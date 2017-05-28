package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

	// Factor de relación de pixeles a metros
	double RelacionPixelMetro=1.2; 
	
    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        PatrulleroEstado agState = (PatrulleroEstado) node.getAgentState();
        
		//Method: Complete Method
        
        // Heurística usando la distancia entre el punto actual y el punto del incidente (según los pixeles de posicionamiento)
        
        double dx= agState.getPosicionActual().getX() - agState.getPosicionIncidente().getX();
        double dy= agState.getPosicionActual().getY() - agState.getPosicionIncidente().getY();
        
		
        return Math.sqrt(dx*dx+dy*dy)*RelacionPixelMetro;
    }
}
