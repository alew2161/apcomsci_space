package com.qxbytes.music;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.RandomXS128;
import com.badlogic.gdx.utils.Timer;

//Owen was here

public class Music {

	Sound background1 = Gdx.audio.newSound(Gdx.files.internal("file")); //background music1
	Sound background2 = Gdx.audio.newSound(Gdx.files.internal("file"));//
	Sound background3 = Gdx.audio.newSound(Gdx.files.internal("file"));//
	Sound shoot = Gdx.audio.newSound(Gdx.files.internal("file"));// weapon music
	Sound damage = Gdx.audio.newSound(Gdx.files.internal("file"));// oof
	Sound damageDone = Gdx.audio.newSound(Gdx.files.internal("file"));// oof for an AI
	Sound click = Gdx.audio.newSound(Gdx.files.internal("file"));
	boolean gameIsRunning = false; // becomes true if user has begun a new game
	int x; // volume modifier for music (defined in user settings)



	// background music
	public void BakgroundMusic() {
		Random musicOption = new Random();
		int choice = musicOption.nextInt(2);//chooses one of the three background music files to play throughout the game

		if(gameIsRunning) { //checks if the user is in a game
			if(choice == 0) {
				background1.loop(x/100);}
			else if(choice == 1) {
				background2.loop(x/100);}
			else{
				background3.loop(x/100);}
		}
		else {
			background1.stop();
			background2.stop();
			background3.stop();
		}}
	
	

	// shooting sound effect && damage done sound effect if weapon does damage
	public void shootMusic() {
		shoot.play(x/100);
		if(true /*logic for hit boxes (remove the true statement once we have a method for it)*/) {
			damageDone.play(x/100);
		}
	}
	
	
	
	public void dmgTknEffect() {
		damage.play(x/100);
	}
	public void clickMusic() {
		click.play(x/100);
	}



	public void main (String [] args) {
		BakgroundMusic();

	}}
