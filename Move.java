public class Move {
	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() { return row; }
	public int getColumn() { return col; }

	private int row, col;
}