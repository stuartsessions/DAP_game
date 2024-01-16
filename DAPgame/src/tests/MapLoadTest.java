package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import gameObjects.GameObject;
import mapBuilder.MapLoader;
import mapBuilder.MapSaver;

class MapLoadTest {

	@Test
	void test() {
		String mapId = "mappers";
		GameObject obj1 = new GameObject(10,10,10,10, 10);
		GameObject obj2 = new GameObject(50,40,50,50,10);
		obj2.setVelocity(20,20);
		
		GameObject obj3 = new GameObject(100,200,100,100, 20);
		obj3.setVelocity(400,500);
		obj3.setHP(1000000);
		
		ArrayList<GameObject> testSet = new ArrayList<>();
		
		ArrayList<GameObject> testAgainst = new ArrayList<>();
		
		testSet.add(obj1);
		testSet.add(obj2);
		testSet.add(obj3);

		testAgainst = MapLoader.loadMap(mapId);
		assertEquals(obj1.getHP(), testAgainst.get(0).getHP());
		assertEquals(obj2.getHP(), testAgainst.get(1).getHP());
		assertEquals(obj3.getHP(), testAgainst.get(2).getHP());
		
		
		
	}

}
