import java.awt.Color;
import java.awt.Graphics;

public class Board {
	private int width;
	private int height;
	private Collidable[][] objects;
	private Player p;
	private int mouseX;
	private int mouseY;
	public static int playerToMouseDist;


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

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Board(int w, int h) {
		objects = new Collidable[8][7];
		p = new Player(337, 750, 0, 10);
		
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				//objects[row][col] = new Block( -100, -100, 0, 0, 0);
				objects[row][col] = new Empty(0, 0, 0, 0);
			}
		}
	}
	
	public void paint(Graphics g) {
		
		//calculates distance from mouse to player
		playerToMouseDist = (int) Math.sqrt( Math.pow((mouseY-p.getY()-p.getDiameter()/2) , 2 ) + Math.pow((mouseX-p.getX()-p.getDiameter()/2),2 ));
		p.setSpeed(playerToMouseDist*20 / 350);
		
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
		
		g.fillOval(mouseX, mouseY, 5, 5);
		p.setAngle(-Math.toDegrees(Math.atan2((double)(mouseY-p.getY()-p.getDiameter()/2),(double)(mouseX-p.getX()-p.getDiameter()/2))));
		if(p.getAngle() <= 0) p.setAngle(p.getAngle()+360);
		g.drawString(""+p.getAngle()+"", 100, 100);
		g.drawString(""+playerToMouseDist+"", 100, 50);
		
		
		if(	playerToMouseDist < 350) {
			if (playerToMouseDist <= 255) g.setColor(new Color(255-playerToMouseDist ,255,255-playerToMouseDist/2)); else { g.setColor(new Color(0,255,127));}
			g.drawLine(p.getX()+p.getDiameter()/2, p.getY()+p.getDiameter()/2, (int)(playerToMouseDist*Math.cos(Math.toRadians(p.getAngle()) )+p.getX()+p.getDiameter()/2), (p.getY()+p.getDiameter()/2 - (int)(playerToMouseDist*Math.sin(Math.toRadians(p.getAngle()))   )));
		} else {
			g.setColor(new Color(0,255,127));
			g.drawLine(p.getX()+p.getDiameter()/2, p.getY()+p.getDiameter()/2, (int)(350*Math.cos(Math.toRadians(p.getAngle()) )+p.getX()+p.getDiameter()/2), (p.getY()+p.getDiameter()/2 - (int)(350*Math.sin(Math.toRadians(p.getAngle()))   )));
		}
		
		
		p.paint(g);
		
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

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

}
	
