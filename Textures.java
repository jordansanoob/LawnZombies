import java.awt.image.BufferedImage;

public class Textures {
	public BufferedImage playerF, playerB, playerL, playerR, bulletF, bulletB, bulletL, bulletR, zombieDub, zombieSing, zombieNone;
	private SpriteSheet ss;
	
	public Textures(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		getTextures();
	}
	
	private void getTextures(){
		playerF = ss.grabImage(2,  2, 32, 32);
		playerB = ss.grabImage(1,  2, 32, 32);
		playerL = ss.grabImage(3,  2, 32, 32);
		playerR = ss.grabImage(4,  2, 32, 32);
		bulletF = ss.grabImage(2, 1, 32, 32);
		bulletB = ss.grabImage(1, 1, 32, 32);
		bulletL = ss.grabImage(3, 1, 32, 32);
		bulletR = ss.grabImage(4, 1, 32, 32);
		zombieDub = ss.grabImage(1, 3, 32, 32);
		zombieSing = ss.grabImage(3, 3, 32, 32);
		zombieNone= ss.grabImage(2, 3, 32, 32);

		
	}
}