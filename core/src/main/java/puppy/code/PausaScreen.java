package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

public class PausaScreen extends PantallaBase {

    private GameScreen juego;
    
    public PausaScreen(final GameLluviaMenu game, GameScreen juego) {
        super(game);
        this.juego = juego;
    }

    @Override
    protected void limpiarPantalla() {
        ScreenUtils.clear(0, 0, 1.0f, 0.5f);
    }

    @Override
    protected void dibujar() {
        getFont().draw(getBatch(), "Juego en Pausa ", 100, 150);
        getFont().draw(getBatch(), "Toca en cualquier lado para continuar !!!", 100, 100);
    }

    @Override
    protected void actualizar(float delta) {
        if (Gdx.input.isTouched()) {
            getGame().setScreen(juego);
            dispose();
        }
    }

}
