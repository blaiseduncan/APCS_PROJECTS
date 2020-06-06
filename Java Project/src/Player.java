import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Player {
	private int x;
	private int y;
	private int numballs;
	private int ballradius;
	private double speed;
	private int px;
	private int py;
	private double angle;
	private ArrayList<Ball> balls;
	private boolean firing;
	private int cntr;

	public Player(int x, int y, double angle, int r) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		ballradius = r;
		balls = new ArrayList<Ball>();
		cntr = 0;
	}
	
	
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		if(!ballsActive()) {
			g.fillRect(x, y, ballradius, ballradius);
		} else {
			if(!firing) x = (int) (Ball.getLastX());
		}
		for(int i = 0; i < balls.size(); i++) {
			//g.drawString(""+balls.get(0).getXv()+balls.get(i).isActive()+speed, 400, 400);
			balls.get(i).paint(g);
			if(balls.get(i).isActive()==false) {
				balls.remove(i);
				i--;
			} else {
				Ball.setLastX(balls.get(i).getXpos());
			}
		}
		//THIS FIREING SYSTEM NEEDS WORK STILL
		if(firing) {
			//System.out.println(fireing);
			if(cntr < numballs) {
				//System.out.println(balls.size()+" "+Driver.timer);
				if(Driver.timer % 10 == 0) {
					cntr++;
					balls.add(new Ball(x, y, ballradius, 0,0));
					balls.get(balls.size()-1).setXv(Math.cos(Math.toRadians(angle))*speed);
					balls.get(balls.size()-1).setYv(-Math.sin(Math.toRadians(angle))*speed);
					balls.get(balls.size()-1).setActive(true);
				}
			} 
			else { 
				firing = false; 
				cntr = 0;
			}
		}
	}
	
	public void fireBalls(double ang) {
		firing = true;
	}
	
	public boolean ballsActive() {
		for(Ball b: balls) {
			if(b.isActive()==true) return true;
		}
		return false;
	}
	
	public int getDiameter() {
		return ballradius;
	}
	
	public void setRadius(int diameter) {
		this.ballradius = diameter;
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



	public int getNumballs() {
		return numballs;
	}



	public void setNumballs(int numballs) {
		this.numballs = numballs;
	}



	public boolean isFireing() {
		return firing;
	}



	public void setFireing(boolean fireing) {
		this.firing = fireing;
	}


}