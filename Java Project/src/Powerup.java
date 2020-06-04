import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;


public class Powerup extends Collidable{

	private int radius;
	
	
	public Powerup(int x, int y, int height) {
		super(x, y, height*2, height*2);
		radius = height;
	}
	
	public int collides(Ball b) {
		  if( Math.pow(x+radius-b.getXpos()+b.getRadius(), 2)+Math.pow(y+radius-b.getYpos()+b.getRadius(), 2) <= Math.pow(radius + b.getRadius(), 2)) return 1;
		  return 0;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, radius, radius);
		
	}
	

}
