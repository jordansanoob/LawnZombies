import java.awt.image.BufferedImage;

public class Textures {
	public BufferedImage player, bullet, zombie;
	private SpriteSheet ss;
	
	public Textures(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		//getTextures();
	}
}