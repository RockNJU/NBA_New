package UI.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTableforhot;
import UI.common.OftenUseMethod;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_Map;
import UI.common.TeamName_Map;
import UI.player.SinglePlayer;
import UI.team.SingleTeam;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;




public class HotPlayers extends JPanel {
	String saiji = "13-14";
	ArrayList<SingleMatchPersonalDataVO> smpd;
	ArrayList<PlayerSeasonDataVO> psdv;
	String according;
	String type;
	//RMIObject rmi = new RMIObject();
	MatchBLService mbs = init.rmi.getMatchObject();
	PlayerBLService pbs = init.rmi.getPlayerObject();
	String[] title = {"名称","球队","球号","位置",according,"肖像"};
	Object [][] data=new Object[5][5];
	
	SortItem_Map map1 = new SortItem_Map();
	TeamName_Map map3 = new TeamName_Map();	
	PlayerPosition_Map map4 = new PlayerPosition_Map();	

	/**
	 * Create the panel.
	 */
	public HotPlayers(String tmpsaccording,String tmptype) {
		String str=init.currentpanel;//="hot&"+"每日,得分总;球队赛季,得分"
		String s1[]=str.split("&");
		String s2[]=s1[1].split(";");
		s2[0]=tmpsaccording+","+tmptype;
		init.currentpanel=s1[0]+"&"+s2[0]+";"+s2[1];
		System.out.println(init.currentpanel);
		if(tmpsaccording.equals("每日")){
			smpd = mbs.getTodayHotPlayer(map1.getItem(tmptype));
			int i = 0;
			for(SingleMatchPersonalDataVO temp:smpd){
				data[i][0]= temp.getPlayerName();		
				System.out.println(data[i][0]);
				data[i][1]= temp.getPlayerReverseName();
				data[i][2]= temp.getPlayerPosition();
				data[i][3]= map3.getFullName(temp.getTeamName());
				//对应项得分
				if(tmptype.equals("得分总")){
					data[i][4]= Integer.toString(temp.getPointNum());
				}
				else if(tmptype.equals("篮板数")){
					data[i][4]= Integer.toString(temp.getReboundNum());
				}
				else if(tmptype.equals("助攻数")){
					data[i][4]= Integer.toString(temp.getAssistNum());
				}
				else if(tmptype.equals("抢断数")){
					data[i][4]= Integer.toString(temp.getStealNum());
				}
				else if(tmptype.equals("盖帽数")){
					data[i][4]= Integer.toString(temp.getBlockNum());
				}
				else{
					data[i][4] = -1;
				}
				
				i++;
			    }
			

			}
		else if(tmpsaccording.equals("赛季")){
			psdv = pbs.getSeasonHotPlayer("13-14",map1.getItem(tmptype));
			
			int i = 0;
			for(PlayerSeasonDataVO temp:psdv){
				data[i][0]= temp.getName();					
				data[i][1]= temp.getInfo().getBirth();
				data[i][2]= temp.getPosition();
				data[i][3]= map3.getFullName( temp.getTeamName());
				//对应项得分
				if(tmptype.equals("得分")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getPointNum_avg()));
				}
				else if(tmptype.equals("篮板")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getReboundNum_avg()));
				}
				else if(tmptype.equals("助攻")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getAssistNum_avg()));
				}
				else if(tmptype.equals("抢断")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getStealNum_avg()));
				}
				else if(tmptype.equals("盖帽")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getBlockNum_avg()));
				}
				else if(tmptype.equals("三分命中率")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getT_shootPercentage()));
				}
				else if(tmptype.equals("投篮命中率")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getShootPercentage()));
				}
				else if(tmptype.equals("罚球命中率")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getFreeThrowPercentage()));
				}
				else{
					data[i][4] = -1;
				}
				
				i++;
			    }

		}
		else{
			psdv = pbs.getMost_Progress_Player(map1.getItem(tmptype));
			
			int i = 0;
			for(PlayerSeasonDataVO temp:psdv){
				data[i][0]= temp.getName();					
				data[i][1]= temp.getInfo().getBirth();
				data[i][2]= temp.getPosition();
				data[i][3]= map3.getFullName( temp.getTeamName());
				//对应项得分
				if(tmptype.equals("得分")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getPointNum_avg()));
				}
				else if(tmptype.equals("篮板")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getReboundNum_avg()));
				}
				else if(tmptype.equals("助攻")){
					data[i][4]= Double.toString(OftenUseMethod.changedouble(temp.getAssistNum_avg()));
				}
				else{
					data[i][4] = -1;
				}
				i++;
			    }
			

			
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
		
		No1_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String season = "13-14";
					String name = (String) data[0][0];
					// System.out.println(name);
					init.currentdio="4(1)&"+name+";"+season;
					SinglePlayer spi = new SinglePlayer(name, season);
					spi.setVisible(true);
					spi.setLocation(375, 58);
				}
			}
		});
		
		JLabel No1_name = new JLabel((String)data[0][0]);
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(189, 20, 180, 36);
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
		No1_Player1.setImage(No1_Player1.getImage().getScaledInstance(48, 39,Image.SCALE_DEFAULT)); 		
		JLabel No1_p1 = new JLabel(No1_Player1);		
		No1_p1.setSize(35, 35);
		No1_p1.setLocation(353, 14);
		No1_p.setBounds(4, 25, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p1);
		
		ImageIcon No1_Player2 = new ImageIcon("pic/portrait/"+data[2][0]+".png");
		No1_Player2.setImage(No1_Player2.getImage().getScaledInstance(48, 39,Image.SCALE_DEFAULT)); 		
		JLabel label = new JLabel(No1_Player2);
		label.setBounds(353, 52, 35, 35);
		add(label);
		
		ImageIcon No1_Player3 = new ImageIcon("pic/portrait/"+data[3][0]+".png");
		No1_Player3.setImage(No1_Player3.getImage().getScaledInstance(48, 39,Image.SCALE_DEFAULT)); 		
		JLabel label_1 = new JLabel(No1_Player3);
		label_1.setBounds(353, 89, 35, 35);
		add(label_1);
		
		ImageIcon No1_Player4 = new ImageIcon("pic/portrait/"+data[4][0]+".png");
		No1_Player4.setImage(No1_Player4.getImage().getScaledInstance(48, 39,Image.SCALE_DEFAULT)); 		
		JLabel label_2 = new JLabel(No1_Player4);
		label_2.setBounds(353, 126, 35, 35);
		add(label_2);
		
		final CreateTableforhot ctfh = new CreateTableforhot(title,data,
				381, 12,395, 150, 37,37, 6,
				new Font("华康雅宋体W9(P)", Font.PLAIN, 14), new Font("华康雅宋体W9(P)", Font.PLAIN, 14),15, 15);
		FitTableColumns(ctfh.getTable());
		add(ctfh);
		
		ctfh.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && ctfh.getSelectedRow() != -1) {
					String name = ctfh.getValueAt(
							ctfh.getSelectedRow(), 0);
					SinglePlayer spi;
					try {
						init.currentdio="4(1)&"+name+";"+saiji;
						spi = new SinglePlayer(name, saiji);
						spi.setVisible(true);
						spi.setLocation(375, 58);
					} catch (TransformerFactoryConfigurationError e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}
		});
		
		


		
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
	public void FitTableColumns(JTable myTable){
		  JTableHeader header = myTable.getTableHeader();
		     int rowCount = myTable.getRowCount();
		     Enumeration columns = myTable.getColumnModel().getColumns();
		     while(columns.hasMoreElements()){
		         TableColumn column = (TableColumn)columns.nextElement();
		         int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
		         int width = (int)myTable.getTableHeader().getDefaultRenderer()
		                 .getTableCellRendererComponent(myTable, column.getIdentifier()
		                         , false, false, -1, col).getPreferredSize().getWidth();
		         for(int row = 0; row<rowCount; row++){
		             int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
		               myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
		             width = Math.max(width, preferedWidth);
		         }
		         header.setResizingColumn(column); // 此行很重要
		         column.setWidth(width+myTable.getIntercellSpacing().width);
		     }
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
