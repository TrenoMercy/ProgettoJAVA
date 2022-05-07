import java.util.ArrayList;

public class Forza4 {
	ArrayList<Player> giocatori;
	private Griglia grill;
	
	public Forza4(ArrayList<Player> players, Griglia g) {
		this.grill=g;
		this.giocatori= players;
	}
	
	/** Aggiunge il valore all'interno della griglia posizionandola (se possibile)
	 *  nella colonna inserita in input e nel punto più basso consentito
	 *  @param col colonna della griglia presa in considerazione 
	 *  @param valore valore da inserire nella colonna 
	 *  @param turno indica il turno del giocatore che inserisce la pedina*/
	public boolean addMove(int col, int valore, int turno ) {
		int i=6;
		boolean check= false;
		
		if (turno== 42) {
			return endGame(turno);
		}
		
		if (col<0 || col>6) {
			System.out.println("Scegli una colonna compresa tra 0 e 6.");
			check=true;

		}
		while (!check) {
			if (grill.getPositionValue(i, col)==0) {
				grill.setPositionValue(i, col, valore);
				grill.getGrill();
				checkPosition(i,col);//controlla la mossa inserita
				System.out.println();
				turno++;
				check=true;
				
			}
			else if (i==7) {
				System.out.println("La colonna è piena, scegline un'altra.");
				check=true;
				
			}
			i--;
		}
		return false;
	}
	
	/** Indica la fine del gioco
	 *  @param turno indica il turno in cui è finita la partita*/
	public boolean endGame(int turno) {
		if (turno==42) {
			System.out.println("Partita intensa ma è finita in parità");
		}
		else {
			System.out.print("Complimenti "+giocatori.get(turno%2)+" hai vinto la partita!");
		}
		return true;
	}
	
	/** Controlla se nella posizione corrente il giocatore che ha 
	 *  inserito la mossa ha vinto
	 *  @param i riga della griglia presa in considerazione
	 *  @param col colonna della griglia presa in considerazione
	 *  @param turno turno in cui è avvenuta la mossa*/
	public void checkPosition(int i, int col) {
		int sequenza=1;
		int valore=grill.getPositionValue(i, col);
		// Controllare se i valori vicino a valore sono uguali a valore
		// se sono uguali incremento sequenza di 1
		// se sequenza= 4 la partita è finita e chiamo il metodo endGame
		// questa funzione deve tornare un booleano
		
	}
}
