import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;


public class Powerup extends Collidable{

	private int radius;
	
	
	public Powerup(int x, int y, int radius) {
		super(x, y, radius*2, radius*2);
		this.radius = radius;
	}
	
	public int collides(Ball b) {
		
		//FIX THIS DISTANCE FORMULA
		double xDif = (b.getXpos()) - x-height/2;
		double yDif = (b.getYpos()) - y-height/2;
		double distanceSquared = xDif * xDif + yDif * yDif;
		boolean collision = distanceSquared <= (b.getRadius() + radius) * (b.getRadius() + radius);
		
		if(collision) {
			return 1;
		  }
		  return 0;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, radius*2, radius*2);
		g.setColor(Color.BLACK);
		g.fillOval(x+radius, y+radius, 1, 1);
		
	}
	

}
