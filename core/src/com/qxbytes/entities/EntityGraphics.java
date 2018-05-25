package com.qxbytes.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityGraphics {
	String name;
	private Texture texture;
	private Sprite sprite;//change with animation

	/**
	 * Make it take an ANIMATION parameter ; make a method in Sprite Handler so that I can call the name of the animation through a simple method
	 * such as getAnimation(5) or getAnimation("run").
	 * @param fileName
	 */
	public EntityGraphics(String fileName) {
		fileName= name; //to fix scope of string
		create();
		/**probably won't use this but it's  helpful
    	pause();
    	resume();*/
		dispose();
	}

	public void create() {        
		/**
		 * Temp
		 */
		texture = new Texture("badlogic.jpg");
		sprite = new Sprite(texture);
	}

	public void dispose() {
		texture.dispose();
	}

	public void render(SpriteBatch g) {  
		/**
		 * We will ned to replace all instances of SPRITE with ANIMATION somehow. 
		 */
		g.draw(sprite,sprite.getX(),sprite.getY());
		

	}
	/**
	 * Temp Sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	
	

}