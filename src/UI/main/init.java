package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.match.BasicM;
import UI.match.JinM;
import UI.match.SingleMatch;
import UI.player.BasicP;
import UI.player.JinP;
import UI.player.MatP;
import UI.player.OtherP;
import UI.player.SinglePlayer;
import UI.team.BasicT;
import UI.team.JinT;
import UI.team.MatT;
import UI.team.SingleTeam;
import VO.MatchVO;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;

public class init extends JFrame {

	private JPanel contentPane;
	JButton max;
	JButton min;
	JButton exit;
	JButton playerbutton;
	JButton matchbutton;
	JButton teambutton;
	JButton hotbutton;
	
	static JPanel rightpanel;
	static Player p;
	static Team t;
	static Match m;
	public static String currentpanel="";
	public static String currentdio="";
	public static RMIObject rmi=new RMIObject();
	int x,y;
	public static PlayerBLService pbl=rmi.getPlayerObject();
	public static TeamBLService tbl=rmi.getTeamObject();
	public static MatchBLService mbl=rmi.getMatchObject();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
	            UIManager
	                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
		EventQueue.invokeLater(new Runnable() {
			@Override
			
			public void run() {
				try {
					init frame = new init();
					frame.setVisible(true);
					listen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	static PanelUpdateThread f ;	
	protected static void listen(){
		//System.out.println("aaa");
		f=new PanelUpdateThread();
		Thread thread = new Thread(f);
		//System.out.println("ccc");
		thread.start();
	}
	static class PanelUpdateThread implements Runnable{
		@Override
		public void run() {	  
			
			while(true){
			//System.out.println("bbb");
            try {
              	 updatepanel(currentpanel);
              	 System.out.println("刷新"+currentpanel+"  "+currentdio);
                  Thread.sleep(10000);// 线程休眠3秒
              } catch (InterruptedException e1) {
                  e1.printStackTrace();
              } catch (TransformerFactoryConfigurationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SVGConverterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
          }
		}
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public init() {
		setTitle("NBA\u6570\u636E\u67E5\u8BE2\u5206\u6790\u7CFB\u7EDF");
		setUndecorated(true);// 取消窗体修饰效果************
		setDragable();//移动功能
		
		setSize(948, 679);
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		x=(screen.width-getWidth())/2;
		y=(screen.height-getHeight())/2-16;	
		setLocation(x,y);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(5,5,948,709);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowOpened(WindowEvent e) {
	             do_this_windowOpened(e);
	            
	        }
	    });
		
		
		
		/**
		 * TODO 
		 * 
		 * 可以对初始界面做出欢迎字样的改进
		 */
		rightpanel=new JPanel();
		rightpanel.setBounds(178,28,764,635);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		add(rightpanel);
		

		
		
		playerbutton = new JButton(new ImageIcon("pic/but/球员信息-na.png"));
    	playerbutton.setToolTipText("球员信息");
		playerbutton.setBounds(10, 215, 166, 57);
		contentPane.add(playerbutton);
		playerbutton.addMouseListener(new MouseListener() {
            
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
            	if(!playerbutton.getToolTipText().equals("球员信息 "))
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            	else
            		playerbutton.setIcon(new ImageIcon("pic/but/球员信息-active.png"));
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-stop.png"));
                // TODO Auto-generated method stub
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-ao.png"));
              	//teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	playerbutton.setToolTipText("球员信息 ");
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-active.png"));
            	teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));

            	hotbutton.setToolTipText("热门信息");
            	teambutton.setToolTipText("队伍信息");
            	matchbutton.setToolTipText("比赛信息");	
            	currentpanel="player";
            	//System.out.println(currentpanel);
				p = new Player();
				change(p);
            }
        });
		
		teambutton = new JButton(new ImageIcon("pic/but/队伍信息-na.png"));
    	teambutton.setToolTipText("队伍信息");
		teambutton.setBounds(10, 300, 167, 60);
		contentPane.add(teambutton);
		teambutton.addMouseListener(new MouseListener() {
            
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
            	if(!teambutton.getToolTipText().equals("队伍信息 "))
            		teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	else
            		teambutton.setIcon(new ImageIcon("pic/but/队伍信息-active.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	teambutton.setIcon(new ImageIcon("pic/but/队伍信息-stop.png"));
                // TODO Auto-generated method stub
            	//teambutton.setIcon(new ImageIcon("pic/but/队伍信息-ao.png"));
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	teambutton.setIcon(new ImageIcon("pic/but/队伍信息-active.png"));
            	hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            	
            	playerbutton.setToolTipText("球员信息");
            	hotbutton.setToolTipText("热门信息");
            	teambutton.setToolTipText("队伍信息 ");
            	matchbutton.setToolTipText("比赛信息");
            	currentpanel="team";
            	//System.out.println(currentpanel);
				t = new Team();
				change(t);
            }
        });

		matchbutton = new JButton(new ImageIcon("pic/but/比赛信息-na.png"));
    	matchbutton.setToolTipText("比赛信息");
		matchbutton.setBounds(10, 385, 166, 56);
		contentPane.add(matchbutton);
		matchbutton.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub      
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-ao.png"));
            }          
            @Override
            public void mouseExited(MouseEvent e) {
            	if(!matchbutton.getToolTipText().equals("比赛信息 "))
            		matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            	else
            		matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-active.png"));
                // TODO Auto-generated method stub
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-stop.png"));
                // TODO Auto-generated method stub
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-ao.png"));
            	//teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-active.png"));
            	teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            	
            	playerbutton.setToolTipText("球员信息");
            	hotbutton.setToolTipText("热门信息");
            	teambutton.setToolTipText("队伍信息");
            	matchbutton.setToolTipText("比赛信息 ");
            	Match p;		
            	currentpanel="match";
            	//System.out.println(currentpanel);
				p = new Match();
				change(p);
            }
        });

		hotbutton = new JButton(new ImageIcon("pic/but/热门信息-na.png"));
    	hotbutton.setToolTipText("热门信息");
		hotbutton.setBounds(10, 130, 165, 56);
		contentPane.add(hotbutton);
		hotbutton.addMouseListener(new MouseListener() {
            
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
            	if(!hotbutton.getToolTipText().equals("热门信息 "))
            		hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	else
            		hotbutton.setIcon(new ImageIcon("pic/but/热门信息-active.png"));
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	hotbutton.setIcon(new ImageIcon("pic/but/热门信息-stop.png"));
                // TODO Auto-generated method stub
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-ao.png"));
            	//teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	hotbutton.setIcon(new ImageIcon("pic/but/热门信息-active.png"));
            	teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            	
            	playerbutton.setToolTipText("球员信息");
            	hotbutton.setToolTipText("热门信息 ");
            	teambutton.setToolTipText("队伍信息");
            	matchbutton.setToolTipText("比赛信息");
            	Hot p;			
            	currentpanel="hot";
            	//System.out.println(currentpanel);
				p = new Hot();
				change(p);
            }
        });
	
		teambutton.setFocusPainted(false);
		hotbutton.setFocusPainted(false);
		playerbutton.setFocusPainted(false);
		matchbutton.setFocusPainted(false);
		//btnNewButton.setContentAreaFilled(false);
		teambutton.setContentAreaFilled(false);
		hotbutton.setContentAreaFilled(false);
		playerbutton.setContentAreaFilled(false);
		matchbutton.setContentAreaFilled(false);
		//最小化but
		min = new JButton(new ImageIcon("pic/but/rnormal.png"));
		min.setBounds(870, 6, 22, 22);
		contentPane.add(min);
		min.setBorderPainted(false);
		min.setFocusPainted(false);
		min.setContentAreaFilled(false);
		min.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
            	min.setIcon(new ImageIcon("pic/but/rnormal.png"));
                // TODO Auto-generated method stub                
            }           
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub    
            	min.setIcon(new ImageIcon("pic/but/ractive.png"));
            }          
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            	min.setIcon(new ImageIcon("pic/but/rover.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	
            	min.setIcon(new ImageIcon("pic/but/ractive.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	 setExtendedState(JFrame.ICONIFIED);
            }
        });
	
		
		
				//最da化but
				max = new JButton(new ImageIcon("pic/but/anormal.png"));
				max.setBounds(897, 6, 22, 22);
				contentPane.add(max);
				max.setBorderPainted(false);
				max.setFocusPainted(false);
				max.setContentAreaFilled(false);
				max.addMouseListener(new MouseListener() {
		            int i=0;
		            @Override
		            public void mouseReleased(MouseEvent e) {
		            	max.setIcon(new ImageIcon("pic/but/anormal.png"));
		                // TODO Auto-generated method stub                
		            }           
		            @Override
		            public void mousePressed(MouseEvent e) {
		                // TODO Auto-generated method stub    
		            	max.setIcon(new ImageIcon("pic/but/aactive.png"));
		            }          
		            @Override
		            public void mouseExited(MouseEvent e) {
		                // TODO Auto-generated method stub
		            	max.setIcon(new ImageIcon("pic/but/aover.png"));
		            }           
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	
		                // TODO Auto-generated method stub
		            	
		            	max.setIcon(new ImageIcon("pic/but/aactive.png"));
		            }
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	i++;
		            	 if (i%2==1) {

		                     setExtendedState(JFrame.MAXIMIZED_BOTH);

		                 } else {

		                     setExtendedState(JFrame.NORMAL);

		                 }
		            }
		        });
		
				//tuichubut
				exit = new JButton(new ImageIcon("pic/but/cnormal.png"));
				exit.setBounds(921, 6, 22, 22);
			    exit.setBorderPainted(false);
				exit.setFocusPainted(false);
				exit.setContentAreaFilled(false);
				contentPane.add(exit);
				exit.addMouseListener(new MouseListener() {
		            
		            @Override
		            public void mouseReleased(MouseEvent e) {
		            	exit.setIcon(new ImageIcon("pic/but/cnormal.png"));
		                // TODO Auto-generated method stub                
		            }           
		            @Override
		            public void mousePressed(MouseEvent e) {
		                // TODO Auto-generated method stub    
		            	exit.setIcon(new ImageIcon("pic/but/cactive.png"));
		            }          
		            @Override
		            public void mouseExited(MouseEvent e) {
		                // TODO Auto-generated method stub
		            	exit.setIcon(new ImageIcon("pic/but/cover.png"));
		            }           
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	
		                // TODO Auto-generated method stub
		            	
		            	exit.setIcon(new ImageIcon("pic/but/cactive.png"));
		            	
		            }            
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	dispose();// 销毁窗体
		            }
		        });
		
				/**
				 * 背景图片
				 */
        ImageIcon image = new ImageIcon("pic/整体界面3.png");
		image.setImage(image.getImage().getScaledInstance(948,679,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 948, 679);		
		photo.setOpaque(false);
		getContentPane().add(photo);
		
		setLocationRelativeTo(null);
		
	}
	
	 protected void do_this_windowOpened(WindowEvent e) {
	        final int height = this.getHeight();// 记录窗体高度
	        new Thread() {// 创建新线程
	            public void run() {
	            	Rectangle rec = getBounds();
	                for (int i = 0; i <= 948; i += 12) {// 循环拉伸窗体
	                	 setBounds(rec.x+460-i/2 , rec.y, i, height);// 不断设置窗体大小与位置
	                     try {
	                        Thread.sleep(1);// 线程休眠1毫秒
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }.start();// 启动线程
	        
	    }
	
	
	 private boolean isDragged = false;
	 private Point loc = null;
	 private Point tmp = null;
	 /**
		 * 设置可以拖动窗体
		 */
		protected void setDragable () {
			this.addMouseListener(new MouseAdapter() {

				public void mouseReleased (java.awt.event.MouseEvent e) {
					isDragged = false;
				}

				public void mousePressed (java.awt.event.MouseEvent e) {
					tmp = new Point(e.getX(), e.getY());
					isDragged = true;
				}

			});

			this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

				public void mouseDragged (java.awt.event.MouseEvent e) {
					if (isDragged) {
						loc = new Point(getLocation().x + e.getX() - tmp.x, getLocation().y + e.getY() - tmp.y);
						setLocation(loc);
					}
				}
			});
		}
       
		static void change(Player ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}
		static void change(Team ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0,764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}
		static void change(Hot ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}
		static void change(Match ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}

		static void updatepanel(String command) throws TransformerFactoryConfigurationError, TransformerException, IOException, SVGConverterException{
			String[] playerTotaltitle = { " 序号  ", " 球员名称  ", " 所属球队  ", 				 "参赛场数",
					"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率",
					"罚球命中率", "进攻", "防守", "抢断", "盖帽", "失误",
					"犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
					"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率",
					"失误率", "使用率" ,"近五场得分提升率","近五场助攻提升率","近五场篮板提升率"};
			String[] teamtitle={" 序号  "," 球队名称  "," 比赛场数  "," 投篮命中数  "," 投篮出手次数  "," 三分命中数  ",
					" 三分出手数  "," 罚球命中数  "," 罚球出手数  "," 进攻篮板数  "," 防守篮板数  "," 篮板数  "," 助攻数  ",
					" 抢断数  "," 盖帽数  "," 失误数  "," 犯规数  "," 比赛得分  "," 投篮命中率  "," 三分命中率  "," 罚球命中率  ",
					" 胜率  "," 进攻回合  ","防守回合"," 防守效率  "," 进攻效率  "," 进攻篮板率  "," 防守篮板率  "," 抢断效率  "," 助攻率  "};
			String[] matchtitle={"序号"," 日期  "," 赛季  "," 主队  "," 比分  "," 客队  ",
					" 第一节  "," 第二节  "," 第三节  "," 第四节  "," 加时赛  "};
			String[] playerinfo = { " 序号  ", " 姓名  ", " 球号  ", " 位置  ", " 身高  ",
					" 体重  ", " 出生日期  ", " 年龄  ", " 球龄  ", " 毕业院校  " };
			
			String com_panel[]=currentpanel.split("&");
			String com_dio[]=currentdio.split("&");
			if(currentdio!=""){
				String com2[]=com_dio[1].split(";");
				if(com_dio[0]=="4(1)"){
					BasicP p=new BasicP(com2[0],com2[1]);
					SinglePlayer.change(p);
				}
				//if(com_dio[0]=="4(2)"){
				//	JinP p=new JinP();
				//	SinglePlayer.change(p);
				//}
				if(com_dio[0]=="4(3)"){
					MatP p=new MatP(com2[0],com2[1]);
					SinglePlayer.change(p);
				}
				//if(com_dio[0]=="4(4)"){
				//	OtherP p=new OtherP();
				//	SinglePlayer.change(p);
				//}
				if(com_dio[0]=="7(1)"){
					BasicT p=new BasicT(com2[0],com2[1]);
					SingleTeam.change(p);
				}

				//if(com_dio[0]=="7(2)"){
				//	JinT p=new JinT();
				//	SingleTeam.change(p);
				//}
				if(com_dio[0]=="7(3)"){
					MatT p=new MatT(com2[0],com2[1]);
					SingleTeam.change(p);
				}

				if(com_dio[0]=="7(4)"){
					//OtherT p=new OtherT();
					//	SingleTeam.change(p);
				}
				if(com_dio[0]=="10(1)"){
					BasicM p=new BasicM(com2[0],com2[1]);
					SingleMatch.change(p);
				}

				//if(com_dio[0]=="10(2)"){
					
				//}
				//if(com_dio[0]=="10(3)"){
					
				//}
			}
			//if(currentdio==""){//如果dio为“”，那么当前panel是初始的
				//以下判断panel的刷新
			System.out.println("???///");
				if(com_panel[0].equals("hot")){//hot针对每个panel刷新
					String[] com2=com_panel[1].split(";");
					String[] panel1=com2[0].split(",");
					String[] panel2=com2[1].split(",");
					HotTeams ht = new HotTeams(panel2[0],panel2[1]);
					Hot.changep2(ht);		
					HotPlayers hp = new HotPlayers(panel1[0],panel1[1]);
					Hot.changep1(hp);
				}
				if(com_panel[0].equals("player")){//球员信息表格刷新
					Object[][] d=init.p.getinfodata(pbl.getAllPlayerInfo());
					init.p.changetabledata(playerinfo, d);
				}
				if(com_panel[0].equals("3")){//球员筛选表格刷新
					System.out.println("3");
					String[]com2=com_panel[1].split(";");
					if(com2.length==1){					
						ArrayList<PlayerSeasonDataVO>psvo = pbl.keyfind(com2[0]);					
						Object[][] data = init.p.getTotaldata(psvo);					
						init.p.changetabledata(playerTotaltitle, data);					
					}else if(com2.length==4){	
						System.out.println("fangfa");
						String Position = com2[1];					
						String Partition = com2[2];					
						String According = com2[3];
						String Season = com2[0];				
						ArrayList<PlayerSeasonDataVO>psvo = pbl.sort(Season, Position, Partition, According);					
						Object[][] data = init.p.getTotaldata(psvo);					
						init.p.changetabledata(playerTotaltitle, data);					
					}else{
						System.out.println("Player里不应出现这种情况");
					}			
				}
				if(com_panel[0].equals("team")){
					System.out.println("TEAM不需要变");
				}
				if(com_panel[0].equals("6")){
					String[] com2=com_panel[1].split(";");
					if(com2.length==1){
						ArrayList<TeamSeasonDataVO>tdvo =tbl.find(com2[0]);
		            	Object[][] data=init.t.getTotaldata(tdvo);
		            	init.t.changetabledata(teamtitle, data);
					}
					else if(com2.length==2){						
							ArrayList<TeamSeasonDataVO>tdvo=tbl.sort(com2[0], com2[1]);
			            	Object[][]data=init.t.getAveragedata(tdvo);
			            	init.t.changetabledata(teamtitle, data);
			            	//Team.teamlist.setVisible(true);						
					}else{
						System.out.println("team6里不应出现这种情况");
					}
				}
				if(com_panel[0].equals("9")){
					
						String[] com2=com_panel[1].split(";");
						if(com2.length==1){
							ArrayList<MatchVO>mvo=mbl.getMatchByTeamTime(com2[0]);             
				              Object[][] data=init.m.getdata(mvo);
				               init.m.changetabledata(matchtitle, data);
				              // Match.matchlist.hideColumn(2);	          
						}else if(com2.length==2){			
							ArrayList<MatchVO> mvo=mbl.getMatchBySeason(com2[0], com2[1]);		         
							Object[][] data=init.m.getdata(mvo);				          
							init.m.changetabledata(matchtitle, data);			         
							//Match. matchlist.hideColumn(2);										
						}else{
							System.out.println("match9里不应出现这种情况");
					 
						}
				}
			//}
			
			
			
			/**
			if(command.equals("")){
				System.out.println(command+"不用刷新");	
			}
			else if(command.equals("hot")){
				HotTeams ht = new HotTeams("球队赛季","得分");
				Hot.changep2(ht);		
				HotPlayers hp = new HotPlayers("每日","得分总");
				Hot.changep1(hp);
			}else if(command.equals("match")){
				System.out.println("match不需要变");
			}else if(command.equals("team")){
				System.out.println("team不需要变");
			}else if(command.equals("player")){
				//Object[][] d=Player.getinfodata(pbl.getAllPlayerInfo());
				//Player.changetabledata(playerinfo, d);
			}else{
				String[] com=command.split("&");
				if(com[0].equals("player")){
					if(com.length==3){
						String[]com2=com[2].split(";");
						BasicP p=new BasicP(com2[0],com2[1]);
						SinglePlayer.change(p);
					}else if(com.length==2){					
						String[]com2=com[1].split(";");
						if(com2.length==1){					
							ArrayList<PlayerSeasonDataVO>psvo = pbl.keyfind(com2[0]);					
							Object[][] data = Player.getTotaldata(psvo);					
							Player.changetabledata(playerTotaltitle, data);					
						}else if(com2.length==4){					
							String Position = com2[1];					
							String Partition = com2[2];					
							String According = com2[3];
							String Season = com2[0];				
							ArrayList<PlayerSeasonDataVO>psvo = pbl.sort(Season, Position, Partition, According);
						//System.out.println(Season + Position + Partition + According);						
							Object[][] data = Player.getTotaldata(psvo);					
							Player.changetabledata(playerTotaltitle, data);					
						}else{						
							System.out.println("player未知错误");						
						}					
					}													
				}else if(com[0].equals("team")){
					if(com.length==3){
						String[]com2=com[2].split(";");
						BasicT p=new BasicT(com2[0],com2[1]);
						SingleTeam.change(p);
					}

					if(com.length==2){
						String[] com2=com[1].split(";");
						if(com2.length==1){
							ArrayList<TeamSeasonDataVO>tdvo =tbl.find(com2[0]);
			            	Object[][] data=Team.getTotaldata(tdvo);
			            	Team.changetabledata(teamtitle, data);
						}

						if(com2.length==2){
							if(com2[0].length()==3){
								BasicT p=new BasicT(com2[0],com2[1]);
								SingleTeam.change(p);
							}else{
								ArrayList<TeamSeasonDataVO>tdvo=tbl.sort(com2[0], com2[1]);
				            	Object[][]data=Team.getTotaldata(tdvo);
				            	Team.changetabledata(teamtitle, data);
				            	//Team.teamlist.setVisible(true);
							}
						}else{
							System.out.println("team未知错误");	
						}
					}
				}else if(com[0].equals("match")){
					if(com.length==2){
						String[] com2=com[1].split(";");
						if(com2.length==1){
							ArrayList<MatchVO>mvo=mbl.getMatchByTeamTime(com2[0]);             
				              Object[][] data=Match.getdata(mvo);
				               Match.changetabledata(matchtitle, data);
				              // Match.matchlist.hideColumn(2);	          
						}else{
							
							ArrayList<MatchVO> mvo=mbl.getMatchBySeason(com2[0], com2[1]);
			            	
				               
				              Object[][] data=Match.getdata(mvo);
				               Match.changetabledata(matchtitle, data);
				              //Match. matchlist.hideColumn(2);
			            	
			            	
						}
					}else if(com.length==3){
						String[]com2=com[2].split(";");
						BasicM p=new BasicM(com2[0],com2[1]);
						SingleMatch.change(p);
					}
				}else if(com[0].equals("hot")){
					//"hot&"+"每日,得分总;球队赛季,得分";
					String[] com2=com[1].split(";");
					String[] panel1=com2[0].split(",");
					String[] panel2=com2[1].split(",");
					HotTeams ht = new HotTeams(panel2[0],panel2[1]);
					Hot.changep2(ht);		
					HotPlayers hp = new HotPlayers(panel1[0],panel1[1]);
					Hot.changep1(hp);
				}else{
					System.out.println("未知错误");	
				}
				
		
			}*/
			
		}
	
}
