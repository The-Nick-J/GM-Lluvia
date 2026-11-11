package puppy.code;

public class DirectorPartida {

    private PartidaBuilder builder;

    public DirectorPartida(PartidaBuilder builder) {
        this.builder = builder;
    }

    public Partida prepararPartida() {
        builder.reset();
        builder.construirTarro();
        builder.construirLluvia();
        builder.construirFondo();
        return builder.getResult();
    }
}
