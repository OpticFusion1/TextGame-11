package textgame.entities;

import java.util.*;
import javax.xml.bind.annotation.*;

import textgame.conversation.*;

public class NPC {
	
	private String id;
	private String name;
	private Conversation conversation;
	
	public NPC() {
		id = new String();
		name = new String();
	}

	public NPC(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public NPC(String id, String name, Conversation convo) {
		this.id = id;
		this.name = name;
		this.conversation = convo;
	}
	
	public String toString() {
		return "id: " + id + ", name: " + name;
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
	
	public Conversation getConversation() {
		return conversation;
	}
	
	public void setConversation(Conversation convo) {
		this.conversation = convo;
	}
}
