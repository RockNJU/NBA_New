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
		setUndecorated(true);// ȡ����������Ч��************
		getContentPane().setLayout(null);
		this.t=team;
		this.d=date;
		/**
		 * TODO 
		 * 
		 * ���ԶԳ�ʼ����������ӭ�����ĸĽ�
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
		back = new LimpidButton("","pic/but/����.png");
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
            	dispose();// ���ٴ���
            }
        });
		
		
		
		basicbutton = new JButton(new ImageIcon("pic/but/������Ϣ��.png"));
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
            	//basicbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            	//basicbutton.setIcon(new ImageIcon("pic/but/������Ϣ��.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	basicbutton.setIcon(new ImageIcon("pic/but/������Ϣ��.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	//otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/��Ա����ǰ.png"));
            	BasicM b=new BasicM(t,d);
            	change(b);
            }
        });
		
		jinjiebutton = new JButton(new ImageIcon("pic/but/������Ϣǰ.png"));
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
            	//jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	//jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣ��.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣ��.png"));
            	//otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/��Ա����ǰ.png"));
            	JinM j=new JinM();
            	change(j);
            }
        });

		matchbutton = new JButton(new ImageIcon("pic/but/��Ա����ǰ.png"));
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
            	//matchbutton.setIcon(new ImageIcon("pic/but/������Ϣ-ao.png"));
            }          
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            	//matchbutton.setIcon(new ImageIcon("pic/but/������Ϣ-na.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	//matchbutton.setIcon(new ImageIcon("pic/but/��Ա����ǰ.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("pic/but/��Ա���ݺ�.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	//otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	MatM m=new MatM();
            	change(m);
            }
        });
/*
		otherbutton = new JButton(new ImageIcon("pic/but/������Ϣǰ.png"));
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
            	//otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            }           
            @Override
            public void mouseEntered(MouseEvent e) {
            	
                // TODO Auto-generated method stub
            	//otherbutton.setIcon(new ImageIcon("pic/but/������Ϣ-active.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	otherbutton.setIcon(new ImageIcon("pic/but/������Ϣ��.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/��Ա����ǰ.png"));
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
		 * ����ͼƬ
		 */

		ImageIcon image = new ImageIcon("pic/��ϸ����.png");
		image.setImage(image.getImage().getScaledInstance(764,635,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 764,635);		
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
		
		addMouseMotionListener(new MouseMotionListener() {

			/**
			* ��������϶��¼�
			* */
			public void mouseDragged(MouseEvent arg0) {
			
			}

			/**
			* ��������ƶ��¼�
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
