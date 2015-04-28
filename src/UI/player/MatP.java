package UI.player;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import UI.common.TeamName_Map;
import UI.main.init;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import businessService.blservice.PlayerBLService;

import javax.swing.JLabel;

public class MatP extends JPanel {

	//RMIObject rmi=new RMIObject();
	PlayerBLService pbl;
	PlayerSeasonDataVO pdvo;
	CreateTable list;
	ArrayList<SingleMatchPersonalDataVO> array;
	Object[][] data;
	String[] title = {"比赛日期","效力球队","是否首发(球员位置)",
			"上场时间","进球数/投篮总数","三分进球数/总数","罚篮进球数/总数",
			"攻/防篮板数","篮板数","助攻数","抢断数","盖帽数",
			"失误数","得分","犯规数",
			 "投篮效率","助攻率","篮板率","攻/防篮板率","抢断率",
			 "失误率","使用率","盖帽率","真实投篮命中率"};
	/**
	 * Create the panel.
	 */
	public MatP(String name,String season) {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		pbl=init.rmi.getPlayerObject();
		
		pdvo=pbl.getAPlayerSeasonMatch(season, name);
		data=getdata(pdvo.getLast_five_match_data());
		list = new CreateTable(title, data, 15, 25, 720, 430, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		list.setLocation(18, 68);
		add(list);
		
		JLabel lblNewLabel = new JLabel(pdvo.getName()+"近五场比赛的信息：");
		lblNewLabel.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		lblNewLabel.setBounds(18, 10, 413, 48);
		add(lblNewLabel);
		
	}
	
	private Object[][] getdata(ArrayList<SingleMatchPersonalDataVO> da) {
		//System.out.println(da == null);
		if (da == null) {
			Object[][] re = new Object[1][27];
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
			return re;
		} else {
			Object[][] re = new Object[15][27];	
			TeamName_Map mm=new TeamName_Map();
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getDate();
				re[i][1] = mm.getFullName(da.get(i).getTeamName());
				if(da.get(i).getPlayerPosition()==null | da.get(i).getPlayerPosition().length()==0){
					re[i][2] = "否";
				}else{
					re[i][2] = "是";
				}	
				re[i][3] = da.get(i).getPlayerPosition();
				re[i][4] =  OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][5] = String.valueOf(da.get(i).getFieldGoal())+"/"+String.valueOf(da.get(i).getShootNum());		
				re[i][6] = String.valueOf(da.get(i).getT_fieldGoal())+"/"+String.valueOf(da.get(i).getT_shootNum());
				re[i][7] = String.valueOf(da.get(i).getFreeThrowGoalNum())+"/"+String.valueOf(da.get(i).getFreeThrowNum());	
				re[i][8] = da.get(i).getO_ReboundNum();
				re[i][9] = da.get(i).getD_ReboundNum();
				re[i][10] = da.get(i).getAssistNum();
				re[i][11] = da.get(i).getStealNum();
				re[i][12] = da.get(i).getBlockNum();
				re[i][13] = da.get(i).getTurnoverNum();
				re[i][14] = da.get(i).getPointNum();
				re[i][15] = da.get(i).getFoulNum();
				re[i][16] = OftenUseMethod.changedouble(da.get(i).getShootEfficiency());
				re[i][17] = OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
				re[i][18] = OftenUseMethod.changedouble(da.get(i).getReboundEfficiency());
				re[i][19] = OftenUseMethod.changedouble(da.get(i).getOffensiveReboundEff());
				re[i][20] = OftenUseMethod.changedouble(da.get(i).getDefenseReboundEff());
				re[i][21] = OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][22] = OftenUseMethod.changedouble(da.get(i).getTurnoverPercentage());
				re[i][23] = OftenUseMethod.changedouble(da.get(i).getUsingPercentage());
				re[i][24] = OftenUseMethod.changedouble(da.get(i).getBlockEfficiency());
				re[i][25] = OftenUseMethod.changedouble(da.get(i).getGmSc());
				re[i][26] = OftenUseMethod.changedouble(da.get(i).getRealShootPercentage());
			}
			return re;

		}

	}
}
