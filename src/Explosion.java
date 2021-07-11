import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Explosion extends Actor
{
   double last =0;
   boolean first = true;
   public Explosion()
   {
      setImage(new Image(getClass().getClassLoader().getResource("resources/explosion.png").toString()));
   }
   @Override
   public void act(long now)
   {
      if (first)
      {
         last = now;
         first = false;
      }
      
      if (now-last>1e9/2)
      {
         this.getWorld().remove(this);
      }
   }

}
