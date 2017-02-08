package textgame.entities;

import textgame.actions.Action;
import textgame.conversation.ConversationManager;
import textgame.game.Outputter;
import textgame.items.Item;
import textgame.locations.Exit;
import textgame.locations.Location;

public class Player extends Entity {
	
	public Player() {
		super();
	}
	
	public Player(String name) {
		super("player", name);
	}
	
	public void converse(NPC person) {
		ConversationManager convo = new ConversationManager(this, person);
		convo.converse();
	}
	
	public void move(String direction) throws IllegalArgumentException {
		Location currentLocation = this.getLocation();
		Exit exit = currentLocation.getExit(direction);
		if(exit == null) { throw new IllegalArgumentException(direction); }
		this.setLocation(exit.getTo());
	}
	
	public void perform(Action action) {
		/* TODO - create subtypes of actions rather than massive switch */
		Location currentLocation = getLocation();
		Item item = null;
		
		switch(action.getType()) {
		case SHOW:
			switch(action.getValue()) {
			case "items":
			case "inventory":
				showItems();
				break;
			case "location":
				currentLocation.show();
				break;
			case "commands":
			case "actions":
				Outputter.showValidCommands();
			default:
				Outputter.writeln("Did not understand: " + action.getValue());
			}
			break;
		case GO:
			try {
				move(action.getValue());
				getLocation().show();
			} catch (IllegalArgumentException e) {
				Outputter.writeln("Did not understand: " + action.getValue());
			}
			break;
		case TALK:
			NPC person = currentLocation.getNPC(action.getValue());
			if(person == null) {
				Outputter.writeln("Did not understand: " + action.getValue());
				return;
			}
			converse(person);
			break;
		case PICK:
		case TAKE:
			item = currentLocation.getItemById(action.getValue());
			if(item == null) {
				Outputter.writeln("Item not found");
				return;
			}
			addItem(item);
			currentLocation.removeItem(item);
			Outputter.writeln("You picked up: "+item.getName());
			break;
		case INSPECT:
			item = currentLocation.getItemById(action.getValue());
			Outputter.writeln(item.getDescription());
			break;
		case NONE:
			break;
		}
	}
}
