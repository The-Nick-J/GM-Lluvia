package puppy.code;

public interface PartidaBuilder {
    public void reset();
    public void construirTarro();
    public void construirLluvia();
    public void construirFondo();
    public Partida getResult();
}
