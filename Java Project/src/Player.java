import java.awt.Graphics;
import java.util.ArrayList;

public class Player {
	private int x;
	private int y;
	private int diameter;
	public int getDiameter() {
		return diameter;
	}



	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	private double angle;
	private ArrayList<Ball> balls;

	public Player(int x, int y, double angle, int d) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		diameter = d;
		setBalls(new ArrayList<Ball>());
		
	}
	
	
	
	public void paint(Graphics g) {
		g.fillOval(x, y, diameter, diameter);
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

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public ArrayList<Ball> getBalls() {
		return balls;
	}

	public void setBalls(ArrayList<Ball> balls) {
		this.balls = balls;
	}
}