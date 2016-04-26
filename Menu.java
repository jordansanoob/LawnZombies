import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Menu {
	
	private int h = 200;
	private int w = 260;
	public void render(Graphics g){
		  g.setColor(Color.white);
		  Font font1 = new Font ("Courier", Font.BOLD,60);
		  g.setFont(font1);
		  g.drawString("LAWN ZOMBIES", w-150, h-50);
		  Font font2 = new Font ("Courier", Font.BOLD,40);
		  g.setFont(font2);
		  g.drawString("CONTROLS", w-100, h);
		  Font font3 = new Font ("Courier", Font.BOLD,25);
		  g.setFont(font3);
		  g.drawString("[Q][W][E]", w-60, 220);
		  g.drawString("[A][S][D]", w-60, 240);
		  g.drawString("[ SPACE BAR ]", w-60, 260);
		  Font font4 = new Font ("Courier", Font.BOLD,20);
		  g.setFont(font4);
		  g.drawString("A - Left", w, 280);
		  g.drawString("D - Right", w, 300);
		  g.drawString("S - Down", w, 320);
		  g.drawString("W - Up", w, 340);
		  g.drawString("Q - Slide Left", w, 360);
		  g.drawString("E - Slide Right", w, 380);
		  g.drawString("SPACE BAR - Shoot Bullets", w, 400);
		  Font font5 = new Font ("Courier", Font.BOLD,40);
		  g.setFont(font5);
		  g.drawString("Press [ENTER] to begin", w-200, 550);
	}

}
