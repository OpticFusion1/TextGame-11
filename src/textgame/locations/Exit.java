package textgame.locations;

public class Exit {
	
	private String to;
	private String direction;
	
	// Default constructor
	public Exit() {
		direction = null;
		to = null;
	}
	
	public Exit(String direction, String to) {
		this.direction = direction;
		this.to = to;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String toString() {
		return direction;
	}

}
