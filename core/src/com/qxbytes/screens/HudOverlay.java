package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.qxbytes.entities.Entity;
import com.qxbytes.spacegame.SpaceGame;
import com.qxbytes.utils.Const;


/**
 * the game's hud updater
 * 
 * This music was used in the making of this code 
 * https://youtu.be/ZnwH-qULAtk
 * 
 * @param ent Character Entity
 * @param init Stage Init time.
 * @param sw screen width
 * @param sh screen height
 * @param canera Camera
 * @author spectators
 **/
public class HudOverlay implements Disposable{
	
	final boolean debug = true;
	public Stage hud;
	private Viewport viewport;
	Entity ent;
	private float init,score,sw,sh;
	OrthographicCamera camera;
	private SpaceGame game;
	private ShapeRenderer shape;
	
	Table top = new Table(), 
			bottom = new Table();
	
	
	private Label h,
				s,
				l,
				t,
				pos,
				fps,
				p,
				speec;
	
	
	public HudOverlay(SpaceGame game, Entity ent,float init,float sw,float sh,OrthographicCamera camera) {
		/**
		 *	ok so maby widgets are need too later. 
		 * 
		 **/
		this.game = game;
		this.ent = ent;
		this.init = init;	//	Stage Init time.
		this.sw = sw;
		this.sh = sh;

		this.camera = camera;
		viewport = new FitViewport(sw, sh, camera);
		
		shape = new ShapeRenderer();
		shape.setProjectionMatrix(game.getBatch()
				.getProjectionMatrix());
			
		hud = new Stage(viewport);
		
		/*
		 *	Labels. 
		 *
		 */
		
	    top.setFillParent(true);
	    top.top();
	    bottom.setFillParent(true);
	    bottom.bottom();
/*	    this.t = new Label(
				String.format(
						"time: %fs", 
						(0.0)
						), 
				new Label.LabelStyle(
						new BitmapFont(), 
						Color.WHITE
						)
				);*/
	    
//	    table.add(t).expandX().padTop(10);	//time
	    
	    if(debug) {
	    	this.pos = new Label(
					String.format(
								"x: %f, y: %f", 
								(ent.getPhysics().getEntityBody().getPosition().x)*Const.PTM,
								(ent.getPhysics().getEntityBody().getPosition().y)*Const.PTM
							), 
					new Label.LabelStyle(
							new BitmapFont(), 
							Color.WHITE
							)
	    			);
	    	this.fps = new Label(
	    			String.format(
	    					"%d fps", 
	    					Gdx.graphics.getFramesPerSecond()
	    					),
	    			new Label.LabelStyle(
	    					new BitmapFont(), 
	    					Color.WHITE
	    					)
	    			);
	    	top.add(pos).expandX().padTop(10);
	    	top.add(fps).expandX().padTop(10);
	    }
	    
	    String hp = "|";
	    for (int i = 0 ; i < ent.getHp(); i++) {
	    	hp += "+|";
	    }
	    
	    this.h = new Label(
    			String.format(
    					"HP: ",
    					hp
    					), 
    			new Label.LabelStyle(
    					new BitmapFont(), 
    					Color.CYAN
    					)
    			);
	    this.h.setFontScale(1);
	    bottom.add(h).expandX().padTop(10);
	    
	    //top()
	    bottom.row();
	    hud.addActor(top);
	    hud.addActor(bottom);
	    
	    /*
	     *	Mouse Pointer
	     * 
	     */
	    
	    this.p = new Label(
	    			"*",
	    			new Label.LabelStyle(
	    					new BitmapFont(), 
	    					Color.CYAN
    					)
	    			); 
	    p.setPosition(Gdx.input.getX(),camera.viewportHeight - Gdx.input.getY());
	    hud.addActor(p);
	}
	
	/**
	 *	Speech Bubbles.
	 * 
	 *	@param text Speech text
	 */
	public void speech(String text) {
		shape.begin(ShapeType.Filled);
		shape.setColor(Color.GRAY);
		shape.rect(Gdx.graphics.getWidth()/2 + 450f, Gdx.graphics.getHeight()/2 + 180f, 200f, 200f);
		shape.end();
		Label speectext = new Label(
				String.format(
						text
						),
				new Skin(
						Gdx.files.internal("uiskin.json")
						),
				"default"
				);
		speectext.setPosition(1100,600);	//	fix- i don't know positioning
		speectext.setWidth(200f);
		speectext.setHeight(200f);
		hud.addActor(speectext);
//		hud.draw();
//		game.pause();
//		speectext.remove();
//		shape.dispose();
	}
	
	/**
	 * Hud updater.
	 * 
	 * @param hp Player HP
	 * @param score Player Score
	 * @return void
	 */
	public void update() {
//		System.out.print(( (int)(Instant.now().getEpochSecond())  +" "+ (int)(init) )+"\n");

		/*
		 * Mouse Pointer
		 * 
		 */
		
		p.setPosition(Gdx.input.getX(), camera.viewportHeight - Gdx.input.getY());
		
		/*
		 *	Text Labels
		 *
		 */
		
		if(debug) {
			pos.setText(
					String.format(
									"pos x: %f, y: %f m x: %d, y: %d", 
									(ent.getPhysics().getEntityBody().getPosition().x)*Const.PTM,
									(ent.getPhysics().getEntityBody().getPosition().y)*Const.PTM,
									Gdx.input.getX(),
									Gdx.input.getY()
								)
						);
			fps.setText(
					String.format(
								"%d fps",
								Gdx.graphics.getFramesPerSecond()
							)
					);
		}
		 String hp = "|";
		    for (int i = 0 ; i < ent.getHp(); i++) {
		    	hp += "+|";
		    }
		if (ent.getInvincibility() > 0) {
			if (GameScreen.rendersTemp/3 % 3 == 0)h.setColor(Color.WHITE); else
			h.setColor(Color.BLACK);
		} else {
			h.setColor(Color.CYAN);
		}
		h.setText(
				"HP: "+ hp
				);
		
		hud.getViewport().update(((int)Math.round(sw)),((int)Math.round(sh)),true);
		hud.draw();
	}
	
	public Entity getEnt() {
		return ent;
	}

	public void setEnt(Entity ent) {
		this.ent = ent;
	}

	@Override
	public void dispose() { 
		hud.dispose(); 
	}
}
