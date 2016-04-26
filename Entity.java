/**
 *@author Allison, Jack, Jordan 
 * (Allison Created this class)
 */ 

import java.awt.Graphics;
/**
 *Interface Entity deals with the tick, render, getX, and getY instances
 */ 
public interface Entity {
	public void tick();
	public void render(Graphics g);
	
	public Double getX();
	public Double getY();

}
