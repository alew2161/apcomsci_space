package com.qxbytes.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityGraphics {
	String name;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;


	public EntityGraphics(String fileName) {
		fileName= name; //to fix scope of string
		create();
		/**probably won't use this but it's  helpful
    	pause();
    	resume();*/
		dispose();
	}

	public void create() {        
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal(name));
		sprite = new Sprite(texture);
	}

	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	public void render(SpriteBatch g) {  

		sprite.draw(g);

	}

}