package textgame.game;

import java.util.Map;

import textgame.entities.*;
import textgame.loaders.LoadResources;
import textgame.locations.*;

public final class TextGame {
	public static void main(String[] args) {
		try {
			Map<String, Location> locations = LoadResources.load("resources/locations.json");
			Player player = new Player("tom", locations);

			Game game = new Game(locations, player);

			game.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
