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
}
