package textgame.game;

import textgame.entities.Player;
import textgame.items.Item;
import textgame.locations.*;

public class CommandParser {
	
	private Player player;
	private Game game;
	
	public CommandParser(Game game) {
		this.game = game;
		this.player = game.getPlayer();
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
