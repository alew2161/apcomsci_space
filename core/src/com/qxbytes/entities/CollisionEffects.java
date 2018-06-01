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
		//only collisions where player is involved
		if (contact.getFixtureA().getBody().getUserData() instanceof Player || contact.getFixtureB().getBody().getUserData() instanceof Player) {
			//only collisions where both are entities i.e. spikes, turrets, etc. (world objects have no user data)
			if (contact.getFixtureA().getBody().getUserData() instanceof Entity && contact.getFixtureB().getBody().getUserData() instanceof Entity) {
				//then remove one health from each
				((Entity)contact.getFixtureA().getBody().getUserData()).takeDamage(1);
				((Entity)contact.getFixtureB().getBody().getUserData()).takeDamage(1);
			}
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
