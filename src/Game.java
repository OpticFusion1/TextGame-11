import java.util.*;

public class Game {
	
	private Location currentLocation;
	private List<Location> locations;
	String command;
	
	public Game()
	{		
		currentLocation = null; /* replace this */
	}
	
	public Game(Locations locations)
	{
		currentLocation = null;
		this.locations = locations.getLocations();
	}
	
	public void setLocation(Location newLocation)
	{
		currentLocation = newLocation;
	}
	
	public void showLocation()
	{
		System.out.println(currentLocation.getDescription());
		System.out.println("Available exits");
		for(Exit exit : currentLocation.getExits())
		{
			System.out.println(exit);
		}
	}
	
	
	
	public void gamePrompt()
	{
		boolean continuePrompt = true;
		Scanner in = new Scanner(System.in);
		while(continuePrompt)
		{
			/* TODO - prefer not to use System.out directly */
			System.out.print("Enter command: ");
			String command = in.next();
			if(command.equals("q"))
			{
				continuePrompt = false;
			}
			for(Exit exit : currentLocation.getExits())
			{
				if(exit.getDirectionName().equals(command))
				{
					this.setLocation(exit.getTo());
					this.showLocation();
				}
			}
		}
		in.close();
		System.out.println("Exiting game");
	}
}
