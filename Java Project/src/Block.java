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
		this.hp= new Integer(hp);
		this.hpString = String.valueOf(hp);
	}
	
	
	
	public void paint(Graphics g) {
		g.setFont(font);
		g.setColor(new Color(hp,hp,hp));
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		g.drawString(hpString, x+width/2-25, y+height/2);
	}
}
