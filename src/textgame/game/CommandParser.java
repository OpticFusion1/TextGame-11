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
		NPC npc = game.getNPCs().get(command);
		if (npc != null) {
			ConversationManager convo = new ConversationManager(game, npc);
			convo.converse();
			return;
		}
		for (Exit exit : currentLocation.getExits()) {
			if (exit.getDirectionName().equals(command)) {
				player.setLocation(exit.getTo());
				player.getLocation().show();
				return;
			}
		}
		for (Item item : currentLocation.getItems()) {
			if (item.getName().equals(command)) {
				player.addItem(item);
				currentLocation.removeItem(item);
				Outputter.writeln("You picked up: " + item.getName());
				return;
			}
		}
	}
}
