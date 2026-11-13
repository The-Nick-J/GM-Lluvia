package puppy.code;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class CreadorGotasAleatorio implements CreadorGotas {
    private final Texture imagenBuena;
    private final Texture imagenMala;
    private final Sound sonidoRecoleccion;

    public CreadorGotasAleatorio(Texture imagenBuena, Texture imagenMala, Sound sonidoRecoleccion) {
        this.imagenBuena = imagenBuena;
        this.imagenMala = imagenMala;
        this.sonidoRecoleccion = sonidoRecoleccion;
    }

    @Override
    public ComportamientoGota crearGota(float posicionX) {
        if (MathUtils.random(1, 10) < 5) {
            return new GotaMala(imagenMala, posicionX);
        }
        return new GotaBuena(imagenBuena, posicionX, sonidoRecoleccion);
    }

    @Override
    public void destruir() {
        imagenBuena.dispose();
        imagenMala.dispose();
        sonidoRecoleccion.dispose();
    }
}
