package com.win.fractals.Utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.win.fractals.Fractals;

/**
 * Created by WIN THU LATT on 10/21/2016.
 */

public class Menu implements Disposable
{
    private Viewport viewport;
    private Stage stage;
    private boolean mengerPressed;
    private float buttonHeight = 100;

    public boolean isMengerPressed()
    {
        return mengerPressed;
    }

    public boolean isMengerRPressed()
    {
        return mengerRPressed;
    }

    private boolean mengerRPressed;
    private OrthographicCamera camera;
    private Fractals app;

    public Menu(Fractals app)
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Fractals.WIDTH, Fractals.HEIGHT);
        viewport = new FitViewport(Fractals.WIDTH, Fractals.HEIGHT, camera);
        stage = new Stage(viewport, app.batch);
        this.app = app;

        TextureButton menger = new TextureButton(app.atlas.findRegion("menger"), Fractals.WIDTH/2f - app.atlas.findRegion("mengerR").getRegionWidth()/2f, buttonHeight, 1f);
        TextureButton mengerR = new TextureButton(app.atlas.findRegion("mengerR"), Fractals.WIDTH/2f - app.atlas.findRegion("mengerR").getRegionWidth()/2f, buttonHeight-64, 1f);

        menger.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                mengerPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                mengerPressed = false;
            }
        });

        mengerR.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                mengerRPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button)
            {
                mengerRPressed = false;
            }
        });

        stage.addActor(menger);
        stage.addActor(mengerR);
        final Fractals temp = app;
        stage.addListener(new InputListener()
        {
            @Override
            public boolean keyDown(InputEvent event, int keycode)
            {
                if (keycode == Input.Keys.MENU)
                {
                    System.out.println("MENU");
                }
                return true;
            }

            @Override
            public boolean keyUp(InputEvent event, int keycode)
            {
                return super.keyUp(event, keycode);
            }
        });

        Gdx.input.setCatchBackKey(true);
        Gdx.input.setCatchMenuKey(true);

        Gdx.input.setInputProcessor(stage);
    }

    public void draw()
    {
        stage.draw();
    }


    @Override
    public void dispose()
    {

    }
}
