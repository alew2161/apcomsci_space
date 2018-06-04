package com.qxbytes.music;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

//Owen was here
/**
 * ha i remember when i used to actually put comments explaining the code
 * @author boson
 *
 */

public class Music {

	Sound background1 = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3")); //background music1
	Sound background2 = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3"));//
	Sound background3 = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3"));//
	Sound shoot = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3"));// weapon music
	Sound damage = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3"));// oof
	Sound damageDone = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3"));// oof for an AI
	Sound click = Gdx.audio.newSound(Gdx.files.internal("Darkling.mp3"));
	boolean gameIsRunning = true; // becomes true if user has begun a new game
	



	// background music
	public void PlayBakgroundMusic(int x) {
		Random musicOption = new Random();
		int choice = musicOption.nextInt(2);//chooses one of the three background music files to play throughout the game

		if(gameIsRunning) {
			System.out.println("music is playing");//checks if the user is in a game
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
	public void PlayshootMusic(int x) {
		shoot.play(x/100);
		if(true /*logic for hit boxes (remove the true statement once we have a method for it)*/) {
			damageDone.play(x/100);
		}
	}
	
	
	
	public void PlaydmgTknEffect(int x) {
		damage.play(x/100);
	}
	public void clickMusic(int x) {
		click.play(x/100);
	}
}
