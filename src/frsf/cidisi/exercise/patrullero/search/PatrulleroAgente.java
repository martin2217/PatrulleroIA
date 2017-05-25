package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.exercise.patrullero.search.actions.IrA;
import frsf.cidisi.exercise.patrullero.search.actions.DoblarADerecha;
import frsf.cidisi.exercise.patrullero.search.actions.DoblarAIzquierda;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PatrulleroAgente extends SearchBasedAgent {

    public PatrulleroAgente() {
    	List<Posicion> adyacentes = new ArrayList<Posicion>();
        // The Agent Goal
        PatrulleroObjetivo agGoal = new PatrulleroObjetivo();

        // The Agent State
        PatrulleroEstado agState = new PatrulleroEstado();
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        adyacentes = agState.getSucesores();
        
        for(int i = 0 ; i < adyacentes.size(); i++){
        operators.addElement(new IrA(adyacentes.get(i)));
        }
        
        //operators.addElement(new DoblarADerecha());	
        //operators.addElement(new DoblarAIzquierda());	

        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

        // Create the search strategy
        DepthFirstSearch strategy = new DepthFirstSearch();          

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.GRAPHVIZ_TREE);

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(PatrulleroAgente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
