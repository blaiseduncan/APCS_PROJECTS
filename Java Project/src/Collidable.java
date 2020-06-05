import java.awt.Graphics;

public class Collidable {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int hp;
	
	public Collidable(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public static float clamp(float value, float min, float max) {
		//takes value and makes it work within the range minimum-max.
		//if the value is less than the minimum it returns minimum, greater than max returns max, and if its within range then it simply returns itself.
	    float x = value;
	    if (x < min) {
	        x = min;
	    } else if (x > max) {
	        x = max;
	    }
	    return x;
	}
	
	public int collides(Ball b) {
		//uses the clamp button to determine closest
	    float closestX = clamp((int)(b.getXpos())+b.getRadius(), x, x + width);
	    float closestY = clamp((int)(b.getYpos())+b.getRadius(), y , y + height);
	 
	    float distanceX = (int)(b.getXpos()+b.getRadius()) - closestX;
	    float distanceY = (int)(b.getYpos()+b.getRadius()) - closestY;
	    //System.out.println(distanceX+"|"+distanceY);
	    
	   //if(this.getClass().getName().equals("Block") && Math.sqrt( Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) <= 5) System.out.println("yes");
	   // System.out.println(Math.sqrt( Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));
	    
	    
	    if(Math.sqrt( Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) <= 5){
	    	//System.out.println("yesa");
	    	//System.out.println(closestX+"|"+closestY);
	    	if(     (((int)(closestX) <= x+b.getRadius() && (int)(closestX) >= x )|| ( (int)(closestX) >= x+width-b.getRadius() && (int)(closestX) <= x+width) ) && (    (int)(closestY) > y && (int)(closestY) < y + height) ) return (2); 
	    	if(((int)(closestX) > x && (int)(closestX) < x+width) && (((int)(closestY) <= y+b.getRadius() && (int)(closestY) >= y )|| ( (int)(closestY) >= y+height-b.getRadius() && (int)(closestY) <= y+height) )) return (1);
	    }
	    return 0;
	}
	 

	
	public void paint(Graphics g) {
  
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	
}
