package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import gameObjects.GameObject;
import mapBuilder.MapLoader;
import mapBuilder.MapSaver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class MapSaveTest {
	//tests map Saving functionality

	@Test
	void test() {
		String mapId = "mappers";
		GameObject obj1 = new GameObject(10,10,10,10,10);
		GameObject obj2 = new GameObject(50,40,50,50,10);
		obj2.setVelocity(20,20);
		
		GameObject obj3 = new GameObject(100,200,100,100,10);
		obj3.setVelocity(400,500);
		obj3.setHP(1000000);
		
		ArrayList<GameObject> testSet = new ArrayList<>();
		
		ArrayList<GameObject> twoTime = new ArrayList<>();
		
		testSet.add(obj1);
		testSet.add(obj2);
		testSet.add(obj3);
		
		MapSaver.saveMap(mapId, testSet);
		
		twoTime = MapLoader.loadMap(mapId);
		MapSaver.saveMap("secondOne", twoTime);
		File map1 = new File("mapFolder", mapId + ".mlv");
		assertEquals(true, map1.exists());
		
		//fail("Not yet implemented");
	}
	
//	
	

}
