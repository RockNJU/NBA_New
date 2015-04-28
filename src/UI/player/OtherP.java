package UI.player;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

import UI.common.CreateTable;
import UI.common.History;
import UI.common.SearchHistory;

public class OtherP extends JPanel {
	CreateTable pastlist;
	String title[] = {"日期","操作"};
	Object[][] data;
	SearchHistory sh = new SearchHistory();
	ArrayList<History> ah;
	/**
	 * Create the panel.
	 */
	public OtherP() {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		ah = sh.get_player_History();
		int i = 0;
		for(History his:ah){
			data[i][0] = his.getDate();
			data[i][1] = his.getContent();
			i++;
		}

		pastlist = new CreateTable(title, data, 25, 144, 720, 460, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		pastlist.setBounds(25, 10, 720, 594);
		add(pastlist);
	}
}
