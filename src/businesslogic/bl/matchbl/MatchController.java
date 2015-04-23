package businesslogic.bl.matchbl;

import java.util.ArrayList;

import businessService.blservice.MatchBLService;
import VO.MatchInfo;
import VO.MatchVO;

public class MatchController implements MatchBLService{
	MatchDataFactory matchFactory;
	
	public MatchController(){
		matchFactory=new MatchDataFactory();
	}
	
	public void add_A_match(MatchVO vo){
		/*���������ݲֿ������һ��������¼*/
		matchFactory.add_A_match(vo);
	}
	
	

	@Override
	public ArrayList<String>getAllSeason() {
		// TODO Auto-generated method stub
		return matchFactory.getAllSeason();
	}

	@Override
	public ArrayList<MatchVO> getMatchByTeamTime(String date) {
		// TODO Auto-generated method stub
		return matchFactory.get_A_Day_match(date);
	}

	@Override
	public MatchVO getMatchByTeam(String date, String team) {
		// TODO Auto-generated method stub
		return matchFactory.get_A_match(date, team);
	}

	
	
}
