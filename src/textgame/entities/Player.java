package textgame.entities;

import java.util.Map;

import textgame.conversation.ConversationManager;
import textgame.locations.Exit;
import textgame.locations.Location;

public class Player extends Entity {
	
	private Map<String, Location> locations;
	
	public Player() {
		super();
		this.locations = null;
	}
	
	public Player(String name, Map<String, Location> locations) {
		super("player", name);
		this.locations = locations;
	}
	
	public void converse(NPC person) {
		ConversationManager convo = new ConversationManager(this, person);
		convo.converse();
	}
	
	public void move(String direction) throws IllegalArgumentException {
		Location currentLocation = this.getLocation();
		Exit exit = currentLocation.getExit(direction);
		if(exit == null) { throw new IllegalArgumentException(direction); }
		this.setLocation(locations.get(exit.getTo()));
	}
}
