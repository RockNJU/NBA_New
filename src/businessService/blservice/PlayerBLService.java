package businessService.blservice;

import java.util.ArrayList;

import VO.A_player_match_data;
import VO.*;

public interface PlayerBLService{
	public ArrayList<PlayerVO> getAllPlayer();		//获取
	public PlayerVO getPlayer(String name);//根据球员姓名获取球员的基本信息
	public ArrayList<PlayerVO> getPlayerInfo(String name);		        
	public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String paitition,String item);
	/*为筛选球员，较之前有赛季的要求*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season);//获取赛季的热点球员
	public ArrayList<A_player_match_data> getTodayHotPlayer(String item);//获取当天的热点球员
}
