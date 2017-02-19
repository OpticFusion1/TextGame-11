package textgame.conversation;

import java.util.*;

import textgame.game.Game;
import textgame.game.Outputter;
import textgame.actions.Action;
import textgame.conditions.Condition;
import textgame.entities.*;

public class ConversationManager {
	private List<Line> conversation;
	private Player player;
	private NPC npc;
	private int currentLineIndex;
	
	public ConversationManager(Player player, NPC npc) {
		this.player = player;
		this.npc = npc;
		this.conversation = npc.getConversation();
		this.currentLineIndex = 0;
	}

	public int getCurrentLineIndex() {
		return currentLineIndex;
	}

	public void setCurrentLineIndex(int currentLineIndex) {
		this.currentLineIndex = currentLineIndex;
	}
	
	public Line getLine(int index) {
		return this.conversation.get(index);
	}
	
	public void showLine(int index) {
		Outputter.writeln(getLine(getCurrentLineIndex()).toString());
	}
	
	public List<Line> getConversation() {
		return conversation;
	}

	public void setConversation(List<Line> conversation) {
		this.conversation = conversation;
	}

	public List<Response> getCurrentLineResponses() {
		return this.getLine(getCurrentLineIndex()).getResponses();
	}
	
	public void showCurrentLineResponses() {
		for(Response response : getCurrentLineResponses()) {
			Outputter.writeln(response.toString());
		}
	}
	
	public void converse() {
		/* TODO - response condition checking needs improved */
		Outputter.writeln(npc.getName() + " says to you: ");
		while(getCurrentLineIndex() < getConversation().size()) {
			showLine(getCurrentLineIndex());
			Action lineAction = getLine(getCurrentLineIndex()).getAction();
			if(lineAction != null) {
				player.perform(lineAction);
				return;
			}
			showCurrentLineResponses();
			int choice = getUserSelection("Enter a number: ");
			Response resp = getLine(getCurrentLineIndex()).getResponses().get(choice - 1);
			if(resp.getConditions() != null && resp.getConditions().size() > 0) {
				for (Condition cond : resp.getConditions()) {
					if(!player.meetsCondition(cond)) {
						Outputter.writeln("You don't meet the condition: " + cond.getError());
						return;
					}
				}
			}
			setCurrentLineIndex(resp.getNextIndex());
		}
	}
	
	public int getUserSelection(String prompt) {
	    Outputter.write(prompt);
	    while(true){
	        try {
	        	/* TODO - validate number input here */
	            return Integer.parseInt(new Scanner(System.in).next());
	        } catch(NumberFormatException ne) {
	            System.out.print("That's not a number.\n"+prompt);
	        }
	    }
	}
}
