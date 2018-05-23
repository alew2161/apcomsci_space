package com.qxbytes.entities;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteHandling{
	private static final int FRAME_COLS = 8, FRAME_ROWS = 8; //number of rows & columns on atlas
	private Texture textureAtlas0;
	public void create(String fileName) { 
		textureAtlas0 = new Texture(Gdx.files.internal(fileName));
		//need to use libgdx tool to configure atlas
		TextureRegion[][] tmp = TextureRegion.split(textureAtlas0, 
				((Graphics) textureAtlas0).getWidth() / FRAME_COLS,//finding height & width of sprite
				((Graphics) textureAtlas0).getHeight() / FRAME_ROWS);
		TextureRegion[] sprite0 = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				sprite0[index++] = tmp[i][j];
			}
		}
		new Animation<TextureRegion>(0.025f, sprite0);
	}
}