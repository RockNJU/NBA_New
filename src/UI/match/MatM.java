package UI.match;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import UI.common.TeamName_Map;
import UI.main.init;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;

import javax.swing.JLabel;

import businessService.blservice.MatchBLService;

public class MatM extends JPanel {

	MatchVO mvo;
	//MatchBLService mbl;
	//RMIObject rmi=new RMIObject();
	CreateTable lista;
	CreateTable listb;
	String[] title={"球员姓名","位置","上场时间","进球数/总数","三分进球数/总数","罚篮进球数/总数","进攻篮板",
			"防守篮板","篮板总数",
			 "助攻数","抢断数","盖帽数","失误数","得分","犯规数"};
	Object[][] dataa;
	Object[][] datab;
	/*
		 private String playerName;				//"球员姓名"
		 private String playerPosition;			//"球员位置"
		 private double time;					//"球员上场时间"
		 private int fieldGoal;					//"进球数"
		
		 */
	/**
	 * Create the panel.
	 */
	public MatM(String team, String date) {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		//mbl=init.rmi.getMatchObject();
		mvo=init.mbl.getMatchByTeam(date, team);
		TeamName_Map mm=new TeamName_Map();
		
		JLabel lb1 = new JLabel("主队队员信息："+mm.getFullName(mvo.getHostTeam().getTeamName()));
		lb1.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		lb1.setBounds(10, 10, 297, 32);
		add(lb1);
		
		JLabel label = new JLabel("客队队员信息："+mm.getFullName(mvo.getGuestTeam().getTeamName()));
		label.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		label.setBounds(10, 240, 297, 32);
		add(label);
		
		dataa=getdata(mvo.getHostTeam().getIndividualData());
		datab=getdata(mvo.getGuestTeam().getIndividualData());
		lista = new CreateTable(title, dataa, 10, 45, 720, 200, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		add(lista);
		listb = new CreateTable(title, datab, 10, 270, 720, 200, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		add(listb);
		
		
	}
	
	
	Object[][] getdata(ArrayList<SingleMatchPersonalDataVO> da){
		//System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][15];
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
			return re;
		} else {
			Object[][] re = new Object[da.size()][15];
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getPlayerName();
				re[i][1] = da.get(i).getPlayerPosition();
				re[i][2] = OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][3] = String.valueOf(da.get(i).getFieldGoal())+"/"+String.valueOf(da.get(i).getShootNum());		
				re[i][4] = String.valueOf(da.get(i).getT_fieldGoal())+"/"+String.valueOf(da.get(i).getT_shootNum());
				re[i][5] = String.valueOf(da.get(i).getFreeThrowGoalNum())+"/"+String.valueOf(da.get(i).getFreeThrowNum());	
				re[i][6] =da.get(i).getO_ReboundNum();
				re[i][7] = da.get(i).getD_ReboundNum();
				re[i][8] = da.get(i).getReboundNum();
				re[i][9] = da.get(i).getAssistNum();
				re[i][10] = da.get(i).getStealNum();
				re[i][11] = da.get(i).getBlockNum();
				re[i][12] = da.get(i).getTurnoverNum();
				re[i][13] = da.get(i).getPointNum();
				re[i][14] = da.get(i).getFoulNum();
			}
			return re;

		}
	}
}
