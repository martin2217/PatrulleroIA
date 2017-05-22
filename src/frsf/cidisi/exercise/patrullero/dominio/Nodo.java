package frsf.cidisi.exercise.patrullero.dominio;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private List<Segmento> segmentosConectados;
	private List<String> nombres; //Sin usar
	private List<String> calles;
	private boolean habilitado;
	private String codigo;
	private int costo=1;
	

	public Nodo(String unNombre, ArrayList<String> call){
		segmentosConectados= new ArrayList<Segmento>();
		nombres = new ArrayList<String>();
		calles = new ArrayList<String>();
		calles = call;
		codigo=unNombre;
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
	public List<String> getNombres() {
		return nombres;
	}

	public void setNombres(List<String> nombres) {
		this.nombres = nombres;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	
}
