package frsf.cidisi.exercise.patrullero.search;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import frsf.cidisi.exercise.patrullero.dominio.Mapa;
import frsf.cidisi.exercise.patrullero.dominio.Posicion;
import frsf.cidisi.faia.exceptions.PrologConnectorException;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.exercise.patrullero.visualizacion.GUIPrincipal;

public class PatrulleroAgenteMain {

	private static Posicion patrullero;
	private static GUIPrincipal gui;
	private static AtomicBoolean pausado;
	private static JFrame menuFrame;
	
    public static void main(String[] args) throws PrologConnectorException {      
    	
		menuFrame= new JFrame("Menu");
		
		menuFrame.setLayout(new BorderLayout());
		menuFrame.setMinimumSize(new Dimension(500, 350));
		menuFrame.setPreferredSize(new Dimension(500, 350));
		menuFrame.setSize(new Dimension(500, 350));
		menuFrame.setLayout(new BorderLayout());
		
		JPanel panelTop = new JPanel(new BorderLayout());
		panelTop.setMinimumSize(new Dimension(400, 80));
		panelTop.setMaximumSize(new Dimension(400, 80));
		panelTop.setPreferredSize(new Dimension(400, 80));
		panelTop.setSize(new Dimension(400, 80));
		panelTop.setBorder(new EmptyBorder(30, 30, 20, 40));
		menuFrame.add(panelTop, BorderLayout.NORTH);
		
		JLabel estrategiasInfo = new JLabel("Elija la estrategia a utilizar");
		panelTop.add(estrategiasInfo, BorderLayout.WEST);
		
		final JComboBox comboEstrategias = new JComboBox();
		String[] estrategias = {"Amplitud", "Profundidad", "Heurística", "Costo uniforme", "A*"};
		comboEstrategias.setModel(new DefaultComboBoxModel(estrategias));
		panelTop.add(comboEstrategias, BorderLayout.EAST);
		
		
		JPanel panelCenter = new JPanel(new BorderLayout());
		panelCenter.setMinimumSize(new Dimension(400, 100));
		panelCenter.setMaximumSize(new Dimension(400, 100));
		panelCenter.setPreferredSize(new Dimension(400, 100));
		panelCenter.setSize(new Dimension(400, 100));
		panelCenter.setBorder(new EmptyBorder(15, 30, 20, 40));
		menuFrame.add(panelCenter, BorderLayout.CENTER);
		
		JPanel panelPatrullero = new JPanel(new BorderLayout());
		panelCenter.add(panelPatrullero, BorderLayout.NORTH);
		
		JLabel labelPatrullero = new JLabel("Ingrese la posición del patrullero");
		panelPatrullero.add(labelPatrullero, BorderLayout.WEST);
		final JTextField textPatrullero = new JTextField();
		textPatrullero.setPreferredSize(new Dimension(200,30));
		panelPatrullero.add(textPatrullero, BorderLayout.EAST);
		panelCenter.setPreferredSize(new Dimension(400, 100));
		
		
		
		JPanel panelIncidente = new JPanel(new BorderLayout());
		panelCenter.add(panelIncidente, BorderLayout.SOUTH);
		
		JLabel labelIncidente = new JLabel("Ingrese la posición del incidente");
		panelIncidente.add(labelIncidente, BorderLayout.WEST);
		final JTextField textIncidente = new JTextField();
		textIncidente.setPreferredSize(new Dimension(200,30));
		panelIncidente.add(textIncidente, BorderLayout.EAST);
		
		
		JPanel panelBot = new JPanel(new BorderLayout());
		panelBot.setMinimumSize(new Dimension(400, 100));
		panelBot.setMaximumSize(new Dimension(400, 100));
		panelBot.setPreferredSize(new Dimension(400, 100));
		panelBot.setSize(new Dimension(400, 100));
		panelBot.setBorder(new EmptyBorder(20, 50, 40, 50));
		menuFrame.add(panelBot, BorderLayout.SOUTH);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!textPatrullero.getText().trim().equals("")
						|| !textIncidente.getText().trim().equals("")) {
					menuFrame.setVisible(false);
					ejecutar(textPatrullero.getText().toString(), textIncidente.getText().toString(),
							comboEstrategias.getSelectedIndex() + 1);
				}
			}
		});
		panelBot.add(btnEjecutar, BorderLayout.CENTER);
		
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.pack();
		menuFrame.setLocationRelativeTo(null);
		menuFrame.setVisible(true);
		
    }
    
	public static void ejecutar(String nodoPatrullero, String nodoIncidente, int estrategia) {
		
		pausado = new AtomicBoolean(false);
		
		PatrulleroAgente agent = new PatrulleroAgente(nodoPatrullero, nodoIncidente, pausado, estrategia);

		Ambiente environment = new Ambiente(nodoPatrullero, nodoIncidente);

		/*
		 * Prueba para cortar un nodo - FUNCIONA PatrulleroEstado estadoP=
		 * (PatrulleroEstado) agent.getAgentState();
		 * estadoP.getMapa().getNodos().get("11").setHabilitado(false);
		 * AmbienteEstado estadoA= (AmbienteEstado)
		 * environment.getEnvironmentState();
		 * estadoA.getMapa().getNodos().get("11").setHabilitado(false);
		 */
        
        SearchBasedAgentSimulator simulator =
                new SearchBasedAgentSimulator(environment, agent);
        

		Mapa mapa = environment.getEnvironmentState().getMapa();
		patrullero=((PatrulleroEstado) agent.getAgentState()).getPosicionActual();
		
		
		
		
		gui = new GUIPrincipal(simulator, mapa, (PatrulleroEstado)agent.getAgentState(), pausado, menuFrame);
        
        //simulator.start();
    	
    }

}
