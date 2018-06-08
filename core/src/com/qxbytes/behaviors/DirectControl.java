package com.qxbytes.behaviors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.qxbytes.entities.Bullet;
import com.qxbytes.screens.GameScreen;
import com.qxbytes.utils.Const;

public class DirectControl extends Behavior{
	int lastshot = 0;
	@Override
	public void doBehavior() {

		if(Gdx.input.isKeyPressed(Input.Keys.W)){
			Vector2 loc = new Vector2(0,0.6f);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y > 4) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x,4);;
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y < -4) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x,-4);;

		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			Vector2 loc = new Vector2(0,-0.9f);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
		}
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x > 3) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(3,this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y);;
		if (this.getEntity().getPhysics().getEntityBody().getLinearVelocity().x < -3) this.getEntity().getPhysics().getEntityBody().setLinearVelocity(-3,this.getEntity().getPhysics().getEntityBody().getLinearVelocity().y);;

		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			Vector2 loc = new Vector2(-0.9f,0);//needs to be replaced w/ world vector
			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
			getEntity().setState(3);

		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			Vector2 loc = new Vector2(0.9f,0);//needs to be replaced w/ world vector

			this.getEntity().getPhysics().getEntityBody().applyForceToCenter(loc, true);
			getEntity().setState(1);

		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isButtonPressed(Buttons.LEFT)) {
			if (GameScreen.rendersTemp > lastshot+60) {
				lastshot = GameScreen.rendersTemp;
				int state = getEntity().getState();
				int offx = 0;
				int offy = 0;

				switch (state) {

				case 1:
					offx = 30;
					break;
				case 2:
					offy = +30;
					break;
				case 3:
					offx = -30;
					break;
				case 4:
					offy = -30;
					break;

				}

				Bullet bullet = new Bullet(
						this.getEntity().getGameWorld(),
						BodyDef.BodyType.DynamicBody,
						getEntity().getPhysics().getEntityBody().getPosition().x * Const.PTM + offx,
						getEntity().getPhysics().getEntityBody().getPosition().y * Const.PTM + offy,
						15,
						15);
				bullet.getPhysics().getEntityBody().applyForceToCenter(offx/4, offy/4,true);
				bullet.setHostile(false);
				this.getEntity().getGameWorld().getQueue().add(bullet
						);
			}
		}
	}

}
