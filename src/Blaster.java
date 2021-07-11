import javafx.scene.image.Image;
import java.util.Arrays;

import javafx.scene.input.KeyCode;
public class Blaster extends Actor
{
   private double dx, dy;
   double height;
   int rotation;
   boolean allowed;
   long last;
   Blaster()
   {
      setImage(new Image(getClass().getClassLoader().getResource("resources/blasters.png").toString()));
      height = getY();
      rotation =1;
      allowed = true;
      dx =0;
      dy =0;
      last =0;
   }
   
   @Override
   public void act(long now)
   {
      move(dx,-dy);
      
      
      if ((getX()+50<getWorld().getWidth())&&rotation==1&&allowed)
      {
         dx = 2;
      }
      
      if ((getX()+50>getWorld().getWidth())&&rotation==-1&&allowed)
      {
         dx = -2;
      }
      
      if (getX()>getWorld().getWidth()-100&&rotation==1)
      {
         allowed = false;
         dy = -2;
         dx =0;
         
         
      }
      if (getX()<50&&rotation==-1)
      {
         allowed = false;
         dy = -2;
         dx =0;
         
         
      }
      
      if(getY()>height+120)
      {
        
           height = getY();
           dy =0;
           rotation *= -1;
           if (rotation ==-1)
           {
              dx = -2;
           } else {
              dx =2;
           }
           allowed = true;
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
      if(now-last >1e9*2)
      {
        
         AlienLaser laser = new AlienLaser();   
         laser.setX(this.getX()+30);
         laser.setY(this.getY());
         laser.setFitWidth(this.getWidth()/2);
         laser.setFitHeight(this.getHeight()/1.5);
         this.getWorld().add(laser);
         last = now;
      }
      
   }
      
   
}
