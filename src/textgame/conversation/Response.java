package textgame.conversation;

import java.util.*;
import textgame.conditions.*;

public class Response {
	private int nextIndex;
	private String message;
	private List<Condition> conditions = new ArrayList<Condition>();
	
	public Response(int nextIndex, String message) {
		this.nextIndex = nextIndex;
		this.message = message;
	}
	
	public int getNextIndex() {
		return nextIndex;
	}
	
	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public String toString() {
		return nextIndex + ": " + message;
	}
	
}
