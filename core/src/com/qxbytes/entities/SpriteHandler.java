package com.qxbytes.entities;
import java.io.Console;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteHandler {

	private static ArrayList<Animation<TextureRegion>> allAnimations = new ArrayList<Animation<TextureRegion>>();
	private static TextureAtlas textureAtlas;
	private static Animation<TextureRegion> animation;

	public SpriteHandler() {
		createAnimation("redRobotWalkRight.atlas", 0.2f);
		createAnimation("spikeSpriteSheet.atlas", .2f);
		createAnimation("bullet.atlas", .2f);
		createAnimation("turretSpriteSheet.atlas", 2f);
		createAnimation("dumpSpriteSheet.atlas", 2f);
		createAnimation("greenRobotWalk.atlas", 2f);
	}

	private static void createAnimation(String fileName, float frameDuration) {
		textureAtlas = new TextureAtlas(Gdx.files.internal(fileName));
		animation = new Animation<TextureRegion>(frameDuration, textureAtlas.getRegions());
		allAnimations.add(animation);
		System.out.println("animation added "+fileName);
	}



	public static Animation<TextureRegion> getAnimation(int num) {
		return allAnimations.get(num);
		
	}


}