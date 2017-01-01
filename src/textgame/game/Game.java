package textgame.game;

import java.util.*;
import textgame.entities.*;
import textgame.items.*;
import textgame.locations.*;

public class Game {

	private Location currentLocation;
	private List<Location> locations;
	private Player player;
	String command;

	public Game() {
		currentLocation = null; /* TODO: replace this */
		player = null;
	}

	public Game(Locations locations, Player player) {
		currentLocation = null;
		this.locations = locations.getLocations();
		this.player = player;
	}

	public void setLocation(Location newLocation) {
		currentLocation = newLocation;
	}

	public void showLocation() {
		Outputter.writeln(currentLocation.getDescription());
		Outputter.writeln("========");
		Outputter.write("Available exits: ");
		for (Exit exit : currentLocation.getExits()) {
			Outputter.write(exit + " ");
		}
		Outputter.writeln("\n========");
		Outputter.write("Available items: ");
		for (Item item : currentLocation.getItems()) {
			Outputter.write(item + " ");
		}
		Outputter.writeln("\n========");
	}

	public void showInventory() {
		Outputter.write("Current inventory: ");
		for (Item item : player.getItems()) {
			Outputter.write(item + " ");
		}
		Outputter.writeln("\n");
	}

	public Player getPlayer() {
		return player;
	}

	public void gamePrompt() {
		boolean continuePrompt = true;
		Scanner in = new Scanner(System.in);
		while (continuePrompt) {
			Outputter.write("Enter command (exit, item, [q]uit, [i]nventory or [l]ocation): ");
			String command = in.next();
			if (command.equals("q")) {
				continuePrompt = false;
			}
			if (command.equals("i")) {
				showInventory();
			}
			if (command.equals("l")) {
				showLocation();
			}
			for (Exit exit : currentLocation.getExits()) {
				if (exit.getDirectionName().equals(command)) {
					this.setLocation(exit.getTo());
					this.showLocation();
					if (this.currentLocation.getId().equals("club")) {
						// End of game. Need a better mechanism
						continuePrompt = false;
					}
				}
			}
			for (Item item : currentLocation.getItems()) {
				if (item.getName().equals(command)) {
					player.addItem(item);
					currentLocation.removeItem(item);
					Outputter.writeln("You picked up: " + item.getName());
				}
			}
		}
		in.close();
		Outputter.writeln("Exiting game");
	}
}
