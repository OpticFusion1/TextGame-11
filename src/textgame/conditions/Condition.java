package textgame.conditions;

import java.util.HashMap;
import java.util.Map;

public class Condition {
	
	public enum ConditionType { NONE, HAS }
	private String value;
	private String type;
	private String error;
    private static Map<String, ConditionType> CONDITION_MAP = new HashMap<String, ConditionType>();

    static {
        CONDITION_MAP.put("none", ConditionType.NONE);
        CONDITION_MAP.put("has", ConditionType.HAS);
    }
    
    public Condition() {
    }
	
	public Condition(String type, String value, String error) throws IllegalArgumentException {
		if(CONDITION_MAP.get(type) == null) { throw new IllegalArgumentException(type); }
		this.type = type;
		this.value = value;
		this.error = error;
	}

	public ConditionType getType() {
		return CONDITION_MAP.get(type);
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
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "type: " + type + ", value: " + value;
	}
}
