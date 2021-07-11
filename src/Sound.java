import javafx.scene.media.AudioClip;

public class Sound {
    AudioClip sound;
    public Sound (String file) {
        sound = new AudioClip(file);
    }
    public void play() {
        if(!sound.isPlaying()) {
            sound.play();
        }
    }
    public void stop() {
       if(sound.isPlaying()) {
           sound.stop();
       }
   }
    public boolean isPlaying() {
        return sound.isPlaying();
    }

}
