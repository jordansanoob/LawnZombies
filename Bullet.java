import java.awt.*;
import java.awt.image.BufferedImage;

//getters and setters

/**
 * 
 * @author John Erwin, Allison Rowe, Jordan Abbatiello
 * Class bullet will import a bullet image and move it accordingly with which direction the player is facing
 */
public class Bullet extends GameObject implements EntityA {
	private String direction;
	private Textures tex;
	private Game game;
	
	
	public Bullet(int x, int y, String direction, Textures tex, Game game){
		super(x,y);
		this.tex = tex;
		this.direction = direction;
		this.game = game;
	}
	
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
	public int getY(){
		return y;
	}
	public int getX(){
		return x;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}

}