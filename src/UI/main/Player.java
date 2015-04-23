package UI.main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.common.SortItem_Map;
import UI.common.TeamMap;
import UI.player.SinglePlayer;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.PlayerVO;

public class Player extends JPanel {

	JLabel findLabel;
	JLabel sortLabel;
	JComboBox position;
	JComboBox partition;
	JComboBox according;
	JComboBox playerseason;
	JComboBox playerseason1;
	JTextField findkey;
	JButton columns;
	JButton sort;
	JButton find;
	CreateTable playerlist;
	String[] playerTotaltitle = { " 序号  ", " 球员名称  ", " 所属球队  ", 				 "参赛场数",
			"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率",
			"罚球命中率", "进攻", "防守", "抢断", "盖帽", "失误",
			"犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
			"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率",
			"失误率", "使用率" ,"近五场得分提升率","近五场助攻提升率","近五场篮板提升率"};
	String[] playerAvgtitle = { " 序号  ", " 球员名称  ", " 所属球队  ", 			 "参赛场数",
				"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率",
				"罚球命中s率", "进攻", "防守", "抢断", "盖帽", "失误",
				"犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
				"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率",
				"失误率", "使用率","近五场得分提升率","近五场助攻提升率","近五场篮板提升率"};
	String[] playerinfo = { " 序号  ", " 姓名  ", " 球号  ", " 位置  ", " 身高  ",
			" 体重  ", " 出生日期  ", " 年龄  ", " 球龄  ", " 毕业院校  " };

	String[] title;
	Object[][] data;

	PlayerBLService pbl;
	MatchBLService mbl;
	RMIObject rmi = new RMIObject();
	ArrayList<PlayerSeasonDataVO> psvo;
	ArrayList<PlayerInfoVO> pivo;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public Player() {
		pbl = rmi.getPlayerObject();
		mbl = rmi.getMatchObject();
		setLayout(null);
		setSize(764, 635);
		setOpaque(false);

		sortLabel = new JLabel("排列：");
		sortLabel.setForeground(Color.WHITE);
		sortLabel.setFont(new Font("华文新魏", Font.BOLD, 32));
		sortLabel.setBounds(31, 35, 130, 30);
		add(sortLabel);
		sortLabel.setVisible(true);
		findLabel = new JLabel("查找：");
		findLabel.setForeground(Color.WHITE);
		findLabel.setFont(new Font("华文新魏", Font.BOLD, 32));
		findLabel.setBounds(31, 75, 130, 30);
		add(findLabel);
		findLabel.setVisible(true);

		/**
		 * 球员的位置
		 */
		position = new JComboBox();
		position.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		position.setBounds(135, 35, 70, 30);
		position.setMaximumRowCount(100);
		position.setModel(new DefaultComboBoxModel(new String[] {
				"\u524D\u950B", "\u4E2D\u950B", "\u540E\u536B" }));
		position.setToolTipText("\u4F4D\u7F6E");
		position.setEditable(true);
		add(position);
		position.setVisible(true);

		/**
		 * 球员所属球队的分区
		 * 
		 */
		partition = new JComboBox();
		partition.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		partition.setToolTipText("\u6240\u5C5E\u7403\u961F\u5206\u533A");
		partition.setModel(new DefaultComboBoxModel(new String[] { "\u65E0",
				"\u4E1C\u533A", "\u897F\u533A", "\u5927\u897F\u6D0B",
				"\u4E2D\u90E8", "\u4E1C\u5357", "\u897F\u5357",
				"\u897F\u5317\u90E8", "\u592A\u5E73\u6D0B" }));
		partition.setEditable(true);
		partition.setBounds(225, 35, 70, 30);
		add(partition);
		partition.setVisible(true);

		/**
		 * 球员进行筛选排列的依据
		 * 
		 */
		according = new JComboBox();
		according.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		according.setToolTipText("\u6392\u5E8F\u4F9D\u636E");
		according.setModel(new DefaultComboBoxModel(new String[] { 
				 "参赛场数",
				"先发场数", "篮板", "助攻", "上场时间", "投篮命中率", "三分命中率",
				"罚球命中率", "进攻", "防守", "抢断", "盖帽", "失误",
				"犯规", "得分", "效率 ", "GmSc效率值", "真实命中率", "投篮效率",
				"篮板率", "进攻篮板数", "防守篮板数", "助攻率", "抢断率", "盖帽率",
				"失误率", "使用率","近五场得分提升率","近五场助攻提升率","近五场篮板提升率"
		}));
		according.setEditable(true);
		according.setBounds(315, 35, 86, 30);
		add(according);
		according.setVisible(true);
		/**
		 * TODO 赛季
		 */
		playerseason = new JComboBox();
		playerseason.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		playerseason.setToolTipText("赛季");

		ArrayList<String> seasons = mbl.getAllSeason();
		if (seasons.size() == 0 || seasons == null) {
			seasons.add("13-14赛季");
		}
		for (int o = 0; o < seasons.size(); o++) {
			playerseason.addItem(seasons.get(o));

		}

		playerseason.setEditable(true);
		playerseason.setBounds(422, 35, 117, 30);
		add(playerseason);
		playerseason.setVisible(true);

		/**
		 * TODO 赛季
		 * 
		 * playerseason1 = new JComboBox(); playerseason1.setFont(new
		 * Font("微软雅黑", Font.PLAIN, 12)); playerseason1.setToolTipText("赛季");
		 * 
		 * 
		 * 
		 * 
		 * playerseason1.setModel(new DefaultComboBoxModel(seasons));
		 * playerseason1.setEditable(true); playerseason1.setBounds(422,79, 117,
		 * 30); add(playerseason1); playerseason1.setVisible(true);
		 */
		String Title[] = playerinfo;
		pivo = pbl.getAllPlayerInfo();
		Object Data[][] = getinfodata(pivo);
		this.title = Title;
		this.data = Data;
		playerlist = new CreateTable(title, data, 25, 144, 720, 460, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		add(playerlist);

		// 双击进入球员界面
		playerlist.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println(playerlist.getSelectedRow()!=-1);
				// System.out.println(e.getClickCount() == 2);
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && playerlist.getSelectedRow() != -1) {
					String season = playerseason.getSelectedItem().toString()
							.substring(0, 5);
					String name = playerlist.getValueAt(
							playerlist.getSelectedRow(), 1);
					// System.out.println(name);
					SinglePlayer spi = new SinglePlayer(name, season);
					spi.setVisible(true);
					spi.setLocation(375, 58);
				}
			}
		});

		/**
		 * 球员查找的关键词
		 * 
		 */
		findkey = new JTextField("请输入关键词");
		findkey.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		findkey.setBounds(135, 75, 404, 30);
		add(findkey);
		findkey.setColumns(20);
		findkey.setVisible(true);

		sort = new JButton(new ImageIcon("pic/but/排列前.png"));
		sort.addMouseListener(new MouseListener() {
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
				sort.setIcon(new ImageIcon("pic/but/排列前.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				sort.setIcon(new ImageIcon("pic/but/排列后.png"));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("sort");
				// TODO
				String Position = position.getSelectedItem().toString();
				String Partition = partition.getSelectedItem().toString();
				String According = according.getSelectedItem().toString();
				String Season = playerseason.getSelectedItem().toString()
						.substring(0, 5);
				PlayerPosition_Map map1 = new PlayerPosition_Map();
				PartitionMap map2 = new PartitionMap();
				SortItem_Map map3 = new SortItem_Map();
				Position = map1.getItem(Position);
				Partition = map2.getItem(Partition);
				According = map3.getItem(According);
				psvo = pbl.sort(Season, Position, Partition, According);
				System.out.println(Season + Position + Partition + According);
				data = getTotaldata(psvo);
				playerlist.updateTable(playerTotaltitle, data);
			}

		});
		sort.setToolTipText("\u663E\u793A\u67E5\u627E\u7684\u7403\u5458\u4FE1\u606F");
		sort.setBounds(566, 35, 75, 26);
		add(sort);
		sort.setVisible(true);

		find = new JButton(new ImageIcon("pic/but/查找前.png"));
		find.addMouseListener(new MouseListener() {
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
				find.setIcon(new ImageIcon("pic/but/查找前.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				find.setIcon(new ImageIcon("pic/but/查找后.png"));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// String
				// Season=playerseason.getSelectedItem().toString().substring(0,
				// 5);
				psvo = pbl.keyfind(findkey.getText());
				data = getTotaldata(psvo);
				playerlist.updateTable(playerTotaltitle, data);
			}

		});

		find.setToolTipText("\u67E5\u8BE2\u5355\u72EC\u7403\u5458\u4FE1\u606F");
		find.setBounds(566, 79, 75, 26);
		add(find);
		find.setVisible(true);

		columns = new JButton(new ImageIcon("pic/but/筛选前.png"));
		columns.addMouseListener(new MouseListener() {
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
				columns.setIcon(new ImageIcon("pic/but/筛选前.png"));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				// TODO Auto-generated method stub
				columns.setIcon(new ImageIcon("pic/but/筛选后.png"));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		columns.setToolTipText("\u9009\u62E9\u8868\u683C\u5C5E\u6027");
		columns.setBounds(670, 35, 75, 26);
		add(columns);
		columns.setVisible(true);

	}

	private Object[][] getTotaldata(ArrayList<PlayerSeasonDataVO> da) {
		System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][33];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			re[0][10] = "";
			re[0][11] = "";
			re[0][12] = "";
			re[0][13] = "";
			re[0][14] = "";
			re[0][15] = "";
			re[0][16] = "";
			re[0][17] = "";
			re[0][18] = "";
			re[0][19] = "";
			re[0][20] = "";
			re[0][21] = "";
			re[0][22] = "";
			re[0][23] = "";
			re[0][24] = "";
			re[0][25] = "";
			re[0][26] = "";
			re[0][27] = "";
			re[0][28] = "";
			re[0][29] = "";
			re[0][30] = "";
			re[0][31] = "";
			re[0][32] = "";
			return re;
		} else {
			Object[][] re = new Object[da.size()][33];
			/*
			 * {"序号","球员名称","所属球队","参赛场数","先发场数",
			 * "篮板数","助攻数","在场时间","投篮命中率","三分命中率","罚球命中率",
			 * "进攻数","防守数","抢断数","盖帽数","失误数","犯规数","得分","效率",
			 * "GmSc效率值","真实命中率","投篮效率","篮板率","进攻篮板率","防守篮板率",
			 * "助攻率","抢断率","盖帽率","失误率","使用率"};
			 */
			// TeamMap temp=new TeamMap();
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = i + 1;
				re[i][1] = da.get(i).getName();
				re[i][2] = da.get(i).getTeamName();
				re[i][3] = da.get(i).getMatchNum();
				re[i][4] = da.get(i).getStartingNum();
				re[i][5] = da.get(i).getReboundNum();
				re[i][6] = da.get(i).getAssistNum();
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][8] = OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][9] = OftenUseMethod.changedouble(da.get(i).getT_shootPercentage());
				re[i][10] = OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());
				re[i][11] = da.get(i).getO_ReboundNum();
				re[i][12] = da.get(i).getD_ReboundNum();
				re[i][13] = da.get(i).getStealNum();
				re[i][14] = da.get(i).getBlockNum();
				re[i][15] = da.get(i).getTurnoverNum();
				re[i][16] = da.get(i).getFoulNum();
				re[i][17] = da.get(i).getPointNum();
				re[i][18] = OftenUseMethod.changedouble(da.get(i).getEfficiency());
				re[i][19] = OftenUseMethod.changedouble(da.get(i).getGmSc());
				re[i][20] = OftenUseMethod.changedouble(da.get(i).getRealShootPercentage());
				re[i][21] = OftenUseMethod.changedouble(da.get(i).getShootEfficiency());
				re[i][22] = OftenUseMethod.changedouble(da.get(i).getReboundEfficiency());
				re[i][23] = OftenUseMethod.changedouble(da.get(i).getOffensiveReboundEff());
				re[i][24] = OftenUseMethod.changedouble(da.get(i).getDefenseReboundEff());
				re[i][25] = OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
				re[i][26] = OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][27] = OftenUseMethod.changedouble(da.get(i).getBlockEfficiency());
				re[i][28] = OftenUseMethod.changedouble(da.get(i).getTurnoverPercentage());
				re[i][29] = OftenUseMethod.changedouble(da.get(i).getUsingPercentage());
				re[0][30] = da.get(i).getL_f_point_rate();
				re[0][31] = da.get(i).getL_f_assist_rate();
				re[0][32] = da.get(i).getL_f_rebound_rate();
			}
			return re;

		}

	}

	private Object[][] getinfodata(ArrayList<PlayerInfoVO> da) {
		System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][10];
			re[0][0] = "";
			re[0][1] = "";
			re[0][2] = "";
			re[0][3] = "";
			re[0][4] = "";
			re[0][5] = "";
			re[0][6] = "";
			re[0][7] = "";
			re[0][8] = "";
			re[0][9] = "";
			return re;
		} else {
			Object[][] re = new Object[da.size()][30];
			/* "序号","姓名","球号","位置","身高","体重","出生日期","年龄","球龄","毕业院校" */
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = i + 1;
				re[i][1] = da.get(i).getName();
				re[i][2] = da.get(i).getNumber();
				re[i][3] = da.get(i).getPosition();
				re[i][4] = da.get(i).getHeight();
				re[i][5] = da.get(i).getWeight();
				re[i][6] = da.get(i).getBirth();
				re[i][7] = da.get(i).getAge();
				re[i][8] = da.get(i).getExp();
				re[i][9] = da.get(i).getSchool();

			}
			return re;

		}
	}
}
