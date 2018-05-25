package com.qxbytes.keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyProcessor {
	public void detectInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)){}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {}
		if(Gdx.input.isKeyPressed(Input.Keys.Q)) {}
		if(Gdx.input.isKeyPressed(Input.Keys.E)) {}
	}
}
