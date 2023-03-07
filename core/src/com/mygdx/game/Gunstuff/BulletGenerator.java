package com.mygdx.game.Gunstuff;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Controls.Grip;
import com.mygdx.game.Main;
import com.mygdx.game.Screens.GameScreen;

public class BulletGenerator {
    public boolean isFire;
    public void update(Grip grip) {
        isFire = (grip.direction.x == 0 && grip.direction.y == 0) ? false : true;

        if(isFire) {
            GameScreen.bullets.add(new Bullets(Main.bullet, GameScreen.player.position, 3, grip.direction)); //GameScreen.player.position
        }
    }
}
