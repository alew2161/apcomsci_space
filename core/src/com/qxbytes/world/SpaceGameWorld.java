package com.qxbytes.world;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.qxbytes.entities.Entity;
import com.qxbytes.entities.Spike;
import com.qxbytes.entities.Turret;
import com.qxbytes.screens.GameScreen;
import com.qxbytes.utils.Const;
import com.qxbytes.utils.SpriteHandler;

public class SpaceGameWorld {
	private World world;
	private OrthographicCamera camera;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private float tileSize;
	private ArrayList<Entity> entities;
	private ArrayList<Entity> queue = new ArrayList<Entity>();
	
	public SpaceGameWorld(World world, OrthographicCamera camera, String tmxFileName, ArrayList<Entity> entities) {
		this.world = world;
		this.camera = camera;
		this.map = new TmxMapLoader().load(tmxFileName);
		this.renderer = new OrthogonalTiledMapRenderer(map);
		this.entities = entities;
		
		TiledMapTileLayer EnemyLayer = (TiledMapTileLayer) map.getLayers().get("spike");
		tileSize = EnemyLayer.getTileHeight();
		for(int row = 0; row < EnemyLayer.getHeight(); row++) {
			for(int col = 0; col < EnemyLayer.getWidth(); col++) {
				Cell cell = EnemyLayer.getCell(col , row);
				if(cell == null) continue;
				if(cell.getTile() == null) continue;
				//System.out.println(row + "," + col);
				entities.add(new Spike(this, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight()));
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
				entities.add(new Turret(this, BodyDef.BodyType.StaticBody, (col+.5f)* tileSize, (row+.5f)*tileSize, cell.getTile().getTextureRegion().getRegionWidth(), cell.getTile().getTextureRegion().getRegionHeight()));
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