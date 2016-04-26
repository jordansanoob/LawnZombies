/**
 *@author Allison, Jack, Jordan 
 * (Allison Created this class)
 */
import java.awt.Graphics;
import java.awt.Rectangle;
 
/**
 *Interface Entity deals with the tick, render, getX, and getY instances
 */ 
public interface EntityA {

	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	
	public int getX();
	public int getY();
}