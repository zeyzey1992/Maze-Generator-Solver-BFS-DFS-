import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MazeGenerator {

	private Random random = new Random();
	
	

	public void generate(Maze maze) {
		
		StackReferenceBased stack = new StackReferenceBased();

		Cell start = maze.getCell(0, 0);
		start.setVisited(true);
		stack.push(start);

		while (!stack.isEmpty()) {
			
			Cell current = (Cell) stack.peek();
			List<Cell> neighbours = new ArrayList<>();
			
			int row = current.getRow();
			int col = current.getCol();

			// Top neighbour
			if (row > 0) {
				Cell top = maze.getCell(row - 1, col);
				if (!top.isVisited()) {
					neighbours.add(top);
				}
			}

			// Right neighbour
			if (col < maze.getCols() - 1) {
				Cell right = maze.getCell(row, col + 1);
				if (!right.isVisited()) {
					neighbours.add(right);
				}
			}

			// Bottom neighbour
			if (row < maze.getRows() - 1) {
				Cell bottom = maze.getCell(row + 1, col);
				if (!bottom.isVisited()) {
					neighbours.add(bottom);
				}
			}

			// Left neighbour
			if (col > 0) {
				Cell left = maze.getCell(row, col - 1);
				if (!left.isVisited()) {
					neighbours.add(left);
				}
			}

			if (!neighbours.isEmpty()) {
				
				int index = random.nextInt(neighbours.size());
				Cell next = neighbours.get(index);

				if (next.getRow() == current.getRow()) {
					// Same row bottom or top
					if (next.getCol() > current.getCol()) {
						current.setRightWall(false);
						next.setLeftWall(false);
					} else {
						current.setLeftWall(false);
						next.setRightWall(false);
					}
				} else {
					// different column bottom or not
					if (next.getRow() > current.getRow()) {
						current.setBottomWall(false);
						next.setTopWall(false);
					} else {
						current.setTopWall(false);
						next.setBottomWall(false);
					}
				}

				next.setVisited(true);
				stack.push(next);
				
				
			} else {
				stack.pop();
			}
		}
	}
}