import java.util.*;

public class TextGame {
	public static void main(String[] args) {
		try {
			Locations locations = LoadResources.loadLocations("resources/Locations.xml");
			//Locations locations = new Locations(importLocations);
			//List<Exit> exits = LoadResources.loadExits("resources/Exits.xml");
			//locations.addExits(exits);
			
			/* TODO - http://stackoverflow.com/questions/5319024/using-jaxb-to-cross-reference-xmlids-from-two-xml-files */
						
			Game game = new Game(locations);
			
			/*locations.get(0).addExit(new Exit(Exit.NORTH, locations.get(1)));
			locations.get(1).addExit(new Exit(Exit.SOUTH, locations.get(0)));*/
			
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
