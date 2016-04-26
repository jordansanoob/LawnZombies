/**
 * @author Allison, Jack, Jordan
 * (Jordan Created this class)
 */ 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * KeyInput class
 * @extends KeyAdapter
 */ 
public class KeyInput extends KeyAdapter{
	
	Game game;
	/**
	 * KeyInput sets the game depending on the key
	 */ 
	public KeyInput(Game game){
		this.game = game;
	}
	/**
	 * keyPressed sets the keyPressed
	 */ 
	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}
	/**
	 * keyReleased sets the keyReleased
	 */
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}

}
