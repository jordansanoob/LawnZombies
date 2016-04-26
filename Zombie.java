import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * 
 * @author Jordan Abbatiello, Allison Rowe, Jack Erwin
 *The zombie class which is the enemy of the Player in Lawn Zombies
 *x is the x coordinate of the zombie
 *y is the y coordinate of the zombie
 *health is how much health remains on the zombie object
 *index is the position the zombie holds in the ZombieArray
 *alive is the boolean of if it is alive (greater than 0 health)
 *Images are a visual of how much life the zombie has left
 *center is the point at the center of the image which represents the zombie
 */
public class Zombie extends GameObject implements EntityB {
	private Textures tex;
	private int health = 3;
	private int index;
	private boolean alive;
	private Game game;
	private Controller c;
	Random r = new Random();
	private int speed = r.nextInt(3)+1;
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
	
	public Zombie(int x, int y, Textures tex, Controller c, Game game){
		super(x, y);
		this.tex = tex;
		this.c = c;
		this.game = game;
	}
	public void tick() {
		
		y += speed;
		if(Physics.Collision(this, game.ea) && health > 0){
			this.punish();
		}
		else if(this.health == 0){				
			c.removeEntity(this);
			game.seteKilled(game.geteKilled() + 1);
		}
	}

	public void render(Graphics g) {
		if(health==3){
			g.drawImage(tex.zombieDub, x, y, null);
		}
		if(health==2){
			g.drawImage(tex.zombieSing, x, y, null);
		}
		if(health==1){
			g.drawImage(tex.zombieNone, x, y, null);
		}
	}

	//get x
	public int getX(){
		return this.x;
	}
	
	//get y
	public int getY(){
		return this.y;
	}
	
	//get health remaining
	public int getHealth(){
		return this.health;
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
		this.x = x;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	//sets y
	public void setY(int y){
		this.y = y;
	}
	
	//if collided with, docks health by 1
	public void punish(){
		this.health = (health - 1);
	}
}
