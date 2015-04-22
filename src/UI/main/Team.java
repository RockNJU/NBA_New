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
import UI.common.TeamMap;
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
			" 胜率  "," 进攻回合  "," 进攻效率  "," 防守效率  "," 篮板效率  "," 抢断效率  "," 助攻率  "};
	
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
	
	RMIObject rmi=new RMIObject();
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
		tbl=rmi.getTeamObject();
		mbl=rmi.getMatchObject();
		
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
				"\u9632\u5B88\u6548\u7387", "\u7BEE\u677F\u6548\u7387", 
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
		String[] seasons={"13-14赛季"};
		season.setModel(new DefaultComboBoxModel(seasons));
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
	            	System.out.println(according.getSelectedItem().toString());
	            	System.out.println(sortItem);
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
		teamlist=new CreateTable(title,data,25,144,720,460,25,new Font("Dialog", 0, 18),new Font("Dialog", 0, 15));
		add(teamlist);
		teamlist.setVisible(false);
		//双击进入球员界面
				teamlist.getTable().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//System.out.println(playerlist.getSelectedRow()!=-1);
						//System.out.println(e.getClickCount() == 2);
			            // TODO Auto-generated method stub	
						  				 
							// System.out.println(name);		        
							
							try {  
								String s=season.getSelectedItem().toString().substring(0, 5);
							 String name = teamlist.getValueAt(teamlist.getSelectedRow(),1);
							 SingleTeam spi;
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
		//add(westpane);
		east=new JPanel();
		//eastpane = new JScrollPane(east);
		east.setBounds(445, 135, 300, 480);	
		east.setLayout(new GridLayout(5,3,0,0));
		east.setOpaque(false);
		//add(eastpane);
		
		//east.setBackground(new Color(253,207,135));
		//west.setBackground(new Color(253,207,135));
		add(east);
		add(west);
		//eastpane.setBackground(new Color(253,207,135));
		//westpane.setBackground(new Color(253,207,135));

		
		
		for(int i=0;i<teamswest.length;i++){
			ImageIcon image = new ImageIcon("pic/TEAMPNG/"+teamswest[i]+".png");
			image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT)); 		
			photo = new JLabel(image);
			photo.setToolTipText(teamswest[i]);
			west.add(photo);
			
			photo.addMouseListener(new MouseListener() {
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
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub	            
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	System.out.println("a");
	            }	
	       
		});
		}
		
		for(int i=0;i<teamseast.length;i++){
			ImageIcon image = new ImageIcon("pic/TEAMPNG/"+teamseast[i]+".png");
			image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT)); 		
			photo = new JLabel(image);
			photo.setToolTipText(teamseast[i]);
			east.add(photo);
			photo.addMouseListener(new MouseListener() {
				
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
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub	            
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	System.out.println("a");
	            	
	            }	
	       
		});
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
/*
		logos=new JPanel();
		logos.setSize(720, 480);
		logos.setOpaque(false);
		logos.setLocation(25, 135);
		logos.setLayout(new GridLayout(5,6,5,0));
		String teamsarray[]={"ATL","BKN","BOS","CHA","CHI",
				"CLE","DAL","DEN","DET","GSW",
				"HOU","IND","LAC","LAL","MEM",
				"MIA","MIL","MIN","NOP","NYK",
				"OKC","ORL","PHI","PHX","POR",
				"SAC","SAS","TOR","UTA","WAS"};
		for(int i=0;i<teamsarray.length;i++){
			ImageIcon image = new ImageIcon("pic/TEAMPNG/"+teamsarray[i]+".png");
			image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT)); 		
			JLabel photo = new JLabel(image);
			photo.setToolTipText(teamsarray[i]);
			logos.add(photo);
			photo.addMouseListener(new MouseListener() {
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
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub	            
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	               try {
						SingleTeam di;
						System.out.println(photo.getToolTipText());
						di = new SingleTeam(choose,"13-14");
						//di.setLocation(375, 58);
	                   // di.setVisible(true);
	                } catch (TransformerFactoryConfigurationError
							| TransformerException | IOException
							| SVGConverterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 System.out.println("a");
					try {
						SingleTeam di;
						di = new SingleTeam(choose,"13-14");
						//di.setLocation(375, 58);
	                   // di.setVisible(true);
	                } catch (TransformerFactoryConfigurationError
							| TransformerException | IOException
							| SVGConverterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }	
	       
		});
		}
		add(logos);
		*/
	
		
	}
	
	
	private Object[][] getTotaldata(ArrayList<TeamSeasonDataVO> da){
		System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][28];
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
			return re;
		}
		else{
			Object[][] re=new Object[da.size()][28];
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
				re[i][18]=da.get(i).getShootPercentage();
				re[i][19]=da.get(i).getT_shootPercentage();
				re[i][20]=da.get(i).getFreeThrowPercentage();				
				re[i][21]=da.get(i).getWinRate();				
				re[i][22]=da.get(i).getOffenseRound();
				re[i][23]=da.get(i).getDefenseRound();				
				re[i][24]=da.get(i).getOffenseEfficiency();
				re[i][25]="??";
				re[i][26]=da.get(i).getStealEfficiency();
				re[i][27]=da.get(i).getAssistEfficiency();
			}		
			return re;
		
		}
		
	}
	
	
}
