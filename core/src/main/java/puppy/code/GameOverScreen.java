package puppy.code;

import com.badlogic.gdx.Gdx;

public class GameOverScreen extends PantallaBase {


    public GameOverScreen(final GameLluviaMenu game) {
        super(game);
    }

    @Override
    protected void dibujar() {
        getFont().draw(getBatch(), "GAME OVER ", 100, 200);
        getFont().draw(getBatch(), "Toca en cualquier lado para reiniciar.", 100, 100);
    }
    
    @Override
    protected void actualizar(float delta){
        if (Gdx.input.isTouched()) {
            getGame().setScreen(new GameScreen(getGame()));
            dispose();
        }
    }

}
