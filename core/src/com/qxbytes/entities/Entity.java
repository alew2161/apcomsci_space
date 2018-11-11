package com.qxbytes.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.Behavior;
import com.qxbytes.utils.Const;
import com.qxbytes.world.SpaceGameWorld;

/**
 *	Entity class.
 *
 *	@param world 
 *	@param definition
 *	@param animation
 *	@author alew2161
 *	@author Metastable1883 
 **/
public class Entity {
	private SpaceGameWorld gameWorld;
	private EntityGraphics graphics;
	private EntityPhysics physics;
	private Behavior behavior;
	private int hp = -1; //i.e. invincible
	private int invincibility = 0;
	private int state = 1;
	private boolean hostile = false;
	private boolean isDead = false;
	
	/**
	 * Ideally, when an object is created, a call to the Sprite Handler will return an animation to be passed into the constructor. Fix this
	 * Owen. Also remember: Owen is not a word.
	 */
	public Entity(SpaceGameWorld gameWorld, BodyDef definition, FixtureDef fixture, Animation<TextureRegion> animation, Behavior behavior) {
		initialize(gameWorld,definition,fixture,animation,behavior);
	}
	public Entity(SpaceGameWorld gameWorld, BodyDef.BodyType type, float xPixels, float yPixels, float widthPixels, float heightPixels, Animation<TextureRegion> animation, Behavior behavior) {
		BodyDef definition = new BodyDef();
		definition.fixedRotation = true;
		definition.position.set(xPixels/Const.PTM, yPixels/Const.PTM);
		definition.type = type;
		
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(widthPixels/2 / Const.PTM, heightPixels/2
                        / Const.PTM);
       

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = .5f;
        fixtureDef.restitution = 0.3f;
        fixtureDef.friction = 1;	


        initialize(gameWorld,definition,fixtureDef,animation,behavior);
	}
	public void initialize(SpaceGameWorld gameWorld, BodyDef definition, FixtureDef fixture, Animation<TextureRegion> animation, Behavior behavior) {
		this.gameWorld = gameWorld;
		graphics = new EntityGraphics(this,animation);
        physics = new EntityPhysics(this,gameWorld.getWorld(),definition,fixture);
        this.behavior = behavior;
        this.behavior.addEntity(this);
        
	}
	public void render(SpriteBatch g) {
		graphics.render(g);
		
		if (state != Const.NOAI) {
			behavior.doBehavior();
		}
		physics.update();
		//Store the sprite the body represents in UserData
		physics.getEntityBody().setUserData(this);
        //Access the sprite
        ((Entity)physics.getEntityBody().getUserData()).getGraphics().getPositionData().setPosition(physics.getEntityBody().getPosition().x,physics.getEntityBody().getPosition().y);
        invincibility-=1;
	}
	
	public void takeDamage() {
		if (invincibility < 0) {
			this.hp -= 1;
			invincibility = 60;

			if (this.hp == 0) {
				this.isDead = true;
			}
		}
	}
	public void setState(Cell cell) {

		if (cell.getRotation() == 0) {
			/**
			 * Omfg this took so long and I still have zero idea why I have to do it this stupid way but #satisfaction in squashing a bug
			 */
			if (cell.getFlipHorizontally()) this.state = 3; else
			this.state = 1;
		} else if (cell.getRotation() == 1) {
			this.state = 2;
		} else if (cell.getRotation() == 2) {
			//never called
			this.state = 3;
		} else if (cell.getRotation() == 3) {
			this.state = 4;
		}
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public SpaceGameWorld getGameWorld() {
		return gameWorld;
	}
	public void setGameWorld(SpaceGameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public void addHp(int hp) {
		this.hp += hp;
	}
	public int getHp(){
		return this.hp;
	}
	public EntityGraphics getGraphics() {
		return graphics;
	}
	public void setGraphics(EntityGraphics graphics) {
		this.graphics = graphics;
	}
	public EntityPhysics getPhysics() {
		return physics;
	}
	public void setPhysics(EntityPhysics physics) {
		this.physics = physics;
	}
	public boolean isHostile() {
		return hostile;
	}
	public int getInvincibility() {
		return invincibility;
	}
	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}
	
	public boolean isDead() {
		return isDead;
	}
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
}
