package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PatrulleroAgenteMain {

    public static void main(String[] args) throws PrologConnectorException {
        
    	PatrulleroAgente agent = new PatrulleroAgente("1", "90");
        
        Ambiente environment = new Ambiente("1", "90");
        
        /*
         * Prueba para cortar un nodo - FUNCIONA
        PatrulleroEstado estadoP= (PatrulleroEstado) agent.getAgentState();
        estadoP.getMapa().getNodos().get("11").setHabilitado(false);
        AmbienteEstado estadoA= (AmbienteEstado) environment.getEnvironmentState();
        estadoA.getMapa().getNodos().get("11").setHabilitado(false);
        */
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
