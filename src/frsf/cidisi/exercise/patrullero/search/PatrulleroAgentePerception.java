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
	private List<Posicion> congestion_transito;
	private List<Posicion> marcha;
	private List<Posicion> accidente_transito;
	private List<Posicion> evento_social;
	private List<Posicion> plan_bacheo;
	//private Posicion destino;
	
	/*
	 *  LEER
	 *  La percepción es una lista de cortes que le tiene que dar el ambiente
	 *  (en un principio hacer que EL AMBIENTE le pase todos, y desp modificamos para que calcule los mas cercanos)
	 *  AmbienteEstado.getPosicionesCercanas() por ej, REVISAR si no se debe implementar en un método predefinido
	 */
	
	
    public  PatrulleroAgentePerception(/*Posicion unDestino*/) {
    	//TODO: Complete Method
    	//destino = unDestino;
    	//initPerception();
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
       
        Posicion pos = environmentState.getPosicionPatrullero();
        
        marcha = environmentState.getListaMarchas();
        
    }
    
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();

        //TODO: Complete Method

        return str.toString();
    }

    // The following methods are agent-specific:
    //TODO: Complete this section with the agent-specific methods
	
	
   
}
