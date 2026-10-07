package puppy.code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen {
	final GameLluviaMenu game;
    private OrthographicCamera camera;
	private SpriteBatch batch;	   
	private BitmapFont font;
	private Texture fondo;
	private Partida partida;

	   
	//boolean activo = true;

	public GameScreen(final GameLluviaMenu game) {
		this.game = game;
        this.batch = game.getBatch();
        this.font = game.getFont();
		fondo = new Texture(Gdx.files.internal("fondo.png"));
	      // camera
	      camera = new OrthographicCamera();
	      camera.setToOrtho(false, 800, 480);
	      batch = new SpriteBatch();

	      PartidaBuilder builder = new PartidaRecolectorBuilder();
	      DirectorPartida director = new DirectorPartida(builder);
	      partida = director.prepararPartida();
	}

	@Override
	public void render(float delta) {
		//limpia la pantalla con color azul obscuro.
		ScreenUtils.clear(0, 0, 0.2f, 1);
		//actualizar matrices de la cámara
		camera.update();
		//actualizar 
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(fondo, 0, 0, 800, 480);
		//dibujar textos
		font.draw(batch, "Gotas totales: " + partida.getTarro().getPuntos(), 5, 475);
		font.draw(batch, "Vidas : " + partida.getTarro().getVidas(), 670, 475);
		font.draw(batch, "HighScore : " + game.getHigherScore(), camera.viewportWidth/2-50, 475);
		
		if (!partida.getTarro().estaHerido()) {
			// movimiento del tarro desde teclado
	        partida.getTarro().actualizarMovimiento();
			// caida de la lluvia 
	       if (!partida.getLluvia().actualizarMovimiento(partida.getTarro())) {
	    	  //actualizar HigherScore
		if (game.getHigherScore()<partida.getTarro().getPuntos())
			game.setHigherScore(partida.getTarro().getPuntos());
	    	  //ir a la ventana de finde juego y destruir la actual
	    	  game.setScreen(new GameOverScreen(game));
	    	  dispose();
	       }
		}
		
		partida.getTarro().dibujar(batch);
		partida.getLluvia().actualizarDibujoLluvia(batch);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	  // continuar con sonido de lluvia
	  partida.getLluvia().continuar();
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		partida.getLluvia().pausar();
		game.setScreen(new PausaScreen(game, this)); 
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
	      fondo.dispose();
	      partida.getTarro().destruir();
	      partida.getLluvia().destruir();

	}

}
