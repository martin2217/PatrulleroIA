package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

public class PatrulleroAgenteMain {

    public static void main(String[] args) throws PrologConnectorException {
        PatrulleroAgente agent = new PatrulleroAgente("1", "3");

        Ambiente environment = new Ambiente("1", "3");

        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        
        simulator.start();
    }

}
