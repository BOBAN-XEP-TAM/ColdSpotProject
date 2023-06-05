package com.mygdx.game.Gunstuff.Stuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Characters.Characters;
import com.mygdx.game.Main;
import com.mygdx.game.Screens.GameScreen;

//public class Bullets extends Characters {
//    public boolean isOut;
//
//    public Bullets(Sprite img, Vector2 position, int speed, Vector2 direction) {
//        super(img, position, speed);
//        this.direction = new Vector2(direction);
//    }
//
//    @Override
//    public void draw(SpriteBatch batch) {
////        img.setRotation(GameScreen.angle);
////        img.setPosition(position.x, position.y);
////        img.setRegionWidth(50);
////        img.setRegionHeight(50);
////        img.draw(batch);
//        batch.draw(img, position.x, position.y, 50, 50);
//    }
//
//    @Override
//    public void update() {
//        position.add(direction.x * speed, direction.y * speed);
//        img.setPosition(position.x, position.y);
//    }
//}
public class Bullets
{
    public Vector2 position = new Vector2();
    public Vector2 direction = new Vector2();
    public int speed, size;
    public Rectangle bounds;
    public boolean isOut;
    //public Texture img;

    public Bullets(Vector2 position, Vector2 direction, int speed, int size)
    {
        //this.img = img;
        this.speed = speed;
        this.position.set(position);
        this.direction.set(direction);
        this.size = size;
        bounds = new Rectangle(position.x, position.y, size, size);

    }

//    public void draw(SpriteBatch batch) {
//        batch.draw(img, position.x, position.y, 56, 17);
//    }
    public void update() {
//        isOut = ((position.x + GameScreen.player.img.getWidth() > Main.WIDTH) || (position.x - GameScreen.player.img.getWidth() < Main.WIDTH)
//        || (position.y + GameScreen.player.img.getHeight() > Main.WIDTH) || (position.y + GameScreen.player.img.getHeight() < Main.WIDTH))  ? true : false;
        //sprite.setPosition(position.x, position.y);
        position.add(direction.x * speed, direction.y * speed);
       bounds.setPosition(position);
    }
}
