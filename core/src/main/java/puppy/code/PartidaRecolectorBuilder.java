package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class PartidaRecolectorBuilder implements PartidaBuilder {
    private Partida partida;

    public void reset() {
        partida = new Partida();
    }

    public void construirTarro() {
        Sound hurtSound =
                Gdx.audio.newSound(Gdx.files.internal("hurt.ogg"));
        Texture bucketImage =
                new Texture(Gdx.files.internal("bucket.png"));

        Tarro tarro = new Tarro(bucketImage, hurtSound);
        tarro.crear();
        partida.setTarro(tarro);
    }

    public void construirLluvia() {
        Texture gotaBuena =
                new Texture(Gdx.files.internal("drop.png"));
        Texture gotaMala =
                new Texture(Gdx.files.internal("dropBad.png"));
        Sound dropSound =
                Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        Music rainMusic =
                Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

        Lluvia lluvia =
                new Lluvia(gotaBuena, gotaMala, dropSound, rainMusic);
        lluvia.crear();
        partida.setLluvia(lluvia);
    }

    public Partida getResult() {
        return partida;
    }
}
