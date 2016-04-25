/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 */

import java.awt.Graphics;
import java.awt.Rectangle;


//current direction
//getters and setters

/**
 * Player class
 * @extends JPanel
 * sets the variables
 * adds the Player and Bullet image into the screen
 */
public class Player extends GameObject implements EntityA{ 

	private int health;
	private int velX = 0;
	private int velY = 0;
	public String direction = "front";
	private boolean alive;
	private Textures tex;
	/**
	 * Player class adds in the Player and Bullet images
	 * sets the height and the width to add the screen
	 * Sets the background color
	 */
	public Player(int x, int y, Textures tex){ 
		super(x, y);
		this.tex = tex;
		
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		if(x<=5)
			x=5;
		if(x>=640-25)
			x=640-25;
		if(y<=5)
			y=5;
		if(y>=800 -110)
			y=800-110;
		
	}
	public void render(Graphics g){
		
		if(direction == "front"){
		 g.drawImage(tex.playerF, x, y, null);
		}
		if(direction == "back"){
			 g.drawImage(tex.playerB, x, y, null);
			}
		if(direction == "left"){
			 g.drawImage(tex.playerL, x, y, null);
			}
		if(direction == "right"){
			 g.drawImage(tex.playerR, x, y, null);
			}
	}

	public String getDirection(){
		return this.direction;
	}
	public int gethealth(){
		return this.health;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}	
	public String setDirection(String d){
		return this.direction = d;
	}
	public void setAlive(boolean alive){
		this.alive = alive;
	}
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void incX(int i){
		this.x += i;
	}
	public void incY(int j){
		this.y += j;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}

}