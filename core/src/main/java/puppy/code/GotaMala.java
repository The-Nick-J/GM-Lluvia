package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class GotaMala extends Gota {

    public GotaMala(Texture imagen, float posicionX) {
        super(imagen, posicionX);
    }

    @Override
    public void aplicarEfecto(ReceptorGota tarro) {
        tarro.dañar();
    }
}
