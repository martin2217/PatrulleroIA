package frsf.cidisi.exercise.patrullero.dominio;

import java.util.ArrayList;
import java.util.List;

public class Segmento extends Posicion {
	
	// Usado para la dirección del segmento/patrullero
	public static final int CRECIENDO=1;
	public static final int DECRECIENDO=2;
	
	private Nodo nodoDesde;
	private Nodo nodoHasta;
	private String nombreCalle;
	private int numeroDesde;
	private int numeroHasta;	
	private int direccion;
	private String nombre;
	
	public Segmento(String nombCalle, int numDesde, int numHasta, int direcc){
		super();
		nodoDesde=null;
		nodoHasta=null;
		costo=numHasta-numDesde; //(1 metro = 1 punto de costo)
		if(costo<10){ // Costo mínimo de 10
			costo=10; 
		}
		nombreCalle=nombCalle;
		numeroDesde=numDesde;
		numeroHasta=numHasta;
		direccion=direcc;
		demorado=1;
		
		// Seteo del nombre
		String s=nombreCalle+" ";
		if(direccion==CRECIENDO){
			s+=numeroDesde+" -> "+numeroHasta;
		}
		else s+=numeroHasta+" -> "+numeroDesde;
		//System.out.println("Segmento: "+s);
		nombre=s;
		
		posX=-100;
		posY=-100;
		
	}
	@Override
	public String getHash(){
		if(nombre!=null){
			String s=nombreCalle+" ";
			if(direccion==CRECIENDO){
				s+=numeroDesde+" -> "+numeroHasta;
			}
			else s+=numeroHasta+" -> "+numeroDesde;
			//System.out.println("Segmento: "+s);
			nombre=s;
			return s;
		}
		return nombre;
	}
	
	public String toString(){
		return getHash();
		//return nombreCalle+" al "+numeroDesde;
	}

	public Nodo getNodoDesde() {
		return nodoDesde;
	}

	public void setNodoDesde(Nodo nodoDesde) {
		this.nodoDesde = nodoDesde;
	}

	public Nodo getNodoHasta() {
		return nodoHasta;
	}

	public void setNodoHasta(Nodo nodoHasta) {
		this.nodoHasta = nodoHasta;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	public int getNumeroDesde() {
		return numeroDesde;
	}

	public void setNumeroDesde(int numeroDesde) {
		this.numeroDesde = numeroDesde;
	}

	public int getNumeroHasta() {
		return numeroHasta;
	}

	public void setNumeroHasta(int numeroHasta) {
		this.numeroHasta = numeroHasta;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getDemorado() {
		return demorado;
	}

	public void setDemorado(int demorado) {
		this.demorado = demorado;
	}

	@Override
	public List<Posicion> getSucesores() {
		ArrayList<Posicion> retorno= new ArrayList<Posicion>();
		retorno.add(nodoHasta);
		return retorno;
	}

	@Override
	public boolean equals(Posicion p) {
		return p.toString().equals(this.toString());
	}

	@Override
	public Posicion clone() {
		Nodo nodoDesde2;
		Nodo nodoHasta2;
		Segmento retorno = new Segmento(nombreCalle, numeroDesde, numeroHasta, direccion);
		retorno.setNodoDesde(nodoDesde); 
		retorno.setNodoHasta(nodoHasta);
		return null;
	}
	
	@Override
	public double getX(){
		// seteo de la posición
		if(posX==-100){
			posX=(nodoDesde.getX()+nodoHasta.getX())/2.0;
		}
		return posX;
	}
	@Override
	public double getY(){
		if(posY==-100){
			posY=(nodoDesde.getY()+nodoHasta.getY())/2.0;
		}
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
