package puppy.code;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface ContextoJuego {
    SpriteBatch getBatch();
    BitmapFont getFont();
    void setScreen(Screen pantalla);
}