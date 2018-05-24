package com.qxbytes.spacegame;

import com.badlogic.gdx.Game;
import com.qxbytes.screens.MainMenuScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.qxbytes.screens.GameScreen;

public class SpaceGame extends Game {
	
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}
 
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
}
