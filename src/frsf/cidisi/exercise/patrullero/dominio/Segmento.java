package frsf.cidisi.exercise.patrullero.dominio;

public class Segmento {
	
	// Usado para la dirección del segmento/patrullero
	public static final int CRECIENDO=1;
	public static final int DECRECIENDO=2;
	
	private Nodo nodoDesde;
	private Nodo nodoHasta;
	private String nombreCalle;
	private int numeroDesde;
	private int numeroHasta;
	private int costo;
	private boolean habilitado;
	private int direccion;
	
	public Segmento(String nombCalle, int numDesde, int numHasta, int direcc){
		nodoDesde=null;
		nodoHasta=null;
		habilitado=true;
		costo=1;
		nombreCalle=nombCalle;
		numeroDesde=numDesde;
		numeroHasta=numHasta;
		direccion=direcc;
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

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
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
}
