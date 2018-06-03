package com.qxbytes.behaviors;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.qxbytes.entities.Bullet;
import com.qxbytes.screens.GameScreen;
import com.qxbytes.utils.Const;

public class FireAtWill extends Behavior {
	
	public FireAtWill() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBehavior() {

		if (GameScreen.rendersTemp % 120 == 0) {
			Bullet bullet = new Bullet(
					this.getEntity().getGameWorld(),
					BodyDef.BodyType.DynamicBody,
					getEntity().getPhysics().getEntityBody().getPosition().x * Const.PTM - 30,
					getEntity().getPhysics().getEntityBody().getPosition().y * Const.PTM,
					20,
					20);
			bullet.getPhysics().getEntityBody().applyForceToCenter(-10, 0,true);
			this.getEntity().getGameWorld().getQueue().add(bullet
					);
		}
	}

}
