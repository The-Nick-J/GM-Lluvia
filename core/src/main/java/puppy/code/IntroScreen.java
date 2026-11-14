package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;

public class IntroScreen extends PantallaBase {
    private Music lluvia;
    private float tiempo;
    private int frase;

    public IntroScreen(ContextoJuego game) {
        super(game);
        lluvia = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
        lluvia.setLooping(true);
    }

    @Override
    public void show() {
        lluvia.play();
    }

    @Override
    protected void dibujar() {
        float opacidad = 1;
        if (tiempo < 0.6f) {
            opacidad = tiempo / 0.6f;
        } else if (tiempo > 2.8f) {
            opacidad = (3.4f - tiempo) / 0.6f;
        }

        getFont().getData().setScale(2, 2);
        getFont().setColor(1, 1, 1, opacidad);
        if (frase == 0) {
            getFont().draw(getBatch(), "Chile, 2026. Con El Niño llegó una tormenta", 100, 270);
            getFont().draw(getBatch(), "que nadie esperaba.", 100, 230);
        } else if (frase == 1) {
            getFont().draw(getBatch(), "Entre las gotas rojas, todavía cae agua limpia.", 100, 250);
        } else {
            getFont().draw(getBatch(), "Tu tarro es lo único que tienes.", 100, 290);
            getFont().draw(getBatch(), "Rescata toda el agua que puedas.", 100, 250);
            getFont().draw(getBatch(), "El mundo la necesita.", 100, 210);
        }

        getFont().setColor(1, 1, 1, 1);
        getFont().getData().setScale(1, 1);
        getFont().draw(getBatch(), "Enter para saltar", 100, 55);
    }

    @Override
    protected void actualizar(float delta) {
        tiempo += delta;
        if (tiempo >= 3.4f) {
            tiempo = 0;
            frase++;
        }
        if (frase == 3 || Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            getGame().setScreen(new MainMenuScreen(getGame()));
        }
    }

    @Override
    public void pause() {
        lluvia.pause();
    }

    @Override
    public void resume() {
        lluvia.play();
    }

    @Override
    public void hide() {
        lluvia.dispose();
    }
}
