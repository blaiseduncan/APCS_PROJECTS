
public class Collidable {
	protected int x;
	protected int y;
	private int width;
	private int height;
	
	public Collidable(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	private boolean collides(Ball b) {
	    float closestX = clamp(b.getX()+b.getRadius(), x, x + width);
	    float closestY = clamp(b.getY()+b.getRadius(), y - height, y);
	 
	    float distanceX = b.getX() - closestX;
	    float distanceY = b.getY() - closestY;
	 
	    return Math.pow(distanceX, 2) + Math.pow(distanceY, 2) < Math.pow(b.getRadius(), 2);
	}
	 
	public static float clamp(float value, float min, float max) {
	    float x = value;
	    if (x < min) {
	        x = min;
	    } else if (x > max) {
	        x = max;
	    }
	    return x;
	}
}