package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.DirectControl;
import com.qxbytes.utils.SpriteHandler;
import com.qxbytes.world.SpaceGameWorld;

public class Player extends Entity {
	public Player(SpaceGameWorld world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(5), new DirectControl());
		this.addHp(17);//so hp = 15
	      }
	public void render(SpriteBatch g) {
		super.render(g);
	}
}
