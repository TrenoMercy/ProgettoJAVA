import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 	LoadGame allows you to suspend a game by giving it a name 
 	and gives you the possibility to resume it.
 */
public class LoadGame {
	
		private Grid grid;
		private String pathFileName;
		
		Scanner in= new Scanner(System.in);
		
		/**
		 	Construct an existing game to memorize.
		 	@param g grid to edit
		 */
		public LoadGame(Grid g) {
			
			this.grid=g;
		}
		
		/**
		 	Construct a new grid to edit for the game pending.
		 	@param pathFileName path of the file of the game to be resumed
		 */
		public LoadGame(String pathFileName) {
				grid= new Grid();
				this.pathFileName=pathFileName;		
		}
		
		/**
		 	Save the pending game to a file.
		 	@param turn turn in which the game was interrupted
		 	@param player1 first player
		 	@param player2 second player
		 */
		public void saveGame(int turn,String player1, String player2, String gameName) {
			grid.getGrid();

			
			try (PrintWriter out= new PrintWriter(new File(gameName+".txt"))){
				for (int row=0; row<6; row++) {
					for (int column=0; column<7; column++) {
						out.append(Integer.toString(grid.getPositionValue(row, column)).charAt(0));
					}
				}
				out.append(";"+Integer.toString(turn)+";"+player1+";"+player2);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 	Resume a game on hold to continue it.
		 	@return grid of the suspended match
		 */
		public Grid resumeGame() {
			
		    int i=0;
		    try {
		    	Scanner in = new Scanner(new File(pathFileName));
		    	String game=in.next();
		    	for (int row=0; row<6; row++) {
					for (int column=0; column<7; column++) {
						char charValue= game.charAt(i);
						grid.setPositionValue(row, column,Character.getNumericValue(charValue));
						i++;
					}
		    	}
		      } 
		      catch (FileNotFoundException e){
		    	  
		         e.printStackTrace();
		         System.out.println("The syntax of the file, directory, or volume name is incorrect.");
		      }
	
			return grid;
		}
		
		/**
		 	Resume the turn in which the game was interrupted.
		 	@return turn from which to resume the game
		 */
		public int turnPlayer() {
			int turn;
			try {
				Scanner in = new Scanner(new File(pathFileName));
				String game=in.next();
				String[] splitString= game.split(";");
				String turnString=splitString[1];
				turn= Integer.parseInt(turnString);
			}
			catch (FileNotFoundException e){
				e.printStackTrace();
		        System.out.println("The syntax of the file, directory, or volume name is incorrect.");
		        return -1;
			}
			return turn;
		}
		/**
		 	Resumes the names of the players of the match.
		 	@return the names of players
		 */
		public String namesPlayers() {
			
			String playersString;
			
			try (Scanner in = new Scanner(new File(pathFileName))){
				String game=in.next();
				String[] splitString= game.split(";");
				playersString=splitString[2]+" "+splitString[3];
			}
			catch (FileNotFoundException e){
				e.printStackTrace();
		        System.out.println("The syntax of the file, directory, or volume name is incorrect.");
		        return null;
			}
			return playersString;
		}
}
