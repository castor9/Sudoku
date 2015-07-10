public class Sudoku {
	public Sudoku(String[] args) {
		row = 9;
		col = 9;
		// get solution
		getSolution(args);

		// generate board
		displayBoard(putInArray(args));

		// start playing
		Player guy = new Player();
	
		playGame(guy, putInArray(args));


	}

	public void playGame(Player player, int [][] args) {
		//have player pick a spot
		int [][] markedBoard = markNumbers(args);
		boolean solved = false;
		while (!solved) {
			player.addAnswer(player.getMove(markedBoard), args);
			displayBoard(args);
		}
	}

	public int [][] markNumbers(int [][] args) {
		int [][] marker = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < col; k++) {
				if (args[i][k] != 0) marker[i][k] = 1;
				else marker[i][k] = 0; 
			}
		}
		return marker;
	}
	public int [][] getSolution(String [] args) {
		Solver s = new Solver();
		solution = s.getAnswer(args);
		//displayBoard(solution);
		return solution;
	}

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

	public void arrayBoard(int array) {

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

	public static void main(String[] args) {
		//SBoard board = new SBoard();
		
		String sArg = "080000243000079100040000090693502070014907360070301429060000050002690000459000030";
		String [] sudokuString = new String[sArg.length()];

		for (int i = 0; i < sudokuString.length; i++) {
    		sudokuString[i] = sArg.substring(i, i + 1);
    		//System.out.print(sudokuString[i] + " ");
 		}

 		//System.out.println("String: " + sudokuString.length);
 		//get Solution
		Sudoku run = new Sudoku(sudokuString);
	}

	int row, col;
	int [][] solution;


}