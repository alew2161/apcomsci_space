package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.qxbytes.behaviors.Burst;
import com.qxbytes.utils.SpriteHandler;
import com.qxbytes.world.SpaceGameWorld;

public class Boss extends Entity {
	public Boss(SpaceGameWorld world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(0), new Burst());
		// TODO Auto-generated constructor stub
		setHostile(true);
		addHp(4);
	}

}
