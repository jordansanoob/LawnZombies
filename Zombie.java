import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * 
 * @author Jordan Abbatiello, Allison Rowe, Jack Erwin
 *The zombie class which is the enemy of the Player in Lawn Zombies
 *zombieX is the x coordinate of the zombie
 *zombieY is the y coordinate of the zombie
 *health is how much health remains on the zombie object
 *index is the position the zombie holds in the ZombieArray
 *alive is the boolean of if it is alive (greater than 0 health)
 *Images are a visual of how much life the zombie has left
 *center is the point at the center of the image which represents the zombie
 */
public class Zombie {
	private int zombieX;
	private int zombieY;
	private int health = 3;
	private int index;
	private boolean alive;
	private Image ZombieDouble, ZombieSingle, ZombieNone;
	private Point center = new Point(this.zombieX, this.zombieY);
	
	//distance from center to bullet needed
	//distance from center to hitbox needed
	//private int hitboxRadius;
	//private int speed; //?
	/**
	 * the zombie object that will be created and added to the zombie array which is
	 * then iterated over in order to draw each of the zombies
	 * @param x location of the zombie on the x plane
	 * @param y location of the zombie on the y plane
	 * @param h health of the zombie
	 * @param i index of the zombie in the array
	 * @param tf true or false if it is alive or not
	 * @param image image that represents remaining health of the zombie
	 * @param c center of the object
	 */
	public Zombie(int x, int y, int h, int i, boolean tf, Image image, Point c){
		this.zombieX = x;
		this.zombieY = y;
		this.health = h;
		this.index = i;
		this.alive = tf;
		this.ZombieDouble = image;
		this.center = c;
	}
	
	//get x
	public int getX(){
		return this.zombieX;
	}
	
	//get y
	public int getY(){
		return this.zombieY;
	}
	
	//get health remaining
	public int getHealth(){
		return this.health;
	}
	
	//returns the center point
	public Point getCenter(){
		return center;
	}
	
	//get the index 
	public int getIndex(){
		return this.index;
	}
	
	//gets if it is alive or not
	public boolean getAlive(){
		return this.alive;
	}
	
	//sets alive
	public void setAlive(boolean alive){
		this.alive = alive;
	}
	
	//sets x
	public void setX(int x){
		this.zombieX = x;
	}
	
	//sets y
	public void setY(int y){
		this.zombieY = y;
	}
	
	//if collided with, docks health by 1
	public void punish(){
		this.health = (health - 1);
	}
	
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
