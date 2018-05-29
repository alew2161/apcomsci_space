package com.qxbytes.behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.EntityPhysics;

public class DirectControl extends Behavior{

	public DirectControl(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBehavior() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			System.out.println("w");
			Vector2 world = new Vector2(Gdx.input.getX(), Gdx.input.getY());//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(Gdx.input.getX(),Gdx.input.getY());// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			System.out.println("a");
			Vector2 world = new Vector2(Gdx.input.getX(), Gdx.input.getY());//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(Gdx.input.getX(),Gdx.input.getY());// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			System.out.println("s");
			Vector2 world = new Vector2(Gdx.input.getX(), Gdx.input.getY()-10);//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(Gdx.input.getX(),Gdx.input.getY()+100);// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);
		}
		if(Gdx.input.isButtonPressed((Input.Buttons.LEFT))) {
			System.out.println("mouse");
			Vector2 world = new Vector2(10,-.5f);//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(10,10);// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);
		}
		

	}

}
