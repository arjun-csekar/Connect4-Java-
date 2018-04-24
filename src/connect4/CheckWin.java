package connect4;

public class CheckWin {
	private int boundRow = 5;
	private int boundCol = 6;
	private int piece = 1;
	private int row;
	private int col;
	private int up;
	private int down;
	private int left;
	private int right;
	private char playerPiece;
	private char[][] arr;

	public CheckWin() {
	}

	private void Setup() {
		CalculateBoundary();
	}

	public boolean check(char[][] arr, int row, int col) {
		this.row = row;
		this.col = col;
		this.playerPiece = arr[row][col];
		this.arr = arr;
		Setup();
		if (Vertical() || Horizontal() || DiagonalLeft() || DiagonalRight()) {
			return true;
		}
		return false;
	}

	private boolean Vertical() {
		for (int i = row; i >= down; i--) {
			if (row == i && col == col) {
				continue;
			}
			if (arr[i][col] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		piece = 1;
		return false;
	}

	private boolean Horizontal() {
		for (int i = col; i <= right; i++) {
			if (row == row && i == col) {
				continue;
			}
			if (arr[row][i] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		for (int i = col; i >= left; i--) {
			if (row == row && i == col) {
				continue;
			}
			if (arr[row][i] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		piece = 1;
		return false;
	}

	private boolean DiagonalRight() {
		for (int i = col, j = row; i <= right && j <= up; i++, j++) {
			if (j == row && i == col) {
				continue;
			}
			if (arr[j][i] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		for (int i = col, j = row; i >= left && j >= down; i--, j--) {
			if (j == row && i == col) {
				continue;
			}
			if (arr[j][i] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		piece = 1;
		return false;
	}

	private boolean DiagonalLeft() {
		for (int i = col, j = row; i >= left && j <= up; i--, j++) {
			if (j == row && i == col) {
				continue;
			}
			if (arr[j][i] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		for (int i = col, j = row; i <= right && j >= down; i++, j--) {
			if (j == row && i == col) {
				continue;
			}
			if (arr[j][i] == playerPiece) {
				piece++;
			} else {
				break;
			}
		}
		if (piece == 4) {
			return true;
		}
		piece = 1;
		return false;
	}

	private void CalculateBoundary() {
		up = (row + 3) <= boundRow ? (row + 3) : boundRow;
		down = (row - 3) >= 0 ? (row - 3) : 0;
		right = (col + 3) <= boundCol ? (col + 3) : boundCol;
		left = (col - 3) >= 0 ? (col - 3) : 0;
	}
}
