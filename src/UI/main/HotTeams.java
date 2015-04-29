package UI.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTableforhot;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_Map;
import UI.common.TeamName_Map;
import UI.player.SinglePlayer;
import UI.team.SingleTeam;
import VO.SingleMatchPersonalDataVO;
import VO.TeamSeasonDataVO;


public class HotTeams extends JPanel {
	SortItem_Map map1 = new SortItem_Map();
	TeamName_Map map3 = new TeamName_Map();	
	PlayerPosition_Map map4 = new PlayerPosition_Map();	
	PartitionMap map5 = new PartitionMap();	
	Object [][] data=new Object[5][5];
	String type;
	String according;
	ArrayList<TeamSeasonDataVO> tsdv;
	
	String saiji = "13-14";
	//RMIObject rmi = new RMIObject();
	TeamBLService tbs = init.rmi.getTeamObject();
	/**
	 * Create the panel.
	 */
	public HotTeams(String tmpsaccording,String tmptype) {{
		this.according=tmpsaccording;
		this.type=tmptype;
		setLayout(null);
		setOpaque(false);
		setSize(746,170);
		
		tsdv = tbs.getHotTeam(saiji,map1.getItem(tmptype));
		
		int i = 0;
		for(TeamSeasonDataVO temp:tsdv){
			data[i][0]= map3.getFullName(temp.getTeamName());
			data[i][1]= temp.getInfo().getPartition();
			data[i][2]= temp.getInfo().getFormedTime();
			data[i][3]= temp.getTeamName();
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
		
		
		
		String[] title = {"球队","分区","建立时间","缩写",tmptype,"肖像"};
		final CreateTableforhot ctfh = new CreateTableforhot(title,data,
				381, 12,395, 150, 37,37, 6,
				new Font("华康雅宋体W9(P)", Font.PLAIN, 14), new Font("华康雅宋体W9(P)", Font.PLAIN, 14),15, 15);
		add(ctfh);
		
		ctfh.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && ctfh.getSelectedRow() != -1) {
					String name = ctfh.getValueAt(
							ctfh.getSelectedRow(), 3);
					System.out.println(name);
					SingleTeam spi;
					try {
						spi = new SingleTeam(name, saiji);
						spi.setVisible(true);
						spi.setLocation(375, 58);
					} catch (TransformerFactoryConfigurationError
							| TransformerException | IOException
							| SVGConverterException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}
		});
		
		ImageIcon No1_Team = new ImageIcon("pic/TEAMPNG/"+data[0][3]+".png");
		No1_Team.setImage(No1_Team.getImage().getScaledInstance(158, 158,Image.SCALE_DEFAULT)); 		
		JLabel No1_p = new JLabel(No1_Team);		
		No1_p.setBounds(4, 25, 180, 130);		
		No1_p.setOpaque(false);
		add(No1_p);
		
		No1_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String season = "13-14";
					String name = (String) data[0][3];
					init.currentpanel+="&"+name+";"+season;
					 SingleTeam spi;
					// System.out.println(name);
					try {
						spi = new SingleTeam(name,season);
						spi.setVisible(true);
						spi.setLocation(375, 58);
					} catch (TransformerFactoryConfigurationError
							| TransformerException | IOException
							| SVGConverterException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}
		});
		JLabel No1_name = new JLabel((String)data[0][0]);
		No1_name.setForeground(new Color(51, 0, 51));
		No1_name.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 20));
		No1_name.setBounds(189, 20, 170, 36);
		add(No1_name);
		
		JLabel No1_part = new JLabel((String)data[0][1]);
		No1_part.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_part.setBounds(189, 61, 85, 15);
		add(No1_part);
		
		JLabel No1_time = new JLabel((String)data[0][2]);
		No1_time.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 14));
		No1_time.setBounds(189, 85, 85, 15);
		add(No1_time);
		
		JLabel No1_info = new JLabel((String)data[0][4]);
		No1_info.setFont(new Font("华康雅宋体W9(P)", Font.PLAIN, 28));
		No1_info.setBounds(217, 110, 85, 50);
		add(No1_info);
		
		
		ImageIcon No1_Player1 = new ImageIcon("pic/TEAMPNG/"+data[1][3]+".png");
		No1_Player1.setImage(No1_Player1.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT)); 		
		JLabel No1_p1 = new JLabel(No1_Player1);		
		No1_p1.setSize(35, 35);
		No1_p1.setLocation(353, 14);
		No1_p.setBounds(4, 25, 160, 130);		
		No1_p.setOpaque(false);
		add(No1_p1);
		
		ImageIcon No1_Player2 = new ImageIcon("pic/TEAMPNG/"+data[2][3]+".png");
		No1_Player2.setImage(No1_Player2.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT)); 		
		JLabel label = new JLabel(No1_Player2);
		label.setBounds(353, 52, 35, 35);
		add(label);
		
		ImageIcon No1_Player3 = new ImageIcon("pic/TEAMPNG/"+data[3][3]+".png");
		No1_Player3.setImage(No1_Player3.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT)); 		
		JLabel label_1 = new JLabel(No1_Player3);
		label_1.setBounds(353, 89, 35, 35);
		add(label_1);
		
		ImageIcon No1_Player4 = new ImageIcon("pic/TEAMPNG/"+data[4][3]+".png");
		No1_Player4.setImage(No1_Player4.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT)); 		
		JLabel label_2 = new JLabel(No1_Player4);
		label_2.setBounds(353, 126, 35, 35);
		add(label_2);
	}

	}
	}
