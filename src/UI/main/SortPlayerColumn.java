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
	 * String[] playerTotaltitle = { "1 序号  ", " 2球员名称  ", " 3所属球队  ", "参赛场数",
	 * "先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率", "罚球命中率", "进攻", "防守", "抢断",
	 * "盖帽", "失误", "犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率", "篮板率",
	 * "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率", "失误率", "使用率"
	 * ,"近五场得分提升率","近五场助攻提升率","近五场篮板提升率"}
	 */

	String[] playerTotaltitle = { " 序号  ", " 球员名称  ", " 所属球队  ", "参赛场数",
			"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率", "罚球命中率", "进攻", "防守",
			"抢断", "盖帽", "失误", "犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
			"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率", "失误率", "使用率",
			"近五场得分提升率", "近五场助攻提升率", "近五场篮板提升率" };
	String[] playerAvgtitle = { " 序号  ", " 球员名称  ", " 所属球队  ", "参赛场数", "先发场数",
			"场均篮板", "场均助攻", "上场时间", "投篮命中率", "三分命中率", "罚球命中率", "场均进攻", "场均防守",
			"场均抢断", "场均盖帽", "场均失误", "场均犯规", "场均得分", "效率 ", "GmSc效率值", "真实命中率",
			"投篮效率", "篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率", "失误率", "使用率",
			"近五场得分提升率", "近五场助攻提升率", "近五场篮板提升率" };

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
					String[] playerTotaltitle = { " 序号  ", " 球员名称  ",
							" 所属球队  ", "参赛数", "先发场数", "篮板", "助攻", "上场时间",
							"投篮命中率", "三分命中率", "罚球命中率", "进攻", "防守", "抢断", "盖帽",
							"失误", "犯规", "得分", "效率 ", "GmSc效率值", "真实命中率",
							"投篮效率", "篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率",
							"盖帽率", "失误率", "使用率", "近五场得分提升率", "近五场助攻提升率",
							"近五场篮板提升率" };
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
		setUndecorated(true);// 取消窗体修饰效果************
		setDragable();// 移动功能

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
		label.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label.setBounds(10, 82, 188, 36);
		contentPane.add(label);

		final JCheckBox 参赛场数 = new JCheckBox("\u53C2\u8D5B\u573A\u6570");

		参赛场数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		参赛场数.setBounds(20, 113, 95, 36);
		参赛场数.setOpaque(false);
		contentPane.add(参赛场数);
		jbs.add(参赛场数);
		final JCheckBox 先发场数 = new JCheckBox("\u5148\u53D1\u573A\u6570");
		先发场数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		先发场数.setBounds(133, 113, 95, 36);
		先发场数.setOpaque(false);
		contentPane.add(先发场数);
		jbs.add(先发场数);
		final JCheckBox 篮板 = new JCheckBox("\u7BEE\u677F");
		篮板.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		篮板.setBounds(242, 113, 67, 36);
		篮板.setOpaque(false);
		contentPane.add(篮板);
		jbs.add(篮板);
		final JCheckBox 助攻 = new JCheckBox("\u52A9\u653B");
		助攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		助攻.setBounds(318, 113, 67, 36);
		助攻.setOpaque(false);
		contentPane.add(助攻);
		jbs.add(助攻);
		final JCheckBox 上场时间 = new JCheckBox("\u4E0A\u573A\u65F6\u95F4");
		上场时间.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		上场时间.setBounds(399, 113, 95, 36);
		上场时间.setOpaque(false);
		contentPane.add(上场时间);
		jbs.add(上场时间);
		final JCheckBox 投篮命中率 = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u7387");
		投篮命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		投篮命中率.setBounds(20, 151, 114, 36);
		投篮命中率.setOpaque(false);
		contentPane.add(投篮命中率);
		jbs.add(投篮命中率);
		final JCheckBox 三分命中率 = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u7387");
		三分命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		三分命中率.setBounds(133, 151, 114, 36);
		三分命中率.setOpaque(false);
		contentPane.add(三分命中率);
		jbs.add(三分命中率);
		final JCheckBox 罚球命中率 = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u7387");
		罚球命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		罚球命中率.setBounds(242, 151, 106, 36);
		罚球命中率.setOpaque(false);
		contentPane.add(罚球命中率);
		jbs.add(罚球命中率);
		final JCheckBox 进攻 = new JCheckBox("\u8FDB\u653B");
		进攻.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		进攻.setBounds(358, 151, 67, 36);
		进攻.setOpaque(false);
		contentPane.add(进攻);
		jbs.add(进攻);
		final JCheckBox 防守 = new JCheckBox("\u9632\u5B88");
		防守.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		防守.setBounds(427, 151, 57, 36);
		防守.setOpaque(false);
		contentPane.add(防守);
		jbs.add(防守);
		final JCheckBox 抢断 = new JCheckBox("\u62A2\u65AD");
		抢断.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		抢断.setBounds(20, 189, 67, 36);
		抢断.setOpaque(false);
		contentPane.add(抢断);
		jbs.add(抢断);
		final JCheckBox 盖帽 = new JCheckBox("\u76D6\u5E3D");
		盖帽.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		盖帽.setBounds(104, 189, 67, 36);
		盖帽.setOpaque(false);
		contentPane.add(盖帽);
		jbs.add(盖帽);
		final JCheckBox 失误 = new JCheckBox("\u5931\u8BEF");
		失误.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		失误.setBounds(180, 189, 67, 36);
		失误.setOpaque(false);
		contentPane.add(失误);
		jbs.add(失误);
		final JCheckBox 犯规 = new JCheckBox("\u72AF\u89C4");
		犯规.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		犯规.setBounds(263, 189, 67, 36);
		犯规.setOpaque(false);
		contentPane.add(犯规);
		jbs.add(犯规);
		final JCheckBox 得分 = new JCheckBox("\u5F97\u5206");
		得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		得分.setBounds(344, 189, 67, 36);
		得分.setOpaque(false);
		contentPane.add(得分);
		jbs.add(得分);
		JLabel label_1 = new JLabel(
				"\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label_1.setBounds(10, 231, 188, 36);
		contentPane.add(label_1);

		final JCheckBox 效率 = new JCheckBox("\u6548\u7387");
		效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		效率.setBounds(20, 262, 67, 36);
		效率.setOpaque(false);
		contentPane.add(效率);
		jbs.add(效率);
		final JCheckBox Gmsc = new JCheckBox("GmSC\u6548\u7387\u503C");
		Gmsc.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		Gmsc.setBounds(89, 262, 114, 36);
		Gmsc.setOpaque(false);
		contentPane.add(Gmsc);
		jbs.add(Gmsc);

		final JCheckBox 真实命中率 = new JCheckBox("\u771F\u5B9E\u547D\u4E2D\u7387");
		真实命中率.setOpaque(false);
		真实命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		真实命中率.setBounds(204, 262, 114, 36);
		contentPane.add(真实命中率);
		jbs.add(真实命中率);
		final JCheckBox 投篮效率 = new JCheckBox("\u6295\u7BEE\u6548\u7387");
		投篮效率.setOpaque(false);
		投篮效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		投篮效率.setBounds(318, 262, 95, 36);
		contentPane.add(投篮效率);
		jbs.add(投篮效率);
		final JCheckBox 篮板率 = new JCheckBox("\u7BEE\u677F\u7387");
		篮板率.setOpaque(false);
		篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		篮板率.setBounds(421, 262, 73, 36);
		contentPane.add(篮板率);
		jbs.add(篮板率);
		final JCheckBox 进攻篮板数 = new JCheckBox("\u8FDB\u653B\u7BEE\u677F\u6570");
		进攻篮板数.setOpaque(false);
		进攻篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		进攻篮板数.setBounds(20, 300, 114, 36);
		contentPane.add(进攻篮板数);
		jbs.add(进攻篮板数);
		final JCheckBox 防守篮板数 = new JCheckBox("\u9632\u5B88\u7BEE\u677F\u6570");
		防守篮板数.setOpaque(false);
		防守篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		防守篮板数.setBounds(133, 300, 114, 36);
		contentPane.add(防守篮板数);
		jbs.add(防守篮板数);
		final JCheckBox 助攻率 = new JCheckBox("\u52A9\u653B\u7387");
		助攻率.setOpaque(false);
		助攻率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		助攻率.setBounds(257, 300, 73, 36);
		contentPane.add(助攻率);
		jbs.add(助攻率);
		final JCheckBox 抢断率 = new JCheckBox("\u62A2\u65AD\u7387");
		抢断率.setOpaque(false);
		抢断率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		抢断率.setBounds(338, 300, 73, 36);
		contentPane.add(抢断率);
		jbs.add(抢断率);
		final JCheckBox 盖帽率 = new JCheckBox("\u76D6\u5E3D\u7387");
		盖帽率.setOpaque(false);
		盖帽率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		盖帽率.setBounds(421, 300, 73, 36);
		contentPane.add(盖帽率);
		jbs.add(盖帽率);
		final JCheckBox 失误率 = new JCheckBox("\u5931\u8BEF\u7387");
		失误率.setOpaque(false);
		失误率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		失误率.setBounds(20, 338, 73, 36);
		contentPane.add(失误率);
		jbs.add(失误率);
		final JCheckBox 使用率 = new JCheckBox("\u4F7F\u7528\u7387");
		使用率.setOpaque(false);
		使用率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		使用率.setBounds(101, 338, 73, 36);
		contentPane.add(使用率);
		jbs.add(使用率);
		final JCheckBox 近五场得分提升率 = new JCheckBox(
				"\u8FD1\u4E94\u573A\u5F97\u5206\u63D0\u5347\u7387");
		近五场得分提升率.setOpaque(false);
		近五场得分提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		近五场得分提升率.setBounds(180, 338, 159, 36);
		contentPane.add(近五场得分提升率);
		jbs.add(近五场得分提升率);
		final JCheckBox 近五场助攻提升率 = new JCheckBox(
				"\u8FD1\u4E94\u573A\u52A9\u653B\u63D0\u5347\u7387");
		近五场助攻提升率.setOpaque(false);
		近五场助攻提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		近五场助攻提升率.setBounds(340, 338, 154, 36);
		contentPane.add(近五场助攻提升率);
		jbs.add(近五场助攻提升率);
		final JCheckBox 近五场篮板提升率 = new JCheckBox(
				"\u8FD1\u4E94\u573A\u7BEE\u677F\u63D0\u5347\u7387");
		近五场篮板提升率.setOpaque(false);
		近五场篮板提升率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		近五场篮板提升率.setBounds(20, 376, 159, 36);
		contentPane.add(近五场篮板提升率);
		jbs.add(近五场篮板提升率);
		JButton sure = new JButton("\u786E\u5B9A");
		sure.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		sure.setBounds(394, 394, 100, 36);
		contentPane.add(sure);
		/*
		 * " 序号  ", " 球员名称  ", " 所属球队  ","参赛数", "先发场数", "篮板", "助攻", "上场时间",
		 * "投篮命中率", "三分命中率", "罚球命中率", "进攻", "防守", "抢断", "盖帽", "失误", "犯规", "得分",
		 * "效率 ", "GmSc效率值", "真实命中率", "投篮效率", "篮板率", "进攻篮板数", "防守篮板数", "助攻率",
		 * "抢断率", "盖帽率", "失误率", "使用率" ,"近五场得分提升率","近五场助攻提升率","近五场篮板提升率"
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
				
				if(!firsttext.getText().equals("第一个筛选条件")){
					textforsort[0] = map.getItem(firsttext.getText());
					if(firstinfo.isSelected()){
						upordown[0] = false;
					}
				}
				if(!secondtext.getText().equals("第二个筛选条件")){
					textforsort[0] = map.getItem(secondtext.getText());
					if(secondinfo.isSelected()){
						upordown[0] = false;
					}
				}
				if(!thirdtext.getText().equals("第三个筛选条件")){
					textforsort[0] = map.getItem(thirdtext.getText());
					if(thirdinfo.isSelected()){
						upordown[0] = false;
					}
				}
				init.p.supersort(textforsort, upordown,isaverage);
				dispose();// 销毁窗体
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
		firstinfo.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		firstinfo.setBounds(20, 53, 151, 23);
		contentPane.add(firstinfo);

		ImageIcon image = new ImageIcon("pic/筛选背景.jpg");

		image.setImage(image.getImage().getScaledInstance(520, 450,
				Image.SCALE_DEFAULT));


		secondinfo.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		secondinfo.setBounds(180, 54, 151, 23);
		contentPane.add(secondinfo);


		thirdinfo.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		thirdinfo.setBounds(344, 54, 151, 23);
		contentPane.add(thirdinfo);

		firsttext = new JTextField();
		firsttext.setEditable(false);
		firsttext.setText("第一个筛选条件");
		firsttext.setBounds(20, 10, 151, 37);
		contentPane.add(firsttext);
		firsttext.setColumns(10);

		secondtext = new JTextField();
		secondtext.setEditable(false);
		secondtext.setText("第二个筛选条件");
		secondtext.setColumns(10);
		secondtext.setBounds(182, 10, 151, 37);
		contentPane.add(secondtext);

		thirdtext = new JTextField();
		thirdtext.setEditable(false);
		thirdtext.setText("第三个筛选条件");
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
					if (jbs.get(k).isSelected()) {// 表示要隐藏的列
						jbs.get(k).setSelected(false);
						firsttext.setText("第一个筛选条件");
						secondtext.setText("第二个筛选条件");
						thirdtext.setText("第三个筛选条件");
						firstinfo.setSelected(false);
						secondinfo.setSelected(false);
						thirdinfo.setSelected(false);
						averageornot.setSelected(false);
					}
				}
			}
		});
		button.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		button.setBounds(242, 394, 100, 36);
		contentPane.add(button);
		

		averageornot.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		averageornot.setBounds(344, 87, 151, 23);
		contentPane.add(averageornot);

		JLabel photo = new JLabel(image);
		photo.setBounds(0, 0, 520, 450);
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
	}

	private boolean do_this_whenclick(String text) {
		if (firsttext.getText().equals("第一个筛选条件")) {
			firsttext.setText(text);
			return true;
		} else if (secondtext.getText().equals("第二个筛选条件")) {
			secondtext.setText(text);
			return true;
		} else if (thirdtext.getText().equals("第三个筛选条件")) {
			thirdtext.setText(text);
			return true;
		} else
			return false;
	}

	protected void do_this_windowOpened(WindowEvent e) {
		final int height = this.getHeight();// 记录窗体高度
		new Thread() {// 创建新线程
			public void run() {
				Rectangle rec = getBounds();
				for (int i = 0; i <= 520; i += 10) {// 循环拉伸窗体
					setBounds(rec.x + 250 - i / 2, rec.y, i, height);// 不断设置窗体大小与位置
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
	private JTextField firsttext;
	private JTextField secondtext;
	private JTextField thirdtext;

	/**
	 * 设置可以拖动窗体
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
