package puppy.code;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public interface ComportamientoGota {

    public void actualizarMovimiento();

    public void dibujar(SpriteBatch batch);

    public Rectangle getArea();

    public void aplicarEfecto(Tarro tarro);
}
