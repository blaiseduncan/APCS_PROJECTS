import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.color.*;


public class Block extends Collidable {
	private int hp;
	private String hpString;
	Font font = new Font("Courier", Font.BOLD,12);
	public Block(int x, int y, int height, int width,int hp) {
		super(x, y, height, width);
		this.hp= hp;
		this.hpString = String.valueOf(hp);
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}



	public void paint(Graphics g) {
		g.setFont(font);
		g.setColor(new Color(Math.abs(hp),Math.abs(hp),Math.abs(hp)));
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawString(hpString, x+width/2-25, y+height/2);
		hpString = String.valueOf(hp);
	}
}
