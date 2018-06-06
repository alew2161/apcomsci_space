package com.qxbytes.screens;

import com.badlogic.gdx.Screen;
import com.qxbytes.spacegame.SpaceGame;

/**
 */
public class WinScreen implements Screen {
	private SpaceGame theGame;
	public WinScreen(SpaceGame theGame) {
		this.theGame = theGame;
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		theGame.getBatch().begin();
		
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
		// TODO Auto-generated method stub
		
	}

}
