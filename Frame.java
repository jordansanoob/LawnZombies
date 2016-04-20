/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 */
//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * The frame class creates the frame for our Lawn Zombies
 * It creates a FLowLayout and a panel 
 * It also sets the size of the frame 
 */
public class Frame extends Screen implements Runnable{
	
	public static final int w = 400; 
	public static final int h = w/12 * 9;
	public static final int SCALE = 2;
	public static boolean open;
	
	private boolean running = false;
	private Thread thread;
	private static final long serialVersionUID = 1L;
	//private static final LayoutManager Flowlayout() = null;
	
	private synchronized void start(){
		if(running){
		 return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	private synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try{
			thread.join(); //joins all the threads togehter
		}
		catch (InterruptedException e){  //catches all the exceptions
			e.printStackTrace();
		}
		System.exit(1);
	}

	/**
	   * Creates the main method of the frame
	   * sets the title of the frame
	   */
	  public void run(){
	  	while(running){
	  		//game loop runs the game
	  	}
	  	stop();
	  }
	  public static void main (String[] args){

	      JFrame frame = new JFrame("LAWN ZOMBIES");
	      frame.setPreferredSize(new Dimension(w * SCALE, h * SCALE));
	      frame.setMaximumSize(new Dimension(w * SCALE, h * SCALE));
	      frame.setMinimumSize(new Dimension(w * SCALE, h * SCALE));
	      Screen screen = new Screen();
	      //frame.setLayout(new FlowLayout());
	      frame.add(screen); //adds the frame to the JFrame
	      frame.pack(); //packs everything together
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      frame.setResizable(false); //makes it so you cannot resize
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true); //sets the program to visible
	      //frame.start();
	      
	  }
}
