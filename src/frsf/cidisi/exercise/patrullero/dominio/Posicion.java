package frsf.cidisi.exercise.patrullero.dominio;

public abstract class Posicion {
	protected int costo;
	protected boolean habilitado;
	
	
	public Posicion(){
		habilitado = true;
		
	}
	
	public abstract int getCosto();
	
	
}
