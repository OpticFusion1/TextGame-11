package textgame.locations;

import java.util.*;

import textgame.entities.NPC;
import textgame.game.Outputter;
import textgame.items.*;

public class Location {
	
	private String id;
	private String name;
	private String description;
	private List<Exit> exits;
	private List<Item> items;
	private List<NPC> npcs;

	public Location(String id, String name) {
		this.id = id;
		this.name = name;
		description = new String();
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
		npcs = new ArrayList<NPC>();
	}

	public Location(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		exits = new ArrayList<Exit>();
		items = new ArrayList<Item>();
		npcs = new ArrayList<NPC>();
	}
	
	public Location(String id, String name, String description, List<Exit> exits,
			List<Item> items, List<NPC> npcs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.exits = exits;
		this.items = items;
		this.npcs = npcs;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Exit getExit(String direction) {
		for(Exit exit : this.getExits()) {
			if(exit.getDirection().equals(direction)) {
				return exit;
			}
		}
		return null;
	}
	
	public List<Exit> getExits() {
		return this.exits;
	}

	public void setExits(List<Exit> exits) {
		this.exits = exits;
	}

	public void addExit(Exit exit) {
		this.exits.add(exit);
	}

	public void removeExit(Exit exit) {
		if (this.exits.contains(exit)) {
			this.exits.remove(exit);
		}
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setItem(Item item) {
		this.items.add(item);
	}
	
	public Item getItem(Item item) {
		return getItem(item.getName());
	}

	public Item getItem(String itemName) {
		for (Item item : this.items) {
			if (item.getName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}
	
	public Item getItemById(String id) {
		for (Item item : this.items) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
	
	public void removeItem(Item item) {
		if (items.contains(item)) {
			items.remove(item);
		}
	}

	public List<NPC> getNPCs() {
		return this.npcs;
	}
	
	public NPC getNPC(String id) {
		for(NPC npc : getNPCs()) {
			if(npc.getId().equals(id)) {
				return npc;
			}
		}
		return null;
	}

	public void setNPCs(List<NPC> npcs) {
		this.npcs = npcs;
	}

	public String toString() {
		return this.name;
	}
	
	public void show() {
		Outputter.writeln(getDescription());
		if(getExits() != null) {
			Outputter.write("Available exits: ");
			for (Exit exit : getExits()) {
				Outputter.write(exit + " ");
			}
		}
		Outputter.write("\n");
		if(getItems() != null && getItems().size() > 0) {
			Outputter.write("Available items: ");
			for (Item item : getItems()) {
				Outputter.write(item + " ");
			}
			Outputter.write("\n");
		}
		if(getNPCs() != null && getNPCs().size() > 0) {
			Outputter.write("Available NPCs: ");
			for (NPC npc : getNPCs()) {
				Outputter.write(npc + " ");
			}
			Outputter.write("\n");
		}
	}
}
