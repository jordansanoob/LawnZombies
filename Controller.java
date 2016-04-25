
	import java.awt.Graphics;
	import java.awt.Image;
	import java.util.ArrayList;
	import java.util.LinkedList;

	import javax.swing.JPanel;
	//create a timer

	/**
	 * 
	 * @author John Erwin, Allison Rowe, Jordan Abbatiello
	 * Controller will use LinkedList to keep track of the zombies and bullets on screen.
	 * In both its tick and draw method it will move the zombies and bullets accordingly and will eventually 
	 * hold our collision method
	 *  
	 */
	public class Controller{
		private LinkedList<Bullet> b = new LinkedList<Bullet>();
		private LinkedList<Zombie> z = new LinkedList<Zombie>();
		private Image background;
		
		//will probably have a linked list of zombies as well
		
		Bullet TempBullet;
		Game game;
		
		Zombie TempZombie;
		
		public Controller(Game game){
			this.game = game;
		}
		
		public void tick(){
			for(int i = 0; i < b.size(); i++){
				TempBullet = b.get(i);
				
				if(TempBullet.getY() < 0
						|| TempBullet.getY() > 800
						|| TempBullet.getX() < 0
						|| TempBullet.getX() > 640){
				removeBullet(TempBullet);
				}
				TempBullet.tick(); 
				
			}
			for(int i = 0; i < z.size(); i++){
				TempZombie = z.get(i);
				TempZombie.tick();
			}
		}
		
		public void render(Graphics g){
			for(int i = 0; i < b.size(); i++){
				TempBullet = b.get(i);
				TempBullet.render(g);
			}
			for(int i = 0; i < z.size(); i++){
				TempZombie = z.get(i);
				
				TempZombie.draw();
			}
		}
			
		public void addBullet(Bullet bullet){
			b.add(bullet);
		}
		
		public void removeBullet(Bullet bullet){
			b.remove(bullet);
		}
		
		public void addZombie(Zombie zombie){
			z.add(zombie);
		}
		
		public void removeZombie(Zombie zombie){
			z.remove(zombie);
	}
}
