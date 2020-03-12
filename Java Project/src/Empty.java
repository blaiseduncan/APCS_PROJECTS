import java.awt.Graphics;

public class Empty extends Collidable {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public Empty(int x, int y, int height, int width) {
		super(x,y,height,width);
	}
	
	public boolean collides(Ball b) {
		return false;
	}
	
	public void paint(Graphics g) {
		
	}
}
