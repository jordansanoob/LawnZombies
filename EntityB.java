
/** @author Allison Rowe, Jack Erwin, Jordan A.
 * (Allison Created this)
 */ 
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 *EntityB interface
 */ 
public interface EntityB {

	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	public int getX();
	public int getY();
}