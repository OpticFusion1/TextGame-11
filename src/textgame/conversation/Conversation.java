package textgame.conversation;

import java.util.*;
import textgame.conversation.*;

public class Conversation {

	private List<Line> lines;
	
	public Conversation() {
		lines = new ArrayList<Line>();
	}
	
	public Conversation(List<Line> lines) {
		this.lines = lines;
	}
	
	public List<Line> getLines() {
		return lines;
	}
	
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	
	public Line getLine(int index) {
		return lines.get(index);
	}
	
	public void addLine(Line line) {
		this.lines.add(line);
	}
}
