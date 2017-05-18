package frsf.cidisi.exercise.patrullero.dominio;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private List<Segmento> segmentosConectados;
	private boolean habilitado;
	/*private String calle1;
	private String calle2;*/
	private int costo=1;
	

	public Nodo(/*String c1, String c2*/){
		segmentosConectados= new ArrayList<Segmento>();
		habilitado=true;
	}

	public List<Segmento> getSegmentosConectados() {
		return segmentosConectados;
	}

	public void setSegmentosConectados(List<Segmento> segmentosConectados) {
		this.segmentosConectados = segmentosConectados;
	}
	
	public void addSegmento(Segmento seg){
		segmentosConectados.add(seg);
	}
}
