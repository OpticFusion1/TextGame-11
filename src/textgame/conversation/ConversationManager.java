package textgame.conversation;

import java.util.*;

import textgame.game.Game;
import textgame.game.Outputter;
import textgame.actions.Action;
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
	
	public Line getCurrentLine() {
		return this.conversation.get(currentLineIndex);
	}
	
	public void showCurrentLine() {
		Outputter.writeln(getCurrentLine().toString());
	}
	
	public List<Response> getCurrentLineResponses() {
		return this.getCurrentLine().getResponses();
	}
	
	public void showCurrentLineResponses() {
		for(Response response : getCurrentLineResponses()) {
			Outputter.writeln(response.toString());
		}
	}
	
	public void converse() {
		Outputter.writeln(npc.getName() + " says to you:");
		while(getCurrentLineIndex() < getCurrentLineResponses().size()) {
			showCurrentLine();
			showCurrentLineResponses();
			int choice = getUserSelection("Enter a number: ");
			setCurrentLineIndex(choice);
			Action responseAction = getCurrentLine().getAction();
			if(responseAction != null) {
				player.perform(responseAction);
			}
		}
		Outputter.write("\n");
	}
	
	public int getUserSelection(String prompt) {
	    Outputter.write(prompt);
	    while(true){
	        try {
	            return Integer.parseInt(new Scanner(System.in).next());
	        } catch(NumberFormatException ne) {
	            System.out.print("That's not a number.\n"+prompt);
	        }
	    }
	}
}
