package frsf.cidisi.exercise.patrullero.dominio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.AbsoluteCrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.AbstractModalGraphMouse;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;

public class PruebaJung {
	
	private static HashMap<String, Nodo> nodos;
	private static HashMap<String, Segmento> segmentos;
	private static DirectedGraph<Nodo, Segmento> grafo ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		prueba();
	}
	
	public static void prueba(){
		Mapa mapa = new Mapa();
		nodos = mapa.getNodos();;
		segmentos = mapa.getSegmentos();
		grafo = new DirectedSparseGraph<Nodo, Segmento>();
		cargarGrafo();
		
		System.out.println("El grafo -> " + grafo.toString());
		
		// Transformer que toma la posición de los nodos y los setea
		Transformer<Nodo, Point2D> locationTransformer = new Transformer<Nodo, Point2D>() {
            @Override
            public Point2D transform(Nodo n) {
            	double posX;
            	double posY;
            	posX = n.getPosX();
            	posY = n.getPosY();
                return new Point2D.Double(posX, posY);
            }
        };
        
		
		AbstractLayout<Nodo, Segmento> layout = new StaticLayout<Nodo, Segmento>(grafo, locationTransformer);
		layout.setSize(new Dimension(1000,1000));
		
		// VisualizationViewer<V,E> Parametrizado con los vertices y arcos dados
		final VisualizationViewer<Nodo,Segmento> vv =
		new VisualizationViewer<Nodo,Segmento>(layout);
		vv.setPreferredSize(new Dimension(1000,1000)); //Sets the viewing area size
		
		// Seteando el transformer de forma de nodo
		vv.getRenderContext().setVertexShapeTransformer(new Transformer<Nodo, Shape>() {
            @Override
            public Shape transform(Nodo n) {
            	Ellipse2D circle = new Ellipse2D.Double(-11, -11, 22, 22);
            	//En caso de agrandarlo - No funciona
            	//if(n.getCodigo()=="20") return AffineTransform.getScaleInstance(6, 6).createTransformedShape(circle);
                return circle;
            }
        });
		
		// Seteando el transformer de color de nodo
		vv.getRenderContext().setVertexFillPaintTransformer(new Transformer<Nodo, Paint>() {
            @Override
            public Paint transform(Nodo n) {
            	if (!n.isHabilitado()){
                    return Color.RED;
                }
                else if (n.getDemorado()!=1){
                	return Color.ORANGE;
                }
                else
                	return Color.GREEN;
            }
        });
		
		
		// Seteando el transformer de color de segmento
        vv.getRenderContext().setEdgeDrawPaintTransformer(new Transformer<Segmento, Paint>(){
            @Override
            public Paint transform(Segmento s){
            	if (!s.isHabilitado()){
                    return Color.RED;
                }
                else if (s.getDemorado()!=1){
                	return Color.ORANGE;
                }
                else
                	return Color.BLACK;
            }
        });
        
        // Color de punta de la flecha
        vv.getRenderContext().setArrowFillPaintTransformer(new Transformer<Segmento,Paint>() {
        	@Override
        	public Paint transform(Segmento s) {
                if (!s.isHabilitado()){
                    return Color.RED;
                }
                else if (s.getDemorado()!=1){
                	return Color.ORANGE;
                }
                else
                	return Color.BLACK;
            }
        });
        vv.getRenderContext().setArrowDrawPaintTransformer(new Transformer<Segmento,Paint>() {
        	@Override
        	public Paint transform(Segmento s) {
                if (!s.isHabilitado()){
                    return Color.RED;
                }
                else if (s.getDemorado()!=1){
                	return Color.ORANGE;
                }
                else
                	return Color.BLACK;
            }
        });
        
        // Seteando el transformer de forma de segmento
        vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line<Nodo, Segmento>());

		// Etiqueta de los nodos
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Nodo>());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		
		
		// Seteando la imagen de fondo
		
		/* BORRAR
		vv.addPreRenderPaintable(new VisualizationViewer.Paintable(){
            public void paint(Graphics g) {
            	BufferedImage img = null;
        		try {
        		    img = ImageIO.read(new File("resources/mapa2.png"));//ImageIO.read(new File("C:\\Users\\marti\\Desktop\\Facu\\mapa2.png"));
        		    
        		} catch (IOException e) {
        		}
            	Graphics g2d = (Graphics2D) g;
            	Dimension d = vv.getSize();
            	g.drawImage(img, 0, 0, vv);
            	
            }
			@Override
			public boolean useTransform() {
				return true;
			}
		});*/
		
		ImageIcon mapIcon = null;
		String imageLocation = "resources/mapa2.png";
		try {
			mapIcon = new ImageIcon(imageLocation);
		} catch (Exception ex) {
			System.err.println("Can't load \"" + imageLocation + "\"");
		}
		final ImageIcon icon = mapIcon;

		if(icon != null) {
			vv.addPreRenderPaintable(new VisualizationViewer.Paintable(){
				public void paint(Graphics g) {
					Graphics2D g2d = (Graphics2D)g;
					AffineTransform oldXform = g2d.getTransform();
					AffineTransform lat = 
						vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).getTransform();
					AffineTransform vat = 
						vv.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.VIEW).getTransform();
					AffineTransform at = new AffineTransform();
					at.concatenate(g2d.getTransform());
					at.concatenate(vat);
					at.concatenate(lat);
					g2d.setTransform(at);
					g.drawImage(icon.getImage(), 0, 0,
							icon.getIconWidth(),icon.getIconHeight(),vv);
					g2d.setTransform(oldXform);
				}
				public boolean useTransform() { return false; }
			});
		}


		vv.setLayout(new BorderLayout());
		//vv.add(BorderLayout.CENTER, scrollPane);
		
		// Create a graph mouse and add it to the visualization component
		
		/*EditingModalGraphMouse<Nodo, Segmento> gm =
			new EditingModalGraphMouse<Nodo, Segmento>(vv.getRenderContext(),
			 sgv.vertexFactory, grafo.); */
		
		// Usado para cambiar el tamaño inicial del zoom
		ScalingControl scaler = new CrossoverScalingControl();
		scaler.scale(vv, (float)1, vv.getCenter());
		

		
		
		JFrame frame = new JFrame("Vista del grafo");
		/*frame.setLayout(new BorderLayout());
	    frame.setLayout(new FlowLayout());
	    */
		
		
		// Creación y adición del control de mouse
		final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
		frame.add(panel);
		final AbstractModalGraphMouse graphMouse = new DefaultModalGraphMouse<Nodo, Segmento>();
		vv.setGraphMouse(graphMouse);

		vv.addKeyListener(graphMouse.getModeKeyListener());
		vv.setToolTipText("<html><center>Presionar 'p' para modo editar<p>Presionar 't' para modo transformar");

		//final ScalingControl scaler2 = new CrossoverScalingControl();
		
		// create the graph mouse
		//GraphZoomScrollPane scrollPane = new GraphZoomScrollPane(vv);
		//vv.set(scrollPane);
		
		//scaler = new AbsoluteCrossoverScalingControl();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);
		
		
		//Usado para imprimir la posicion de los nodos
		//obtenerPosiciones(layout);
	}
	
	/*
	 * Carga en la estructura de grafo JUNG, el grafo generado en el mapa
	 */
	private static void cargarGrafo(){
		for (Nodo value : nodos.values()) {
		    grafo.addVertex(value);
		}
		for (Map.Entry<String, Segmento> entry : segmentos.entrySet()) {
		    String key = entry.getKey();
		    Segmento value = entry.getValue();
		    grafo.addEdge(value, value.getNodoDesde(), value.getNodoHasta());
		}
	}
	
	/* 
	 * Hacer que java te dé el código jajajajaja.. Nunca visto
	 */
	private static void obtenerPosiciones(AbstractLayout<Nodo, Segmento> layout){
		for(int i=0; i<grafo.getVertexCount(); i++){
			double x= layout.getX(nodos.get(String.valueOf(i+1)));
			double y= layout.getY(nodos.get(String.valueOf(i+1)));
			System.out.println("posicionar(pos, "+x+", "+y+");");
		}
	}
	
	
}
