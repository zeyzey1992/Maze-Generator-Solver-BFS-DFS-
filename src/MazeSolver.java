import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MazeSolver {
	
	public List<Cell> solve(Maze maze){
		
		Cell start = maze.getCell(0, 0);
		Cell finish = maze.getCell(maze.getRows()-1, maze.getCols()-1);
		
		QueueArrayBased q = new QueueArrayBased();
		Map<Cell, Cell> previous = new HashMap<>();
		
		q.enqueue(start);
		previous.put(start, null);
		
		
			while(!q.isEmpty()) {
				Cell current = (Cell) q.dequeue();
				
				if(current == finish) {
					break;
				}
				
				int row = current.getRow();
				int col = current.getCol();
				
				if(row >0 && !current.isTopWall()) {
					Cell top = maze.getCell(row-1, col);
					
					if(!previous.containsKey(top)) {
						previous.put(top, current);
						q.enqueue(top);
					}
				}
				
				if(col < maze.getCols()-1 && !current.isRightWall()) {
					Cell right = maze.getCell(row, col +1);
					
					if(!previous.containsKey(right)) {
						previous.put(right, current);
						q.enqueue(right);
					}
				}
				
				if(row < maze.getRows()-1 && !current.isBottomWall()) {
					Cell bottom = maze.getCell(row+1, col);
					
					if(!previous.containsKey(bottom)) {
						previous.put(bottom, current);
						q.enqueue(bottom);
					}
				}
				
				if(col > 0 && !current.isLeftWall()) {
					Cell left = maze.getCell(row, col -1);
					
					if(!previous.containsKey(left)) {
						previous.put(left, current);
						q.enqueue(left);
					}
				}
				
				
				
			}
		
		
		if(!previous.containsKey(finish)) {
			return new ArrayList<>();
		}
		List<Cell> path = new ArrayList<>();
		Cell current = finish;
		
		while(current != null) {
			path.add(current);
			current = previous.get(current);
		}
		
		Collections.reverse(path);
		return path;
	}

}
