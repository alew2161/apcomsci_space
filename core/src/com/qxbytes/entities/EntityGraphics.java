package com.qxbytes.entities;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityGraphics {
	String name;
	private Texture texture;
	private Sprite sprite;//change with animation

	/**
	 * TODO:
	 * Make it take an ANIMATION parameter ; make a method in Sprite Handler so that I can call the name of the animation through a simple method
	 * such as getAnimation(5) or getAnimation("run").
	 * @param fileName
	 */
	
	public EntityGraphics(String fileName) {
		name = fileName; //to fix scope of string. Owen can't figure out which side is assigned to which. It's left <-- right
		create();
		
	}

	public void create() {        
		/**
		 * Temp
		 */
		texture = new Texture(name);
		sprite = new Sprite(texture);
		

	}

	public void render(SpriteBatch g) {  
		/**
		 * We will ned to replace all instances of SPRITE with ANIMATION somehow. 
		 */

		g.draw(sprite,sprite.getX()*Const.PTM,sprite.getY()*Const.PTM);


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