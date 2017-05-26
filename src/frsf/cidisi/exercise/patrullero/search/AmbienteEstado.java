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
    private List<Posicion> listaMarchas;                //Corte Total
    private List<Posicion> listaAccidentesTransito;     //Corte Parcial
    private List<Posicion> listaCongestionTransito;     //Corte Parcial
    private List<Posicion> listaEventoSocial;           //Corte Total
    private List<Posicion> listaPlanBacheo;             //Corte Parcial
    private Posicion posicionPatrullero;
    private Posicion posicionIncidente;
    private Mapa mapa;
    private String posPatrullero;
    private String posIncidente;
	
    /*
     * Incidente y posición del patrullero predefinidas
     */
    public AmbienteEstado() {
        
        //TODO: Setup variables estado del ambiente
    	posPatrullero="1";
    	posIncidente="55";
    	listaMarchas = new ArrayList<Posicion>();
    	listaAccidentesTransito= new ArrayList<Posicion>();
        listaCongestionTransito= new ArrayList<Posicion>();
        listaEventoSocial= new ArrayList<Posicion>();
        listaPlanBacheo= new ArrayList<Posicion>();
        this.initState();
    }
    
    public AmbienteEstado(String posP, String posI) {
    	posPatrullero= posP;
    	posIncidente= posI;
    	listaMarchas = new ArrayList<Posicion>();
    	listaAccidentesTransito= new ArrayList<Posicion>();
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
    	
    	//Cargar listas... (..?)
    	
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method
        str+="Patrullero en "+posicionPatrullero.toString()+", incidente en "+posicionIncidente.toString()+".";

        return str;
    }
    
    public Posicion getPosicionPatrullero(){
    	return posicionPatrullero;
    }
    
    public void setPosicionPatrullero(Posicion nuevaPosicion){
    	posicionPatrullero = nuevaPosicion;
    }
    
    public List<Posicion> getListaMarchas(){
    	return listaMarchas;
    
    }
    public List<Posicion> getListaAccidentesTransito(){
    	return listaMarchas;
    
    }
    public List<Posicion> getListaCongestionTransito(){
    	return listaMarchas;
    
    }
    public List<Posicion> getListaEventoSocial(){
    	return listaMarchas;
    
    }
    public List<Posicion> getListaPlanBacheo(){
    	return listaMarchas;
    
    }
    
    public void addListaMarchas(Posicion unaPosicion){
    	listaMarchas.add(unaPosicion);
    
    }
    public void addListaAccidentesTransito(Posicion unaPosicion){
    	listaMarchas.add(unaPosicion);
    
    }
    public void addListaCongestionTransito(Posicion unaPosicion){
    	listaMarchas.add(unaPosicion);
    
    }
    public void addListaEventoSocial(Posicion unaPosicion){
    	listaMarchas.add(unaPosicion);
    
    }
    public void addListaPlanBacheo(Posicion unaPosicion){
    	listaMarchas.add(unaPosicion);
    
    }
	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	

}

