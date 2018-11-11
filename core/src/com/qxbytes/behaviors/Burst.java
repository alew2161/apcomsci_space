package com.qxbytes.behaviors;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.qxbytes.entities.Bullet;
import com.qxbytes.screens.GameScreen;
import com.qxbytes.utils.Const;

public class Burst extends Behavior {

	public Burst() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doBehavior() {

		if (GameScreen.rendersTemp % 10 == 0) {
			
			for (int i = GameScreen.rendersTemp ; i < 360+GameScreen.rendersTemp ; i+=120) {
				int offx = (int) (Math.cos(Math.toRadians(i))*30);
				int offy = (int) (Math.sin(Math.toRadians(i))*30);
				Bullet bullet = new Bullet(
						this.getEntity().getGameWorld(),
						BodyDef.BodyType.DynamicBody,
						getEntity().getPhysics().getEntityBody().getPosition().x * Const.PTM +offx,
						getEntity().getPhysics().getEntityBody().getPosition().y * Const.PTM +offy,
						15,
						15);
				bullet.getPhysics().getEntityBody().applyForceToCenter(offx/8, offy/8,true);
				this.getEntity().getGameWorld().getQueue().add(bullet
						);
			}
		}
	}

}
