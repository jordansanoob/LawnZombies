import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author Jordan Abbatiello, Allison Rowe, Jack Erwin
 *provides a background image
 *provides the upper limit of the frame that the zombies spawn in
 *provides the lower limit of the frame that the zombies must cross in order
 *to damage the player
 */
public class Screen extends JPanel {
	
	Image background;
	private static int upperBound;
	private static int lowerBound;
	
	/**
	 * Constructor for the screen class
	 */
	public Screen(){
		//temporary
		setBackground(Color.GREEN);
	}
}
