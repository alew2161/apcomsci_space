package com.qxbytes.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class SpriteHandling {
	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Sprite sprite;
	private int currentFrame = 1;
	private String currentAtlasKey = new String("0001");
	/**
	 * Constructor also renders animation so graphics class is redundant for animations
	 * @param Atlas
	 * @param SizeX
	 * @param SizeY
	 */
	public SpriteHandling(String Atlas, int SizeX, int SizeY) {
		create();
		resize(SizeX, SizeY);
		render();
		dispose();
	}

	public void create() {        
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheet.atlas"));
		AtlasRegion region = textureAtlas.findRegion("0001");
		sprite = new Sprite(region);
		sprite.setPosition(120, 100);
		sprite.scale(2.5f);
		Timer.schedule(new Task(){
			@Override
			public void run() {
				currentFrame++;
				if(currentFrame > 20)
					currentFrame = 1;
				currentAtlasKey = String.format("%04d", currentFrame);
				sprite.setRegion(textureAtlas.findRegion(currentAtlasKey));
			}
		}
		,0,1/30.0f);
	}

	public void dispose() {
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
	}
}