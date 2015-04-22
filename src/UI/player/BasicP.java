package UI.player;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

public class BasicP extends JPanel {

	/**
	 * Create the panel.
	 */
	public BasicP(String name,String season) {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		BasicInfo panel = new BasicInfo(name,season);
		panel.setLocation(80, 10);
		panel.setSize(582,474);
		add(panel);
	}
}
