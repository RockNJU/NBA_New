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
	/*String[] teamTotaltitle = { "1 序号  ", " 2球员名称  ", " 3所属球队  ", "参赛场数",
			"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率",
			"罚球命中率", "进攻", "防守", "抢断", "盖帽", "失误",
			"犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
			"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率",
			"失误率", "使用率" ,"近五场得分提升率","近五场助攻提升率","近五场篮板提升率"}*/
	
	String[] teamTotaltitle ={" 序号  "," 球队名称  "," 比赛场数  "," 投篮命中数  "," 投篮出手次数  "," 三分命中数  ",
			" 三分出手数  "," 罚球命中数  "," 罚球出手数  "," 进攻篮板数  "," 防守篮板数  "," 篮板数  "," 助攻数  ",
			" 抢断数  "," 盖帽数  "," 失误数  "," 犯规数  "," 比赛得分  "," 投篮命中率  "," 三分命中率  "," 罚球命中率  ",
			" 胜率  "," 进攻回合  "," 进攻效率  "," 防守效率  "," 进攻篮板率  "," 防守篮板率  "," 抢断效率  "," 助攻率  "};
	
	String[] teamAvgtitle = { " 序号  "," 球队名称  "," 比赛场数  "," 场均投篮命中数  "," 场均投篮出手次数  "," 场均三分命中数  ",
			" 场均三分出手数  "," 场均罚球命中数  "," 场均罚球出手数  "," 场均进攻篮板数  "," 场均防守篮板数  "," 场均篮板数  "," 场均助攻数  ",
			" 场均抢断数  "," 场均盖帽数  "," 场均失误数  "," 场均犯规数  "," 场均比赛得分  "," 投篮命中率  "," 三分命中率  "," 罚球命中率  ",
			" 胜率  "," 场均进攻回合  "," 进攻效率  "," 防守效率  "," 进攻篮板率  "," 防守篮板率  "," 抢断效率  "," 助攻率  "};
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
		setUndecorated(true);// 取消窗体修饰效果************
		setDragable();//移动功能
	
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
		basicinfo.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		basicinfo.setBounds(10, 10, 147, 36);
		contentPane.add(basicinfo);
		
		JCheckBox 球队名称 = new JCheckBox("\u7403\u961F\u540D\u79F0");
		球队名称.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		球队名称.setEnabled(false);
		球队名称.setSelected(true);
		球队名称.setBounds(20, 40, 95, 36);
		球队名称.setOpaque(false);
		contentPane.add(球队名称);
		jbs.add(球队名称);
		JLabel label = new JLabel("\u6BD4\u8D5B\u57FA\u7840\u4FE1\u606F\u9009\u9879\uFF1A");
		label.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label.setBounds(10, 82, 188, 36);
		contentPane.add(label);
		
		final JCheckBox 比赛场数 = new JCheckBox("\u6BD4\u8D5B\u573A\u6570");
		比赛场数.setSelected(true);
		比赛场数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		比赛场数.setBounds(20, 113, 95, 36);
		比赛场数.setOpaque(false);
		contentPane.add(比赛场数);
		jbs.add(比赛场数);
		final JCheckBox 投篮命中数 = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u6570");
		投篮命中数.setSelected(true);
		投篮命中数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		投篮命中数.setBounds(133, 113, 114, 36);
		投篮命中数.setOpaque(false);
		contentPane.add(投篮命中数);
		jbs.add(投篮命中数);
		final JCheckBox 投篮出手次数 = new JCheckBox("\u6295\u7BEE\u51FA\u624B\u6570");
		投篮出手次数.setSelected(true);
		投篮出手次数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		投篮出手次数.setBounds(263, 113, 134, 36);
		投篮出手次数.setOpaque(false);
		contentPane.add(投篮出手次数);
		jbs.add(投篮出手次数);
		final JCheckBox 三分命中数 = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u6570");
		三分命中数.setSelected(true);
		三分命中数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		三分命中数.setBounds(399, 113, 106, 36);
		三分命中数.setOpaque(false);
		contentPane.add(三分命中数);
		jbs.add(三分命中数);
		final JCheckBox 三分出手次数 = new JCheckBox("\u4E09\u5206\u51FA\u624B\u6570");
		三分出手次数.setSelected(true);
		三分出手次数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		三分出手次数.setBounds(20, 151, 137, 36);
		三分出手次数.setOpaque(false);
		contentPane.add(三分出手次数);
		jbs.add(三分出手次数);
		final JCheckBox 罚球命中数 = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u6570");
		罚球命中数.setSelected(true);
		罚球命中数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		罚球命中数.setBounds(133, 151, 114, 36);
		罚球命中数.setOpaque(false);
		contentPane.add(罚球命中数);
		jbs.add(罚球命中数);
		final JCheckBox 罚球出手数 = new JCheckBox("\u7F5A\u7403\u51FA\u624B\u6570");
		罚球出手数.setSelected(true);
		罚球出手数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		罚球出手数.setBounds(263, 151, 106, 36);
		罚球出手数.setOpaque(false);
		contentPane.add(罚球出手数);
		jbs.add(罚球出手数);
		final JCheckBox 进攻篮板数 = new JCheckBox("\u8FDB\u653B\u7BEE\u677F\u6570");
		进攻篮板数.setSelected(true);
		进攻篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		进攻篮板数.setBounds(399, 151, 106, 36);
		进攻篮板数.setOpaque(false);
		contentPane.add(进攻篮板数);
		jbs.add(进攻篮板数);
		final JCheckBox 防守篮板数 = new JCheckBox("\u9632\u5B88\u7BEE\u677F\u6570");
		防守篮板数.setSelected(true);
		防守篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		防守篮板数.setBounds(20, 189, 106, 36);
		防守篮板数.setOpaque(false);
		contentPane.add(防守篮板数);
		jbs.add(防守篮板数);
		final JCheckBox 盖帽数 = new JCheckBox("\u76D6\u5E3D\u6570");
		盖帽数.setSelected(true);
		盖帽数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		盖帽数.setBounds(432, 189, 73, 36);
		盖帽数.setOpaque(false);
		contentPane.add(盖帽数);
		jbs.add(盖帽数);
		final JCheckBox 失误数 = new JCheckBox("\u5931\u8BEF\u6570");
		失误数.setSelected(true);
		失误数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		失误数.setBounds(20, 227, 73, 36);
		失误数.setOpaque(false);
		contentPane.add(失误数);
		jbs.add(失误数);
		final JCheckBox 犯规数 = new JCheckBox("\u72AF\u89C4\u6570");
		犯规数.setSelected(true);
		犯规数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		犯规数.setBounds(133, 227, 83, 36);
		犯规数.setOpaque(false);
		contentPane.add(犯规数);
		jbs.add(犯规数);
		final JCheckBox 比赛得分 = new JCheckBox("\u6BD4\u8D5B\u5F97\u5206");
		比赛得分.setSelected(true);
		比赛得分.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		比赛得分.setBounds(237, 227, 102, 36);
		比赛得分.setOpaque(false);
		contentPane.add(比赛得分);
		jbs.add(比赛得分);
		JLabel label_1 = new JLabel("\u6BD4\u8D5B\u5206\u6790\u4FE1\u606F\u9009\u9879\uFF1A");
		label_1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label_1.setBounds(10, 259, 188, 36);
		contentPane.add(label_1);
		
		final JCheckBox 进攻回合 = new JCheckBox("\u8FDB\u653B\u56DE\u5408");
		进攻回合.setSelected(true);
		进攻回合.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		进攻回合.setBounds(20, 328, 114, 36);
		进攻回合.setOpaque(false);
		contentPane.add(进攻回合);
		jbs.add(进攻回合);
		final JCheckBox 篮板数 = new JCheckBox("\u7BEE\u677F\u6570");
		篮板数.setSelected(true);
		篮板数.setOpaque(false);
		篮板数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		篮板数.setBounds(133, 189, 73, 36);
		contentPane.add(篮板数);
		jbs.add(篮板数);
		final JCheckBox 助攻数 = new JCheckBox("\u52A9\u653B\u6570");
		助攻数.setSelected(true);
		助攻数.setOpaque(false);
		助攻数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		助攻数.setBounds(237, 189, 73, 36);
		contentPane.add(助攻数);
		jbs.add(助攻数);
		final JCheckBox 抢断数 = new JCheckBox("\u62A2\u65AD\u6570");
		抢断数.setSelected(true);
		抢断数.setOpaque(false);
		抢断数.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		抢断数.setBounds(340, 189, 73, 36);
		contentPane.add(抢断数);
		jbs.add(抢断数);
		/**
		 * 背景图片
		 */

		
		final JCheckBox 投篮命中率 = new JCheckBox("\u6295\u7BEE\u547D\u4E2D\u7387");
		投篮命中率.setSelected(true);
		投篮命中率.setOpaque(false);
		投篮命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		投篮命中率.setBounds(20, 290, 114, 36);
		contentPane.add(投篮命中率);
		jbs.add(投篮命中率);
		final JCheckBox 三分命中率 = new JCheckBox("\u4E09\u5206\u547D\u4E2D\u7387");
		三分命中率.setSelected(true);
		三分命中率.setOpaque(false);
		三分命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		三分命中率.setBounds(152, 290, 114, 36);
		contentPane.add(三分命中率);
		jbs.add(三分命中率);
		final JCheckBox 罚球命中率 = new JCheckBox("\u7F5A\u7403\u547D\u4E2D\u7387");
		罚球命中率.setSelected(true);
		罚球命中率.setOpaque(false);
		罚球命中率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		罚球命中率.setBounds(285, 290, 112, 36);
		contentPane.add(罚球命中率);
		jbs.add(罚球命中率);
		final JCheckBox 进攻效率 = new JCheckBox("\u8FDB\u653B\u6548\u7387");
		进攻效率.setSelected(true);
		进攻效率.setOpaque(false);
		进攻效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		进攻效率.setBounds(152, 328, 95, 36);
		contentPane.add(进攻效率);
		jbs.add(进攻效率);
		final JCheckBox 防守效率 = new JCheckBox("\u9632\u5B88\u6548\u7387");
		防守效率.setSelected(true);
		防守效率.setOpaque(false);
		防守效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		防守效率.setBounds(285, 328, 102, 36);
		contentPane.add(防守效率);
		jbs.add(防守效率);
		final JCheckBox 进攻篮板率 = new JCheckBox("\u8FDB\u653B\u7BEE\u677F\u7387");
		进攻篮板率.setSelected(true);
		进攻篮板率.setOpaque(false);
		进攻篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		进攻篮板率.setBounds(399, 328, 106, 36);
		contentPane.add(进攻篮板率);
		jbs.add(进攻篮板率);
		final JCheckBox 防守篮板率 = new JCheckBox("\u9632\u5B88\u7BEE\u677F\u7387");
		防守篮板率.setSelected(true);
		防守篮板率.setOpaque(false);
		防守篮板率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		防守篮板率.setBounds(20, 366, 137, 36);
		contentPane.add(防守篮板率);
		jbs.add(防守篮板率);
		final JCheckBox 胜率 = new JCheckBox("\u80DC\u7387");
		胜率.setSelected(true);
		胜率.setOpaque(false);
		胜率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		胜率.setBounds(421, 290, 73, 36);
		contentPane.add(胜率);
		jbs.add(胜率);
		final JCheckBox 抢断效率 = new JCheckBox("\u62A2\u65AD\u6548\u7387");
		抢断效率.setSelected(true);
		抢断效率.setOpaque(false);
		抢断效率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		抢断效率.setBounds(152, 366, 114, 36);
		contentPane.add(抢断效率);
		jbs.add(抢断效率);
		final JCheckBox 助攻率 = new JCheckBox("\u52A9\u653B\u7387");
		助攻率.setSelected(true);
		助攻率.setOpaque(false);
		助攻率.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		助攻率.setBounds(285, 366, 154, 36);
		contentPane.add(助攻率);
		jbs.add(助攻率);
		final JCheckBox checkBox_3 = new JCheckBox("\u5168\u9009");
		checkBox_3.setSelected(true);
		checkBox_3.setOpaque(false);
		checkBox_3.setFont(new Font("幼圆", Font.PLAIN, 14));
		checkBox_3.setBounds(437, 82, 57, 36);
		contentPane.add(checkBox_3);
		checkBox_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox_3.isSelected()){
				

					比赛场数.setSelected(true);					
					投篮命中数.setSelected(true);
					投篮出手次数.setSelected(true);
					三分命中数.setSelected(true);
					三分出手次数.setSelected(true);
					罚球命中数.setSelected(true);							
					罚球出手数.setSelected(true);
					进攻篮板数.setSelected(true);
					防守篮板数.setSelected(true);
					篮板数.setSelected(true);
					助攻数.setSelected(true);
					抢断数.setSelected(true);
					盖帽数.setSelected(true);
					失误数.setSelected(true);								
					犯规数.setSelected(true);
					比赛得分.setSelected(true);
				}
				else{
					比赛场数.setSelected(false);					
					投篮命中数.setSelected(false);
					投篮出手次数.setSelected(false);
					三分命中数.setSelected(false);
					三分出手次数.setSelected(false);
					罚球命中数.setSelected(false);							
					罚球出手数.setSelected(false);
					进攻篮板数.setSelected(false);
					防守篮板数.setSelected(false);
					篮板数.setSelected(false);
					助攻数.setSelected(false);
					抢断数.setSelected(false);
					盖帽数.setSelected(false);
					失误数.setSelected(false);								
					犯规数.setSelected(false);
					比赛得分.setSelected(false);
				}
				
			}
			
		});
		
		final JCheckBox checkBox_5 = new JCheckBox("\u5168\u9009");
		checkBox_5.setSelected(true);
		checkBox_5.setOpaque(false);
		checkBox_5.setFont(new Font("幼圆", Font.PLAIN, 14));
		checkBox_5.setBounds(437, 259, 57, 36);
		contentPane.add(checkBox_5);
		checkBox_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(checkBox_5.isSelected()){
					进攻回合.setSelected(true);
					投篮命中率.setSelected(true);
					三分命中率.setSelected(true);
					
					罚球命中率.setSelected(true);
					进攻效率.setSelected(true);
					防守效率.setSelected(true);
					进攻篮板率.setSelected(true);
								
					防守篮板率.setSelected(true);
					胜率.setSelected(true);
					抢断效率.setSelected(true);
					助攻率.setSelected(true);
				}
				else{
					进攻回合.setSelected(false);
					投篮命中率.setSelected(false);
					三分命中率.setSelected(false);
					
					罚球命中率.setSelected(false);
					进攻效率.setSelected(false);
					防守效率.setSelected(false);
					进攻篮板率.setSelected(false);
								
					防守篮板率.setSelected(false);
					胜率.setSelected(false);
					抢断效率.setSelected(false);
					助攻率.setSelected(false);
				}
				
			}
			
		});
		JButton sure = new JButton("\u786E\u5B9A");
		sure.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		sure.setBounds(204, 400, 100, 30);
		contentPane.add(sure);
		/*" 序号  ", " 球员名称  ", " 所属球队  ","参赛数",
		"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率",
		"罚球命中率", "进攻", "防守", "抢断", "盖帽", "失误",
		"犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
		"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率",
		"失误率", "使用率" ,"近五场得分提升率","近五场助攻提升率","近五场篮板提升率"*/
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
					if(!jbs.get(k).isSelected()){//表示要隐藏的列
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
				//TODO 方法调用
				
				
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
		label_2.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
		label_2.setBounds(275, 10, 147, 36);
		contentPane.add(label_2);
		
		info = new JRadioButton("\u663E\u793A\u573A\u5747\u6570\u636E");
		info.setFont(new Font("华康雅宋体W9", Font.PLAIN, 16));
		info.setBounds(285, 48, 127, 23);
		contentPane.add(info);
		

		ImageIcon image = new ImageIcon("pic/筛选背景.jpg");

		image.setImage(image.getImage().getScaledInstance(520, 450,Image.SCALE_DEFAULT));
		
		
		JLabel photo = new JLabel(image);
		photo.setBounds(0, 0, 520, 450);
		photo.setOpaque(false);
		getContentPane().add(photo);
		setLocationRelativeTo(null);
	}
	
	
	
	 protected void do_this_windowOpened(WindowEvent e) {
	        final int height = this.getHeight();// 记录窗体高度
	        new Thread() {// 创建新线程
	            public void run() {
	            	Rectangle rec = getBounds();
	                for (int i = 0; i <= 520; i += 5) {// 循环拉伸窗体
	                	 setBounds(rec.x+250-i/2 , rec.y, i, height);// 不断设置窗体大小与位置
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
}
