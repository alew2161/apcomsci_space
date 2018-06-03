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
					20,
					20);
			bullet.getPhysics().getEntityBody().applyForceToCenter(offx/3, offy/3,true);
			this.getEntity().getGameWorld().getQueue().add(bullet
					);
		}
	}

}
