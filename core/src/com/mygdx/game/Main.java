package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Screens.GameOverScreen;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.SplashScreen;
import com.mygdx.game.Screens.WinScreen;

public class Main extends Game {
	public static SpriteBatch batch;
	public static Stage stage;
	private ScreenViewport viewport = new ScreenViewport();
	public static Sprite mainChar, mainChar_ak,  mainChar_shotgun;
	public static OrthographicCamera camera;
	public static Texture mainCharImg, mainCharImg_ak, mainCharImg_shotgun, joystickImg, gripImg;

	public static final float PPM = 64;
	public static final short BIT_WALL = 2;
	public static final short BIT_PLAYER = 4;
	public static final short BIT_ENEMY= 8;
	public static final short BIT_BULLET= 16;

	public static int WIDTH, HEIGHT;
	public static ShapeRenderer shapeRenderer;

	private SplashScreen splashScreen;
	private GameScreen gameScreen;
	private GameOverScreen gameOverScreen;
	private WinScreen winScreen;
	public final static int SPLASH = 0;
	public final static int GAME = 1;
	public final static int GAMEOVER = 2;
	public final static int WIN = 3;

	public void changeScreen(int screen){
		try {
			switch (screen) {
				case SPLASH:
					if (splashScreen == null) splashScreen = new SplashScreen(this);
					this.setScreen(splashScreen);
					break;
				case GAME:
					if (gameScreen == null) gameScreen = new GameScreen(this);
					this.setScreen(gameScreen);
					break;
				case GAMEOVER:
					if (gameOverScreen == null) gameOverScreen = new GameOverScreen(this);
					this.setScreen(gameOverScreen);
					break;
				case WIN:
					if (winScreen == null) winScreen = new WinScreen(this);
					this.setScreen(winScreen);
					break;
			}
		} catch (NullPointerException e) {}
	}

	@Override
	public void create () {
		Gdx.input.setOnscreenKeyboardVisible(false);
		//VISUAL CONFIGURATION
		batch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(viewport); //new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera)

		mainCharImg = new Texture("main_sprites/main.png");
		mainChar = new Sprite(mainCharImg);
		mainCharImg_ak = new Texture("main_sprites/main_char_ak_d.png");
		mainChar_ak = new Sprite(mainCharImg_ak);
		mainCharImg_shotgun = new Texture("main_sprites/main_shotgun.png");
		mainChar_shotgun = new Sprite(mainCharImg_shotgun);
		joystickImg = new Texture("grips/circle.png");
		gripImg = new Texture("grips/red_grip.png");
		shapeRenderer = new ShapeRenderer();

		//SCREEN PARAMETERS
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();


		//setScreen(new GameScreen(this));
		splashScreen = new SplashScreen(this);
		setScreen(splashScreen);

	}

	@Override
	public void dispose () {
		stage.dispose();
		batch.dispose();
		shapeRenderer.dispose();
		splashScreen.dispose();
		gameScreen.dispose();
	}
}
