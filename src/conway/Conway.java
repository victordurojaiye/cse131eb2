package conway;

import support.cse131.NotYetImplementedException;

public class Conway {

	private int rows,cols;
	public boolean[][] board;

	/**
	 * Constructs a new Conway board rows X columns in size with each cell's alive
	 * status false.
	 * 
	 * @param rows the number of rows
	 * @param cols the number of columns
	 */
	public Conway(int rows, int cols) {

		// FIXME
		this.rows = rows;
		this.cols = cols;
		board = new boolean[rows][cols];

	} 


	/**
	 * @return the number of rows
	 */
	public int getRows() {

		// FIXME
		return rows;

	}

	/**
	 * @return the number of columns
	 */
	public int getColumns() {

		// FIXME
		return cols;

	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * 
	 * @param isAlive if true, the cell is alive; if false, the cell is dead
	 * @param row
	 * @param col
	 */
	public void setAlive(boolean isAlive, int row, int col) {

		// FIXME

		if(isAlive == true) {
			board[row][col] = true;
		}


	}

	/**
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive.
	 *         If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col) {

		// FIXME


		if( ( row < 0 || row >= rows)|| ( col < 0 || col >= cols)) {
			return false;
		}

		else if(board[row][col] == true) {
			return true;
		}

		else {
			return false;
		}

	}

	/**
	 * Make every cell not alive
	 */
	public void clear() {

		// FIXME
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++) {	
				board[i][j] = false;
			}
		}

	}

	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 * n n n
	 * n c n
	 * n n n
	 * 
	 * Above, if c represents the cell at (row, col), each n is
	 * a neighbor of c, according to the above definition.
	 * The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col) {

		// FIXME

		int count = 0;

		if( (( row >= 1 || row < rows -1)|| ( col >= 1 || col < cols -1))) {

			if(isAlive(row-1,col)) {
				count++;
			}
			if(isAlive(row-1,col-1)) {
				count++;
			}
			if(isAlive(row,col-1)) {
				count++;
			}
			if(isAlive(row+1,col)) {
				count++;
			}
			if(isAlive(row+1,col+1)) {
				count++;
			}
			if(isAlive(row-1,col+1)) {
				count++;
			}
			if(isAlive(row+1,col-1)) {
				count++;
			}
			if(isAlive(row,col+1)) {
				count++;
			}

			return count;
		}

		return count;
	}


	/**
	 * Executes a generation of life. Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	public void step() {
		// FIXME

		boolean [][] originalConway = board;
		boolean [][] newConway = new boolean[rows][cols];

		for( int i = 0; i < rows; i++) {
			for( int j = 0; j < cols; j++) {
				newConway[i][j]= board[i][j];
			}
		}
		
		for( int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {

				if(!isAlive(i,j)) {
					if(countLivingNeighbors(i,j) == 3) {
						newConway[i][j] = true;
						//	System.out.println("C");
					}
				}
				else {
					if(countLivingNeighbors(i,j) == 2 || countLivingNeighbors(i,j) == 3) {
						newConway[i][j] = true;
						//	System.out.println("A");
					}
					else{
						newConway[i][j] = false;
						//	System.out.println("B");
					}
				}
			}
		}
		board = newConway;
	}

}
