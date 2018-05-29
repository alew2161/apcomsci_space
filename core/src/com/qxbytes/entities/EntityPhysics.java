package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class EntityPhysics {
	private Body entityBody;
	/**
	 * 
	 * @param world
	 * @param body definition
	 */
	public EntityPhysics(Entity entity, World world, BodyDef definition, FixtureDef fixture) {

		entityBody = world.createBody(definition);
		

        entityBody.createFixture(fixture);

	}
	
	public void update() {

	}
	public Body getEntityBody() {
		return entityBody;
	}
	public void setEntityBody(Body entityBody) {
		this.entityBody = entityBody;
	}
	
}
