package frsf.cidisi.exercise.patrullero.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;

import frsf.cidisi.exercise.patrullero.dominio.Mapa;
import frsf.cidisi.exercise.patrullero.dominio.Nodo;
import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.exercise.patrullero.dominio.Segmento;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class PatrulleroEstado extends SearchBasedAgentState {
	
	public final String SEGMENTO_CLASE="frsf.cidisi.exercise.patrullero.dominio.Segmento";
	public final String NODO_CLASE="frsf.cidisi.exercise.patrullero.dominio.Nodo";
	
	//TODO: Setup Variables
    private Posicion posicionActual;
    private Posicion posicionIncidente;
    private Mapa mapa;
    private Segmento ultimoSegmento; // No usado
    // listaMarchas - 				Corte Total
    // listaEventoSocial - 			Corte Total
    // listaAccidentesTransito -	Corte Parcial
    // listaCongestionTransito -	Corte Parcial
    // listaPlanBacheo -			Corte Parcial
    private List<Posicion> listaCortesParciales;
    private List<Posicion> listaCortesTotales;
	private List<Posicion> listaNodosVisitados;
	private String posPatrullero;
	private String posIncidente;

	public AtomicBoolean pausado;
	public JFrame jFrame;
	
    public PatrulleroEstado(String posP, String posI) {
       	
    	//TODO: Complete Method
    	posPatrullero=posP;
    	posIncidente=posI;
    	listaCortesParciales= new ArrayList<Posicion>();
    	listaCortesTotales= new ArrayList<Posicion>();
    	listaNodosVisitados= new ArrayList<Posicion>();
    	
		this.initState();
	}
    public PatrulleroEstado() {
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
		PatrulleroEstado nuevo = new PatrulleroEstado();
		Mapa map = mapa;
		nuevo.setMapa(mapa);
		nuevo.setListaCortesParciales(new ArrayList<Posicion>(getListaCortesParciales()));
		nuevo.setListaCortesTotales(new ArrayList<Posicion>(getListaCortesTotales()));
		nuevo.setPausado(pausado);
		nuevo.setJFrame(jFrame);
		
		// Se cargan todas las posiciones visitados al nuevo estado
		ArrayList<Posicion> nodosVisitados2 = new ArrayList<Posicion>(listaNodosVisitados); // Clonado de la lista
		nuevo.setListaNodosVisitados(nodosVisitados2);
		
		// Se carga la posicion actual
		if(posicionActual.getClass().equals(Segmento.class)){
			nuevo.setPosicionActual(map.getSegmentos().get(posicionActual.getHash()));
		}
		else /*if(posicionActual.getClass().equals(Nodo.class))*/{
			nuevo.setPosicionActual(map.getNodos().get(posicionActual.getHash())); //TODO revisar si está bien que entre tantas veces
		}
		
		// se carga la posicioin del incidente
		if(posicionIncidente.getClass().equals(Segmento.class)){
			nuevo.setPosicionIncidente(map.getSegmentos().get(posicionIncidente.getHash()));
		}
		else /*if(posicionActual.getClass().getName().equals("Nodo"))*/{
			nuevo.setPosicionIncidente(map.getNodos().get(posicionIncidente.getHash()));
		}
		
		//Se carga el ultimo segmento - No usado
		/*if (ultimoSegmento!= null){
			nuevo.setUltimoSegmento(map.getSegmentos().get(ultimoSegmento.getHash()));
		}
		*/
        return nuevo;
    }

	/**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    	// Primero limpiar todos los segmentos y nodos (habilitado=true, demorado=1)
    	// O no, y hacer que el agente explore, descubriendo y guardando el historial
    	
    	PatrulleroAgentePerception percepcion = (PatrulleroAgentePerception)p;

    	cargarCortesTotales(percepcion.getListaMarcha());
    	cargarCortesTotales(percepcion.getListaEventoSocial());
    	cargarCortesParciales(percepcion.getListaAccidenteTransito());
    	cargarCortesParciales(percepcion.getListaCongestionTransito());
    	cargarCortesParciales(percepcion.getListaPlanBacheo());
    	
    	jFrame.repaint();
    	
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method
    	mapa= new Mapa();
    	posicionActual = mapa.getPosicion(posPatrullero);
    	posicionIncidente = mapa.getPosicion(posIncidente);
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";
        str+="Patrullero en "+posicionActual.toString()+", incidente en "+posicionIncidente.toString()+".";
        return str;
    }
	
	/**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
    	// TODO: revisar si se debe incluir las posiciones visitadas
    	PatrulleroEstado otroPatrullero=(PatrulleroEstado) obj;
    	if(otroPatrullero.getPosicionActual().toString().equals(posicionActual.toString())){
    		return true;
    	}
    	else return false;
    }
    
    
	
    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    public void setPausado(AtomicBoolean pausad){
    	pausado=pausad;
    }
    public AtomicBoolean getPausado(){
    	return pausado;
    }
    
    
    private void cargarCortesTotales(List<Posicion> cortesT){
    	for(Posicion corte : cortesT){
    		if(!listaCortesTotales.contains(corte)){
    			listaCortesTotales.add(corte);
    			mapa.cortarTotalmente(corte);
    		}
    	}
    }
    
    private void cargarCortesParciales(List<Posicion> cortesP){
    	for(Posicion corte : cortesP){
    		if(!listaCortesParciales.contains(corte)){
    			listaCortesParciales.add(corte);
    			mapa.cortarParcialmente(corte);
    		}
    	}
    }
    
	
    public Posicion getPosicionIncidente(){
    	return posicionIncidente;
    }

    public Posicion getPosicionActual(){
    	return posicionActual;
    }
    
    public void setPosicionActual(Posicion nuevaPosicion){
    	posicionActual = nuevaPosicion;
    }
    
    public List<Posicion> getPosicionesVisitadas(){
    	return listaNodosVisitados;
    }
    
    public List<Posicion> getSucesores(){
    	return posicionActual.getSucesores();
    }
    public List<String> getSucesoresString(){
    	ArrayList<String> retorno = new ArrayList<String>();
		for(Posicion p : posicionActual.getSucesores()){
			retorno.add(p.toString());
		}
		return retorno;
    }
    
    public void addPosicionVisitada(Posicion unaPosicion){
    	listaNodosVisitados.add(unaPosicion);
    }
    
    public void addListaCortesParciales(Posicion unaPosicion){
    	listaCortesParciales.add(unaPosicion);
    }
    
    public void addListaCortesTotales(Posicion unaPosicion){
    	listaCortesTotales.add(unaPosicion);
    }
    
    public Mapa getMapa(){
    	return mapa;
    }

    private void setMapa(Mapa map) {
		mapa=map;
	}
    public Segmento getUltimoSegmento() {
		return ultimoSegmento;
	}
    public String getUltimoSegmentoString() {
		return ultimoSegmento.toString();
	}
	public void setUltimoSegmento(Segmento ultimoSegmento) {
		this.ultimoSegmento = ultimoSegmento;
	}
	public List<Posicion> getListaCortesParciales() {
		return listaCortesParciales;
	}
	public List<String> getListaCortesParcialesString(){
		ArrayList<String> retorno = new ArrayList<String>();
		for(Posicion p : listaCortesParciales){
			retorno.add(p.toString());
		}
		return retorno;
	}
	public void setListaCortesParciales(List<Posicion> listaCortesParciales) {
		this.listaCortesParciales = listaCortesParciales;
	}
	public List<Posicion> getListaCortesTotales() {
		return listaCortesTotales;
	}
	public List<String> getListaCortesTotalesString(){
		ArrayList<String> retorno = new ArrayList<String>();
		for(Posicion p : listaCortesTotales){
			retorno.add(p.toString());
		}
		return retorno;
	}
	public void setListaCortesTotales(List<Posicion> listaCortesTotales) {
		this.listaCortesTotales = listaCortesTotales;
	}
	public List<Posicion> getListaNodosVisitados() {
		return listaNodosVisitados;
	}
	public List<String> getListaNodosVisitadosString(){
		ArrayList<String> retorno = new ArrayList<String>();
		for(Posicion p : listaNodosVisitados){
			retorno.add(p.getHash());
		}
		return retorno;
	}
	public void setListaNodosVisitados(List<Posicion> listaNodosVisitados) {
		this.listaNodosVisitados = listaNodosVisitados;
	}
	public String getPosPatrullero() {
		return posPatrullero;
	}
	public void setPosPatrullero(String posPatrullero) {
		this.posPatrullero = posPatrullero;
	}
	public String getPosIncidente() {
		return posIncidente;
	}
	public void setPosIncidente(String posIncidente) {
		this.posIncidente = posIncidente;
	}
	public void setPosicionIncidente(Posicion posicionIncidente) {
		this.posicionIncidente = posicionIncidente;
	}
	
	public void setJFrame(JFrame frame){
		jFrame=frame;
	}
	public void repintar(){
		jFrame.repaint();
	}
	
}

