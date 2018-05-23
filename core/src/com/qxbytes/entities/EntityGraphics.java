package com.qxbytes.entities;
/**@author boson*/
import javax.xml.bind.JAXBElement.GlobalScope;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityGraphics implements ApplicationListener {
	String name;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;


	public EntityGraphics(String fileName) {
		fileName= name; //to fix scope of string
		create();
		render();
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

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {  
		/**
		 * clearColor is being used to erase the previous frame in order to replace it w/ next one
		 */
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
/**as of now, these are not being used
 */
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}