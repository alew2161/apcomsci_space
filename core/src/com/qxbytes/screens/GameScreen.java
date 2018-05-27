package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.camera.MainInputProcessor;
import com.qxbytes.entities.Const;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.SpriteHandler;
import com.qxbytes.keyboard.KeyProcessor;
import com.qxbytes.spacegame.SpaceGame;

/**
 * Main Game screen.
 * @param game SpaceGame
 */
public class GameScreen implements Screen {
	
	final float WORLD_WIDTH = Gdx.graphics.getWidth();
	final float WORLD_HEIGHT = Gdx.graphics.getHeight();
	
	public static final float SPEED = 60;
	
	private Box2DDebugRenderer debug;
	private     Matrix4 debugMatrix;

	private OrthographicCamera camera;
	private World world = new World(new Vector2(0,-1f), true);
	
	/**
	 * Temporary
	 * 
	 */
	Texture img;
	float x;
	float y;
	
	/**
	 * Insert TEST Sprite handler image
	 */
	
	Entity testDummy = new Entity(world, Const.PLAYER, SpriteHandler.);
	
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
        debug = new Box2DDebugRenderer();

	}

	@Override
	public void render(float delta) {
		world.step(delta, 6, 2);
		
		KeyProcessor a = new KeyProcessor();
		a.detectInput();
		
		
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		debugMatrix = game.getBatch().getProjectionMatrix().cpy().scale(Const.PTM, 
                Const.PTM, 0);
		game.getBatch().begin();
		
		game.getBatch().setProjectionMatrix(camera.combined);
		testDummy.render(game.getBatch());
		game.getBatch().draw(img, x, y);
		
		/*
		 * Draw Everything now by passing the Batch in
		 */
		game.getBatch().end();
        debug.render(world, debugMatrix);

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
