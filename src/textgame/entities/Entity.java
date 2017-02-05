package textgame.entities;

import java.util.*;
import textgame.locations.*;
import textgame.game.Outputter;
import textgame.items.*;

// Superclass for all entities (player, NPCs)
public abstract class Entity {

	private String id;
	private String name;
	private Location location = null;
	private List<Item> items;

	public Entity() {
		this(null, null);
	}

	public Entity(String id, String name) {
		this.id = id;
		this.name = name;
		this.items = new ArrayList<Item>();
	}
	
	public Entity(String id, String name, List<Item> items) {
		this.id = id;
		this.name = name;
		this.items = items;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return (List<Item>) ((ArrayList<Item>) items).clone();
	}

	public Item getItem(Item item) {
		return getItem(item.getName());
	}

	public Item getItem(String itemName) {
		for (Item item : items) {
			if (item.getName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}

	public Item removeItem(Item item) {
		Item itemToRemove = getItem(item);
		if (itemToRemove != null) {
			items.remove(itemToRemove);
		}
		return itemToRemove;
	}
	
	public Item removeItem(String itemName) {
		return removeItem(getItem(itemName));
	}
	
	public void showItems() {
		Outputter.write("Current inventory: ");
		for (Item item : getItems()) {
			Outputter.write(item + " ");
		}
		Outputter.writeln("\n");
	}
}
