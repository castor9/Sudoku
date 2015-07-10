import java.util.Arrays;
public class Solver {
	//080000243000079100040000090693502070014907360070301429060000050002690000459000030
	//907156000325400086106823507000040801200080005508060000701234908830005714000718602
	//000092500000060010574001000000000021708000406640000000000200694050030000009810000
	//039281000305305070802210006030102400042607002030401006008002030105000205007902050 - bad board
	//005000009030850071008004000009460310020100600004000700400085003600300580500279040
	
	public Solver() {
		// number of rows and columns in the board
		row = 9;
		col = 9;

		// put into a 2d int array
		// int [][] sudoku = putInArray(args);
		
		// System.out.println("INPUT:");
		// //displayBoard(sudoku);
	
		// if (backtrack(sudoku, 0, 0)) {
		// 	System.out.println("ANSWERED.");
		// 	displayBoard(sudoku);
		// 	answer = sudoku;
		// } else System.out.println("NO ANSWER. Check Your Board");

	}

	public int [][] getAnswer(String [] args) {
		int [][] sudoku = putInArray(args);
		
		backtrack(sudoku, 0, 0);

		return sudoku;
	}

	// String to 2d int array
	public int [][] putInArray(String[] args) {
		int array[][] = new int[row][col];
		int inc = 0;
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				array[i][k] = Integer.parseInt(args[inc]);
				inc++;
			}
		}
		return array;
	}

	// backtracking algorithm
	public boolean backtrack(int [][] sudokuArray, int row, int col) {
		//GET NEXT
		if (row > 8) {
			row = 0; 
			if (++col > 8) return true;
		}
		if (sudokuArray[row][col] != 0) return backtrack(sudokuArray, (row + 1), col);
		// if the number can be put in, then use it in the board to test if it is the right one
		for (int i = 0; i < 9; i++) {
			if (numberIsGood(sudokuArray, row, col, (i + 1))) {
				sudokuArray[row][col] = (i + 1);
				if (backtrack(sudokuArray, (row + 1), col)) return true;
			}
		}
		// if it is not the right one, then set it back to zero, backtrack
		sudokuArray[row][col] = 0;
		return false;
	}

	// checks if the number is good for putting in the array
	public boolean numberIsGood(int [][] sudokuArray, int row, int col, int num) {
		int [] constraints = countConstraints(sudokuArray, row, col);
		if (contains(constraints, num)) return false;
		return true;
	}

	// getting all constraints of a square by scanning rows col, and block
	public int [] countConstraints(int [][] arr, int r, int c) {	
		boolean [] b = new boolean[row];
		b = scanRowsAndCols(arr, r, c);
		b = scanBlock(arr, b, r, c);
		int [] newArr = new int[booleanCount(b)];
		int i = 0;
		for (int m = 0; m < b.length; m++) {
			if (b[m] == false) {
				newArr[i] = (m + 1);
				i++;
			}
		}

		return newArr;
	}

	// checking if number is in array
	public boolean contains(int [] arr, int n) {
		for (int i = 0; i < arr.length; i++) if (arr[i] == n) return false;
		return true;
	}

	// scanning block for constraints
	public boolean [] scanBlock(int [][] sudokuArray, boolean [] domainBoolean, int valueRow, int valueCol) {
		//boolean bool = new boolean[row];
		int blockRow = 0, blockCol = 0;
		if (valueRow < 3) blockRow = 0;
		else if (valueRow >= 3 && valueRow < 6) blockRow = 3;
		else if (valueRow  >= 6) blockRow = 6;

		if (valueCol < 3) blockCol = 0;
		else if (valueCol >= 3 && valueCol < 6) blockCol = 3;
		else if (valueCol  >= 6) blockCol = 6;

		//System.out.println("block Row: " + blockRow + ", block Col " + blockCol);

		for (int i = blockRow; i < (blockRow + 3); i++) {
			for (int k = blockCol; k < (blockCol + 3); k++) {
				if (sudokuArray[i][k] != 0) domainBoolean[(sudokuArray[i][k] - 1)] = true;
			}
		}

		return domainBoolean;
	}

	// scanning row and col for constraints
	public boolean [] scanRowsAndCols(int [][] sudokuArray, int valueRow, int valueCol) {
		boolean domainBoolean[] = new boolean[row];
		//GOING DOWN
		for (int i = 0; i < col; i++) {
			if (sudokuArray[valueRow][i] != 0) domainBoolean[(sudokuArray[valueRow][i] - 1)] = true;
		}

		//GOING ACROSS
		for (int i = 0; i < row; i++) {
			if (sudokuArray[i][valueCol] != 0) domainBoolean[(sudokuArray[i][valueCol] - 1)] = true;
		}

		return domainBoolean;
	}

	//display the sudoku puzzle
	public void displayBoard(int [][] board) {
		System.out.print(" -------------------------- \n");
		for (int i = 0; i < row; i++) {
			System.out.print("| ");
			for (int k = 0; k < col; k++) {
				System.out.print(board[i][k] + " ");
				if (k % 3 == 2) System.out.print(" | ");
			}
			//System.out.print("|");
			if (i % 3 == 2) System.out.print("\n -------------------------- \n");
			else System.out.println();
		}
	}

	// count the false booleans - false means that they are contraints
	public int booleanCount(boolean [] b) {
		int count = 0;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == false) count++;
		}
		return count;
	}

	//public static void main(String[] args) {
		// if (args.length == 0) {
		// 	System.out.println("no arguments");
		// 	System.exit(0);
		// } 

		// String sArg = args[0];

		// if (sArg.length() < 81) {
		// 	System.out.println("TOO FEW NUMBERS. Check Your Board");
		// 	System.exit(0);
		// }

		// String [] sudokuString = new String[sArg.length()];

		// for (int i = 0; i < sudokuString.length; i++) {
  //   		sudokuString[i] = sArg.substring(i,i + 1);
  //   		//System.out.print(sudokuString[i] + " ");
 	// 	}

 	// 	//System.out.println("String: " + sudokuString.length);
		// Solver run = new Solver(sudokuString);
	//}
	int row, col;
	int [][] answer;
}