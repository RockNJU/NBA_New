package UI.blObject;

import java.util.ArrayList;

import VO.TeamSeasonDataVO;
import businessService.blservice.*;
import businesslogic.bl.*;
import businesslogic.bl.center.CenterController;
import businesslogic.bl.matchbl.MatchController;
import businesslogic.bl.playerbl.PlayerController;
import businesslogic.bl.teambl.TeamController;



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
		
		ArrayList<TeamSeasonDataVO> list=team.getAllTeamSeasonData("13-14");
		for(int i=0;i<list.size();i++){
			System.out.println("--¶ÓÃû£º"+list.get(i).getTeamName()+";   "+list.get(i).getPointNum());
		}
	}
	
}
