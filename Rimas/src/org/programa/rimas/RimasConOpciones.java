package org.programa.rimas;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

/*
 * llamada por:		Rimas.java.
 * llama a:			rimasconopciones.xml
 *  
 * El campo introducido en la anterior pantalla (Rimas.java), aparece en vez de centrado como antes, en la parte de arriba y con el valor del campo que hayamos introducido.
 * Es la misma pantalla que la anterior, salvo lo que acabo de comentar, y con un nuevo campo (un Spinner) d�nde podemos introducir las opciones de b�squeda.
 */
public class RimasConOpciones extends Activity implements OnClickListener {
	
	private EditText etPalabraBuscar2;
	private Button btSearch2;
	private Bundle bundle;
	private Spinner spOpcionesRimas;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rimasconopciones);
		
		inicializarVariables();
		
		recogerDatosOtraAcitivity();
		
		llenarListaRimasConOpciones();
	
		
		btSearch2.setOnClickListener(this);  // registramos el bot�n para quede ligado a �l el evento onClick
		
	}

	/*
	 * Llenamos, el Spinner, de opciones.
	 */
	private void llenarListaRimasConOpciones() {
		// TODO Auto-generated method stub
		
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.opcionesrimas, android.R.layout.simple_spinner_item); // en Res/arrays, tenemos opcionesrimas...
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOpcionesRimas.setAdapter(adapter);
        
        /*
         * al seleccionar un item del Spinner, sacamos un mensaje por pantalla...
         */
        spOpcionesRimas.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        showToast("Please, press button Search...");
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        showToast("Spinner1: unselected");
                    }
                });
		
	}

	/*
	 * Recogemos el dato mandado de Activity Rimas.java y lo insertamos en etPalabraBuscar2.
	 */
	private void recogerDatosOtraAcitivity() {
		// TODO Auto-generated method stub
		bundle = getIntent().getExtras(); // recogemos
		etPalabraBuscar2.setText(bundle.getString("PalabraBuscar"));  // insertamos
		
	}

	/*
	 * M�todo para inicializar todas las variables. Uniendo la parte l�gica con la parte visual(ficheros xml)
	 */
	private void inicializarVariables() {
		// TODO Auto-generated method stub
		etPalabraBuscar2 = (EditText) findViewById(R.id.etPalabraBuscar2); // recogemos el elemento correspondiente (etPalabraBuscar2) del fichero xml (rimasconopciones.xml)
		btSearch2 = (Button) findViewById(R.id.btSearch2); // recogemos el elemento correspondiente (btSearch2) del fichero xml (rimasconopciones.xml)
		spOpcionesRimas = (Spinner) findViewById(R.id.spOpcionesRimas); // recogemos el elemento correspondiente (spOpcionesRimas) del fichero xml (rimasconopciones.xml)
		
	}

	/*
	 * Este m�todo es llamado, cuando se produce el envento onClickListener, sobre el bot�n btSearch2.
	 * El proceso que realiza �ste m�todo es llamar a la Activity RimasResultado (RimasResultado.java) pas�ndole como par�metro "PalabraBuscar". (y ver PENDIENTE).
	 * "PalabraBuscar" contiene el dato recogido de la variable etPalabraBuscar2, la cual, anteriormente hab�a recogido el dato introducido por el usuario.
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// Aviso, mediante Intent, al sistema operativo, de que debe mostrar la Activity RimasPorSilabasyAcentos.java
		Intent b = new Intent(this, RimasResultado.class);
		b.putExtra("PalabraBuscar2", etPalabraBuscar2.getText().toString()); // introducimos el par�metro, que queremos que pase a la Activity.
		/* ********************************************************************************************************************************************
		 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ----
		 * 
		 * TENEMOS QUE MANDAR EL ELEMENTO SELECCIONADO DEL SPINNER, llamado spOpcionesRimas (rimasconopciones.xml) ( P E N D I E N T E)
		 *
		 * P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- P E N D I E N T E ---- 
		 * ********************************************************************************************************************************************/
		startActivity(b); // Empieza la llamada a la Activity...
		
	}
	
	/*
	 * M�todo para mostrar por pantalla mensaje...
	 */
	void showToast(CharSequence msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}
