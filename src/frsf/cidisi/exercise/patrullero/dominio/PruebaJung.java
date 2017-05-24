package frsf.cidisi.exercise.patrullero.dominio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
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

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public class PruebaJung {
	
	private static HashMap<String, Nodo> nodos;
	private static HashMap<String, Segmento> segmentos;
	private static DirectedGraph<Nodo, Segmento> grafo ;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ejemplo();
		prueba();
				
	}

	public static void ejemplo(){
		Mapa mapa = new Mapa();
		nodos = mapa.getNodos();;
		segmentos =mapa.getSegmentos();
		DirectedGraph<Integer, Integer> grafo = new DirectedSparseGraph<Integer, Integer>();
		grafo.addVertex((Integer) 1);
		grafo.addVertex((Integer) 2);
		grafo.addVertex((Integer) 3);
		grafo.addEdge(12, 1, 2);
		grafo.addEdge(23, 2, 3);
		grafo.addEdge(32, 3, 2);
		
		System.out.println("El grafo = " + grafo.toString());
		
		// De ejemplo
		Transformer<Integer, Point2D> locationTransformer = new Transformer<Integer, Point2D>() {
            @Override
            public Point2D transform(Integer vertex) {
                int value = (vertex.intValue() * 40) + 20;
                return new Point2D.Double((double) value, (double) value);
            }
        };

        // Dado en el ejmplo, reemplazado por el grafo nuestro - BORRAR
		//SimpleGraphView sgv = new SimpleGraphView(); //We create our graph in here
        
		// Layout<V, E> se parametriza con el vertice y arco elegidos (nodo/segmento o cualquier otro)
        // DEL EJEMPLO
		Layout<Integer, Integer> layout = new StaticLayout(grafo, locationTransformer);
		// NUESTRO
		
		layout.setSize(new Dimension(800,1000));
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		BasicVisualizationServer<Integer,Integer> vv =
		new BasicVisualizationServer<Integer,Integer>(layout);
		vv.setPreferredSize(new Dimension(600,600)); //Sets the viewing area size

		JFrame frame = new JFrame("Simple Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void prueba(){
		Mapa mapa = new Mapa();
		nodos = mapa.getNodos();;
		segmentos =mapa.getSegmentos();
		grafo = new DirectedSparseGraph<Nodo, Segmento>();
		transformar();
		
		System.out.println("El grafo = " + grafo.toString());
		
		// De ejemplo - Cambiar la posición del nodo
		Transformer<Nodo, Point2D> locationTransformer = new Transformer<Nodo, Point2D>() {
            @Override
            public Point2D transform(Nodo n) {
            	double posX;
            	double posY;
            	posX = n.getPosX();
            	posY = n.getPosY(); 
            	/*posX = (double)r.nextInt(1290-10) + 10;
            	posY = (double)r.nextInt(890-10) + 10;
            	*/
                return new Point2D.Double(posX, posY);
            }
        };
        
        // Cambiar la forma del nodo
        Transformer<Nodo, Shape> transformerTamaño = new Transformer<Nodo, Shape>() {
            @Override
            public Shape transform(Nodo n) {
            	Ellipse2D circle = new Ellipse2D.Double(-7, -7, 14, 14);
            	
            	//En caso de agrandarlo
            	if(n.getCodigo()=="20") return AffineTransform.getScaleInstance(2, 2).createTransformedShape(circle);
            	
                return circle;
            }
        };
        
		// Layout<V, E> se parametriza con el vertice y arco elegidos (nodo/segmento o cualquier otro)
        // DEL EJEMPLO
		Layout<Nodo, Segmento> layout = new StaticLayout(grafo, locationTransformer);
		// NUESTRO
		
		layout.setSize(new Dimension(1000,1000));
		// The BasicVisualizationServer<V,E> is parameterized by the edge types
		final BasicVisualizationServer<Nodo,Segmento> vv =
		new BasicVisualizationServer<Nodo,Segmento>(layout);
		vv.setPreferredSize(new Dimension(1000,1000)); //Sets the viewing area size
		vv.getRenderContext().setVertexShapeTransformer(transformerTamaño);
		
		
		
		vv.addPreRenderPaintable(new VisualizationViewer.Paintable(){
            public void paint(Graphics g) {
            	BufferedImage img = null;
        		try {
        		    img = ImageIO.read(new File("resources/mapa2.png"));//ImageIO.read(new File("C:\\Users\\marti\\Desktop\\Facu\\mapa2.png"));
        		    
        		} catch (IOException e) {
        		}
            	Graphics g2d = (Graphics2D) g;
            	Dimension d = vv.getSize();
            	g.drawImage(img, 0, 0, d.width, d.height, vv); // TODO Sacar el ancho y alto modificable
            	/*
            	 * Dimension d = vv.getSize();
            	 * g.drawImage(icon.getImage(),0,0,d.width,d.height,vv);
            	 */
                 
            }
			@Override
			public boolean useTransform() {
				return true;
			}
		});

		JFrame frame = new JFrame("Simple Graph View");
		/*frame.setLayout(new BorderLayout());
	    frame.setContentPane(new JLabel(new ImageIcon("C:\\Users\\marti\\Desktop\\Facu\\mapa2.png")));
	    frame.setLayout(new FlowLayout());
	    */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void transformar(){
		for (Nodo value : nodos.values()) {
		    grafo.addVertex(value);
		}
		for (Map.Entry<String, Segmento> entry : segmentos.entrySet()) {
		    String key = entry.getKey();
		    Segmento value = entry.getValue();
		    grafo.addEdge(value, value.getNodoDesde(), value.getNodoHasta());
		}
	}
	
	
}
