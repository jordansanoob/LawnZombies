/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 */
//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * The frame class creates the frame for our Lawn Zombies
 * It creates a FLowLayout and a panel 
 * It also sets the size of the frame 
 */
public class Game extends Canvas implements Runnable{
	
	public static final int w = 320; 
	public static final int h = 460;
	public static final int SCALE = 2;
	public static boolean open;
	public final String title = "Lawn Zombies";
	public Controller controller;
	private boolean running = false;
	private Thread thread;
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	
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
		  long lastTime = System.nanoTime();
		  final double amountOfTicks = 60.0;
		  double ns = 1000000000 / amountOfTicks;
		  double delta = 0;
		  int updates = 0;
		  int frames = 0;
		  long timer = System.currentTimeMillis();
		  
		  
	  	while(running){
	  		long now = System.nanoTime();
	  		delta += (now - lastTime) / ns;
	  		lastTime = now;
	  		if(delta >=1){
	  			tick();
	  			updates ++;
	  			delta --;
	  		}
	  		render();
	  		frames++;
	  		
	  		if(System.currentTimeMillis() - timer > 1000){
	  			timer += 1000;
	  			System.out.println(updates + " Ticks, Fps " + frames);
	  			updates = 0; 
	  			frames = 0;
	  		}
	  	}
	  	stop();
	  }
	  
	  private void tick(){
		  
	  }
	  
	  private void render(){
		  BufferStrategy bs = this.getBufferStrategy();
		  if(bs == null){
			  createBufferStrategy(3);
			  return;
		  }
		  Graphics g = bs.getDrawGraphics();
		  g.drawImage(image,  0,  0,  getWidth(), getHeight(), this);
		  
		  g.dispose();
		  bs.show();
	  }
	  
	  public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			p.setX(p.getX + 5);		//need to change all of these to VelocityX and Y eventually
		} else if(key == KeyEvent.VK_LEFT){
			p.setX(p.getX - 5);
		} else if(key == KeyEvent.VK_DOWN){
			p.setY(p.getY + 5);
		} else if(key == KeyEvent.VK_UP){
			p.setY(p.getY - 5);
		}
	}
	
	public void keyReleased(KeyEvent e){
		
	}
}
	  
	  public static void main (String[] args){
		  Game game = new Game();
		  //Controller controller = new Controller();
		  Color background = new Color(102, 255, 102);
		  
		  game.setPreferredSize(new Dimension(w * SCALE, h * SCALE));
	      game.setMaximumSize(new Dimension(w * SCALE, h * SCALE));
	      game.setMinimumSize(new Dimension(w * SCALE, h * SCALE));
	      game.setBackground(background);
	      JFrame frame = new JFrame("Lawn Zombies");
	     // Screen screen = new Screen();
	      
	      
	      
	      
	      frame.add(game);
	      //frame.add(screen);
	      frame.pack();
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      frame.setResizable(false);
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	      game.start();
	      
	  }
}
