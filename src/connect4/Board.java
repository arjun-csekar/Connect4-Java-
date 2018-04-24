package connect4;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
	
	private final char PLAYER_1 = 'X';
	private final char PLAYER_2 = 'O';
	
	private char[][] grid = new char[6][7];
	private Piece player1 = new Piece();
	private Piece player2 = new Piece();
	
	public Board() {
		this.fillArray();
	}
	
	private void fillArray() {
	    for (int i = 0; i < this.grid.length; i++){
	        Arrays.fill(this.grid[i], '-');
	    }
	}
	
	private boolean columnFull(int column) {
		return this.grid[5][column] != '-';
	}
	
	public int choose() {
		int turn = Piece.getTurn();
		String name;
		char playerPiece;
		if(turn == 1) {
			name = player1.getName();
			playerPiece = PLAYER_1;
		}
		else {
			name = player2.getName();
			playerPiece = PLAYER_2;
		}

		boolean invalid = true;
		int column = -1;
		while(invalid) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.printf("%s, enter a column 1-7: ", name);
				column = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid input");
				continue;
			}
			
			column -= 1;
			if(column > 6 || column < 0) {
				System.out.println("Must be 1-7");
			}
			else if(this.columnFull(column)) {
				System.out.println("Column is full");
			}
			else {
				invalid = !invalid;
			}
		}
		return column;
	}
	
	public int findRow(int column) {
		for(int i = 4; i >= 0; i--) {
			if(this.grid[i][column] != '-') {
				return i + 1;
			}
		}
		return 0;
	}
	
	public void update(int row, int column) {
		char playerPiece;
		int turn = Piece.getTurn();
		if(turn == 1) {
			playerPiece = PLAYER_1;
		}
		else {
			playerPiece = PLAYER_2;
		}
		
		this.grid[row][column] = playerPiece;
	}
	
	public void printGrid() {
		for(int i = 5; i >= 0 ; i--) {
			for(int j = 0 ; j < 7; j++) {
				System.out.print(String.format("%5c", this.grid[i][j]));
			}
			System.out.println();
		}
	}
	
	public void setPlayerNames() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Player 1's name: ");
		this.player1.setName(sc.nextLine());
		System.out.print("Enter Player 2's name: ");
		this.player2.setName(sc.nextLine());
	}

	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public Piece getPlayer1() {
		return player1;
	}

	public void setPlayer1(Piece player1) {
		this.player1 = player1;
	}

	public Piece getPlayer2() {
		return player2;
	}

	public void setPlayer2(Piece player2) {
		this.player2 = player2;
	}
	
}
