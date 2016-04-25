package con.gam.src.main;

import java.awt.Graphics;

public interface Entity {
	public void tick();
	public void redner(Graphics g);
	
	public Double getX();
	public Double getY();

}
