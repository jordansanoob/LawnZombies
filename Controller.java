import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

	/**
	 * 
	 * @author John Erwin, Allison Rowe, Jordan Abbatiello
	 * Controller will use LinkedList to keep track of the zombies and bullets on screen.
	 * In both its tick and draw method it will move the zombies and bullets accordingly and will eventually 
	 * hold our collision method
	 *(Created by Allison, Jack, and Jordan) 
	 */
	public class Controller{
		private LinkedList<EntityA> ea = new LinkedList<EntityA>(); 
		private LinkedList<EntityB> eb = new LinkedList<EntityB>();
		EntityA entA; //Created in seporate Classes
		EntityB entB;
		private Textures tex;
		Random r = new Random(); //generate random for the zoombies getting added to the game class
		private Game game;
		/**
		 * sets the controller to deal with the textures and the game 
		 */ 
		public Controller(Textures tex, Game game){
			this.tex = tex;
			this.game = game;
		}
		/**
		 *CreateZombie method counts the zombies nad creates them
		 */ 
		 public void createZombie(int eCount){
			 for(int i = 0; i < eCount; i++){
				 addEntity(new Zombie(r.nextInt(640), -10, tex, this, game));
			 }
		 }
		/**
		 * tick method gets the size of the EntityA and EntitiyB
		 */ 
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
		/**
		 * Render method
		 */ 
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
		/**
		 * Adds the bullet
		 */ 
		public void addEntity(EntityA bullet){
			ea.add(bullet);
		}
		/**
		 *removes the zombie when collision occurs
		 */ 
		public void removeEntity(EntityA obj){
			ea.remove(obj);
		}
		/**
		 *adds the next zombie after it is removed
		 */ 
		public void addEntity(EntityB obj){
			eb.add(obj);
		}
		/**
		 *removes the zombies when collision occurs 
		 */ 
		public void removeEntity(EntityB obj){
			eb.remove(obj);
		}
		/**
		 *EntityA return method
		 */ 
		public LinkedList<EntityA> getEntityA(){
			return ea;
		}
		/**
		 *EntityB return method
		 */ 
		public LinkedList<EntityB> getEntityB(){
			return eb;
		}	

}
