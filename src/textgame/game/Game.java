package textgame.game;

import java.util.*;
import textgame.entities.*;
import textgame.items.*;
import textgame.locations.*;

public class Game {
	
	public enum State { PLAYER_ALIVE, WIN, QUIT };

	private List<Location> locations;
	private Player player;
	private State gameState;
	private CommandParser commandParser;

	public Game(Locations locations, Player player) {
		this.locations = locations.getAll();
		this.player = player;
		this.player.setLocation(locations.get(0));
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
	
	public void play() {
		Scanner in = new Scanner(System.in);
		while(getGameState().equals(State.PLAYER_ALIVE)) {
			Outputter.write("Enter command (exit, item, [q]uit, [i]nventory or [l]ocation): ");
			String command = in.next();
			commandParser.parse(command);
		}
		in.close();
		Outputter.writeln("Exiting game");
	}
	
	public void sendCommand(String command) {
		commandParser.parse(command);
	}
}
