package com.qxbytes.screens;


import java.time.Instant;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.NothingSpecial;
import com.qxbytes.camera.CameraUpdater;
import com.qxbytes.camera.MainInputProcessor;
import com.qxbytes.entities.CollisionEffects;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.Player;
import com.qxbytes.entities.Spike;
import com.qxbytes.entities.Turret;
import com.qxbytes.spacegame.SpaceGame;
import com.qxbytes.utils.Const;
import com.qxbytes.utils.SpriteHandler;
import com.qxbytes.world.SpaceGameWorld;


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
	SpriteHandler robot = new SpriteHandler();
	private SpaceGameWorld gameWorld = new SpaceGameWorld(
			new World(new Vector2(0,-2f), true),
			new OrthographicCamera(WORLD_WIDTH ,WORLD_HEIGHT),
			"oneSec.tmx", 
			new ArrayList<Entity>());

	

	//Ground Entity
	Entity ground = new Entity(gameWorld.getWorld(),BodyDef.BodyType.StaticBody, -3200,0,12800,20,SpriteHandler.getAnimation(0),new NothingSpecial());

	/**
	 * Temporary Solution.
	 * 
	 */
	Texture img;
	float x;
	float y;
	static float init = (Instant.now().getEpochSecond());	//	STAGE INIT TIME!
	
	/**
	 * Insert TEST Sprite handler image	
	 */

	private CameraUpdater cameraUdate;
	private HudOverlay hud;

	Player testDummy = new Player(gameWorld.getWorld(), BodyDef.BodyType.DynamicBody, 100, 400, 50, 50);
//	Entity testDummy1 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(1), new NothingSpecial());
//	Entity testDummy2 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(2), new NothingSpecial());
//	Entity testDummy3 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(3), new NothingSpecial());
//	Entity testDummy4 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(4), new NothingSpecial());
//	Entity testDummy5 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(0), new NothingSpecial());


	//OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(map, 2f);//1f / 32f);
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


		gameWorld.getCamera().position.set(WORLD_WIDTH/2,WORLD_HEIGHT/2,0);

		Gdx.input.setInputProcessor(new MainInputProcessor(gameWorld.getCamera()));

		debug = new Box2DDebugRenderer();
		cameraUdate = new CameraUpdater(gameWorld.getCamera(),testDummy);
		hud = new HudOverlay(testDummy,init,WORLD_WIDTH,WORLD_HEIGHT,gameWorld.getCamera());
		gameWorld.getWorld().setContactListener(new CollisionEffects());
		
	}

	@Override
	public void render(float delta) {
		/*boolean collisionX;
		collisionX = collisionLayer.getCell((int) ((testDummy.getPhysics().getEntityBody().getPosition().x)*100), (int) ((testDummy.getPhysics().getEntityBody().getPosition().y)*100)).getTile().getProperties().containsKey("object");
		System.out.println(collisionX);*/
		deltaTime = delta;
		gameWorld.getWorld().step(delta, 6, 2);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//		camera.update();
		cameraUdate.render();

		debugMatrix = game.getBatch().getProjectionMatrix().cpy().scale(Const.PTM, 
				Const.PTM, 0);
		game.getBatch().begin();
		//game.getBatch().draw(img, x, y);
		game.getBatch().setProjectionMatrix(hud.hud.getCamera().combined);
		testDummy.render(game.getBatch());
//		testDummy1.render(game.getBatch());
//		testDummy2.render(game.getBatch());
//		testDummy3.render(game.getBatch());
//		testDummy4.render(game.getBatch());
//		testDummy5.render(game.getBatch());
//		
		for (Entity e : gameWorld.getEntities()) {
			e.render(game.getBatch());
		}
		
		ground.render(game.getBatch());
		gameWorld.getRenderer().render();
		gameWorld.getRenderer().setView(gameWorld.getCamera());
		hud.update();
		/*
		 * Draw Everything now by passing the Batch in
		 */
		game.getBatch().end();
		debug.render(gameWorld.getWorld(), debugMatrix);

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

		testDummy.dispose();
//		testDummy1.dispose();
//		testDummy2.dispose();
//		testDummy3.dispose();
//		testDummy4.dispose();
//		testDummy5.dispose();
		ground.dispose();
		hud.dispose();
	}


}
