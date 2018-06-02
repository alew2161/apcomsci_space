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
	private float tileSize;

	private OrthographicCamera camera;
	private World world = new World(new Vector2(0,-2f), true);
	SpriteHandler robot = new SpriteHandler();

	//Ground Entity
	Entity ground = new Entity(world,BodyDef.BodyType.StaticBody, -3200,0,12800,20,SpriteHandler.getAnimation(0),new NothingSpecial());

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
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	Player testDummy = new Player(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50);
	Entity testDummy1 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(1), new NothingSpecial());
	Entity testDummy2 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(2), new NothingSpecial());
	Entity testDummy3 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(3), new NothingSpecial());
	Entity testDummy4 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(4), new NothingSpecial());
	Entity testDummy5 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(0), new NothingSpecial());

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;

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

		img = new Texture("untitled.png");
		map = new TmxMapLoader().load("oneSec.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);

		camera = new OrthographicCamera(WORLD_WIDTH ,WORLD_HEIGHT);
		camera.position.set(WORLD_WIDTH/2,WORLD_HEIGHT/2,0);

		Gdx.input.setInputProcessor(new MainInputProcessor(camera));

		debug = new Box2DDebugRenderer();
		cameraUdate = new CameraUpdater(camera,testDummy);
		hud = new HudOverlay(testDummy,init,WORLD_WIDTH,WORLD_HEIGHT,camera);
		world.setContactListener(new CollisionEffects());
		
		TiledMapTileLayer EnemyLayer = (TiledMapTileLayer) map.getLayers().get("spike");
		tileSize = EnemyLayer.getTileHeight();
		for(int row = 0; row < EnemyLayer.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer.getWidth(); col++) {
				Cell cell = EnemyLayer.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				//System.out.println(row + "," + col);
				entities.add(new Spike(world, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight()));
			}
		}
		TiledMapTileLayer EnemyLayer1 = (TiledMapTileLayer) map.getLayers().get("turret");
		tileSize = EnemyLayer1.getTileHeight();
		for(int row = 0; row < EnemyLayer1.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer1.getWidth(); col++) {
				Cell cell = EnemyLayer1.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				//System.out.println(row + "," + col);
				entities.add(new Turret(world, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight()));
			}
		}

		TiledMapTileLayer interactionLayer = (TiledMapTileLayer) map.getLayers().get("object");
		tileSize = interactionLayer.getTileHeight();
		for(int row = 0; row < interactionLayer.getHeight(); row++) {
			for(int col = 0; col < interactionLayer.getWidth(); col++) {
				Cell cell = interactionLayer.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				BodyDef definition = new BodyDef();// alexander idk where u initialized bodydef
				definition.type = BodyType.StaticBody; 
				definition.position.set(
						(col+.5f)* tileSize/Const.PTM, (row+.5f)*tileSize/Const.PTM);
//				ChainShape cs = new ChainShape(); 
//				Vector2[] v = new Vector2[3];
//				v[0] = new Vector2(-tileSize/2/Const.PTM, -tileSize/2/Const.PTM);
//
//				v[1]= new Vector2(-tileSize/2/Const.PTM, tileSize/2/Const.PTM);
//
//				v[2]= new Vector2(tileSize/2/Const.PTM, tileSize/2/Const.PTM);
//
//				cs.createChain(v);
				
				PolygonShape shape = new PolygonShape();
		        shape.setAsBox(tileSize/2 / Const.PTM, tileSize/2
		                        / Const.PTM);
		       


				FixtureDef fdef = new FixtureDef();
				fdef.friction = 1;
				fdef.shape = shape;
				fdef.filter.categoryBits = 1;
				fdef.filter.maskBits = -1;
				fdef.isSensor = false;
				world.createBody(definition).createFixture(fdef);

			}
		}
	}

	@Override
	public void render(float delta) {
		/*boolean collisionX;
		collisionX = collisionLayer.getCell((int) ((testDummy.getPhysics().getEntityBody().getPosition().x)*100), (int) ((testDummy.getPhysics().getEntityBody().getPosition().y)*100)).getTile().getProperties().containsKey("object");
		System.out.println(collisionX);*/
		deltaTime = delta;
		world.step(delta, 6, 2);

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
		testDummy1.render(game.getBatch());
		testDummy2.render(game.getBatch());
		testDummy3.render(game.getBatch());
		testDummy4.render(game.getBatch());
		testDummy5.render(game.getBatch());
		
		for (Entity e : entities) {
			e.render(game.getBatch());
		}
		
		ground.render(game.getBatch());
		renderer.render();
		renderer.setView(camera);
		hud.update();
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
		testDummy.dispose();
		testDummy1.dispose();
		testDummy2.dispose();
		testDummy3.dispose();
		testDummy4.dispose();
		testDummy5.dispose();
		ground.dispose();
		hud.dispose();
	}


}
