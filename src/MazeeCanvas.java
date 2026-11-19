import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MazeeCanvas extends JPanel{
	
	Cell [][] grid;
	List<Cell> path;
	
	
	
	public MazeeCanvas(Cell [][] grid) {
		this.grid = grid;
	}
	
	public void setPath(List<Cell> path) {

	    this.path = new ArrayList<>();

	    Timer timer = new Timer(200, null);

	    timer.addActionListener(e -> {

	        int i = this.path.size();

	        if (i < path.size()) {

	            this.path.add(path.get(i));
	            repaint();

	        } else {

	            timer.stop();
	        }

	    });

	    timer.start();
	}
	
	
	private void drawCell(Graphics g, Cell c, int top, int left, int cell_dim) {
		top++;
		if(c.isTopWall()) {
			
			g.drawLine(left, top, left+ cell_dim, top);//draw top line
		}
		
		if(c.isLeftWall()) {
			
			g.drawLine(left, top, left, top+cell_dim);//draw left line
		}
		
		if(c.isRightWall()) {
			
			g.drawLine(left+cell_dim, top, left+ cell_dim, top+cell_dim);//draw right line
		}
		
		if(c.isBottomWall()) {
			
			g.drawLine(left+cell_dim, top+cell_dim, left, top+cell_dim);//draw bottom line
		}
		
		if (path != null && path.contains(c)) {
	        g.setColor(java.awt.Color.PINK);
	        g.fillOval(left + 10, top + 10, 5, 5);
	        g.setColor(java.awt.Color.BLACK);
	    }
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int w = getWidth();
		int h = getHeight();
		
		int cell_dim;
		if(w < h) {
			cell_dim = w/grid[0].length;
		}else {
			cell_dim = h/ grid.length;
		}
		
		for(int i=0; i< grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				drawCell(g, grid[i][j], i*cell_dim, j*cell_dim, cell_dim);
			}
		}
	}

}
