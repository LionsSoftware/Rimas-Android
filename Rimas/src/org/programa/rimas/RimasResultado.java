package org.programa.rimas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;

/*
 * llamada por:		RimasConOpciones.java.
 * llama a:			rimasresultado.xml
 *  
 * El campo introducido en la anterior pantalla (RimasConOpciones.java), aparece en la parte de arriba y con el valor del campo que hallamos introducido.
 * Es la misma pantalla que la anterior, salvo el campo spinner (opciones), y con un nuevo campo (un listview), donde aparecen los resultados (las palabras
 * que riman con la palabra introducida en el EditText). 
 * Podemos picar sobre cualquier palabra que hemos obtenido como resultado, y obtener la definición de la misma según la RAE o el diccionario que utilizemos como
 * BBDD.
 */
public class RimasResultado extends Activity{

	private EditText etPalabraBuscar3;
	private Bundle bundle2;
	private Button btSearch3;
	
	
//	private static final String NAME = "NAME";
//    private static final String IS_EVEN = "IS_EVEN";
//    private ExpandableListAdapter mAdapter;
    
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rimasresultado);
		
		inicializaVariable();
		
		recogerDatosOtraAcitivity();
		
		procesoObenerResultadoBusqueda();
		
		
	}

	/*
	 * Conexión BBDD, volcado de resultado obtenido en Listview...
	 */
	private void procesoObenerResultadoBusqueda() {
		// TODO Auto-generated method stub
		
		/* ********************************************************************************************************************************************
		 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ----
		 * 
		 * Aqui va la Conexión con la BBDD (local o en el Servidor --> no se sabe todavía), para luego obtener el resultado y volcarlo sobre
		 * el ListView  ( P E N D I E N T E)
		 *
		 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- 
		 * ********************************************************************************************************************************************/
		
//		volcarResultado();
		ListaExpanndible2 uno = new ListaExpanndible2();
	}

//	private void volcarResultado() {
//		// TODO Auto-generated method stub
//		
//		 List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
//	        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
//	        for (int i = 0; i < 20; i++) {
//	            Map<String, String> curGroupMap = new HashMap<String, String>();
//	            groupData.add(curGroupMap);
//	            curGroupMap.put(NAME, "Group " + i);
//	            curGroupMap.put(IS_EVEN, (i % 2 == 0) ? "This group is even" : "This group is odd");
//	            
//	            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
//	            for (int j = 0; j < 15; j++) {
//	                Map<String, String> curChildMap = new HashMap<String, String>();
//	                children.add(curChildMap);
//	                curChildMap.put(NAME, "Child " + j);
//	                curChildMap.put(IS_EVEN, (j % 2 == 0) ? "This child is even" : "This child is odd");
//	            }
//	            childData.add(children);
//	        }
//	        
//	        // Set up our adapter
//	        mAdapter = new SimpleExpandableListAdapter(
//	                this,
//	                groupData,
//	                android.R.layout.simple_expandable_list_item_1,
//	                new String[] { NAME, IS_EVEN },
//	                new int[] { android.R.id.text1, android.R.id.text2 },
//	                childData,
//	                android.R.layout.simple_expandable_list_item_2,
//	                new String[] { NAME, IS_EVEN },
//	                new int[] { android.R.id.text1, android.R.id.text2 }
//	                );
//	        setListAdapter(mAdapter);
//		
//	}

	/*
	 * Recogemos los datos mandados de Activity RimasConOpciones.java.  Insertamos dato recibido: "PalabraBuscar2", en etPalabraBuscar3.
	 */
	private void recogerDatosOtraAcitivity() {
		// TODO Auto-generated method stub
		bundle2 = getIntent().getExtras(); // recogemos
		etPalabraBuscar3.setText(bundle2.getString("PalabraBuscar2"));  // insertamos
		/* ********************************************************************************************************************************************
		 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ----
		 * 
		 * TENEMOS QUE RECOGER EL ELEMENTO DE SPINNER, osea la opción seleccionada en la otra pantalla ( P E N D I E N T E)
		 *
		 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- 
		 * ********************************************************************************************************************************************/
		
	}

	/*
	 * Método para inicializar todas las variables. Uniendo la parte lógica con la parte visual(ficheros xml)
	 */
	private void inicializaVariable() {
		// TODO Auto-generated method stub
		etPalabraBuscar3 = (EditText) findViewById(R.id.etPalabraBuscar3); // recogemos el elemento correspondiente (etPalabraBuscar3) del fichero xml (rimasresultado.xml)
		btSearch3 = (Button) findViewById(R.id.btSearch3); // recogemos el elemento correspondiente (btSearch3) del fichero xml (rimasresultado.xml)
		
		
	}

}
