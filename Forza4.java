import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Forza4 {
	ArrayList<Player> giocatori;
	private Griglia grill;
	Scanner in= new Scanner(System.in);
	
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
		int i=5;
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
				if (checkPosition(i,col,turno) == true){
					return true;
				}
				System.out.println();
				
				check=true;
				
			}
			else if (i==0) {
				System.out.println("La colonna è piena, scegline un'altra.");
				return addMove(in.nextInt(),valore,turno);
				
			}
			i--;
		}
		return false;
	}
	
	/** Indica la fine del gioco
	 *  @param turno indica il turno in cui è finita la partita*/
	public boolean endGame(int turno) {
		if (turno==42) {
			System.out.println("Partita intensa ma è finita in parità ");
		}
		else {
			System.out.print("Complimenti "+giocatori.get(turno%2).getName()+" hai vinto la partita!");
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
		// se count=4 la partita � finita e chiamo il metodo endGame
		// questa funzione deve tornare un booleano
		
		// Controllo orizzontale
		for (int x=0; x<6; x++) {
			int count = 0;
			for (int y=0; y<7; y++) {
				if(grill.getPositionValue(x, y) == valore) {
					count++;
					if(count >= 4) {				
						return endGame(turno);
					}
				}
				else {
					count = 0;
				}
			}
//			System.out.println("count:"+ count);
		}
		
		// Controllo verticale
		for (int y=0; y<7; y++) {
			int count = 0;
			for (int x=0; x<6; x++) {
				if(grill.getPositionValue(x, y) == valore) {
					count++;
					if(count >= 4) {
						return endGame(turno);
					}
				}
				else {
					count = 0;
				}
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
					catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
					// Controllo contro-diagonale
					try {
						if (grill.getPositionValue(x+delta, y-delta) == valore) {
							count2++;
						}
		                else {
		                    count2 = 0;
		                }
					}
					catch (ArrayIndexOutOfBoundsException e) {
						
					}
					
					
				if(count1 >= 4 || count2 >= 4) {
					return endGame(turno);
				}

				}
			}
		}
		return false;
	}
	
	
	/** Permette di continuare una partita ottenendo i dati della
	 *  partita precedente da un file txt
	 *  */
    public void getGame(String fileName) {
    	String path = System.getProperty("user.home").replace("\\", "\\\\") + "\\";
        String fullPath = path + fileName;
        	
        try {
            File file = new File(fullPath);
            Scanner sc = new Scanner(file);
            
            Player g3= new Player(sc.nextLine(), Integer.parseInt(sc.nextLine()));
            Player g4= new Player(sc.nextLine(), Integer.parseInt(sc.nextLine()));
            giocatori.set(0,g3);
            giocatori.set(1,g4);

    		for (int i=0; i<6; i++) {    			   	
    			for (int j=0; j<7; j++) {
    				grill.setPositionValue(i, j, Integer.parseInt(sc.nextLine()));
    			}
    		}
    		sc.close();
    		
        } catch (NumberFormatException e) {} 
          catch (FileNotFoundException e) {
        	  System.out.println("File non trovato");
        }


    }
    
	/** Permette di salvare una partita scrivendo i dati della
	 *  partita corrente su un file txt
	 *  */
    public void saveGame(String fileName) {
    	String path = System.getProperty("user.home").replace("\\", "\\\\") + "\\";
        PrintWriter out = null;

        try {
            out = new PrintWriter(path + fileName, "UTF-8");
            out.println(giocatori.get(0).getNumber());
            out.println(giocatori.get(0).getName());
            
            out.println(giocatori.get(1).getNumber());
            out.println(giocatori.get(1).getName());           

    		for (int i=0; i<6; i++) {    			   	
    			for (int j=0; j<7; j++) {
    				out.println(grill.getPositionValue(i, j));
    			}
    		}
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

