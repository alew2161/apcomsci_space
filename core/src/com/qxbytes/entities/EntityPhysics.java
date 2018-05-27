package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
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
		
//		PolygonShape shape = new PolygonShape();
//        shape.setAsBox(128 / Const.PTM, 128
//                        / Const.PTM);
//
//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = shape;
//        fixtureDef.density = 0.1f;

        entityBody.createFixture(fixture);

//        shape.dispose();

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
