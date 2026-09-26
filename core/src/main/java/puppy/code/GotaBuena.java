package puppy.code;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class GotaBuena extends Gota implements ComportamientoGota {

    private Sound sonidoRecoleccion;

    public GotaBuena(Texture imagen, float posicionX, Sound sonidoRecoleccion) {
        super(imagen, posicionX);
        this.sonidoRecoleccion = sonidoRecoleccion;
    }

    @Override
    public void aplicarEfecto(Tarro tarro) {
        tarro.sumarPuntos(10);
        sonidoRecoleccion.play();
    }
}
