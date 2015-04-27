package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_Map;
import UI.common.TeamMap;
import UI.common.TeamName_Map;
import UI.team.SingleTeam;
import VO.TeamSeasonDataVO;

public class Team extends JPanel {
	JLabel findLabel;
	JLabel sortLabel;

	JComboBox according;
	JComboBox season;
	JTextField findkey;
	
	JButton columns;
	JButton sort;
	JButton find;
	CreateTable teamlist;
	String[] teamtitle={" 序号  "," 球队名称  "," 比赛场数  "," 投篮命中数  "," 投篮出手次数  "," 三分命中数  ",
			" 三分出手数  "," 罚球命中数  "," 罚球出手数  "," 进攻篮板数  "," 防守篮板数  "," 篮板数  "," 助攻数  ",
			" 抢断数  "," 盖帽数  "," 失误数  "," 犯规数  "," 比赛得分  "," 投篮命中率  "," 三分命中率  "," 罚球命中率  ",
			" 胜率  "," 进攻回合  ","防守回合"," 防守效率  "," 进攻效率  "," 进攻篮板率  "," 防守篮板率  "," 抢断效率  "," 助攻率  "};
	
	String[] teamtitleaverage={" 序号  "," 球队名称  "," 比赛场数  "," 平均投篮命中数  "," 平均投篮出手次数  "," 平均三分命中数  ",
			" 平均三分出手数  "," 平均罚球命中数  "," 平均罚球出手数  "," 进平均攻篮板数  "," 平均防守篮板数  "," 平均篮板数  "," 平均助攻数  ",
			" 平均抢断数  "," 平均盖帽数  "," 平均失误数  "," 平均犯规数  "," 平均比赛得分  "," 投篮命中率  "," 三分命中率  "," 罚球命中率  ",
			" 胜率  "," 进攻回合  ","防守回合"," 防守效率  "," 进攻效率  "," 进攻篮板率  "," 防守篮板率  "," 抢断效率  "," 助攻率  "};
	
    String [] teamswest	={"ATL","CHI","BOS","CHA","CLE","BKN","MIA","DET",				
			"NYK","ORL","IND","PHI","WAS","MIL","TOR"};		
	
	String []teamseast={"HOU","LAC","LAL","MEM",
			"MIN","NOP","DAL","DEN","GSW",
			"OKC","PHX","POR",
			"SAC","SAS","UTA"};
 
	String[] title;
	Object[][] data;
	JLabel dd;
	//JPanel logos;
	//ScrollPane sp;
	//JScrollPane westpane;
	//JScrollPane eastpane;
	JPanel west,east;
	JLabel photo;
	//String choose;
	
	//RMIObject rmi=new RMIObject();
	TeamBLService tbl;
	MatchBLService mbl;
	ArrayList<TeamSeasonDataVO> tdvo;
	/**
	 * Create the panel.
	 */
	public Team() {
		setLayout(null);
		setSize(764,635);
		setOpaque(false);
		tbl=init.rmi.getTeamObject();
		mbl=init.rmi.getMatchObject();
		
		sortLabel = new JLabel("排列：");
		sortLabel.setForeground(Color.WHITE);
		sortLabel.setFont(new Font("华文新魏", Font.BOLD, 32));
		sortLabel.setBounds(31, 35, 130, 30);
		add(sortLabel);
		sortLabel.setVisible(true);
		findLabel = new JLabel("查找：");
		findLabel.setForeground(Color.WHITE);
		findLabel.setFont(new Font("华文新魏", Font.BOLD, 32));
		findLabel.setBounds(31, 75, 130, 30);
		add(findLabel);
		findLabel.setVisible(true);
		/**
		 * 球队筛选的依据
		 */
		
		according = new JComboBox();
		according.setToolTipText("\u7B5B\u9009\u4F9D\u636E");
		according.setModel(new DefaultComboBoxModel(new String[] {
				"\u6295\u7BEE\u547D\u4E2D\u7387", "\u6295\u7BEE\u51FA\u624B\u6B21\u6570",
				"\u4E09\u5206\u547D\u4E2D\u6570", "\u4E09\u5206\u51FA\u624B\u6570", 
				"\u7F5A\u7403\u547D\u4E2D\u6570", "\u7F5A\u7403\u51FA\u624B\u6570", 
				"\u8FDB\u653B\u7BEE\u677F\u6570", "\u9632\u5B88\u7BEE\u677F\u6570", 
				"\u7BEE\u677F\u6570", "\u52A9\u653B\u6570", "\u62A2\u65AD\u6570", 
				"\u76D6\u5E3D\u6570", "\u5931\u8BEF\u6570", "\u72AF\u89C4\u6570", 
				"\u6BD4\u8D5B\u5F97\u5206", "\u6295\u7BEE\u547D\u4E2D\u7387", 
				"\u4E09\u5206\u547D\u4E2D\u7387", "\u7F5A\u7403\u547D\u4E2D\u7387", 
				"\u80DC\u7387", "\u8FDB\u653B\u56DE\u5408", "\u8FDB\u653B\u6548\u7387",
				"\u9632\u5B88\u6548\u7387", "进攻篮板率","防守篮板率", 
				"\u62A2\u65AD\u6548\u7387", "\u52A9\u653B\u7387"}));
		according.setBounds(135, 35, 127, 30);		
		add(according);
		according.setVisible(true);
		season = new JComboBox();
		season.setToolTipText("赛季");
		
		//String[] seasons=mbl.getAllSeason();
		//if(seasons==null){
		//	seasons[0]="13-14赛季";
		//}
		ArrayList<String> seasons=mbl.getAllSeason();
		if(seasons.size()==0||seasons==null){
			seasons.add("13-14赛季");
		}		
		for(int o=0;o<seasons.size();o++){
			season.addItem(seasons.get(o));
			
		}
		season.setBounds(291, 35, 130, 30);		
		add(season);
		season.setVisible(true);
		
		/**球员查找的关键词
		 * 
		 */
		findkey = new JTextField("请输入关键词");
		findkey.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		findkey.setBounds(135, 75, 286, 30);		
		add(findkey);
		findkey.setColumns(20);
		findkey.setVisible(true);
		sort = new JButton(new ImageIcon("pic/but/排列前.png"));
		sort.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	sort.setIcon(new ImageIcon("pic/but/排列前.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	sort.setIcon(new ImageIcon("pic/but/排列后.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	//TODO
	            	String Season=season.getSelectedItem().toString().substring(0, 5);
	            	
	            	TeamMap m=new TeamMap();
	            	String sortItem=m.getItem(according.getSelectedItem().toString());
	            	//System.out.println(according.getSelectedItem().toString());
	            	//System.out.println(sortItem);
	            	tdvo=tbl.sort(Season, sortItem);
	            	data=getTotaldata(tdvo);
	            	teamlist.updateTable(teamtitle, data);
	            	teamlist.setVisible(true);
	            	dd.setVisible(false);
	            	east.setVisible(false);
	            	west.setVisible(false);
	            	
	            	
	            }
	       
		});
		sort.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u961F\u4FE1\u606F");
		sort.setBounds(480, 35, 75, 26);
		add(sort);
		sort.setVisible(true);
		
		
		find = new JButton(new ImageIcon("pic/but/查找前.png"));
		find.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	find.setIcon(new ImageIcon("pic/but/查找前.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	find.setIcon(new ImageIcon("pic/but/查找后.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	tdvo =tbl.find(findkey.getText());
	            	data=getTotaldata(tdvo);
	            	teamlist.updateTable(teamtitle, data);
	            	teamlist.setVisible(true);
	            	dd.setVisible(false);
	            	east.setVisible(false);
	            	west.setVisible(false);
					 
	            }	
	       
		});
		
		find.setToolTipText("\u67E5\u8BE2\u5355\u72EC\u7403\u961F\u4FE1\u606F");
		find.setBounds(480, 75, 75, 26);
		add(find);
		find.setVisible(true);
		
		
		columns = new JButton(new ImageIcon("pic/but/筛选前.png"));
		columns.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	columns.setIcon(new ImageIcon("pic/but/筛选前.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	columns.setIcon(new ImageIcon("pic/but/筛选后.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	teamlist.setVisible(true);
	            	dd.setVisible(false);
	            	east.setVisible(false);
	            	west.setVisible(false);
	            	ChooseTeamColumn cpc=new ChooseTeamColumn();
					cpc.setVisible(true);
	            }	
	       
		});
		columns.setToolTipText("\u9009\u62E9\u8868\u683C\u5C5E\u6027");
		columns.setBounds(600, 35, 75, 26);
		add(columns);
		columns.setVisible(true);	
		
		
		
		String Title[]={"eee"};
		Object Data[][]={{"q"},{"e"},{"w"},{"r"},{"b"}};
		this.title=Title;
		this.data=Data;
		teamlist=new CreateTable(title,data,25,144,720,460,25,new Font("华文新魏", 0, 15),new Font("Dialog", 0, 12));
		add(teamlist);
		teamlist.setVisible(false);
				teamlist.getTable().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	        
							
							try {  
								String s=season.getSelectedItem().toString().substring(0, 5);
							 String name = teamlist.getValueAt(teamlist.getSelectedRow(),1);
							 SingleTeam spi;
							//System.out.println("aha"+s+name);
							spi = new SingleTeam(name,s);
							
							 spi.setVisible(true);
							 spi.setLocation(375, 58);
							} catch (TransformerFactoryConfigurationError
									| TransformerException | IOException
									| SVGConverterException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				});		
		west=new JPanel();
		west.setLayout(new GridLayout(5,3,0,0));
		west.setBounds(25, 135, 300, 480);
		west.setOpaque(false);
		east=new JPanel();
		east.setBounds(445, 135, 300, 480);	
		east.setLayout(new GridLayout(5,3,0,0));
		east.setOpaque(false);
		add(east);
		add(west);


		
		
		for(int i=0;i<teamswest.length;i++){
			ImageIcon image = new ImageIcon("pic/TEAMPNG/"+teamswest[i]+".png");
			image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT)); 		
			//photo = new JLabel(image);
			//photo.setToolTipText(teamswest[i]);
			final String tempa = teamswest[i];
			JButton btnNewButton = new JButton(image);
			btnNewButton.setContentAreaFilled(false);
			TeamName_Map mm=new TeamName_Map();
			btnNewButton.setToolTipText(mm.getFullName(tempa));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SingleTeam sti;
					try {
						//System.out.println("qiudui:"+tempa);
						sti = new SingleTeam(tempa, "13-14");
						sti.setVisible(true);
						sti.setLocation(375, 58);	
					} catch (TransformerFactoryConfigurationError e1) {
						e1.printStackTrace();
					} catch (TransformerException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SVGConverterException e1) {
						e1.printStackTrace();
					}
				}
			});
			west.add(btnNewButton);
		}
		
		for(int i=0;i<teamseast.length;i++){
			ImageIcon image = new ImageIcon("pic/TEAMPNG/"+teamseast[i]+".png");
			image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT)); 	
			//photo = new JLabel(image);
			
			final String tempa = teamseast[i];
			JButton btnNewButton = new JButton(image);
			TeamName_Map mm=new TeamName_Map();
			btnNewButton.setToolTipText(mm.getFullName(tempa));
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SingleTeam sti;
					try {
						//System.out.println("qiudui:"+tempa);
						sti = new SingleTeam(tempa, "13-14");
						sti.setVisible(true);
						sti.setLocation(375, 58);	
					} catch (TransformerFactoryConfigurationError e1) {
						e1.printStackTrace();
					} catch (TransformerException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SVGConverterException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			east.add(btnNewButton);
		}
	
		
		/**
		 * 背景图片
		 */

		ImageIcon bg = new ImageIcon("pic/球队选择.png");
		bg.setImage(bg.getImage().getScaledInstance(756,451,Image.SCALE_DEFAULT)); 		
		dd = new JLabel(bg);		
		dd.setBounds(2, 155, 756,451);		
		dd.setOpaque(false);
		add(dd);
		
	}
	
	public void datachoose(boolean isaverage,int hide[]){
		//更新信息
		if(isaverage == true){
			String Season=season.getSelectedItem().toString().substring(0, 5);
        	
        	TeamMap m=new TeamMap();
        	String sortItem=m.getItem(according.getSelectedItem().toString());
        	//System.out.println(according.getSelectedItem().toString());
        	//System.out.println(sortItem);
        	tdvo=tbl.sort(Season, sortItem);
        	data=getAveragedata(tdvo);
        	teamlist.updateTable(teamtitleaverage, data);
        	teamlist.setVisible(true);
        	dd.setVisible(false);
        	east.setVisible(false);
        	west.setVisible(false);
		}
		else{
			String Season=season.getSelectedItem().toString().substring(0, 5);
        	
        	TeamMap m=new TeamMap();
        	String sortItem=m.getItem(according.getSelectedItem().toString());
        	//System.out.println(according.getSelectedItem().toString());
        	//System.out.println(sortItem);
        	tdvo=tbl.sort(Season, sortItem);
        	data=getTotaldata(tdvo);
        	teamlist.updateTable(teamtitle, data);
        	teamlist.setVisible(true);
        	dd.setVisible(false);
        	east.setVisible(false);
        	west.setVisible(false);
		}
		//隐藏表格
		if(hide.length!=0){
			for(int temp :hide){
				teamlist.hideColumn(temp);
			}
		}
	}
	
	private Object[][] getTotaldata(ArrayList<TeamSeasonDataVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][30];
			re[0][0]="";
			re[0][1]="";
			re[0][2]="";
			re[0][3]="";			
			re[0][4]="";
			re[0][5]="";
			re[0][6]="";
			re[0][7]="";
			re[0][8]="";
			re[0][9]="";
			re[0][10]="";
			re[0][11]="";			
			re[0][12]="";
			re[0][13]="";
			re[0][14]="";
			re[0][15]="";
			re[0][16]="";
			re[0][17]="";
			re[0][18]="";
			re[0][19]="";			
			re[0][20]="";
			re[0][21]="";
			re[0][22]="";
			re[0][23]="";
			re[0][24]="";
			re[0][25]="";
			re[0][26]="";
			re[0][27]="";
			re[0][28]="";
			re[0][29]="";
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][30];
			/*	String[] teamtitle={" xuahao球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数",
			" 三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数",
			"抢断数","盖帽数","失误数","犯规数","比赛得分"," 投篮命中率","三分命中率"," 罚球命中率",
			"胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};*/
			for(int i=0;i<da.size();i++){						
				re[i][0]=i+1;
				re[i][1]=da.get(i).getTeamName();
				re[i][2]=da.get(i).getMatchNum();
				re[i][3]=da.get(i).getFieldGoal();
				re[i][4]=da.get(i).getShootNum();
				re[i][5]=da.get(i).getT_fieldGoal();
				re[i][6]=da.get(i).getT_shootNum();				
				re[i][7]=da.get(i).getFreeThrowGoalNum();
				re[i][8]=da.get(i).getFreeThrowNum();
				re[i][9]=da.get(i).getO_ReboundNum();
				re[i][10]=da.get(i).getD_ReboundNum();
				re[i][11]=da.get(i).getReboundNum();				
				re[i][12]=da.get(i).getAssistNum();
				re[i][13]=da.get(i).getStealNum();
				re[i][14]=da.get(i).getBlockNum();
				re[i][15]=da.get(i).getTurnoverNum();
				re[i][16]=da.get(i).getFoulNum();				
				re[i][17]=da.get(i).getPointNum();				
				re[i][18]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][19]=OftenUseMethod.changedouble(da.get(i).getT_shootPercentage());
				re[i][20]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());				
				re[i][21]=OftenUseMethod.changedouble(da.get(i).getWinRate());				
				re[i][22]=da.get(i).getOffenseRound();
				re[i][23]=da.get(i).getDefenseRound();					
				re[i][24]=OftenUseMethod.changedouble(da.get(i).getDefenseEfficiency());
				re[i][25]=OftenUseMethod.changedouble(da.get(i).getOffenseEfficiency());
				re[i][26]=OftenUseMethod.changedouble(da.get(i).getO_ReboundEfficiency());
				re[i][27]=OftenUseMethod.changedouble(da.get(i).getD_ReboundEfficiency());
				re[i][28]=OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][29]=OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
			}		
			return re;
		
		}
		
	}
	private Object[][] getAveragedata(ArrayList<TeamSeasonDataVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][30];
			re[0][0]="";
			re[0][1]="";
			re[0][2]="";
			re[0][3]="";			
			re[0][4]="";
			re[0][5]="";
			re[0][6]="";
			re[0][7]="";
			re[0][8]="";
			re[0][9]="";
			re[0][10]="";
			re[0][11]="";			
			re[0][12]="";
			re[0][13]="";
			re[0][14]="";
			re[0][15]="";
			re[0][16]="";
			re[0][17]="";
			re[0][18]="";
			re[0][19]="";			
			re[0][20]="";
			re[0][21]="";
			re[0][22]="";
			re[0][23]="";
			re[0][24]="";
			re[0][25]="";
			re[0][26]="";
			re[0][27]="";
			re[0][28]="";
			re[0][29]="";
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][30];
			/*	String[] teamtitle={" xuahao球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数",
			" 三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数","篮板数","助攻数",
			"抢断数","盖帽数","失误数","犯规数","比赛得分"," 投篮命中率","三分命中率"," 罚球命中率",
			"胜率","进攻回合","进攻效率","防守效率","篮板效率","抢断效率","助攻率"};*/
			for(int i=0;i<da.size();i++){						
				re[i][0]=i+1;
				re[i][1]=da.get(i).getTeamName();
				re[i][2]=da.get(i).getMatchNum();
				re[i][3]=da.get(i).getFieldGoal();
				re[i][4]=OftenUseMethod.changedouble(da.get(i).getShootNum_avg());
				re[i][5]=OftenUseMethod.changedouble(da.get(i).getT_fieldGoal_avg());
				re[i][6]=OftenUseMethod.changedouble(da.get(i).getT_shootNum_avg());				
				re[i][7]=OftenUseMethod.changedouble(da.get(i).getFreeThrowGoalNum_avg());
				re[i][8]=OftenUseMethod.changedouble(da.get(i).getFreeThrowNum_avg());
				re[i][9]=OftenUseMethod.changedouble(da.get(i).getO_ReboundNum_avg());
				re[i][10]=OftenUseMethod.changedouble(da.get(i).getD_ReboundNum_avg());
				re[i][11]=OftenUseMethod.changedouble(da.get(i).getReboundNum_avg());				
				re[i][12]=OftenUseMethod.changedouble(da.get(i).getAssistNum_avg());
				re[i][13]=OftenUseMethod.changedouble(da.get(i).getStealNum_avg());
				re[i][14]=OftenUseMethod.changedouble(da.get(i).getBlockNum_avg());
				re[i][15]=OftenUseMethod.changedouble(da.get(i).getTurnoverNum_avg());
				re[i][16]=OftenUseMethod.changedouble(da.get(i).getFoulNum_avg());				
				re[i][17]=OftenUseMethod.changedouble(da.get(i).getPointNum_avg());				
				re[i][18]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][19]=OftenUseMethod.changedouble(da.get(i).getT_shootPercentage());
				re[i][20]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());				
				re[i][21]=OftenUseMethod.changedouble(da.get(i).getWinRate());				
				re[i][22]=OftenUseMethod.changedouble(da.get(i).getOffenseRound_avg());
				re[i][23]=OftenUseMethod.changedouble(da.get(i).getDefenseRound());		
				re[i][24]=OftenUseMethod.changedouble(da.get(i).getDefenseEfficiency());
				re[i][25]=OftenUseMethod.changedouble(da.get(i).getOffenseEfficiency());
				re[i][26]=OftenUseMethod.changedouble(da.get(i).getO_ReboundEfficiency());
				re[i][27]=OftenUseMethod.changedouble(da.get(i).getD_ReboundEfficiency());
				re[i][28]=OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][29]=OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
			}		
			return re;
		
		}
			
	}
}
