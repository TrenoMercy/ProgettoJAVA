import java.util.Scanner;

public class main {

	static boolean partita_conclusa = false; //condizione di conclusione della partita
	static int n_turno = 0; //turni totali
	static int turno_del_giocatore; // turno di quale giocatore
	
//	
//	MAIN
//	
	
	public static void main(String[] args) {
		
		System.out.println("Inizializzazione Partita");
		inizzializza_partita(); // Richiede nomi e assegna colori	
		
		//	INIZIO PARTITA	
		
		System.out.println("----------------");
		System.out.println("Partita Iniziata");
		System.out.println("----------------");
		
		// ciclo in cui si alternano i turni
		while (!partita_conclusa) {
			n_turno ++;			
			turno_del_giocatore = (n_turno % 2) +1;
					
			System.out.println("n_turno:" + n_turno);
			System.out.println("turno_del_giocatore:" +turno_del_giocatore);
			
			valida_input();
			processa_turno();
			
			
			// PORTARE QUESTO METODO IN CLASS GRIGLIA?
			check_partita_conclusa();

			}
		}
		
		
//	
//	METODI
//	
	
	//metodo per controllare se la partita è conclusa
	static public void check_partita_conclusa() {
		
		//partita_conclusa in caso di parità (tutte le caselle sono piene e non c'è un vincitore)
		if (n_turno == 42) {
			partita_conclusa = true;
		}
		
		//partita_conclusa in caso...
	}
	
	
	static public void inizzializza_partita() {
		// Richiede nomi e assegna colori
		Scanner in = new Scanner(System.in);
		System.out.println("Inserire nome Giocatore 1");
		giocatore g1 = new giocatore(in.next(), 1);
		System.out.println("Giocatore1:" + g1.nome);
		
		System.out.println("Inserire nome Giocatore 2");
		giocatore g2 = new giocatore(in.next(), 2);
		System.out.println("Giocatore2:" + g2.nome);
		
	}
	
	static public void valida_input() {
		
		int value=100;
		do

		{
		Scanner in = new Scanner(System.in);
		System.out.print("Inserisci colonna da 0 a 6: ");
		if(in.hasNextInt()) {
			value = in.nextInt();
		}
//		value = in.next();

		}

		while (value < 0 || value > 6);
		
	}
	
	static public void processa_turno() {
		
	}
}
