package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class MovimientoTactil implements EstrategiaMovimiento {

    private final OrthographicCamera camera;

    public MovimientoTactil(OrthographicCamera camera) {
        this.camera = camera;
    }

    @Override
    public void mover(Tarro tarro, float velocidad, float delta) {
        if (Gdx.input.isTouched()) {
            Vector3 posicion = new Vector3(
                    Gdx.input.getX(),
                    Gdx.input.getY(),
                    0
            );

            camera.unproject(posicion);
            tarro.moverAlCentro(posicion.x);
        }
    }
}
