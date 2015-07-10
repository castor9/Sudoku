import java.util.Scanner;
public class Player {
	public Move getMove(int [][] board) {
		Scanner scanner = new Scanner(System.in);
		Move move;
		String answer = "";
		boolean valid = false;
		letter = 0;
		number = 0;
		
		while (!valid) {
			System.out.print("Select a square: ");
			answer = scanner.nextLine();
			if (answer.length() != 2) {
				System.out.println("not a valid coordinate, try again");
				continue;
			}

			letter = (answer.toUpperCase().charAt(0) - 'A');
			number = (answer.charAt(1) - '0');
			if (letter < 9 && letter >= 0 &&
				number < 9 && number >= 0 &&
				board[letter][number] == 0) valid = true;
			else System.out.println("not a valid coordinate, try again");
		}

		//letter = (answer.toUpperCase().charAt(0) - 'A');
		// Checks if there is a number in the tens place, or not
		//number = (answer.charAt(1) - '0'); // 1 - 49 = 0
		move = new Move(letter, number);

		return move; 
	}

	public void addAnswer(Move move, int [][] args) {
		String answer = "";
		Scanner scanner  = new Scanner(System.in);
		
		while (true) {
			System.out.print("What would you like to put there? ");
			answer = scanner.nextLine();
			number = (answer.charAt(0) - '0');
			if (answer.length() == 1 && number <= 9 && number >= 0) {
				args[move.getRow()][move.getColumn()] = number;
				return;
			} else System.out.println("not a valid number try again");
		}
	}

	private int letter;
	private int number;
}