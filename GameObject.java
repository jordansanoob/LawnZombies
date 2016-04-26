/**
 * @author Allison, Jack, Jordan
 * (Jordan Created this Class)
 */ 
import java.awt.Rectangle;
/**
 * Game Object sets the x and y coordinates
 */ 
public class GameObject {
	public int x, y;
	/**
	 *GameObjext method for x and y 
	 */ 
	public GameObject(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	/**
	 *rectangle method getshte bounds of the rectangle 
	 */ 
	public Rectangle getBounds(int width, int height){
		return new Rectangle(x, y, width, height);
	}

}
