package businessService.blservice;
import java.util.ArrayList;

import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	
	public ArrayList<TeamVO> getAllTeam(String season);			 
	public TeamVO getTeamInfo(String teamAbb);		 
	public double getTeamWinNum(String season,String teamAbb);
	public ArrayList<String> getTeamAllPlayer(String teamAbb);
	public ArrayList<TeamVO> sort(String season,String sortItem);
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season,String item);
	
}
