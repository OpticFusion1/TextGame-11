package textgame.conversation;

import java.util.*;

import textgame.game.Game;
import textgame.game.Outputter;
import textgame.entities.*;

public class ConversationManager {
	private Conversation conversation;
	private Game game;
	private Player player;
	private NPC npc;
	private int currentLineIndex;
	
	public ConversationManager(Game game, NPC npc) {
		this.game = game;
		this.player = game.getPlayer();
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
		return this.conversation.getLine(currentLineIndex);
	}
	
	public void showCurrentLine() {
		Outputter.writeln(getCurrentLine().toString()+"\n");
	}
	
	public List<Response> getCurrentLineResponses() {
		return this.getCurrentLine().getResponses();
	}
	
	public void showCurrentLineResponses() {
		for(Response response : getCurrentLineResponses()) {
			Outputter.writeln(response.toString()+"\n");
		}
	}
	
	public void converse() {
		while(getCurrentLineIndex() < getCurrentLineResponses().size()) {
			showCurrentLine();
			showCurrentLineResponses();
			int choice = getUserSelection("Enter a number: ");
			setCurrentLineIndex(choice);
			Action responseAction = getCurrentLine().getAction();
			if(responseAction != null) {
				game.performAction(player, npc, responseAction);
			}
		}
		showCurrentLine();
		player.getLocation().show();
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
