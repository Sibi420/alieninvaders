import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Nuclear extends Actor
{
   double last =0;
   boolean first = true;
   int dx;
   int dy;
   int rotation;
   boolean allowed;
   public Nuclear()
   {
      setImage(new Image(getClass().getClassLoader().getResource("resources/nuke.png").toString()));
      dx = 4;
      dy =0;
      rotation =1;
      allowed = true;
   }
   @Override
   public void act(long now)
   {
      move(dx,-dy);
      
      if (getX()<300)
      {
         rotation *=-1;
      }
      if ((getX()-50<0)&&rotation==1&&allowed)
      {
         dx = 6;
      }
      if ((getX()+300>getWorld().getWidth()))
      {
         rotation *=-1;
      }
      
      if ((getX()+300>getWorld().getWidth())&&rotation==-1&&allowed)
      {
         dx = -6;
      }
   }

}
