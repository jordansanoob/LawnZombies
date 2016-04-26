/**
 * @author Allison, jack, Jordan
 * (Jordan Created this class)
 */ 
import java.awt.image.BufferedImage;
/**
 * SpriteSheet class addes the sprites as images
 */ 
public class SpriteSheet {
	
	private BufferedImage image;
	
	/**
	 * adds sprites as images
	 * */
	public SpriteSheet(BufferedImage image){
		this.image = image;
	}
	/**
	 * BufferedImage grabs the image
	 */ 
	public BufferedImage grabImage(int col, int row, int width, int height){
		BufferedImage img = image.getSubimage((col*32)-32, (row*32)-32, width, height);
		return img;
	}

}
