package com.qxbytes.behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class DirectControl extends Behavior{



	@Override
	public void doBehavior() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			Vector2 loc = new Vector2(0,0.5f);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			Vector2 loc = new Vector2(-0.5f,0);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			Vector2 loc = new Vector2(0,-0.5f);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			Vector2 loc = new Vector2(0.5f,0);//needs to be replaced w/ world vector

			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		

	}

}
