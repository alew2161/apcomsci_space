package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.qxbytes.behaviors.NothingSpecial;
import com.qxbytes.utils.SpriteHandler;
import com.qxbytes.world.SpaceGameWorld;

public class End extends Entity {

	public End(SpaceGameWorld world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(7), new NothingSpecial());
		this.getPhysics().getEntityBody().setGravityScale(0);
	}

}
