

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.awt.Color;
public class Lives extends Text{
	private int score;
	private String type;
	public Lives(String s) {
		score = 5;
		Font font = Font.loadFont("resources/PressStart2P-Regular.ttf", 45);
		type =s;
		this.setFont(font);
		
		
	}
	public void UpdateDisplay() {
	   if (type=="l")
	   {
	      this.setText("Lives: "+score);
	   }
	   if (type=="p")
      {
         this.setText("None Selected");
      }
	}
	
	public void setScore(int x) {
		this.score = x;
		UpdateDisplay();
	}
	
	public void setPowerup(String x) {
	   this.setText(x);
   }
	
	public int getScore() {
		return this.score;
	}
}
