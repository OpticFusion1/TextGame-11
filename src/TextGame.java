import java.util.*;

public class TextGame {
	public static void main(String[] args) {
		try {
			Locations locations = LoadResources.loadLocations("resources/Locations.xml");
			
			Game game = new Game(locations);
			
			game.setLocation(locations.get(0));
			game.showLocation();
			game.gamePrompt();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
