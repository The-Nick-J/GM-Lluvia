package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Tarro {

    private Rectangle bucket;
    private Texture bucketImage;
    private Sound sonidoHerido;
    private int vidas = 3;
    private int puntos = 0;
    private int velx = 400;
    private boolean herido = false;
    private int tiempoHeridoMax = 50;
    private int tiempoHerido;
    private EstrategiaMovimiento estrategiaMovimiento;

    public Tarro(Texture tex, Sound ss) {
        bucketImage = tex;
        sonidoHerido = ss;
    }

    public void setEstrategiaMovimiento(EstrategiaMovimiento estrategiaMovimiento) {
        this.estrategiaMovimiento = estrategiaMovimiento;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos(int pp) {
        puntos += pp;
    }

    public void moverIzquierda(float distancia) {
        bucket.x -= distancia;
    }

    public void moverDerecha(float distancia) {
        bucket.x += distancia;
    }

    public void moverAlCentro(float posicionX) {
        bucket.x = posicionX - bucket.width / 2;
    }

    public boolean colisionaCon(Rectangle otraArea) {
        return bucket.overlaps(otraArea);
    }

    public void crear() {
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;
    }

    public void dañar() {
        vidas--;
        herido = true;
        tiempoHerido = tiempoHeridoMax;
        sonidoHerido.play();
    }

    public void dibujar(SpriteBatch batch) {
        if (!herido) {
            batch.draw(bucketImage, bucket.x, bucket.y);
        } else {

            batch.draw(bucketImage, bucket.x, bucket.y + MathUtils.random(-5, 5));
        }
    }

    public void actualizarEstado() {
        if (herido) {
            tiempoHerido--;
            if (tiempoHerido <= 0) {
                herido = false;
            }
        }
    }

    public void actualizarMovimiento() {
        estrategiaMovimiento.mover(this, velx, Gdx.graphics.getDeltaTime());

        // mantener el tarro dentro del juego
        if (bucket.x < 0) {
            bucket.x = 0;
        }

        if (bucket.x > 800 - bucket.width) {
            bucket.x = 800 - bucket.width;
        }
    }

    public void destruir() {
        bucketImage.dispose();
    }

    public boolean estaHerido() {
        return herido;
    }

}
