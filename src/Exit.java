
public class Exit {
	
	// Numerical codes
	public static final int UNDEFINED = 0;
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = 3;
	public static final int WEST = 4;
	public static final int UP = 5;
	public static final int DOWN = 6;
	public static final int IN = 7;
	public static final int OUT = 8;
	
	// String codes
	public static final String[] dirName = {
		"undefined",
		"north",
		"east",
		"south",
		"west",
		"up",
		"down",
		"in",
		"out"
	};
	
	private Location leadsTo = null;
	private int direction;
	private String directionName;
	
	// Default constructor
	public Exit()
	{
		direction = Exit.UNDEFINED;
		leadsTo = null;
		directionName = dirName[UNDEFINED];
	}
	
	// Full constructor
	public Exit(int exitDirection, Location exitLeadsTo)
	{
		direction = exitDirection;
		if(exitDirection <= dirName.length)
		{
			directionName = dirName[direction];
		}
		leadsTo = exitLeadsTo;
	}
	
	public String toString()
	{
		return directionName;
	}
	
	public void setDirectionName(String exitDirectionName)
	{
		directionName = exitDirectionName;
	}
	
	public String getDirectionName()
	{
		return directionName;
	}
	
	public void setLeadsTo(Location exitLeadsTo)
	{
		leadsTo = exitLeadsTo;
	}
	
	public Location getLeadsTo()
	{
		return leadsTo;
	}
}
