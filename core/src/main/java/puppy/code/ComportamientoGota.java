package puppy.code;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ComportamientoGota {

    public void actualizarMovimiento();

    public void dibujar(SpriteBatch batch);

    public boolean estaFueraDePantalla();

    public boolean colisionaCon(Tarro tarro);

    public void aplicarEfecto(Tarro tarro);
}
