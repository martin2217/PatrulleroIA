package frsf.cidisi.exercise.patrullero.search.actions;

import java.util.ArrayList;
import java.util.List;

import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.exercise.patrullero.dominio.Segmento;
import frsf.cidisi.exercise.patrullero.search.*;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class IrA extends SearchAction {

	Posicion destino = null;
	String dest;

	public IrA(Posicion unDestino) {
		destino = unDestino;
		dest= unDestino.toString();
	}

	/**
	 * This method updates a tree node state when the search process is running.
	 * It does not updates the real world state.
	 */
    	
	@Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        PatrulleroEstado agState = (PatrulleroEstado) s;
                        
        if (agState.getListaNodosVisitadosString().contains(destino.toString()) || !destino.isHabilitado()) {
            return null;
        }
        
        List<String> sucesores = agState.getSucesoresString();
        
        if (sucesores != null) {
            int index = sucesores.indexOf(destino.toString());
            
            // Si la posición del operador IrA coincide con algun sucesor
            if (index >= 0) {
                agState.setPosicionActual(agState.getMapa().getPosicion(destino.getHash()));
                agState.addPosicionVisitada(agState.getMapa().getPosicion(destino.getHash()));
                
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
        List<String> sucesores = agState.getSucesoresString();
        
        if (sucesores != null) {
        	index = sucesores.indexOf(destino.toString());
        }
        
        if (/*(!agState.getListaNodosVisitadosString().contains(destino.getHash())) && */(index >= 0)) {
            // Update the real world
        	environmentState.setPosicionPatrullero(agState.getMapa().getPosicion(destino.getHash()));
        	
            // Update the agent state
            agState.setPosicionActual(agState.getMapa().getPosicion(destino.getHash()));
            agState.addPosicionVisitada(agState.getMapa().getPosicion(destino.getHash()));
        	
            agState.repintar();
            
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
        return "Ir a "+dest+".";
    }

	public Posicion getDestino() {
		return destino;
	}

	public void setDestino(Posicion destino) {
		this.destino = destino;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
}