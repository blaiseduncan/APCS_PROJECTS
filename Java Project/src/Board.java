import java.awt.Color;
import java.awt.Graphics;

public class Board {
	int width;
	int height;
	Collidable[][] objects;


	public Board(int w, int h) {
		objects = new Collidable[8][7];
		
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				//objects[row][col] = new Block( -100, -100, 0, 0, 0);
				objects[row][col] = new Empty(0, 0, 0, 0);
			}
		}
	}
	
	public void paint(Graphics g) {
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				objects[row][col].paint(g);
			}
		}
		for(int col = 0; col <= objects[0].length; col++) {
			g.setColor(Color.gray);
			g.drawLine(100*col, 0, 100*col, 800);
		}
		
		for(int row = 0; row <= objects.length;row++) {
			g.setColor(Color.gray);
			g.drawLine(0, 100*row, 100*7, 100*row);
		}
		
		
	}
	
	public void populateRow(int row, int h) {
		Collidable[] temp = new Collidable[objects[row].length];
		for(int i = 0; i < temp.length;i++) {
			if(!((int)(Math.random()*3)==0)) {
				if((int)(Math.random()*20)==0) {
					objects[row][i] = new Block( i*100, row*100, 100, 100, h*2);
				}  else {  objects[row][i] = new Block( i*100, row*100, 100, 100, h); }
			} else { if((int)(Math.random()*2)==0) {
				objects[row][i] = new Powerup(i*100+37, row*100+37, 25);
				} continue; 
			}
		}
	}

}
	
