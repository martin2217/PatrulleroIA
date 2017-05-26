

package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class PatrulleroObjetivo extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    
    	PatrulleroEstado estado = (PatrulleroEstado) agentState;
    	
    	// TODO: Complete Method
    	
    	// Revisiones para el debugging
    	if (estado==null){
    		int v=0;
    	}
    	else if(estado.getPosicionActual()==null){
    		int v=1;
    	}
    	else if(estado.getPosicionIncidente()==null){
    		int v=2;
    	}
        if  (estado.getPosicionActual().toString().equals(estado.getPosicionIncidente().toString())) {
              return true;
        	}
        return false;
	}
}