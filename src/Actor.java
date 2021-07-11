import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView {

	public abstract void act(long now);
	
	public void move(double dx, double dy) {
		setX(getX() + dx);
		setY(getY() + dy);
	}
	
	public World getWorld() {
		return (getParent() == null || getParent() instanceof World) ? ((World) getParent()) : null;
	}
	
	public double getHeight() {
		return getBoundsInParent().getHeight();
	}
	
	public double getWidth() {
		return getBoundsInParent().getWidth();
	}
	
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		ArrayList<A> list = new ArrayList<>();
		
		for(int i = 0; i < getParent().getChildrenUnmodifiable().size(); i++) {
			
			Node obj = getParent().getChildrenUnmodifiable().get(i);
			
			if(obj != this && cls.isInstance(obj) && this.intersects(obj.getBoundsInParent()))
				list.add(cls.cast(obj));
		}
		
		return list;
	}
	
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
	   if(!(getParent()==null)&&!(getParent().getChildrenUnmodifiable()==null))
      	for(int i = 0; i < getParent().getChildrenUnmodifiable().size(); i++) {
      	   
      		
      		Node obj = getParent().getChildrenUnmodifiable().get(i);
      		
      		if(obj != this && cls.isInstance(obj) && this.intersects(obj.getBoundsInParent()))
      			return cls.cast(obj);
      	}
		
		return null;
	}

}
