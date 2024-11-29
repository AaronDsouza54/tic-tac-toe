public class GameBoard {
private Square [] currentBoard  = new Square[9];
	
	GameBoard() {
		initializeBoard();
	}
	
	private void initializeBoard() {
		for (int i=0; i<currentBoard.length;i++)
			currentBoard[i] = new Square(); 
	}
	
	public void clearBoard() {
		initializeBoard(); 
	}
	
	public boolean isEmpty(int row, int col) {
		if (checkValue(row) && checkValue(col))
			return currentBoard[(row-1)*3+(col-1)].isEmpty();
		else
			throw new IllegalArgumentException("Invalid row or column specified!");	
	}
	
	public void setMove(String move, int row, int col) {
		int position;
		if (!checkValue(row))
			throw new IllegalArgumentException("Invalid row specified!");
		if (!checkValue(col))
			throw new IllegalArgumentException("Invalid col specified!");
		position = (row-1)*3  + (col-1); 
		currentBoard[position].setSquare(move);
	}
	
	private boolean checkHorizontal(String value) {
		for (int i=0; i<3; i++)
			if (currentBoard[i*3].getSquare().equals(value) && 
				currentBoard[i*3+1].getSquare().equals(value) && 
				currentBoard[i*3+2].getSquare().equals(value))
				return true; 
		return false; 
	}
	
	private boolean checkVertical(String value) {
		for (int i=0; i<3; i++)
			if (currentBoard[i].getSquare().equals(value) && 
				currentBoard[i+3].getSquare().equals(value) && 
				currentBoard[i+6].getSquare().equals(value))
				return true; 
		return false; 
	}
	
	private boolean checkDiagonal(String value) {
		return (currentBoard[0].getSquare().equals(value) && 
				currentBoard[4].getSquare().equals(value) && 
				currentBoard[8].getSquare().equals(value)) ||
			
				(currentBoard[2].getSquare().equals(value) && 
				currentBoard[4].getSquare().equals(value) && 
				currentBoard[6].getSquare().equals(value));
	}
	
	public boolean checkWinner(String value) {
		return checkHorizontal(value) || checkVertical(value) || checkDiagonal(value); 
	}
	
	public String toString() {
		String result="";
		for (int i=0; i<currentBoard.length;i++) {
			if (i % 3 == 0)
				result += "\n";
			result += currentBoard[i].toString(); 
		}
		return result; 
	}
	
	private boolean checkValue(int value) {
		return (value >=1 && value <=3);
	}
}
