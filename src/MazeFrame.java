import javax.swing.JFrame;

public class MazeFrame extends JFrame {

    public MazeFrame(Maze maze, java.util.List<Cell> path) {

        setTitle("My Perfect Maze!!!");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MazeeCanvas canvas = new MazeeCanvas(maze.getGrid());
        canvas.setPath(path);
        canvas.invalidate();
        

        add(canvas);
    }
}