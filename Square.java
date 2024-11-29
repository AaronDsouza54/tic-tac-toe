public class Square {
	private boolean empty; 
	private String value; 
	
	Square() {
		initializeSquare();
	}
	
	private void initializeSquare() {
		empty = true; 
		value ="E";  //Empty :)
	}
	
	public String getSquare() {
		return value; 
	}
	public void setSquare(String value) {
		value = value.toUpperCase();
		if (!(value.equals("X") ||  value.equals("O")))
			throw new IllegalArgumentException("Must Specify X or O");
		this.value = value; 
		setOccupied(); 
	}
	
	public boolean isEmpty() {
		return empty; 
	}
	
	private void setOccupied() {
		empty = false; 
	}
	public String toString() {
		return value; 
	}
}
