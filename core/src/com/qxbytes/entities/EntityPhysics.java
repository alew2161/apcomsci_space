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
	public EntityPhysics(Entity entity, World world, BodyDef definition) {
		definition.position.set(200, 200);
		entityBody = world.createBody(definition);
		
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(
        		entity.getGraphics().getSprite().getWidth()/2 / BodyPresets.PIXELS_TO_METERS,
        		entity.getGraphics().getSprite().getHeight()
                /2 / BodyPresets.PIXELS_TO_METERS);
        
        FixtureDef x = BodyPresets.NORMAL;
        x.shape = shape;
        entityBody.createFixture(x);
        
        shape.dispose();

	}
	
	public void update() {
		System.out.println("Location: "+ entityBody.getPosition());
	}
	public Body getEntityBody() {
		return entityBody;
	}
	public void setEntityBody(Body entityBody) {
		this.entityBody = entityBody;
	}
	
}
