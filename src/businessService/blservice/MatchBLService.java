package businessService.blservice;
import java.util.ArrayList;
import VO.MatchVO;
public interface MatchBLService {
	
	ArrayList<String> getMatchByTeamTime(String time,String team);
	MatchVO getMatchByTeam(String time,String teamA,String teamB);

}
