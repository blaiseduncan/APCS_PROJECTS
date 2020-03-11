import java.awt.Color;
import java.awt.Graphics;

public class Board {
int width;
int height;
Collidable[][] objects;


	public Board(int w, int h) {
		objects = new Collidable[8][7];
	}
	
	public void paint(Graphics g) {
		for(int col = 0; col <= objects[0].length; col++) {
			g.setColor(Color.gray);
			g.drawLine(100*col, 0, 100*col, 800);
		}
		
		for(int row = 0; row <= objects.length;row++) {
			g.setColor(Color.gray);
			g.drawLine(0, 100*row, 100*7, 100*row);
		}
	}

}
	
