package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameScreen extends PantallaBase {

    private PartidaBuilder builder;
    private Partida partida;
    private EstrategiaMovimiento movimientoTeclado;
    private EstrategiaMovimiento movimientoTactil;

    //boolean activo = true;
    public GameScreen(final ContextoJuego game, PartidaBuilder builder) {
        super(game);
        this.builder = builder;
        DirectorPartida director = new DirectorPartida(builder);
        partida = director.prepararPartida();
        movimientoTeclado = new MovimientoTeclado();
        movimientoTactil = new MovimientoTactil(getCamera());
    }

    @Override
    protected void dibujar() {
        getBatch().draw(partida.getFondo(), 0, 0, 800, 480);
        //dibujar textos
        getFont().draw(getBatch(), "Gotas totales: " + partida.getTarro().getPuntos(), 5, 475);
        getFont().draw(getBatch(), "Vidas : " + partida.getTarro().getVidas(), 670, 475);
        getFont().draw(getBatch(), "HighScore : " + Puntaje.getInstancia().getHigherScore(partida.getDificultad()), getCamera().viewportWidth / 2 - 50, 475);
        partida.getTarro().dibujar(getBatch());
        partida.getLluvia().actualizarDibujoLluvia(getBatch());
    }

    @Override
    protected void actualizar(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            pause();
            return;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            partida.getTarro().setEstrategiaMovimiento(movimientoTeclado);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            partida.getTarro().setEstrategiaMovimiento(movimientoTactil);
        }

        if (!partida.actualizar()) {
            Puntaje.getInstancia().registrarPuntaje(partida.getTarro().getPuntos(), partida.getDificultad());
            getGame().setScreen(new GameOverScreen(getGame(), builder));
            dispose();
        }
    }

    @Override
    public void show() {
        // continuar con sonido de lluvia
        partida.getLluvia().continuar();
    }

    @Override
    public void pause() {
        partida.getLluvia().pausar();
        getGame().setScreen(new PausaScreen(getGame(), this));
    }

    @Override
    public void dispose() {
        partida.getFondo().dispose();
        partida.getTarro().destruir();
        partida.getLluvia().destruir();

    }

}
