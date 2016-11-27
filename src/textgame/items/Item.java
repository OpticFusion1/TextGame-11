package textgame.items;

import javax.xml.bind.annotation.*;
import textgame.game.Outputter;

public class Item {
	private String id;
	private String type;
	private String name;
	private String description;

	public Item() {
		id = null;
		type = null;
		name = null;
		description = null;
	}

	public Item(String id, String type, String name, String description) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	@XmlID
	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	@XmlElement
	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Item) {
			Item i = (Item) obj;
			return name.equals(i.name);
		}
		return false;
	}

	public void display() {
		Outputter.writeln(name + ": " + description);
	}

	public String toString() {
		return name;
	}
}
