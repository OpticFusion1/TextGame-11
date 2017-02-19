package textgame.game;

import java.util.Map;

import textgame.entities.*;
import textgame.loaders.LoadResources;
import textgame.locations.*;

public final class TextGame {
	public static void main(String[] args) {
		try {
			Map<String, Location> locations = LoadResources.load("resources/locations.json");
			Player player = new Player("tom");

			Game game = new Game(locations, player);
			try {
				game.connectExits();
			} catch(IllegalStateException e) {
				Outputter.writeln("Error in JSON input file: specified exits are not valid. Aborting.");
				return;
			}

			game.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
