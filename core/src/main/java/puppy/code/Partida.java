package puppy.code;

import com.badlogic.gdx.graphics.Texture;

public class Partida {
    private Tarro tarro;
    private Lluvia lluvia;
    private Texture fondo;
    private String dificultad;

    public void setFondo(Texture fondo) {
        this.fondo = fondo;
    }

    public Texture getFondo() {
        return fondo;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setTarro(Tarro tarro) {
        this.tarro = tarro;
    }

    public Tarro getTarro() {
        return tarro;
    }

    public void setLluvia(Lluvia lluvia) {
        this.lluvia = lluvia;
    }

    public Lluvia getLluvia() {
        return lluvia;
    }

    public boolean actualizar() {
        tarro.actualizarEstado();

        if (!tarro.estaHerido()) {
            tarro.actualizarMovimiento();
            return lluvia.actualizarMovimiento(tarro);
        }

        return true;
    }
}
