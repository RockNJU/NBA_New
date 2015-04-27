package UI.main;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import businessService.blservice.MatchBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTableforhot;
import UI.common.SortItem_Map;
import VO.SingleMatchPersonalDataVO;




public class HotPlayers extends JPanel {
	
	ArrayList<SingleMatchPersonalDataVO> smpd;
	String according;
	String type;
	RMIObject rmi = new RMIObject();
	MatchBLService mbs = rmi.getMatchObject();;
	String[] title = {"名称","球队","球号","位置",according,"肖像"};
	Object [][] data=new Object[4][5];
	SortItem_Map map = new SortItem_Map();

	/**
	 * Create the panel.
	 */
	public HotPlayers(String tmpsaccording,String tmptype) {
		if(tmpsaccording.equals("每日")){
			smpd = mbs.getTodayHotPlayer(map.getItem(tmptype));
			

			int i = 0;
			for(SingleMatchPersonalDataVO temp:smpd){
				data[i][0]= temp.getPlayerName();					
				data[i][1]= temp.getPlayerReverseName();
				data[i][2]= temp.getPlayerPosition();
				data[i][3]= temp.getTeamName();
				//对应项得分
				if(tmptype.equals("得分")){
					data[i][4]= temp.getPoints();
				}
				if(tmptype.equals("篮板")){
					data[i][4]= temp.getReboundNum();
				}
				if(tmptype.equals("助攻")){
					data[i][4]= temp.getAssistNum();
				}
				if(tmptype.equals("抢断")){
					data[i][4]= temp.getStealNum();
				}
				if(tmptype.equals("盖帽")){
					data[i][4]= temp.getBlockNum();
				}
				
				i++;
			    }
			
			String[] title = {"名称","球队","球号","位置",tmptype,"肖像"};
			CreateTableforhot ctfh = new CreateTableforhot(title,data,
					381, 12,409, 150, 37,37, 6,
					new Font("华康雅宋体W9(P)", Font.PLAIN, 14), new Font("华康雅宋体W9(P)", Font.PLAIN, 14),15, 15);
			add(ctfh);
			
			}
		else if(tmptype.equals("赛季")){
			
		}
		else{
			
		}
		
	
		
		this.according=tmpsaccording;
		this.type=tmptype;

		setLayout(null);
		setOpaque(false);
		setSize(746,170);
		
		ImageIcon No1_Player = new ImageIcon("pic/portrait/"+data[0][0]+".png");
		No1_Player.setImage(No1_Player.getImage().getScaledInstance(160, 130,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Player);		
		No1_p.setBounds(4, 25, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		JLabel No1_name = new JLabel((String)data[0][0]);
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(189, 20, 137, 36);
		add(No1_name);
		
		JLabel No1_team = new JLabel((String)data[0][3]);
		No1_team.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_team.setBounds(189, 61, 85, 15);
		add(No1_team);
		
		JLabel No1_num_positon = new JLabel((String)data[0][2]);
		No1_num_positon.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_num_positon.setBounds(189, 85, 85, 15);
		add(No1_num_positon);
		
		JLabel No1_info = new JLabel((String)data[0][4]);
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 28));
		No1_info.setBounds(217, 110, 85, 50);
		add(No1_info);
		
		ImageIcon No1_Player1 = new ImageIcon("pic/portrait/"+data[1][0]+".png");
		No1_Player1.setImage(No1_Player.getImage().getScaledInstance(64, 52,Image.SCALE_DEFAULT)); 		
		JLabel No1_p1 = new JLabel(No1_Player1);		
		No1_p1.setSize(35, 35);
		No1_p1.setLocation(353, 14);
		No1_p.setBounds(4, 25, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p1);
		
		ImageIcon No1_Player2 = new ImageIcon("pic/portrait/"+data[2][0]+".png");
		No1_Player2.setImage(No1_Player.getImage().getScaledInstance(64, 52,Image.SCALE_DEFAULT)); 		
		JLabel label = new JLabel(No1_Player2);
		label.setBounds(353, 52, 35, 35);
		add(label);
		
		ImageIcon No1_Player3 = new ImageIcon("pic/portrait/"+data[3][0]+".png");
		No1_Player3.setImage(No1_Player.getImage().getScaledInstance(64, 52,Image.SCALE_DEFAULT)); 		
		JLabel label_1 = new JLabel(No1_Player3);
		label_1.setBounds(353, 89, 35, 35);
		add(label_1);
		
		ImageIcon No1_Player4 = new ImageIcon("pic/portrait/"+data[4][0]+".png");
		No1_Player4.setImage(No1_Player.getImage().getScaledInstance(64, 52,Image.SCALE_DEFAULT)); 		
		JLabel label_2 = new JLabel(No1_Player4);
		label_2.setBounds(353, 126, 35, 35);
		add(label_2);
		
		CreateTableforhot ctfh = new CreateTableforhot(title,data,
				381, 12,409, 150, 37,37, 6,
				new Font("华康雅宋体W9(P)", Font.PLAIN, 14), new Font("华康雅宋体W9(P)", Font.PLAIN, 14),15, 15);
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

	/*
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
	*/
}
