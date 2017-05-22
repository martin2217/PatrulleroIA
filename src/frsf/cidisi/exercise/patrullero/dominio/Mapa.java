package frsf.cidisi.exercise.patrullero.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
	private void cargarNodo(String cod, ArrayList<String> calles){
		Nodo n1;
		n1=new Nodo(cod, calles); // Se crea el nodo
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
	private final String GODOY = "Ruperto Godoy";
	private final String HUERGO = "D Huergo";
	private final String ARZAMENDIA = "Pje Arzamendia";
	private final String LLERENA = "Llerena";
	private final String SASTRE = "Marco Sastre";
	private final String LAVAISSE = "Lavaisse";
	private final String GOROSTIAGA = "Gorostiaga";
	private final String MOSQUERA = "Mosquera";
	private final String ITURRI = "Pje Iturri";
	
	private final String TACUARI = "Tacuarí";
	private final String PIEDRAS = "Piedras";
	private final String A_GODOY = "Antonia Godoy";
	private final String ECHAGUE = "Echagüe";
	private final String CASANELLO = "Ángel Cassanello";
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
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Güemes")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Avellaneda")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Pje Pizzorino")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Laprida")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(GODOY, "Av Almirante Brown")));
		
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
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Pje Pizzorino")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList(ITURRI, "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList(ITURRI, "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList(ITURRI, "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Patricio Cullen")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", "Echagüe")));
		ls.add(new ArrayList<String>(Arrays.asList("Pedro de Vega", AV_BROWN)));
		
		//94
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Dorrego")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Vélez Sársfield")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Tacuarí")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Piedras")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Antonia Godoy")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Patricio Cullen")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", "Echagüe")));
		ls.add(new ArrayList<String>(Arrays.asList("Ricardo Aldao", AV_BROWN)));
		
		//104
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, GRAL_PAZ)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO)));
		ls.add(new ArrayList<String>(Arrays.asList(DORREGO)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, VELEZ)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, TACUARI)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, PIEDRAS)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, A_GODOY)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, CULLEN)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, ECHAGUE)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, TALCAHUANO)));
		ls.add(new ArrayList<String>(Arrays.asList(CASANELLO, AV_BROWN)));
		
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
		
		
		// Creación de los nodos
		for (int i=1; i<=176; i++){
			cargarNodo(String.valueOf(i),ls.get(i-1));
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
		
		cargarSegmento(GODOY, 1300, 1400, Segmento.DECRECIENDO, 27, 28);
		cargarSegmento(GODOY, 1200, 1300, Segmento.DECRECIENDO, 28, 29);
		cargarSegmento(GODOY, 1100, 1200, Segmento.DECRECIENDO, 29, 30);
		cargarSegmento(GODOY, 1000, 1100, Segmento.DECRECIENDO, 30, 31);
		cargarSegmento(GODOY, 900, 1000, Segmento.DECRECIENDO, 32, 33);
		cargarSegmento(GODOY, 800, 900, Segmento.DECRECIENDO, 33, 34);
		cargarSegmento(GODOY, 780, 800, Segmento.DECRECIENDO, 34, 35);
		
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
		cargarSegmento(GODOY, 5900, 5950, Segmento.DECRECIENDO, 64, 53);
		cargarSegmento(AV_BROWN, 5900, 6000, Segmento.CRECIENDO, 54, 69);
		cargarSegmento(AV_BROWN, 5900, 6000, Segmento.DECRECIENDO, 69, 54);
		
		//99
		cargarSegmento(SASTRE, 900, 1000, Segmento.CRECIENDO, 62, 61);
		cargarSegmento(SASTRE, 800, 900, Segmento.CRECIENDO, 63, 62);
		cargarSegmento(SASTRE, 700, 800, Segmento.CRECIENDO, 64, 63);
		cargarSegmento(VELEZ, 5950, 6000, Segmento.CRECIENDO, 61, 65);
		cargarSegmento(TACUARI, 5950, 6000, Segmento.DECRECIENDO, 66, 62);
		cargarSegmento(PIEDRAS, 5950, 6000, Segmento.CRECIENDO, 63, 67);
		cargarSegmento(GODOY, 5950, 6000, Segmento.DECRECIENDO, 68, 64);
		
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
		cargarSegmento(GODOY, 6000, 6100, Segmento.DECRECIENDO, 79, 68);
		cargarSegmento(CULLEN, 6000, 6200, Segmento.CRECIENDO, 69, 91);
		cargarSegmento(AV_BROWN, 6000, 6200, Segmento.CRECIENDO, 69, 93);
		cargarSegmento(AV_BROWN, 6000, 6200, Segmento.DECRECIENDO, 93, 69);
		
		cargarSegmento(GRAL_PAZ, 6100, 6150, Segmento.CRECIENDO, 70, 80);
		cargarSegmento(GRAL_PAZ, 6100, 6150, Segmento.DECRECIENDO, 80, 70);
		cargarSegmento(GRAL_PAZ, 6150, 6200, Segmento.CRECIENDO, 80, 81);
		cargarSegmento(GRAL_PAZ, 6150, 6200, Segmento.DECRECIENDO, 81, 80);
		cargarSegmento(MOSQUERA, 1200, 1300, Segmento.CRECIENDO, 72, 80);
		cargarSegmento(MOSQUERA, 1200, 1300, Segmento.DECRECIENDO, 80, 72);
		cargarSegmento(GOROSTIAGA, 110, 1150, Segmento.DECRECIENDO, 72, 73);
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
		cargarSegmento(GODOY, 6100, 6150, Segmento.DECRECIENDO, 87, 79);
		
		cargarSegmento(ITURRI, 800, 900, Segmento.DECRECIENDO, 85, 86);
		cargarSegmento(ITURRI, 700, 800, Segmento.DECRECIENDO, 86, 87);
		cargarSegmento(TACUARI, 6150, 6200, Segmento.DECRECIENDO, 88, 85);
		cargarSegmento(PIEDRAS, 6150, 6200, Segmento.CRECIENDO, 86, 89);
		cargarSegmento(GODOY, 6150, 6200, Segmento.DECRECIENDO, 90, 87);
	}
}
