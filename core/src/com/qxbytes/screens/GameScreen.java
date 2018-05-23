package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.qxbytes.spacegame.SpaceGame;
import com.qxbytes.camera.CameraInputProcessor;

public class GameScreen implements Screen {
	
	final float WORLD_WIDTH = Gdx.graphics.getWidth();
	final float WORLD_HEIGHT = Gdx.graphics.getHeight();
	
	public static final float SPEED = 120;
	
	OrthographicCamera camera;

	Texture img;
	float x;
	float y;
	
	SpaceGame game;
	
	public GameScreen(SpaceGame game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		img = new Texture("badlogic.jpg");

	    camera = new OrthographicCamera(WORLD_WIDTH ,WORLD_HEIGHT);
	    camera.position.set(WORLD_WIDTH/2,WORLD_HEIGHT/2,0);

	    Gdx.input.setInputProcessor(new CameraInputProcessor(camera));
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.getBatch().begin();
		game.getBatch().setProjectionMatrix(camera.combined);
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
