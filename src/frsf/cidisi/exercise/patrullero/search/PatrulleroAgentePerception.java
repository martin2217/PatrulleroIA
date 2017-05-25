package frsf.cidisi.exercise.patrullero.search;

import java.util.List;

import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class PatrulleroAgentePerception extends Perception {

	//TODO: Setup Statics
    public static int UNKNOWN_PERCEPTION = -1;   
	
	
	//TODO: Setup Sensors
	private int congestion_transito;
	private int marcha;
	private int accidente_transito;
	private int evento_social;
	private int plan_bacheo;
	//private Posicion destino;
 

    public  PatrulleroAgentePerception(/*Posicion unDestino*/) {
    	//TODO: Complete Method
    	congestion_transito=UNKNOWN_PERCEPTION;
    	marcha=UNKNOWN_PERCEPTION;
    	accidente_transito=UNKNOWN_PERCEPTION;
    	evento_social=UNKNOWN_PERCEPTION;
    	plan_bacheo=UNKNOWN_PERCEPTION;
    	//destino = unDestino;
    }

    public PatrulleroAgentePerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    	//TODO: Complete Method
        
        PatrulleroAgente agent = (PatrulleroAgente) agentIn;
        Ambiente environment = (Ambiente) environmentIn;
        AmbienteEstado environmentState = environment.getEnvironmentState();
       
        Posicion pos = environmentState.getPosicionPatrullero(); //destino; 
        
        boolean hayMarcha = environmentState.getListaMarchas().contains(pos);
        boolean hayAccidente = environmentState.getListaAccidentesTransito().contains(pos);
        boolean hayCongestion = environmentState.getListaCongestionTransito().contains(pos);
        boolean hayEvento = environmentState.getListaEventoSocial().contains(pos);
        boolean hayBacheo = environmentState.getListaPlanBacheo().contains(pos);
        
        //Marcha
        if(hayMarcha){
        	marcha = 1;
        }
        else
        {
        	marcha = 0;	
        }
        
        //Accidente
        if(hayAccidente){
        	accidente_transito = 1;
        }
        else
        {
        	accidente_transito = 0;	
        }
        
        //Congestoin
        if(hayCongestion){
        	congestion_transito = 1;
        }
        else
        {
        	congestion_transito = 0;	
        }
        
        //Evento
        if(hayEvento){
        	evento_social = 1;
        }
        else
        {
        	evento_social = 0;	
        }
        
        //Bacheo
        if(hayBacheo){
        	plan_bacheo = 1;
        }
        else
        {
        	plan_bacheo = 0;	
        }
               
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
     public int getcongestion_transito(){
        return congestion_transito;
     }
     public void setcongestion_transito(int arg){
        this.congestion_transito = arg;
     }
     public int getmarcha(){
        return marcha;
     }
     public void setmarcha(int arg){
        this.marcha = arg;
     }
     public int getaccidente_transito(){
        return accidente_transito;
     }
     public void setaccidente_transito(int arg){
        this.accidente_transito = arg;
     }
     public int getevento_social(){
        return evento_social;
     }
     public void setevento_social(int arg){
        this.evento_social = arg;
     }
     public int getplan_bacheo(){
        return plan_bacheo;
     }
     public void setplan_bacheo(int arg){
        this.plan_bacheo = arg;
     }
	
   
}
