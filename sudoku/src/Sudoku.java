public class Sudoku {
	private int[][] sudoku; // [y][x], y=rader av kolumner, x=kolumner i rader
	
	/**
	 * Sudokut anges som en matris vid skapandet av sudokuobjektet
	 * @param sudoku matris av heltal som representerar sudokut som ska l�sas
	 */
	public Sudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}
	
	/**
	 * L�s sudokut. Observera att sudokumatrisen som angivits som parameter
	 * till konstruktorn kommer att skrivas �ver.
	 * @return true om sudokut gick att l�sa, false annars
	 */
	public boolean solve() {
		return solve(0, 0);
	}
	
	private boolean solve(int y, int x) {
		if (sudoku[y][x] > 0) { // finns en siffra i (y, x)
			if (check(y, x)) { // om i �r giltigt i (y, x)
				if(y == 8 && x == 8 ) { // sista rutan i sudokut
					return true;
				} else // k�r solve p� n�sta ruta
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
					sudoku[y][x] = i; // prova att s�tta in i
					if (check(y, x)) { // om i �r giltigt i (y, x)
						return true; // sudokut �r l�st
					}
				}
				return false;
			} else {
				for (int i = 1; i <= 9; i++) {
					sudoku[y][x] = i; // prova att s�tta in i
					if (check(y, x)) { // om i �r giltigt i (y, x)
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
				return false; // felaktig l�sning, g� bak�t
			}
		}
	}
	
	/**
	 * Letar efter f�rekomster av num i aktuell rad
	 * @param row rad att testa
	 * @param num numret att leta efter
	 * @return true om num inte hittades i raden, false annars
	 */
	private boolean checkRow(int row, int num) {
		int index = 0;
		while (index < 9 && num != sudoku[row][index]) {
			index++;
		}
		return index == 9; // inga dubletter
	}
	
	/**
	 * Letar efter f�rekomster av num i aktuell kolumn
	 * @param num numret att leta efter
	 * @param col kolumn att testa 
	 * @return true om num inte hittades i kolumnen, false annars
	 */
	private boolean checkColumn(int num, int col) {
		int index = 0;
		while (index < 9 && num != sudoku[index][col]) {
			index++;
		}
		return index == 9; // inga dubletter
	}
	
	/**
	 * Letar efter f�rekomster av num i aktuell 3x3-region
	 * @param y y-koordinat i sudokut
	 * @param x x-koordinat i sudokut
	 * @param num numret att leta efter
	 * @return true om num inte hittades i regionen, false annars
	 */
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
	
	/**
	 * Utf�r alla tre kontroller p� en ruta
	 * @param y y-koordinat i sudokut
	 * @param x x-koordinat i sudokut
	 * @return true om rutan �r okej, false annars
	 */
	public boolean check(int y, int x) {
		// Plocka tillf�lligt ut v�rdet fr�n aktuell ruta f�r att inte uppt�cka falska dubletter
		int num = sudoku[y][x];
		sudoku[y][x] = 0;
		
		if (checkRow(y, num) && checkColumn(num, x) && checkRegion(y, x, num)) {
			sudoku[y][x] = num;
			return true;
		} else {
			sudoku[y][x] = num;
			return false;
		}
	}
}
