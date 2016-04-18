/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 */
//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * The frame class creates the frame for our Lawn Zombies
 * It creates a FLowLayout and a panel 
 * It also sets the size of the frame 
 */
public class Frame extends Screen{
	
	public static int w = 800; 
	public static int h = 1000;
	public static boolean open;
	private static final long serialVersionUID = 1L;

	/**
	   * Creates the main method of the frame
	   * sets the title of the frame
	   */
	  public static void main (String[] args){

	      JFrame frame = new JFrame ("LAWN ZOMBIES");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      Screen screen = new Screen();
	      screen.setLayout(new FlowLayout());  //sets a split layout
	      frame.setLocation(500, 0);
	  //    screen.setLayout(new BorderLayout()); //sets non-split layout
	      frame.setSize(w,h);
	      screen.setSize(w,h);
	      frame.add(screen);
	      //frame.pack();
	      frame.setVisible(true);
	  }
}
