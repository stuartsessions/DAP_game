# The RAMones Project 2
==== README ====
src folder contains the packages gameEngine, gameObjects, gameSave, gui, mapBuilder, physicsEngine
Other folders include mapFolder and sprites.

This build contains design patterns such as singletons, chain of responsibility, observer, 
and command design patterns within the packages.


# Design patterns

GameEngine - Singleton utilized through the GUI
to keep a single object instance to be shared throughout the file
Chain of Responsibility - the GUI is designed around a Chain of Responsibilty
design pattern in order to keep actions and logic contained within subclasses
Observer - physicsEngine is designed as an Observer to notify all gameObjects
to update their positions
Command - physicsEngine is also designed as around a comman design pattern
in order to handle requests and actions effectively.


# Compilation

Verify that all files are present (See Files Expected Below)
Running GameMaker within the GameEngine package will compile the program
and build it. Make sure the mapFolder is outside of src and present in the
build for the game to load correctly


# Files Expected

GameEngine - Package that handles game running logic
	-GameEngine.java 					- Handles logic for running the game
	-GameMaker.java 				      	- Main method, compiles game

gameObjects - Package that handles game objects
	-Avian.java 				     		- Avian class for the program
	-GameObject.java 					- Class for GameObject
	-Position.java 				     		- Class that handles position logic
	-Velocity.java						- Class that handles velocity logic
	
gameSave - Package that handles saving
	-GameLoad.java 				      		- Loads in game
	-GameSave.java			    			- Saves Game
	
gui - Package that handles the interface
	-Game.java 			    			- Handles displaying of game
	-GameGui.java 			 			- Creates game display
	-Level.java 				      		- Displays gameObjects in Game
	-LoadPrompt.java 				   	- Reads in player's load file
	-SavePrompt.java 			    		- Saves player's file
	-StartMenu.java 				    	- Initiates GUI interface user interacts with
	
mapBuilder - Package that handles mapLoading
	-MapLoader.java 		  			- Handles map loading logic
	-MapSaver.java 				    		- Handles map saving logic
	
physicsEngine - Package that handles physics logic
	-ActionQueue.java 					- Handles queuing of Actions
	-ObjectUpdate.java					- Updates object fields
	-PhysicsEngine.java					- Handles Physics logic
	-PositionUpdater.java				      	- Updates Object's position
	-VelocityUpdater.java 					- Updates Object's velocity
