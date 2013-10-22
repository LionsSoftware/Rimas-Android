package org.programa.rimas;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TabHost;


/****************************************************************************************************************************************************************************
 * Programa: 		Rimas																																		         	*
 * Programador: 	Pablo Belda Bilbao 																																		*
 * fecha: 			14-Oct-2013               																																*
 ****************************************************************************************************************************************************************************
 *
 * Pantalla que se muestra nada mas empezar el programa, con música de fondo, y que espera 7 segundos para a continuación desparecer y dar paso al menú: Rimas.java, 
 * que contendrá un campo de búsqueda...
 */
public class Splash extends Activity{

	MediaPlayer ourSong;
	
	
	@Override
	protected void onCreate(Bundle mochila) {
		// TODO Auto-generated method stub
		super.onCreate(mochila);
		setContentView(R.layout.splash); // llama a pantalla xml que contiene un monito..
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.splashsound); //Crea un MediaPlayer... recogiendo un fichero mp3 (res/raw/splashsound.mp3)
		
		// Llama a res/xml/prefs.xml
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if (music == true)
			ourSong.start();
		
		// hilo para pasar a la siguiente pantalla	
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(7000); // espera 7 milisegundos (7 segundos) antes de mostrar el error o la siquiente pantalla					
				} catch (InterruptedException e){ // Errores
					e.printStackTrace();
				}finally{ // Se muestra si o sí...
					// Aviso, mediante Intent, al sistema operativo, de que debe mostrar la Activity, que muestra el campo a buscar..
					Intent openStartingPoint = new Intent("org.programa.rimas.RIMAS");
					startActivity(openStartingPoint);
				}
			}
		};
		// lanza el hilo timer...
		timer.start();
	}

	
	/*
	 * Cuando se llama a MainMenu.java, este método se lanza y quita la música (ourSong) y cierra la pantalla Splash.java.
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release(); // quita la música
		finish(); // cierra esta Activity
	}
}
