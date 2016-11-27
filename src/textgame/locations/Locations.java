package textgame.locations;
import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Locations {
	private List<Location> locations;
	
	public Locations()
	{
		this.locations = new ArrayList<Location>();
	}
	
	public Locations(List<Location> locations)
	{
		this.locations = locations;
	}
	
	public String toString()
	{
		String info = "";
		for(Location location : getLocations())
		{
			info += location;
		}
		return info;
	}
	
	public List<Location> getLocations()
	{
		return this.locations;
	}
	
	public Location get(int index)
	{
		return this.locations.get(index);
	}
	
	public Location get(String id)
	{
		for(Location location : getLocations())
		{
			if(location.getId().equals(id))
			{
				return location;
			}
		}
		return null;
	}
	
	@XmlElement
	public void setLocation(Location location)
	{
		this.locations.add(location);
	}
}
