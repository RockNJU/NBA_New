package UI.match;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JinM extends JPanel {

	/**
	 * Create the panel.
	 */
	public JinM() {

		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 178, 163, 66);
		add(rdbtnNewRadioButton);
	}
}
