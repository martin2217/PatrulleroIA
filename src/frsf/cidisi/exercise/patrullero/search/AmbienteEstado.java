package frsf.cidisi.exercise.patrullero.search;

import frsf.cidisi.exercise.patrullero.dominio.Mapa;
import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class AmbienteEstado extends EnvironmentState {
	
	//TODO: Setup Variables
    private Mapa mapa;
    private int DataStructureName2;
	
    public AmbienteEstado() {
        
        //TODO: Complete Method
    	/*
			// DataStructureName = initData0;
			// DataStructureName2 = initData1;
        */
        this.initState();
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {

        //TODO: Complete Method
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "";

        //TODO: Complete Method

        return str;
    }

	//TODO: Complete this section with agent-specific methods
    // The following methods are agent-specific:
	
     public Mapa getDataStructureName(){
        return mapa;
     }
     public void setDataStructureName(Mapa arg){
        mapa = arg;
     }
     public int getDataStructureName2(){
        return DataStructureName2;
     }
     public void setDataStructureName2(int arg){
        DataStructureName2 = arg;
     }
	

}

