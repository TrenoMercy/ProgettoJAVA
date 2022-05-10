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
				checkPosition(i,col,turno);//controlla la mossa inserita
				System.out.println();
				turno++;
				check=true;
				
			}
			else if (i==7) {
				System.out.println("La colonna Ã¨ piena, scegline un'altra.");
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
			System.out.println("Partita intensa ma Ã¨ finita in paritÃ ");
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
	
	public boolean checkPosition(int i, int col, int turno) {
		int valore=grill.getPositionValue(i, col);
		// Controllare se i valori vicino a valore sono uguali a valore
		// se sono uguali incremento count di 1
		// se count=4 la partita è finita e chiamo il metodo endGame
		// questa funzione deve tornare un booleano
		
		// Controllo orizzontale
		for (int x=0; x<6; x++) {
			int count = 0;
			for (int y=0; y<7; y++) {
				if(grill.getPositionValue(x, y) == valore) {
					count++;
				}
				else {
					count = 0;
				}
			}
			if(count >= 4) {				
				return endGame(turno);
			}
		}
		
		// Controllo verticale
		for (int y=0; y<7; y++) {
			int count = 0;
			for (int x=0; x<6; x++) {
				if(grill.getPositionValue(x, y) == valore) {
					count++;
				}
				else {
					count = 0;
				}
			}
			if(count >= 4) {
				return endGame(turno);
			}
		}
		
		// Controllo diagonale	            		
		for (int y=0; y<7; y++) {
			for (int x=0; x<6; x++) {
				int count1 = 0;
				int count2 = 0;
				for (int delta=0; delta<5; delta++) {
					
					// Controllo diagonale
					try {
						if (grill.getPositionValue(x+delta, y+delta) == valore) {
							count1++;
						}
		                else {
		                    count1 = 0;
		                }
					}
					finally {}
					
					// Controllo contro-diagonale
					try {
						if (grill.getPositionValue(x+delta, y-delta) == valore) {
							count2++;
						}
		                else {
		                    count2 = 0;
		                }
					}
					finally {}
					
				if(count1 >= 4 || count2 >= 4) {
					return endGame(turno);
				}

				}
			}
		}
		return false;
	}
}

