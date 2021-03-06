package frsf.cidisi.exercise.patrullero.dominio;

import java.util.ArrayList;
import java.util.List;

public class Nodo extends Posicion{
	
	private List<Segmento> segmentosConectados;
	private List<String> nombres; //Sin usar
	private List<String> calles;
	private String codigo;
	private int costo=5; // Costo de nodo = 10
	

	public Nodo(String unNombre, ArrayList<String> call){
		super();
		segmentosConectados= new ArrayList<Segmento>();
		nombres = new ArrayList<String>();
		calles = new ArrayList<String>();
		calles = call;
		codigo=unNombre;
		posX=0;
		posY=0;
		demorado=1;
	}
	public Nodo(String unNombre, ArrayList<String> call, double x, double y){
		super();
		segmentosConectados= new ArrayList<Segmento>();
		nombres = new ArrayList<String>();
		calles = new ArrayList<String>();
		calles = call;
		codigo=unNombre;
		habilitado=true;
		posX=x;
		posY=y;
		demorado=1;
	}
	
	public String toString(){
		String retorno=new String();
		/*
		retorno+="Esquina "+calles.get(0);
		if(calles.size()>1) retorno+=" y "+calles.get(1);
		*/
		retorno=codigo;
		return retorno;
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
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	@Override
	public int getDemorado() {
		return demorado;
	}
	@Override
	public void setDemorado(int demora) {
		demorado=demora;
	}
	@Override
	public List<Posicion> getSucesores() {
		ArrayList<Posicion> retorno= new ArrayList<Posicion>();
		retorno.addAll(segmentosConectados);
		return retorno;
	}
	@Override
	public boolean equals(Posicion p) {
		return p.toString().equals(this.toString());
	}
	@Override
	public Posicion clone() {
		return null;
	}
	@Override
	public String getHash() {
		return codigo;
	}
	@Override
	public double getX(){
		return posX;
	}
	@Override
	public double getY(){
		return posY;
	}
	@Override
	public void setX(double x) {
		posX=x;
	}
	@Override
	public void setY(double y) {
		posY=y;
	}
	
}
