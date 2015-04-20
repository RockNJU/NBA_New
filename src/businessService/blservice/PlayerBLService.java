package businessService.blservice;

import java.util.ArrayList;

import VO.A_player_match_data;
import VO.*;

public interface PlayerBLService{
	
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,String name);//根据球员姓名获取球员的某个赛季的比赛数据
	public PlayerInfoVO getPlayerInfo(String name);   //根据球员的名字获取球员的基本信息
	public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //获取所有球员的基本信息
	public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String paitition,String item);/*为筛选球员，较之前有赛季的要求*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);//获取赛季的热点球员,传入的参数是赛季和筛选项目
	public ArrayList<A_player_match_data> getTodayHotPlayer(String item);//获取当天的热点球员，传入的是热点项目
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  //按照传入的赛季获取整个赛季中的所有球员的赛季数据
	
}
