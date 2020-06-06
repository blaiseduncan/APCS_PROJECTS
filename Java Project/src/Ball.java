

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;

public class Ball {
private int radius; 
private double xpos;
private  double ypos;
private  double xv;
private  double yv;
private boolean active;
private static double lastX;

public Ball(int px, int py, int r, double pxv, double pyv){
	xpos=px;
	ypos=py;
	radius=r;
	xv= pxv;
	yv= pyv;
	setLastX(px);
 }

 public void move(){
	 xpos+=xv;
	 ypos+=yv;
 }
 public void bounce(){
	 xv=-xv;
 }
 
 public void bounceY(){
	 yv=-yv;
 }
 public int getRadius() {
	return radius;
}
public void setRadius(int radius) {
	this.radius = radius;
}
public double getXpos() {
	return xpos;
}
public void setXpos(double xpos) {
	this.xpos = xpos;
}
public double getYpos() {
	return ypos;
}
public void setYpos(double ypos) {
	this.ypos = ypos;
}
public double getXv() {
	return xv;
}
public void setXv(double xv) {
	this.xv = xv;
}
public double getYv() {
	return yv;
}
public void setYv(double yv) {
	this.yv = yv;
}
public void paint(Graphics g){
	System.out.println(lastX);
	g.setColor(Color.blue);
	if(ypos >= Driver.screen_height-radius*2-50) active = false;
	if(ypos <= 0) {
		ypos = 0+radius;
		bounceY();
	}
	if(xpos <= 0) {
		xpos = 0+radius;
		bounce();
	}
	if(xpos >= Driver.screen_width-radius*2-44+25) {
		xpos = Driver.screen_width-radius*2-49;
		bounce();
	}
	
	if(active) {
		g.fillOval((int)(xpos)-radius, (int)(ypos)-radius, radius*2, radius*2);
		xpos += xv;
		ypos += yv;
	}
 }

public boolean isActive() {
	return active;
}

public void setActive(boolean moving) {
	this.active = moving;
}

public static double getLastX() {
	return lastX;
}

public static void setLastX(double lastX) {
	Ball.lastX = lastX;
}
}

