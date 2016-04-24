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
	private Image PlayerLeft, PlayerRight, PlayerForward, PlayerBackward, Bullet; //images we will import in
	private int x, y, health;
	private int deltaX = 0;
	private int deltaY = 0;
	private int vLX = 0;
	private int vLY = 0;
	public String direction;
	
	/**
	 * Player class adds in the Player and Bullet images
	 * sets the height and the width to add the screen
	 * Sets the background color
	 */
	public Player() {
		x = WIDTH / 2;
		y = HEIGHT / 2;
		ImageIcon PlayerLeft = new ImageIcon("PlayerLeft.gif"); //Player
		ImageIcon PlayerRight = new IamgeIcon("PlayerRight.gif");
		ImageIcon PlayerForward = new ImageIcon("PlayerForward.gif");
		ImageIcon PlayerBackward = new ImageIcon("PlayerBackward.gif");
		setBackground(Color.GREEN);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
	
	}

	/**
	 * PaintComponenet which calls in the Graphics needed
	 * adds the Player and Bullet images into the screen
	 * calls in the DeltaX and DeltaY
	 */
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		//Player.paintIcon(this, page, x, y);
		//Bullet.paintIcon(this, page, x, y);
		Graphics2D g2 = (Graphics2D) page;
//		Player.translate(deltaX, deltaY);
//		Bullet.translate(deltaX, deltaY);
	}
	public String getDirection(){
		return this.direction;
	}
	public int setdirection(String d){
		return this.direction = d;
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
	public void tick(){
		x += vLX;
		y += vLY;
	}
}
