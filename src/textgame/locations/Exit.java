package textgame.locations;
import javax.xml.bind.annotation.*;

@XmlRootElement
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
	
	private Location to = null;
	private Location from = null;
	
	private int direction;
	private String directionName;
	
	// Default constructor
	public Exit()
	{
		direction = Exit.UNDEFINED;
		to = null;
		from = null;
		directionName = dirName[UNDEFINED];
	}
	
	// Full constructor
	public Exit(int exitDirection, Location exitLeadsFrom, Location exitLeadsTo)
	{
		direction = exitDirection;
		if(exitDirection <= dirName.length)
		{
			directionName = dirName[direction];
		}
		to = exitLeadsTo;
		from = exitLeadsFrom;
	}
	
	public String toString()
	{
		return directionName;
	}
	
	@XmlElement
	public void setDirection(int direction)
	{
		this.direction = direction;
		if(direction <= dirName.length)
		{
			directionName = dirName[direction];
		}
	}
	public void setDirectionName(String exitDirectionName)
	{
		directionName = exitDirectionName;
	}
	
	public String getDirectionName()
	{
		return directionName;
	}
	
	@XmlIDREF
	@XmlElement
	public void setTo(Location exitTo)
	{
		to = exitTo;
	}
	
	public Location getTo()
	{
		return to;
	}
	
	@XmlIDREF
	@XmlElement
	public void setFrom(Location exitFrom)
	{
		from = exitFrom;
	}
	
	public Location getFrom()
	{
		return from;
	}
}
