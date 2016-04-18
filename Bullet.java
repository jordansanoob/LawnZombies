import java.awt.*;

//getters and setters

/**
 * 
 * @author John Erwin, Allison Rowe, Jordan Abbatiello
 * Class bullet will import a bullet image and move it accordingly with which direction the player is facing
 */
public class Bullet {
	private double x;
	private double y;
	private double bulletX;		//may delete but idea is the actual point of the front of the bullet in the gif image
	private double bulletY;
	private Image image;
	private Player p;
	private Controller game;
	
	public Bullet(double x, double y, Controller game, Player p){
		this.x = x;
		this.y = y;
		this.p = p;
		
		//image = getSprite()
	}
	
	public void tick(){
		if (p.direction == "north"){
			y -= 5;
		}
		else if (p.direction == "south"){
			y += 5;
		}
		else if (p.direction == "east"){
			x += 5;
		}
		else if (p.direction == "west"){
			x -= 5;
		}
	}
	
	public void draw(Graphics g){
		;
	}
}
