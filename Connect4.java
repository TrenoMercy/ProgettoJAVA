import java.util.ArrayList;
import java.util.Scanner;

/**
 	Game Connect 4.
 */

public class Connect4 {
	
	ArrayList<Player> giocatori;
	private Grid grid;
	Scanner in= new Scanner(System.in);
	
	
	/**
		Construct the Connect 4 game with the match players and the grid.
 		@param players two players game
 		@param grid game grid 
	*/
	public Connect4(ArrayList<Player> players, Grid grid) {
		this.grid=grid;
		this.giocatori= players;
	}
	
	
	/** Adds the value that identifies the player within the grid by putting him 
	   (if possible) in the column entered in input and in the lowest possible row. 
	   Returns the row where the number is placed.
       @param col column of location
       @param value value of the player to be entered in the column 
	   @param turn turn of the player who enters the value
	   @return row where the value arrived
	 */
	public int addMove(int col, int value, int turn ) {
		int row=5;

		boolean check= false;
		
		if (col<0 || col>6) {
			System.out.println("Choose a column between 0 and 6.");
			if (in.hasNextInt()) {
				addMove(in.nextInt(),value,turn);
			}
			else {
				in.next();
				System.out.println("Attention please enter a number.");
				addMove(in.nextInt(),value,turn);
			}
		}
		while (!check) {
			
			if (grid.getPositionValue(row, col)==0) {
				
				grid.setPositionValue(row, col, value);
				check=true;
				
			}
			else if (row==0) {
				System.out.println("The column is full, choose another one.");
				addMove(in.nextInt(),value,turn);
				
			}
			row--;
		}
		return row+1;
	}

	
	/** Check if in the current position the player who inserts the move wins or not.
	 	@param row row of location
        @param column column of location
	 	@param turn turn in which the move took place
	 	@return return true if the game is over, false if it is not over
	 */
	public boolean checkPosition(int row, int column, int turn) {
		
		if (turn==41) {
			System.out.println("Good game but ends in a draw.");
			return true;
		}
		int valore=grid.getPositionValue(row, column);
		for (int x=0; x<6; x++) {
			int count = 0;
			for (int y=0; y<7; y++) {
				if(grid .getPositionValue(x, y) == valore) {
					count++;
					if(count >= 4) {
						System.out.print("Well done "+giocatori.get(turn%2).getName()+" you won the game!");
						return true;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		for (int y=0; y<7; y++) {
			int count = 0;
			for (int x=0; x<6; x++) {
				if(grid.getPositionValue(x, y) == valore) {
					count++;
					if(count >= 4) {
						System.out.print("Well done "+giocatori.get(turn%2).getName()+" you won the game!");
						return true;
					}
				}
				else {
					count = 0;
				}
			}

		}
		            		
		for (int y=0; y<7; y++) {
			for (int x=0; x<6; x++) {
				int count1 = 0;
				int count2 = 0;
				for (int delta=0; delta<5; delta++) {
					
					try {
						if (grid.getPositionValue(x+delta, y+delta) == valore) {
							count1++;
						}
		                else {
		                    count1 = 0;
		                }
					}
					catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
					try {
						if (grid.getPositionValue(x+delta, y-delta) == valore) {
							count2++;
						}
		                else {
		                    count2 = 0;
		                }
					}
					catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
					
				if(count1 >= 4 || count2 >= 4) {
					System.out.print("Well done "+giocatori.get(turn%2).getName()+" you won the game!");
					return true;
				}

				}
			}
		}
		return false;
	}
}