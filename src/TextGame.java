
public class TextGame {
	public static void main(String[] args) {
		Game game = new Game();

		Location hall = new Location("Hall", "You're in the hall");
		Location kitchen = new Location("Kitchen", "You're in the kitchen");
		
		hall.addExit(new Exit(Exit.NORTH, kitchen));
		kitchen.addExit(new Exit(Exit.SOUTH, hall));
		
		game.setLocation(hall);
		game.showLocation();
		game.gamePrompt();
	}
}
