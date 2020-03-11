
public class Powerup extends Collidable{

	private int radius;
	
	
	public Powerup(int x, int y, int height) {
		super(x, y, height*2, height*2);
		radius = height;
	}
	
	public boolean collides(Ball b) {
		  return Math.pow(x+radius-b.getX()+b.getRadius(), 2)+Math.pow(y+radius-b.getY()+b.getRadius(), 2) <= Math.pow(radius + b.getRadius(), 2);
	}

}
