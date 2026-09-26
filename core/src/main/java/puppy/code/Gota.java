package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Gota {

    private Rectangle area;
    private Texture imagen;
    private int velocidad = 300;

    public Gota(Texture imagen, float posicionX) {
        this.imagen = imagen;
        area = new Rectangle(posicionX, 480, 64, 64);
    }

    public void actualizarMovimiento() {
        area.y -= velocidad * Gdx.graphics.getDeltaTime();
    }

    public void dibujar(SpriteBatch batch) {
        batch.draw(imagen, area.x, area.y);
    }

    public Rectangle getArea() {
        return area;
    }

    public abstract void aplicarEfecto(Tarro tarro);
}
