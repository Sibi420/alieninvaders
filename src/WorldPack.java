import java.util.ArrayList;
import java.util.Collections;
public class WorldPack
{
   private ArrayList <World> pack = new ArrayList<World>();
   private int score = 0;
   private ArrayList <World> dupe;
   int get;
   final int HEIGHT = 700;
   public WorldPack()
   {
      get = 0;
   }
   
   public World getWorld(int i)
   {
      return pack.get(i);         
      
   }
   
   public void reset()
   {
      pack = new ArrayList<World>();
      WorldStats world = new WorldStats();
      this.addWorld(world);
      WorldStats world1 = new WorldStats();
      this.addWorld(world1);    
      WorldStats world2 = new WorldStats();
      this.addWorld(world2);    
      WorldStats world3 = new WorldStats();
      this.addWorld(world3);    
      WorldStats world4 = new WorldStats();
      this.addWorld(world4);     
      WorldStats world5 = new WorldStats();
      this.addWorld(world5);     
      WorldStats world6 = new WorldStats();
      this.addWorld(world6);      
      WorldStats world7 = new WorldStats();
      this.addWorld(world7);
      WorldStats world8 = new WorldStats();
      this.addWorld(world8);
      WorldStats world9 = new WorldStats();
      this.addWorld(world9);
      WorldStats world10 = new WorldStats();
      this.addWorld(world10);
      WorldStats world11 = new WorldStats();
      this.addWorld(world11);
      WorldStats world12 = new WorldStats();
      this.addWorld(world12);
      
      this.getWorld(0).setPrefSize(HEIGHT * 2, HEIGHT);  
      this.getWorld(1).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(2).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(3).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(4).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(5).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(6).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(7).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(8).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(9).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(10).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(11).setPrefSize(HEIGHT * 2, HEIGHT);
      this.getWorld(12).setPrefSize(HEIGHT * 2, HEIGHT);


   
      
      
      
      //world 0 ---------------------------------------------------------------
      
      for (int x=0;x*100<1000; x++)
      {
         Rusher rusher = new Rusher();
         rusher.setFitWidth(rusher.getWidth()/3);
         rusher.setFitHeight(rusher.getHeight()/3);
         rusher.setX(100+x*100);
         rusher.setY(121);
         
         this.getWorld(0).add(rusher);
      }
      
      //world 1 ---------------------------------------------------------------
      for (int x=0;x*100<1000; x++)
      {
         Rusher rusher = new Rusher();
         rusher.setFitWidth(rusher.getWidth()/3);
         rusher.setFitHeight(rusher.getHeight()/3);
         rusher.setX(x*100);
         
         this.getWorld(1).add(rusher);
      }
      
      for (int x=0;x*100<1000; x++)
      {
         Rusher rusher = new Rusher();
         rusher.setFitWidth(rusher.getWidth()/3);
         rusher.setFitHeight(rusher.getHeight()/3);
         rusher.setX(100+x*100);
         rusher.setY(121);
         
         this.getWorld(1).add(rusher);
      }
      
      for (int x=0;x*200<1000; x++)
      {
         Sprinter sprinter = new Sprinter();
         sprinter.setFitWidth(sprinter.getWidth()/5);
         sprinter.setFitHeight(sprinter.getHeight()/5);
         sprinter.setX(100+x*200);
         sprinter.setY(81);
         
         this.getWorld(1).add(sprinter);
      }
      
      for (int x=0;x*200<1000; x++)
      {
         Sprinter sprinter = new Sprinter();
         sprinter.setFitWidth(sprinter.getWidth()/5);
         sprinter.setFitHeight(sprinter.getHeight()/5);
         sprinter.setX(100+x*200);
         sprinter.setY(181);
         
         this.getWorld(1).add(sprinter);
      }
      
      //world 2 ---------------------------------------------------------------
      for (int x=0;x*100<1000; x++)
      {
         Rusher rusher = new Rusher();
         rusher.setFitWidth(rusher.getWidth()/3);
         rusher.setFitHeight(rusher.getHeight()/3);
         rusher.setX(x*100);
         
         this.getWorld(2).add(rusher);
      }
      
      
      for (int x=0;x*200<1000; x++)
      {
         Sprinter sprinter = new Sprinter();
         sprinter.setFitWidth(sprinter.getWidth()/5);
         sprinter.setFitHeight(sprinter.getHeight()/5);
         sprinter.setX(100+x*200);
         sprinter.setY(81);
         
         this.getWorld(2).add(sprinter);
      }
      
      for (int x=0;x*200<1000; x++)
      {
         Sprinter sprinter = new Sprinter();
         sprinter.setFitWidth(sprinter.getWidth()/5);
         sprinter.setFitHeight(sprinter.getHeight()/5);
         sprinter.setX(100+x*200);
         sprinter.setY(181);
         
         this.getWorld(2).add(sprinter);
      }
      
      for (int x=0;x*200<1000; x++)
      {
         Blaster blaster = new Blaster();
         blaster.setFitWidth(blaster.getWidth()/5);
         blaster.setFitHeight(blaster.getHeight()/5);
         blaster.setX(100+x*200);
         blaster.setY(121);
         
         this.getWorld(2).add(blaster);
      }
      
      
      
      //world 3 (boss) ---------------------------------------------------------------
      Mothership boss1 = new Mothership();
      this.getWorld(3).add(boss1);
      
      //world 4  ---------------------------------------------------------------
      for (int x=0;x*100<1000; x++)
      {
         Sprinter rusher = new Sprinter();
         rusher.setFitWidth(rusher.getWidth()/5);
         rusher.setFitHeight(rusher.getHeight()/5);
         rusher.setX(x*100);
         
         this.getWorld(4).add(rusher);
      }
      
      for (int x=0;x*200<1300; x++)
      {
         Blaster blaster = new Blaster();
         blaster.setFitWidth(blaster.getWidth()/5);
         blaster.setFitHeight(blaster.getHeight()/5);
         blaster.setX(100+x*200);
         blaster.setY(251);
         
         this.getWorld(4).add(blaster);
      }
      Nuclear nuke = new Nuclear();
      ExtraLife life = new ExtraLife();
      
      
    //world 5  ---------------------------------------------------------------
      for (int x=0;x*100<1000; x++)
      {
         Sprinter rusher = new Sprinter();
         rusher.setFitWidth(rusher.getWidth()/5);
         rusher.setFitHeight(rusher.getHeight()/5);
         rusher.setX(x*100);
         
         this.getWorld(5).add(rusher);
      }
      
      
      
      for (int x=0;x*200<1300; x++)
      {
         Blaster blaster = new Blaster();
         blaster.setFitWidth(blaster.getWidth()/5);
         blaster.setFitHeight(blaster.getHeight()/5);
         blaster.setX(100+x*200);
         blaster.setY(251);
         
         this.getWorld(5).add(blaster);
      }
      
      for (int x=0;x*200<1300; x++)
      {
         Rusher blaster = new Rusher();
         blaster.setFitWidth(blaster.getWidth()/3);
         blaster.setFitHeight(blaster.getHeight()/3);
         blaster.setX(100+x*200);
         blaster.setY(351);
         
         this.getWorld(5).add(blaster);
      }
      
      life.setFitWidth(nuke.getWidth()/12);
      life.setFitHeight(nuke.getHeight()/10);
      this.getWorld(5).add(nuke);    
      ExtraLife life1 = new ExtraLife();
      life1.setFitWidth(life1.getWidth()/10);
      life1.setFitHeight(life1.getHeight()/10);
    
      this.getWorld(5).add(life1);
      Shield shield = new Shield();
      shield.setFitWidth(shield.getWidth()/20);
      shield.setFitHeight(shield.getHeight()/20);
      this.getWorld(5).add(shield);
      
      //world 6  --------------------------------------------------------------
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         rusher.setY(51);
         this.getWorld(6).add(rusher);
      }
      for (int x=0;x*100<1000; x++)
      {
         Sprinter rusher = new Sprinter();
         rusher.setFitWidth(rusher.getWidth()/5);
         rusher.setFitHeight(rusher.getHeight()/5);
         rusher.setX(x*100);
         
         this.getWorld(6).add(rusher);
      }
      
      
      
      for (int x=0;x*200<1300; x++)
      {
         Blaster blaster = new Blaster();
         blaster.setFitWidth(blaster.getWidth()/5);
         blaster.setFitHeight(blaster.getHeight()/5);
         blaster.setX(100+x*200);
         blaster.setY(251);
         
         this.getWorld(6).add(blaster);
      }
      
      for (int x=0;x*200<1300; x++)
      {
         Rusher blaster = new Rusher();
         blaster.setFitWidth(blaster.getWidth()/3);
         blaster.setFitHeight(blaster.getHeight()/3);
         blaster.setX(100+x*200);
         blaster.setY(351);
         
         this.getWorld(6).add(blaster);
      }
      Nuclear nuke1 = new Nuclear();
      life.setFitWidth(nuke1.getWidth()/12);
      life.setFitHeight(nuke1.getHeight()/10);
      this.getWorld(6).add(nuke);    
      ExtraLife life2 = new ExtraLife();
      life2.setFitWidth(life2.getWidth()/10);
      life2.setFitHeight(life2.getHeight()/10);
    
      this.getWorld(6).add(shield);
      this.getWorld(6).add(life2);
      
      //world 7  --------------------------------------------------------------
      
      
      
      this.getWorld(7).add(nuke);    
      
      Motherboard m = new Motherboard();
      m.setFitWidth(m.getWidth()*1.3);
      m.setFitHeight(m.getHeight()*1.3);
      this.getWorld(7).add(m);
      
      //world 8  --------------------------------------------------------------
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         rusher.setY(51);
         this.getWorld(8).add(rusher);
      }
      for (int x=0;x*100<1000; x++)
      {
         Blaster rusher = new Blaster();
         rusher.setFitWidth(rusher.getWidth()/5);
         rusher.setFitHeight(rusher.getHeight()/5);
         rusher.setX(x*100);
         
         this.getWorld(8).add(rusher);
      }
      for (int x=0;x*200<1300; x++)
      {
         Blaster blaster = new Blaster();
         blaster.setFitWidth(blaster.getWidth()/5);
         blaster.setFitHeight(blaster.getHeight()/5);
         blaster.setX(100+x*200);
         blaster.setY(351);
         
         this.getWorld(8).add(blaster);
      }
      this.getWorld(8).add(shield);
      shield.setX(500);
     
      this.getWorld(8).add(nuke);
      
      //world 9-----------------------------------------------------------------------------
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         rusher.setY(132);
         this.getWorld(9).add(rusher);
      }
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         this.getWorld(9).add(rusher);
      }
      for (int x=0;x*200<1300; x++)
      {
         Blaster blaster = new Blaster();
         blaster.setFitWidth(blaster.getWidth()/5);
         blaster.setFitHeight(blaster.getHeight()/5);
         blaster.setX(100+x*200);
         blaster.setY(351);
         
         this.getWorld(9).add(blaster);
      }
      this.getWorld(9).add(life2);
      shield.setX(500);
     
      this.getWorld(9).add(nuke);
    //world 10-----------------------------------------------------------------------------
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         rusher.setY(132);
         this.getWorld(10).add(rusher);
      }
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         this.getWorld(10).add(rusher);
      }
      for (int x=1;x*300<1000; x++)
      {
         Bomber rusher = new Bomber();
         rusher.setFitWidth(rusher.getWidth()/2);
         rusher.setFitHeight(rusher.getHeight()/2);
         rusher.setX(x*300);
         rusher.setY(250);
         this.getWorld(10).add(rusher);
      }
  
     
      this.getWorld(10).add(shield);
      //world 11-----------------------------------------------------------------------------
      AlienCore core = new AlienCore();
            
      this.getWorld(11).add(core);
   }
   public void setGet(int i)
   {
      get = i;
   }
   public World getWorld()
   {
      return pack.get(get);         
      
   }
   public void addWorld(World w)
   {
      pack.add(w);
   }
   public void nextWorld()
   {
      get++;
   }
   public boolean last()
   {
      return (get==pack.size()-1);
   }
   
}
