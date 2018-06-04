package com.qxbytes.utils;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class SpriteHandler {

	private static ArrayList<Animation<TextureRegion>> allAnimations = new ArrayList<Animation<TextureRegion>>();
	private static TextureAtlas textureAtlas;
	private static Animation<TextureRegion> animation;

	public SpriteHandler() {
		createAnimation("redRobotWalkRight.atlas", 0.2f);
		createAnimation("spikeSpriteSheet.atlas", .2f);
		createAnimation("electricity.atlas", .2f);
		createAnimation("turretSpriteSheet.atlas", .5f);
		/**
		 * Can't have this - all sprites are ON ONE sprite sheet, BUT each has a DIFFERENT texture atlas!
		 */
		createAnimation("dumpSpriteSheet.atlas", .2f);
		createAnimation("greenRobotWalkRight.atlas", .2f);
		createAnimation("electricity.atlas", .2f);
		createAnimation("end.atlas",.2f);
	}

	private static void createAnimation(String fileName, float frameDuration) {
		textureAtlas = new TextureAtlas(Gdx.files.internal(fileName));
		animation = new Animation<TextureRegion>(frameDuration, textureAtlas.getRegions());
		allAnimations.add(animation);
		System.out.println("animation added "+fileName);
	}
/*private void generateTerrain(String fileName, float frameDuration) {
	
	map = new TmxMapLoader().load("untitled1.tmx");
	MapLayer objects = map.getLayers().get("object");
	objects.
	textureAtlas = new TextureAtlas(Gdx.files.internal(fileName));
	animation = new Animation<TextureRegion>(frameDuration, textureAtlas.getRegions());
	allAnimations.add(animation);
	System.out.println("animation added "+fileName);
}*/
	public static Animation<TextureRegion> getAnimation(int num) {
		return allAnimations.get(num);
		
	}


}