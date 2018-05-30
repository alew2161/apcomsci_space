package com.qxbytes.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.qxbytes.entities.Entity;
import com.badlogic.gdx.math.Vector2;

/**
 * CameraUpdater. it follows the specfied object.
 * 
 * @param Entity entity
 * @param OrthographicCamera camera
 * @author spectators
 */
public class CameraUpdater {
	private OrthographicCamera camera;
	private Entity entity;
	public CameraUpdater(OrthographicCamera camera, Entity entity) {
		this.entity = entity;
		this.camera = camera;
	}

	public void render() {
		System.out.print(entity.getPhysics().getEntityBody().getPosition().x+"\n");
		System.out.print(entity.getPhysics().getEntityBody().getPosition().y+"\n");
		camera.position.set((entity.getPhysics().getEntityBody().getPosition().x)*100,
				(entity.getPhysics().getEntityBody().getPosition().y)*100
				,0);
		camera.update();
	}
}
