package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.DirectControl;
import com.qxbytes.utils.SpriteHandler;

public class Player extends Entity {
	public Player(World world, BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels) {
		super(world, type, xPixels, yPixels, widthPixels, heightPixels, SpriteHandler.getAnimation(5), new DirectControl());
		this.addHp(4);//so hp = 3
	}
	public void render(SpriteBatch g) {
		super.render(g);
	}
}
