package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.camera.MainInputProcessor;
import com.qxbytes.entities.BodyPresets;
import com.qxbytes.entities.Entity;
import com.qxbytes.spacegame.SpaceGame;

/**
 * Main Game screen.
 * @param game SpaceGame
 */
public class GameScreen implements Screen {
	
	final float WORLD_WIDTH = Gdx.graphics.getWidth();
	final float WORLD_HEIGHT = Gdx.graphics.getHeight();
	
	public static final float SPEED = 60;
	
	private OrthographicCamera camera;
	private World world = new World(new Vector2(0,-1f), true);
	
	/**
	 * Temporary
	 * 
	 */
	Texture img;
	float x;
	float y;
	
	Entity testDummy = new Entity(world, BodyPresets.PLAYER, null);
	
	/**
	 * End Temporary
	 * 
	 */
	private SpaceGame game;
	
	public GameScreen(SpaceGame game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		img = new Texture("badlogic.jpg");

	    camera = new OrthographicCamera(WORLD_WIDTH ,WORLD_HEIGHT);
	    camera.position.set(WORLD_WIDTH/2,WORLD_HEIGHT/2,0);

	    Gdx.input.setInputProcessor(new MainInputProcessor(camera));
	}

	@Override
	public void render(float delta) {
		world.step(1/60f, 6, 2);
		
		
		
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.getBatch().begin();
		
		game.getBatch().setProjectionMatrix(camera.combined);
		testDummy.render(game.getBatch());
		game.getBatch().draw(img, x, y);
		
		/*
		 * Draw Everything now by passing the Batch in
		 */
		game.getBatch().end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		img.dispose();
		
	}

}
