package UI.main;

import java.awt.*;
import java.util.*;

import javax.swing.*;


public class HotTeams extends JPanel {
	String type;
	String according;
	/**
	 * Create the panel.
	 */
	public HotTeams(String tmpsaccording,String tmptype) {{
		this.according=tmpsaccording;
		this.type=tmptype;
		setLayout(null);
		setOpaque(false);
		setSize(746,170);
		
		ImageIcon No1_Team = new ImageIcon("pic/TEAMPNG/ATL.png");
		No1_Team.setImage(No1_Team.getImage().getScaledInstance(158, 158,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Team);		
		No1_p.setBounds(4, 25, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		JLabel No1_name = new JLabel("\u7B2C\u4E00\u540D");
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(189, 20, 137, 36);
		add(No1_name);
		
		JLabel No1_part = new JLabel("\u6240\u5C5E\u8054\u76DF");
		No1_part.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_part.setBounds(189, 61, 85, 15);
		add(No1_part);
		
		JLabel No1_time = new JLabel("\u5EFA\u7ACB\u65F6\u95F4");
		No1_time.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_time.setBounds(189, 85, 85, 15);
		add(No1_time);
		
		JLabel No1_info = new JLabel("\u4F9D\u636E\u5F97\u5206");
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 28));
		No1_info.setBounds(217, 110, 85, 50);
		add(No1_info);
	}

	}
	}
