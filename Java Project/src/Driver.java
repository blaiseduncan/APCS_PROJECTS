import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Driver extends JPanel implements ActionListener, KeyListener,
		MouseListener, MouseMotionListener {
	
	public static int screen_width = 725;
	public static int screen_height = 850;
	Board b = new Board(720,960);
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 700, 800);
		b.paint(g);
	}


	public void update() {
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}
	

	
	
	public Driver() {

		//b.populateRow(1,1);
		b.addDebugBlock(1, 3);
		JFrame f = new JFrame();
		f.setTitle("bollocks");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		//driver is responsible for setting up attributes
		// player.addMouseListener(this);
		// bg = new Background("background.png");
		// do not add to frame, call paint on
		// these objects in paint method

		f.add(this);
		t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}

	Timer t;
	
	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode()==82);

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!b.getP().allBallsMoving()) {
			for(int i = 0; i < b.getP().getBalls().size();i++) {
				b.getP().getBalls().get(i).setMoving(true);
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	public void reset() {

	}

	boolean on = false;
	@Override
	public void mousePressed(MouseEvent e) {
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//s.setFireCount(s.getRate());
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {

	}

	@Override
	public void mouseMoved(MouseEvent m) {
		//this method is triggered anytime there is
		//mouse movement on the frame
		b.setMouseX(m.getX()-10);
		b.setMouseY(m.getY()-33);

		
	}

}
