package textgame.conversation;

import java.util.HashMap;
import java.util.Map;

public class Action {
	
	public enum ActionType { NONE, GO, GIVE, TAKE }
	private String value;
	private String type;
    private static Map<String, ActionType> ACTION_MAP = new HashMap<String, ActionType>();

    static {
        ACTION_MAP.put("none", ActionType.NONE);
        ACTION_MAP.put("go", ActionType.GO);
        ACTION_MAP.put("give", ActionType.GIVE);
        ACTION_MAP.put("take", ActionType.TAKE);
    }
    
    public Action() {
    }
	
	public Action(String type, String value) {
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
