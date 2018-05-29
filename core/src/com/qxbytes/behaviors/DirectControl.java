package com.qxbytes.behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.qxbytes.entities.Entity;

public class DirectControl extends Behavior{

	public DirectControl(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBehavior() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			System.out.println("w");
//			this.getEntity().getPhysics().getEntityBody().applyForce(100, Vector2.(something), wake);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			System.out.println("a");

		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			System.out.println("s");

		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			System.out.println("d");

		}
		if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
			System.out.println("q");

		}
		if(Gdx.input.isKeyPressed(Input.Keys.E)) {
			System.out.println("e");

		}
	}

}
