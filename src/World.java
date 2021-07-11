import java.util.ArrayList;
import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public abstract class World extends Pane{
	
	AnimationTimer timer;
	int score;
	private HashSet<KeyCode> keysDown;
	String powerup; 
	public World() {
		keysDown = new HashSet<>();
		score = 0;
		powerup = "";
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				act(now);
				
				for(int i = 0; i < getChildren().size(); i++)
					if(getChildren().get(i) instanceof Actor)
						((Actor) getChildren().get(i)).act(now);
			}
		};
	}
	
	public void start() {
		timer.start();
	}
	
	public int getWorldScore()
	{
	   return score;
	}
	public void setScore(int s)
   {
	   score = s;
   }
	public String getWorldPowerup()
	{
	   return powerup;
	}
	public void setPowerup(String s)
   {
      powerup = s;
   }
	public void stop() {
		timer.stop();
	}
	
	public void add(Actor actor) {
		getChildren().add(actor);
	}
	
	public void remove(Actor actor) {
		getChildren().remove(actor);
	}
	
	public void setPressedStatus(KeyCode key, boolean isDown) {
		if(isDown)
			keysDown.add(key);
		else
			keysDown.remove(key);
	}
	
	public boolean isKeyDown(KeyCode key) {
		return keysDown.contains(key);
	}
	
	public <A extends Actor> java.util.List<A> getObjects(java.lang.Class<A> cls){
		ArrayList<A> list = new ArrayList<>();
		
		for(int i = 0; i < getChildren().size(); i++)
			if(cls.isInstance(getChildren().get(i)))
				list.add(cls.cast(getChildren().get(i)));
		
		return list;
	}
	
	public boolean isDone()
	{
	   for(int i = 0; i < getChildren().size(); i++)
	   {
         if((Blaster.class).isInstance(getChildren().get(i))||(AlienCore.class).isInstance(getChildren().get(i))||(Bomber.class).isInstance(getChildren().get(i))
               ||(Motherboard.class).isInstance(getChildren().get(i))||(Mothership.class).isInstance(getChildren().get(i))||(Rusher.class).isInstance(getChildren().get(i))
               ||(Sprinter.class).isInstance(getChildren().get(i)))
         {
            return false;
            
         }
	   }
	   return true;
	}
	
	
	
	public abstract void act(long now);
}
