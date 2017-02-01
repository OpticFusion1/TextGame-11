package textgame.conversation;

import java.util.HashMap;
import java.util.Map;

public class Action {
	
	public enum ActionType { NONE, ENTER, GIVE, TAKE }
	private String value;
	private ActionType type;
    private static Map<String, ActionType> ACTION_MAP = new HashMap<>();

    static {
        ACTION_MAP.put("none", ActionType.NONE);
        ACTION_MAP.put("enter", ActionType.ENTER);
        ACTION_MAP.put("give", ActionType.GIVE);
        ACTION_MAP.put("take", ActionType.TAKE);
    }
	
	public Action(String type, String value) {
		this.type = ACTION_MAP.get(type);
		this.setValue(value);
	}

	public ActionType getType() {
		return type;
	}

	public void setType(ActionType type) {
		this.type = type;
	}
	
	public void setType(String type) {
		this.type = ACTION_MAP.get(type);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
