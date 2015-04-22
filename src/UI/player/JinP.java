package UI.player;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JinP extends JPanel {

	/**
	 * Create the panel.
	 */
	public JinP() {

		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(6, 178, 163, 66);
		add(rdbtnNewRadioButton);
	}
}
