package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.Behavior;
import com.qxbytes.behaviors.NothingSpecial;
import com.qxbytes.utils.SpriteHandler;

public class Bullet extends Entity {

	public Bullet(World world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels,
			Animation<TextureRegion> animation, Behavior behavior) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(2), new NothingSpecial());
		// TODO Auto-generated constructor stub
		setHostile(true);
		this.getPhysics().getEntityBody().setGravityScale(0);
	}

}
