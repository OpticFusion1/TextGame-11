package textgame.entities;

import textgame.actions.Action;
import textgame.conditions.Condition;
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
	
	public Boolean meetsCondition(Condition cond) {
		switch(cond.getType()) {
		case HAS:
			return getItem(cond.getValue()) != null;
		default:
			return false;
		}
	}
	
	public void perform(Action action) {
		/* TODO - create subtypes of actions rather than massive switch */
		Location currentLocation = getLocation();
		Item item = null;
		NPC person = null;
		
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
			person = currentLocation.getNPC(action.getValue());
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
		case RECEIVE:
			person = currentLocation.getNPC(action.getFrom());
			item = person.getItem(action.getValue());
			addItem(item);
			person.removeItem(item);
			Outputter.writeln(person.toString() + " gave you " + item.toString());
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
