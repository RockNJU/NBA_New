package businessService.blservice;

import java.util.ArrayList;

import VO.*;

public interface PlayerBLService{
	
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,String name);//根据球员姓名获取球员的某个赛季的比赛数据
	public PlayerInfoVO getPlayerInfo(String name);   //根据球员的名字获取球员的基本信息
	public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //获取所有球员的基本信息
	public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String partition,String item);/*为筛选球员，较之前有赛季的要求*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);//获取赛季的热点球员,传入的参数是赛季和筛选项目
	
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  //按照传入的赛季获取整个赛季中的所有球员的赛季数据
	
	//TODO 关键词查找，不是很理解上面的方法，所以自己写了个
	//     姓名查找-含有此关键词的球员的比赛信息，个人认为姓名可以只记住单姓或者字母
	public ArrayList<PlayerSeasonDataVO> keyfind( String text);
	
	//TODO 还是改成获取基本信息-
		public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,String teamAbb);    
		//根据球队的缩写获取球队所有的球员姓名，其实你可以考虑返回所有的基本信息，这容易做到
	
}
