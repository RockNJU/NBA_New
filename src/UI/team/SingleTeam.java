package UI.team;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import UI.common.LimpidButton;

public class SingleTeam extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JButton basicbutton;
	JButton jinjiebutton;
	JButton matchbutton;
	JButton otherbutton;
	JButton  back;
	JPanel rightpanel;
	String t;
	String s;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		 try {
	            UIManager
	                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
		try {
			SingleTeam dialog = new SingleTeam();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Create the dialog.
	 * @throws SVGConverterException 
	 * @throws IOException 
	 * @throws TransformerException 
	 * @throws TransformerFactoryConfigurationError 
	 */
	public SingleTeam(String tpp,String season) throws TransformerFactoryConfigurationError, TransformerException, IOException, SVGConverterException {
		setSize(764,635);
		setLocation(200,50);
		this.t=tpp;
		this.s=s;
		setUndecorated(true);// ȡ����������Ч��************
		getContentPane().setLayout(null);
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
		BasicT newp=new BasicT(tpp,season);
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
		
		
		
		basicbutton = new JButton(new ImageIcon("pic/but/������Ϣǰ.png"));
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
            	otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/���ڱ���ǰ.png"));
            	
				try {
					BasicT b;
					b = new BasicT(t, s);
					change(b);
				} catch (TransformerFactoryConfigurationError e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SVGConverterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
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
            	otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	matchbutton.setIcon(new ImageIcon("pic/but/���ڱ���ǰ.png"));
            	JinT j=new JinT();
            	change(j);
            }
        });

		matchbutton = new JButton(new ImageIcon("pic/but/���ڱ���ǰ.png"));
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
            	//matchbutton.setIcon(new ImageIcon("pic/but/���ڱ���ǰ.png"));
            	
            }            
            @Override
            public void mouseClicked(MouseEvent e) {
            	matchbutton.setIcon(new ImageIcon("pic/but/���ڱ�����.png"));
            	jinjiebutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	otherbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	basicbutton.setIcon(new ImageIcon("pic/but/������Ϣǰ.png"));
            	MatT m=new MatT();
            	change(m);
            }
        });

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
            	matchbutton.setIcon(new ImageIcon("pic/but/���ڱ���ǰ.png"));
            	OtherT o=new OtherT();
            	change(o);
            }
        });
	
		jinjiebutton.setContentAreaFilled(false);
		otherbutton.setContentAreaFilled(false);
		basicbutton.setContentAreaFilled(false);
		matchbutton.setContentAreaFilled(false);
		jinjiebutton.setBorderPainted(true);
		otherbutton.setBorderPainted(false);
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

	void change(BasicT ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
	void change(JinT ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0,760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
	void change(MatT ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
	void change(OtherT ppanel){
		rightpanel.removeAll();
		rightpanel.add(ppanel);
		ppanel.setVisible(true);
		ppanel.setBounds(0, 0, 760,500);
		rightpanel.validate();
		rightpanel.repaint();
	}
}
