package com.qxbytes.camera;

import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * CameraUpdater. it follows the specfied object.
 * 
 * @param Entity entity
 * @param OrthographicCamera camera
 * @author spectators
 */
public class CameraUpdater {
	private OrthographicCamera camera;
	public CameraUpdater(OrthographicCamera camera) {
		this.camera = camera;
	}
}
