package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.mygdx.game.Tools.Vector2;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Characters.Player;
import com.mygdx.game.Gunstuff.BulletGenerator;
import com.mygdx.game.Gunstuff.Bullets;
import com.mygdx.game.Main;
import com.mygdx.game.Controls.Grip;

public class GameScreen implements Screen {
    Main main;
    Grip gripL, gripR;
    public static Player player;
    public static Array<Bullets> bullets;
    BulletGenerator bulletGenerator;
    private float angle;

    public GameScreen(Main main){
        this.main = main;
    }
    @Override
    public void show() {
        loadActors();
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = (Main.HEIGHT - screenY);
                multitouch( screenX, screenY, true, pointer);
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                screenY =  (Main.HEIGHT - screenY);
                multitouch(screenX, screenY, false, pointer);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                screenY = (Main.HEIGHT - screenY);
                multitouch(screenX, screenY, true, pointer);
                return false;
            }


            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        }
        );

    }

    public void loadActors() {
        bullets = new Array<Bullets>();
        gripR = new Grip(main.joystickImg, main.gripImg, new Vector2(main.WIDTH - ((main.HEIGHT / 3) / 2 + (main.HEIGHT / 3) / 4), (main.HEIGHT / 3) / 2 + (main.HEIGHT / 3) / 4), Main.HEIGHT / 3);
        gripL = new Grip(Main.joystickImg, Main.gripImg, new Vector2(Main.WIDTH - ((Main.HEIGHT) + (Main.HEIGHT / 2) + (Main.HEIGHT / 5)), (Main.HEIGHT / 3) / 2 + (Main.HEIGHT / 3) / 4), Main.HEIGHT / 3);
        //gripR = new Grip(Main.joystickImg, Main.gripImg, new Vector2(Main.HEIGHT / 3 / 4, (Main.HEIGHT / 3) / 2 + (Main.HEIGHT / 3) / 4), Main.HEIGHT / 3);
        player = new Player(main.mainChar, new Vector2(main.WIDTH / 2, main.HEIGHT / 2), 10, 20);
        bulletGenerator = new BulletGenerator();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameUpdate();
        Main.batch.begin();
        gameRender(main.batch);
        Main.batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
    public void gameRender(SpriteBatch batch) {
        player.draw(batch);
        //System.out.println(gripL.direction.angleDeg() - 270);
        //System.out.println(player.img.getWidth() + ", " +  player.img.getHeight());
        //System.out.println(main.mainCharImg.getWidth() + ", " +  main.mainCharImg.getHeight());
        if (gripL.direction.angleDeg() - 270 != -270.0) angle = gripL.direction.angleDeg() - 270;
        if (gripR.direction.angleDeg() - 270 != -270.0) angle = gripR.direction.angleDeg() - 270;
        player.img.setRotation(angle);
        player.img.setRotation(angle);
        gripL.draw(batch);
        gripR.draw(batch);
        //player.img.rotate(90);
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).draw(batch);
        }
    }
    public void gameUpdate(){
        player.setDirection(gripL.direction);
        player.update();
        bulletGenerator.update(gripR);
        for (int i = 0; i < bullets.size; i++) {
            bullets.get(i).update();
        }
    }


    public void multitouch(float x, float y, boolean isDownTouched, int pointer) {
        for (int i = 0; i < 5; i++) {
            gripL.update(x,y,isDownTouched,pointer);
            gripR.update(x, y, isDownTouched, pointer);
        }
    }

}
