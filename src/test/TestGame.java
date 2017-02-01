package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;
import java.util.Map.Entry;

import junit.framework.TestCase;
import textgame.conversation.Conversation;
import textgame.conversation.Line;
import textgame.entities.*;
import textgame.game.Game;
import textgame.loaders.LoadResources;
import textgame.locations.Locations;

public class TestGame extends TestCase {
	
	private Locations locations = null;
	private Game game = null;
	private Player player = null;
	private NPCs npcs = null;
	
	@Before
	public void setUp() {
		locations = LoadResources.loadLocations("resources/Locations.xml");
		npcs = LoadResources.loadNPCs("resources/NPCs.json");
		player = new Player("tom");
		game = new Game(locations, player, npcs);
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
	
	@Test
	public void testNPCsAreNotNull() {
		HashMap<String, NPC> npcs = game.getNPCs().getAll();
		assertNotNull(npcs);
		for(Entry<String, NPC> entry : npcs.entrySet()) {
			assertNotNull(entry.getValue());
		}
	}
	
	@Test
	public void testNPCsHaveConversations() {
		HashMap<String, NPC> npcs = game.getNPCs().getAll();
		for(Entry<String, NPC> entry : npcs.entrySet()) {
			Conversation conversation = entry.getValue().getConversation();
			assertNotNull(conversation);
			List<Line> lines = conversation.getLines();
			for(Line line : lines) {
				assertNotNull(line);
			}
		}
	}
	
	@After
	public void tearDowm() {
		game = null;
	}
}
