package UI.match;

import javax.swing.*;
import java.awt.*;

public class BasicM extends JPanel {

	/**
	 * Create the panel.
	 */
	public BasicM(String name, String season) {
		setSize(760, 500);
		setLayout(null);
		setOpaque(false);

		
		
		
		
		/**
		 * ±³¾°Í¼Æ¬
		 */

		ImageIcon image = new ImageIcon("pic/±ÈÈü.jpg");
		image.setImage(image.getImage().getScaledInstance(582, 474,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(80, 10, 582, 474);		
		photo.setOpaque(false);
		add(photo);
	}
}
