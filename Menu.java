import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
/**
 @author Allison, Jack, Jordan
 *Created by Allison and Jordan
 */

/**
 * 
 * Menu Class creates the front page of the game
 *
 */
public class Menu {
	
	private int h = 200;
	private int w = 260;
	public void render(Graphics g){
		  g.setColor(Color.white);
		  Font font1 = new Font ("times", Font.ITALIC,65);
		  g.setFont(font1);
		  g.setColor(Color.GREEN);
		  g.drawString("LAWN ZOMBIES", w-190, h-50);
		  g.setColor(Color.white);
		  Font font2 = new Font ("Courier", Font.BOLD,40);
		  g.setFont(font2);
		  g.drawString("CONTROLS", w-100, h);
		  g.drawString("_________", w-110, h);
		  Font font3 = new Font ("Courier", Font.BOLD,25);
		  g.setFont(font3);
		  g.setColor(Color.black);
		  g.drawString("[Q][W][E]", w-40, 240);
		  g.drawString("[A][S][D]", w-40, 260);
		  g.drawString("[ SPACE BAR ]", w-40, 290);
		  Font font4 = new Font ("Courier", Font.BOLD,20);
		  g.setFont(font4);
		  g.setColor(Color.white);
		  g.drawString("A - Left", w, 330);
		  g.drawString("D - Right", w, 350);
		  g.drawString("S - Down", w, 370);
		  g.drawString("W - Up", w, 390);
		  g.drawString("Q - Slide Left", w, 410);
		  g.drawString("E - Slide Right", w, 430);
		  g.drawString("SPACE BAR - Shoot Bullets", w, 450);
		  Font font5 = new Font ("Courier", Font.BOLD,40);
		  g.setFont(font5);
		  g.drawString("Press [ENTER] to begin", w-200, 550);
	}

}
