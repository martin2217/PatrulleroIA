package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.exercise.patrullero.dominio.Nodo;
import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.exercise.patrullero.dominio.Segmento;
import frsf.cidisi.exercise.patrullero.search.actions.IrA;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PatrulleroAgente extends SearchBasedAgent {

    public PatrulleroAgente(String posPatrullero, String posIncidente) {
    	List<Posicion> adyacentes = new ArrayList<Posicion>();
        // The Agent Goal
        PatrulleroObjetivo agGoal = new PatrulleroObjetivo();

        // The Agent State
        PatrulleroEstado agState = new PatrulleroEstado(posPatrullero, posIncidente);
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        HashMap<String, Segmento> segmentos= agState.getMapa().getSegmentos();
        for(Map.Entry<String, Segmento> entry : segmentos.entrySet()){
        	Posicion value = entry.getValue();
            operators.addElement(new IrA(value));
        }
        
        HashMap<String, Nodo> nodos= agState.getMapa().getNodos();
        for (Map.Entry<String, Nodo> entry : nodos.entrySet()){
            Posicion value = entry.getValue();
            operators.addElement(new IrA(value));
        }

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
    	BreathFirstSearch strategy = new BreathFirstSearch();          

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE);

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
