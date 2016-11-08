import java.util.*;

public class Location
{
	//private String id;
	private String name;
	private String description;
	private ArrayList<Exit> exits;
	
	// Blank constructor
	public Location()
	{
		// Blanks by default
		//id = new String();
		name = new String();
		description = new String();
		exits = new ArrayList<Exit>();
	}
	
	// Partial constructor
	public Location(String locationName)
	{
		name = locationName;
		description = new String();
		exits = new ArrayList<Exit>();
	}
	
	// Full constructor
	public Location(String locationName, String locationDesc)
	{
		name = locationName;
		description = locationDesc;
		exits = new ArrayList<Exit>();
	}
	
	public String toString()
	{
		return name;
	}
	
	public void addExit(Exit exit)
	{
		exits.add(exit);
	}
	
	public void removeExit(Exit exit)
	{
		if(exits.contains(exit))
		{
			exits.remove(exit);
		}
	}
	
	public List<Exit> getExits()
	{
		return (ArrayList<Exit>) exits.clone();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String locationName)
	{
		name = locationName;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String locationDesc)
	{
		description = locationDesc;
	}
}
