import java.awt.*;
import java.awt.image.BufferedImage;

//getters and setters

/**
* 
* @author John Erwin, Allison Rowe, Jordan Abbatiello
* Class bullet will import a bullet image and move it accordingly with which direction the player is facing
* (John Created this Class)
*/

/**
*Bullet Class 
*@extends GameObject
*@implements EntitiyA
*adds functionality to the bulllet sprite 
*/
public class Bullet extends GameObject implements EntityA {
	private String direction;
	private Textures tex;
	private Game game;
	
	/**
	 *Bullet method takes x, y, direction, tex, and game 
	 */ 
	public Bullet(int x, int y, String direction, Textures tex, Game game){
		super(x,y);
		this.tex = tex;
		this.direction = direction;
		this.game = game;
	}
	/**
	 *tick takes the bullet Sprite that BufferImage added to the Game class
	 *adds direction to the Bullet making it face the front, back, left, and right of the game class 
	 *via x and y coordinates
	 */ 
	public void tick(){
		
		if(direction == "front"){
			y-=10;
			}
			if(direction == "back"){
				y+=10;
				}
			if(direction == "left"){
				x-=10;
				}
			if(direction == "right"){
				x+=10;
				}
	}
	/**
	 * Renders the bullet sprite so that each of the four bullet sprites correlate to the direction
	 * they face, to insure the bullet faces the correct direction
	 */ 
	public void render(Graphics g){
		if(direction == "front"){
			g.drawImage(tex.bulletF, x,  y,  null);
		}
		if(direction == "back"){
			g.drawImage(tex.bulletB, x,  y,  null);
			}
		if(direction == "left"){
			g.drawImage(tex.bulletL, x,  y,  null);
			}
		if(direction == "right"){
			g.drawImage(tex.bulletR, x,  y,  null);
			}
	
	}
	/**
	 * Gets the Y coordinate
	 */ 
	public int getY(){
		return y;
	}
	/**
	 * Gets the x coordinate
	 */ 
	public int getX(){
		return x;
	}
	/**
	 *Gets the bounds of the screen
	 *will be used later for the health bar
	 */ 
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}

}