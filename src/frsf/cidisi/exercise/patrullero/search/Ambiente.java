package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {

    public Ambiente() {
        // Create the environment state
        this.environmentState = new AmbienteEstado();
    }

    public AmbienteEstado getEnvironmentState() {
        return (AmbienteEstado) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  PatrulleroAgentePerception getPercept() {
        // Create a new perception to return
         PatrulleroAgentePerception perception = new PatrulleroAgentePerception();
		
		//TODO : Set the perceptions sensors
        Posicion pos = getEnvironmentState().getPosicionPatrullero();
        
        boolean hayMarcha = getEnvironmentState().getListaMarchas().contains(pos);
        boolean hayAccidente = getEnvironmentState().getListaAccidentesTransito().contains(pos);
        boolean hayCongestion = getEnvironmentState().getListaCongestionTransito().contains(pos);
        boolean hayEvento = getEnvironmentState().getListaEventoSocial().contains(pos);
        boolean hayBacheo = getEnvironmentState().getListaPlanBacheo().contains(pos);
        
        //Marcha
        if(hayMarcha){
        	perception.setmarcha(1);
        	
        }
        else
        {
        	perception.setmarcha(0);
        }
        
        //Accidente
        if(hayAccidente){
        	perception.setaccidente_transito(1);
        }
        else
        {
        	perception.setaccidente_transito(0);	
        }
        
        //Congestoin
        if(hayCongestion){
        	perception.setcongestion_transito(1);
        }
        else
        {
        	perception.setcongestion_transito(0);	
        }
        
        //Evento
        if(hayEvento){
        	perception.setevento_social(1);
        }
        else
        {
        	perception.setevento_social(0);	
        }
        
        //Bacheo
        if(hayBacheo){
        	perception.setplan_bacheo(1);
        }
        else
        {
        	perception.setplan_bacheo(0);
        }
         
         
         
        // Return the perception
        return perception;
    }

    
    public String toString() {
        return environmentState.toString();
    }

    
    public boolean agentFailed(Action actionReturned) {

        AmbienteEstado envState =
                this.getEnvironmentState();

        // TODO: Complete Method        

        return false;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
    
    
}
