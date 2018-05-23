package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class EntityPhysics {
	private Body entityBody;
	/**
	 * 
	 * @param world
	 * @param body definition
	 */
	public EntityPhysics(World world, BodyDef definition) {
		world.createBody(definition);
	}
}
