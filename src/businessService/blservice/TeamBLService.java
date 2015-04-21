package businessService.blservice;
import java.util.ArrayList;

import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season);	
	//返回某个赛季的所有球队的现有赛季信息，传入的参数为赛季
	
	public TeamSeasonDataVO get_A_TeamSeasonData(String season,String teamAbb);	
	//根据赛季和球队缩写获取一支球队在某个赛季的比赛信息
	
	public double getTeamWinNum(String season,String teamAbb);
	//根据赛季和球队获取一支球队的胜率，注：这一条是先前留下的，胜率在TeamSeasonDataVO里已经有了，我不知道需不需要
	
	public ArrayList<String> getTeamAllPlayer(String teamAbb);    
	//根据球队的缩写获取球队所有的球员姓名，其实你可以考虑返回所有的基本信息，这容易做到
	
	public ArrayList<TeamVO> sort(String season,String sortItem);  //根据赛季和排序的 属性对球队进行排序后返回
	
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season,String item);
	//根据赛季和筛选的条件 获取赛季热点球队，即排名前五的球队
	
}
