package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class CollisionEffects implements ContactListener{
	/**
	 * Probably the ABSOLUTE WORST CLASS I have written this entire program. Not OOP at all!
	 */
	@Override
	public void beginContact(Contact contact) {
		/**
		 * Go from least to most general
		 */
		//only collisions where entities are involved
		if (contact.getFixtureA().getBody().getUserData() instanceof Entity && contact.getFixtureB().getBody().getUserData() instanceof Entity) {

			Entity fixA = ((Entity)contact.getFixtureA().getBody().getUserData());
			Entity fixB = ((Entity)contact.getFixtureB().getBody().getUserData());
			//you gotta be alive to take damage, right?
			if (!fixA.isDead() && !fixB.isDead()) {
				if (fixA.isHostile() != fixB.isHostile()) {
					fixA.takeDamage();
					fixB.takeDamage();
				}
			}
		}
		//bullets colliding into walls
		if (contact.getFixtureA().getBody().getUserData() instanceof Bullet) {
			((Entity)contact.getFixtureA().getBody().getUserData()).takeDamage();
		}
		if (contact.getFixtureB().getBody().getUserData() instanceof Bullet) {
			((Entity)contact.getFixtureB().getBody().getUserData()).takeDamage();
		}
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub

	}

}
