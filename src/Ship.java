import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Ship extends Actor {
	long last;
	long last2;
	private double[] previousXPositions;
	int lives;
	int nuke;
	int shield;
	int first;
	boolean power;
	double time;
	int shots;
	long lastp;
	long lasts;
	boolean allowed;
	boolean firstime;
	public Ship(int n, int s, int l) {
		setImage(new Image(getClass().getClassLoader().getResource("resources/alienship.png").toString()));
	
		previousXPositions = new double[5];
		Arrays.fill(previousXPositions, getX());
		lives = l;

		last2=0;
		nuke=n;
		shield=s;
		first =3;
		power = false;
		time = 1e9/2;
		shots=0;
		lastp =0;
		lasts = 0;
		allowed = true;
		firstime =true;
	}
	
	public double getXVelocity() {
		double diffs = 0;
		for(int i = 0; i < previousXPositions.length - 1; i++) 
			diffs += previousXPositions[i + 1] - previousXPositions[i];
		
		return diffs / (previousXPositions.length - 1);
	}

	@Override
	public void act(long now) {
	   if (firstime)
	   {
	      WorldStats world = (WorldStats) getWorld();
	      world.getScore().setScore(lives);
	      firstime = false;
	      String[] s = getPowerup().split(" ");
         String format = s[0]+" Selected -> "+s[1];
         if(getPowerup()=="None 0")
         {
            format = "None Selected";
         }
         world.getPowerup().setPowerup(format);
         time = 1e9/2;
         allowed = true;
         if(getPowerup()=="None 0")
         {
            power=false;
         } else
         {
            power = true;
         }
         lastp = now;
	   }
	   
		if(getWorld().isKeyDown(KeyCode.LEFT))
		{
			move(-getWidth() / 20, 0);
			
		}
		if(getWorld().isKeyDown(KeyCode.RIGHT))
		{
			move(getWidth() / 20, 0);
		}
		if(getWorld().isKeyDown(KeyCode.UP))
		{
		   
		   if (shield ==0)
		   {
		      allowed=true;
		   }
		   if ((first ==1 &&nuke>0 ||first ==2&&shield>0)&&power)
		   {
		      if (first==1)
		      {
		         time = 1e8;
		         shots++;
		      }
		      if (shots==100)
		      {
		         shots =0;
		         time = 1e9/2;
		         nuke--;
		         String[] s = getPowerup().split(" ");
	            String format = s[0]+" Selected -> "+s[1];
	            WorldStats world = (WorldStats) getWorld();
	            world.getPowerup().setPowerup(format);
		         
		      }
		      if (first==2&&now-lasts >1e9/2)
		      {
	            allowed = false;
		         lives=lives+5;
		         WorldStats world = (WorldStats) getWorld();
		         world.getScore().setScore(lives);
		         shield--;
		         String[] s = getPowerup().split(" ");
	            String format = s[0]+" Selected -> "+s[1];
	            WorldStats world1 = (WorldStats) getWorld();
	            world1.getPowerup().setPowerup(format);
	            lasts=now;
		      }
		   }
		   if((now-last >time)&&allowed)
         {
           
            Laser laser = new Laser();   
            laser.setX(this.getX()+30);
            laser.setY(this.getY());
            laser.setFitWidth(this.getWidth()/2);
            laser.setFitHeight(this.getHeight()/1.5);
            this.getWorld().add(laser);
            last = now;
         }
		}
		
		if(getWorld().isKeyDown(KeyCode.DOWN))
      {
         if(now-lastp >1e9/2)
         {
            first = changeFirst(first);
            String[] s = getPowerup().split(" ");
            String format = s[0]+" Selected -> "+s[1];
            if(getPowerup()=="None 0")
            {
               format = "None Selected";
            }
            WorldStats world = (WorldStats) getWorld();
            world.getPowerup().setPowerup(format);
            time = 1e9/2;
            allowed = true;
            if(getPowerup()=="None 0")
            {
               power=false;
            } else
            {
               power = true;
            }
            lastp = now;
         }
         
      }
		   
		
		if(getX() < 0)
		{
			setX(0);
		}
		else if(getX() > getWorld().getWidth() - getWidth())
		{
			setX(getWorld().getWidth() - getWidth());
		}
		
		for(int i = 0; i < previousXPositions.length - 1;)
		{
			previousXPositions[i] = previousXPositions[++i];
		}
		
		previousXPositions[previousXPositions.length - 1] = getX();
		
		AlienLaser laser = getOneIntersectingObject(AlienLaser.class);
      
		if (now-last2>1e9/2)
		{
         if (laser != null)
         {
            Explosion exp = new Explosion();       
            exp.setX(getX());
            exp.setY(getY());
            exp.setFitWidth(getWidth());
            exp.setFitHeight(getHeight());
            this.getWorld().add(exp);
            takeHit();
            this.getWorld().remove(laser);
            last2=now;
         }
         
		}
		
		
	}
	public void takeHit()
   {
	   lives--;
      if (lives==0)
      {
         this.setY(-1000);
      }
      
      WorldStats world = (WorldStats) getWorld();
      world.getScore().setScore(lives);
   }

   public void addPowerup(int i)
   {
      if (i==1)
      {
         lives++;
         WorldStats world = (WorldStats) getWorld();
         world.getScore().setScore(lives);
      }
      if(i==2)
      {
         shield++;
      }
      if(i==3)
      {
         nuke++;
      }
      
   }
   
   public String getPowerup()
   {
      if (first==1)
      {
         return ("Nuke "+ nuke);
      } 
      if (first==2)
      {
         return ("Shield "+ shield);
      }
      return "None 0";
      
   }
   public int getLives()
   {
      return lives;
   }
   public int getNukes()
   {
      return nuke;
   }
   public int getShields()
   {
      return shield;
   }
   public void first()
   {
      firstime = true;
   }
   
   public int changeFirst(int d)
   {
      if (d++<3)
      {
         return d++;
      }
      return 1;
      
   }
   

}
