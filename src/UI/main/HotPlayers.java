package UI.main;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import UI.common.CreateTableforhot;




public class HotPlayers extends JPanel {
	
	ArrayList<String> players;
	String according;
	String type;
	
	/**
	 * Create the panel.
	 */
	public HotPlayers(ArrayList<String> tmps,String tmpsaccording,String tmptype) {
		this.players=tmps;
		this.according=tmpsaccording;
		this.type=tmptype;
		String[] title = {"肖像","名称","球队","球号","位置",according};
		Object[][] data = {{"pic/portrait/Aaron Brooks.png","a","b","c","d",tmptype},
				{"pic/portrait/Aaron Gray.png","e","f","a","s",tmptype}
		};
		setLayout(null);
		setOpaque(false);
		setSize(746,170);
		
		ImageIcon No1_Player = new ImageIcon("pic/portrait/Aaron Brooks.png");
		No1_Player.setImage(No1_Player.getImage().getScaledInstance(160, 130,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Player);		
		No1_p.setBounds(4, 25, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		JLabel No1_name = new JLabel("\u7B2C\u4E00\u540D");
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(189, 20, 137, 36);
		add(No1_name);
		
		JLabel No1_team = new JLabel("\u6240\u5C5E\u7403\u961F");
		No1_team.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_team.setBounds(189, 61, 85, 15);
		add(No1_team);
		
		JLabel No1_num_positon = new JLabel("\u7403\u53F7\u548C\u4F4D\u7F6E");
		No1_num_positon.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_num_positon.setBounds(189, 85, 85, 15);
		add(No1_num_positon);
		
		JLabel No1_info = new JLabel("\u4F9D\u636E\u5F97\u5206");
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 28));
		No1_info.setBounds(217, 110, 85, 50);
		add(No1_info);
		
		CreateTableforhot ctfh = new CreateTableforhot(title,data,
				351, 12,390, 150, 37,37, 6,
				new Font("华康雅宋体W9(P)", Font.PLAIN, 14), new Font("华康雅宋体W9(P)", Font.PLAIN, 14),37, 37);
		add(ctfh);
		/**
		JScrollPane scrollPane = new JScrollPane();
        add(scrollPane);
        scrollPane.setBounds(346, 10, 390, 150);
		list = new JList();
		//list.setLocation(346, 10);
		//list.setSize(390, 38);
	    list.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	    //序号、球员的照片、球员的姓名、球号、位置、所属球队、对应项得分
	    Object[][] data=getdata(); 
		list.setListData(data);
        ListCellRenderer renderer = new ImageListCellRenderer();
        list.setCellRenderer(renderer);
        scrollPane.setViewportView(list);
        */
	}

	
	@SuppressWarnings("null")
	private Object[][] getdata(){
		Object[][] re=new Object[4][5];
		for(int i=0;i<4;i++){
			re[i][0]="i+1";
			ImageIcon ddd = new ImageIcon("pic/portrait/"+players.get(i+1)+".png");
			ddd.setImage(ddd.getImage().getScaledInstance(47, 38,Image.SCALE_DEFAULT)); 					
		    re[i][1]=ddd;
		    re[i][2]="位置";
		    re[i][3]="所属球队";
		    re[i][4]="对应项得分";
		}
		 
		
		
		return re;
		
	}
	
}
