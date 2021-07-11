import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Laser extends Actor
{
  
   Laser()
   {
      setImage(new Image(getClass().getClassLoader().getResource("resources/laser.png").toString()));
   }
   
   @Override
   public void act(long now)
   {
      move(0,-4);
      
      if(getY() + getHeight() > getWorld().getHeight()) 
      {
         this.getWorld().remove(this);
      }
   
      Rusher rusher = getOneIntersectingObject(Rusher.class);
      
      
      if (rusher != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(rusher.getX());
         exp.setY(rusher.getY());
         exp.setFitWidth(rusher.getWidth()*2);
         exp.setFitHeight(rusher.getHeight()*2);
         this.getWorld().add(exp);
         this.getWorld().remove(rusher);
         this.getWorld().remove(this);
      }
      
      Sprinter sprinter = getOneIntersectingObject(Sprinter.class);
      
      
      if (sprinter != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(sprinter.getX());
         exp.setY(sprinter.getY());
         exp.setFitWidth(sprinter.getWidth()*2);
         exp.setFitHeight(sprinter.getHeight()*2);
         this.getWorld().add(exp);
         this.getWorld().remove(sprinter);
         this.getWorld().remove(this);
      }
      
      Blaster blaster = getOneIntersectingObject(Blaster.class);
      
      
      if (blaster != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(blaster.getX());
         exp.setY(blaster.getY());
         exp.setFitWidth(blaster.getWidth()*2);
         exp.setFitHeight(blaster.getHeight()*2);
         this.getWorld().add(exp);
         this.getWorld().remove(blaster);
         this.getWorld().remove(this);
      }
      
      Bomber bomber = getOneIntersectingObject(Bomber.class);
      
      
      if (bomber != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(bomber.getX());
         exp.setY(bomber.getY());
         exp.setFitWidth(bomber.getWidth());
         exp.setFitHeight(bomber.getHeight());
         this.getWorld().add(exp);
         this.getWorld().remove(bomber);
         this.getWorld().remove(this);
      }
      Mothership ship = getOneIntersectingObject(Mothership.class);
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
      Motherboard board = getOneIntersectingObject(Motherboard.class);
      if (board != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(board.getX());
         exp.setY(board.getY());
         exp.setFitWidth(board.getWidth());
         exp.setFitHeight(board.getHeight());
         this.getWorld().add(exp);
         board.takeHit();
         this.getWorld().remove(this);
      }
      
      AlienCore core = getOneIntersectingObject(AlienCore.class);
      if (core != null)
      {
         Explosion exp = new Explosion();       
         exp.setX(core.getX()+40);
         exp.setY(core.getY());
         exp.setFitWidth(core.getWidth()/2);
         exp.setFitHeight(core.getHeight()/2);
         this.getWorld().add(exp);
         core.takeHit();
         this.getWorld().remove(this);
      }
      
      ExtraLife life = getOneIntersectingObject(ExtraLife.class);
      if (life != null)
      {
         this.getWorld().remove(life);
         Ship ship1 = (this.getWorld().getObjects(Ship.class)).get(0);
         ship1.addPowerup(1);
         this.getWorld().remove(this);      
      }
      
      Shield shield = getOneIntersectingObject(Shield.class);
      if (shield != null)
      {
         this.getWorld().remove(shield);
         Ship ship2 = (this.getWorld().getObjects(Ship.class)).get(0);
         ship2.addPowerup(2);
         this.getWorld().remove(this);
      }
      
      Nuclear nuke = getOneIntersectingObject(Nuclear.class);
      if (nuke != null)
      {
         this.getWorld().remove(nuke);
         Ship ship3 = (this.getWorld().getObjects(Ship.class)).get(0);
         ship3.addPowerup(3);
         this.getWorld().remove(this);
      }
      
   }
}  
