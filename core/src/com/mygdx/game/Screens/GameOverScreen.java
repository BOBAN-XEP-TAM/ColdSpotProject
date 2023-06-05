package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Main;

public class GameOverScreen implements Screen {
    private SpriteBatch batch;
    private Sprite gameOver;
    private Main parent;
    private final Stage stage;
    //private Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/click_sound_splash.mp3"));
    public GameOverScreen(Main main){
        parent = main;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        Texture splashTexture = new Texture(Gdx.files.internal("main_sprites/logo/game_over.png"));
        gameOver = new Sprite(splashTexture);
        gameOver.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        gameOver.setPosition(150, -150);

        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int i) {
                return false;
            }

            @Override
            public boolean keyUp(int i) {
                return false;
            }

            @Override
            public boolean keyTyped(char c) {
                return false;
            }

            @Override
            public boolean touchDown(int i, int i1, int i2, int i3) {
                Gdx.app.exit();
                return false;
            }

            @Override
            public boolean touchUp(int i, int i1, int i2, int i3) {

                return false;
            }

            @Override
            public boolean touchDragged(int i, int i1, int i2) {

                return false;
            }

            @Override
            public boolean mouseMoved(int i, int i1) {
                return false;
            }

            @Override
            public boolean scrolled(float v, float v1) {
                return false;
            }
        });
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        gameOver.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
