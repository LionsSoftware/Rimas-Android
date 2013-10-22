package org.programa.rimas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/*
 * Esta Activity es llamada por Splash.java. Se trata de una Activity
 * que se encarga de llamar al fichero xml (incluido en res/layout) denominado "rimas.xml".
 * Lo que hace esta pantalla es mostrar un campo, para introducir una palabra, de la que queremos 
 * obtener su rima...
 */
public class Rimas extends Activity implements OnClickListener  {

	private EditText etPalabraBuscar;
	private Button btSearch;
	
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rimas);
		
		inicializarVariables();
				
		btSearch.setOnClickListener(this);  // registramos el bot�n para quede ligado a �l el evento onClick
    }
	
	/*
	 * M�todo para inicializar todas las variables. Uniendo la parte l�gica con la parte visual(ficheros xml)
	 */
	private void inicializarVariables() {
		// TODO Auto-generated method stub
		etPalabraBuscar = (EditText) findViewById(R.id.etPalabraBuscar); // recogemos el elemento correspondiente (etPalabraBuscar) del fichero xml (rimas.xml)
		btSearch = (Button) findViewById(R.id.btSearch); // recogemos el elemento correspondiente (btSearch) del fichero xml (rimas.xml)
	}

	/*
	 * Este m�todo es llamado, cuando se produce el envento onClickListener, sobre el bot�n btSearch.
	 * El proceso que realiza �ste m�todo es llamar a la Activity RimasConOpciones (RimasConOpciones.java) pas�ndole como par�metro "PalabraBuscar".
	 * "PalabraBuscar" contiene el dato recogido de la variable etPalabraBuscar, la cual, anteriormente hab�a recogido el dato introducido por el usuario.
	 */
	@Override
	public void onClick(View arg0) {
		
		// Aviso, mediante Intent, al sistema operativo, de que debe mostrar la Activity RimasPorSilabasyAcentos.java
		Intent a = new Intent(this, RimasConOpciones.class);
		a.putExtra("PalabraBuscar", etPalabraBuscar.getText().toString()); // introducimos el par�metro, que queremos que pase a la Activity.
		startActivity(a); // Empieza la llamada a la Activity...
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
