package frsf.cidisi.exercise.patrullero.dominio;

import java.util.HashMap;

public class Mapa {

	private HashMap<String, Nodo> nodos;
	private HashMap<String, Segmento> segmentos;
	
	public Mapa(){
		nodos= new HashMap<String, Nodo>();
		segmentos= new HashMap<String, Segmento>();
		cargarMapa();
	}
	
	public HashMap<String, Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(HashMap<String, Nodo> nodos) {
		this.nodos = nodos;
	}

	public HashMap<String, Segmento> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(HashMap<String, Segmento> segmentos) {
		this.segmentos = segmentos;
	}
	
	private void cargarMapa(){
		Nodo n1;
		Nodo n2;
		Segmento s;
		
		n1=new Nodo();
		n2=new Nodo();
		s=new Segmento("Salvador del Carril", 101, 199, 1);
		segmentos.put("Salvador del Carril 100", s);
		n1.addSegmento(s); n2.addSegmento(s);
		nodos.put("Salvador del Carril y callecita 1", n1);
		nodos.put("Callecita 2 y Salvador del carril", n2);
	}
}
