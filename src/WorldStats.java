import javafx.scene.paint.*;
import javafx.scene.text.Font;


public class WorldStats extends World {
	private Lives lives;
	private Lives powerup;
	@Override
	public void act(long now) {
	}
	public WorldStats() {
		lives = new Lives("l");
		
		lives.setScore(5);
		Font font = Font.loadFont(getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"), 40);
		lives.setFont(font);
		//Put it somewhere
		lives.setX(0);
		lives.setY(500);
		Color c = Color.WHITE;
		lives.setFill(c);
		//System.out.println(this.score.getFont());
		getChildren().add(lives);
		
		powerup = new Lives("p");   
		powerup.setScore(5);    
		powerup.setFont(font);
		powerup.setX(0);
		powerup.setY(300);
		powerup.setFill(c);
		getChildren().add(powerup);
	}
	public Lives getScore() {
		return this.lives;
	}
	public Lives getPowerup() {
      return this.powerup;
   }
}
