package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MainMenuScreen extends PantallaBase {

    public MainMenuScreen(final GameLluviaMenu game) {
        super(game);
    }

    @Override
    protected void dibujar(){
        getFont().getData().setScale(2, 2);
        getFont().draw(getBatch(), "Bienvenido a Recolecta Gotas!!! ", 100, getCamera().viewportHeight / 2 + 50);
        getFont().draw(getBatch(), "Presiona 1 para modo facil", 100, getCamera().viewportHeight / 2);
        getFont().draw(getBatch(), "Presiona 2 para modo dificil", 100, getCamera().viewportHeight / 2 - 50);
    }
    
    @Override
    protected void actualizar(float delta){
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            getGame().setScreen(new GameScreen(getGame(), false));
            dispose();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            getGame().setScreen(new GameScreen(getGame(), true));
            dispose();
        }
    }
    

    
}
