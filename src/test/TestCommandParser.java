package test;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.TestCase;

import textgame.entities.Player;
import textgame.game.Game;
import textgame.game.LoadResources;
import textgame.locations.Locations;

public class TestCommandParser extends TestCase {

	private Locations locations = null;
	private Game game = null;
	private Player player = null;
	
	@Override
	public void setUp() {
		try {
			locations = LoadResources.loadLocations("resources/Locations.xml");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		player = new Player("tom");
		game = new Game(locations, player);
	}
	
	public void testQSetsGameToQuit() {
		game.sendCommand("q");
		assertEquals(game.getGameState(), Game.State.QUIT);
	}
	
	public void testEnteringALocationChangesPlayerLocation() {
		game.sendCommand("out");
		assertEquals(game.getPlayer().getLocation(), locations.get(1));
	}
	
	public void testPlayerCanPickUpItem() {
		game.sendCommand("badge");
		assertNotNull(game.getPlayer().getItem("badge"));
		assertNull(game.getPlayer().getLocation().getItem("badge"));
	}
}
