package gui;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import gameEngine.GameEngine;
import gameObjects.Avian;
import gameObjects.GameObject;
import mapBuilder.MapLoader;

import java.awt.event.*;

/**
 * Class where that calls drawing methods and does other graphical calculations for the GameGui class.
 * Implements MouseListeners and the Runnable interfaces, MouseListener allows Game to recieve user
 * input from their mouse, and the Runnable interface allows for this class to run on a separate thread.
 * @author bryan
 *
 */
public class Game extends JPanel implements MouseListener, MouseMotionListener, Runnable{
    private DrawCanvas canvas;
    private int canvasWidth, canvasHeight;
    public Avian birb;
    double mouseX, mouseY, speed, angle;
    boolean mouseClickedAvian;
    Level level_used;
    private ArrayList<GameObject> gamestuff;
    private int clickedX;
    private int clickedY;
    private boolean dragBird;
    private int startingbirdX;
    private int startingbirdY;
    private boolean automode;
    /**
     * Constructor for the Game class. Takes in a width and a height which is used to define how
     * large the panel is.
     * @param width
     * @param height
     */
    public Game(int width, int height) {
    	Thread.currentThread().setName("GameDrawThread");
    	gamestuff = MapLoader.loadMap("Level_1");
    	dragBird = false;
    	automode = false;
        canvasHeight = height; 
        canvas = new DrawCanvas();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);
        level_used = new Level(0, 0, canvasWidth, canvasHeight, gamestuff);
        birb = (Avian)gamestuff.get(0);
        startingbirdX = (int) birb.getCenter().getX();
        startingbirdY = (int) birb.getCenter().getY();
    }
    /**
     * A private class that uses the paintComponent function to invoke Level's draw method.
     * Has logic to draw a guiding line that can be used to help the players during gameplay.
     * @author bryan
     *
     */
    public class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            level_used.draw(g);
            if (mouseClickedAvian) {
            	int mx = (int) birb.getCenter().getX();
            	int my = (int) birb.getCenter().getY();
                g.drawLine(mx, my, (int) mouseX, (int) mouseY); 
            }
        }
    }
    
    private boolean mouseAvianDetection(MouseEvent drag, Avian bird) {
    	System.out.println("Bird center" + bird.getCenter().getX() + " " + bird.getCenter().getY());
    	
    	boolean result = ((drag.getX() >= bird.getCenter().getX() - bird.radius && drag.getX() <= bird.getCenter().getX() + bird.radius)
    			&& (drag.getY() >= bird.getCenter().getY() - bird.radius && drag.getY() <= bird.getCenter().getY() + bird.radius));
    	return result;
    }
	@Override
	public void mouseDragged(MouseEvent event) {
        if (mouseAvianDetection(event, birb)) {
        	System.out.println("dragging");
            mouseClickedAvian = true;
        }

        if (mouseClickedAvian) {
            speed = ((birb.getX() - event.getX()) * (birb.getX() - event.getX()) + (birb.getY() - event.getY()) * (birb.getY() - event.getY())) * 0.0003;
            angle = Math.toDegrees(Math.atan2(birb.getX() - event.getX(), birb.getY() - event.getY())) - 90;
            System.out.println("Bird Speed: "+speed);
            System.out.println("Bird Angle: "+angle+"\n");
            mouseX = event.getX();
            mouseY = event.getY();
            mouseClickedAvian = true;
        }		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {	
	}
	@Override
	public void mouseClicked(MouseEvent e) {	
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
        if (mouseClickedAvian) {
            birb.setSpeedAndAngle(speed, angle);
            mouseClickedAvian = false;
            System.out.println("print start");
        }
        dragBird = false;
        automode = true;
        mouseClickedAvian = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(60);
				if(automode) {
					GameEngine.getEngine().runSimulation();
				}
				canvas.repaint();
				
			} catch (InterruptedException e) {
				e.printStackTrace();	}
					}
		}
	
	/**
	 * 
	 * @return Level this game uses
	 */
	public Level getLevel()
	{
		return level_used;
	}
}
