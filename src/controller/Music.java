package controller;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {
		
	private Clip clip;
	
	public Music(String name, int loop) {
		try {
		File file = new File("sounds/" + name);
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(file));
		// clip.loop(Clip.LOOP_CONTINUOUSLY); 
		clip.loop(loop); 
		clip.start(); 
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
	}
	
	public void close() {
		clip.close();
	}
}
