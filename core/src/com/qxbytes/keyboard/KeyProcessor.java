package com.qxbytes.keyboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class KeyProcessor {
	//should be in entities class
	Sprite player = new Sprite();
	public void detectInput() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			System.out.println("w");
			 player.translateX(1f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			System.out.println("a");
			player.translateY(-1f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			System.out.println("s");
			player.translateY(-.5f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			System.out.println("d");
			player.translateX(1f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
			System.out.println("q");
			/**code for calling animation 1*/
		}
		if(Gdx.input.isKeyPressed(Input.Keys.E)) {
			System.out.println("e");
			/**code for calling animation2*/
		}
	}
}
