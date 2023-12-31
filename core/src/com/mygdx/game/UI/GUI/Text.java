package com.mygdx.game.UI.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Characters.Player;

public class Text extends Actor {
    private BitmapFont text;
    private CharSequence str;
    private float x, y;
    public Text(String path, float x, float y) {
        this.y = y;
        this.x = x;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(path));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 80;
        text = generator.generateFont(parameter);
        text.setColor(Color.WHITE);
        generator.dispose();
    }

    public void draw(Batch batch, float parentalAlpha) {
        text.draw(batch, str, x, y);
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getX() {
        return x;
    }

    public void update(int ammo) {
        str = String.valueOf(ammo);
    }

}
