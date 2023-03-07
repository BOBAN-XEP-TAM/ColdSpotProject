package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.GameScreen;

public class Main extends Game {
	public static SpriteBatch batch;
	public static Sprite mainChar, bullet;
	public static Texture mainCharImg, bulletImg, joystickImg, gripImg;
	public static int WIDTH, HEIGHT;

	@Override
	public void create () {
		batch = new SpriteBatch();
		//Pixmap pix = new Pixmap(64, 64, Pixmap.Format.RGB888);
		mainCharImg = new Texture("main.png");
		mainChar = new Sprite(mainCharImg);
		//mainChar.setSize(mainCharImg.getWidth(), mainCharImg.getHeight());
		bulletImg = new Texture("bullet.png");
		bullet= new Sprite(bulletImg);
		joystickImg = new Texture("circle.png");
		gripImg = new Texture("pngegg (3).png");

		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		setScreen(new GameScreen(this));

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
