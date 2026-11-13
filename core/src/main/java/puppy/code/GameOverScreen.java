package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameOverScreen extends PantallaBase {

    private PartidaBuilder builder;

    public GameOverScreen(final ContextoJuego game, PartidaBuilder builder) {
        super(game);
        this.builder = builder;
    }

    @Override
    protected void dibujar() {
        getFont().draw(getBatch(), "GAME OVER ", 100, 200);
        getFont().draw(getBatch(), "Presiona 1 para reiniciar", 100, 140);
        getFont().draw(getBatch(), "Presiona 2 para volver al menu", 100, 100);
    }
    
    @Override
    protected void actualizar(float delta){
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            getGame().setScreen(new GameScreen(getGame(), builder));
            dispose();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            getGame().setScreen(new MainMenuScreen(getGame()));
            dispose();
        }
    }

}
