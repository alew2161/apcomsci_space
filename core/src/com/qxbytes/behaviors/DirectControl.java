package com.qxbytes.behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class DirectControl extends Behavior{

	@Override
	public void doBehavior() {
		if (disable) {
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			Vector2 loc = new Vector2(0,0.4f);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y > 2) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x,2);;

		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			Vector2 loc = new Vector2(0,-0.9f);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x > 3) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(3,this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y);;
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x < -3) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(-3,this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y);;

		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			Vector2 loc = new Vector2(-0.9f,0);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			Vector2 loc = new Vector2(0.9f,0);//needs to be replaced w/ world vector

			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		}
	}

}
