package UI.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ChooseTeamColumn extends JFrame {

	private JPanel contentPane;
	int x,y;
	JRadioButton info;
	JButton exit;
	String[] title;
	ArrayList<JCheckBox> jbs=new ArrayList<JCheckBox>(); 
	/*String[] teamTotaltitle = { "1 ���  ", " 2��Ա����  ", " 3�������  ", "��������",
			"�ȷ�����", "����", "����", "�ϳ�ʱ��", "Ͷ��������", "����������",
			"����������", "����", "����", "����", "��ñ", "ʧ��",
			"����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��",
			"������", "����������", "����������", "������", "������", "��ñ��",
			"ʧ����", "ʹ����" ,"���峡�÷�������","���峡����������","���峡����������"}*/
	
	String[] teamTotaltitle ={" ���  "," �������  "," ��������  "," Ͷ��������  "," Ͷ�����ִ���  "," ����������  ",
			" ���ֳ�����  "," ����������  "," ���������  "," ����������  "," ����������  "," ������  "," ������  ",
			" ������  "," ��ñ��  "," ʧ����  "," ������  "," �����÷�  "," Ͷ��������  "," ����������  "," ����������  ",
			" ʤ��  "," �����غ�  "," ����Ч��  "," ����Ч��  "," ����������  "," ����������  "," ����Ч��  "," ������  "};
	
	String[] teamAvgtitle = { " ���  "," �������  "," ��������  "," ����Ͷ��������  "," ����Ͷ�����ִ���  "," ��������������  ",
			" �������ֳ�����  "," ��������������  "," �������������  "," ��������������  "," ��������������  "," ����������  "," ����������  ",
			" ����������  "," ������ñ��  "," ����ʧ����  "," ����������  "," ���������÷�  "," Ͷ��������  "," ����������  "," ����������  ",
			" ʤ��  "," ���������غ�  "," ����Ч��  "," ����Ч��  "," ����������  "," ����������  "," ����Ч��  "," ������  "};
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
			public void run() {
				try {
					
					ChooseTeamColumn frame = new ChooseTeamColumn();
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
	public ChooseTeamColumn() {
		setUndecorated(true);// ȡ����������Ч��************
		setDragable();//�ƶ�����
	
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		x=(screen.width-getWidth())/2;
		y=(screen.height-getHeight())/2-16;	
		setLocation(x,y);
		
		setSize( 520, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowOpened(WindowEvent e) {
	             do_this_windowOpened(e);
	            
	        }
	    });
		
		
	
		
		
		
		
		JLabel basicinfo = new JLabel("\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		basicinfo.setFont(new Font("����������W9", Font.PLAIN, 18));
		basicinfo.setBounds(10, 10, 147, 36);
		contentPane.add(basicinfo);
		
		JCheckBox ������� = new JCheckBox("\u7403\u961F\u540D\u79F0");
		�������.setFont(new Font("����������W9", Font.PLAIN, 16));
		�������.setEnabled(false);
		�������.setSelected(true);
		�������.setBounds(20, 40, 95, 36);
		�������.setOpaque(false);
		contentPane.add(�������);
		jbs.add(�������);
		JLabel label = new JLabel("\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("����������W9", Font.PLAIN, 18));
		label.setBounds(10, 82, 188, 36);
		contentPane.add(label);
		
		final JCheckBox �������� = new JCheckBox("\u6BD4\u8D5B\u573A\u6570");
		��������.setSelected(true);
		��������.setFont(new Font("����������W9", Font.PLAIN, 16));
		��������.setBounds(20, 113, 95, 36);
		��������.setOpaque(false);
		contentPane.add(��������);
		jbs.add(��������);
		final JCheckBox Ͷ�������� = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u6570");
		Ͷ��������.setSelected(true);
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 16));
		Ͷ��������.setBounds(133, 113, 114, 36);
		Ͷ��������.setOpaque(false);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		final JCheckBox Ͷ�����ִ��� = new JCheckBox("\u6295\u7BEE\u51FA\u624B\u6570");
		Ͷ�����ִ���.setSelected(true);
		Ͷ�����ִ���.setFont(new Font("����������W9", Font.PLAIN, 16));
		Ͷ�����ִ���.setBounds(263, 113, 134, 36);
		Ͷ�����ִ���.setOpaque(false);
		contentPane.add(Ͷ�����ִ���);
		jbs.add(Ͷ�����ִ���);
		final JCheckBox ���������� = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u6570");
		����������.setSelected(true);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(399, 113, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���ֳ��ִ��� = new JCheckBox("\u4E09\u5206\u51FA\u624B\u6570");
		���ֳ��ִ���.setSelected(true);
		���ֳ��ִ���.setFont(new Font("����������W9", Font.PLAIN, 16));
		���ֳ��ִ���.setBounds(20, 151, 137, 36);
		���ֳ��ִ���.setOpaque(false);
		contentPane.add(���ֳ��ִ���);
		jbs.add(���ֳ��ִ���);
		final JCheckBox ���������� = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u6570");
		����������.setSelected(true);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(133, 151, 114, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ��������� = new JCheckBox("\u7F5A\u7403\u51FA\u624B\u6570");
		���������.setSelected(true);
		���������.setFont(new Font("����������W9", Font.PLAIN, 16));
		���������.setBounds(263, 151, 106, 36);
		���������.setOpaque(false);
		contentPane.add(���������);
		jbs.add(���������);
		final JCheckBox ���������� = new JCheckBox("\u8FDB\u653B\u7BEE\u677F\u6570");
		����������.setSelected(true);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(399, 151, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���������� = new JCheckBox("\u9632\u5B88\u7BEE\u677F\u6570");
		����������.setSelected(true);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(20, 189, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ��ñ�� = new JCheckBox("\u76D6\u5E3D\u6570");
		��ñ��.setSelected(true);
		��ñ��.setFont(new Font("����������W9", Font.PLAIN, 16));
		��ñ��.setBounds(432, 189, 73, 36);
		��ñ��.setOpaque(false);
		contentPane.add(��ñ��);
		jbs.add(��ñ��);
		final JCheckBox ʧ���� = new JCheckBox("\u5931\u8BEF\u6570");
		ʧ����.setSelected(true);
		ʧ����.setFont(new Font("����������W9", Font.PLAIN, 16));
		ʧ����.setBounds(20, 227, 73, 36);
		ʧ����.setOpaque(false);
		contentPane.add(ʧ����);
		jbs.add(ʧ����);
		final JCheckBox ������ = new JCheckBox("\u72AF\u89C4\u6570");
		������.setSelected(true);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(133, 227, 83, 36);
		������.setOpaque(false);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox �����÷� = new JCheckBox("\u6BD4\u8D5B\u5F97\u5206");
		�����÷�.setSelected(true);
		�����÷�.setFont(new Font("����������W9", Font.PLAIN, 16));
		�����÷�.setBounds(237, 227, 102, 36);
		�����÷�.setOpaque(false);
		contentPane.add(�����÷�);
		jbs.add(�����÷�);
		JLabel label_1 = new JLabel("\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 259, 188, 36);
		contentPane.add(label_1);
		
		final JCheckBox �����غ� = new JCheckBox("\u8FDB\u653B\u56DE\u5408");
		�����غ�.setSelected(true);
		�����غ�.setFont(new Font("����������W9", Font.PLAIN, 16));
		�����غ�.setBounds(20, 328, 114, 36);
		�����غ�.setOpaque(false);
		contentPane.add(�����غ�);
		jbs.add(�����غ�);
		final JCheckBox ������ = new JCheckBox("\u7BEE\u677F\u6570");
		������.setSelected(true);
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(133, 189, 73, 36);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox ������ = new JCheckBox("\u52A9\u653B\u6570");
		������.setSelected(true);
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(237, 189, 73, 36);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox ������ = new JCheckBox("\u62A2\u65AD\u6570");
		������.setSelected(true);
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(340, 189, 73, 36);
		contentPane.add(������);
		jbs.add(������);
		/**
		 * ����ͼƬ
		 */

		
		final JCheckBox Ͷ�������� = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setSelected(true);
		Ͷ��������.setOpaque(false);
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 16));
		Ͷ��������.setBounds(20, 290, 114, 36);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		final JCheckBox ���������� = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setSelected(true);
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(152, 290, 114, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���������� = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setSelected(true);
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(285, 290, 112, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ����Ч�� = new JCheckBox("\u8FDB\u653B\u6548\u7387");
		����Ч��.setSelected(true);
		����Ч��.setOpaque(false);
		����Ч��.setFont(new Font("����������W9", Font.PLAIN, 16));
		����Ч��.setBounds(152, 328, 95, 36);
		contentPane.add(����Ч��);
		jbs.add(����Ч��);
		final JCheckBox ����Ч�� = new JCheckBox("\u9632\u5B88\u6548\u7387");
		����Ч��.setSelected(true);
		����Ч��.setOpaque(false);
		����Ч��.setFont(new Font("����������W9", Font.PLAIN, 16));
		����Ч��.setBounds(285, 328, 102, 36);
		contentPane.add(����Ч��);
		jbs.add(����Ч��);
		final JCheckBox ���������� = new JCheckBox("\u8FDB\u653B\u7BEE\u677F\u7387");
		����������.setSelected(true);
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(399, 328, 106, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���������� = new JCheckBox("\u9632\u5B88\u7BEE\u677F\u7387");
		����������.setSelected(true);
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(20, 366, 137, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ʤ�� = new JCheckBox("\u80DC\u7387");
		ʤ��.setSelected(true);
		ʤ��.setOpaque(false);
		ʤ��.setFont(new Font("����������W9", Font.PLAIN, 16));
		ʤ��.setBounds(421, 290, 73, 36);
		contentPane.add(ʤ��);
		jbs.add(ʤ��);
		final JCheckBox ����Ч�� = new JCheckBox("\u62A2\u65AD\u6548\u7387");
		����Ч��.setSelected(true);
		����Ч��.setOpaque(false);
		����Ч��.setFont(new Font("����������W9", Font.PLAIN, 16));
		����Ч��.setBounds(152, 366, 114, 36);
		contentPane.add(����Ч��);
		jbs.add(����Ч��);
		final JCheckBox ������ = new JCheckBox("\u52A9\u653B\u7387");
		������.setSelected(true);
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(285, 366, 154, 36);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox checkBox_3 = new JCheckBox("\u5168\u9009");
		checkBox_3.setSelected(true);
		checkBox_3.setOpaque(false);
		checkBox_3.setFont(new Font("��Բ", Font.PLAIN, 14));
		checkBox_3.setBounds(437, 82, 57, 36);
		contentPane.add(checkBox_3);
		checkBox_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox_3.isSelected()){
				

					��������.setSelected(true);					
					Ͷ��������.setSelected(true);
					Ͷ�����ִ���.setSelected(true);
					����������.setSelected(true);
					���ֳ��ִ���.setSelected(true);
					����������.setSelected(true);							
					���������.setSelected(true);
					����������.setSelected(true);
					����������.setSelected(true);
					������.setSelected(true);
					������.setSelected(true);
					������.setSelected(true);
					��ñ��.setSelected(true);
					ʧ����.setSelected(true);								
					������.setSelected(true);
					�����÷�.setSelected(true);
				}
				else{
					��������.setSelected(false);					
					Ͷ��������.setSelected(false);
					Ͷ�����ִ���.setSelected(false);
					����������.setSelected(false);
					���ֳ��ִ���.setSelected(false);
					����������.setSelected(false);							
					���������.setSelected(false);
					����������.setSelected(false);
					����������.setSelected(false);
					������.setSelected(false);
					������.setSelected(false);
					������.setSelected(false);
					��ñ��.setSelected(false);
					ʧ����.setSelected(false);								
					������.setSelected(false);
					�����÷�.setSelected(false);
				}
				
			}
			
		});
		
		final JCheckBox checkBox_5 = new JCheckBox("\u5168\u9009");
		checkBox_5.setSelected(true);
		checkBox_5.setOpaque(false);
		checkBox_5.setFont(new Font("��Բ", Font.PLAIN, 14));
		checkBox_5.setBounds(437, 259, 57, 36);
		contentPane.add(checkBox_5);
		checkBox_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(checkBox_5.isSelected()){
					�����غ�.setSelected(true);
					Ͷ��������.setSelected(true);
					����������.setSelected(true);
					
					����������.setSelected(true);
					����Ч��.setSelected(true);
					����Ч��.setSelected(true);
					����������.setSelected(true);
								
					����������.setSelected(true);
					ʤ��.setSelected(true);
					����Ч��.setSelected(true);
					������.setSelected(true);
				}
				else{
					�����غ�.setSelected(false);
					Ͷ��������.setSelected(false);
					����������.setSelected(false);
					
					����������.setSelected(false);
					����Ч��.setSelected(false);
					����Ч��.setSelected(false);
					����������.setSelected(false);
								
					����������.setSelected(false);
					ʤ��.setSelected(false);
					����Ч��.setSelected(false);
					������.setSelected(false);
				}
				
			}
			
		});
		JButton sure = new JButton("\u786E\u5B9A");
		sure.setFont(new Font("����������W9", Font.PLAIN, 20));
		sure.setBounds(204, 400, 100, 30);
		contentPane.add(sure);
		/*" ���  ", " ��Ա����  ", " �������  ","������",
		"�ȷ�����", "����", "����", "�ϳ�ʱ��", "Ͷ��������", "����������",
		"����������", "����", "����", "����", "��ñ", "ʧ��",
		"����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��",
		"������", "����������", "����������", "������", "������", "��ñ��",
		"ʧ����", "ʹ����" ,"���峡�÷�������","���峡����������","���峡����������"*/
		sure.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("a");
				// TODO Auto-generated method stub
				if(info.isSelected()){
					title=teamAvgtitle;
				}else{
					title=teamTotaltitle;
				}
				int hide=0;
				System.out.println("hide"+hide);
				ArrayList<Integer> hides=new ArrayList<Integer>();
				for(int k=0;k<jbs.size();k++){
					if(!jbs.get(k).isSelected()){//��ʾҪ���ص���
						hide++;
						hides.add(k+1);
					}
				}
				int [] hidecolumns=new int[hide];
				for(int m=0;m<hide;m++){
					hidecolumns[m]=hides.get(m);
					//System.out.print(hidecolumns[m]);
				}
				//System.out.println();
				//TODO ��������
				
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JLabel label_2 = new JLabel("\u8868\u683C\u663E\u793A\u9009\u9879\uFF1A");
		label_2.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_2.setBounds(275, 10, 147, 36);
		contentPane.add(label_2);
		
		info = new JRadioButton("\u663E\u793A\u573A\u5747\u6570\u636E");
		info.setFont(new Font("����������W9", Font.PLAIN, 16));
		info.setBounds(285, 48, 127, 23);
		contentPane.add(info);
		

		ImageIcon image = new ImageIcon("pic/ɸѡ����.jpg");

		image.setImage(image.getImage().getScaledInstance(520, 450,Image.SCALE_DEFAULT));
		
		
		JLabel photo = new JLabel(image);
		photo.setBounds(0, 0, 520, 450);
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
	}
	
	
	
	 protected void do_this_windowOpened(WindowEvent e) {
	        final int height = this.getHeight();// ��¼����߶�
	        new Thread() {// �������߳�
	            public void run() {
	            	Rectangle rec = getBounds();
	                for (int i = 0; i <= 520; i += 5) {// ѭ�����촰��
	                	 setBounds(rec.x+250-i/2 , rec.y, i, height);// �������ô����С��λ��
	                     try {
	                        Thread.sleep(1);// �߳�����1����
	                    } catch (InterruptedException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }.start();// �����߳�
	    }
	
	
	
	private boolean isDragged = false;
	 private Point loc = null;
	 private Point tmp = null;
	 /**
		 * ���ÿ����϶�����
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
}
