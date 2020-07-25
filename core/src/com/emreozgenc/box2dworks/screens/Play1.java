package com.emreozgenc.box2dworks.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.emreozgenc.box2dworks.Box2DWorks;
import com.emreozgenc.box2dworks.Constants;

public class Play1 implements Screen {

    private Box2DWorks game;

    // Box2D elements
    private World world;
    private Body ballBody;
    private Body groundBody;
    private Box2DDebugRenderer b2dr;

    // Ball texture
    private Texture ballTexture;

    // Sprite Batch for rendering
    private SpriteBatch batch;


    public Play1(Box2DWorks game) {
        this.game = game;
        world = new World(Constants.WORLD_GRAVITY, true);
        b2dr = new Box2DDebugRenderer();
        batch = new SpriteBatch();

        ballTexture = new Texture(Gdx.files.internal("ball.png"));
    }

    private void update(float delta) {
        world.step(1 / 60f, 6, 2);
        handleInput();
    }

    private void handleInput() {

    }

    private void render2(SpriteBatch batch) {
        batch.draw(ballTexture, 3, 3,
                Constants.BALL_RADIUS * 2,
                Constants.BALL_RADIUS * 2);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        game.cam.update();
        batch.setProjectionMatrix(game.cam.combined);
        batch.begin();
        render2(batch);
        batch.end();

        b2dr.render(world, game.cam.combined);

    }

    @Override
    public void resize(int width, int height) {
        game.cam.setToOrtho(false,
                Constants.V_HEIGHT * width / (float) height,
                Constants.V_HEIGHT);
        game.cam.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
