package com.qxbytes.spacegame.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.qxbytes.spacegame.SpaceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;	//	final float WORLD_* = Gdx.graphics.get*(); will break everything. don't even ask.
		config.backgroundFPS = 20;	//	power saver
		config.foregroundFPS = 60;	//	60fps 
		config.vSyncEnabled = true; // here we go.	
		config.forceExit = false;	//	apparently i need to do this.
		new LwjglApplication(new SpaceGame(), config);
	}
}
