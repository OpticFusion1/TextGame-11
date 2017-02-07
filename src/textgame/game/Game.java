package textgame.game;

import java.util.*;

import textgame.actions.Action;
import textgame.conversation.*;
import textgame.entities.*;
import textgame.locations.*;

public class Game {
	
	public enum State { PLAYER_ALIVE, WIN, QUIT };

	private Map<String, Location> locations;
	private Player player;
	private State gameState;
	private CommandParser commandParser;

	public Game(Map<String, Location> locations, Player player) {
		this.locations = locations;
		this.player = player;
		this.player.setLocation(locations.get("apartment"));
		setGameState(State.PLAYER_ALIVE);
		this.commandParser = new CommandParser(this);
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

	public Map<String, Location> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, Location> locations) {
		this.locations = locations;
	}

	public void play() {
		player.getLocation().show();
		while(getGameState().equals(State.PLAYER_ALIVE)) {
			Outputter.write("> ");
			String command = commandParser.getCommand();
			Action action = commandParser.parse(command);
			if(action != null) {
				player.perform(action);
			}
		}
		Outputter.writeln("Exiting game");
	}
	
	public void sendCommand(String command) {
		commandParser.parse(command);
	}
}
