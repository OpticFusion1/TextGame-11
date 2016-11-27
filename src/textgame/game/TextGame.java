package textgame.game;

import textgame.entities.*;
import textgame.locations.*;

public final class TextGame {
	public static void main(String[] args) {
		try {
			Locations locations = LoadResources.loadLocations("resources/Locations.xml");
			Player player = new Player("tom");

			Game game = new Game(locations, player);

			game.setLocation(locations.get(0));
			game.showLocation();
			game.gamePrompt();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
