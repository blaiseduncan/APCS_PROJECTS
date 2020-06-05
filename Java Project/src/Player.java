import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player {
	private int x;
	private int y;
	private int ballradius;
	private double speed;
	private int px;
	private int py;
	private int timer;
	
	
	public void setRadius(int diameter) {
		this.ballradius = diameter;
	}

	private double angle;
	private ArrayList<Ball> balls;

	public Player(int x, int y, double angle, int r) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		ballradius = r;
		balls = new ArrayList<Ball>();
		for(int i = 0; i < 9; i++) {
			balls.add(new Ball(x, y, ballradius, 0, 0));
		}
	}
	
	
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString(""+balls.get(0).getXv()+balls.get(0).isMoving()+speed, 400, 400);
		g.fillOval(x, y, ballradius, ballradius);
		for(int i = 0; i < balls.size(); i++) {
			balls.get(i).paint(g);
				if(!balls.get(i).isMoving()) {
				balls.get(i).setXv(Math.cos(Math.toRadians(angle))*speed);
				balls.get(i).setYv(-Math.sin(Math.toRadians(angle))*speed);
				balls.get(i).setXpos(x);
				balls.get(i).setYpos(y);
				}
		}
		
	}
	
	
	public void fireBalls(int index, double a) {
			balls.get(index).setXv(Math.cos(Math.toRadians(a))*speed);
			balls.get(index).setYv(-Math.sin(Math.toRadians(a))*speed);
			balls.get(index).setMoving(true);
	}
	
	public boolean allBallsMoving() {
		for(int i = 0; i < balls.size();i++) {
			if(!balls.get(i).isMoving()) return false;
		}
		return true;
	}
	
	public int getDiameter() {
		return ballradius;
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



	public double getSpeed() {
		return speed;
	}



	public void setSpeed(double speed) {
		this.speed = speed;
	}



	public int getPx() {
		return px;
	}



	public void setPx(int px) {
		this.px = px;
	}



	public int getPy() {
		return py;
	}



	public void setPy(int py) {
		this.py = py;
	}
}