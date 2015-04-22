package UI.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class init extends JFrame {

	private JPanel contentPane;
	JButton max;
	JButton min;
	JButton exit;
	JButton playerbutton;
	JButton matchbutton;
	JButton teambutton;
	JButton hotbutton;
	
	JPanel rightpanel;
	 
	
	int x,y;
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            	//playerbutton.setIcon(new ImageIcon("pic/but/球员信息-ao.png"));
              	//teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            	playerbutton.setIcon(new ImageIcon("pic/but/球员信息-active.png"));
            	teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            	hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            	Player p;				
				p = new Player();
				change(p);
            }
        });
		
		teambutton = new JButton(new ImageIcon("pic/but/队伍信息-na.png"));
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
            	//teambutton.setIcon(new ImageIcon("pic/but/队伍信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
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
            	Team p;				
				p = new Team();
				change(p);
            }
        });

		matchbutton = new JButton(new ImageIcon("pic/but/比赛信息-na.png"));
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
                // TODO Auto-generated method stub
            	//matchbutton.setIcon(new ImageIcon("pic/but/比赛信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
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
            	Match p;				
				p = new Match();
				change(p);
            }
        });

		hotbutton = new JButton(new ImageIcon("pic/but/热门信息-na.png"));
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
            	//hotbutton.setIcon(new ImageIcon("pic/but/热门信息-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
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
            	Hot p;				
				p = new Hot();
				change(p);
            }
        });
	
		teambutton.setFocusPainted(false);
		hotbutton.setFocusPainted(false);
		playerbutton.setFocusPainted(false);
		matchbutton.setFocusPainted(false);
	
		
		//最小化but
		min = new JButton(new ImageIcon("pic/but/rnormal.png"));
		min.setBounds(870, 6, 20, 20);
		contentPane.add(min);
		min.setBorderPainted(false);
		min.setFocusPainted(false);
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
				max.setBounds(897, 6, 20, 20);
				contentPane.add(max);
				max.setBorderPainted(false);
				max.setFocusPainted(false);
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
				exit.setBounds(921, 6, 20, 20);
			    exit.setBorderPainted(false);
				exit.setFocusPainted(false);
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
        ImageIcon image = new ImageIcon("pic/整体界面.png");
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
	                for (int i = 0; i <= 948; i += 6) {// 循环拉伸窗体
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
       
		void change(Player ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}
		void change(Team ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0,764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}
		void change(Hot ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}
		void change(Match ppanel){
			rightpanel.removeAll();
			rightpanel.add(ppanel);
			ppanel.setVisible(true);
			ppanel.setBounds(0, 0, 764, 635);
			rightpanel.validate();
			rightpanel.repaint();
		}

}
