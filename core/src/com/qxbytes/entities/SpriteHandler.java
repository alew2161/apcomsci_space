package com.qxbytes.entities;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class SpriteHandler {

	private static ArrayList<Animation<TextureRegion>> allAnimations = new ArrayList<Animation<TextureRegion>>();
	private static TextureAtlas textureAtlas;
	private static Animation<TextureRegion> animation;
	TiledMapTileLayer collisionLayer = new TiledMapTileLayer(0, 0, 0, 0);

	public SpriteHandler() {
		createAnimation("redRobotWalkRight.atlas", 0.2f);
		createAnimation("spikeSpriteSheet.atlas", .2f);
		createAnimation("bullet.atlas", .2f);
		createAnimation("turretSpriteSheet.atlas", .5f);
		/**
		 * Can't have this - all sprites are ON ONE sprite sheet, BUT each has a DIFFERENT texture atlas!
		 */
		createAnimation("dumpSpriteSheet.atlas", .2f);
		createAnimation("greenRobotWalkRight.atlas", .2f);
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