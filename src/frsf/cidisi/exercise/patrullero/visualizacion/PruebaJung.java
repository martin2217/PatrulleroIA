package frsf.cidisi.exercise.patrullero.visualizacion;

import java.awt.BorderLayout;
import java.awt.Button;
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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
import frsf.cidisi.exercise.patrullero.dominio.Mapa;
import frsf.cidisi.exercise.patrullero.dominio.Nodo;
import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.exercise.patrullero.dominio.Segmento;
import frsf.cidisi.exercise.patrullero.search.PatrulleroEstado;

public class PruebaJung {
	
	private static HashMap<String, Nodo> nodos;
	private static HashMap<String, Segmento> segmentos;
	private static DirectedGraph<Nodo, Segmento> grafo;
	private static Posicion patrullero;
	private static PatrulleroEstado patrulleroEstado;

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {

		Mapa mapa = new Mapa();
		patrullero=mapa.getSegmentos().get("Salvador del Carril 1500 -> 1400");
		graficar(mapa);
		
	}
	*/
	
	public PruebaJung(Mapa mapa, PatrulleroEstado patrulleroEst){
		//patrullero=patrulleroEst.getPosicionActual();
		patrulleroEstado=patrulleroEst;
		graficar(mapa);
	}
	
	public static void graficar(Mapa mapa){
		
		nodos = mapa.getNodos();
		segmentos = mapa.getSegmentos();
		
		JPanel panelMapa = generarPanelMapa(nodos, segmentos);
		
		JPanel panelControl = generarPanelControl();
		
		
		JFrame frame = new JFrame("Patrullero");
		frame.setLayout(new BorderLayout());
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setSize(new Dimension(1000, 800));
	    //frame.setLayout(new FlowLayout()); ??
		
		// Creación y adición de la barra de scroll - NO USADO
		//final GraphZoomScrollPane zoomScroll = new GraphZoomScrollPane(vv);
		//frame.add(zoomScroll);
		
		
		
		frame.getContentPane().add(panelMapa, BorderLayout.CENTER);
		frame.add(panelControl, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Prueba para verificación gráfica de los modificadores
		//nodos.get("104").setHabilitado(false);
		//panelMapa.repaint();
		
		//Usado para imprimir la posicion de los nodos (en caso de necesitar reposicionarlos)
		//obtenerPosiciones(layout);
		
		// Prueba para verificación del movimiento del patrullero
		//patrullero.setX(patrullero.getX()+20);
		//panelMapa.repaint();
	}
	
	
	private static JPanel generarPanelMapa(HashMap<String, Nodo> nodos, HashMap<String, Segmento> segmentos){
		
		grafo = new DirectedSparseGraph<Nodo, Segmento>();
		cargarGrafo(nodos, segmentos);
		
		//System.out.println("El grafo -> " + grafo.toString());
		
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
		
		layout.setSize(new Dimension(1000, 800));
		//layout.setMinimumSize(new Dimension(600, 500));
		
		// VisualizationViewer<V,E> Parametrizado con los vertices y arcos dados
		final VisualizationViewer<Nodo,Segmento> vv =
		new VisualizationViewer<Nodo,Segmento>(layout);
		vv.setPreferredSize(new Dimension(1000, 800)); //Sets the viewing area size
		
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
		ImageIcon mapIcon = null;
		String mapImageLocation = "resources/mapa2.png";
		try {
			mapIcon = new ImageIcon(mapImageLocation);
		} catch (Exception ex) {
			System.err.println("Can't load \"" + mapImageLocation + "\"");
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
		

		// Cargar posicion del patrullero?
		ImageIcon patrulleroIcon = null;
		String patrulleroImageLocation = "resources/patrullero.png";
		try {
			patrulleroIcon = new ImageIcon(patrulleroImageLocation);
		} catch (Exception ex) {
			System.err.println("Can't load \"" + patrulleroImageLocation + "\"");
		}
		final ImageIcon icon2 = patrulleroIcon;
		VisualizationViewer.Paintable patrulleroImagen = new VisualizationViewer.Paintable(){
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
				
				g.drawImage(icon2.getImage(), new Double(patrulleroEstado.getPosicionActual().getX()).intValue()-icon2.getIconWidth()/2,
						new Double(patrulleroEstado.getPosicionActual().getY()).intValue()-icon2.getIconHeight()/2,
						icon2.getIconWidth(),icon2.getIconHeight(),vv);
				g2d.setTransform(oldXform);
			}
			public boolean useTransform() { return false; }
		};
		vv.addPostRenderPaintable(patrulleroImagen);
		
		vv.setLayout(new BorderLayout());
		//vv.add(BorderLayout.CENTER, scrollPane);
		
		// Create a graph mouse and add it to the visualization component
		/*EditingModalGraphMouse<Nodo, Segmento> gm =
			new EditingModalGraphMouse<Nodo, Segmento>(vv.getRenderContext(),
			 sgv.vertexFactory, grafo.); */
		
		// Usado para cambiar el tamaño inicial del zoom
		ScalingControl scaler = new CrossoverScalingControl();
		scaler.scale(vv, (float)1, vv.getCenter());
		
		// Creación y adición del control de mouse
		final AbstractModalGraphMouse graphMouse = new DefaultModalGraphMouse<Nodo, Segmento>();
		vv.setGraphMouse(graphMouse);

		vv.addKeyListener(graphMouse.getModeKeyListener());
		vv.setToolTipText("<html><center>Presionar 'p' para modo editar<p>Presionar 't' para modo transformar");
		
		// Creación del panel para posicionar el mapa
		JPanel panelMapa = new JPanel();
		panelMapa.setLayout(new BorderLayout());
		panelMapa.add(vv, BorderLayout.CENTER);
		panelMapa.setSize(new Dimension(800, 800));
		panelMapa.setPreferredSize(new Dimension(800, 800));
		panelMapa.setMinimumSize(new Dimension(600, 500));
		
		return panelMapa;
	}
	
	private static JPanel generarPanelControl(){
		
		// Creación del panel con las configuraciones necesarias
		JPanel panelControl= new JPanel();
		panelControl.setLayout(new BoxLayout(panelControl, BoxLayout.PAGE_AXIS));
		panelControl.setSize(new Dimension(200, 700));
		panelControl.setPreferredSize(new Dimension(200, 700));
		panelControl.setMinimumSize(new Dimension(200, 500));
		panelControl.setMaximumSize(new Dimension(200, 1000));
		panelControl.setBounds(20, 20, 10, 10);
		panelControl.setBounds(61, 50, 81, 140);
		//panelControl.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3), "Controles"));
		panelControl.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(
				new EmptyBorder(10, 5, 10, 5), new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3), "Controles")),
				new EmptyBorder(20, 10, 10, 10)));
		

		// Creación de los botones
		
		JButton btnIniciar= new JButton("Iniciar");
		
		JButton btnVolver= new JButton("Volver");
		
		JButton btnPausar= new JButton("Pausar");
		
		JButton btnDeshabilitar= new JButton("Deshabilitar");
		
		JButton btnHabilitar= new JButton("Habilitar");
		
		JButton btnDemorar= new JButton("Demorar");
		
		JButton btnNormalizar= new JButton("Normalizar");
		
		// Botón 
	    panelControl.add(btnIniciar);
		panelControl.add(Box.createRigidArea(new Dimension(10,20)));
		panelControl.add(btnVolver);
		panelControl.add(Box.createRigidArea(new Dimension(10,20)));
		panelControl.add(btnPausar);
		panelControl.add(Box.createRigidArea(new Dimension(10,20)));
		panelControl.add(btnDeshabilitar);
		panelControl.add(Box.createRigidArea(new Dimension(10,20)));
		panelControl.add(btnHabilitar);
		panelControl.add(Box.createRigidArea(new Dimension(10,20)));
		panelControl.add(btnDemorar);
		panelControl.add(Box.createRigidArea(new Dimension(10,20)));
		panelControl.add(btnNormalizar);
		panelControl.add(Box.createRigidArea(new Dimension(5,20)));
		
		
		return panelControl;
	}
	/*
	 * Carga en la estructura de grafo JUNG, el grafo generado en el mapa
	 */
	private static void cargarGrafo(HashMap<String, Nodo> nodos, HashMap<String, Segmento> segmentos){
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
