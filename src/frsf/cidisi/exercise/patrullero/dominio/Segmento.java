package frsf.cidisi.exercise.patrullero.dominio;

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
	
	public Segmento(String nombCalle, int numDesde, int numHasta, int direcc){
		super();
		nodoDesde=null;
		nodoHasta=null;
		costo=1; // TODO Usar los numeros desde-hasta para dar costo (1 metro = 1 punto de costo)
		nombreCalle=nombCalle;
		numeroDesde=numDesde;
		numeroHasta=numHasta;
		direccion=direcc;
		demorado=1;
	}
	
	public String getHash(){
		String s=nombreCalle+" ";
		if(direccion==CRECIENDO){
			s+=numeroDesde+" -> "+numeroHasta;
		}
		else s+=numeroHasta+" -> "+numeroDesde;
		return s;
	}
	
	public String toString(){
		return nombreCalle+" al "+numeroDesde;
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

	@Override
	public int getCosto() {
		return costo*demorado;
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

	public int getDemorado() {
		return demorado;
	}

	public void setDemorado(int demorado) {
		this.demorado = demorado;
	}
	
}
