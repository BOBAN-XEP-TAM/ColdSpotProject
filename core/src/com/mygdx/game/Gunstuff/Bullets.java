package com.mygdx.game.Gunstuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Characters.Characters;

public class Bullets extends Characters {

    public Bullets(Sprite img, Vector2 position, int speed, Vector2 direction) {
        super(img, position, speed);
        this.direction = new Vector2(direction);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.x, position.y, 50, 50);
    }

    @Override
    public void update() {
        position.add(direction.x * speed, direction.y * speed);
        img.setPosition(position.x, position.y);
    }
}
