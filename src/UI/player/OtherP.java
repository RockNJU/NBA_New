package UI.player;

import javax.swing.JPanel;
import javax.swing.JButton;

public class OtherP extends JPanel {

	/**
	 * Create the panel.
	 */
	public OtherP() {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(20, 100, 173, 58);
		add(btnNewButton);
	}
}
