package textgame.entities;

import java.util.*;

import textgame.entities.NPC;

public class NPCs {
	private HashMap<String, NPC> npcs;
	
	public NPCs() {
		this.npcs = new HashMap<String, NPC>();
	}
	
	public void setNPC(NPC npc) {
		this.npcs.put(npc.getId(), npc);
	}
	
	public NPC get(String key) {
		return this.npcs.get(key);
	}
	
	public HashMap<String, NPC> getAll() {
		return (HashMap<String, NPC>) this.npcs.clone();
	}
	
}
