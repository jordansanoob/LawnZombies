import java.awt.*;
import java.awt.image.BufferedImage;

//getters and setters

/**
 * 
 * @author John Erwin, Allison Rowe, Jordan Abbatiello
 * Class bullet will import a bullet image and move it accordingly with which direction the player is facing
 */
public class Bullet {
	private int x;
	private int y;

	BufferedImage image;
	private Player p;
	private Game game;
	
	public Bullet(int x, int y, Game game){
		this.x = x;
		this.y = y;
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		image = ss.grabImage(2, 1, 32, 32);
	}
	
	public void tick(){
		
		y-=5;
//		if (p.direction == "north"){
//			y -= 5;
//		}
//		else if (p.direction == "south"){
//			y += 5;
//		}
//		else if (p.direction == "east"){
//			x += 5;
//		}
//		else if (p.direction == "west"){
//			x -= 5;
//		}
	}
	
	public void render(Graphics g){
		g.drawImage(image, x,  y,  null);
	}
	public int getY(){
		return y;
	}
	public int getX(){
		return x;
	}
}