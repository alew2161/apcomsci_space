package com.qxbytes.screens;

import java.time.Instant;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.qxbytes.entities.Const;
import com.qxbytes.entities.Entity;

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
	private int hp,lives;
	private float init,score,sw,sh;
	OrthographicCamera camera;
	Table table = new Table();
	
	private Label s,l,t,pos;
	
	public HudOverlay(Entity ent,float init,float sw,float sh,OrthographicCamera camera) {
		/**
		 *	ok so maby widgets are need too later. 
		 * 
		 **/
		this.ent = ent;
		this.init = init;	//	Stage Init time.
		this.sw = sw;
		this.sh = sh;

		this.camera = camera;
		viewport = new FitViewport(sw, sh, camera);
	    hud = new Stage(viewport);
	    table.top();
	    table.setFillParent(true);

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
	    
	    	table.add(pos).expandX().padTop(10);
	    }
	    table.row();
	    hud.addActor(table);
	}
	
	/**
	 * Hud updater.
	 * 
	 * @param hp Player HP
	 * @param score Player Score
	 */
	public void update(int hp,float score) {
//		System.out.print(( (int)(Instant.now().getEpochSecond())  +" "+ (int)(init) )+"\n");
		if(debug) {
			pos.setText(
					String.format(
									"x: %f, y: %f", 
									(ent.getPhysics().getEntityBody().getPosition().x)*Const.PTM,
									(ent.getPhysics().getEntityBody().getPosition().y)*Const.PTM
								)
						);
		}
		hud.getViewport().update(((int)Math.round(sw)),((int)Math.round(sh)),true);
		hud.draw();
		//	https://gamedev.stackexchange.com/questions/31379/how-do-i-make-an-on-screen-hud-in-libgdx
	}
	@Override
	public void dispose() { 
		hud.dispose(); 
	}
}
