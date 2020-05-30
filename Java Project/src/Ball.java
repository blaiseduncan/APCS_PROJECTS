

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;

public class Ball {
private int radius; 
private int xpos;
private  int ypos;
private  double xv;
private  double yv;
private boolean moving;

public Ball(int px, int py, int r, int pxv, int pyv){
	xpos=px;
	ypos=py;
	radius=r;
	xv= pxv;
	yv= pyv;
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
public int getXpos() {
	return xpos;
}
public void setXpos(int xpos) {
	this.xpos = xpos;
}
public int getYpos() {
	return ypos;
}
public void setYpos(int ypos) {
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
	g.setColor(Color.blue);
	if(ypos >= 850-radius*2) moving = false;
	if(ypos <= 0) bounceY();
	if(xpos <= 0) bounce();
	if(xpos >= 750-radius*2) bounce();
	
	if(moving) {
		g.fillOval(xpos, ypos, radius, radius);
		xpos += xv;
		ypos += yv;
	}
 }

public boolean isMoving() {
	return moving;
}

public void setMoving(boolean moving) {
	this.moving = moving;
}
}

