package puppy.code;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Lluvia {
    private Array<ComportamientoGota> gotas;
    private long lastDropTime;
    private final CreadorGotas creadorGotas;
    private Music rainMusic;
    private long tiempoEntreGotas;
	   
	public Lluvia(CreadorGotas creadorGotas, Music rainMusic, long tiempoEntreGotas) {
            this.creadorGotas = creadorGotas;
            this.rainMusic = rainMusic;
            this.tiempoEntreGotas = tiempoEntreGotas;
        }
	
	public void crear() {
		gotas = new Array<ComportamientoGota>();
		crearGotaDeLluvia();
	      // start the playback of the background music immediately
	      rainMusic.setLooping(true);
	      rainMusic.play();
	}
	
	private void crearGotaDeLluvia() {
            float posicionX = MathUtils.random(0, 800 - 64);
            gotas.add(creadorGotas.crearGota(posicionX));
            lastDropTime = TimeUtils.nanoTime();
        }
	
   public boolean actualizarMovimiento(Tarro tarro) { 
	   // generar gotas de lluvia 
	   if(TimeUtils.nanoTime() - lastDropTime > tiempoEntreGotas) crearGotaDeLluvia();
	  
	   
	   // revisar si las gotas cayeron al suelo o chocaron con el tarro
	   for (int i=0; i < gotas.size; i++ ) {
	      ComportamientoGota gota = gotas.get(i);
	      gota.actualizarMovimiento();
	      //cae al suelo y se elimina
	      if(gota.estaFueraDePantalla()) {
	    	  gotas.removeIndex(i);
	    	  i--;
	    	  continue;
	      }
	      if(gota.colisionaCon(tarro)) {
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
      creadorGotas.destruir();
      rainMusic.dispose();
   }
   public void pausar() {
	  rainMusic.stop();
   }
   public void continuar() {
	  rainMusic.play();
   }
   
}
