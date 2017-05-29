package frsf.cidisi.exercise.patrullero.search;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import java.util.ArrayList;
import java.util.List;

import sun.nio.cs.ext.MacArabic;

import frsf.cidisi.exercise.patrullero.dominio.Mapa;
import frsf.cidisi.exercise.patrullero.dominio.Posicion;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class AmbienteEstado extends EnvironmentState {
	
	//TODO: Setup Variables
    private List<Posicion> listaMarcha;                //Corte Total
    private List<Posicion> listaEventoSocial;           //Corte Total
    private List<Posicion> listaAccidenteTransito;     //Corte Parcial
    private List<Posicion> listaCongestionTransito;     //Corte Parcial
    private List<Posicion> listaPlanBacheo;             //Corte Parcial
    private Posicion posicionPatrullero;
    private Posicion posicionIncidente;
    private Mapa mapa;
    private String posPatrullero;
    private String posIncidente;
    
    public final static double DISTANCIA_VISION=300;
	
    
    public AmbienteEstado(String posP, String posI) {
    	posPatrullero= posP;
    	posIncidente= posI;
    	listaMarcha = new ArrayList<Posicion>();
    	listaAccidenteTransito= new ArrayList<Posicion>();
        listaCongestionTransito= new ArrayList<Posicion>();
        listaEventoSocial= new ArrayList<Posicion>();
        listaPlanBacheo= new ArrayList<Posicion>();
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

    	mapa = new Mapa();
    	posicionPatrullero = mapa.getPosicion(posPatrullero);
    	posicionIncidente = mapa.getPosicion(posIncidente);
    	
    	// TODO: Inicializar y cargar listas de percepciones al mapa
    	percepcionesIniciales();
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        str+="Ambiente: Patrullero en "+posicionPatrullero.toString()+", incidente en "+posicionIncidente.toString()+".";

        return str;
    }
    
	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    private void percepcionesIniciales(){
		addAccidenteTransito(mapa.getNodos().get("15"));
		addAccidenteTransito(mapa.getNodos().get("19"));
		addAccidenteTransito(mapa.getNodos().get("7"));
		addAccidenteTransito(mapa.getNodos().get("33"));
		addAccidenteTransito(mapa.getNodos().get("33"));
		
		addCongestionTransito(mapa.getNodos().get("40"));
		addCongestionTransito(mapa.getNodos().get("22"));
		addCongestionTransito(mapa.getNodos().get("70"));
		addCongestionTransito(mapa.getNodos().get("78"));
		
		addEventoSocial(mapa.getNodos().get("45"));
		addEventoSocial(mapa.getNodos().get("66"));
		addEventoSocial(mapa.getNodos().get("81"));
		addEventoSocial(mapa.getNodos().get("87"));
		
		addPlanBacheo(mapa.getNodos().get("50"));		
		addPlanBacheo(mapa.getNodos().get("90"));		
		addPlanBacheo(mapa.getNodos().get("107"));		
		addPlanBacheo(mapa.getNodos().get("111"));
		addPlanBacheo(mapa.getSegmentos().get("Salvador del Carril 1500 -> 1400"));	
		addPlanBacheo(mapa.getNodos().get("119"));	
		addPlanBacheo(mapa.getNodos().get("139"));
		
		addMarcha(mapa.getNodos().get("55"));
		addMarcha(mapa.getNodos().get("13"));
		addMarcha(mapa.getNodos().get("102"));
		addMarcha(mapa.getNodos().get("133"));
		addMarcha(mapa.getNodos().get("122"));
		addMarcha(mapa.getNodos().get("146"));
		addMarcha(mapa.getNodos().get("150"));
		
	}
    
    public double distanciaEntre(Posicion p1, Posicion p2){
    	double retorno;
    	double xx, yy;
    	xx= p1.getX()-p2.getX();
    	yy= p1.getY()-p2.getY();
    	retorno= Math.sqrt(xx*xx+yy*yy);
    	return retorno;
    }
    
    private List<Posicion> obtenerPercepcionesCercanas(List<Posicion> listaEventos){
    	List<Posicion> aux = new ArrayList<Posicion>();
    	for(Posicion pos : listaEventos){
    		if(distanciaEntre(pos, posicionPatrullero) < DISTANCIA_VISION){
    			aux.add(pos);
    		}
    	}
    	return aux;
    }
    
    
    public Posicion getPosicionPatrullero(){
    	return posicionPatrullero;
    }
    
    public void setPosicionPatrullero(Posicion nuevaPosicion){
    	posicionPatrullero = nuevaPosicion;
    }
    
    public List<Posicion> getListaMarcha(){
    	return listaMarcha;
    }
    public List<Posicion> getListaMarchaPatrullero(){
    	return obtenerPercepcionesCercanas(listaMarcha);
    }
    
    public List<Posicion> getListaAccidenteTransito(){
    	return listaAccidenteTransito;
    }
    public List<Posicion> getListaAccidenteTransitoPatrullero(){
    	return obtenerPercepcionesCercanas(listaAccidenteTransito);
    }
    
    public List<Posicion> getListaCongestionTransito(){
    	return listaCongestionTransito;
    }
    public List<Posicion> getListaCongestionTransitoPatrullero(){
    	return obtenerPercepcionesCercanas(listaCongestionTransito);
    }
    
    public List<Posicion> getListaEventoSocial(){
    	return listaEventoSocial;
    }
    public List<Posicion> getListaEventoSocialPatrullero(){
    	return obtenerPercepcionesCercanas(listaEventoSocial);
    }
    
    public List<Posicion> getListaPlanBacheo(){
    	return listaPlanBacheo;
    }
    public List<Posicion> getListaPlanBacheoPatrullero(){
    	return obtenerPercepcionesCercanas(listaPlanBacheo);
    }
    
    
    // Corte Total
    public void addMarcha(Posicion unaPosicion){
    	if(!listaMarcha.contains(unaPosicion)){
			listaMarcha.add(unaPosicion);
			unaPosicion.setHabilitado(false);
    	}
    }
    public void addMarcha(String unaPosicion){
    	addMarcha(mapa.getPosicion(unaPosicion));
    }
    
	// Corte Parcial
	public void addAccidenteTransito(Posicion unaPosicion){
    	if(!listaAccidenteTransito.contains(unaPosicion)){
    		listaAccidenteTransito.add(unaPosicion);
    		unaPosicion.setDemorado(3);
    	}
    }
    public void addAccidenteTransito(String unaPosicion){
    	addAccidenteTransito(mapa.getPosicion(unaPosicion));
    }
    
    // Corte Parcial
    public void addCongestionTransito(Posicion unaPosicion){
    	if(!listaCongestionTransito.contains(unaPosicion)){
        	listaCongestionTransito.add(unaPosicion);
        	unaPosicion.setDemorado(3);
    	}
    }
    public void addCongestionTransito(String unaPosicion){
    	addCongestionTransito(mapa.getPosicion(unaPosicion));
    }
    
    // Corte Total
    public void addEventoSocial(Posicion unaPosicion){
    	if(!listaEventoSocial.contains(unaPosicion)){
        	listaEventoSocial.add(unaPosicion);
        	unaPosicion.setHabilitado(false);
    	}
    }
    public void addEventoSocial(String unaPosicion){
    	addEventoSocial(mapa.getPosicion(unaPosicion));
    }
    
    // Corte Parcial
    public void addPlanBacheo(Posicion unaPosicion){
    	if(!listaPlanBacheo.contains(unaPosicion)){
        	listaPlanBacheo.add(unaPosicion);
        	unaPosicion.setDemorado(3);
    	}
    }
    public void addPlanBacheo(String unaPosicion){
    	addPlanBacheo(mapa.getPosicion(unaPosicion));
    }
    
    
    // Habilitar un nodo genérico
    public void habilitar(String unaPosicion){
    	habilitar(mapa.getPosicion(unaPosicion));
    }
    public void habilitar(Posicion unaPosicion){
    	if(listaEventoSocial.contains(unaPosicion)){
    		eliminarEventoSocial(unaPosicion);
    	}
    	if(listaMarcha.contains(unaPosicion)){
    		eliminarMarcha(unaPosicion);
    	}
    }
    
    // Normalizar las demoras de un nodo
    public void normalizar(String unaPosicion){
    	normalizar(mapa.getPosicion(unaPosicion));
    }
    public void normalizar(Posicion unaPosicion){
    	if(listaCongestionTransito.contains(unaPosicion)){
    		eliminarCongestionTransito(unaPosicion);
    	}
    	if(listaPlanBacheo.contains(unaPosicion)){
    		eliminarPlanBacheo(unaPosicion);
    	}
    	if (listaAccidenteTransito.contains(unaPosicion)){
    		eliminarAccidenteTransito(unaPosicion);
    	}
    }
    
    // Corte Total
    public void eliminarMarcha(Posicion unaPosicion){
    	listaMarcha.remove(unaPosicion);
    	unaPosicion.setHabilitado(true);
    }
    
    // Corte Parcial
    public void eliminarAccidenteTransito(Posicion unaPosicion){
    	listaAccidenteTransito.remove(unaPosicion);
    	unaPosicion.setDemorado(1);
    }
    
    // Corte Parcial
    public void eliminarCongestionTransito(Posicion unaPosicion){
    	listaCongestionTransito.remove(unaPosicion);
    	unaPosicion.setDemorado(1);
    }
    
    // Corte Total
    public void eliminarEventoSocial(Posicion unaPosicion){
    	listaEventoSocial.remove(unaPosicion);
    	unaPosicion.setHabilitado(true);
    }
    
    // Corte Parcial
    public void eliminarPlanBacheo(Posicion unaPosicion){
    	listaPlanBacheo.remove(unaPosicion);
    	unaPosicion.setDemorado(1);
    }
    
    
	public Posicion getPosicionIncidente() {
		return posicionIncidente;
	}
	public void setPosicionIncidente(Posicion posicionIncidente) {
		this.posicionIncidente = posicionIncidente;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
    
	

}

