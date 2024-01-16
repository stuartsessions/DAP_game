package gameEngine;

import java.awt.Rectangle;

/**
 * The main Class to run the DAP program
 * @author stuartsessions
 *
 */
public class GameMaker 
{
	/**
	 * Main Method to instantiate the GameEngine.
	 * @param args
	 */
	public static void main(String[] args)
	{
		GameEngine engine = GameEngine.getEngine();
		
		Rectangle rect = new Rectangle();
		engine.startGame();
	}
}
