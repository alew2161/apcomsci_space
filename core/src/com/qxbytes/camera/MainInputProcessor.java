package com.qxbytes.camera;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainInputProcessor implements InputProcessor {
	private OrthographicCamera camera;
	public MainInputProcessor(OrthographicCamera camera) {
		this.camera = camera;
	}
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.RIGHT)
	         camera.translate(10f,0f);
	      if(keycode == Input.Keys.LEFT)
	         camera.translate(-10f,0f);
	      if(keycode == Input.Keys.UP)
	         camera.translate(0f,10f);
	      if(keycode == Input.Keys.DOWN)
	         camera.translate(0f,-10f);
		return false;
		//	delete later.
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
