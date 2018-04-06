package connect4;

import java.util.Arrays;
import java.util.Scanner;

public class TestConnect {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char table[][] = new char[6][7];
		FillArray(table);
		
		int col;
		
		boolean play = true;
		
		print(table);
		boolean win = false;
		
		while(true) {
			System.out.print(play ? "Player 1 " + "Enter column: " : "Player 2 " + "Enter column: ");
			col = sc.nextInt() - 1;
			
			if(play) {
				int row = check(table, col);
				table[row][col] = 'X';
				if(checkWin(table, row, col)) {
					System.out.println("\nWINNER!");
					win = true;
				}
				play = false;
			}
			else {
				int row = check(table, col);
				table[row][col] = 'O';
				if(checkWin(table, row, col)) {
					System.out.println("\nWINNER!");
					win = true;
				}
				play = true;
			}
			
			print(table);
			if(win) {
				break;
			}
		}

	}
	
	static int check(char[][] arr, int num) {
		for(int i = 5; i >= 0; i--) {
			if(arr[i][num] != '-') {
				return i + 1;
			}
		}
		return 0;
	}
	
	
	static void print(char[][] arr) {
		for(int i = 5; i >= 0 ; i--) {
			for(int j = 0 ; j < 7; j++) {
				System.out.print(String.format("%5c", arr[i][j]));
			}
			System.out.println();
		}
	}
	
	static void FillArray(char[][] SC){
	    for (int i = 0; i < SC.length; i++){
	        Arrays.fill(SC[i], '-');
	    }
	}

	static boolean checkHorizontal(char[][] arr, int row, int col) {
		boolean win  = false;
		char piece = arr[row][col];
		int piecesOwned = 1;
		int width = arr[0].length;
		boolean keepChecking = true;
		int checkIndex = col - 1;
		// Check left side
		while(keepChecking) {
			if(checkIndex >= 0) {
				char checkPiece = arr[row][checkIndex];
				if(checkPiece == piece) {
					piecesOwned++;
					checkIndex--;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		keepChecking = true;
		checkIndex = col + 1;
		// Check right side
		while(keepChecking) {
			if(checkIndex < width) {
				char checkPiece = arr[row][checkIndex];
				if(checkPiece == piece) {
					piecesOwned++;
					checkIndex++;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		if(piecesOwned >= 4) {
			win = true;
		}
		
		return win;
	}
	
	static boolean checkVertical(char[][] arr, int row, int col) {
		boolean win = false;
		char piece = arr[row][col];
		int piecesOwned = 1;
		boolean keepChecking = true;
		int height = arr.length;
		
		// Check below first
		int checkIndex = row - 1;
		while(keepChecking) {
			if(checkIndex >= 0) {
				char checkPiece = arr[checkIndex][col];
				if(checkPiece == piece) {
					piecesOwned++;
					checkIndex--;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		// Checking above now
		keepChecking = true;
		checkIndex = row + 1;
		while(keepChecking) {
			if(checkIndex < height) {
				char checkPiece = arr[checkIndex][col];
				if(checkPiece == piece) {
					piecesOwned++;
					checkIndex++;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		if(piecesOwned >= 4) {
			win = true;
		}
		
		return win;
	}
	
	// checks top-left to bottom-right diagonal
	static boolean checkDiagonalTLBR(char[][] arr, int row, int col) {
		boolean win = false;
		
		char piece = arr[row][col];
		int piecesOwned = 1;
		boolean keepChecking = true;
		int height = arr.length;
		int width = arr[0].length;
		
		// TOP-LEFT TO BOTTOM-RIGHT DIAGONAL CHECK
		
		int rowCheck = row + 1;
		int colCheck = col - 1;
		
		// Checking toward top left first
		while(keepChecking) {
			if(rowCheck < height && colCheck >= 0) {
				char checkPiece = arr[rowCheck][colCheck];
				if(checkPiece == piece) {
					piecesOwned++;
					rowCheck++;
					colCheck--;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		// Checking toward bottom right now
		keepChecking = true;
		rowCheck = row - 1;
		colCheck = col + 1;
		
		while(keepChecking) {
			if(rowCheck >= 0 && colCheck < height) {
				char checkPiece = arr[rowCheck][colCheck];
				if(checkPiece == piece) {
					piecesOwned++;
					rowCheck--;
					colCheck++;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		if(piecesOwned >= 4) {
			win = true;
		}
		
		return win;
	}
	
	// Bottom-left to top-right diagonal check
	static boolean checkDiagonalBLTR(char[][] arr, int row, int col) {
		boolean win = false;
		char piece = arr[row][col];
		int piecesOwned = 1;
		boolean keepChecking = true;
		int height = arr.length;
		int width = arr[0].length;
		
		int rowCheck = row - 1;
		int colCheck = col - 1;
		
		// Checking toward bottom-left first
		while(keepChecking) {
			if(rowCheck >= 0 && colCheck >= 0) {
				char checkPiece = arr[rowCheck][colCheck];
				if(checkPiece == piece) {
					piecesOwned++;
					rowCheck--;
					colCheck--;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		keepChecking = true;
		rowCheck = row + 1;
		colCheck = col + 1;
		// Checking toward top-right now
		while(keepChecking) {
			if(rowCheck < height && colCheck < width) {
				char checkPiece = arr[rowCheck][colCheck];
				if(checkPiece == piece) {
					piecesOwned++;
					rowCheck++;
					colCheck++;
				}
				else {
					keepChecking = !keepChecking;
				}
			}
			else {
				keepChecking = !keepChecking;
			}
		}
		
		if(piecesOwned >= 4) {
			win = true;
		}
		
		return win;
	}
	
	static boolean checkWin(char[][] arr, int row, int col) {
		boolean win = false;
		
		if(checkVertical(arr, row, col) || checkHorizontal(arr, row, col) || checkDiagonalTLBR(arr, row, col) || checkDiagonalBLTR(arr, row, col)) {
			win = true;
		}
		
		return win;
	}
	
}
