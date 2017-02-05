package textgame.entities;

import java.util.List;

import textgame.conversation.*;

public class NPC extends Entity {
	
	private List<Line> conversation;
	
	public NPC() {
		super();
	}

	public NPC(String id, String name) {
		super(id, name);
	}
	
	public NPC(String id, String name, List<Line> convo) {
		super(id, name);
		this.conversation = convo;
	}

	public List<Line> getConversation() {
		return conversation;
	}
	
	public void setConversation(List<Line> convo) {
		this.conversation = convo;
	}
	
	public String toString() {
		return this.getId();
	}
}
