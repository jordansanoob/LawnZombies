	import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

	/**
	 * 
	 * @author John Erwin, Allison Rowe, Jordan Abbatiello
	 * Controller will use LinkedList to keep track of the zombies and bullets on screen.
	 * In both its tick and draw method it will move the zombies and bullets accordingly and will eventually 
	 * hold our collision method
	 *  
	 */
	public class Controller{
		private LinkedList<EntityA> ea = new LinkedList<EntityA>();
		private LinkedList<EntityB> eb = new LinkedList<EntityB>();
		EntityA entA; 
		EntityB entB;
		private Textures tex;
		Random r = new Random();
		private Game game;
		
		public Controller(Textures tex, Game game){
			this.tex = tex;
			this.game = game;
		}
		 public void createZombie(int eCount){
			 for(int i = 0; i < eCount; i++){
				 addEntity(new Zombie(r.nextInt(640), -10, tex, this, game));
			 }
		 }
		
		public void tick(){
			
			//A Class
			for(int i = 0; i<ea.size(); i++){
				entA = ea.get(i);
				entA.tick();
			}
			//B Class
			for(int i = 0; i<eb.size(); i++){
				entB = eb.get(i);
				entB.tick();
			}
		}
		public void render(Graphics g){
			//A Class
			for(int i = 0; i<ea.size(); i++){
				entA = ea.get(i);
				entA.render(g);
			}
			
			//B Class
			for(int i = 0; i<eb.size(); i++){
				entB = eb.get(i);
				entB.render(g);
			}
		}
		public void addEntity(EntityA bullet){
			ea.add(bullet);
		}
		public void removeEntity(EntityA obj){
			ea.remove(obj);
		}
		public void addEntity(EntityB obj){
			eb.add(obj);
		}
		public void removeEntity(EntityB obj){
			eb.remove(obj);
		}
		public LinkedList<EntityA> getEntityA(){
			return ea;
		}
		public LinkedList<EntityB> getEntityB(){
			return eb;
		}	

}