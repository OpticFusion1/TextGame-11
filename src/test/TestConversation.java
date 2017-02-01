package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import junit.framework.TestCase;
import textgame.conversation.Conversation;
import textgame.conversation.ConversationManager;
import textgame.conversation.Line;
import textgame.conversation.Response;
import textgame.entities.NPC;
import textgame.entities.NPCs;
import textgame.entities.Player;
import textgame.game.Game;
import textgame.loaders.LoadResources;
import textgame.locations.Locations;

public class TestConversation extends TestCase {
	
	private Locations locations;
	private Game game;
	private Player player;
	private NPCs npcs;
	private NPC bouncer;
	private ConversationManager convoManager;
	
	@Before
	public void setUp() {
		locations = LoadResources.loadLocations("resources/Locations.xml");
		npcs = LoadResources.loadNPCs("resources/NPCs.json");
		player = new Player("tom");
		game = new Game(locations, player, npcs);
		bouncer = npcs.get("bouncer");
		convoManager = new ConversationManager(bouncer.getConversation());
	}
	
	@Test
	public void testBouncerHasConversation() {
		assertNotNull(bouncer.getConversation());
	}
	
	@Test
	public void testCanCreateConversationManager() {
		assertNotNull(convoManager);
		assertEquals(convoManager.getCurrentLineIndex(), 0);
	}
	
	@Test
	public void testCanSetCurrentLineIndex() {
		convoManager.setCurrentLineIndex(2);
		assertEquals(convoManager.getCurrentLineIndex(), 2);
	}
	
	@Test
	public void testCanGetCurrentLine() {
		Line currentLine = convoManager.getCurrentLine();
		assertEquals(currentLine.getText(), "No, you can't get into the club. You need to have the badge!");
	}
	
	@Test
	public void testReturnsCorrectNumberOfResponses() {
		List<Response> responses = convoManager.getCurrentLine().getResponses();
		assertEquals(responses.size(), 3);
	}
}
