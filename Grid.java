/**
 	Grid for playing Connect 4.
 */

public class Grid {
	
	private int [][] grid;
	
	/**
	     Construct an empty grid object.
	 */
	public Grid() {
		grid= new int[6][7];
	}
	
	/**
	     Construct a grid object by initializing it with the input grid.
	     @param g grid to edit
	 */
	public Grid(Grid g) {
		this.grid= g.grid;
	}
	
	/** 
	     Print the current grid status on the screen.
	 */
	public void getGrid() {
		for (int row=0; row<6; row++) {
			for (int column=0; column<7; column++) {
				if (column==6) {
					System.out.print("| "+grid[row][column]+" |");
				}
				else {
					System.out.print("| "+grid[row][column]+" ");
				}
			}
			System.out.println();
		}
	}
	
	/**Returns the value found in the grid in position [row] [column].
	   @param row row of location
           @param col column of location
	   @return value found in the grid in position [row] [column]*/
	public int getPositionValue(int row, int column){
		return grid[row][column];
	}
	
	/**Set the value in position [row] [column].
	   @param row row of location
           @param column column of location
	   @param value value to insert*/
	
	public void setPositionValue(int row, int column, int value) {
		grid[row][column]=value;
	}
}
