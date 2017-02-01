package textgame.game;

import textgame.entities.*;
import textgame.loaders.LoadResources;
import textgame.locations.*;

public final class TextGame {
	public static void main(String[] args) {
		try {
			Locations locations = LoadResources.loadLocations("resources/Locations.xml");
			NPCs npcs = LoadResources.loadNPCs("resources/NPCs.json");

			Player player = new Player("tom");

			Game game = new Game(locations, player, npcs);

			game.play();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
