package connect4;

public class Piece implements Player{
	
	private static int turn = 1;
	private String name;
	
	public Piece() {}
	
	public static int getTurn() {
		return Piece.turn;
	}
	
	public static void switchTurn() {
		Piece.turn = Piece.turn == 1 ? 2 : 1;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
