package com.qxbytes.spacegame;

import java.time.Instant;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.qxbytes.screens.MainMenuScreen;

public class SpaceGame extends Game {
	/**
	 *@author Alexander Lew
	 *@author Owen Ryan
	 *@author Edward Choi
	 */
	private SpriteBatch batch;
	final float init = Instant.now().getEpochSecond();

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
		if(1==0) {
			this.setScreen(new MainMenuScreen(this));
		}
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
	
	public float getInit() {
		return init;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
}
