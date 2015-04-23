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
		/*往比赛数据仓库中添加一条比赛记录*/
		matchFactory.add_A_match(vo);
	}
	
	
	@Override
	public MatchVO getMatchByTeam(String date, String teamA, String teamB) {
		// TODO Auto-generated method stub
		return matchFactory.get_A_match(date, teamA);
	}

	@Override
	public ArrayList<MatchInfo> getMatchByTeamTime(String date) {
		// TODO Auto-generated method stub
		return matchFactory.getMatchInfo(date);
	}

	@Override
	public ArrayList<String>getAllSeason() {
		// TODO Auto-generated method stub
		return matchFactory.getAllSeason();
	}

	@Override
	public ArrayList<MatchInfo> getAllMatchInfo(String date) {
		// TODO Auto-generated method stub
		return matchFactory.getMatchInfo(date);
	}
	
}
