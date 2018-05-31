package com.qxbytes.screens;

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
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.behaviors.DirectControl;
import com.qxbytes.behaviors.DoNothing;
import com.qxbytes.camera.CameraUpdater;
import com.qxbytes.camera.MainInputProcessor;
import com.qxbytes.entities.Const;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.SpriteHandler;
import com.qxbytes.spacegame.SpaceGame;


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
	Entity testDummy = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(0), new DirectControl());
	Entity testDummy1 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(1), new DoNothing());
	Entity testDummy2 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(2), new DoNothing());
	Entity testDummy3 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(3), new DoNothing());
	Entity testDummy4 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(4), new DoNothing());
	Entity testDummy5 = new Entity(world, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50, SpriteHandler.getAnimation(5), new DoNothing());

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
		TiledMapTileLayer EnemyLayer = (TiledMapTileLayer) map.getLayers().get("hazard");
		tileSize = EnemyLayer.getTileHeight();
		for(int row = 0; row < EnemyLayer.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer.getWidth(); col++) {
				/**
				 * add memes here
				 */

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
						(col+.5f)* tileSize/100, (row+.5f)*tileSize/100);
				ChainShape cs = new ChainShape(); 
				Vector2[] v = new Vector2[3];
				v[0] = new Vector2(-tileSize/2/100, -tileSize/2/100);

				v[1]= new Vector2(-tileSize/2/100, tileSize/2/100);

				v[2]= new Vector2(tileSize/2/100, tileSize/2/100);

				cs.createChain(v);

				FixtureDef fdef = new FixtureDef();
				fdef.friction = 1;
				fdef.shape = cs;
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

		game.getBatch().setProjectionMatrix(camera.combined);

		testDummy.render(game.getBatch());
		testDummy1.render(game.getBatch());
		testDummy2.render(game.getBatch());
		testDummy3.render(game.getBatch());
		testDummy4.render(game.getBatch());
		testDummy5.render(game.getBatch());

		ground.render(game.getBatch());
		renderer.render();
		renderer.setView(camera);
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
