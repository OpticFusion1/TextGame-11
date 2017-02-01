package textgame.conversation;

import java.util.*;

import textgame.game.Outputter;

public class ConversationManager {
	private Conversation conversation;
	private int currentLineIndex;
	
	public ConversationManager(Conversation conversation) {
		this.conversation = conversation;
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
			setCurrentLineIndex(getUserSelection("Enter a number: "));
		}
		showCurrentLine(); // Show user final NPC line
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
