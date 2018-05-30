package com.qxbytes.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.DirectControl;
import com.qxbytes.behaviors.DoNothing;
import com.qxbytes.camera.MainInputProcessor;
import com.qxbytes.entities.Const;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.SpriteHandler;
import com.qxbytes.spacegame.SpaceGame;
import com.qxbytes.camera.CameraUpdater;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


/**
 * Main Game screen.
 * @param game SpaceGame
 */
public class GameScreen implements Screen {
	
	final float WORLD_WIDTH = Gdx.graphics.getWidth();
	final float WORLD_HEIGHT = Gdx.graphics.getHeight();
	
	public static final float SPEED = 60;
	public static float deltaTime = 0;
	private Box2DDebugRenderer debug;
	private     Matrix4 debugMatrix;

	private OrthographicCamera camera;
	private World world = new World(new Vector2(0,-.5f), true);
	SpriteHandler robot = new SpriteHandler();
	
	//Ground Entity
	Entity ground = new Entity(world,BodyDef.BodyType.StaticBody, -3200,0,12800,20,SpriteHandler.getAnimation(0),new DoNothing());
	
	/**
	 * Temporary Solution.
	 * 
	 */
	Texture img;
	float x;
	float y;
	
	/**
	 * Insert TEST Sprite handler image	
	 */
	
	private CameraUpdater cameraUdate;
	Entity testDummy = new Entity(world, BodyDef.BodyType.DynamicBody, 400, 400, 50, 50, SpriteHandler.getAnimation(0), new DirectControl());
	Entity testDummy1 = new Entity(world, BodyDef.BodyType.DynamicBody, 400, 400, 50, 50, SpriteHandler.getAnimation(1), new DoNothing());
	Entity testDummy2 = new Entity(world, BodyDef.BodyType.DynamicBody, 400, 400, 50, 50, SpriteHandler.getAnimation(2), new DoNothing());
	Entity testDummy3 = new Entity(world, BodyDef.BodyType.DynamicBody, 400, 400, 50, 50, SpriteHandler.getAnimation(3), new DoNothing());
	Entity testDummy4 = new Entity(world, BodyDef.BodyType.DynamicBody, 400, 400, 50, 50, SpriteHandler.getAnimation(4), new DoNothing());
	Entity testDummy5 = new Entity(world, BodyDef.BodyType.DynamicBody, 400, 400, 50, 50, SpriteHandler.getAnimation(5), new DoNothing());
private TiledMap map;
private OrthogonalTiledMapRenderer renderer;
	/**
	 * End Temporary
	 * 
	 */
	
	private SpaceGame game;
	
	public GameScreen(SpaceGame game) {
		this.game = game;
	}
	
	@Override
	public void show() {
		TmxMapLoader loader =new TmxMapLoader();
		map= loader.load("untitled1.tmx");
		//img = new Texture("untitled.png");

	    camera = new OrthographicCamera(WORLD_WIDTH ,WORLD_HEIGHT);
	    camera.position.set(WORLD_WIDTH/2,WORLD_HEIGHT/2,0);

	    Gdx.input.setInputProcessor(new MainInputProcessor(camera));
	    
        debug = new Box2DDebugRenderer();
        cameraUdate = new CameraUpdater(camera,testDummy);
	}

	@Override
	public void render(float delta) {
		deltaTime = delta;
		world.step(delta, 6, 2);
	
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		camera.update();
		cameraUdate.render();
		debugMatrix = game.getBatch().getProjectionMatrix().cpy().scale(Const.PTM, 
                Const.PTM, 0);
		game.getBatch().begin();
		game.getBatch().draw(img, x, y);
		
		game.getBatch().setProjectionMatrix(camera.combined);
		ground.render(game.getBatch());
		testDummy.render(game.getBatch());
		testDummy1.render(game.getBatch());
		testDummy2.render(game.getBatch());
		testDummy3.render(game.getBatch());
		testDummy4.render(game.getBatch());
		testDummy5.render(game.getBatch());
		renderer.render();
		
		/*
		 * Draw Everything now by passing the Batch in
		 */
		game.getBatch().end();
        debug.render(world, debugMatrix);

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
		img.dispose();
		map.dispose();
		renderer.dispose();
		
	}

}
