package com.mygdx.game.Characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Characters {
    private int score;
    private int health;


//    public Player(Texture img, Vector2 position, float speed, float health) {
//        super(img, position, speed);
//        this.health = health;
//    }
    public Player(Sprite img, Vector2 position, int speed, int health) {
        super(img, position, speed);
        this.health = health;
        img.setOrigin(img.getWidth() / 2 - 65, img.getY() / 2 + 240);
    }


    @Override
    public void draw(SpriteBatch batch) {
        //batch.draw(img, position.x, position.y);
        img.setPosition(position.x, position.y);
        img.draw(batch);
    }

    @Override
    public void update() {
//        if (position.x + r > MyGdxGame.WIDTH) position.x = MyGdxGame.WIDTH - r;
//        if (position.x - r < 0) position.x = r;
//        if (position.y + r > MyGdxGame.HEIGHT) position.y = MyGdxGame.WIDTH - r;
//        if (position.y - r < 0) position.y = r;
        position.add(direction.x * speed, direction.y * speed);
    }
}
