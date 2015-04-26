package UI.player;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JFormattedTextField;

import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import businessService.blservice.PlayerBLService;

public class MatP extends JPanel {

	RMIObject rmi=new RMIObject();
	PlayerBLService pbl;
	PlayerSeasonDataVO pdvo;
	CreateTable list;
	ArrayList<SingleMatchPersonalDataVO> array;
	Object[][] data;
	String[] title = {"比赛日期","效力球队","球员位置","球员上场时间","进球数","投篮总数","三分进球数",
			 "三分投射数","罚篮进球数","罚篮总数","进攻篮板数","防守篮板数","篮板总数",
			 "助攻数","抢断数","盖帽数","失误数","得分","犯规数","投篮效率","助攻率","篮板率","进攻篮板率",
			 "防守篮板率","抢断率","失误率","使用率","盖帽率","真实投篮命中率"};
	/**
	 * Create the panel.
	 */
	public MatP(String name,String season) {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		pbl=rmi.getPlayerObject();
		pdvo=pbl.getAPlayerSeasonMatch(season, name);
		list = new CreateTable(title, data, 10, 45, 720, 460, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		add(list);
		
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
}
