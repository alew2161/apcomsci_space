package com.qxbytes.spacegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.qxbytes.spacegame.SpaceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.backgroundFPS = 30;	//	power saver
		config.foregroundFPS = 120;	//	nobody needs more than 120fps in this game. 
		config.vSyncEnabled = false; // here we go.	
		new LwjglApplication(new SpaceGame(), config);
	}
}
