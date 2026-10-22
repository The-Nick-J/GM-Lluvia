package puppy.code;

public class Partida {
    private Tarro tarro;
    private Lluvia lluvia;

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
