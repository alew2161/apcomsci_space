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
	/**
	 * Initializer block WILL THROW an error!
	 */
	public SpriteHandler() {
		createAnimation("spritesheet.atlas");
		getAnimation(0);
	}

	private static void createAnimation(String fileName) {
		textureAtlas = new TextureAtlas(Gdx.files.internal(fileName));
		animation = new Animation<TextureRegion>(1f/15f, textureAtlas.getRegions());
		allAnimations.add(animation);
		System.out.println("animation added "+fileName);
	}



	public static Animation<TextureRegion> getAnimation(int num) {
		return allAnimations.get(num);
		
	}


}