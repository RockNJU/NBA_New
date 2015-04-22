package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;

import businessService.blservice.MatchBLService;
import businesslogic.bl.matchbl.MatchInfo;
import UI.blObject.RMIObject;
import UI.common.ComboBoxRenderer;
import UI.common.CreateTable;
import UI.common.DateChooser;
import VO.MatchVO;



public class Match extends JPanel {
	private JTable table;
	DateChooser dc;
	JLabel dateLabel;
	JButton find;
	JButton findteam;
	JButton columns;
	CreateTable matchlist;
	String[] matchrtitle={" ���  "," ��Ա����  "," �������  "," ��������  "," �ȷ�����  ",
			" ������  "," ������  "," �ڳ�ʱ��  "," Ͷ��������  "," ����������  "," ����������  ",
			" ������  "," ������  "," ������  "," ��ñ��  "," ʧ����  "," ������  "," �÷�  "," Ч��  ",
			" GmScЧ��ֵ  "," ��ʵ������  "," Ͷ��Ч��  "," ������  "," ����������  "," ����������  ",
			" ������  "," ������  "," ��ñ��  "," ʧ����  "," ʹ����  "};
	String[] title;
	Object[][] data;
	private JLabel team;
	JComboBox season;
	JComboBox teams;
	
	RMIObject rmi=new RMIObject();
	MatchBLService mbl;
	ArrayList<MatchInfo> info;
	/**
	 * Create the panel.
	 */
	public Match() {
		setLayout(null);
		setSize(764,635);
		setOpaque(false);

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
		JComboBox teams= new JComboBox(content.keySet().toArray());
	    
		ComboBoxRenderer renderer = new ComboBoxRenderer(content);
	    
		teams.setRenderer(renderer);
	     
		teams.setBounds(292, 67, 150, 50);		
		add(teams);
		teams.setVisible(true);
		
		mbl=rmi.getMatchObject();
		season = new JComboBox();
		season.setToolTipText("����");
		
		String[] seasons=mbl.getAllSeason();
		if(seasons.length==0||seasons==null){
			seasons[0]="13-14����";
		}		
		season.setModel(new DefaultComboBoxModel(seasons));
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
	               info=mbl.getAllMatchInfo(dc.showDate.getText());
	               
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
	                
	            }	
	       
		});
		
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
		
		
		
		String Title[]={"�ձ��"};
		Object Data[][]={{"q"},{"e"},{"w"},{"r"},{"b"}};
		this.title=Title;
		this.data=Data;
		matchlist=new CreateTable(title,data,25,144,720,460,20,new Font("Dialog", 0, 18),new Font("Dialog", 0, 10));
		add(matchlist);
	}
	
	
	private Object[][] getdata(ArrayList<MatchVO> mdata){
		System.out.println(mdata.size());
		if(mdata.size()==0||mdata==null){
			Object[][] re=new Object[8][1];
			re[0][0]="";
			re[1][0]="";
			re[2][0]="";
			re[3][0]="";			
			re[4][0]="";
			re[5][0]="";
			re[6][0]="";
			re[7][0]="";
			return re;
		}
		else{
			Object[][] re=new Object[8][mdata.size()];
			
			for(int i=0;i<mdata.size();i++){		
				
				re[0][i]="i+1";
				re[1][i]=mdata.get(i).getHostTeam();
				re[2][i]=mdata.get(i).getGuestTeam();
				re[3][i]=mdata.get(i).getMatchScore();
				re[4][i]="i+1";
				re[5][i]="i+1";
				re[6][i]="i+1";
				re[7][i]="i+1";
				
			}		
			return re;
		
		}
	}
}
