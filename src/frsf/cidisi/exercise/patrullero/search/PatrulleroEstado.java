package frsf.cidisi.exercise.patrullero.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
	
	//TODO: Setup Variables
    private Posicion posicionActual;
    private Posicion posicionIncidente;
    private Mapa mapa;
    private Segmento ultimoSegmento;
    private List<Posicion> listaCortesParciales;
    private List<Posicion> listaCortesTotales;
	private List<Posicion> listaNodosVisitados;

    public PatrulleroEstado() {
       	
    	
    	//TODO: Complete Method
    	/*
			// DataStructureName = initData0;
        */
        this.initState();
    }

    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
		//TODO: Complete Method
		
        return null;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
        
        //TODO: Complete Method
    	PatrulleroAgentePerception percepcion = (PatrulleroAgentePerception)p;
    	
    	Posicion posActual = this.posicionActual;
    	int marchaPercibida = percepcion.getmarcha();
    	int accidentePercibido = percepcion.getaccidente_transito();
    	int congestionPercibida = percepcion.getcongestion_transito();
    	int eventoPercibido = percepcion.getevento_social();
    	int bacheoPercibido = percepcion.getplan_bacheo();
    	
    	if(marchaPercibida ==1){
    		addListaCortesTotales(getPosicionActual());
    	}
    	if(accidentePercibido ==1){
    		addListaCortesParciales(getPosicionActual());
    	}
    	if(congestionPercibida ==1){
    		addListaCortesParciales(getPosicionActual());
    	}
    	if(eventoPercibido ==1){
    		addListaCortesTotales(getPosicionActual());
    	}
    	if(bacheoPercibido ==1){
    		addListaCortesParciales(getPosicionActual());
    	}
    	
    	
    	
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
	//TODO: Complete Method
    	
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
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
    	List<Posicion> lista = new ArrayList<Posicion>();
    	 
    	if(posicionActual.getClass().getName()=="Segmento"){
    		lista.add(((Segmento)posicionActual).getNodoHasta());
    	}
    	else{
    		lista.addAll(((Nodo)posicionActual).getSegmentosConectados());
    	}
    	
    	return lista;
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
    
    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
       
       //TODO: Complete Method
        
        return true;
    }

    //TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
   	    
	
}

