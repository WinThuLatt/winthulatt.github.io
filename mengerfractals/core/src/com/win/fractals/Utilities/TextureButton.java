package com.win.fractals.Utilities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TextureButton extends Actor
{
    TextureAtlas.AtlasRegion texture;
    float x = 0, y = 0;
    float scaling = 1f;

    public TextureButton(TextureAtlas.AtlasRegion texture, float x, float y, float s)
    {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.scaling = s;
        setBounds(x, y, texture.getRegionWidth()*s, texture.getRegionHeight()*s);
    }


    @Override
    public void draw(Batch batch, float parentAlpha)
    {
        batch.draw(texture, x, y, texture.getRegionWidth() * scaling, texture.getRegionHeight() * scaling);
    }


}