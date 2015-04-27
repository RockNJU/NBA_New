package UI.team;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.OftenUseMethod;
import UI.main.init;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class MatT extends JPanel {
 
	TeamBLService tbl;
	//RMIObject rmi=new RMIObject();
	Object[][] data;
	ArrayList<TeamMatchVO> tmvo;
	String[] title = {"赛季","对抗队伍","得分","篮板数","进攻篮板数","防守篮板数","助攻数","失误数","抢断数",
			"犯规数","盖帽数","进球数/投篮总数","三分进球数/三分投射数","罚篮进球数/罚篮总数",
			"进攻回合","防守回合","罚球命中率","三分球命中率","投篮命中率","助攻率",
			"进攻篮板率","防守篮板率","抢断率","进攻效率","防守效率"};
	CreateTable list;
	/**
	 * Create the panel.
	 */
	public MatT(String name,String season) {
		setSize(760,500);
		setLayout(null);
		setOpaque(false);
		tbl=init.rmi.getTeamObject();
		tmvo=tbl.get_A_TeamSeasonData(season, name).getLast_five_match();
		data=getdata(tmvo);
		JLabel lblNewLabel = new JLabel(tbl.get_A_TeamSeasonData(season, name).getTeamName()+"近五场比赛的信息：");
		lblNewLabel.setFont(new Font("华康雅宋体W9", Font.PLAIN, 20));
		lblNewLabel.setBounds(18, 10, 413, 48);
		add(lblNewLabel);
		
		
		list = new CreateTable(title, data, 15, 25, 720, 430, 25,
				new Font("华文新魏", 0, 15), new Font("Dialog", 0, 12));
		list.setLocation(18, 68);
		add(list);
	}
	private Object[][] getdata(ArrayList<TeamMatchVO> da){
		//System.out.println(da==null);
		if(da==null){
			Object[][] re=new Object[1][25];
			re[0][0]="";
			re[0][1]="";
			re[0][2]="";
			re[0][3]="";			
			re[0][4]="";
			re[0][5]="";
			re[0][6]="";
			re[0][7]="";
			re[0][8]="";
			re[0][9]="";
			re[0][10]="";
			re[0][11]="";			
			re[0][12]="";
			re[0][13]="";
			re[0][14]="";
			re[0][15]="";
			re[0][16]="";
			re[0][17]="";
			re[0][18]="";
			re[0][19]="";			
			re[0][20]="";
			re[0][21]="";
			re[0][22]="";
			re[0][23]="";
			re[0][24]="";

			return re;
		}
		else{
			Object[][] re=new Object[15][25];
			for(int i=0;i<da.size();i++){						
				re[i][0]=da.get(i).getSeason();
				re[i][1]=da.get(i).getOpp_team();
				re[i][2]=da.get(i).getPointNum();
				re[i][3]=da.get(i).getReboundNum();
				re[i][4]=da.get(i).getO_ReboundNum();
				re[i][5]=da.get(i).getD_ReboundNum();
				re[i][6]=da.get(i).getAssistNum();				
				re[i][7]=da.get(i).getTurnoverNum();
				re[i][8]=da.get(i).getStealNum();
				re[i][9]=da.get(i).getFoulNum();
				re[i][10]=da.get(i).getBlockNum();
				re[i][11]=String.valueOf(da.get(i).getFieldGoal())+"/"+String.valueOf(da.get(i).getShootNum());				
				re[i][12]=String.valueOf(da.get(i).getT_fieldGoal())+"/"+String.valueOf(da.get(i).getT_shootNum());
				re[i][13]=String.valueOf(da.get(i).getFreeThrowGoalNum())+"/"+String.valueOf(da.get(i).getFreeThrowNum());			
				re[i][14]=da.get(i).getO_ReboundNum();				
				re[i][15]=da.get(i).getD_ReboundNum();					
				re[i][16]=OftenUseMethod.changedouble(da.get(i).getFreeThrowPercentage());
				re[i][17]=OftenUseMethod.changedouble(da.get(i).getThreePointPercentage());			
				re[i][18]=OftenUseMethod.changedouble(da.get(i).getShootPercentage());
				re[i][19]=OftenUseMethod.changedouble(da.get(i).getAssistEfficiency());
				re[i][20]=OftenUseMethod.changedouble(da.get(i).getO_ReboundEfficiency());					
				re[i][21]=OftenUseMethod.changedouble(da.get(i).getD_ReboundEfficiency());
				re[i][22]=OftenUseMethod.changedouble(da.get(i).getStealEfficiency());
				re[i][23]=OftenUseMethod.changedouble(da.get(i).getOffenseEfficiency());
				re[i][24]=OftenUseMethod.changedouble(da.get(i).getDefenseEfficiency());
			}		
			return re;
		
		}
		
	}
}
