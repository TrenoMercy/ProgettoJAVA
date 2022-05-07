/**Griglia*/

public class Griglia {
	
	private int [][] grill;
	
	public Griglia() {
		grill= new int[6][7];
	}
	
	/** Stampa a video lo stato attuale della griglia aggiornata*/
	
	public void getGrill() {
		for (int i=0; i<6; i++) {
			for (int j=0; j<7; j++) {
				if (j==6) {
					System.out.print("| "+grill[i][j]+" |");
				}
				else {
					System.out.print("| "+grill[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	
	/**Ritorna il valore che si trova nella griglia in posizione [i][col]
	 * @param i riga della griglia presa in considerazione 
	 * @param col colonna della griglia presa in considerazione
	 * @return valore che si trova nella griglia in posizione [i][col]*/
	public int getPositionValue(int i, int col){
		return grill[i][col];
	}
	
	/**Imposta il valore preso in input in posizione [i][col] all'interno della griglia
	 * @param i riga della griglia presa in considerazione 
	 * @param col colonna della griglia presa in considerazione 
	 * @param value valore da inserire in posizione [i][col]*/
	
	public void setPositionValue(int i, int col, int value) {
		grill[i][col]=value;
	}
}
