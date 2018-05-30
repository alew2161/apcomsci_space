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
			System.out.println("mouse");
			Vector2 world = new Vector2(0,0.5f);//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(0,0);
			loc.add(world);// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			System.out.println("mouse");
			Vector2 world = new Vector2(-0.5f,0);//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(0,0);
			loc.add(world);// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			System.out.println("mouse");
			Vector2 world = new Vector2(0,-0.5f);//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(0,0);
			loc.add(world);// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			System.out.println("mouse");
			Vector2 world = new Vector2(0.5f,0);//needs to be replaced w/ world vector
			Vector2 loc= new Vector2(0,0);
			loc.add(world);// needs to be replaced w/ pos of entity
			this.getEntity().getPhysics().getEntityBody().applyForce(world, loc, true);
		}
		

	}

}
