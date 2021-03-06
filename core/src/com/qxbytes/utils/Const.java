package com.qxbytes.utils;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Const {
	public static final int NOAI = -1;
	public static final int IDLE = 0;
	public static final int MOVE_RIGHT = 1;
	public static final int MOVE_DOWN = 2;
	public static final int MOVE_LEFT = 3;
	public static final int MOVE_UP = 4;
	
	
	/**
	 * DIVIDE = Pixels --> Meters
	 * MULTIPLY = Meters --> Pixels
	 */
	public static final float PTM = 100f;
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
