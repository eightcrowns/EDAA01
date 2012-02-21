
public class Sudoku {
	private int[][] sudoku; // [y][x], y=rader av kolumner, x=kolumner i rader
	
	public Sudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}
	
	public boolean solve() {
		return solve(0, 0);
	}
	
	private boolean solve(int y, int x) {
		if (sudoku[y][x] > 0) { // finns en siffra i (y, x)
			int i = sudoku[y][x];
			int temp = sudoku[y][x];
			sudoku[y][x] = 0;
			System.out.println(checkRow(y, i) + ", " + checkColumn(i, x) + ", " + checkRegion(y, x, i));
			boolean noDuplicates = checkRow(y, i) && checkColumn(i, x) && checkRegion(y, x, i);
			sudoku[y][x] = temp;
			if (noDuplicates) { // om i �r giltigt i (y, x)
				// k�r solve p� n�sta ruta
				if (x == 8) {
					if (solve(y+1, 0)) {
						return true;
					}
				} else {
					if (solve(y, x+1)) {
						return true;
					}
				}
			}
			return false;
		} else { // tomt i (y, x)
			if(y == 8 && x == 8 ) { // sista rutan i sudokut
				for (int i = 1; i <= 9; i++) {
					if (checkRow(y, i) && checkColumn(i, x) && checkRegion(y, x, i)) { // om i �r giltigt i (y, x)
						sudoku[y][x] = i; // s�tt in i
						
						return true; // sudokut �r l�st
					}
				}
				return false;
			} else {
				for (int i = 1; i <= 9; i++) {
					if (checkRow(y, i) && checkColumn(i, x) && checkRegion(y, x, i)) { // om i �r giltigt i (y, x)
						sudoku[y][x] = i; // s�tt in i
						
						// k�r solve p� n�sta ruta
						if (x == 8) { // sista rutan i raden
							if (solve(y+1, 0)) {
								return true;
							}
						} else {
							if (solve(y, x+1)) {
								return true;
							}
						}
					}
				}
				sudoku[y][x] = 0;
				return false;
			}
		}
	}
	
	/**
	 * K�rs f�re num l�ggs till i matrisen.
	 * @param row
	 * @param num
	 * @return
	 */
	private boolean checkRow(int row, int num) {
		int index = 0;
		while (index < 9 && num != sudoku[row][index]) {
			index++;
		}
		return index == 9; // inga dubletter
	}
	
	private boolean checkColumn(int num, int col) {
		int i = 0;
		while (i < 9 && num != sudoku[i][col]) {
			i++;
		}
		return i == 9; // inga dubletter
	}
	
	private boolean checkRegion(int y, int x, int num) {
		boolean noDuplicates = true;
		for (int row = (y / 3) * 3; row < (y / 3 + 1) * 3; row++) {
			for (int col = (x / 3) * 3; col < (x / 3 +1) * 3; col++) {
				if (sudoku[row][col] > 0 && num == sudoku[row][col]) {
					noDuplicates = false; // det finns dubletter i regionen som �r > 0, dvs ifyllda
				}
			}
		}
		return noDuplicates;
	}
	
	public static void main(String args[]) {
//		int s[][] = {
//			{0, 0, 8, 0, 0, 9, 0, 6, 2},
//			{0, 0, 0, 0, 0, 0, 0, 0, 5},
//			{1, 0, 2, 5, 0, 0, 0, 0, 0},
//			{0, 0, 0, 2, 1, 0, 0, 9, 0},
//			{0, 5, 0, 0, 0, 0, 6, 0, 0},
//			{6, 0, 0, 0, 0, 0, 0, 2, 8},
//			{4, 1, 0, 6, 0, 8, 0, 0, 0},
//			{8, 6, 0, 0, 3, 0, 1, 0, 0},
//			{0, 0, 0, 0, 0, 0, 4, 0, 0}
//		};
		int s[][] = {
				{0, 0, 8, 0, 0, 9, 0, 6, 2},
				{0, 0, 0, 0, 0, 0, 0, 0, 5},
				{1, 0, 2, 5, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 1, 0, 0, 9, 0},
				{0, 5, 0, 0, 0, 0, 6, 0, 0},
				{6, 0, 0, 0, 0, 0, 0, 2, 8},
				{4, 1, 0, 6, 0, 8, 0, 0, 0},
				{8, 6, 0, 0, 3, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 4, 0, 0}
			};
		
		Sudoku sudoku = new Sudoku(s);
		System.out.println(sudoku.solve());
		
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				System.out.print(s[y][x] + " ");
			}
			System.out.println();
		}
	}
}