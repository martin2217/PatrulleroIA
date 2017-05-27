package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.exercise.patrullero.dominio.Mapa;
import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.exercise.patrullero.visualizacion.PruebaJung;

public class PatrulleroAgenteMain {

	private static Posicion patrullero;
	
    public static void main(String[] args) throws PrologConnectorException {
        
    	PatrulleroAgente agent = new PatrulleroAgente("1", "50");
        
        Ambiente environment = new Ambiente("1", "50");
        
        /*
         * Prueba para cortar un nodo - FUNCIONA
        PatrulleroEstado estadoP= (PatrulleroEstado) agent.getAgentState();
        estadoP.getMapa().getNodos().get("11").setHabilitado(false);
        AmbienteEstado estadoA= (AmbienteEstado) environment.getEnvironmentState();
        estadoA.getMapa().getNodos().get("11").setHabilitado(false);
        */
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        

		Mapa mapa = environment.getEnvironmentState().getMapa();
		patrullero=((PatrulleroEstado) agent.getAgentState()).getPosicionActual();
		
		new PruebaJung(mapa, (PatrulleroEstado)agent.getAgentState());
        
        simulator.start();
    }

}
