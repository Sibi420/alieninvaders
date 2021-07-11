import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Bomb extends Actor
{
  
   Bomb()
   {
      setImage(new Image(getClass().getClassLoader().getResource("resources/Bomb.png").toString()));
   }
   
   @Override
   public void act(long now)
   {
      move(0,3);
      if(getY()  > 700) 
      {
         this.getWorld().remove(this);
      }
      
      Ship ship = getOneIntersectingObject(Ship.class);
      
      
      if (ship != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(ship.getX());
         exp.setY(ship.getY());
         exp.setFitWidth(ship.getWidth());
         exp.setFitHeight(ship.getHeight());
         this.getWorld().add(exp);
         ship.takeHit();
         this.getWorld().remove(this);
      }
     
   }
}  
