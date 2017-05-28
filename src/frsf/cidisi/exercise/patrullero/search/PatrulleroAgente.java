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

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class PatrulleroAgente extends SearchBasedAgent {
	
	public AtomicBoolean pausado;
	public int tipoBusqueda;
	
	public static final int AMPLITUD=1;
	public static final int PROFUNDIDAD=2;
	public static final int HEURISTICA=3;
	public static final int COSTO=4;
	public static final int A_ESTRELLA=5;
	

    public PatrulleroAgente(String posPatrullero, String posIncidente, AtomicBoolean pausad, int tipoBusq) {
    	
    	pausado=pausad;
    	tipoBusqueda=tipoBusq;
    	
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

    	Strategy strategy= new BreathFirstSearch();
    	
		switch (tipoBusqueda) {

		// Estrategia en amplitud
		case AMPLITUD:
			strategy = new BreathFirstSearch();
			break;

		// Estrategia por heurística
		case PROFUNDIDAD:
			strategy = new DepthFirstSearch();
			break;

		// Estrategia por heurística
		case HEURISTICA:
			strategy = new GreedySearch(new Heuristic());
			break;

		// Estrategia por costo
		case COSTO:
			strategy = new UniformCostSearch(new CostFunction());
			break;

		// Estrategia A*
		case A_ESTRELLA:
			strategy = new AStarSearch(new CostFunction(), new Heuristic());
			break;
			
		default:
			strategy = new BreathFirstSearch();
		}
    	

        // Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.PDF_TREE);

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
