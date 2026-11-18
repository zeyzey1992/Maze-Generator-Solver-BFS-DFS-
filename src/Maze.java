
public class Maze {

	private int rows;
	private int cols;
	private Cell[][] grid;

	public Maze(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		grid = new Cell[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				grid[row][col] = new Cell(row, col);
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
	
	public Cell[][] getGrid() {
        return grid;
    }

}
