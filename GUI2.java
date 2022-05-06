import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUI2 {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public GUI2() {
		initialize2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize2() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
