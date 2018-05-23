package com.qxbytes.entities;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;//import statements
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Timer;
public class EntityGraphics{
	private SpriteBatch batch;
	private TextureAtlas textureAtlas; // defines necessities 
	private Sprite sprite;
	private int currentFrame = 1; //defines which image file to display 
	private String currentAtlasKey = new String(""); //need to use sprite packer tool to create atlas

	/**
	 * Run only once
	 */
	public EntityGraphics() {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/spritesheet.atlas"));
		AtlasRegion region = textureAtlas.findRegion("0001");
		sprite = new Sprite(region);
		sprite.setPosition(120, 100);
		sprite.scale(2.5f);
	}

	public void run() {
		currentFrame++;
		try {
			Thread.sleep(001);
			if(currentFrame > 20)
				currentFrame = 1;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		currentAtlasKey = String.format("%04d", currentFrame);
		sprite.setRegion(textureAtlas.findRegion(currentAtlasKey));
	}




	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
	}

	/**
	 * Called 120 fps
	 * @param g
	 */
	public void render(SpriteBatch g) {
		 run();

	     sprite.draw(g);

	}


	public void resize( int width, int height) {

	}


	public void pause() {
}}
