package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {

    public Ambiente(String posPatrullero, String posIncidente) {
        // Create the environment state
        this.environmentState = new AmbienteEstado(posPatrullero, posIncidente);
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
        
        perception.setListaAccidenteTransito(getEnvironmentState().getListaAccidenteTransitoPatrullero());
        perception.setListaCongestionTransito(getEnvironmentState().getListaCongestionTransitoPatrullero());
        perception.setListaEventoSocial(getEnvironmentState().getListaEventoSocialPatrullero());
        perception.setListaMarcha(getEnvironmentState().getListaMarchaPatrullero());
        perception.setListaPlanBacheo(getEnvironmentState().getListaPlanBacheoPatrullero());
         
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
