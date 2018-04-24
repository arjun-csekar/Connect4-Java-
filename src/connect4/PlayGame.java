package connect4;

public class PlayGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int TURN_LIMIT = 42;
		
		Board game = new Board();
		CheckWin checker = new CheckWin();
		game.setPlayerNames();
		game.printGrid();
		
		int turnCount = 0;
		while(true) {
			int column = game.choose();
			int row = game.findRow(column);
			game.update(row, column);
			game.printGrid();
			turnCount++;
			// test for win condition here
			if(checker.check(game.getGrid(), row, column)) {
				String winner = (Piece.getTurn() == 1) ? game.getPlayer1().getName() : game.getPlayer2().getName();
				System.out.println(String.format("%s wins!", winner));
				break;
			}
			
			if(turnCount == TURN_LIMIT) {
				System.out.println("TIE!");
				break;
			}
			
			System.out.println();
			Piece.switchTurn();
		}
	}

}
