import java.util.Scanner;
import java.util.ArrayList;

public class Connect4Tester{
	
	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		ArrayList<Player> players= new ArrayList<Player>();
		Grid grid;
		int turn;
		
		System.out.println("Enter 1 if you want to resume a pending game,anything else to start a new game:");
		if (in.hasNextInt()&& in.nextInt()==1) {
			System.out.println("Insert the filepath:");
			
		    String fileName = in.next();
			LoadGame loadGame= new LoadGame(fileName);
			System.out.println("loadGame ok");
			
			grid= new Grid(loadGame.resumeGame());
			System.out.println("resumeGame ok");
			
			turn=loadGame.turnPlayer();
			System.out.println("turnPlayer ok: "+turn);
			
			String names= loadGame.namesPlayers();
			System.out.println("namesPlayers ok: "+names);
			
			String[] s= names.split(" ");
		
			Player g1= new Player(s[0].substring(0,s[0].length()-1),Integer.parseInt(s[0].substring(s[0].length()-1)));
			players.add(g1);
			
			Player g2= new Player(s[1].substring(0,s[1].length()-1),Integer.parseInt(s[1].substring(s[1].length()-1)));
			players.add(g2);
			
		}
		else {
			in.next();
			System.out.println("Enter the name of the first player:");
			Player g1= new Player(in.next(),1);
			players.add(g1);
			
			System.out.println("Enter the name of the second player:");
			Player g2= new Player(in.next(),2);
			players.add(g2);
			
			grid= new Grid();
			turn=0;
		}
		grid.getGrid();
		System.out.println(players.get(0).getName());
		System.out.println(players.get(1).getName());
		Connect4 game= new Connect4(players,grid);
		
		boolean check= false;
	
		while (!check) {
			System.out.println("turn: "+turn);
			System.out.print(players.get(turn%2).getName()+" make your move, choose the column (between 0 and 6) in which to insert the number (-1 to suspend the game):\n");
			if (in.hasNextInt()) { 
				int column=in.nextInt();
				if (column!= -1) {
					int row=game.addMove(column, players.get(turn%2).getNumber(), turn);
					grid.getGrid();
					check=game.checkPosition(row,column, turn);
					System.out.println();
					turn++;
				}
				else {
					LoadGame loadGame= new LoadGame(grid);
					String player1=players.get(0).getName()+players.get(0).getNumber();
					String player2=players.get(1).getName()+players.get(1).getNumber();
					
					System.out.println("You have suspended the game, enter the name with which you want to save it.");
					String gameName= in.next();
					
					loadGame.saveGame(turn,player1,player2,gameName);
					check=true;
				}
			}
			else {
				in.next();
				System.out.println("Attention please enter a number.");
			}
		}
		in.close();
	}
}