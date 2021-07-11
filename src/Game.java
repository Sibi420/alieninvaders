
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
public class Game extends Application {
	
	private static final double HEIGHT = 700;
	WorldPack pack;
	Ship ship;
	BorderPane root;
	BorderPane titleNamePanel;
	Boolean playing = true;
	Sound backtrack;
	ImageView loser;
	ImageView winner;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Invaders");
		stage.setResizable(false);
		stage.sizeToScene();
		AnimationTimer timer = new MyTimer();
		titleNamePanel = new BorderPane();
		titleNamePanel.setPrefSize(HEIGHT * 2, HEIGHT);
		Image bg = new Image(getClass().getClassLoader().getResource("resources/startscreenew.png").toString());
      ImageView bgview = new ImageView(bg);
      bgview.setFitWidth(HEIGHT * 2);
      bgview.setFitHeight(HEIGHT);
      titleNamePanel.getChildren().addAll(bgview); 
      
      Image bg1 = new Image(getClass().getClassLoader().getResource("resources/blueearth.jpg").toString());
      ImageView bg1view = new ImageView(bg1);
      bg1view.setFitWidth(HEIGHT * 2);
      bg1view.setFitHeight(HEIGHT);
      
      Image lose = new Image(getClass().getClassLoader().getResource("resources/losescreen.png").toString());
      loser = new ImageView(lose);
      loser.setFitWidth(HEIGHT * 2);
      loser.setFitHeight(HEIGHT);
      
      Image win = new Image(getClass().getClassLoader().getResource("resources/winscreen.png").toString());
      winner = new ImageView(win);
      winner.setFitWidth(HEIGHT * 2);
      winner.setFitHeight(HEIGHT);

      
      
		Image bg2 = new Image(getClass().getClassLoader().getResource("resources/newhelp.png").toString());
		ImageView bg2view = new ImageView(bg2);
      bg2view.setFitWidth(HEIGHT * 2);
      bg2view.setFitHeight(HEIGHT);
      Scene scene1 = new Scene(titleNamePanel);
      
		pack = new WorldPack();
		pack.setGet(0);
		pack.reset();
     
      scene1.setOnKeyPressed(new EventHandler<KeyEvent>() {
         @Override
         public void handle(KeyEvent events) {        
             switch (events.getCode()) {
                 case E:  
                 {
                   
                       if(playing)
                       {
                          backtrack.stop();
                          backtrack = new Sound(getClass().getResource("/sounds/Tom Player - AXIS (Position Music - Epic Intense Dark Orchestral).mp3").toExternalForm());
                          ship = new Ship(100,100,100);
                          ship.setX(HEIGHT - ship.getWidth() / 2);
                          ship.setY(HEIGHT - ship.getHeight()+500);
                          ship.setFitWidth(ship.getWidth() * 150 / HEIGHT);
                          ship.setFitHeight(ship.getHeight() * 100 / HEIGHT);
                          pack.getWorld().add(ship);
                          ship.first();
                          titleNamePanel.getChildren().clear();
                          titleNamePanel.getChildren().addAll(bg1view); 
                          titleNamePanel.setCenter(pack.getWorld());    
      
                          pack.getWorld().requestFocus();
                          pack.getWorld().setOnKeyPressed((event) -> {        
                             pack.getWorld().setPressedStatus(event.getCode(), true);
                          });
                          
                          pack.getWorld().setOnKeyReleased((event) -> {         
                             pack.getWorld().setPressedStatus(event.getCode(), false);
                          });
                          playing =false;
                          pack.getWorld().start();
                          break;
                       }
                 }
                    
                       
                 case N:  
                 {
                   
                    if(playing)
                    {
                       backtrack.stop();
                       backtrack = new Sound(getClass().getResource("/sounds/Tom Player - AXIS (Position Music - Epic Intense Dark Orchestral).mp3").toExternalForm());
                          ship = new Ship(5,5,20);
                          ship.setX(HEIGHT - ship.getWidth() / 2);
                          ship.setY(HEIGHT - ship.getHeight()+500);
                          ship.setFitWidth(ship.getWidth() * 150 / HEIGHT);
                          ship.setFitHeight(ship.getHeight() * 100 / HEIGHT);
                          pack.getWorld().add(ship);
                          ship.first();
                          titleNamePanel.getChildren().clear();
                          titleNamePanel.getChildren().addAll(bg1view); 
                          titleNamePanel.setCenter(pack.getWorld());    
      
                          pack.getWorld().requestFocus();
                          pack.getWorld().setOnKeyPressed((event) -> {        
                             pack.getWorld().setPressedStatus(event.getCode(), true);
                          });
                          
                          pack.getWorld().setOnKeyReleased((event) -> {         
                             pack.getWorld().setPressedStatus(event.getCode(), false);
                          });
                          playing = false;
                          pack.getWorld().start();
                          break;
                    }
                 }
                       
                 case D: 
                 {
                    
                    if(playing)
                    {  
                       backtrack.stop();
                       backtrack = new Sound(getClass().getResource("/sounds/Tom Player - AXIS (Position Music - Epic Intense Dark Orchestral).mp3").toExternalForm());
                       ship = new Ship(0,0,10);
                       ship.setX(HEIGHT - ship.getWidth() / 2);
                       ship.setY(HEIGHT - ship.getHeight()+500);
                       ship.setFitWidth(ship.getWidth() * 150 / HEIGHT);
                       ship.setFitHeight(ship.getHeight() * 100 / HEIGHT);
                       pack.getWorld().add(ship);
                       ship.first();
                       titleNamePanel.getChildren().clear();
                       titleNamePanel.getChildren().addAll(bg1view); 
                       titleNamePanel.setCenter(pack.getWorld());    
   
                       pack.getWorld().requestFocus();
                       pack.getWorld().setOnKeyPressed((event) -> {        
                          pack.getWorld().setPressedStatus(event.getCode(), true);
                       });
                       
                       pack.getWorld().setOnKeyReleased((event) -> {         
                          pack.getWorld().setPressedStatus(event.getCode(), false);
                       });
                       playing = false;
                       pack.getWorld().start();
                       break;
                    }
                 }
                 case H: 
                 {
                    if(playing)
                    {
                       ship = new Ship(999,999,999);
                       ship.setX(HEIGHT - ship.getWidth() / 2);
                       ship.setY(HEIGHT - ship.getHeight()+500);
                       ship.setFitWidth(ship.getWidth() * 150 / HEIGHT);
                       ship.setFitHeight(ship.getHeight() * 100 / HEIGHT);
                       pack.getWorld(12).add(ship);
                       ship.first();
                       titleNamePanel.getChildren().clear();
                       titleNamePanel.getChildren().addAll(bg2view); 
                       titleNamePanel.setCenter(pack.getWorld(12));    
   
                       pack.getWorld(12).requestFocus();
                       pack.getWorld(12).setOnKeyPressed((event) -> {        
                          pack.getWorld(12).setPressedStatus(event.getCode(), true);
                       });
                       
                       pack.getWorld(12).setOnKeyReleased((event) -> {         
                          pack.getWorld(12).setPressedStatus(event.getCode(), false);
                       });
                       playing =false;
                       pack.getWorld(12).start();
                       break;
                    }
                 }
                 case P:   
                 {

                    pack.getWorld().stop();
 
                    
                    break;
                 }
                 case L:
                 {
                    if(!playing)
                    {
                       if((pack.getWorld().getObjects(Ship.class).size()>0&&pack.getWorld().getObjects(Ship.class).get(0).getY()<0)||pack.getWorld(11).getObjects(AlienCore.class).size()==0)
                       {
                          backtrack.stop();
                          backtrack = new Sound(getClass().getResource("/sounds/jsphu - Arrival of the Hero by Batikan Iscan (Orchestral Cover).mp3").toExternalForm());
                          backtrack.play();
                       }
                       pack.getWorld().remove(ship);
                       titleNamePanel.getChildren().clear();
                       titleNamePanel.getChildren().addAll(bgview); 
                       playing = true;  
                       pack.reset();
                       pack.setGet(0);
                       break;
                    }
                 }
                               
                    
                 case R:
                 {

                    pack.getWorld().start();
    

                    break;
                 }

             }
         }
      });
      
      stage.setScene(scene1);
      stage.show();
      
		
		
		timer.start();
		backtrack = new Sound(getClass().getResource("/sounds/jsphu - Arrival of the Hero by Batikan Iscan (Orchestral Cover).mp3").toExternalForm());
		
	}
	private class MyTimer extends AnimationTimer {
      private long prevTime;
      @Override
      public void handle(long now) {
          backtrack.play();
          if(now-prevTime >  1e8 &&playing ==false) {
             if (pack.getWorld(11).getObjects(AlienCore.class).size()==0)
             {
                titleNamePanel.getChildren().clear();
                titleNamePanel.getChildren().addAll(winner);
              
             }
             if (pack.getWorld().getObjects(Ship.class).size()>0&&pack.getWorld().getObjects(Ship.class).get(0).getY()<0)
             {
                titleNamePanel.getChildren().clear();
                titleNamePanel.getChildren().addAll(loser);
             }
              if (pack.getWorld().isDone())
              {
                 if(pack.last())
                 {
                   
                    
                 } else 
                 {
                    pack.nextWorld();
                    pack.getWorld().add(ship);
                    ship.first();
                    titleNamePanel.setCenter(pack.getWorld());    

                    pack.getWorld().requestFocus();
                    pack.getWorld().setOnKeyPressed((event) -> {        
                       pack.getWorld().setPressedStatus(event.getCode(), true);
                    });
                    
                    pack.getWorld().setOnKeyReleased((event) -> {         
                       pack.getWorld().setPressedStatus(event.getCode(), false);
                    });
                    
                    pack.getWorld().start();
                    
                 }
                 
              }
              prevTime = now;
          }
          
      }

  
  }

}
