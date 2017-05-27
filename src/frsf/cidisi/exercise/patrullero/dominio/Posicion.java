package frsf.cidisi.exercise.patrullero.dominio;

import java.util.List;

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
	public abstract String toString();
	public abstract List<Posicion> getSucesores();
	public abstract boolean equals(Posicion p);
	public abstract Posicion clone();
	public abstract String getHash();
	public abstract double getX();
	public abstract double getY();
	
}
