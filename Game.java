/**
 * @author AllisonRowe, JackErwin, JordanAbbatiello
 */
//import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

/**
 * The frame class creates the frame for our Lawn Zombies
 * It creates a FLowLayout and a panel 
 * It also sets the size of the frame 
 */
public class Game extends Canvas implements Runnable{
	
	public static final int w = 320; 
	public static final int h = 400;
	public static final int SCALE = 2;
	public static boolean open;
	public final String title = "Lawn Zombies";
	private boolean running = false;
	private Thread thread;
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	
	private int eCount = 1;
	private int eKilled = 0;
	
	private Player p;
	private Controller c;
	private Textures tex;
	
	public static int Health = (int) (100 * 1.5); //added health
	
	private boolean isShooting = false;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	
	
	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		
		try{
			
			spriteSheet = loader.loadImage("/spriteSheet.png");
			background = loader.loadImage("/background.png");
		}catch(IOException e){
			e.printStackTrace();	
		}
		
		tex = new Textures(this);
		//p = new Player(w, (h*2) - 110, tex, this, c);
		c = new Controller(tex, this);
		p = new Player(w, (h*2) - 110, tex, this, c);
		this.addKeyListener(new KeyInput(this));
		c.createZombie(eCount);
		
		ea = c.getEntityA();
		eb = c.getEntityB();
		
		c.createZombie(eCount);
	}
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
		  init();
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
		  p.tick();
		  c.tick();
		  
		  if(eKilled >= eCount){
			 eCount+=2;
			 eKilled=0;
			 c.createZombie(eCount);
		  }
	  }
	  
	  private void render(){
		  BufferStrategy bs = this.getBufferStrategy();
		  if(bs == null){
			  createBufferStrategy(3);
			  return;
		  }
		  Graphics g = bs.getDrawGraphics();
		  //////////////////////////////////////////
		  
		  g.drawImage(image,  0,  0,  getWidth(), getHeight(), this);
		  
		  g.drawImage(background, 5, 5, null);		  
		  p.render(g);
		  c.render(g);
		  
		  //added health bar
		  g.setColor(Color.gray);
		  g.fillRect(10, 10, 150, 50);
		  g.setColor(Color.red);
		  g.fillRect(10, 10, Health, 50);
		  g.setColor(Color.white);
		  g.drawRect(10, 10, 150, 50);
		  Font font = new Font ("Courier", Font.BOLD,20);
		  g.setFont(font);
		  g.drawString("HEALTH BAR", 20, 45);
		  Font font2 = new Font ("Courier", Font.BOLD,15);
		  g.setFont(font2);
		  g.drawString("CONTROLS", 15, 95);
		  Font font3 = new Font ("Courier", Font.BOLD,12);
		  g.setFont(font3);
		  g.drawString("[Q][W][E]", 15, 115);
		  g.drawString("[A][S][D]", 15, 125);
		  g.drawString("[ SPACE BAR ]", 15, 145);
		  Font font4 = new Font ("Courier", Font.BOLD,10);
		  g.setFont(font4);
		  g.drawString("A - Left", 15, 165);
		  g.drawString("D - Right", 15, 175);
		  g.drawString("S - Down", 15, 185);
		  g.drawString("W - Up", 15, 195);
		  g.drawString("Q - Slide Left", 15, 205);
		  g.drawString("E - Slide Right", 15, 215);
		  g.drawString("SPACE BAR - Shoot Bullets", 15, 235);
		  Font font6 = new Font ("Times", Font.ITALIC,90);
		  g.setFont(font6);
		  //g.setColor(Color.GREEN);
		  //g.drawString("LAWN ZOMBIES", 10, 400);
		  Font font5 = new Font ("Courier", Font.BOLD,30);
		  g.setFont(font5);
		  g.setColor(Color.white);
		  g.drawString("____________________________________", 10, 650);
		  g.drawString("DOUBLE TAP SPACE BAR TO BEGIN GAME", 10, 700);
		  //Rectangle2D rect = new Rectangle2D.Double(0,0,w,h);
		  //g.fill(rect);
		  //////////////////////////////////////////
		  g.dispose();
		  bs.show();
	  }
	  
	  
	  public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D){
			p.setDirection("right");
			p.setVelX(5);	
		} else if(key == KeyEvent.VK_A){
			p.setDirection("left");
			p.setVelX(-5);
		} else if(key == KeyEvent.VK_S){
			p.setDirection("back");
			p.setVelY(5);
		} else if(key == KeyEvent.VK_W){
			p.setDirection("front");
			p.setVelY(-5);
		} else if(key == KeyEvent.VK_E){
			p.setDirection("front");
			p.setVelX(5);
		} else if(key == KeyEvent.VK_Q){
			p.setDirection("front");
			p.setVelX(-5);
		}else if(key == KeyEvent.VK_SPACE && !isShooting){
			
			c.addEntity(new Bullet(p.getX(), p.getY(), p.getDirection(), tex, this));
			//c.addEntity(new Bullet(p.getX(), p.getY(), this));
			isShooting = true;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D){
			p.setVelX(0);	
		} else if(key == KeyEvent.VK_A){
			p.setVelX(0);
		} else if(key == KeyEvent.VK_S){
			p.setVelY(0);
		} else if(key == KeyEvent.VK_W){
			p.setVelY(0);
		} else if(key==KeyEvent.VK_SPACE){
			isShooting = false;
		} else if(key == KeyEvent.VK_E){
			p.setVelX(0);
		} else if(key == KeyEvent.VK_Q){
			p.setVelX(0);
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
	      frame.add(game);
	      frame.pack();
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	      frame.setResizable(false);
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	      game.start();
	      
	  }
	  public BufferedImage getSpriteSheet(){
		  return spriteSheet;
	  }
	public int geteCount() {
		return eCount;
	}
	public void seteCount(int eCount) {
		this.eCount = eCount;
	}
	public int geteKilled() {
		return eKilled;
	}
	public void seteKilled(int eKilled) {
		this.eKilled = eKilled;
	}
}
