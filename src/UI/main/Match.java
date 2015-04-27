package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;

import businessService.blservice.MatchBLService;
import UI.blObject.RMIObject;
import UI.common.ComboBoxRenderer;
import UI.common.CreateTable;
import UI.common.DateChooser;
import UI.match.SingleMatch;
import UI.player.SinglePlayer;
import VO.MatchInfo;
import VO.MatchVO;



public class Match extends JPanel {
	private JTable table;
	DateChooser dc;
	JLabel dateLabel;
	JButton find;
	JButton findteam;
	//JButton columns;
	CreateTable matchlist;
	//���ڡ����������ӡ��ȷ֡��Ͷӡ���һ�ڡ����������ġ���ʱ��
	String[] matchtitle={"���"," ����  "," ����  "," ����  "," �ȷ�  "," �Ͷ�  ",
			" ��һ�ڱȷ�  "," �ڶ��ڱȷ�  "," �����ڱȷ�  "," ���Ľڱȷ�  "," ��ʱ���ȷ�  "};
	String[] title;
	Object[][] data;
	private JLabel team;
	JComboBox season;
	JComboBox teams;
	
	//RMIObject rmi=new RMIObject();
	MatchBLService mbl;
	ArrayList<MatchVO> mvo;
	/**
	 * Create the panel.
	 */
	public Match() {
		setLayout(null);
		setSize(764,635);
		setOpaque(false);

		mbl=init.rmi.getMatchObject();
		dc=new DateChooser(180,35);
		dc.setSize(120, 30);
		dc.setLocation(131, 27);
		add(dc);
		
		dateLabel = new JLabel("\u65E5\u671F\uFF1A");
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("������κ", Font.BOLD, 30));
		dateLabel.setBounds(29, 28, 110, 30);
		add(dateLabel);
		
		/**
		 * ���ɸѡ������
		 */
		String teamsarray[]={"ATL","BKN","BOS","CHA","CHI",
				"CLE","DAL","DEN","DET","GSW",
				"HOU","IND","LAC","LAL","MEM",
				"MIA","MIL","MIN","NOP","NYK",
				"OKC","ORL","PHI","PHX","POR",
				"SAC","SAS","TOR","UTA","WAS"};
		 
		Map<String, ImageIcon> content = new LinkedHashMap<String, ImageIcon>();
	    for(int i=0;i<teamsarray.length;i++){
	    	ImageIcon image=new ImageIcon("pic/TEAMPNG/"+teamsarray[i]+".png");
	    	image.setImage(image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
	    	content.put(teamsarray[i], image);
	    }   
		final JComboBox teams= new JComboBox(content.keySet().toArray());
	    
		ComboBoxRenderer renderer = new ComboBoxRenderer(content);
	    
		teams.setRenderer(renderer);
	     
		teams.setBounds(292, 67, 150, 50);		
		add(teams);
		teams.setVisible(true);

		season = new JComboBox();
		season.setToolTipText("����");
		
		ArrayList<String> seasons=mbl.getAllSeason();
		if(seasons.size()==0||seasons==null){
			seasons.add("13-14����");
		}		
		for(int o=0;o<seasons.size();o++){
			season.addItem(seasons.get(o));
			
		}
		season.setBounds(131, 77, 120, 30);		
		add(season);
		season.setVisible(true);
		
		
		
		
		find = new JButton(new ImageIcon("pic/but/����ǰ.png"));
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
	            	find.setIcon(new ImageIcon("pic/but/����ǰ.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	find.setIcon(new ImageIcon("pic/but/���Һ�.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	               //info=mbl.getAllMatchInfo(dc.showDate.getText());
	               matchlist.setVisible(true);
	               
	               mvo=mbl.getMatchByTeamTime(dc.showDate.getText());
	               System.out.println("shifouweikong"+mvo==null);
	               if(mvo==null){
	            	   JOptionPane.showMessageDialog(Match.this, "������������û�б�����");
	               }else{
	               data=getdata(mvo);
	               matchlist.updateTable(matchtitle, data);
	               }
	            }	
	       
		});
		
		team = new JLabel("\u7403\u961F\uFF1A");
		team.setForeground(Color.WHITE);
		team.setFont(new Font("������κ", Font.BOLD, 30));
		team.setBounds(29, 78, 110, 30);
		add(team);
		
		find.setToolTipText("\u67E5\u8BE2\u6BD4\u8D5B");
		find.setBounds(483, 27, 75, 26);
		add(find);
		find.setVisible(true);
		
		findteam = new JButton(new ImageIcon("pic/but/����ǰ.png"));
		findteam.setToolTipText("\u67E5\u8BE2\u6BD4\u8D5B");
		findteam.setBounds(483, 77, 75, 26);
		add(findteam);
		findteam.setVisible(true);		
		findteam.addMouseListener(new MouseListener() {
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
	            	findteam.setIcon(new ImageIcon("pic/but/����ǰ.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	findteam.setIcon(new ImageIcon("pic/but/���Һ�.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	String Season = season.getSelectedItem().toString().substring(0, 5);
	            	String Team=teams.getSelectedItem().toString();
	            	//System.out.println(Team);
	            	matchlist.setVisible(true);
	            	mvo=mbl.getMatchBySeason(Season, Team);
	            	if(mvo==null){
		            	   JOptionPane.showMessageDialog(Match.this, "û�б�����");
		             }
	            	else{
		               
		               data=getdata(mvo);
		               matchlist.updateTable(matchtitle, data);
	            	}
	            }	
	       
		});
		/*
		columns = new JButton(new ImageIcon("pic/but/ɸѡǰ.png"));
		columns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
	            	columns.setIcon(new ImageIcon("pic/but/ɸѡǰ.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	columns.setIcon(new ImageIcon("pic/but/ɸѡ��.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                
	            }	
	       
		});
		columns.setToolTipText("\u9009\u62E9\u8868\u683C\u5C5E\u6027");
		columns.setBounds(597, 27, 75, 26);
		add(columns);
		columns.setVisible(true);	
		
		*/
		
		String Title[]={"�ձ��"};
		Object Data[][]={{"q"},{"e"},{"w"},{"r"},{"b"}};
		this.title=Title;
		this.data=Data;
		matchlist=new CreateTable(title,data,25,144,720,460,25,new Font("������κ", 0, 15),new Font("Dialog", 0, 12));
		add(matchlist);
		matchlist.setVisible(false);
		// ˫��������Ա����
				matchlist.getTable().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// System.out.println(playerlist.getSelectedRow()!=-1);
						// System.out.println(e.getClickCount() == 2);
						// TODO Auto-generated method stub
						if (e.getClickCount() == 2 && matchlist.getSelectedRow() != -1) {
							String team=matchlist.getValueAt(
									matchlist.getSelectedRow(), 3);
							String date= matchlist.getValueAt(
									matchlist.getSelectedRow(), 1);
							// System.out.println(name);
							SingleMatch spi = new SingleMatch(team,date );
							spi.setVisible(true);
							spi.setLocation(375, 58);
						}
					}
				});

	}
	

	private Object[][] getdata(ArrayList<MatchVO> mdata){
		//System.out.println(mdata.size());
		if(mdata==null){
			Object[][] re=new Object[1][11];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			return re;
		}
		else{
			Object[][] re=new Object[mdata.size()][11];
			//String[] matchtitle={" ����  "," ����  "," ����  "," �ȷ�  "," �Ͷ�  ",
			//	" ��һ�ڱȷ�  "," �ڶ��ڱȷ�  "," �����ڱȷ�  "," ���Ľڱȷ�  "," ��ʱ���ȷ�  "};
			for(int i=0;i<mdata.size();i++){		
				int k=mdata.get(i).getScores().size();
				re[i][0]=i+1;
				re[i][1]=mdata.get(i).getDate();
				re[i][2]=mdata.get(i).getSeason()+"����";
				re[i][3]=mdata.get(i).getHostTeam().getTeamName();
				re[i][4]=mdata.get(i).getMatchScore();
				re[i][5]=mdata.get(i).getGuestTeam().getTeamName();
				re[i][6]=re[i][3]+" "+mdata.get(i).getScores().get(0)+" "+re[i][5];
				re[i][7]=re[i][3]+" "+mdata.get(i).getScores().get(1)+" "+re[i][5];
				re[i][8]=re[i][3]+" "+mdata.get(i).getScores().get(2)+" "+re[i][5];
				re[i][9]=re[i][3]+" "+mdata.get(i).getScores().get(3)+" "+re[i][5];				
				re[i][10]="";
				if(k==4){
					re[i][10]="�޼�ʱ��";
				}else{
					for(int m=4;m<k;m++){
						re[i][10]=(re[i][10]+"/"+mdata.get(i).getScores().get(m)).substring(1);
					}
					
				}
				System.out.println(re[i][10]);
			}		
			return re;
		
		}
	}
}
