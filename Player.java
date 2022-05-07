
public class Player {
	private String name;
	private int number;
	
	/** @param nome indica il nome del giocatore
	 *  @param n indica il valore che è stato assegnato al giocatore*/
	public Player(String nome, int n) {
		this.name=nome;
		this.number=n;
	}
	
	/** Indica il nome del giocatore
	 *  @return nome del giocatore*/
	public String getName() {
		return name;
	}
	
	/** Indica il numero assegnato al giocatore
	 *  @return il numero del giocatore*/
	public int getNumber() {
		return number;
	}
}
