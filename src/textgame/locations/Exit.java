package textgame.locations;

public class Exit {
	
	private String toId;
	private String direction;
	private Location to;
	
	// Default constructor
	public Exit() {
		direction = null;
		toId = null;
		to = null;
	}
	
	public Exit(String direction, String toId) {
		this.direction = direction;
		this.toId = toId;
	}
	
	public String getDirection() {
		return direction;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public Location getTo() {
		return to;
	}
	
	public void setTo(Location to) {
		this.to = to;
	}
	
	public String getToId() {
		return toId;
	}

	public void setToName(String toId) {
		this.toId = toId;
	}

	public String toString() {
		return direction;
	}

}
