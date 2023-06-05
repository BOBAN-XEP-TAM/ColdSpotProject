package com.mygdx.game.Gunstuff.Guns;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Characters.Enemy;
import com.mygdx.game.UI.GUI.Joystick;

public abstract class Gun {
    public boolean isFire;
    private int ammo;
    private double startTime;
    private double startTimeShoot;
    private double endTime;
    private double endTimeShoot;
    private double interval;
    private double reloadTime;

    double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }
    abstract void reload_timer();
    abstract void shoot(Vector2 direction);
    public abstract void update(Joystick joystick);
}
