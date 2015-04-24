package UI.match;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import UI.common.LimpidButton;


public class SingleMatch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JButton basicbutton;
	JButton jinjiebutton;
	JButton matchbutton;
	//JButton otherbutton;
	LimpidButton  back;
	JPanel rightpanel;
	String t;
	String d;
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
		try {
			SingleMatch dialog = new SingleMatch("ATL","2014-01-03");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SingleMatch(String team,String date) {
		setSize(764,635);
		setLocation(200,50);
		setUndecorated(true);// 取消窗体修饰效果************
		getContentPane().setLayout(null);
		this.t=team;
		this.d=date;
		/**
		 * TODO 
		 * 
		 * 可以对初始界面做出欢迎字样的改进
		 */
		rightpanel=new JPanel();
		rightpanel.setBounds(2,125,760,500);
		rightpanel.setOpaque(false);
		rightpanel.setLayout(null);
		add(rightpanel);
		BasicM newp=new BasicM(t,d);
		newp.setLocation(0, 0);
		rightpanel.add(newp);
		
		//((JComponent) getContentPane()).setOpaque(false);
		back = new LimpidButton("","pic/but/返回.png");
		back.setBounds(681, 6, 80, 30);
		getContentPane().add(back);
		back.setVisible(false);
		back.addMouseListener(new MouseListener() {
         
		
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
            	dispose();// 销毁窗体
            }
        });
		
		
		
		basicbutton = new JButton(new ImageIcon("pic/but/基础信息后.png"));
		basicbutton.setBounds(10, 33, 191, 90);
		getContentPane().add(basicbutton);
		basicbutton.addMouseListener(new MouseListener() {
            
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
            	//basicbutton.setIcon(new ImageIcon("pic/but/基础信息前.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            	//basicbutton.setIcon(new ImageIcon("pic/but/基础信息后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	basicbutton.setIcon(new ImageIcon("pic/but/基础信息后.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/进阶信息前.png"));
            	//otherbutton.setIcon(new ImageIcon("pic/but/其他信息前.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/队员数据前.png"));
            	BasicM b=new BasicM(t,d);
            	change(b);
            }
        });
		
		jinjiebutton = new JButton(new ImageIcon("pic/but/进阶信息前.png"));
		jinjiebutton.setBounds(196, 33, 191, 90);
		getContentPane().add(jinjiebutton);
		jinjiebutton.addMouseListener(new MouseListener() {
            
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
            	//jinjiebutton.setIcon(new ImageIcon("pic/but/进阶信息前.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	//jinjiebutton.setIcon(new ImageIcon("pic/but/进阶信息后.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	jinjiebutton.setIcon(new ImageIcon("pic/but/进阶信息后.png"));
            	//otherbutton.setIcon(new ImageIcon("pic/but/其他信息前.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/基础信息前.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/队员数据前.png"));
            	JinM j=new JinM();
            	change(j);
            }
        });

		matchbutton = new JButton(new ImageIcon("pic/but/队员数据前.png"));
		matchbutton.setBounds(382, 33, 191, 90);
		getContentPane().add(matchbutton);
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
            	//matchbutton.setIcon(new ImageIcon("pic/but/队员数据前.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("pic/but/队员数据后.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/进阶信息前.png"));
            	//otherbutton.setIcon(new ImageIcon("pic/but/其他信息前.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/基础信息前.png"));
            	MatM m=new MatM();
            	change(m);
            }
        });
/*
		otherbutton = new JButton(new ImageIcon("pic/but/其他信息前.png"));
		otherbutton.setBounds(568, 33, 191, 90);
		getContentPane().add(otherbutton);
		otherbutton.addMouseListener(new MouseListener() {
            
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
            	//otherbutton.setIcon(new ImageIcon("pic/but/其他信息前.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	//otherbutton.setIcon(new ImageIcon("pic/but/热门信息-active.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	otherbutton.setIcon(new ImageIcon("pic/but/其他信息后.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/进阶信息前.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/基础信息前.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/队员数据前.png"));
            	OtherM o=new OtherM();
            	change(o);
            }
        });
	*/
		jinjiebutton.setContentAreaFilled(false);
		//otherbutton.setContentAreaFilled(false);
		basicbutton.setContentAreaFilled(false);
		matchbutton.setContentAreaFilled(false);
		jinjiebutton.setBorderPainted(true);
		//otherbutton.setBorderPainted(false);
		basicbutton.setBorderPainted(false);
		matchbutton.setBorderPainted(false);
		
		
		/**
		 * 背景图片
		 */

		ImageIcon image = new ImageIcon("pic/详细界面.png");
		image.setImage(image.getImage().getScaledInstance(764,635,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 764,635);		
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
		
		addMouseMotionListener(new MouseMotionListener() {

			/**
			* 处理鼠标拖动事件
			* */
			public void mouseDragged(MouseEvent arg0) {
			
			}

			/**
			* 处理鼠标移动事件
			* */
			public void mouseMoved(MouseEvent arg0) {
				
				if(arg0.getX()>back.getX() && arg0.getX() <back.getX()+back.getWidth()
						&&
						arg0.getY()>back.getY() && arg0.getY()<back.getY()+back.getHeight()){
					back.setVisible(true);
				}
				else{	
					back.setVisible(false);
					
				}
			
			}

			});
	}

	void change(BasicM ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
	void change(JinM ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
	void change(MatM ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
	void change(OtherM ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
}
