package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class PartidaDificilBuilder implements PartidaBuilder {
    private Partida partida;

    public void reset() {
        partida = new Partida();
        partida.setDificultad("dificil");
    }

    public void construirTarro() {
        Sound hurtSound = Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
        Texture bucketImage = new Texture(Gdx.files.internal("bucket.png"));

        Tarro tarro = new Tarro(bucketImage, hurtSound, 2);
        tarro.crear();
        partida.setTarro(tarro);
    }

    public void construirLluvia() {
        Texture gotaBuena = new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMala = new Texture(Gdx.files.internal("dropBad.png"));
        Sound dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        
        
        CreadorGotas creadorGotas = new CreadorGotasAleatorio(gotaBuena, gotaMala, dropSound);
        Lluvia lluvia = new Lluvia(creadorGotas, rainMusic, 100000000L);
        lluvia.crear();
        partida.setLluvia(lluvia);
    }

    public void construirFondo() {
        Texture fondo = new Texture(Gdx.files.internal("fondoDificil.png"));
        partida.setFondo(fondo);
    }

    public Partida getResult() {
        return partida;
    }
}
