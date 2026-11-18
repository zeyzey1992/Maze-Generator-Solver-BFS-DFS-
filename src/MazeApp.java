import java.util.List;
import java.util.Scanner;

public class MazeApp {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter row number");
    	int rows = scanner.nextInt();
    	
    	System.out.println("Please enter column number");
    	int cols = scanner.nextInt();
    	
    	if(rows<=0 || cols<=0) {
    		System.out.println("Row and column numbers must be greater than 0");
    		return;
    	}
    	

        Maze maze = new Maze(rows, cols);

        MazeGenerator generator = new MazeGenerator();
        generator.generate(maze);

        MazeSolver solver = new MazeSolver();
        List<Cell> path = solver.solve(maze);

        MazeFrame frame = new MazeFrame(maze, path);
        frame.setVisible(true);
    }
}