package UI.team;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.common.CreateTable;
import UI.common.History;
import UI.common.SearchHistory;

public class OtherT extends JPanel {
	CreateTable pastlist;
	String title[] = {"                           日期                                          ","        "
			+ "                                 操作                                               "};

	SearchHistory sh = new SearchHistory();
	ArrayList<History> ah;
	/**
	 * Create the panel.
	 */
	public OtherT() {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		ah = sh.get_team_History();
		int i = 0;
		Object[][] data = new Object[ah.size()][2];
		for(History his:ah){
			data[i][0] = his.getDate();
			data[i][1] = his.getContent();
			i++;
		}
		JLabel lblNewLabel = new JLabel("\u8FC7\u5F80\u67E5\u8BE2\uFF1A");
		lblNewLabel.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		lblNewLabel.setBounds(25, 10, 119, 38);
		add(lblNewLabel);
		pastlist = new CreateTable(title, data, 25, 40, 720, 460, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		//pastlist.setBounds(25, 10, 720, 594);
		add(pastlist);
	}

}
