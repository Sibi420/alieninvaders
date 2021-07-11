import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class AlienLaser extends Actor
{
   long last;
  
   AlienLaser()
   {
      setImage(new Image(getClass().getClassLoader().getResource("resources/laser.png").toString()));
      last =0;
   }
   
   @Override
   public void act(long now)
   {
      move(0,4);
      
      if(getY()  > 700) 
      {
         this.getWorld().remove(this);
      }
      
        
      
     
   }
}  
