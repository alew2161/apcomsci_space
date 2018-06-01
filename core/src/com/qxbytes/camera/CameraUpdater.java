package com.qxbytes.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.qxbytes.entities.Entity;
import com.qxbytes.utils.Const;
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
		
		camera.position.set((entity.getPhysics().getEntityBody().getPosition().x)*Const.PTM,
				(entity.getPhysics().getEntityBody().getPosition().y)*Const.PTM
				,0);
		if (camera.position.y - camera.viewportHeight/2 < 0) {
			camera.position.y = camera.viewportHeight/2;
		}
		camera.update();
	}
}
