package com.qxbytes.entities;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.qxbytes.screens.GameScreen;
import com.qxbytes.utils.Const;

public class EntityGraphics {
	//String name;
	private Sprite positionData;	//THIS SPRITE WILL NEVER BE RENDERED AND IS ONLY USED FOR POSITION DATA
	private Animation<TextureRegion> animation;
	private float lifetime = 0;
	private Entity entity;


	public EntityGraphics(Entity entity,Animation<TextureRegion> animation) {
		this.entity = entity;
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
		lifetime+= GameScreen.deltaTime;
		TextureRegion currentFrame = animation.getKeyFrame(lifetime, true);
		
		boolean flipx = false;
		if (entity.getState() == 3) {
			flipx = true;
		}
		//draw(Texture texture, float x, float y, float width, float height, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY)
		g.draw(currentFrame.getTexture(),
				(positionData.getX()*Const.PTM-positionData.getRegionWidth()/2), 
				(positionData.getY()*Const.PTM)-positionData.getRegionHeight()/2,
				(positionData.getRegionWidth()), 
				positionData.getRegionHeight(),
				currentFrame.getRegionX(),
				currentFrame.getRegionY(),
				currentFrame.getRegionWidth(),
				currentFrame.getRegionHeight(),
				flipx, false);

		
	}
	/**
	 * Temp Sprite
	 */
	public Sprite getPositionData() {
		return positionData;
	}
}