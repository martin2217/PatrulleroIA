package frsf.cidisi.exercise.patrullero.dominio;

public abstract class Posicion {
	protected int costo;
	protected boolean habilitado;
	protected int demorado; // Multiplicador de costo
	
	
	public Posicion(){
		habilitado = true;
	}
	
	public abstract int getCosto();
	public abstract boolean isHabilitado();
	public abstract void setHabilitado(boolean habilitado);
	public abstract int getDemorado();
	public abstract void setDemorado(int demora);
	
	
}
