package com.qxbytes.entities;

import com.badlogic.gdx.physics.box2d.BodyDef;

public class BodyPresets {
	public static final BodyDef GROUND = new BodyDef();
	public static final BodyDef ENEMY = new BodyDef();
	public static final BodyDef BULLET = new BodyDef();
	public static final BodyDef PLAYER = new BodyDef();
	public static final BodyDef BLOCK = new BodyDef();
	

	
	{
		GROUND.type = BodyDef.BodyType.StaticBody;
		BLOCK.type = BodyDef.BodyType.StaticBody;
		ENEMY.type = BodyDef.BodyType.DynamicBody;
		PLAYER.type = BodyDef.BodyType.DynamicBody;
		BULLET.type = BodyDef.BodyType.DynamicBody;
		
	}
}
