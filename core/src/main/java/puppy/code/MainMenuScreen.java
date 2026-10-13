package puppy.code;

import com.badlogic.gdx.Gdx;

public class MainMenuScreen extends PantallaBase {

    public MainMenuScreen(final GameLluviaMenu game) {
        super(game);
    }

    @Override
    protected void dibujar(){
        getFont().getData().setScale(2, 2);
        getFont().draw(getBatch(), "Bienvenido a Recolecta Gotas!!! ", 100, getCamera().viewportHeight / 2 + 50);
        getFont().draw(getBatch(), "Toca en cualquier lugar para comenzar!", 100, getCamera().viewportHeight / 2 - 50);
    }
    
    @Override
    protected void actualizar(float delta){
        if (Gdx.input.isTouched()) {
            getGame().setScreen(new GameScreen(getGame()));
            dispose();
        }
    }
    

    
}
