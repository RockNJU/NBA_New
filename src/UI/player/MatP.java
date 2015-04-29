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
	//PlayerBLService pbl;
	PlayerSeasonDataVO pdvo;
	CreateTable list1,list2;
	ArrayList<SingleMatchPersonalDataVO> array=new ArrayList<SingleMatchPersonalDataVO>();
	Object[][] data1,data2;
	String[] title1 = {"比赛日期","效力球队","球员位置",
			"上场时间","进球数/总数","三分","罚篮",
			"攻/防篮板数","篮板","助攻","抢断","盖帽"};
	String[] title2={"失误","得分","犯规","投篮效率","助攻率","篮板率","攻/防篮板率","抢断率",
			 "失误率","使用率","盖帽率","GmSc","投篮命中率"};
	/**
	 * Create the panel.
	 */
	public MatP(String name,String season) {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		
		//pbl=init.rmi.getPlayerObject();
		
		pdvo=init.pbl.getAPlayerSeasonMatch(season, name);
		
		if(pdvo==null){
			array=null;
		}else{
			array=pdvo.getLast_five_match_data();
		}
		data1=getdata1(array);
		list1 = new CreateTable(title1, data1,18, 68, 720, 170, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		//list1.setLocation(18, 68);
		add(list1);
		data2=getdata2(array);
		list2 = new CreateTable(title2, data2, 18, 230, 720, 200, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		add(list2);
		
		JLabel lblNewLabel = new JLabel(pdvo.getName()+"近五场比赛的信息：");
		lblNewLabel.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		lblNewLabel.setBounds(18, 10, 413, 48);
		add(lblNewLabel);
		
	}
	
	private Object[][] getdata1(ArrayList<SingleMatchPersonalDataVO> da) {
		//System.out.println(da==null);
		if (da == null) {
			Object[][] re = new Object[1][12];
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
			return re;
		} else {
			Object[][] re = new Object[da.size()][12];	
			System.out.println(da.size());
			TeamName_Map mm=new TeamName_Map();
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getDate();
				re[i][1] = mm.getFullName(da.get(i).getTeamName());
				if(da.get(i).getPlayerPosition()==null | da.get(i).getPlayerPosition().length()==0){
					re[i][2] = "非首发";
				}else{
					re[i][2] = da.get(i).getPlayerPosition();
				}	
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getTime());
				re[i][4] = String.valueOf(da.get(i).getFieldGoal())+"/"+String.valueOf(da.get(i).getShootNum());		
				re[i][5] = String.valueOf(da.get(i).getT_fieldGoal())+"/"+String.valueOf(da.get(i).getT_shootNum());
				re[i][6] = String.valueOf(da.get(i).getFreeThrowGoalNum())+"/"+String.valueOf(da.get(i).getFreeThrowNum());	
				re[i][7] = String.valueOf(da.get(i).getO_ReboundNum())+"/"+String.valueOf( da.get(i).getD_ReboundNum());
				re[i][8]=da.get(i).getReboundNum();
				re[i][9] = da.get(i).getAssistNum();
				re[i][10] = da.get(i).getStealNum();
				re[i][11] = da.get(i).getBlockNum();
			}
			return re;
		}

	}
	private Object[][] getdata2(ArrayList<SingleMatchPersonalDataVO> da) {
		if (da == null) {
			Object[][] re = new Object[1][13];
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
			return re;
		} else {
			Object[][] re = new Object[da.size()][13];	
			for (int i = 0; i < da.size(); i++) {
				re[i][0] = da.get(i).getTurnoverNum();
				re[i][1] = da.get(i).getPointNum();
				re[i][2] = da.get(i).getFoulNum();
				re[i][3] = OftenUseMethod.changedouble(da.get(i).getShootEfficiency());
				re[i][4] = OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
				re[i][5] = OftenUseMethod.changedouble(da.get(i).getReboundEfficiency());
				re[i][6] = String.valueOf(OftenUseMethod.changedouble(da.get(i).getOffensiveReboundEff()))+"/"+String.valueOf(OftenUseMethod.changedouble(da.get(i).getDefenseReboundEff()));
				re[i][7] = OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][8] = OftenUseMethod.changedouble(da.get(i).getTurnoverPercentage());
				re[i][9] = OftenUseMethod.changedouble(da.get(i).getUsingPercentage());
				re[i][10] = OftenUseMethod.changedouble(da.get(i).getBlockEfficiency());
				re[i][11] = OftenUseMethod.changedouble(da.get(i).getGmSc());
				re[i][12] = OftenUseMethod.changedouble(da.get(i).getRealShootPercentage());
			}
			return re;

		}

	}
}
