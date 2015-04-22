package UI.player;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

public class MatP extends JPanel {

	/**
	 * Create the panel.
	 */
	public MatP() {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(64, 88, 118, 81);
		add(formattedTextField);
	}
}
