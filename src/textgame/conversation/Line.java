package textgame.conversation;

import java.util.*;

import textgame.actions.Action;

public class Line {

	private String text;
	private List<Response> responses;
	private Action action;
	
	public Line() {
		text = null;
		responses = new ArrayList<Response>();
		action = null;
	}
	
	public Line(String text) {
		this.text = text;
		this.responses = new ArrayList<Response>();
		this.action = null;
	}
	
	public Line(String text, List<Response> responses) {
		this.text = text;
		this.responses = responses;
		this.action = null;
	}
	
	public Line(String text, Action action) {
		this.text = text;
		this.responses = new ArrayList<Response>();
		this.action = action;
	}
	
	public Line(String text, List<Response> responses, Action action) {
		this.text = text;
		this.responses = responses;
		this.action = action;
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
	
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "-- " + text;
	}
	
}
