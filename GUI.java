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
import java.util.Scanner;
import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Font;

public class GUI {

	private JFrame frame;
	private JTextField g1Field;
	private JTextField g2Field;

	/**
	 * Launch the application.
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
		frame = new JFrame();
		frame.setBounds(100, 100, 408, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		g1Field = new JTextField();
		g1Field.setBounds(10, 75, 158, 27);
		frame.getContentPane().add(g1Field);
		g1Field.setColumns(10);
		
		JLabel g1Label = new JLabel("Giocatore 1");
		g1Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		g1Label.setBounds(215, 67, 202, 40);
		frame.getContentPane().add(g1Label);
		
		JLabel g2Label = new JLabel("Giocatore 2");
		g2Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		g2Label.setBounds(215, 146, 203, 34);
		frame.getContentPane().add(g2Label);
		
		JLabel g1LabelColore = new JLabel("");
		g1LabelColore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		g1LabelColore.setBounds(215, 97, 189, 25);
		frame.getContentPane().add(g1LabelColore);
		
		JLabel g2LabelColore = new JLabel("");
		g2LabelColore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		g2LabelColore.setBounds(215, 171, 189, 30);
		frame.getContentPane().add(g2LabelColore);
		
		JButton bottoneConfermaNomi = new JButton("Conferma Nomi");
		bottoneConfermaNomi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Richiede nomi e assegna colori
				giocatore g3 = new giocatore(g1Field.getText(), 1);
				g1Label.setText("Giocatore 1:   "+ g3.nome);
				g1LabelColore.setText("Colore assegnato: "+ g3.colore);

				giocatore g4 = new giocatore(g2Field.getText(), 2);
				g2Label.setText("Giocatore 2:   "+ g4.nome);
				g2LabelColore.setText("Colore assegnato: "+ g4.colore);
				
			}
		});
		bottoneConfermaNomi.setBounds(10, 235, 127, 37);
		frame.getContentPane().add(bottoneConfermaNomi);
		
		g2Field = new JTextField();
		g2Field.setBounds(10, 151, 158, 27);
		frame.getContentPane().add(g2Field);
		g2Field.setColumns(10);
		
		
		JButton bottoneInizioPartita = new JButton("Inizia Partita");
		bottoneInizioPartita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI2 frame2 = new GUI2();
			}
		});
		bottoneInizioPartita.setBounds(272, 235, 112, 37);
		frame.getContentPane().add(bottoneInizioPartita);
		
		JLabel lblNewLabel = new JLabel("FORZA 4");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(115, 10, 140, 47);
		frame.getContentPane().add(lblNewLabel);
		

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
