package com.mygdx.game.UI.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen implements Screen {
    private SpriteBatch batch;
    private Sprite splash;
    @Override
    public void show() {
        batch = new SpriteBatch();
        Texture splashTexture = new Texture(Gdx.files.internal("main_sprites/logo/splash.png"));
        splash = new Sprite(splashTexture);
        splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        splash.setPosition(150, -150);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        splash.draw(batch);
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

    }
}
