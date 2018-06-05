package com.qxbytes.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.qxbytes.camera.CameraUpdater;
import com.qxbytes.entities.Electricity;
import com.qxbytes.entities.End;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.Player;
import com.qxbytes.entities.Spike;
import com.qxbytes.entities.Turret;
import com.qxbytes.screens.GameScreen;
import com.qxbytes.screens.HudOverlay;
import com.qxbytes.spacegame.SpaceGame;
import com.qxbytes.utils.Const;

public class SpaceGameWorld {
	private World world;
	private OrthographicCamera camera;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private float tileSize;
	private ArrayList<Entity> entities;
	private ArrayList<Entity> queue = new ArrayList<Entity>();
	private CameraUpdater cameraUpdater;
	private HudOverlay hud;
	private boolean queueChange = false;
	private int mapNumber = 2;
	private SpaceGame theGame;
	
	
	public SpaceGameWorld(SpaceGame theGame, World world, OrthographicCamera camera, String tmxFileName, ArrayList<Entity> entities) {
		
		this.theGame = theGame;
		
		this.camera = camera;
		
		this.world = world;
		
		this.entities = entities;
		
		changeMap(tmxFileName);
		
		
		
		
	}
	public void queueChange() {
		queueChange = true;
	}
	
	public void doQueuedChange() {
		if (queueChange == false || world.isLocked()) return;
		changeMap("level" + mapNumber + ".tmx");
		this.setHud(new HudOverlay(this.getTheGame(), this.getEntities().get(0), GameScreen.init, GameScreen.WORLD_WIDTH,GameScreen.WORLD_HEIGHT,this.getCamera()));

		queueChange = false;
		mapNumber++;
	}
	/**
	 * Do not call. Use Queue change instead
	 * @param tmxFileName
	 */
	private void changeMap(String tmxFileName) {
		//reset business
		Array<Body> allBodies = new Array<Body>();
		world.getBodies(allBodies);
		for (int i = allBodies.size-1 ; i >= 0 ; i--) {
			world.destroyBody(allBodies.get(i));
		}
		for (int i = entities.size()-1 ; i >= 0 ; i--) {
			entities.get(i).dispose();
		}
		
		entities.clear();
		
		getEntities().add(0,new Player(this, BodyDef.BodyType.DynamicBody, 100, 400, 50, 50));
		
		getCamera().position.set(GameScreen.WORLD_WIDTH/2,GameScreen.WORLD_HEIGHT/2,0);
		this.cameraUpdater = new CameraUpdater(getCamera(),getEntities().get(0));
		//hud = new HudOverlay(theGame,getEntities().get(0),GameScreen.init,GameScreen.WORLD_WIDTH,GameScreen.WORLD_HEIGHT,getCamera());
		
		//
		
		
		this.map = new TmxMapLoader().load(tmxFileName);
		this.renderer = new OrthogonalTiledMapRenderer(map);
		TiledMapTileLayer EnemyLayer = (TiledMapTileLayer) map.getLayers().get("end");
		tileSize = EnemyLayer.getTileHeight();
		for(int row = 0; row < EnemyLayer.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer.getWidth(); col++) {
				Cell cell = EnemyLayer.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				//System.out.println(row + "," + col);\
				End s = new End(this, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight());
				s.setState(cell);
				entities.add(s);
			}
		}
		TiledMapTileLayer EnemyLayer0 = (TiledMapTileLayer) map.getLayers().get("spike");
		tileSize = EnemyLayer0.getTileHeight();
		for(int row = 0; row < EnemyLayer0.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer0.getWidth(); col++) {
				Cell cell = EnemyLayer0.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				//System.out.println(row + "," + col);\
				Spike s = new Spike(this, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight());
				s.setState(cell);
				entities.add(s);
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
				Turret t = new Turret(this, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight());
				t.setState(cell);
				entities.add(t);

			}
		}
		TiledMapTileLayer EnemyLayer2 = (TiledMapTileLayer) map.getLayers().get("electricity");
		tileSize = EnemyLayer2.getTileHeight();
		for(int row = 0; row < EnemyLayer2.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer2.getWidth(); col++) {
				Cell cell = EnemyLayer2.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				//System.out.println(row + "," + col);
				entities.add(new Electricity(this, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight()));
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
	public void disposeAllDead() {
		for (int i = entities.size()-1 ; i >= 0 ; i--) {
			System.out.println( i + ":" + entities.get(i));
			if (entities.get(i).isDead()) {
				world.destroyBody(entities.get(i).getPhysics().getEntityBody());
				entities.get(i).dispose();
				
				entities.remove(i);

			}
		}
	}
	
	public SpaceGame getTheGame() {
		return theGame;
	}
	public void addQueued() {
		this.entities.addAll(queue);
		queue.clear();
	}
	public ArrayList<Entity> getQueue() {
		return queue;
	}
	public void setQueue(ArrayList<Entity> queue) {
		this.queue = queue;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public CameraUpdater getCameraUpdater() {
		return cameraUpdater;
	}
	public void setCameraUpdater(CameraUpdater cameraUpdater) {
		this.cameraUpdater = cameraUpdater;
	}
	public HudOverlay getHud() {
		return hud;
	}
	public void setHud(HudOverlay hud) {
		this.hud = hud;
	}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void setCamera(OrthographicCamera camera) {
		this.camera = camera;
	}
	public OrthogonalTiledMapRenderer getRenderer() {
		return renderer;
	}

	public void setRenderer(OrthogonalTiledMapRenderer renderer) {
		this.renderer = renderer;
	}

}
