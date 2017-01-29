package test;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import textgame.entities.Player;
import textgame.game.Game;
import textgame.game.LoadResources;
import textgame.locations.Locations;

public class TestGame extends TestCase {
	
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
	
	@Test
	public void testGameInitialisesPlayerToFirstLocation() {		
		assertEquals(player.getLocation(), locations.get(0));
	}

	@Test
	public void testGameStartsAtPlayerAliveState() {
		assertEquals(game.getGameState(), Game.State.PLAYER_ALIVE);
	}
	
	@Test
	public void testSetGameStateChangesTheState() {
		game.setGameState(Game.State.WIN);
		assertEquals(game.getGameState(), Game.State.WIN);
	}
}
