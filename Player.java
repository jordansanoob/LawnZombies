/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 * (Allison Created this Class)
 */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;


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
	private int velX = 0; //velocity
	private int velY = 0;
	public String direction = "front";
	private boolean alive;
	private Textures tex;
	Game game;
	Controller controller;
	//SpriteSheet ss; //
	/**
	 * Player class adds in the Player and Bullet images
	 * sets the height and the width to add the screen
	 * Sets the background color
	 */
	public Player(int x, int y,Textures tex, Game game, Controller controller){ 
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.controller = controller;
	
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		BufferedImage player = ss.grabImage(2,  2,  32, 32);
	}
	/**
	 * tick method for velocity
	 */ 
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
		
	//collison of the bullets and how it affects the health bar
	for(int i = 0; i < game.eb.size(); i++){
		EntityB tempEnt = game.eb.get(i);
		
		if(Physics.Collision(this, tempEnt)){
			controller.removeEntity(tempEnt);
			Game.Health -= 20; //takes away health from the health bar
			game.seteKilled(game.geteKilled() + 1);
			if(Game.Health == 0){
				System.exit(0); //need to change
			}
		}
	}
	}
	/**
	 * render methof for direction of player
	 */ 
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
	//gets the directio
	public String getDirection(){
		return this.direction;
	}
	//gets the health
	public int gethealth(){
		return this.health;
	}
	//gets the x
	public int getX(){
		return this.x;
	}
	//gets the y
	public int getY(){
		return this.y;
	}
	//sets the direction
	public String setDirection(String d){
		return this.direction = d;
	}
	//checks if the player is still alive
	public void setAlive(boolean alive){
		this.alive = alive;
	}
	//sets the x
	public void setX(int x){
		this.x = x;
	}
	//sets the y
	public void setY(int y){
		this.y = y;
	}
	//increases x
	public void incX(int i){
		this.x += i;
	}
	//increases y
	public void incY(int j){
		this.y += j;
	}
	//sets velocity x
	public void setVelX(int velX){
		this.velX = velX;
	}
	//sets velocity y
	public void setVelY(int velY){
		this.velY = velY;
	}
	//gets the bounds
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}

}
