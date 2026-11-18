
public class Cell {
	
	private int row, col;
	private boolean isVisited;
	private boolean topWall, leftWall, bottomWall, rightWall;


	public Cell(int r, int c) {
		this.row = r;
		this.col = c;
		
		isVisited = false;
		topWall= leftWall= bottomWall= rightWall= true;
	
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public boolean isVisited() {
		return isVisited;
	}


	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}


	public boolean isTopWall() {
		return topWall;
	}


	public void setTopWall(boolean topWall) {
		this.topWall = topWall;
	}


	public boolean isLeftWall() {
		return leftWall;
	}


	public void setLeftWall(boolean leftWall) {
		this.leftWall = leftWall;
	}


	public boolean isBottomWall() {
		return bottomWall;
	}


	public void setBottomWall(boolean bottomWall) {
		this.bottomWall = bottomWall;
	}


	public boolean isRightWall() {
		return rightWall;
	}


	public void setRightWall(boolean rightWall) {
		this.rightWall = rightWall;
	}
	
	

}
