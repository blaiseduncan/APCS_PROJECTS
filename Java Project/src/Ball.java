

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;

public class Ball {
private int radius; 
private int xpos;
private  int ypos;
private  int xv;
private  int yv;
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
 }public void bounceY(){
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
public int getXv() {
	return xv;
}
public void setXv(int xv) {
	this.xv = xv;
}
public int getYv() {
	return yv;
}
public void setYv(int yv) {
	this.yv = yv;
}
public void paint(Graphics g){
		g.setColor(Color.blue);
	g.fillOval(xpos, ypos, radius, radius);
 }
}

