package textgame.conversation;

public class Response {
	private int nextIndex;
	private String message;
	
	public Response(int nextIndex, String message) {
		this.nextIndex = nextIndex;
		this.message = message;
	}
	
	public int getNextIndex() {
		return nextIndex;
	}
	
	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return nextIndex + ": " + message;
	}
	
}
