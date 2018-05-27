package com.qxbytes.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EntityGraphics {
	//String name;
	private Sprite positionData;//THIS SPRITE WILL NEVER BE RENDERED AND IS ONLY USED FOR POSITION DATA
	private Animation<TextureRegion> animation;
	private int lifetime = 0;

	/**
	 * TODO:
	 * 
	 * @param animation
	 */
	
	public EntityGraphics(Animation<TextureRegion> animation) {
		this.animation = animation;
		this.positionData = new Sprite(animation.getKeyFrame(0).getTexture());
		//create();
	
	}

//	public void create() {        
//		/**
//		 * Temp
//		 */
//		texture = new Texture(name);
//		sprite = new Sprite(texture);
//		
//
//	}

	public void render(SpriteBatch g) {  
		/**
		 * We will ned to replace all instances of SPRITE with ANIMATION somehow. 
		 */
		lifetime+=Gdx.graphics.getDeltaTime();
		g.draw(animation.getKeyFrame(lifetime),positionData.getX()*Const.PTM-positionData.getWidth()/2,positionData.getY()*Const.PTM-positionData.getHeight()/2);


	}
	/**
	 * Temp Sprite
	 */
	public Sprite getPositionData() {
		return positionData;
	}


	
	

}