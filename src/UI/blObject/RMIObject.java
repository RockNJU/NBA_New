package UI.blObject;

import java.util.ArrayList;
import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;
import businessService.blservice.*;
import businesslogic.bl.center.CenterController;



public class RMIObject {
	CenterController contr;
	public RMIObject(){
		contr=new CenterController();
	}
	
	public MatchBLService  getMatchObject(){
		MatchBLService match=contr.getMatch();
		return match;
	}
	
	public PlayerBLService getPlayerObject(){
		PlayerBLService player=contr.getPlayer();
		return player;
	}
	
	public TeamBLService getTeamObject(){
		TeamBLService team=contr.getTeam();
		return team;
	}
	
	public static void main(String args[]){
		RMIObject m=new RMIObject();
		TeamBLService team=m.getTeamObject();
		PlayerBLService player=m.getPlayerObject();
		MatchBLService mac=m.getMatchObject();
		
		ArrayList<PlayerSeasonDataVO> pl=player.sort("13-14", "C", "  ", "t_shootPercentage");
		
		for(int i=0;i<pl.size();i++){
			System.out.println("姓名："+pl.get(i).getName()+"球员位置："+pl.get(i).getPosition()
					+"得分："+pl.get(i).getPointNum_avg()+"近5场提升率："+pl.get(i).getL_f_assist_rate());
			 
			//System.out.println("姓名："+pl.get(i).getName()+"  球员进攻篮板："+pl.get(i).getD_ReboundNum_avg()
				//	+"    得分："+pl.get(i).getPointNum_avg());
		}/**/
		
		/*ArrayList<TeamSeasonDataVO> list=team.getAllTeamSeasonData("13-14");
		for(int i=0;i<list.size();i++){
			System.out.println("--队名："+list.get(i).getTeamName()+"; 防守回合：  "+list.get(i).getDefenseRound());
		}
		// MatchVO  vo=mac.getMatchByTeam("2013-12-03","TOR");
		 
		for(int i=0;i<list.size();i++){
			System.out.println("--赛季："+list.get(i).getDate()+"队名："+list.get(i).getHostTeam().getTeamName());
		}
		 
		 System.out.println("--赛季："+vo.getDate()+"队--员---名："+
		 vo.get_GuestTeam_Highest_point().getPlayerName()+"；得分："+vo.get_GuestTeam_Highest_point().getPointNum());
			
		System.out.println("RMIObject测试结束！");*/
	}
	
}
