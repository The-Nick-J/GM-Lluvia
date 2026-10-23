package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;

public class GameScreen extends PantallaBase {

    private Texture fondo;
    private Partida partida;
    private EstrategiaMovimiento movimientoTeclado;
    private EstrategiaMovimiento movimientoTactil;
    private boolean modoDificil;

    //boolean activo = true;
    public GameScreen(final GameLluviaMenu game, boolean modoDificil) {
        super(game);
        this.modoDificil = modoDificil;
        String archivoFondo = modoDificil ? "fondoDificil.png" : "fondo.png";
        fondo = new Texture(Gdx.files.internal(archivoFondo));

        PartidaBuilder builder = new PartidaRecolectorBuilder(modoDificil);
        DirectorPartida director = new DirectorPartida(builder);
        partida = director.prepararPartida();
        movimientoTeclado = new MovimientoTeclado();
        movimientoTactil = new MovimientoTactil(getCamera());
        partida.getTarro().setEstrategiaMovimiento(movimientoTeclado);
    }

    @Override
    protected void dibujar() {
        getBatch().draw(fondo, 0, 0, 800, 480);
        //dibujar textos
        getFont().draw(getBatch(), "Gotas totales: " + partida.getTarro().getPuntos(), 5, 475);
        getFont().draw(getBatch(), "Vidas : " + partida.getTarro().getVidas(), 670, 475);
        getFont().draw(getBatch(), "HighScore : " + Puntaje.getInstancia().getHigherScore(modoDificil), getCamera().viewportWidth / 2 - 50, 475);
        partida.getTarro().dibujar(getBatch());
        partida.getLluvia().actualizarDibujoLluvia(getBatch());
    }

    @Override
    protected void actualizar(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            partida.getTarro().setEstrategiaMovimiento(movimientoTeclado);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            partida.getTarro().setEstrategiaMovimiento(movimientoTactil);
        }

        if (!partida.actualizar()) {
            Puntaje.getInstancia().registrarPuntaje(partida.getTarro().getPuntos(), modoDificil);
            getGame().setScreen(new GameOverScreen(getGame(), modoDificil));
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
        fondo.dispose();
        partida.getTarro().destruir();
        partida.getLluvia().destruir();

    }

}
