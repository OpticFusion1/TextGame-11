package textgame.conversation;

import java.util.*;

public class Line {

	private String text;
	private List<Response> responses;
	
	public Line() {
		text = null;
		responses = new ArrayList<Response>();
	}
	
	public Line(String text) {
		this.text = text;
		this.responses = new ArrayList<Response>();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public List<Response> getResponses() {
		return responses;
	}
	
	public void addResponse(Response response) {
		this.responses.add(response);
	}

	public String toString() {
		return "-- " + text;
	}
	
}
