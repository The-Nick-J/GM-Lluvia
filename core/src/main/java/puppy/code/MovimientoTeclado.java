package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MovimientoTeclado implements EstrategiaMovimiento {

    @Override
    public void mover(Tarro tarro, float velocidad, float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tarro.moverIzquierda(velocidad * delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tarro.moverDerecha(velocidad * delta);
        }
    }
}
