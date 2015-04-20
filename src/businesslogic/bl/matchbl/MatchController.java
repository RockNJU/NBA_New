package businesslogic.bl.matchbl;

import java.util.ArrayList;

import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamMatchVO;
import businessService.blservice.MatchBLService;
import businesslogic.PO.MatchPO;
import businesslogic.PO.SingleMatchPersonalDataPO;
import businesslogic.PO.TeamMatchPO;
import businesslogic.bl.teambl.TeamBase;

public class MatchController implements MatchBLService{
	MatchDataFactory matchFactory;
	
	public MatchController(){
		matchFactory=new MatchDataFactory();
	}
	
	public void add_A_match(MatchVO vo){
		matchFactory.add_A_match(vo);
	}
	
	public MatchVO get_A_match(String date){
		return null;
	}
	
	@Override
	public MatchVO getMatchByTeam(String time, String teamA, String teamB) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MatchInfo> getMatchByTeamTime(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
