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
		this.positionData = new Sprite(animation.getKeyFrame(1).getTexture());
		this.positionData.setRegionHeight(animation.getKeyFrame(1).getRegionHeight());
		this.positionData.setRegionWidth(animation.getKeyFrame(1).getRegionWidth());
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
		g.draw(animation.getKeyFrame(lifetime),(positionData.getX()*Const.PTM-positionData.getRegionWidth()/2),(positionData.getY()*Const.PTM)-positionData.getRegionHeight()/2);
		System.out.println(positionData.getX()*Const.PTM);
		System.out.println(positionData.getY()*Const.PTM);

	}
	/**
	 * Temp Sprite
	 */
	public Sprite getPositionData() {
		return positionData;
	}


	
	

}