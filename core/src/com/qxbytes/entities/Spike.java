package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.DoNothing;
import com.qxbytes.utils.SpriteHandler;

public class Spike extends Entity {
	public Spike(World world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(1), new DoNothing());
		// TODO Auto-generated constructor stub
	}

}
