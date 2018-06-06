package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.qxbytes.spacegame.SpaceGame;
import com.qxbytes.utils.Const;

/**
 * Main menu screen.
 * @param game SpaceGame
 */
public class MainMenuScreen implements Screen {


	private Skin skin;
    private Stage stage;
    private Texture bg;
	SpaceGame game;
	BitmapFont font;
	private Label l;
	
	
	public MainMenuScreen(SpaceGame game) 
	{
		this.game = game;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub ok
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        bg = new Texture("titleScreen.png");
        stage = new Stage();
        
        
        final TextButton button = new TextButton("Start", skin, "default");
        final TextButton button1 = new TextButton("Exit game",skin,"default");
    	l = new Label(
			String.format(
						"Loading.. please wait."
					), 
			new Label.LabelStyle(
					new BitmapFont(), 
					Color.WHITE
					)
			);
    	
        button.setWidth(200f);
        button.setHeight(20f);
        button1.setWidth(200f);
        button1.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 10f);
        button1.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 50f);
        button.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	stage.addActor(l);
            	stage.draw();
            	game.setScreen(new GameScreen(game));
            
            }
        });
        button1.addListener(new ClickListener(){
            @Override 
            public void clicked(InputEvent event, float x, float y){
            	Gdx.app.exit();
            }
        });
        stage.addActor(button);;
        stage.addActor(button1);
        
        Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.getBatch().begin();
        game.getBatch().draw(bg, 0, 0 ,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        game.getBatch().end();
        stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		bg.dispose();
		game.getBatch().dispose();
	}

}
