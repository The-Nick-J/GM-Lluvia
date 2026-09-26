package puppy.code;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
    private Array<ComportamientoGota> gotas;
    private long lastDropTime;
    private Texture gotaBuena;
    private Texture gotaMala;
    private Sound dropSound;
    private Music rainMusic;
	   
	public Lluvia(Texture gotaBuena, Texture gotaMala, Sound ss, Music mm) {
		rainMusic = mm;
		dropSound = ss;
		this.gotaBuena = gotaBuena;
		this.gotaMala = gotaMala;
	}
	
	public void crear() {
		gotas = new Array<ComportamientoGota>();
		crearGotaDeLluvia();
	      // start the playback of the background music immediately
	      rainMusic.setLooping(true);
	      rainMusic.play();
	}
	
	private void crearGotaDeLluvia() {
	      float posicionX = MathUtils.random(0, 800-64);
	      if (MathUtils.random(1,10)<5)
	         gotas.add(new GotaMala(gotaMala, posicionX));
	      else
	         gotas.add(new GotaBuena(gotaBuena, posicionX, dropSound));
	      lastDropTime = TimeUtils.nanoTime();
	   }
	
   public boolean actualizarMovimiento(Tarro tarro) { 
	   // generar gotas de lluvia 
	   if(TimeUtils.nanoTime() - lastDropTime > 100000000) crearGotaDeLluvia();
	  
	   
	   // revisar si las gotas cayeron al suelo o chocaron con el tarro
	   for (int i=0; i < gotas.size; i++ ) {
	      ComportamientoGota gota = gotas.get(i);
	      gota.actualizarMovimiento();
	      //cae al suelo y se elimina
	      if(gota.getArea().y + 64 < 0) {
	    	  gotas.removeIndex(i);
	    	  i--;
	    	  continue;
	      }
	      if(gota.getArea().overlaps(tarro.getArea())) {
	    	  gota.aplicarEfecto(tarro);
	    	  if (tarro.getVidas()<=0)
	    		 return false;
	    	  gotas.removeIndex(i);
	    	  i--;
	      }
	   } 
	  return true; 
   }
   
   public void actualizarDibujoLluvia(SpriteBatch batch) { 
	   
	  for (int i=0; i < gotas.size; i++ ) {
		  gotas.get(i).dibujar(batch);
	   }
   }
   public void destruir() {
      dropSound.dispose();
      rainMusic.dispose();
   }
   public void pausar() {
	  rainMusic.stop();
   }
   public void continuar() {
	  rainMusic.play();
   }
   
}
