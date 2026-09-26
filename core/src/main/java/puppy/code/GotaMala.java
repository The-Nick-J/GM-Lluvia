package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class GotaMala extends Gota implements ComportamientoGota {

    public GotaMala(Texture imagen, float posicionX) {
        super(imagen, posicionX);
    }

    @Override
    public void aplicarEfecto(Tarro tarro) {
        tarro.dañar();
    }
}
