package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.qxbytes.behaviors.NothingSpecial;
import com.qxbytes.utils.SpriteHandler;
import com.qxbytes.world.SpaceGameWorld;

public class Bullet extends Entity {

	public Bullet(SpaceGameWorld world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(2), new NothingSpecial());
		// TODO Auto-generated constructor stub
		setHostile(true);
		this.getPhysics().getEntityBody().setGravityScale(0);
		//so 1 HP
		this.addHp(2);
	}

}
