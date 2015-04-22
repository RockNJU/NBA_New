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
		
		
		ArrayList<PlayerSeasonDataVO> pl=player.sort("13-14", "C", "  ", "pointNum");
		
		for(int i=0;i<pl.size();i++){
			System.out.println("姓名："+pl.get(i).getName()+"球员位置："+pl.get(i).getPosition()+"得分："+pl.get(i).getPointNum_avg());
		}
		
		/*ArrayList<TeamSeasonDataVO> list=team.getAllTeamSeasonData("13-14");
		for(int i=0;i<list.size();i++){
			System.out.println("--队名："+list.get(i).getTeamName()+";   "+list.get(i).getPointNum());
		}*/
		
		
		System.out.println("RMIObject测试结束！");
	}
	
}
