package frsf.cidisi.exercise.patrullero.dominio;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;

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
		
		layout.setSize(new Dimension(800,800));
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
		
		// De ejemplo
		Transformer<Nodo, Point2D> locationTransformer = new Transformer<Nodo, Point2D>() {
            @Override
            public Point2D transform(Nodo n) {
            	Random r = new Random();
            	int posX;
            	int posY;
            	//posX = n.getPosX();
            	//posY = n.getPosY(); 
            	posX = r.nextInt(1290-10) + 10;
            	posY = r.nextInt(890-10) + 10;
                return new Point2D.Double((double) posX, (double) posY);
            }
        };

        // Dado en el ejmplo, reemplazado por el grafo nuestro - BORRAR
		//SimpleGraphView sgv = new SimpleGraphView(); //We create our graph in here
        
		// Layout<V, E> se parametriza con el vertice y arco elegidos (nodo/segmento o cualquier otro)
        // DEL EJEMPLO
		Layout<Integer, Integer> layout = new StaticLayout(grafo, locationTransformer);
		// NUESTRO
		
		layout.setSize(new Dimension(800,800));
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
