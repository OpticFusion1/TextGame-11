import java.util.*;

public class Game {
	
	private Location currentLocation;
	String command;
	
	public Game()
	{		
		currentLocation = null; /* replace this */
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
					this.setLocation(exit.getLeadsTo());
					this.showLocation();
				}
			}
		}
		in.close();
		System.out.println("Exiting game");
	}
}
