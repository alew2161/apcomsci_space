package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.qxbytes.afterspace.SpaceGame;

public class GameScreen implements Screen{
	
	public static final float SPEED = 120;
	
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
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			y+= SPEED * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			y-= SPEED * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			x-= SPEED * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			x+= SPEED * Gdx.graphics.getDeltaTime();
		}
		
		game.getBatch().begin();
		game.getBatch().draw(img, x, y);
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
