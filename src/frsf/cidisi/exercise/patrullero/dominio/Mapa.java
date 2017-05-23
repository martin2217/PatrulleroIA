package frsf.cidisi.exercise.patrullero.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.uci.ics.jung.graph.util.Pair;

public class Mapa {

	private HashMap<String, Nodo> nodos;
	private HashMap<String, Segmento> segmentos;
	
	public Mapa(){
		nodos= new HashMap<String, Nodo>();
		segmentos= new HashMap<String, Segmento>();
		cargarMapa();
	}
	
	public HashMap<String, Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(HashMap<String, Nodo> nodos) {
		this.nodos = nodos;
	}

	public HashMap<String, Segmento> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(HashMap<String, Segmento> segmentos) {
		this.segmentos = segmentos;
	}
	
	private void conectar(Nodo n1, Nodo n2, Segmento s){
		n1.addSegmento(s); // Grafo dirigido
		s.setNodoDesde(n1); s.setNodoHasta(n2);
	}
	private void cargarNodo(String cod, ArrayList<String> calles, Double x, Double y){
		Nodo n1;
		n1=new Nodo(cod, calles, x, y); // Se crea el nodo
		nodos.put(cod, n1); // Se agrega a la lista de nodos
	}
	private void cargarSegmento(String calle, int numDesde, int numHasta, int direcc, int nodoDesde, int nodoHasta){
		// Ejemplo: cargarSegmento(SALVADOR_DEL_CARRIL, 1400, 1500, Segmento.CRECIENDO, 1, 2);
		Segmento s;
		// Se crea el segmento
		s=new Segmento(calle, numDesde, numHasta, direcc);
		// Se agrega al HashMap de segmentos (calle+" "+numDesde+" -> "+numHasta)
		segmentos.put(s.getHash(), s);
		// Se conecta el segmento y los nodos
		conectar(nodos.get(String.valueOf(nodoDesde)), nodos.get(String.valueOf(nodoHasta)), s);
	}
	private void posicionar(ArrayList<Pair<Double>> pos, int x, int y){
		pos.add(new Pair<Double>((double)x,(double)y));
	}
	
	private final String SALVADOR_DEL_CARRIL = "Salvador del Carril";
	private final String GRAL_PAZ = "Av Gral Paz";
	private final String LAVALLE = "Lavalle";
	private final String GUEMES = "Güemes";
	private final String AVELLANEDA = "Avellaneda";
	private final String PIZZORINO = "Pje Pizzorino";
	private final String VELEZ = "Vélez Sársfield";
	private final String LAPRIDA = "Laprida";
	private final String DORREGO = "Dorrego";
	private final String AV_BROWN = "Av Almirante Brown";
	private final String DERQUI = "Santiago Derqui";
	private final String ZUVIRIA = "José María Zuviría";
	private final String R_GODOY = "Ruperto Godoy";
	private final String HUERGO = "D Huergo";
	private final String ARZAMENDIA = "Pje Arzamendia";
	private final String LLERENA = "Llerena";
	private final String SASTRE = "Marco Sastre";
	private final String LAVAISSE = "Lavaisse";
	private final String GOROSTIAGA = "Gorostiaga";
	private final String MOSQUERA = "Mosquera";
	private final String ITURRI = "Pje Iturri";
	private final String PEDRO_DE_VEGA = "Pedro de Vega";
	private final String ALDAO = "Ricardo Aldao";
	
	private final String TACUARI = "Tacuarí";
	private final String PIEDRAS = "Piedras";
	private final String A_GODOY = "Antonia Godoy";
	private final String ECHAGUE = "Echagüe";
	private final String CASSANELLO = "Ángel Cassanello";
	private final String CULLEN = "Patricio Cullen";
	private final String TALCAHUANO = "Talcahuano";
	private final String LOPEZ = "J P LOPEZ";
	private final String HERNANDARIAS = "Hernandarias";
	private final String PUJATO = "Pje Pujato";
	private final String DEFENSA = "Defensa";
	private final String CASTELLI = "Juan Castelli";
	private final String RIOBAMBA = "Riobamba";
	private final String ZEBALLOS = "Estanislao Zeballos";
	private final String PASAJE = "Pasaje";
	private final String BONEO = "Obispo Boneo";
	
	
	private void cargarMapa(){
		
		// Lista, de lista de calles (las calles que contiene cada nodo, no las conexiones en si)
		ArrayList< ArrayList<String >> ls = new ArrayList< ArrayList<String> >();
		ArrayList<Pair<Double>> pos = new ArrayList<Pair<Double>>(167);
		
		//ArrayList<String> l = new ArrayList<String>();
		
		// 1
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, LAVALLE)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, GUEMES)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, AVELLANEDA)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, DORREGO)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, PIZZORINO)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, LAPRIDA)));
		ls.add(new ArrayList<String>(Arrays.asList(SALVADOR_DEL_CARRIL, AV_BROWN)));
		
		//10
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, LAVALLE)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, GUEMES)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, AVELLANEDA)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, DORREGO)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, PIZZORINO)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(ZUVIRIA, LAPRIDA)));
		
		//18
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, LAVALLE)));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Güemes")));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Pje Pizzorino")));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Laprida")));
		ls.add(new ArrayList<String>(Arrays.asList(DERQUI, "Av Almirante Brown")));
		
		//27
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Güemes")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Pje Pizzorino")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Laprida")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(R_GODOY, "Av Almirante Brown")));
		
		//36
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Güemes")));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, ARZAMENDIA)));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Pje Pizzorino", LLERENA)));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Laprida", "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(HUERGO, "Av Almirante Brown")));
		
		//46
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, ARZAMENDIA)));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList(LLERENA, "Av Almirante Brown")));
		
		//55
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, ARZAMENDIA)));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, GOROSTIAGA)));
		ls.add(new ArrayList<String>(Arrays.asList("Dorrego", GOROSTIAGA)));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, "Dorrego")));
		
		ls.add(new ArrayList<String>(Arrays.asList(SASTRE, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(SASTRE, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(SASTRE, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(SASTRE, "Antonia Godoy")));
		
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(LAVAISSE, "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList("Av Almirante Brown", "Patricio Cullen")));
		
		//70
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, MOSQUERA)));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(MOSQUERA, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Pje Pizzorino")));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(GOROSTIAGA, "Antonia Godoy")));
		
		//80
		ls.add(new ArrayList<String>(Arrays.asList(MOSQUERA, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Pje Pizzorino")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(ITURRI, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(ITURRI, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(ITURRI, "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Patricio Cullen")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, "Echagüe")));
		ls.add(new ArrayList<String>(Arrays.asList(PEDRO_DE_VEGA, AV_BROWN)));
		
		//94
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO)));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Patricio Cullen")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, "Echagüe")));
		ls.add(new ArrayList<String>(Arrays.asList(ALDAO, AV_BROWN)));
		
		//104
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO)));
		ls.add(new ArrayList<String>(Arrays.asList(DORREGO)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(CASSANELLO, AV_BROWN)));
		
		//115
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, DEFENSA)));
		ls.add(new ArrayList<String>(Arrays.asList(LOPEZ, AV_BROWN)));
		
		//127
		ls.add(new ArrayList<String>(Arrays.asList(PUJATO, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(PUJATO, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(PUJATO, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(PUJATO, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(PUJATO, ECHAGUE)));
		
		//132
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, DEFENSA)));
		ls.add(new ArrayList<String>(Arrays.asList(HERNANDARIAS, AV_BROWN)));
		
		//142
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, DEFENSA)));
		ls.add(new ArrayList<String>(Arrays.asList(RIOBAMBA, AV_BROWN)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, RIOBAMBA)));
		ls.add(new ArrayList<String>(Arrays.asList(CASTELLI, AV_BROWN)));
		
		//154
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, DEFENSA)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, RIOBAMBA)));
		ls.add(new ArrayList<String>(Arrays.asList(ZEBALLOS, AV_BROWN)));
		
		//165
		ls.add(new ArrayList<String>(Arrays.asList(PASAJE, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(PASAJE)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, DEFENSA)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, RIOBAMBA)));
		ls.add(new ArrayList<String>(Arrays.asList(BONEO, AV_BROWN)));
		
		
		
		// Carga de posiciones para visualización

		posicionar(pos, 32, 825);
		posicionar(pos, 95, 838);
		posicionar(pos, 155, 850);
		posicionar(pos, 213, 863);
		posicionar(pos, 272, 875);
		posicionar(pos, 321, 884);
		posicionar(pos, 346, 889);
		posicionar(pos, 403, 901);
		posicionar(pos, 464, 916);
		
		// 10
		posicionar(pos, 54, 790);
		posicionar(pos, 105, 802);
		posicionar(pos, 163, 816);
		posicionar(pos, 221, 831);
		posicionar(pos, 279, 845);
		posicionar(pos, 325, 856);
		posicionar(pos, 355, 851);
		posicionar(pos, 412, 860);
		
		//18
		posicionar(pos, 88, 737);
		posicionar(pos, 120, 743);
		posicionar(pos, 178, 761);
		posicionar(pos, 236, 772);
		posicionar(pos, 294, 786);
		posicionar(pos, 343, 801);
		posicionar(pos, 367, 805);
		posicionar(pos, 422, 819);
		posicionar(pos, 490, 835);
		
		//27
		posicionar(pos, 129, 681);
		posicionar(pos, 190, 698);
		posicionar(pos, 252, 713);
		posicionar(pos, 309, 728);
		posicionar(pos, 355, 740);
		posicionar(pos, 379, 745);
		posicionar(pos, 439, 762);
		posicionar(pos, 490, 774);
		posicionar(pos, 514, 778);
		
		
		// TODO continuar
		
		
		// Creación de los nodos
		for (int i=1; i<=176; i++){
			Double x;
			Double y;
			if (pos.size()+1 <= i){
				x=0.0; y=0.0;
			}
			else {
				x=pos.get(i-1).getFirst();
				y=pos.get(i-1).getSecond();
			}
			cargarNodo(String.valueOf(i),ls.get(i-1), x, y);
		}
		
		
		
		
		
		// Carga de segmentos    -    Se deben deshabilitar (o poner mas costo) a AMBOS segmentos manualmente .. Al menos hasta ahora es manual
		
		//cargarSegmento(Calle, numeroDesde, numeroHasta, Direccion, nodoDesde, nodoHasta);
		
		cargarSegmento(SALVADOR_DEL_CARRIL, 1400, 1500, Segmento.CRECIENDO, 2, 1);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1400, 1500, Segmento.DECRECIENDO, 1, 2);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1300, 1400, Segmento.CRECIENDO, 3, 2);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1300, 1400, Segmento.DECRECIENDO, 2, 3);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1200, 1300, Segmento.CRECIENDO, 4, 3);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1200, 1300, Segmento.DECRECIENDO, 3, 4);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1100, 1200, Segmento.CRECIENDO, 5, 4);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1100, 1200, Segmento.DECRECIENDO, 4, 5);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1000, 1100, Segmento.CRECIENDO, 6, 5);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1000, 1100, Segmento.DECRECIENDO, 5, 6);
		cargarSegmento(SALVADOR_DEL_CARRIL, 1000, 1000, Segmento.CRECIENDO, 7, 6);  // Ver qué Desde-Hasta ponemos
		cargarSegmento(SALVADOR_DEL_CARRIL, 1000, 1000, Segmento.DECRECIENDO, 6, 7);  // Ver
		cargarSegmento(SALVADOR_DEL_CARRIL, 900, 1000, Segmento.CRECIENDO, 8, 7);
		cargarSegmento(SALVADOR_DEL_CARRIL, 900, 1000, Segmento.DECRECIENDO, 7, 8);
		cargarSegmento(SALVADOR_DEL_CARRIL, 800, 900, Segmento.CRECIENDO, 9, 8);
		cargarSegmento(SALVADOR_DEL_CARRIL, 800, 900, Segmento.DECRECIENDO, 8, 9);

		cargarSegmento(GRAL_PAZ, 5400, 5500, Segmento.CRECIENDO, 1, 10);
		cargarSegmento(GRAL_PAZ, 5400, 5500, Segmento.DECRECIENDO, 10, 1);
		cargarSegmento(LAVALLE, 5400, 5500, Segmento.CRECIENDO, 2, 11);
		cargarSegmento(GUEMES, 5400, 5500, Segmento.DECRECIENDO, 12, 3);
		cargarSegmento(AVELLANEDA, 5400, 5500, Segmento.CRECIENDO, 4, 13);
		cargarSegmento(DORREGO, 5400, 5500, Segmento.DECRECIENDO, 14, 5);
		cargarSegmento(PIZZORINO, 5400, 5500, Segmento.CRECIENDO, 6, 15);
		cargarSegmento(PIZZORINO, 5400, 5500, Segmento.DECRECIENDO, 15, 6);
		cargarSegmento(VELEZ, 5400, 5500, Segmento.CRECIENDO, 7, 16);
		cargarSegmento(LAPRIDA, 5400, 5500, Segmento.DECRECIENDO, 17, 8);
		
		cargarSegmento(ZUVIRIA, 1400, 1500, Segmento.DECRECIENDO, 10, 11);
		cargarSegmento(ZUVIRIA, 1300, 1400, Segmento.DECRECIENDO, 11, 12);
		cargarSegmento(ZUVIRIA, 1200, 1300, Segmento.DECRECIENDO, 12, 13);
		cargarSegmento(ZUVIRIA, 1100, 1200, Segmento.DECRECIENDO, 13, 14);
		cargarSegmento(ZUVIRIA, 1000, 1100, Segmento.DECRECIENDO, 14, 15);
		cargarSegmento(ZUVIRIA, 900, 1000, Segmento.DECRECIENDO, 16, 17);
		
		cargarSegmento(GRAL_PAZ, 5500, 5600, Segmento.CRECIENDO, 10, 18);
		cargarSegmento(GRAL_PAZ, 5500, 5600, Segmento.DECRECIENDO, 18, 10);
		cargarSegmento(LAVALLE, 5500, 5600, Segmento.CRECIENDO, 11, 19);
		cargarSegmento(GUEMES, 5500, 5600, Segmento.DECRECIENDO, 20, 12);
		cargarSegmento(AVELLANEDA, 5500, 5600, Segmento.CRECIENDO, 13, 21);
		cargarSegmento(DORREGO, 5500, 5600, Segmento.DECRECIENDO, 22, 14);
		cargarSegmento(DORREGO, 5500, 5600, Segmento.CRECIENDO, 14, 22);
		cargarSegmento(PIZZORINO, 5500, 5600, Segmento.CRECIENDO, 15, 23);
		cargarSegmento(PIZZORINO, 5500, 5600, Segmento.DECRECIENDO, 23, 15);
		cargarSegmento(VELEZ, 5500, 5600, Segmento.CRECIENDO, 16, 24);
		cargarSegmento(LAPRIDA, 5500, 5600, Segmento.DECRECIENDO, 25, 17);
		cargarSegmento(AV_BROWN, 5400, 5600, Segmento.CRECIENDO, 9, 26);
		cargarSegmento(AV_BROWN, 5400, 5600, Segmento.DECRECIENDO, 26, 9);
		
		cargarSegmento(DERQUI, 1400, 1450, Segmento.CRECIENDO, 19, 18);
		cargarSegmento(DERQUI, 1300, 1400, Segmento.CRECIENDO, 20, 19);
		cargarSegmento(DERQUI, 1200, 1300, Segmento.CRECIENDO, 21, 20);
		cargarSegmento(DERQUI, 1100, 1200, Segmento.CRECIENDO, 22, 21);
		cargarSegmento(DERQUI, 1000, 1100, Segmento.CRECIENDO, 23, 22);
		cargarSegmento(DERQUI, 900, 1000, Segmento.CRECIENDO, 25, 24);
		cargarSegmento(DERQUI, 800, 900, Segmento.CRECIENDO, 26, 25);
		
		cargarSegmento(GRAL_PAZ, 5600, 5700, Segmento.CRECIENDO, 18, 27);
		cargarSegmento(GRAL_PAZ, 5600, 5700, Segmento.DECRECIENDO, 27, 18);
		cargarSegmento(GUEMES, 5600, 5700, Segmento.DECRECIENDO, 28, 20);
		cargarSegmento(AVELLANEDA, 5600, 5700, Segmento.CRECIENDO, 21, 29);
		cargarSegmento(DORREGO, 5600, 5700, Segmento.DECRECIENDO, 30, 22);
		cargarSegmento(DORREGO, 5600, 5700, Segmento.CRECIENDO, 22, 30);
		cargarSegmento(PIZZORINO, 5600, 5700, Segmento.CRECIENDO, 23, 31);
		cargarSegmento(PIZZORINO, 5600, 5700, Segmento.DECRECIENDO, 31, 23);
		cargarSegmento(VELEZ, 5600, 5700, Segmento.CRECIENDO, 24, 32);
		cargarSegmento(LAPRIDA, 5600, 5700, Segmento.DECRECIENDO, 33, 25);
		cargarSegmento(AV_BROWN, 5600, 5700, Segmento.CRECIENDO, 26, 35);
		cargarSegmento(AV_BROWN, 5600, 5700, Segmento.DECRECIENDO, 35, 26);
		
		cargarSegmento(R_GODOY, 1300, 1400, Segmento.DECRECIENDO, 27, 28);
		cargarSegmento(R_GODOY, 1200, 1300, Segmento.DECRECIENDO, 28, 29);
		cargarSegmento(R_GODOY, 1100, 1200, Segmento.DECRECIENDO, 29, 30);
		cargarSegmento(R_GODOY, 1000, 1100, Segmento.DECRECIENDO, 30, 31);
		cargarSegmento(R_GODOY, 900, 1000, Segmento.DECRECIENDO, 32, 33);
		cargarSegmento(R_GODOY, 800, 900, Segmento.DECRECIENDO, 33, 34);
		cargarSegmento(R_GODOY, 780, 800, Segmento.DECRECIENDO, 34, 35);
		
		cargarSegmento(GRAL_PAZ, 5700, 5800, Segmento.CRECIENDO, 27, 36);
		cargarSegmento(GRAL_PAZ, 5700, 5800, Segmento.DECRECIENDO, 36, 27);
		cargarSegmento(GUEMES, 5700, 5800, Segmento.DECRECIENDO, 37, 28);
		cargarSegmento(AVELLANEDA, 5700, 5800, Segmento.CRECIENDO, 29, 39);
		cargarSegmento(DORREGO, 5700, 5800, Segmento.DECRECIENDO, 40, 30);
		cargarSegmento(DORREGO, 5700, 5800, Segmento.CRECIENDO, 30, 40);
		cargarSegmento(PIZZORINO, 5700, 5800, Segmento.CRECIENDO, 31, 41);
		cargarSegmento(PIZZORINO, 5700, 5800, Segmento.DECRECIENDO, 41, 31);
		cargarSegmento(VELEZ, 5700, 5800, Segmento.CRECIENDO, 32, 42);
		cargarSegmento(LAPRIDA, 5700, 5800, Segmento.DECRECIENDO, 43, 33);
		cargarSegmento(PIEDRAS, 5700, 5800, Segmento.CRECIENDO, 34, 44);
		cargarSegmento(AV_BROWN, 5700, 5800, Segmento.CRECIENDO, 35, 45);
		cargarSegmento(AV_BROWN, 5700, 5800, Segmento.DECRECIENDO, 45, 35);
		
		cargarSegmento(HUERGO, 1320, 1400, Segmento.CRECIENDO, 37, 36);
		cargarSegmento(HUERGO, 1300, 1320, Segmento.CRECIENDO, 38, 37);
		cargarSegmento(HUERGO, 1200, 1300, Segmento.CRECIENDO, 39, 38);
		cargarSegmento(HUERGO, 1100, 1200, Segmento.CRECIENDO, 40, 39);
		cargarSegmento(HUERGO, 1000, 1100, Segmento.CRECIENDO, 41, 40);
		cargarSegmento(HUERGO, 900, 1000, Segmento.CRECIENDO, 43, 42);
		cargarSegmento(HUERGO, 800, 900, Segmento.CRECIENDO, 44, 43);
		cargarSegmento(HUERGO, 700, 800, Segmento.CRECIENDO, 45, 44);
		
		cargarSegmento(GRAL_PAZ, 5800, 5900, Segmento.CRECIENDO, 36, 46);
		cargarSegmento(GRAL_PAZ, 5800, 5900, Segmento.DECRECIENDO, 46, 36);
		cargarSegmento(ARZAMENDIA, 5800, 5900, Segmento.DECRECIENDO, 47, 38);
		cargarSegmento(AVELLANEDA, 5800, 5900, Segmento.CRECIENDO, 39, 48);
		cargarSegmento(DORREGO, 5800, 5900, Segmento.DECRECIENDO, 49, 40);
		cargarSegmento(DORREGO, 5800, 5900, Segmento.CRECIENDO, 40, 49);
		cargarSegmento(LLERENA, 1000, 1100, Segmento.CRECIENDO, 41, 49);
		cargarSegmento(LLERENA, 1000, 1100, Segmento.DECRECIENDO, 49, 41);
		cargarSegmento(VELEZ, 5800, 5900, Segmento.CRECIENDO, 42, 50);
		cargarSegmento(TACUARI, 5800, 5900, Segmento.DECRECIENDO, 51, 43);
		cargarSegmento(PIEDRAS, 5800, 5900, Segmento.CRECIENDO, 44, 52);
		cargarSegmento(AV_BROWN, 5800, 5900, Segmento.CRECIENDO, 45, 54);
		cargarSegmento(AV_BROWN, 5800, 5900, Segmento.DECRECIENDO, 54, 45);
		
		cargarSegmento(LLERENA, 1300, 1400, Segmento.DECRECIENDO, 46, 47);
		cargarSegmento(LLERENA, 1200, 1300, Segmento.DECRECIENDO, 47, 48);
		cargarSegmento(LLERENA, 1100, 1200, Segmento.DECRECIENDO, 48, 49);
		cargarSegmento(LLERENA, 900, 1000, Segmento.DECRECIENDO, 50, 51);
		cargarSegmento(LLERENA, 800, 900, Segmento.DECRECIENDO, 51, 52);
		cargarSegmento(LLERENA, 700, 800, Segmento.DECRECIENDO, 52, 53);
		cargarSegmento(LLERENA, 680, 700, Segmento.DECRECIENDO, 53, 54);
		
		cargarSegmento(GRAL_PAZ, 5900, 6000, Segmento.CRECIENDO, 46, 55);
		cargarSegmento(GRAL_PAZ, 5900, 6000, Segmento.DECRECIENDO, 55, 46);
		cargarSegmento(ARZAMENDIA, 5900, 6000, Segmento.DECRECIENDO, 56, 47);
		cargarSegmento(AVELLANEDA, 5900, 6000, Segmento.CRECIENDO, 48, 57);
		cargarSegmento(DORREGO, 5900, 5980, Segmento.DECRECIENDO, 59, 49);
		cargarSegmento(DORREGO, 5900, 5980, Segmento.CRECIENDO, 49, 59);
		cargarSegmento(VELEZ, 5900, 5950, Segmento.CRECIENDO, 50, 61);
		cargarSegmento(TACUARI, 5900, 5950, Segmento.DECRECIENDO, 62, 51);
		cargarSegmento(PIEDRAS, 5900, 5950, Segmento.CRECIENDO, 52, 63);
		cargarSegmento(R_GODOY, 5900, 5950, Segmento.DECRECIENDO, 64, 53);
		cargarSegmento(AV_BROWN, 5900, 6000, Segmento.CRECIENDO, 54, 69);
		cargarSegmento(AV_BROWN, 5900, 6000, Segmento.DECRECIENDO, 69, 54);
		
		//99
		cargarSegmento(SASTRE, 900, 1000, Segmento.CRECIENDO, 62, 61);
		cargarSegmento(SASTRE, 800, 900, Segmento.CRECIENDO, 63, 62);
		cargarSegmento(SASTRE, 700, 800, Segmento.CRECIENDO, 64, 63);
		cargarSegmento(VELEZ, 5950, 6000, Segmento.CRECIENDO, 61, 65);
		cargarSegmento(TACUARI, 5950, 6000, Segmento.DECRECIENDO, 66, 62);
		cargarSegmento(PIEDRAS, 5950, 6000, Segmento.CRECIENDO, 63, 67);
		cargarSegmento(R_GODOY, 5950, 6000, Segmento.DECRECIENDO, 68, 64);
		
		cargarSegmento(LAVAISSE, 1250, 1300, Segmento.CRECIENDO, 56, 55);
		cargarSegmento(LAVAISSE, 1200, 1250, Segmento.CRECIENDO, 57, 56);
		cargarSegmento(LAVAISSE, 1120, 1200, Segmento.DECRECIENDO, 58, 57);
		cargarSegmento(LAVAISSE, 1100, 1120, Segmento.CRECIENDO, 60, 58);
		cargarSegmento(GOROSTIAGA, 1150, 1160, Segmento.DECRECIENDO, 58, 59);
		cargarSegmento(DORREGO, 5980, 6000, Segmento.DECRECIENDO, 60, 59);
		cargarSegmento(DORREGO, 5980, 6000, Segmento.CRECIENDO, 59, 60);
		cargarSegmento(LAVAISSE, 1000, 1100, Segmento.CRECIENDO, 65, 60);
		cargarSegmento(LAVAISSE, 900, 1000, Segmento.DECRECIENDO, 65, 66);
		cargarSegmento(LAVAISSE, 800, 900, Segmento.DECRECIENDO, 66, 67);
		cargarSegmento(LAVAISSE, 700, 800, Segmento.DECRECIENDO, 67, 68);
		
		// Sin número
		cargarSegmento(GRAL_PAZ, 6000, 6100, Segmento.CRECIENDO, 55, 70);
		cargarSegmento(GRAL_PAZ, 6000, 6100, Segmento.DECRECIENDO, 70, 55);
		cargarSegmento(AVELLANEDA, 6000, 6100, Segmento.CRECIENDO, 57, 71);
		cargarSegmento(GOROSTIAGA, 1200, 1300, Segmento.DECRECIENDO, 70, 71);
		cargarSegmento(GOROSTIAGA, 1160, 1200, Segmento.DECRECIENDO, 71, 58);
		cargarSegmento(MOSQUERA, 1100, 1200, Segmento.CRECIENDO, 74, 72);
		cargarSegmento(MOSQUERA, 1100, 1200, Segmento.DECRECIENDO, 72, 74);
		cargarSegmento(DORREGO, 6000, 6020, Segmento.DECRECIENDO, 74, 60);
		cargarSegmento(DORREGO, 6000, 6020, Segmento.CRECIENDO, 60, 74);
		cargarSegmento(DORREGO, 6020, 6100, Segmento.DECRECIENDO, 73, 74);
		cargarSegmento(DORREGO, 6020, 6100, Segmento.CRECIENDO, 74, 73);
		cargarSegmento(VELEZ, 6000, 6100, Segmento.CRECIENDO, 65, 76);
		cargarSegmento(TACUARI, 6000, 6100, Segmento.DECRECIENDO, 77, 66);
		cargarSegmento(PIEDRAS, 6000, 6100, Segmento.CRECIENDO, 67, 78);
		cargarSegmento(R_GODOY, 6000, 6100, Segmento.DECRECIENDO, 79, 68);
		cargarSegmento(CULLEN, 6000, 6200, Segmento.CRECIENDO, 69, 91);
		cargarSegmento(AV_BROWN, 6000, 6200, Segmento.CRECIENDO, 69, 93);
		cargarSegmento(AV_BROWN, 6000, 6200, Segmento.DECRECIENDO, 93, 69);
		
		cargarSegmento(GRAL_PAZ, 6100, 6150, Segmento.CRECIENDO, 70, 80);
		cargarSegmento(GRAL_PAZ, 6100, 6150, Segmento.DECRECIENDO, 80, 70);
		cargarSegmento(GRAL_PAZ, 6150, 6200, Segmento.CRECIENDO, 80, 81);
		cargarSegmento(GRAL_PAZ, 6150, 6200, Segmento.DECRECIENDO, 81, 80);
		cargarSegmento(MOSQUERA, 1200, 1300, Segmento.CRECIENDO, 72, 80);
		cargarSegmento(MOSQUERA, 1200, 1300, Segmento.DECRECIENDO, 80, 72);
		cargarSegmento(GOROSTIAGA, 1100, 1150, Segmento.DECRECIENDO, 72, 73);
		cargarSegmento(GOROSTIAGA, 1100, 1150, Segmento.CRECIENDO, 73, 72);
		cargarSegmento(GOROSTIAGA, 1000, 1100, Segmento.DECRECIENDO, 73, 75);
		cargarSegmento(GOROSTIAGA, 1000, 1100, Segmento.CRECIENDO, 75, 73);
		cargarSegmento(GOROSTIAGA, 900, 1000, Segmento.CRECIENDO, 77, 76);
		cargarSegmento(GOROSTIAGA, 800, 900, Segmento.CRECIENDO, 78, 77);
		cargarSegmento(GOROSTIAGA, 700, 800, Segmento.CRECIENDO, 79, 78);
		
		cargarSegmento(DORREGO, 6100, 6200, Segmento.DECRECIENDO, 82, 73);
		cargarSegmento(DORREGO, 6100, 6200, Segmento.CRECIENDO, 73, 82);
		cargarSegmento(PIZZORINO, 6100, 6200, Segmento.DECRECIENDO, 83, 75);
		cargarSegmento(PIZZORINO, 6100, 6200, Segmento.CRECIENDO, 75, 83);
		cargarSegmento(VELEZ, 6100, 6200, Segmento.CRECIENDO, 76, 84);
		cargarSegmento(TACUARI, 6100, 6150, Segmento.DECRECIENDO, 85, 77);
		cargarSegmento(PIEDRAS, 6100, 6150, Segmento.CRECIENDO, 78, 86);
		cargarSegmento(R_GODOY, 6100, 6150, Segmento.DECRECIENDO, 87, 79);
		
		cargarSegmento(ITURRI, 800, 900, Segmento.DECRECIENDO, 85, 86);
		cargarSegmento(ITURRI, 700, 800, Segmento.DECRECIENDO, 86, 87);
		cargarSegmento(TACUARI, 6150, 6200, Segmento.DECRECIENDO, 88, 85);
		cargarSegmento(PIEDRAS, 6150, 6200, Segmento.CRECIENDO, 86, 89);
		cargarSegmento(R_GODOY, 6150, 6200, Segmento.DECRECIENDO, 90, 87);
		
		cargarSegmento(PEDRO_DE_VEGA, 1100, 1200, Segmento.CRECIENDO, 82, 81);
		cargarSegmento(PEDRO_DE_VEGA, 1020, 1100, Segmento.CRECIENDO, 83, 82);
		cargarSegmento(PEDRO_DE_VEGA, 1000, 1020, Segmento.CRECIENDO, 84, 83);
		cargarSegmento(PEDRO_DE_VEGA, 900, 1000, Segmento.CRECIENDO, 88, 84);
		cargarSegmento(PEDRO_DE_VEGA, 800, 900, Segmento.CRECIENDO, 89, 88);
		cargarSegmento(PEDRO_DE_VEGA, 700, 800, Segmento.CRECIENDO, 90, 89);
		cargarSegmento(PEDRO_DE_VEGA, 600, 700, Segmento.CRECIENDO, 91, 90);
		cargarSegmento(PEDRO_DE_VEGA, 500, 600, Segmento.CRECIENDO, 92, 91);
		cargarSegmento(PEDRO_DE_VEGA, 480, 500, Segmento.CRECIENDO, 93, 92);
		
		cargarSegmento(GRAL_PAZ, 6200, 6300, Segmento.CRECIENDO, 81, 94);
		cargarSegmento(GRAL_PAZ, 6200, 6300, Segmento.DECRECIENDO, 94, 81);
		cargarSegmento(DORREGO, 6200, 6300, Segmento.DECRECIENDO, 95, 82);
		cargarSegmento(DORREGO, 6200, 6300, Segmento.CRECIENDO, 82, 95);
		cargarSegmento(VELEZ, 6200, 6300, Segmento.CRECIENDO, 84, 97);
		cargarSegmento(TACUARI, 6200, 6300, Segmento.DECRECIENDO, 98, 88);
		cargarSegmento(PIEDRAS, 6200, 6300, Segmento.CRECIENDO, 89, 99);
		cargarSegmento(A_GODOY, 6200, 6300, Segmento.DECRECIENDO, 100, 90);
		cargarSegmento(CULLEN, 6200, 6300, Segmento.CRECIENDO, 91, 101);
		cargarSegmento(ECHAGUE, 6200, 6300, Segmento.DECRECIENDO, 102, 92);
		cargarSegmento(AV_BROWN, 6200, 6300, Segmento.CRECIENDO, 93, 103);
		cargarSegmento(AV_BROWN, 6200, 6300, Segmento.DECRECIENDO, 103, 93);
		
		cargarSegmento(ALDAO, 1100, 1200, Segmento.DECRECIENDO, 94, 95);
		cargarSegmento(ALDAO, 1050, 1100, Segmento.DECRECIENDO, 95, 96);
		cargarSegmento(ALDAO, 1000, 1050, Segmento.DECRECIENDO, 96, 97);
		cargarSegmento(ALDAO, 900, 1000, Segmento.DECRECIENDO, 97, 98);
		cargarSegmento(ALDAO, 800, 900, Segmento.DECRECIENDO, 98, 99);
		cargarSegmento(ALDAO, 700, 800, Segmento.DECRECIENDO, 99, 100);
		cargarSegmento(ALDAO, 600, 700, Segmento.DECRECIENDO, 100, 101);
		cargarSegmento(ALDAO, 500, 600, Segmento.DECRECIENDO, 101, 102);
		cargarSegmento(ALDAO, 400, 500, Segmento.DECRECIENDO, 102, 103);
		
		cargarSegmento(GRAL_PAZ, 6300, 6400, Segmento.CRECIENDO, 94, 104);
		cargarSegmento(GRAL_PAZ, 6300, 6400, Segmento.DECRECIENDO, 104, 94);
		cargarSegmento(DORREGO, 6300, 6380, Segmento.DECRECIENDO, 106, 95);
		cargarSegmento(DORREGO, 6300, 6380, Segmento.CRECIENDO, 95, 106);
		cargarSegmento(DORREGO, 6380, 6400, Segmento.DECRECIENDO, 105, 106);
		cargarSegmento(DORREGO, 6380, 6400, Segmento.CRECIENDO, 106, 105);
		cargarSegmento(VELEZ, 6300, 6400, Segmento.CRECIENDO, 97, 107);
		cargarSegmento(TACUARI, 6300, 6400, Segmento.DECRECIENDO, 108, 98);
		cargarSegmento(PIEDRAS, 6300, 6400, Segmento.CRECIENDO, 99, 109);
		cargarSegmento(A_GODOY, 6300, 6400, Segmento.DECRECIENDO, 110, 100);
		cargarSegmento(CULLEN, 6300, 6400, Segmento.CRECIENDO, 101, 111);
		cargarSegmento(ECHAGUE, 6300, 6400, Segmento.DECRECIENDO, 112, 102);
		cargarSegmento(AV_BROWN, 6300, 6400, Segmento.CRECIENDO, 103, 114);
		cargarSegmento(AV_BROWN, 6300, 6400, Segmento.DECRECIENDO, 114, 103);
		
		cargarSegmento(CASSANELLO, 1100, 1150, Segmento.DECRECIENDO, 104, 105);
		cargarSegmento(CASSANELLO, 1100, 1150, Segmento.CRECIENDO, 105, 104);
		cargarSegmento(CASSANELLO, 1000, 1100, Segmento.DECRECIENDO, 105, 107);
		cargarSegmento(CASSANELLO, 1000, 1100, Segmento.CRECIENDO, 107, 105);
		cargarSegmento(CASSANELLO, 900, 1000, Segmento.DECRECIENDO, 107, 108);
		cargarSegmento(CASSANELLO, 900, 1000, Segmento.CRECIENDO, 108, 107);
		cargarSegmento(CASSANELLO, 800, 900, Segmento.DECRECIENDO, 108, 109);
		cargarSegmento(CASSANELLO, 800, 900, Segmento.CRECIENDO, 109, 108);
		cargarSegmento(CASSANELLO, 700, 800, Segmento.DECRECIENDO, 109, 110);
		cargarSegmento(CASSANELLO, 700, 800, Segmento.CRECIENDO, 110, 109);
		cargarSegmento(CASSANELLO, 600, 700, Segmento.DECRECIENDO, 110, 111);
		cargarSegmento(CASSANELLO, 600, 700, Segmento.CRECIENDO, 111, 110);
		cargarSegmento(CASSANELLO, 500, 600, Segmento.DECRECIENDO, 111, 112);
		cargarSegmento(CASSANELLO, 500, 600, Segmento.CRECIENDO, 112, 111);
		cargarSegmento(CASSANELLO, 400, 500, Segmento.DECRECIENDO, 112, 113);
		cargarSegmento(CASSANELLO, 400, 500, Segmento.CRECIENDO, 113, 112);
		cargarSegmento(CASSANELLO, 350, 400, Segmento.DECRECIENDO, 113, 114);
		cargarSegmento(CASSANELLO, 350, 400, Segmento.CRECIENDO, 114, 113);
		
		cargarSegmento(GRAL_PAZ, 6400, 6500, Segmento.CRECIENDO, 104, 115);
		cargarSegmento(GRAL_PAZ, 6400, 6500, Segmento.DECRECIENDO, 115, 104);
		cargarSegmento(VELEZ, 6400, 6500, Segmento.CRECIENDO, 107, 118);
		cargarSegmento(TACUARI, 6400, 6500, Segmento.DECRECIENDO, 119, 108);
		cargarSegmento(PIEDRAS, 6400, 6500, Segmento.CRECIENDO, 109, 120);
		cargarSegmento(A_GODOY, 6400, 6500, Segmento.DECRECIENDO, 121, 110);
		cargarSegmento(CULLEN, 6400, 6500, Segmento.CRECIENDO, 111, 122);
		cargarSegmento(ECHAGUE, 6400, 6500, Segmento.DECRECIENDO, 123, 112);
		cargarSegmento(TALCAHUANO, 6400, 6500, Segmento.CRECIENDO, 113, 124);
		cargarSegmento(AV_BROWN, 6400, 6500, Segmento.CRECIENDO, 114, 126);
		cargarSegmento(AV_BROWN, 6400, 6500, Segmento.DECRECIENDO, 126, 114);
		
		cargarSegmento(LOPEZ, 1100, 1150, Segmento.DECRECIENDO, 115, 116);
		cargarSegmento(LOPEZ, 1050, 1100, Segmento.DECRECIENDO, 116, 117);
		cargarSegmento(LOPEZ, 1000, 1050, Segmento.DECRECIENDO, 117, 118);
		cargarSegmento(LOPEZ, 900, 1000, Segmento.DECRECIENDO, 118, 119);
		cargarSegmento(LOPEZ, 800, 900, Segmento.DECRECIENDO, 119, 120);
		cargarSegmento(LOPEZ, 700, 800, Segmento.DECRECIENDO, 120, 121);
		cargarSegmento(LOPEZ, 600, 700, Segmento.DECRECIENDO, 121, 122);
		cargarSegmento(LOPEZ, 500, 600, Segmento.DECRECIENDO, 122, 123);
		cargarSegmento(LOPEZ, 400, 500, Segmento.DECRECIENDO, 123, 124);
		cargarSegmento(LOPEZ, 300, 400, Segmento.DECRECIENDO, 124, 125);
		cargarSegmento(LOPEZ, 250, 300, Segmento.DECRECIENDO, 125, 126);
		
		cargarSegmento(GRAL_PAZ, 6500, 6600, Segmento.CRECIENDO, 115, 132);
		cargarSegmento(GRAL_PAZ, 6500, 6600, Segmento.DECRECIENDO, 132, 115);
		cargarSegmento(VELEZ, 6500, 6600, Segmento.CRECIENDO, 118, 133);
		cargarSegmento(TACUARI, 6500, 6550, Segmento.DECRECIENDO, 127, 119);
		cargarSegmento(PIEDRAS, 6500, 6550, Segmento.CRECIENDO, 120, 128);
		cargarSegmento(A_GODOY, 6500, 6550, Segmento.DECRECIENDO, 129, 121);
		cargarSegmento(CULLEN, 6500, 6550, Segmento.CRECIENDO, 122, 130);
		cargarSegmento(ECHAGUE, 6500, 6550, Segmento.DECRECIENDO, 131, 123);
		cargarSegmento(TALCAHUANO, 6500, 6600, Segmento.CRECIENDO, 124, 139);
		cargarSegmento(DEFENSA, 6500, 6600, Segmento.DECRECIENDO, 140, 125);
		cargarSegmento(AV_BROWN, 6500, 6600, Segmento.CRECIENDO, 126, 141);
		cargarSegmento(AV_BROWN, 6500, 6600, Segmento.DECRECIENDO, 141, 126);
		
		cargarSegmento(PUJATO, 800, 900, Segmento.DECRECIENDO, 127, 128);
		cargarSegmento(PUJATO, 800, 900, Segmento.CRECIENDO, 128, 127);
		cargarSegmento(PUJATO, 600, 700, Segmento.DECRECIENDO, 129, 130);
		cargarSegmento(PUJATO, 600, 700, Segmento.CRECIENDO, 130, 129);
		cargarSegmento(PUJATO, 500, 600, Segmento.DECRECIENDO, 130, 131);
		cargarSegmento(PUJATO, 500, 600, Segmento.CRECIENDO, 131, 130);

		cargarSegmento(TACUARI, 6550, 6600, Segmento.DECRECIENDO, 134, 127);
		cargarSegmento(PIEDRAS, 6550, 6600, Segmento.CRECIENDO, 128, 135);
		cargarSegmento(A_GODOY, 6550, 6600, Segmento.DECRECIENDO, 136, 129);
		cargarSegmento(CULLEN, 6550, 6600, Segmento.CRECIENDO, 130, 137);
		cargarSegmento(ECHAGUE, 6550, 6600, Segmento.DECRECIENDO, 138, 131);
		
		cargarSegmento(HERNANDARIAS, 1000, 1100, Segmento.CRECIENDO, 133, 132);
		cargarSegmento(HERNANDARIAS, 900, 1000, Segmento.CRECIENDO, 134, 133);
		cargarSegmento(HERNANDARIAS, 800, 900, Segmento.CRECIENDO, 135, 134);
		cargarSegmento(HERNANDARIAS, 700, 800, Segmento.CRECIENDO, 136, 135);
		cargarSegmento(HERNANDARIAS, 600, 700, Segmento.CRECIENDO, 137, 136);
		cargarSegmento(HERNANDARIAS, 500, 600, Segmento.CRECIENDO, 138, 137);
		cargarSegmento(HERNANDARIAS, 400, 500, Segmento.CRECIENDO, 139, 138);
		cargarSegmento(HERNANDARIAS, 300, 400, Segmento.CRECIENDO, 140, 139);
		cargarSegmento(HERNANDARIAS, 200, 300, Segmento.CRECIENDO, 141, 140);
		
		cargarSegmento(GRAL_PAZ, 6600, 6700, Segmento.CRECIENDO, 132, 142);
		cargarSegmento(GRAL_PAZ, 6600, 6700, Segmento.DECRECIENDO, 142, 132);
		cargarSegmento(VELEZ, 6600, 6700, Segmento.CRECIENDO, 133, 143);
		cargarSegmento(TACUARI, 6600, 6700, Segmento.DECRECIENDO, 144, 134);
		cargarSegmento(PIEDRAS, 6600, 6700, Segmento.CRECIENDO, 135, 145);
		cargarSegmento(A_GODOY, 6600, 6700, Segmento.DECRECIENDO, 146, 136);
		cargarSegmento(CULLEN, 6600, 6700, Segmento.CRECIENDO, 137, 147);
		cargarSegmento(ECHAGUE, 6600, 6700, Segmento.DECRECIENDO, 148, 138);
		cargarSegmento(TALCAHUANO, 6600, 6700, Segmento.CRECIENDO, 139, 149);
		cargarSegmento(DEFENSA, 6600, 6700, Segmento.DECRECIENDO, 150, 140);
		cargarSegmento(RIOBAMBA, 6650, 6700, Segmento.CRECIENDO, 151, 152);
		cargarSegmento(AV_BROWN, 6600, 6650, Segmento.CRECIENDO, 141, 151);
		cargarSegmento(AV_BROWN, 6600, 6650, Segmento.DECRECIENDO, 151, 141);
		cargarSegmento(AV_BROWN, 6650, 6700, Segmento.CRECIENDO, 151, 153);
		cargarSegmento(AV_BROWN, 6650, 6700, Segmento.DECRECIENDO, 153, 151);
		
		cargarSegmento(CASTELLI, 1000, 1100, Segmento.DECRECIENDO, 142, 143);
		cargarSegmento(CASTELLI, 900, 1000, Segmento.DECRECIENDO, 143, 144);
		cargarSegmento(CASTELLI, 800, 900, Segmento.DECRECIENDO, 144, 145);
		cargarSegmento(CASTELLI, 700, 800, Segmento.DECRECIENDO, 145, 146);
		cargarSegmento(CASTELLI, 600, 700, Segmento.DECRECIENDO, 146, 147);
		cargarSegmento(CASTELLI, 500, 600, Segmento.DECRECIENDO, 147, 148);
		cargarSegmento(CASTELLI, 400, 500, Segmento.DECRECIENDO, 148, 149);
		cargarSegmento(CASTELLI, 300, 400, Segmento.DECRECIENDO, 149, 150);
		cargarSegmento(CASTELLI, 200, 300, Segmento.DECRECIENDO, 150, 152);
		cargarSegmento(CASTELLI, 150, 200, Segmento.DECRECIENDO, 152, 153);
		
		cargarSegmento(GRAL_PAZ, 6700, 6800, Segmento.CRECIENDO, 142, 154);
		cargarSegmento(GRAL_PAZ, 6700, 6800, Segmento.DECRECIENDO, 154, 142);
		cargarSegmento(VELEZ, 6700, 6800, Segmento.CRECIENDO, 143, 155);
		cargarSegmento(TACUARI, 6700, 6800, Segmento.DECRECIENDO, 156, 144);
		cargarSegmento(PIEDRAS, 6700, 6800, Segmento.CRECIENDO, 145, 157);
		cargarSegmento(A_GODOY, 6700, 6800, Segmento.DECRECIENDO, 158, 146);
		cargarSegmento(CULLEN, 6700, 6800, Segmento.CRECIENDO, 147, 159);
		cargarSegmento(ECHAGUE, 6700, 6800, Segmento.DECRECIENDO, 160, 148);
		cargarSegmento(TALCAHUANO, 6700, 6800, Segmento.CRECIENDO, 149, 161);
		cargarSegmento(DEFENSA, 6700, 6800, Segmento.DECRECIENDO, 162, 150);
		cargarSegmento(RIOBAMBA, 6700, 6800, Segmento.CRECIENDO, 152, 163);
		cargarSegmento(AV_BROWN, 6700, 6800, Segmento.CRECIENDO, 153, 164);
		cargarSegmento(AV_BROWN, 6700, 6800, Segmento.DECRECIENDO, 164, 153);
		
		cargarSegmento(ZEBALLOS, 1000, 1050, Segmento.CRECIENDO, 142, 143);
		cargarSegmento(ZEBALLOS, 900, 1000, Segmento.CRECIENDO, 143, 144);
		cargarSegmento(ZEBALLOS, 800, 900, Segmento.CRECIENDO, 144, 145);
		cargarSegmento(ZEBALLOS, 700, 800, Segmento.CRECIENDO, 145, 146);
		cargarSegmento(ZEBALLOS, 600, 700, Segmento.CRECIENDO, 146, 147);
		cargarSegmento(ZEBALLOS, 500, 600, Segmento.CRECIENDO, 147, 148);
		cargarSegmento(ZEBALLOS, 400, 500, Segmento.CRECIENDO, 148, 149);
		cargarSegmento(ZEBALLOS, 300, 400, Segmento.CRECIENDO, 149, 150);
		cargarSegmento(ZEBALLOS, 200, 300, Segmento.CRECIENDO, 150, 152);
		cargarSegmento(ZEBALLOS, 100, 200, Segmento.CRECIENDO, 152, 153);
		
		cargarSegmento(GRAL_PAZ, 6800, 6850, Segmento.CRECIENDO, 154, 165);
		cargarSegmento(GRAL_PAZ, 6800, 6850, Segmento.DECRECIENDO, 165, 154);
		cargarSegmento(GRAL_PAZ, 6850, 6900, Segmento.CRECIENDO, 165, 167);
		cargarSegmento(GRAL_PAZ, 6850, 6900, Segmento.DECRECIENDO, 167, 165);
		cargarSegmento(TACUARI, 6800, 6900, Segmento.DECRECIENDO, 168, 156);
		cargarSegmento(PIEDRAS, 6800, 6900, Segmento.CRECIENDO, 157, 169);
		cargarSegmento(A_GODOY, 6800, 6900, Segmento.DECRECIENDO, 170, 158);
		cargarSegmento(CULLEN, 6800, 6900, Segmento.CRECIENDO, 159, 171);
		cargarSegmento(ECHAGUE, 6800, 6900, Segmento.DECRECIENDO, 172, 160);
		cargarSegmento(TALCAHUANO, 6800, 6900, Segmento.CRECIENDO, 161, 173);
		cargarSegmento(DEFENSA, 6800, 6900, Segmento.DECRECIENDO, 174, 162);
		cargarSegmento(RIOBAMBA, 6800, 6900, Segmento.CRECIENDO, 163, 175);
		cargarSegmento(AV_BROWN, 6800, 6900, Segmento.CRECIENDO, 164, 176);
		cargarSegmento(AV_BROWN, 6800, 6900, Segmento.DECRECIENDO, 176, 164);
		
		cargarSegmento(PASAJE, 1000, 1050, Segmento.DECRECIENDO, 165, 166);
		cargarSegmento(PASAJE, 1000, 1050, Segmento.CRECIENDO, 166, 165);
		cargarSegmento(BONEO, 900, 1050, Segmento.DECRECIENDO, 167, 168);
		cargarSegmento(BONEO, 800, 900, Segmento.DECRECIENDO, 168, 169);
		cargarSegmento(BONEO, 700, 800, Segmento.DECRECIENDO, 169, 170);
		cargarSegmento(BONEO, 600, 700, Segmento.DECRECIENDO, 170, 171);
		cargarSegmento(BONEO, 500, 600, Segmento.DECRECIENDO, 171, 172);
		cargarSegmento(BONEO, 400, 500, Segmento.DECRECIENDO, 172, 173);
		cargarSegmento(BONEO, 300, 400, Segmento.DECRECIENDO, 173, 174);
		cargarSegmento(BONEO, 200, 300, Segmento.DECRECIENDO, 174, 175);
		cargarSegmento(BONEO, 150, 200, Segmento.DECRECIENDO, 175, 176);
		
	}
}