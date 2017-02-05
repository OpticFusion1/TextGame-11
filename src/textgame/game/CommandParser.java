package textgame.game;

import java.util.Scanner;

import textgame.conversation.ConversationManager;
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
		String command = in.next();
		return command;
	}

	public void parse(String command) {
		Location currentLocation = player.getLocation();
		if (command.equals("q")) {
			game.setGameState(Game.State.QUIT);
			return;
		}
		if (command.equals("i")) {
			player.showItems();
			return;
		}
		if (command.equals("l")) {
			currentLocation.show();
			return;
		}
		if(currentLocation.getExit(command) != null) {
			try {
				player.move(command);
			} catch (IllegalArgumentException e) {
				// TODO use proper commands e.g. 'go out' and catch invalid exits
			}
			return;
		}
		if(currentLocation.getNPC(command) != null) {
			player.converse(currentLocation.getNPC(command));
			return;
		}
		for (Item item : currentLocation.getItems()) {
			if (item.getId().equals(command)) {
				player.addItem(item);
				currentLocation.removeItem(item);
				Outputter.writeln("You picked up: " + item.getName());
				return;
			}
		}
	}
}
