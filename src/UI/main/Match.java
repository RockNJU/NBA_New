package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import businessService.blservice.MatchBLService;
import UI.blObject.RMIObject;
import UI.common.ComboBoxRenderer;
import UI.common.CreateTable;
import UI.common.DateChooser;
import UI.common.TeamName_Map;
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
	JComboBox filter;
	JTextField fliterkey;
	JLabel filterLabel;
	int tempchossen = 0;
	JButton filterb;
	//JButton columns;
	static CreateTable matchlist;
	//日期、赛季、主队、比分、客队、第一节、二、三、四、加时、
	String[] matchtitle={"序号"," 日期  "," 赛季  "," 主队  "," 比分  "," 客队  ",
			" 第一节  "," 第二节  "," 第三节  "," 第四节  "," 加时赛  "};
	String[] title;
	Object[][] data;
	private JLabel team;
	JComboBox season;
	JComboBox teams;
	
	//RMIObject rmi=new RMIObject();
	//MatchBLService mbl;
	ArrayList<MatchVO> mvo;
	/**
	 * Create the panel.
	 */
	public Match() {
		setLayout(null);
		setSize(764,635);
		setOpaque(false);

		//mbl=init.rmi.getMatchObject();
		dc=new DateChooser(180,35);
		dc.setSize(120, 30);
		dc.setLocation(131, 10);
		add(dc);
		
		dateLabel = new JLabel("\u65E5\u671F\uFF1A");
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("华文新魏", Font.BOLD, 30));
		dateLabel.setBounds(29, 10, 110, 30);
		add(dateLabel);
		
		/**
		 * 球队筛选的依据
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
	     
		teams.setBounds(290, 30, 200, 50);		
		add(teams);
		teams.setVisible(true);

		season = new JComboBox();
		season.setToolTipText("赛季");
		
		ArrayList<String> seasons=init.mbl.getAllSeason();
		if(seasons.size()==0||seasons==null){
			seasons.add("13-14赛季");
		}		
		for(int o=0;o<seasons.size();o++){
			season.addItem(seasons.get(o));
			
		}
		season.setBounds(131, 50, 120, 30);		
		add(season);
		season.setVisible(true);
		
		filterLabel = new JLabel("排除：");
		filterLabel.setForeground(Color.WHITE);
		filterLabel.setFont(new Font("华文新魏", Font.BOLD, 32));
		filterLabel.setBounds(31, 90, 130, 30);
		add(filterLabel);
		filterLabel.setVisible(true);
		
		
		
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
	               //info=mbl.getAllMatchInfo(dc.showDate.getText());
	               matchlist.setVisible(true);
	               
	               mvo=init.mbl.getMatchByTeamTime(dc.showDate.getText());
	               //System.out.println("shifouweikong"+mvo==null);
	               if(mvo==null){
	            	   JOptionPane.showMessageDialog(Match.this, "您搜索的日期没有比赛！");
	               }else{
	               data=getdata(mvo);
	               matchlist.updateTable(matchtitle, data);
	               matchlist.hideColumn(2);
	               }
	               init.currentpanel="9"+"&"+dc.showDate.getText();
	               System.out.println(init.currentpanel);
	            }	
	       
		});
		
		team = new JLabel("\u7403\u961F\uFF1A");
		team.setForeground(Color.WHITE);
		team.setFont(new Font("华文新魏", Font.BOLD, 30));
		team.setBounds(29, 50, 110, 30);
		add(team);
		
		find.setToolTipText("\u67E5\u8BE2\u6BD4\u8D5B");
		find.setBounds(532, 10, 75, 26);
		add(find);
		find.setVisible(true);
		
		findteam = new JButton(new ImageIcon("pic/but/查找前.png"));
		findteam.setToolTipText("\u67E5\u8BE2\u6BD4\u8D5B");
		findteam.setBounds(532, 50, 75, 26);
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
	            	findteam.setIcon(new ImageIcon("pic/but/查找前.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	findteam.setIcon(new ImageIcon("pic/but/查找后.png"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	String Season = season.getSelectedItem().toString().substring(0, 5);
	            	String Team=teams.getSelectedItem().toString();
	            	//System.out.println(Team);
	            	matchlist.setVisible(true);
	            	mvo=init.mbl.getMatchBySeason(Season, Team);
	            	if(mvo==null){
		            	   JOptionPane.showMessageDialog(Match.this, "没有比赛！");
		             }
	            	else{
		               
		               data=getdata(mvo);
		               matchlist.updateTable(matchtitle, data);
		               matchlist.hideColumn(2);
	            	}
	            	init.currentpanel="9"+"&"+Season+";"+Team;
		            System.out.println(init.currentpanel);
	            }	
	       
		});
		
		/**
		 * 筛选
		 */
		filter = new JComboBox();
		filter.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		filter.setBounds(131, 90, 120, 30);
		filter.setMaximumRowCount(100);
		filter.setModel(new DefaultComboBoxModel(new String[] {
				"包含","大于","等于","小于" }));
		filter.setToolTipText("排除");
		filter.setEditable(true);
		add(filter);
		filter.setVisible(true);
		/**
		 * 筛选的关键词
		 * 
		 */
		fliterkey = new JTextField("请输入数值");
		fliterkey.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fliterkey.setText(null);
			}
		});
		fliterkey.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		fliterkey.setBounds(290, 90, 200, 30);
		add(fliterkey);
		fliterkey.setColumns(20);
		fliterkey.setVisible(true);
		filterb = new JButton(new ImageIcon("pic/but/排除前.png"));
	    
		filterb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(matchlist.getmodel());
			    matchlist.setRowSorter(sorter);
			    	  int[] a =  {tempchossen};
			    	  //test;
				String comparisonType = filter.getSelectedItem().toString();
			    String text = fliterkey.getText();
                if (text.length() == 0)
                {
                    sorter.setRowFilter(null);
                }
                else
                {
                	try{
                	if(comparisonType.equals("包含")){
                    	sorter.setRowFilter (RowFilter.regexFilter(text, a));
                    }
                	if(comparisonType.equals("等于")){
                		sorter.setRowFilter (RowFilter.numberFilter(ComparisonType.EQUAL, Double.valueOf(text), a));
                	}
                	else if(comparisonType.equals("小于")){
                		sorter.setRowFilter (RowFilter.numberFilter(ComparisonType.BEFORE, Double.valueOf(text), a));
                	}
                	else if(comparisonType.equals("大于")){
                		sorter.setRowFilter (RowFilter.numberFilter(ComparisonType.AFTER, Double.valueOf(text),a));
                	}
                	}
                	catch(Exception e1){
                		
                	}
                	}
			}
		});
		filterb.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				filterb.setIcon(new ImageIcon("pic/but/排除前.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				filterb.setIcon(new ImageIcon("pic/but/排除后.png"));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				//System.out.println(init.currentpanel);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		filterb.setToolTipText("选择表格中的一列，进行排除");
		filterb.setBounds(532, 90, 75, 26);
		add(filterb);
		filterb.setVisible(true);
		/*
		columns = new JButton(new ImageIcon("pic/but/筛选前.png"));
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
	            	columns.setIcon(new ImageIcon("pic/but/筛选前.png"));
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	columns.setIcon(new ImageIcon("pic/but/筛选后.png"));
	            	
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
		
		String Title[]={""};
		Object Data[][]={{""},{""},{""},{""},{""}};
		this.title=Title;
		this.data=Data;
		matchlist=new CreateTable(title,data,25,144,720,460,25,new Font("华文新魏", 0, 15),new Font("Dialog", 0, 12));
		//matchlist.getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(matchlist);
		
		matchlist.setVisible(false);
		// 双击进入球员界面
				matchlist.getTable().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// System.out.println(playerlist.getSelectedRow()!=-1);
						// System.out.println(e.getClickCount() == 2);
						// TODO Auto-generated method stub
						if (e.getClickCount() == 2 && matchlist.getSelectedRow() != -1) {
							TeamName_Map mm=new TeamName_Map();
							String team=mm.getFullName(matchlist.getValueAt(
									matchlist.getSelectedRow(), 3));
							String date= matchlist.getValueAt(
									matchlist.getSelectedRow(), 1);
							// System.out.println(name);
							init.currentdio="10(1)&"+team+";"+date;
							//System.out.println(init.currentpanel);
							SingleMatch spi = new SingleMatch(team,date );
							spi.setVisible(true);
							spi.setLocation(375, 80);
						}
						else{
							tempchossen = matchlist.getSelectedColumn();
							fliterkey.setText("目前选择的是："+matchlist.getColumnName(tempchossen));
						}
					}
					
				
				});

	}
	

	public static  Object[][] getdata(ArrayList<MatchVO> mdata){
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
			TeamName_Map mm=new TeamName_Map();
			//String[] matchtitle={" 日期  "," 赛季  "," 主队  "," 比分  "," 客队  ",
			//	" 第一节比分  "," 第二节比分  "," 第三节比分  "," 第四节比分  "," 加时赛比分  "};
			for(int i=0;i<mdata.size();i++){		
				int k=mdata.get(i).getScores().size();
				re[i][0]=i+1;
				re[i][1]=mdata.get(i).getDate();
				re[i][2]=mdata.get(i).getSeason()+"赛季";
				re[i][3]=mm.getFullName(mdata.get(i).getHostTeam().getTeamName());
				re[i][4]=mdata.get(i).getMatchScore();
				re[i][5]=mm.getFullName(mdata.get(i).getGuestTeam().getTeamName());
				re[i][6]=mdata.get(i).getScores().get(0);
				re[i][7]=mdata.get(i).getScores().get(1);
				re[i][8]=mdata.get(i).getScores().get(2);
				re[i][9]=mdata.get(i).getScores().get(3);				
				re[i][10]="";
				if(k==4){
					re[i][10]="无加时赛";
				}else{
					for(int m=4;m<k;m++){
						re[i][10]=((re[i][10]+"/"+mdata.get(i).getScores().get(m)));
						
						
					}
					String str=re[i][10].toString();
						
					str=str.substring(str.indexOf('/')+1);
					//System.out.println(str);
					re[i][10]=str;
					//System.out.println(re[i][10]);
				}
			}		
			return re;
		
		}
	}
	public static void changetabledata(String[]t,Object[][] d){
		matchlist.updateTable(t, d);
	}
}
