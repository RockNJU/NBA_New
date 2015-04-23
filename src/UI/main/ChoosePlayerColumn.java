package UI.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class ChoosePlayerColumn extends JFrame  {

	private JPanel contentPane;
	int x,y;
	ArrayList<JCheckBox> jcs=new ArrayList<JCheckBox>();
	JButton exit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] playerTotaltitle = {" ���  ", " ��Ա����  ", " �������  ","������",
							"�ȷ�����", "����", "����", "�ϳ�ʱ��", "Ͷ��������", "����������",
							"����������", "����", "����", "����", "��ñ", "ʧ��",
							"����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��",
							"������", "����������", "����������", "������", "������", "��ñ��",
							"ʧ����", "ʹ����" ,"���峡�÷�������","���峡����������","���峡����������"};
					ChoosePlayerColumn frame = new ChoosePlayerColumn(playerTotaltitle);
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
	public ChoosePlayerColumn(String[] title) {
		setUndecorated(true);// ȡ����������Ч��************
		setDragable();//�ƶ�����
		contentPane.setLayout(null);
		Toolkit toolkit= Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		x=(screen.width-getWidth())/2;
		y=(screen.height-getHeight())/2-16;	
		setLocation(x,y);
		
		setSize( 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowOpened(WindowEvent e) {
	             do_this_windowOpened(e);
	            
	        }
	    });
		
		
		/*" ���  ", " ��Ա����  ", " �������  ","������",
		"�ȷ�����", "����", "����", "�ϳ�ʱ��", "Ͷ��������", "����������",
		"����������", "����", "����", "����", "��ñ", "ʧ��",
		"����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��",
		"������", "����������", "����������", "������", "������", "��ñ��",
		"ʧ����", "ʹ����" ,"���峡�÷�������","���峡����������","���峡����������"*/
		
		
		
		
		
		JLabel basicinfo = new JLabel("\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		basicinfo.setFont(new Font("����������W9", Font.PLAIN, 18));
		basicinfo.setBounds(10, 10, 147, 36);
		contentPane.add(basicinfo);
		
		JCheckBox ��Ա���� = new JCheckBox("\u7403\u5458\u540D\u79F0");
		��Ա����.setFont(new Font("����������W9", Font.PLAIN, 15));
		��Ա����.setEnabled(false);
		��Ա����.setSelected(true);
		��Ա����.setBounds(20, 40, 95, 36);
		contentPane.add(��Ա����);
		
		JCheckBox ������� = new JCheckBox("\u6240\u5C5E\u7403\u961F");
		�������.setSelected(true);
		�������.setFont(new Font("����������W9", Font.PLAIN, 15));
		�������.setBounds(133, 40, 95, 36);
		contentPane.add(�������);
		
		JLabel label = new JLabel("\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("����������W9", Font.PLAIN, 18));
		label.setBounds(10, 82, 188, 36);
		contentPane.add(label);
		
		JCheckBox �������� = new JCheckBox("\u53C2\u8D5B\u573A\u6570");
		��������.setSelected(true);
		��������.setFont(new Font("����������W9", Font.PLAIN, 15));
		��������.setBounds(20, 113, 95, 36);
		contentPane.add(��������);
		
		JCheckBox �ȷ����� = new JCheckBox("\u5148\u53D1\u573A\u6570");
		�ȷ�����.setSelected(true);
		�ȷ�����.setFont(new Font("����������W9", Font.PLAIN, 15));
		�ȷ�����.setBounds(133, 113, 95, 36);
		contentPane.add(�ȷ�����);
		
		JCheckBox ���� = new JCheckBox("\u7BEE\u677F");
		����.setSelected(true);
		����.setFont(new Font("����������W9", Font.PLAIN, 15));
		����.setBounds(242, 113, 67, 36);
		contentPane.add(����);
		
		JCheckBox ���� = new JCheckBox("\u52A9\u653B");
		����.setSelected(true);
		����.setFont(new Font("����������W9", Font.PLAIN, 15));
		����.setBounds(318, 113, 67, 36);
		contentPane.add(����);
		
		JCheckBox �ϳ�ʱ�� = new JCheckBox("\u4E0A\u573A\u65F6\u95F4");
		�ϳ�ʱ��.setSelected(true);
		�ϳ�ʱ��.setFont(new Font("����������W9", Font.PLAIN, 15));
		�ϳ�ʱ��.setBounds(399, 113, 95, 36);
		contentPane.add(�ϳ�ʱ��);
		
		JCheckBox Ͷ�������� = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setSelected(true);
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 15));
		Ͷ��������.setBounds(20, 151, 114, 36);
		contentPane.add(Ͷ��������);
		
		JCheckBox ���������� = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setSelected(true);
		����������.setFont(new Font("����������W9", Font.PLAIN, 15));
		����������.setBounds(133, 151, 114, 36);
		contentPane.add(����������);
		
		JCheckBox ���������� = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setSelected(true);
		����������.setFont(new Font("����������W9", Font.PLAIN, 15));
		����������.setBounds(242, 151, 106, 36);
		contentPane.add(����������);
		
		JCheckBox ���� = new JCheckBox("\u8FDB\u653B");
		����.setSelected(true);
		����.setFont(new Font("����������W9", Font.PLAIN, 15));
		����.setBounds(358, 151, 67, 36);
		contentPane.add(����);
		
		JCheckBox ���� = new JCheckBox("\u9632\u5B88");
		����.setSelected(true);
		����.setFont(new Font("����������W9", Font.PLAIN, 15));
		����.setBounds(427, 151, 55, 36);
		contentPane.add(����);
		
		JCheckBox ���� = new JCheckBox("\u62A2\u65AD");
		����.setSelected(true);
		����.setFont(new Font("����������W9", Font.PLAIN, 15));
		����.setBounds(20, 189, 67, 36);
		contentPane.add(����);
		
		JCheckBox ��ñ = new JCheckBox("\u76D6\u5E3D");
		��ñ.setSelected(true);
		��ñ.setFont(new Font("����������W9", Font.PLAIN, 15));
		��ñ.setBounds(104, 189, 67, 36);
		contentPane.add(��ñ);
		
		JCheckBox ʧ�� = new JCheckBox("\u5931\u8BEF");
		ʧ��.setSelected(true);
		ʧ��.setFont(new Font("����������W9", Font.PLAIN, 15));
		ʧ��.setBounds(180, 189, 67, 36);
		contentPane.add(ʧ��);
		
		JCheckBox ���� = new JCheckBox("\u72AF\u89C4");
		����.setSelected(true);
		����.setFont(new Font("����������W9", Font.PLAIN, 15));
		����.setBounds(263, 189, 67, 36);
		contentPane.add(����);
		
		JCheckBox �÷� = new JCheckBox("\u5F97\u5206");
		�÷�.setSelected(true);
		�÷�.setFont(new Font("����������W9", Font.PLAIN, 15));
		�÷�.setBounds(344, 189, 67, 36);
		contentPane.add(�÷�);
		
		JLabel label_1 = new JLabel("\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 231, 188, 36);
		contentPane.add(label_1);
		
		JCheckBox Ч�� = new JCheckBox("\u6548\u7387");
		Ч��.setSelected(true);
		Ч��.setFont(new Font("����������W9", Font.PLAIN, 15));
		Ч��.setBounds(20, 262, 67, 36);
		contentPane.add(Ч��);
		
		JCheckBox Gmsc = new JCheckBox("GmSC\u6548\u7387\u503C");
		Gmsc.setSelected(true);
		Gmsc.setFont(new Font("����������W9", Font.PLAIN, 15));
		Gmsc.setBounds(97, 262, 114, 36);
		contentPane.add(Gmsc);

		
		/**
		 * ����ͼƬ
		 */

		ImageIcon image = new ImageIcon("pic/������ʾ.png");

		image.setImage(image.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT));
	
		
		JLabel photo = new JLabel(image);
		photo.setBounds(225, 10, 500, 400);
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
	}
	
	
	
	 protected void do_this_windowOpened(WindowEvent e) {
	        final int height = this.getHeight();// ��¼����߶�
	        new Thread() {// �������߳�
	            public void run() {
	            	Rectangle rec = getBounds();
	                for (int i = 0; i <= 500; i += 5) {// ѭ�����촰��
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
