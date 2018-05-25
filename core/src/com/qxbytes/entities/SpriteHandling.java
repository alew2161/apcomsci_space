package com.qxbytes.entities;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class SpriteHandling {

	private ArrayList<Animation> allAnimations = new ArrayList<Animation>();
	SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation animation;
	public void createAnimation(String fileName) {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal(fileName));
		animation = new Animation(1f/15f, textureAtlas.getRegions());
		allAnimations.add(animation);
	}
	
	public SpriteHandling(){
		createAnimation("a");
		createAnimation("b");
		createAnimation("c");
	}
	
	public Animation getAnimation(int num) {
		return allAnimations.get(num);
	}


}