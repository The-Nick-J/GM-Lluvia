
package puppy.code;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public abstract class PantallaBase implements Screen {
    private GameLluviaMenu game;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;
    
    public PantallaBase(GameLluviaMenu game){
        this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }
    
    @Override
    public final void render(float delta){
        limpiarPantalla();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        
        batch.begin();
        dibujar();
        batch.end();
        
        actualizar(delta);
    }
    
    protected void limpiarPantalla(){
        ScreenUtils.clear(0, 0, 0.2f, 1);
    }
    
    protected abstract void dibujar();
    
    
    protected abstract void actualizar(float delta);
    
    public GameLluviaMenu getGame() {
        return game;
    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public BitmapFont getFont() {
        return font;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
    
    @Override
    public void show(){
    }

    @Override
    public void resize(int width, int height){
    }

    @Override
    public void pause(){
    }

    @Override
    public void resume(){
    }

    @Override
    public void hide(){
    }

    @Override
    public void dispose(){
    }
    
}
