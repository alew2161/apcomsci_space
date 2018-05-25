package com.qxbytes.entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class BodyPresets {
	public static final BodyDef GROUND = new BodyDef();
	public static final BodyDef ENEMY = new BodyDef();
	public static final BodyDef BULLET = new BodyDef();
	public static final BodyDef PLAYER = new BodyDef();
	public static final BodyDef BLOCK = new BodyDef();
	
	public static final FixtureDef LIGHT = new FixtureDef();
    public static final FixtureDef NORMAL = new FixtureDef();
    public static final FixtureDef HEAVY = new FixtureDef();


	{
		GROUND.type = BodyDef.BodyType.StaticBody;
		BLOCK.type = BodyDef.BodyType.StaticBody;
		ENEMY.type = BodyDef.BodyType.DynamicBody;
		PLAYER.type = BodyDef.BodyType.DynamicBody;
		BULLET.type = BodyDef.BodyType.DynamicBody;
		
		LIGHT.density = .25f;
		NORMAL.density = .50f;
		HEAVY.density = .75f;
	}
}
