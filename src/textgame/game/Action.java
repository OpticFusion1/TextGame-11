package textgame.game;

import java.util.HashMap;
import java.util.Map;

public class Action {
	
	public enum ActionType { NONE, GO, SHOW, GIVE, TAKE, PICK, INSPECT, TALK }
	private String value;
	private String type;
    private static Map<String, ActionType> ACTION_MAP = new HashMap<String, ActionType>();

    static {
        ACTION_MAP.put("none", ActionType.NONE);
        ACTION_MAP.put("go", ActionType.GO);
        ACTION_MAP.put("show", ActionType.SHOW);
        ACTION_MAP.put("give", ActionType.GIVE);
        ACTION_MAP.put("take", ActionType.TAKE);
        ACTION_MAP.put("pick", ActionType.PICK);
        ACTION_MAP.put("inspect", ActionType.INSPECT);
        ACTION_MAP.put("talk",  ActionType.TALK);
    }
    
    public Action() {
    }
	
	public Action(String type, String value) throws IllegalArgumentException {
		if(ACTION_MAP.get(type) == null) { throw new IllegalArgumentException(type); }
		this.type = type;
		this.value = value;
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
	
	@Override
	public String toString() {
		return "type: " + type + ", value: " + value;
	}
}
