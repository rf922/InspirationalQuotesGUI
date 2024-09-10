package audioeffects;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * AudioEffect class to play sounds.
 * @author #rf922
 */
public class AudioEffect {

    private final String CLICK = "/resources/sounds/click.mp3"; 
    private final Media sound;
    
    public AudioEffect() {
        String soundFilePath = getClass().getResource(CLICK).toString();
        this.sound = new Media(soundFilePath);
    }


    public void playClick() {
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play(); 
    }
}
