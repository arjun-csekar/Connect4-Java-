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
		
		
		while(true) {
			System.out.print(play ? "Player 1 " + "Enter column: " : "Player 2 " + "Enter column: ");
			col = sc.nextInt() - 1;
			
			if(play) {
				table[check(table, col)][col] = 'X';
				play = false;
			}
			else {
				table[check(table, col)][col] = 'O';
				play = true;
			}
			
			print(table);
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

}
