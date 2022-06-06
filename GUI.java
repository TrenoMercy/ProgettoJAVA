import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Canvas;
import java.awt.Point;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

/*
	Graphic User Interface (created with Eclipse's WindowBuilder add-on and manual coding)
*/
public class GUI {
	
	/**
	 * Attributes for the frame itself and its components.
	 */
	
	private JFrame frame;
	private JTextField g1Field;
	private JTextField g2Field;
	private JInternalFrame internalFrame;
	private JLabel lblNewLabel_1;
	private JLabel turni_label;
    private JLabel[][] slots;
    private JButton[] buttons;
    
	/**
	 * Attributes for the logic of the game, since it acts also as main.
	 */
    
    private final int xsize = 6;
    private final int ysize = 7;  
    private ArrayList<Player> players;
    private Grid grid;
    private Connect4 game;
	private int turn;
	private JTextField saveField;
	private JTextField loadField;
	
	/**
	 * Launch the application form Main.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		
		/**
		 * Creating all objects needed for the game.
		 */
		turn=0;
		players= new ArrayList<Player>();
        slots = new JLabel[xsize][ysize];
        buttons = new JButton[ysize];
		grid= new Grid();
		game= new Connect4(players,grid);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 883, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		g1Field = new JTextField();
		g1Field.setBounds(22, 121, 158, 27);
		g1Field.setColumns(10);
		
		JLabel g1Label = new JLabel("Giocatore 1");
		g1Label.setBounds(194, 111, 97, 40);
		g1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel g2Label = new JLabel("Giocatore 2");
		g2Label.setBounds(194, 167, 97, 34);
		g2Label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel g1LabelColore = new JLabel("");
		g1LabelColore.setHorizontalTextPosition(SwingConstants.CENTER);
		g1LabelColore.setHorizontalAlignment(SwingConstants.CENTER);
		g1LabelColore.setBorder(new LineBorder(Color.BLACK));
		g1LabelColore.setBounds(318, 21, 209, 30);
		g1LabelColore.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel g2LabelColore = new JLabel("");
		g2LabelColore.setHorizontalTextPosition(SwingConstants.CENTER);
		g2LabelColore.setHorizontalAlignment(SwingConstants.CENTER);
		g2LabelColore.setBorder(new LineBorder(Color.BLACK));
		g2LabelColore.setBounds(656, 21, 203, 30);
		g2LabelColore.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton bottoneConfermaNomi = new JButton("Conferma Nomi");
		bottoneConfermaNomi.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottoneConfermaNomi.setBounds(22, 225, 276, 49);
		bottoneConfermaNomi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				/**
				 * When the button is pressed, assigns names 
				 * form GUI textfields into players ArrayList
				 */
				
				String s1=g1Field.getText();
				String s2=g2Field.getText();
				if (s1.length() > 0 && s2.length() > 0) {
					players.clear();
					Player g1= new Player(s1, 1);
					players.add(g1);
					g1LabelColore.setText("G1 " + players.get(0).getName() + ", colore: 		ROSSO ");
					
					
					Player g2= new Player(s2, 2);
					players.add(g2);
					g2LabelColore.setText("G2 " + players.get(1).getName() + ", colore: 		BLU ");
				}
				else {
    				  internalFrame.setVisible(true);
    				  	lblNewLabel_1.setText("I giocatori devono avere un nome!");
				}
			}
		});
		
		g2Field = new JTextField();
		g2Field.setFont(new Font("Tahoma", Font.PLAIN, 10));
		g2Field.setBounds(22, 174, 158, 27);
		g2Field.setColumns(10);
		
		
		JButton bottoneResettaPartita = new JButton("Resetta Partita");
		bottoneResettaPartita.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottoneResettaPartita.setBounds(22, 297, 276, 49);
		bottoneResettaPartita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				resetGame();
			}
		});
		frame.getContentPane().setLayout(null);
		
		internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setForeground(Color.BLACK);
		internalFrame.setBackground(new Color(240, 240, 240));
		internalFrame.setVisible(false);
		internalFrame.setOpaque(true);
		internalFrame.setClosable(true);
		internalFrame.setBounds(149, 211, 340, 141);
		frame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 328, 102);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("FORZA 4");
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setBounds(35, 21, 226, 62);
		lblNewLabel.setFont(new Font("Source Code Pro", Font.BOLD | Font.ITALIC, 45));
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(g1Field);
		frame.getContentPane().add(g1Label);
		frame.getContentPane().add(g1LabelColore);
		frame.getContentPane().add(g2Field);
		frame.getContentPane().add(g2Label);
		frame.getContentPane().add(g2LabelColore);
		frame.getContentPane().add(bottoneConfermaNomi);
		frame.getContentPane().add(bottoneResettaPartita);
		
		JPanel panel_bottoni = new JPanel();
		panel_bottoni.setBounds(318, 513, 541, 40);
		frame.getContentPane().add(panel_bottoni);
		panel_bottoni.setLayout(new GridLayout(1, 0, 0, 0));
		
	      for (int i = 0; i < ysize; i++) {
	      buttons[i] = new JButton("" + (i + 1));
	      buttons[i].setActionCommand("" + i);
	      buttons[i].addActionListener(
	              new ActionListener() {
	                  public void actionPerformed(ActionEvent e) {
	              		
	              		/**
	              		 * When the button is pressed, adds the value that identifies the player in the grid,
	              		 * checks if the current state of the grid is final,
	              		 * updates turn count, updates GUI grid (matrix of labels),
	              		 * manages different outcome cases included in internal frame label
	              		 */
	                	  
	                	  try {
	                		  int column = Integer.parseInt(e.getActionCommand());
	                		  int row = game.addMove(column, players.get(turn%2).getNumber(), turn);
	                		  boolean ret = game.checkPosition(row, column, turn);
	                		  turn++;
	                		  turni_label.setText("Turno:" + turn);
	                		  updateBoard();
	                		  if (turn==42) {
		          				  internalFrame.setVisible(true);
		          				  	lblNewLabel_1.setText("Partita conclusa in parità");
	                		  }
	                		  else if (ret==true) {
		          				  internalFrame.setVisible(true);
		          				  	lblNewLabel_1.setText("Complimenti " + players.get(turn%2).getName()+ " hai vinto la partita!");
	                		  }
	                	  }
	                	  catch(Exception a){
	          				  internalFrame.setVisible(true);
	          				  lblNewLabel_1.setText("Errore: Conferma nomi dei giocatori \n o scegli altra colonna");
	                	  }
	                  }
	              });
	      panel_bottoni.add(buttons[i]);
	  }
		
		JPanel panel_griglia = new JPanel();
		panel_griglia.setBackground(Color.LIGHT_GRAY);
		panel_griglia.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, null, null, null));
		panel_griglia.setBounds(318, 64, 541, 439);
		frame.getContentPane().add(panel_griglia);
		panel_griglia.setLayout(new GridLayout(6, 7, 0, 0));
		
		turni_label = new JLabel("Turno: 0");
		turni_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		turni_label.setHorizontalAlignment(SwingConstants.CENTER);
		turni_label.setBounds(541, 10, 105, 41);
		frame.getContentPane().add(turni_label);
		
		JButton bottoneSalvaPartita = new JButton("Salva Partita");
		bottoneSalvaPartita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gameName = saveField.getText();
				/**
			 	When the button is pressed, saves the pending game to a file,
				manages different outcome cases included in internal frame label
				 */
				if(players.isEmpty()) {
					internalFrame.setVisible(true);
				  	lblNewLabel_1.setText("Stai salvando una partita non iniziata!");
				}
				else if (gameName.length() == 0) {
					internalFrame.setVisible(true);
				  	lblNewLabel_1.setText("Inserire il nome del file da salvare!");
				}
				else {

					LoadGame loadGame= new LoadGame(grid);
					String player1=players.get(0).getName()+players.get(0).getNumber();
					String player2=players.get(1).getName()+players.get(1).getNumber();
					loadGame.saveGame(turn,player1,player2,gameName);
					internalFrame.setVisible(true);
				  	lblNewLabel_1.setText("Partita salvata correttamente");

					}
				}
			}
		);
		bottoneSalvaPartita.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottoneSalvaPartita.setBounds(22, 378, 117, 49);
		frame.getContentPane().add(bottoneSalvaPartita);
		
		JButton bottoneCaricaPartita = new JButton("Carica Partita");
		bottoneCaricaPartita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
			 	When the button is pressed, loads teh game from a file,
			 	updates logical components of the game and the GUI components to
			 	load the games form file
				manages different outcome cases included in internal frame label
				 */
				String gameName = loadField.getText();
				
				if (gameName.length() == 0) {
					internalFrame.setVisible(true);
				  	lblNewLabel_1.setText("Inserire il nome del file da caricare!");
				}
				else {
					try {
					LoadGame loadGame= new LoadGame(gameName);

					grid= new Grid(loadGame.resumeGame());
					updateBoard();
					turn = loadGame.turnPlayer();
					String names= loadGame.namesPlayers();

					String[] s= names.split(" ");
					
					players.clear();
					Player g1= new Player(s[0].substring(0,s[0].length()-1),Integer.parseInt(s[0].substring(s[0].length()-1)));
					players.add(g1);
					
					Player g2= new Player(s[1].substring(0,s[1].length()-1),Integer.parseInt(s[1].substring(s[1].length()-1)));
					players.add(g2);
					game= new Connect4(players,grid);
					g1LabelColore.setText("G1 " + players.get(0).getName() + ", colore: 		ROSSO ");
					g2LabelColore.setText("G2 " + players.get(1).getName() + ", colore: 		BLU ");
					 turni_label.setText("Turno:" + turn);
					}
					
					catch(Exception a) {
						internalFrame.setVisible(true);
					  	lblNewLabel_1.setText("Il file non esiste! Inserire path completo o resetta partita");
					
				}

			}
			
			}});
		bottoneCaricaPartita.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottoneCaricaPartita.setBounds(22, 446, 117, 49);
		frame.getContentPane().add(bottoneCaricaPartita);
		
		saveField = new JTextField();
		saveField.setColumns(10);
		saveField.setBounds(149, 390, 149, 27);
		frame.getContentPane().add(saveField);
		
		loadField = new JTextField();
		loadField.setColumns(10);
		loadField.setBounds(149, 455, 149, 27);
		frame.getContentPane().add(loadField);
		
		/**
		Manual creation of labels' Matrix
		 */
        for (int row = 0; row < xsize; row++) {
            for (int column = 0; column < ysize; column++) {
                slots[row][column] = new JLabel();
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                slots[row][column].setBorder(new LineBorder(Color.black));
                panel_griglia.add(slots[row][column]);
            }
        }
	}

	public boolean getInternalFrameVisible() {
		return internalFrame.isVisible();
	}
	public void setInternalFrameVisible(boolean visible) {
		internalFrame.setVisible(visible);
	}
	/**
	Keeps the labels' Matrix GUI in sync with the grid logic
	 */
	  public void updateBoard() {
	  for (int row = 0; row < xsize; row++) {
	      for (int column = 0; column < ysize; column++) {
	          if (grid.getPositionValue(row, column)==1) {
	        	  slots[row][column].setOpaque(true);
	        	  slots[row][column].setBackground(Color.red);
	          }
	          if (grid.getPositionValue(row, column)==2) {
	        	  slots[row][column].setOpaque(true);
	        	  slots[row][column].setBackground(Color.yellow);
	          }
	      }
	  }
	}
	/**
	Resets the game creating a new instance of GUI's window
	 */
	public void resetGame() {
		GUI window = new GUI();
		window.frame.setVisible(true);
		frame.dispose();
	}
}