package com.qxbytes.afterspace.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.qxbytes.afterspace.SpaceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 120;
		//	originally- config.foregroundFPS = 30; experimenting.
		new LwjglApplication(new SpaceGame(), config);
	}
}
 