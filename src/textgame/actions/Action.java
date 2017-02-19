package textgame.actions;

import java.util.HashMap;
import java.util.Map;

import textgame.entities.NPC;
import textgame.entities.Player;
import textgame.game.Outputter;
import textgame.items.Item;
import textgame.locations.Location;

public class Action {
	
	public enum ActionType { NONE, GO, SHOW, TAKE, PICK, INSPECT, TALK, RECEIVE }
	private String value;
	private String type;
	private String from;
    private static Map<String, ActionType> ACTION_MAP = new HashMap<String, ActionType>();

    static {
        ACTION_MAP.put("none", ActionType.NONE);
        ACTION_MAP.put("go", ActionType.GO);
        ACTION_MAP.put("show", ActionType.SHOW);
        ACTION_MAP.put("take", ActionType.TAKE);
        ACTION_MAP.put("pick", ActionType.PICK);
        ACTION_MAP.put("inspect", ActionType.INSPECT);
        ACTION_MAP.put("talk",  ActionType.TALK);
        ACTION_MAP.put("receive",  ActionType.RECEIVE);
    }
    
    public Action() {
    }
	
	public Action(String type, String value, String from) throws IllegalArgumentException {
		if(ACTION_MAP.get(type) == null) { throw new IllegalArgumentException(type); }
		this.type = type;
		this.value = value;
		this.from = from;
	}
	
	public Action(String type, String value) throws IllegalArgumentException {
		if(ACTION_MAP.get(type) == null) { throw new IllegalArgumentException(type); }
		this.type = type;
		this.value = value;
		this.from = null;
	}


	public ActionType getType() {
		return ACTION_MAP.get(type);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public String toString() {
		return "type: " + type + ", value: " + value;
	}
}
