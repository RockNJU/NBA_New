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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import UI.common.SortItem_Map;

public class SortPlayerColumn extends JFrame {

	private JPanel contentPane;
	int x, y;
	JRadioButton firstinfo;
	JButton exit;
	String[] title;
	SortItem_Map map = new SortItem_Map();
	ArrayList<JCheckBox> jbs = new ArrayList<JCheckBox>();
	JRadioButton secondinfo = new JRadioButton(
			"\u9009\u4E2D\u4E3A\u964D\u5E8F");
	JRadioButton thirdinfo = new JRadioButton(
			"\u9009\u4E2D\u4E3A\u964D\u5E8F");
	JRadioButton averageornot = new JRadioButton("\u9009\u4E2D\u8F93\u51FA\u5E73\u5747\u503C");
	/*
	 * String[] playerTotaltitle = { "1 ���  ", " 2��Ա����  ", " 3�������  ", "��������",
	 * "�ȷ�����", "����", "����", "�ϳ�ʱ��", "Ͷ��������", "����������", "����������", "����", "����", "����",
	 * "��ñ", "ʧ��", "����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��", "������",
	 * "����������", "����������", "������", "������", "��ñ��", "ʧ����", "ʹ����"
	 * ,"���峡�÷�������","���峡����������","���峡����������"}
	 */

	String[] playerTotaltitle = { " ���  ", " ��Ա����  ", " �������  ", "��������",
			"�ȷ�����", "����", "����", "�ϳ�ʱ��", "Ͷ��������", "����������", "����������", "����", "����",
			"����", "��ñ", "ʧ��", "����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��",
			"������", "����������", "����������", "������", "������", "��ñ��", "ʧ����", "ʹ����",
			"���峡�÷�������", "���峡����������", "���峡����������" };
	String[] playerAvgtitle = { " ���  ", " ��Ա����  ", " �������  ", "��������", "�ȷ�����",
			"��������", "��������", "�ϳ�ʱ��", "Ͷ��������", "����������", "����������", "��������", "��������",
			"��������", "������ñ", "����ʧ��", "��������", "�����÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������",
			"Ͷ��Ч��", "������", "����������", "����������", "������", "������", "��ñ��", "ʧ����", "ʹ����",
			"���峡�÷�������", "���峡����������", "���峡����������" };

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
					String[] playerTotaltitle = { " ���  ", " ��Ա����  ",
							" �������  ", "������", "�ȷ�����", "����", "����", "�ϳ�ʱ��",
							"Ͷ��������", "����������", "����������", "����", "����", "����", "��ñ",
							"ʧ��", "����", "�÷�", "Ч�� ", "GmScЧ��ֵ", "��ʵ������",
							"Ͷ��Ч��", "������", "����������", "����������", "������", "������",
							"��ñ��", "ʧ����", "ʹ����", "���峡�÷�������", "���峡����������",
							"���峡����������" };
					SortPlayerColumn frame = new SortPlayerColumn();
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
	public SortPlayerColumn() {
		setUndecorated(true);// ȡ����������Ч��************
		setDragable();// �ƶ�����

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		x = (screen.width - getWidth()) / 2;
		y = (screen.height - getHeight()) / 2 - 16;
		setLocation(x, y);

		setSize(520, 450);
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
		JLabel label = new JLabel(
				"\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("����������W9", Font.PLAIN, 18));
		label.setBounds(10, 82, 188, 36);
		contentPane.add(label);

		final JCheckBox �������� = new JCheckBox("\u53C2\u8D5B\u573A\u6570");

		��������.setFont(new Font("����������W9", Font.PLAIN, 16));
		��������.setBounds(20, 113, 95, 36);
		��������.setOpaque(false);
		contentPane.add(��������);
		jbs.add(��������);
		final JCheckBox �ȷ����� = new JCheckBox("\u5148\u53D1\u573A\u6570");
		�ȷ�����.setFont(new Font("����������W9", Font.PLAIN, 16));
		�ȷ�����.setBounds(133, 113, 95, 36);
		�ȷ�����.setOpaque(false);
		contentPane.add(�ȷ�����);
		jbs.add(�ȷ�����);
		final JCheckBox ���� = new JCheckBox("\u7BEE\u677F");
		����.setFont(new Font("����������W9", Font.PLAIN, 16));
		����.setBounds(242, 113, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JCheckBox ���� = new JCheckBox("\u52A9\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 16));
		����.setBounds(318, 113, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JCheckBox �ϳ�ʱ�� = new JCheckBox("\u4E0A\u573A\u65F6\u95F4");
		�ϳ�ʱ��.setFont(new Font("����������W9", Font.PLAIN, 16));
		�ϳ�ʱ��.setBounds(399, 113, 95, 36);
		�ϳ�ʱ��.setOpaque(false);
		contentPane.add(�ϳ�ʱ��);
		jbs.add(�ϳ�ʱ��);
		final JCheckBox Ͷ�������� = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u7387");
		Ͷ��������.setFont(new Font("����������W9", Font.PLAIN, 16));
		Ͷ��������.setBounds(20, 151, 114, 36);
		Ͷ��������.setOpaque(false);
		contentPane.add(Ͷ��������);
		jbs.add(Ͷ��������);
		final JCheckBox ���������� = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(133, 151, 114, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���������� = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u7387");
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(242, 151, 106, 36);
		����������.setOpaque(false);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���� = new JCheckBox("\u8FDB\u653B");
		����.setFont(new Font("����������W9", Font.PLAIN, 16));
		����.setBounds(358, 151, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JCheckBox ���� = new JCheckBox("\u9632\u5B88");
		����.setFont(new Font("����������W9", Font.PLAIN, 16));
		����.setBounds(427, 151, 57, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JCheckBox ���� = new JCheckBox("\u62A2\u65AD");
		����.setFont(new Font("����������W9", Font.PLAIN, 16));
		����.setBounds(20, 189, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JCheckBox ��ñ = new JCheckBox("\u76D6\u5E3D");
		��ñ.setFont(new Font("����������W9", Font.PLAIN, 16));
		��ñ.setBounds(104, 189, 67, 36);
		��ñ.setOpaque(false);
		contentPane.add(��ñ);
		jbs.add(��ñ);
		final JCheckBox ʧ�� = new JCheckBox("\u5931\u8BEF");
		ʧ��.setFont(new Font("����������W9", Font.PLAIN, 16));
		ʧ��.setBounds(180, 189, 67, 36);
		ʧ��.setOpaque(false);
		contentPane.add(ʧ��);
		jbs.add(ʧ��);
		final JCheckBox ���� = new JCheckBox("\u72AF\u89C4");
		����.setFont(new Font("����������W9", Font.PLAIN, 16));
		����.setBounds(263, 189, 67, 36);
		����.setOpaque(false);
		contentPane.add(����);
		jbs.add(����);
		final JCheckBox �÷� = new JCheckBox("\u5F97\u5206");
		�÷�.setFont(new Font("����������W9", Font.PLAIN, 16));
		�÷�.setBounds(344, 189, 67, 36);
		�÷�.setOpaque(false);
		contentPane.add(�÷�);
		jbs.add(�÷�);
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("����������W9", Font.PLAIN, 18));
		label_1.setBounds(10, 231, 188, 36);
		contentPane.add(label_1);

		final JCheckBox Ч�� = new JCheckBox("\u6548\u7387");
		Ч��.setFont(new Font("����������W9", Font.PLAIN, 16));
		Ч��.setBounds(20, 262, 67, 36);
		Ч��.setOpaque(false);
		contentPane.add(Ч��);
		jbs.add(Ч��);
		final JCheckBox Gmsc = new JCheckBox("GmSC\u6548\u7387\u503C");
		Gmsc.setFont(new Font("����������W9", Font.PLAIN, 16));
		Gmsc.setBounds(89, 262, 114, 36);
		Gmsc.setOpaque(false);
		contentPane.add(Gmsc);
		jbs.add(Gmsc);

		final JCheckBox ��ʵ������ = new JCheckBox("\u771F\u5B9E\u547D\u4E2D\u7387");
		��ʵ������.setOpaque(false);
		��ʵ������.setFont(new Font("����������W9", Font.PLAIN, 16));
		��ʵ������.setBounds(204, 262, 114, 36);
		contentPane.add(��ʵ������);
		jbs.add(��ʵ������);
		final JCheckBox Ͷ��Ч�� = new JCheckBox("\u6295\u7BEE\u6548\u7387");
		Ͷ��Ч��.setOpaque(false);
		Ͷ��Ч��.setFont(new Font("����������W9", Font.PLAIN, 16));
		Ͷ��Ч��.setBounds(318, 262, 95, 36);
		contentPane.add(Ͷ��Ч��);
		jbs.add(Ͷ��Ч��);
		final JCheckBox ������ = new JCheckBox("\u7BEE\u677F\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(421, 262, 73, 36);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox ���������� = new JCheckBox("\u8FDB\u653B\u7BEE\u677F\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(20, 300, 114, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ���������� = new JCheckBox("\u9632\u5B88\u7BEE\u677F\u6570");
		����������.setOpaque(false);
		����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		����������.setBounds(133, 300, 114, 36);
		contentPane.add(����������);
		jbs.add(����������);
		final JCheckBox ������ = new JCheckBox("\u52A9\u653B\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(257, 300, 73, 36);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox ������ = new JCheckBox("\u62A2\u65AD\u7387");
		������.setOpaque(false);
		������.setFont(new Font("����������W9", Font.PLAIN, 16));
		������.setBounds(338, 300, 73, 36);
		contentPane.add(������);
		jbs.add(������);
		final JCheckBox ��ñ�� = new JCheckBox("\u76D6\u5E3D\u7387");
		��ñ��.setOpaque(false);
		��ñ��.setFont(new Font("����������W9", Font.PLAIN, 16));
		��ñ��.setBounds(421, 300, 73, 36);
		contentPane.add(��ñ��);
		jbs.add(��ñ��);
		final JCheckBox ʧ���� = new JCheckBox("\u5931\u8BEF\u7387");
		ʧ����.setOpaque(false);
		ʧ����.setFont(new Font("����������W9", Font.PLAIN, 16));
		ʧ����.setBounds(20, 338, 73, 36);
		contentPane.add(ʧ����);
		jbs.add(ʧ����);
		final JCheckBox ʹ���� = new JCheckBox("\u4F7F\u7528\u7387");
		ʹ����.setOpaque(false);
		ʹ����.setFont(new Font("����������W9", Font.PLAIN, 16));
		ʹ����.setBounds(101, 338, 73, 36);
		contentPane.add(ʹ����);
		jbs.add(ʹ����);
		final JCheckBox ���峡�÷������� = new JCheckBox(
				"\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387");
		���峡�÷�������.setOpaque(false);
		���峡�÷�������.setFont(new Font("����������W9", Font.PLAIN, 16));
		���峡�÷�������.setBounds(180, 338, 159, 36);
		contentPane.add(���峡�÷�������);
		jbs.add(���峡�÷�������);
		final JCheckBox ���峡���������� = new JCheckBox(
				"\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387");
		���峡����������.setOpaque(false);
		���峡����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		���峡����������.setBounds(340, 338, 154, 36);
		contentPane.add(���峡����������);
		jbs.add(���峡����������);
		final JCheckBox ���峡���������� = new JCheckBox(
				"\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387");
		���峡����������.setOpaque(false);
		���峡����������.setFont(new Font("����������W9", Font.PLAIN, 16));
		���峡����������.setBounds(20, 376, 159, 36);
		contentPane.add(���峡����������);
		jbs.add(���峡����������);
		JButton sure = new JButton("\u786E\u5B9A");
		sure.setFont(new Font("����������W9", Font.PLAIN, 20));
		sure.setBounds(394, 394, 100, 36);
		contentPane.add(sure);
		/*
		 * " ���  ", " ��Ա����  ", " �������  ","������", "�ȷ�����", "����", "����", "�ϳ�ʱ��",
		 * "Ͷ��������", "����������", "����������", "����", "����", "����", "��ñ", "ʧ��", "����", "�÷�",
		 * "Ч�� ", "GmScЧ��ֵ", "��ʵ������", "Ͷ��Ч��", "������", "����������", "����������", "������",
		 * "������", "��ñ��", "ʧ����", "ʹ����" ,"���峡�÷�������","���峡����������","���峡����������"
		 */
		sure.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String[] textforsort = {null,null,null};
				boolean[] upordown = {true,true,true};
				boolean isaverage = false;
				
				if(averageornot.isSelected()){
					isaverage = true;
				}
				
				if(!firsttext.getText().equals("��һ��ɸѡ����")){
					textforsort[0] = map.getItem(firsttext.getText());
					if(firstinfo.isSelected()){
						upordown[0] = false;
					}
				}
				if(!secondtext.getText().equals("�ڶ���ɸѡ����")){
					textforsort[0] = map.getItem(secondtext.getText());
					if(secondinfo.isSelected()){
						upordown[0] = false;
					}
				}
				if(!thirdtext.getText().equals("������ɸѡ����")){
					textforsort[0] = map.getItem(thirdtext.getText());
					if(thirdinfo.isSelected()){
						upordown[0] = false;
					}
				}
				init.p.supersort(textforsort, upordown,isaverage);
				dispose();// ���ٴ���
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

		firstinfo = new JRadioButton("\u9009\u4E2D\u4E3A\u964D\u5E8F");
		firstinfo.setFont(new Font("����������W9", Font.PLAIN, 16));
		firstinfo.setBounds(20, 53, 151, 23);
		contentPane.add(firstinfo);

		ImageIcon image = new ImageIcon("pic/ɸѡ����.jpg");

		image.setImage(image.getImage().getScaledInstance(520, 450,
				Image.SCALE_DEFAULT));


		secondinfo.setFont(new Font("����������W9", Font.PLAIN, 16));
		secondinfo.setBounds(180, 54, 151, 23);
		contentPane.add(secondinfo);


		thirdinfo.setFont(new Font("����������W9", Font.PLAIN, 16));
		thirdinfo.setBounds(344, 54, 151, 23);
		contentPane.add(thirdinfo);

		firsttext = new JTextField();
		firsttext.setEditable(false);
		firsttext.setText("��һ��ɸѡ����");
		firsttext.setBounds(20, 10, 151, 37);
		contentPane.add(firsttext);
		firsttext.setColumns(10);

		secondtext = new JTextField();
		secondtext.setEditable(false);
		secondtext.setText("�ڶ���ɸѡ����");
		secondtext.setColumns(10);
		secondtext.setBounds(182, 10, 151, 37);
		contentPane.add(secondtext);

		thirdtext = new JTextField();
		thirdtext.setEditable(false);
		thirdtext.setText("������ɸѡ����");
		thirdtext.setColumns(10);
		thirdtext.setBounds(344, 10, 151, 37);
		contentPane.add(thirdtext);

		for (int k = 0; k < jbs.size(); k++) {
			final JCheckBox tempjb = jbs.get(k);
				final String name = tempjb.getText();
				tempjb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean temp = do_this_whenclick(name);
						if (temp == false) {
							tempjb.setSelected(false);
						}
					}
				});
			
		}

		JButton button = new JButton("\u6E05\u7A7A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int k = 0; k < jbs.size(); k++) {
					if (jbs.get(k).isSelected()) {// ��ʾҪ���ص���
						jbs.get(k).setSelected(false);
						firsttext.setText("��һ��ɸѡ����");
						secondtext.setText("�ڶ���ɸѡ����");
						thirdtext.setText("������ɸѡ����");
						firstinfo.setSelected(false);
						secondinfo.setSelected(false);
						thirdinfo.setSelected(false);
						averageornot.setSelected(false);
					}
				}
			}
		});
		button.setFont(new Font("����������W9", Font.PLAIN, 20));
		button.setBounds(242, 394, 100, 36);
		contentPane.add(button);
		

		averageornot.setFont(new Font("����������W9", Font.PLAIN, 16));
		averageornot.setBounds(344, 87, 151, 23);
		contentPane.add(averageornot);

		JLabel photo = new JLabel(image);
		photo.setBounds(0, 0, 520, 450);
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
	}

	private boolean do_this_whenclick(String text) {
		if (firsttext.getText().equals("��һ��ɸѡ����")) {
			firsttext.setText(text);
			return true;
		} else if (secondtext.getText().equals("�ڶ���ɸѡ����")) {
			secondtext.setText(text);
			return true;
		} else if (thirdtext.getText().equals("������ɸѡ����")) {
			thirdtext.setText(text);
			return true;
		} else
			return false;
	}

	protected void do_this_windowOpened(WindowEvent e) {
		final int height = this.getHeight();// ��¼����߶�
		new Thread() {// �������߳�
			public void run() {
				Rectangle rec = getBounds();
				for (int i = 0; i <= 520; i += 10) {// ѭ�����촰��
					setBounds(rec.x + 250 - i / 2, rec.y, i, height);// �������ô����С��λ��
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
	private JTextField firsttext;
	private JTextField secondtext;
	private JTextField thirdtext;

	/**
	 * ���ÿ����϶�����
	 */
	protected void setDragable() {
		this.addMouseListener(new MouseAdapter() {

			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}

		});

		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(getLocation().x + e.getX() - tmp.x,
							getLocation().y + e.getY() - tmp.y);
					setLocation(loc);
				}
			}
		});
	}
}
