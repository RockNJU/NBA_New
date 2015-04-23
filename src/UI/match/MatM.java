package UI.match;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

public class MatM extends JPanel {

	/**
	 * Create the panel.
	 */
	public MatM() {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(64, 88, 118, 81);
		add(formattedTextField);
	}
}
