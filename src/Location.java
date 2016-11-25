import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Location
{
	private String id;
	
	private String name;
	private String description;
	private ArrayList<Exit> exits;
	private ArrayList<Item> items;
	
	// Blank constructor
	public Location()
	{
		// Blanks by default
		id = new String();
		name = new String();
		description = new String();
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	// Partial constructor
	public Location(String id, String locationName)
	{
		this.id = id;
		name = locationName;
		description = new String();
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	// Full constructor
	public Location(String id, String locationName, String locationDesc)
	{
		this.id = id;
		name = locationName;
		description = locationDesc;
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
	}
	
	public String toString()
	{
		return name;
	}
	
	@XmlElement(name="exit")
	public void setExit(Exit exit)
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
	
	@XmlElement(name="item")
	public void setItem(Item item)
	{
		items.add(item);
	}
	
	public void removeItem(Item item)
	{
		if(items.contains(item))
		{
			items.remove(item);
		}
	}
	
	public List<Item> getItems()
	{
		return (ArrayList<Item>) items.clone();
	}
	
	public String getName()
	{
		return name;
	}
	
	@XmlElement
	public void setName(String locationName)
	{
		name = locationName;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	@XmlElement
	public void setDescription(String locationDesc)
	{
		description = locationDesc;
	}
	
	public String getId()
	{
		return id;
	}
	
	@XmlID
	@XmlAttribute
	public void setId(String newId)
	{
		id = newId;
	}
}
