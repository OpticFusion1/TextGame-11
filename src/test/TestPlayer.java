package test;
import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

import junit.framework.TestCase;
import textgame.entities.Player;
import textgame.game.Game;
import textgame.game.LoadResources;
import textgame.items.*;
import textgame.locations.Locations;

public class TestPlayer extends TestCase {

	private Locations locations = null;
	private Player player = null;
	
	@Before
	public void setUp() {
		try {
			locations = LoadResources.loadLocations("resources/Locations.xml");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		player = new Player("tom");
	}
	
	@Test
	public void testPlayerIsInitialisedWithName() {
		assertEquals("tom", player.getName());
	}
	
	@Test
	public void testPlayerIsInitialisedWithNoItems() {
		assertTrue(player.getItems().equals(new ArrayList<Item>()));
	}
	
	@Test
	public void testCanAddItemToPlayer() {
		Item testItem = new Item("testItem");
		player.addItem(testItem);
		assertEquals(player.getItem(testItem), testItem);
	}
	
	@Test
	public void testCanRemoveItemFromPlayer() {
		Item testItem = new Item("testItem");
		player.addItem(testItem);
		player.removeItem(testItem);
		assertTrue(player.getItems().equals(new ArrayList<Item>()));
	}
	
	@Test
	public void testIgnoresRemovingNonExistentItem() {
		Item testItem = new Item("fake!");
		player.removeItem(testItem);
		assertTrue(player.getItems().equals(new ArrayList<Item>()));
	}
	
	@Test
	public void testPlayerCanChangeLocation() {
		player.setLocation(locations.get(1));
		assertEquals(player.getLocation(), locations.get(1));
	}

}
