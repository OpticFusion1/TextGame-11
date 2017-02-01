package textgame.game;

import java.util.*;

import textgame.conversation.ConversationManager;
import textgame.entities.*;
import textgame.items.*;
import textgame.locations.*;

public class Game {
	
	public enum State { PLAYER_ALIVE, WIN, QUIT };

	private List<Location> locations;
	private Player player;
	private State gameState;
	private CommandParser commandParser;
	private NPCs npcs;
	
	public Game(Locations locations, Player player) {
		this(locations, player, null);
	}

	public Game(Locations locations, Player player, NPCs npcs) {
		this.locations = locations.getAll();
		this.player = player;
		this.player.setLocation(locations.get(0));
		setGameState(State.PLAYER_ALIVE);
		this.commandParser = new CommandParser(this);
		this.npcs = (npcs == null ? new NPCs() : npcs);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}
	
	public NPCs getNPCs() {
		return npcs;
	}

	public void setNPCs(NPCs npcs) {
		this.npcs = npcs;
	}

	public void play() {
		ConversationManager convo = new ConversationManager(getNPCs().get("bouncer").getConversation());
		convo.converse();
		while(getGameState().equals(State.PLAYER_ALIVE)) {
			Outputter.write("Enter command (exit, item, [q]uit, [i]nventory or [l]ocation): ");
			String command = commandParser.getCommand();
			commandParser.parse(command);
		}
		Outputter.writeln("Exiting game");
	}
	
	public void sendCommand(String command) {
		commandParser.parse(command);
	}
}
