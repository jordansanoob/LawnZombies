/**
 *@author: Allison Rowe, Jack Erwin, Jordan Abbatiello
 * (Jordan Created this Class)
 */
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * This is the BufferImageLoader Class
 * It takes the Sprite Images and reads them into the program 
 */
public class BufferedImageLoader {

	
	private BufferedImage image;
	/**
	 * BufferImage Loads the Image by tracing its path
	 * @throws IOException
	 */
	public BufferedImage loadImage(String path) throws IOException{
		image = ImageIO.read(getClass().getResource(path));
		return image;
	}
}
