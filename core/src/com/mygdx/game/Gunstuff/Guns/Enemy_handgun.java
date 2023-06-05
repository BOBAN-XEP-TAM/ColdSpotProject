package com.mygdx.game.Gunstuff.Guns;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Camera.Rumble;
import com.mygdx.game.Characters.Enemy;
import com.mygdx.game.Characters.Player;
import com.mygdx.game.Controls.Grip;
import com.mygdx.game.Gunstuff.Stuff.Bullet;
import com.mygdx.game.Screens.GameScreen;

public class Enemy_pistol extends Gun{
    public boolean isFire;
    public int ammo = 30;
    private double startTime = 0;
    private double startTimeShoot = 0;
    private double endTime = 0;
    private double endTimeShoot = 0;
    private double interval = 1000 * 1;
    private double reloadTime = 1 * 1000;
    private Vector2 offset, barrelPosition;
    private Enemy en;

    public Enemy_pistol(Enemy en) {
        this.en = en;
    }
    @Override
    void reload_timer() {
        if (startTime == 0) {
            startTime = System.currentTimeMillis();
            endTime = startTime + reloadTime;
        }
        if (endTime <= System.currentTimeMillis()) {
            startTime = 0;
            ammo = 30;
        }
    }

    @Override
    void shoot(Grip grip) {

    }

    void shoot() {
        if (startTimeShoot == 0) {
            startTimeShoot = System.currentTimeMillis();
            endTimeShoot = startTimeShoot + interval;
        }
        if (endTimeShoot <= System.currentTimeMillis()) {
            startTimeShoot = 0;
            GameScreen.bullets.add(new Bullet(barrelPosition, new Vector2(en.direction), (int)getRandomDoubleBetweenRange(30,34), 10)); //GameScreen.player.position
            ammo--;
            Rumble.rumble(2.8f, 0.2f);
        }
    }

    @Override
    public void update(Grip grip) {

    }
}
