package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
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
	public Entity(World world, BodyDef definition, Animation animation) {
		physics = new EntityPhysics(world,definition);//<-- Try to make it as simple as that
		
		//graphics = new EntityGraphics(animation);
	}
	public void render(SpriteBatch g) {
		graphics.render(g);
		physics.update();
		//TODO: Link up physics component with graphics component
	}
}
