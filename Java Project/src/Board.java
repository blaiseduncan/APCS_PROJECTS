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
	private boolean moveInProg;
	


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
		p = new Player(337, 750, 0, 8);
		p.setNumballs(1);
		
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				//objects[row][col] = new Block( -100, -100, 0, 0, 0);
				objects[row][col] = new Empty(0, 0, 0, 0);
			}
		}
	}
	
	public void paint(Graphics g) {
		p.setPx(mouseX);
		p.setPy(mouseY);
		
		
		
		
		//calculates distance from mouse to player
		if(!p.isFireing()) {
			
			playerToMouseDist = (int) Math.sqrt( Math.pow((mouseY-p.getY()-p.getDiameter()/2) , 2 ) + Math.pow((mouseX-p.getX()-p.getDiameter()/2),2 ));
			
			p.setSpeed(Collidable.clamp(playerToMouseDist*20 / 350, (float)(4), (float)(13)));
			
			p.setAngle(-Math.toDegrees(Math.atan2((double)(mouseY-p.getY()-p.getDiameter()/2),(double)(mouseX-p.getX()-p.getDiameter()/2))));
			
			if(p.getAngle() <= 0) p.setAngle(p.getAngle()+360);
			
			if(!p.ballsActive()) {
				if(	playerToMouseDist < 350) {
					if (playerToMouseDist <= 255) g.setColor(new Color(255-playerToMouseDist ,255,255-playerToMouseDist/2)); else { g.setColor(new Color(0,255,127));}
					g.drawLine(p.getX()+p.getDiameter()/2, p.getY()+p.getDiameter()/2, (int)(playerToMouseDist*Math.cos(Math.toRadians(p.getAngle()) )+p.getX()+p.getDiameter()/2), (p.getY()+p.getDiameter()/2 - (int)(playerToMouseDist*Math.sin(Math.toRadians(p.getAngle()))   )));
				} else {
					g.setColor(new Color(0,255,127));
					g.drawLine(p.getX()+p.getDiameter()/2, p.getY()+p.getDiameter()/2, (int)(350*Math.cos(Math.toRadians(p.getAngle()) )+p.getX()+p.getDiameter()/2), (p.getY()+p.getDiameter()/2 - (int)(350*Math.sin(Math.toRadians(p.getAngle()))   )));
				}
				
				if(moveInProg) {
					moveDown();
					moveInProg= false;
				}
			}
		}
		
		if(!p.ballsActive()) {
			g.fillOval(mouseX, mouseY, 5, 5);
			
			//g.drawString(""+p.getAngle()+"", 100, 100);
			
			//g.drawString(""+playerToMouseDist+"", 100, 50);
			

			
		}
		

		
		
		
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				objects[row][col].paint(g);
				if(objects[row][col].getHp()<= 0 && objects[row][col].getClass().getName().equals("Block")) objects[row][col] = new Empty(row*100, col*100, 100, 100);
				if(objects[row][col].getClass().getName().contentEquals("Block")) { 
					objects[row][col].setX(col*100);
					objects[row][col].setY(row*100);
					for(int i = 0; i < p.getBalls().size(); i++) {
						///This will be removed later.
						//g.fillOval( (int)(Collidable.clamp( (float)(p.getBalls().get(i).getXpos())  ,  (float)(objects[row][col].getX())  ,  (float)(objects[row][col].getX()+objects[row][col].getWidth()))-p.getBalls().get(i).getRadius() ),
						//(int)(Collidable.clamp((float)(p.getBalls().get(i).getYpos())  ,(float)(objects[row][col].getY())  ,(float)(objects[row][col].getY()+objects[row][col].getHeight()))-p.getBalls().get(i).getRadius()),
						//p.getBalls().get(i).getRadius()*2, p.getBalls().get(i).getRadius()*2);
						
						switch(objects[row][col].collides(p.getBalls().get(i))) {
							case 0:
								break;
							case 1:
								p.getBalls().get(i).bounceY();
								objects[row][col].setHp(objects[row][col].getHp() -1);
								break;
							case 2: 
								p.getBalls().get(i).bounce();
								objects[row][col].setHp(objects[row][col].getHp() -1);
								break;
						}
					}
				}	
			}
		}
		
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				if(objects[row][col].getClass().getName().contentEquals("Powerup")) { 
					for(int i = 0; i < p.getBalls().size();i++) {
						objects[row][col].setX(col*100+37);
						objects[row][col].setY(row*100+37);
						//g.drawLine((int)(p.getBalls().get(i).getXpos()), (int)(p.getBalls().get(i).getYpos()), objects[row][col].getX()+objects[row][col].getHeight()/2, objects[row][col].getY()+objects[row][col].getHeight()/2);
						if(objects[row][col].collides(p.getBalls().get(i))==1) {
							objects[row][col] = new Empty(col*100, row*100, 100, 100);

							p.setNumballs(p.getNumballs()+1);
							break;
						}
					}
				}
			}
		}
			

		p.paint(g);
		
	}
	
	public void populateRow(int row, int h) {
		for(int i = 0; i < objects[row].length; i++) {
			if((int)(Math.random()*8) <= 3 ) {
				switch((int)(Math.random()*10)) {
					default:
						objects[row][i] = new Block( i*100, row*100, 100, 100, h);
						break;
					case 0:
						objects[row][i] = new Block( i*100, row*100, 100, 100, h*2);
				}
			}
			else { 
				if((int)(Math.random()*3)==0) {
					objects[row][i] = new Powerup(i*100+37, row*100+37, 16);
				}
			}
			System.out.println(objects[row][i].getClass().getName());
		} 
	}
	
	public void moveDown() {
		for(int row = objects.length-1; row >= 1; row--) {
			for(int col = 0; col < objects[row-1].length; col++) {
				if(objects[row-1][col].getClass().getName().contentEquals("Block")) {
					objects[row][col] = new Block(row*100,col*100,objects[row-1][col].getHeight(),objects[row-1][col].getWidth(), objects[row-1][col].getHp());
				}
				if(objects[row-1][col].getClass().getName().contentEquals("Powerup")) {
					objects[row][col] = new Powerup(col*100+37, row*100+37, 16);
				}
				if(objects[row-1][col].getClass().getName().contentEquals("Empty")) {
					objects[row][col] = new Empty(col*100, row*100, 100,100);
				}
				objects[row-1][col] = new Empty(col*100, row*100, 100,100);
			}
		}
		populateRow(1,Driver.round);
		
		for(int row = 0; row < objects.length; row++) {
			for(int col = 0; col < objects[0].length; col++) {
				System.out.print(objects[row][col].getClass().getName());
			}
			System.out.println(" ");
		}
	}

	public void addDebugBlock(int row, int col) {
		Collidable[] temp = new Collidable[objects[row].length];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = new Empty(i*100, row*100, 100, 100);
		}
		temp[col] = new Block(col*100, row*100, 100, 100, 1);
		objects[row] = temp;
	}
	
	public boolean gameOver() {
		boolean temp = false;
		for(int i = 0; i < objects[objects.length-1].length;i++) {
			if(objects[objects.length-1][i].getClass().getName().contentEquals("Block")||objects[objects.length-1][i].getClass().getName().contentEquals("Powerup") ) {
				temp = true;
			}
		}
		return temp;
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

	public boolean isMoveInProg() {
		return moveInProg;
	}

	public void setMoveInProg(boolean moveInProg) {
		this.moveInProg = moveInProg;
	}

}
	
