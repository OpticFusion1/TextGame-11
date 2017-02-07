package textgame.game;

import java.util.Scanner;

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
	public void parse(String command) {
		Location currentLocation = player.getLocation();
		Action action = null;
		Item item = null;
		
		if (command.equals("q")) {
			game.setGameState(Game.State.QUIT);
			return;
		}
		
		String[] words = command.split(" ");
		try {
			action = new Action(words[0], words[words.length - 1]);
		} catch (IllegalArgumentException e) {
			Outputter.writeln("Invalid command");
			return;
		}
		
		switch(action.getType()) {
		case SHOW:
			switch(action.getValue()) {
			case "items":
			case "inventory":
				player.showItems();
				break;
			case "location":
				currentLocation.show();
				break;
			case "commands":
			case "actions":
				Outputter.writeln("Valid commands are 'show', 'go', 'talk', 'inspect', 'give', 'take', 'pick'");
			}
			break;
		case GO:
			try {
				player.move(action.getValue());
				player.getLocation().show();
			} catch (IllegalArgumentException e) {
				Outputter.writeln("Exit not found");
			}
			break;
		case TALK:
			NPC person = currentLocation.getNPC(action.getValue());
			if(person == null) {
				Outputter.writeln("Person not found");
				return;
			}
			player.converse(person);
			break;
		case PICK:
		case TAKE:
			item = currentLocation.getItemById(action.getValue());
			if(item == null) {
				Outputter.writeln("Item not found");
				return;
			}
			player.addItem(item);
			currentLocation.removeItem(item);
			Outputter.writeln("You picked up: "+item.getName());
			break;
		case INSPECT:
			item = currentLocation.getItemById(action.getValue());
			Outputter.writeln(item.getDescription());
			break;
		case NONE:
		case GIVE:
			break;
		}
	}
}
