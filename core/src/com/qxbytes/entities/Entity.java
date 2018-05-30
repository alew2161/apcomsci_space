package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Entity {
	private EntityGraphics graphics;
	private EntityPhysics physics;
    

	/**
	 * Ideally, when an object is created, a call to the Sprite Handler will return an animation to be passed into the constructor. Fix this
	 * Owen. Remember: Owen is not a word.
	 * @param world
	 * @param definition
	 * @param animation
	 */
	public Entity(World world, BodyDef definition, FixtureDef fixture, Animation<TextureRegion> animation) {
		initialize(world,definition,fixture,animation);
	}
	public Entity(World world, BodyDef.BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels, Animation<TextureRegion> animation) {
		BodyDef definition = new BodyDef();
		definition.position.set(xPixels/Const.PTM, yPixels/Const.PTM);
		definition.type = type;
		
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(widthPixels/2 / Const.PTM, heightPixels/2
                        / Const.PTM);
       

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = .5f;
        fixtureDef.restitution = 0.5f;

        initialize(world,definition,fixtureDef,animation);
	}
	public void initialize(World world, BodyDef definition, FixtureDef fixture, Animation<TextureRegion> animation) {
		graphics = new EntityGraphics(animation);
        physics = new EntityPhysics(this,world,definition,fixture);
	}
	public void render(SpriteBatch g) {
		graphics.render(g);
		physics.update();
		//Store the sprite the body represents in UserData
        physics.getEntityBody().setUserData(graphics.getPositionData());
        //Access the sprite
        ((Sprite)physics.getEntityBody().getUserData()).setPosition(physics.getEntityBody().getPosition().x,physics.getEntityBody().getPosition().y);
	
	}
	public EntityGraphics getGraphics() {
		return graphics;
	}
	public void setGraphics(EntityGraphics graphics) {
		this.graphics = graphics;
	}
	public EntityPhysics getPhysics() {
		return physics;
	}
	public void setPhysics(EntityPhysics physics) {
		this.physics = physics;
	}
	
}
