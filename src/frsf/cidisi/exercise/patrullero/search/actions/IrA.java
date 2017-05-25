package frsf.cidisi.exercise.patrullero.search.actions;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.exercise.patrullero.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrA extends SearchAction {
  Posicion destino = null;
	
    	public IrA(Posicion unDestino){
    		destino = unDestino;
    	}
	
    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    	
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PatrulleroEstado agState = (PatrulleroEstado) s;
                        
        if (agState.getPosicionesVisitadas().contains(destino)) {
            return null;
        }
        List<Posicion> sucesores = agState.getSucesores();
        
        if (sucesores != null) {
            int index = sucesores.indexOf(destino);
            if (index >= 0) {
                agState.setPosicionActual(destino);
                agState.addPosicionVisitada(destino);
                                
                return agState;
            }
        } 
        
        return null;
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        AmbienteEstado environmentState = (AmbienteEstado) est;
        PatrulleroEstado agState = ((PatrulleroEstado) ast);

        int index = -1;
        List<Posicion> sucesores = agState.getSucesores();
        
        if (sucesores != null) {
            index = sucesores.indexOf(destino);
        }
        
        if ((!agState.getPosicionesVisitadas().contains(destino)) && (index >= 0)) {
            // Update the real world
        	   environmentState.setPosicionPatrullero(destino);                
                    	
        	
            // Update the agent state
            agState.setPosicionActual(destino);
            agState.addPosicionVisitada(destino);
        	
            return environmentState;
        }

        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "IrA ";
    }
}