/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


//current direction
//getters and setters

/**
 * Player class
 * @extends JPanel
 * sets the variables
 * adds the Player and Bullet image into the screen
 */
public class Player extends JPanel{ 

	private static final long serialVersionUID = 1L;
	private final int WIDTH = 300, HEIGHT = 600;
	private int x, y, health;
	private int velX = 0;
	private int velY = 0;
	public String direction;
	private boolean alive;
	Contoller controller; //for the health bar
	Game game; //for the health bar
	private BufferedImage player;
	/**
	 * Player class adds in the Player and Bullet images
	 * sets the height and the width to add the screen
	 * Sets the background color
	 */
	public Player(int x, int y, Game game, Controller controller){ 
		this.x = x; 
		this.y = y;
		this.game = game;
		this.controller = controller;
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		player = ss.grabImage(2,  2,  32, 32);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		if(x<=0)
			x=0;
		if(x>=640-16)
			x=640-16;
		if(y<=0)
			y=0;
		if(y>=800 -22)
			y=800-22;
			
		//for the health bar in order to make it go down
		for(int i = 0; i < game.eb.size(); i++){
			EntityB tempEnt = game.eb.get(i);
			
			if(Physics.Collisio(this, tempEnt)){
				controller.removeEntity(tempEnt);
				Game.Health -= 10;
				game.setEnemy_killed(game.getEnemy_killed() + 1);
			}
		}
		
	}
	public void render(Graphics g){
		 g.drawImage(player, x, y, null);
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
	public void setImage(BufferedImage img){
		this.player = img;
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

	/**
	 * PaintComponenet which calls in the Graphics needed
	 * adds the Player and Bullet images into the screen
	 * calls in the DeltaX and DeltaY
	 */
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		Graphics2D g2 = (Graphics2D) page;
	}
}
