package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.Behavior;

/**
 *	Entity class.
 *
 *	@param world 
 *	@param definition
 *	@param animation
 *	@author alew2161
 *	@author Metastable1883 
 **/
public class Entity {
	private EntityGraphics graphics;
	private EntityPhysics physics;
	private Behavior behavior;

	/**
	 * Ideally, when an object is created, a call to the Sprite Handler will return an animation to be passed into the constructor. Fix this
	 * Owen. Also remember: Owen is not a word.
	 */
	public Entity(World world, BodyDef definition, FixtureDef fixture, Animation<TextureRegion> animation, Behavior behavior) {
		initialize(world,definition,fixture,animation,behavior);
	}
	public Entity(World world, BodyDef.BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels, Animation<TextureRegion> animation, Behavior behavior) {
		BodyDef definition = new BodyDef();
		definition.fixedRotation = true;
		definition.position.set(xPixels/Const.PTM, yPixels/Const.PTM);
		definition.type = type;
		
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(widthPixels/2 / Const.PTM, heightPixels/2
                        / Const.PTM);
       

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = .5f;
        fixtureDef.restitution = 0.3f;
        fixtureDef.friction = 1;	


        initialize(world,definition,fixtureDef,animation,behavior);
	}
	public void initialize(World world, BodyDef definition, FixtureDef fixture, Animation<TextureRegion> animation, Behavior behavior) {
		graphics = new EntityGraphics(animation);
        physics = new EntityPhysics(this,world,definition,fixture);
        this.behavior = behavior;
        this.behavior.addEntity(this);
	}
	public void render(SpriteBatch g) {
		graphics.render(g);
		behavior.doBehavior();
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
