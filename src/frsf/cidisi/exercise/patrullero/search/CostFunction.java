package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.faia.solver.search.IStepCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class can be used in any search strategy like
 * Uniform Cost.
 */
public class CostFunction implements IStepCostFunction {

    /**
     * This method calculates the cost of the given NTree node.
     */
    @Override
    public double calculateCost(NTree node) {
        
        PatrulleroEstado auxPatrulleroEstado;// = ((PatrulleroEstado) node.getAgentState());
        double costoTotal=0;
        
        NTree nodoAux=node;
        do{
        	auxPatrulleroEstado=((PatrulleroEstado) nodoAux.getAgentState());
        	costoTotal+=auxPatrulleroEstado.getPosicionActual().getCosto();
        	
        } while((nodoAux=nodoAux.getParent())!=null);
        
        return costoTotal;
    }
}
