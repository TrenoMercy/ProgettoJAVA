import java.util.Scanner;
import java.util.ArrayList;
public class Partita{
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		ArrayList<Player> giocatori= new ArrayList<Player>();
		
		System.out.println("Inserisci il nome del primo giocatore:");
		Player g1= new Player(in.next(),0);
		giocatori.add(g1);
		
		System.out.println("Inserisci il nome del secondo giocatore");
		Player g2= new Player(in.next(),1);
		giocatori.add(g2);
		
		Griglia grill= new Griglia();
		grill.getGrill();
		
		Forza4 game= new Forza4(giocatori,grill);
		
		boolean check= false;
		int turno=0;
		while (!check) {
			System.out.print(giocatori.get(turno%2)+" fai la tua mossa, scegli la colonna(tra 0 e 6) in cui inserire la pedina");
			check= game.addMove(in.nextInt(), giocatori.get(turno%2).getNumber(), turno);
			
		}
	}
}