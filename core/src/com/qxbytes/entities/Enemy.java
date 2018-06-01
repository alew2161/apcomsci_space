package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.MoveTowards;
import com.qxbytes.utils.SpriteHandler;

public class Enemy extends Entity {
	public Enemy(World world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(0), new MoveTowards());
		// TODO Auto-generated constructor stub
	}

}
