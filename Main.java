public class Main {
	public static void main(String[] args) {
		GameBoard game = new GameBoard(); 
		userTurn(game, "X");
		System.out.println(game.toString());
		userTurn(game, "O");
		System.out.println(game.toString());
		userTurn(game, "X");
		System.out.println(game.toString());
		userTurn(game, "O");
		System.out.println(game.toString());
		userTurn(game, "X");
		System.out.println(game.toString());
		userTurn(game, "O");
		System.out.println(game.toString());
	}
	
	public static void gameplay(GameBoard game) {
		boolean playerOne = true;
		String playerOneCharacter = "X";
		boolean playerTwo = false;
		String playerTwoCharacter = "O";
		do {
			if (playerOne)
				playerOne = userTurn(game, playerOneCharacter);
			else if (playerTwo)
				playerTwo = userTurn(game, playerTwoCharacter);
			
			System.out.println(game.toString());
			
		}while(checkWinner(game, 
							playerOneCharacter, 
							playerTwoCharacter
							)
				);
	}

	public static boolean checkWinner(GameBoard game, 
										String playerOneCharacter, 
										String playerTwoCharacter) {
		return !(game.checkWinner(playerOneCharacter) || game.checkWinner(playerTwoCharacter));
	}
	
	public static boolean userTurn(GameBoard game, 
									String source) {
		int row;
		int col;
		row = Utils.inputIntegerBetween("Row number: ", 1, 3);
		col = Utils.inputIntegerBetween("Column number: ", 1, 3);
		if (game.isEmpty(row, col)) {
			game.setMove(source, row, col);
			return false;
		}
		return true;
	}
	
	public static void addCounter(GameBoard game, 
									int row, 
									int col, 
									String source
									) {
		if (game.isEmpty(row, col))
			game.setMove(source, row, col);
	}
}
