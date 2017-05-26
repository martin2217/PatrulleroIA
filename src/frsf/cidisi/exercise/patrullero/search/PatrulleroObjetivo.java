

package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class PatrulleroObjetivo extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    
    	PatrulleroEstado estado = (PatrulleroEstado) agentState;
    	
    	// TODO: Complete Method
        if  (estado.getPosicionActual().toString().equals(estado.getPosicionIncidente().toString())) {
              return true;
        	}
        return false;
	}
}