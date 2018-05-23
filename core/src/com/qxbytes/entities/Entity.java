package com.qxbytes.entities;
/*owen was here
 * 
 * 
 * NOTE: THIS CLASS ONLY WORKS FOR ONE SPRITE 
 * & OBJECT ORIENTED CANNOT BE USED SO
 * THERES GONNA BE ALOT OF CLASSES UNLESS WHOEVER
 * IS DESIGNING THE ANIMATIONS DECIDES TO PUT EVERY
 * ON ONE SPRITE SHEET
 * 
 */
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Entity implements ApplicationListener{
	private static final int FRAME_COLS = 6, FRAME_ROWS = 5; //number of rows & columns on atlas

	private float elapsedTime; //seconds counter determining when to restart animation meme
	private SpriteBatch batch0;
	private Texture textureAtlas0;
	private Animation<TextureRegion> animation0; //need <TextureRegion> to specify attributes with batch.draw & batch.clear



	public void create() { 
		// Load the sprite sheet as a Texture
		textureAtlas0 = new Texture(Gdx.files.internal("meme.png"));
		//need to use libgdx tool to configure atlas
		//splicing sprite sheet
		TextureRegion[][] tmp = TextureRegion.split(textureAtlas0, 
				((Graphics) textureAtlas0).getWidth() / FRAME_COLS,//finding height & width of sprite
				((Graphics) textureAtlas0).getHeight() / FRAME_ROWS);

		//make sprites linear WTH ISNT SPRITES A WORD
		TextureRegion[] sprite0 = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				sprite0[index++] = tmp[i][j];
			}
		}

		//defining animation & specifying FPS (change fps based on # of sprites)
		animation0 = new Animation<TextureRegion>(0.025f, sprite0);

		// Instantiate a SpriteBatch for drawing and reset the elapsed animation
		// time to 0
		batch0 = new SpriteBatch();//creating a batch
		elapsedTime = 0f; // setting time to 0
		/*batch0 = new SpriteBatch(); 
		textureAtlas0 = new TextureAtlas(Gdx.files.internal("meme.atlas"));
		animation0 = new Animation<TextureRegion>(0.025f, textureAtlas0);*/
	}

	public void dispose() {//disposing of animation & stored atlas/batch
		batch0.dispose();
		textureAtlas0.dispose();
	}

	public void render() {        
		Gdx.gl.glClearColor(0, 0, 0, 1);// clear screen in order to update
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// may need to be changed to GL10 modifier, but currently works *GL10 is not present in library!
		elapsedTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

		// Get current frame of animation for the current stateTime
		TextureRegion currentFrame = animation0.getKeyFrame(elapsedTime, true);
		batch0.begin();
		batch0.draw(currentFrame, 50, 50); // Draw current frame at (50, 50)
		batch0.end();
	}
	//unimplemented methods from here on
	public void resize(int width, int height) {
	}

	public void pause() {
	}

	public void resume() {
	}

}