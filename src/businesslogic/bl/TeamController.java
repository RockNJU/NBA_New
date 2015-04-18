package businesslogic.bl;
import java.util.ArrayList;

import businessService.blservice.TeamBLService;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public class TeamController implements TeamBLService,TeamInfo_player{

	@Override
	public TeamInfoVO getTeam_info(String teamAbb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> getAllTeam(String season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamVO getTeamInfo(String teamAbb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTeamWinNum(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getTeamAllPlayer(String teamAbb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVO> sort(String season, String sortItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season, String item) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
