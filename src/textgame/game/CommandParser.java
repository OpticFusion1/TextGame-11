package textgame.game;

import java.util.Scanner;

import textgame.actions.Action;
import textgame.entities.NPC;
import textgame.entities.Player;
import textgame.items.Item;
import textgame.locations.*;

public class CommandParser {
	
	private Player player;
	private Game game;
	private Scanner in = new Scanner(System.in);

	public CommandParser(Game game) {
		this.game = game;
		this.player = game.getPlayer();
	}

	public String getCommand() {
		String command = in.nextLine();
		return command;
	}

	/* Expects command to be in 'verb noun' format or 'q' to quit
	 * Only first and last words are significant so e.g. 'talk to the person'
	 * is interpreted as 'talk person'
	 */
	public Action parse(String command) {
		Action action = null;
		
		if (command.equals("q")) {
			game.setGameState(Game.State.QUIT);
			return action;
		}
		
		String[] words = command.split(" ");
		try {
			action = new Action(words[0], words[words.length - 1]);
		} catch (IllegalArgumentException e) {
			Outputter.writeln("Invalid command");
		}
		return action;
	}
}
