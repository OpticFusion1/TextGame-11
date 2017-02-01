package textgame.game;

import java.util.*;

import textgame.conversation.*;
import textgame.entities.*;
import textgame.items.*;
import textgame.locations.*;

public class Game {
	
	public enum State { PLAYER_ALIVE, WIN, QUIT };

	private Locations locations;
	private Player player;
	private State gameState;
	private CommandParser commandParser;
	private NPCs npcs;
	
	public Game(Locations locations, Player player) {
		this(locations, player, null);
	}

	public Game(Locations locations, Player player, NPCs npcs) {
		this.locations = locations;
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
	
	public void performAction(Entity subject, Entity object, Action action) {
		switch(action.getType()) {
			case ENTER:
				subject.setLocation(locations.get(action.getValue()));
				break;
			case GIVE:
				object.addItem(subject.removeItem(action.getValue()));
				break;
			case TAKE:
				subject.addItem(object.removeItem(action.getValue()));
				break;
			default:
				break;
		}
	}
}
