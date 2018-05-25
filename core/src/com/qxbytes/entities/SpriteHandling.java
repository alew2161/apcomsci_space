package com.qxbytes.entities;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class SpriteHandling {
	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Sprite sprite;
	private int currentFrame = 1;
	private String currentAtlasKey = new String("0001");
	private ArrayList<Animation> allAnimations = new ArrayList<Animation>();
	private ArrayList<Sprite> allSprites = new ArrayList<Sprite>();
	/**
	 * Constructor also renders animation so graphics class is redundant for animations
	 * @param Atlas
	 * @param SizeX
	 * @param SizeY
	 */
	public SpriteHandling(String FileName) {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal(FileName));
		AtlasRegion region = textureAtlas.findRegion("0001");
		sprite = new Sprite(region);
		
	}
	public Animation getAnimation(int num) {
		return allAnimations.get(num);
	}
	public Sprite getSprite(int num) {
		return allSprites.get(num);
	}
	public void createSprite(String FileName) {        
		
		/**
		  sprite.setPosition(120, 100);
		sprite.scale(2.5f);used in 
		 * Timer.schedule(new Task(){
			@Override
			public void run() {
				currentFrame++;
				if(currentFrame > 20)
					currentFrame = 1;
				currentAtlasKey = String.format("%04d", currentFrame);
				sprite.setRegion(textureAtlas.findRegion(currentAtlasKey));
			}
		}
		,0,1/30.0f);*/
	}

	/**public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
	}

	public void render() {        
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	public void resize(int width, int height) {
	}*/
}