package businessService.blservice;
import java.util.ArrayList;

import businesslogic.bl.matchbl.MatchInfo;
import VO.MatchVO;
public interface MatchBLService {
	
	ArrayList<MatchInfo> getMatchByTeamTime(String date); 
	            /*  根据输入的日期获取这一天所有的比赛信息
	          比赛信息 MatchInfo 详见matchbl里的MAtchInfo定义，
	          我认为这比之前的用-隔开的String方便，省去你们的分割操作               
	                         */
	MatchVO getMatchByTeam(String data,String teamA,String teamB);
	        //根据球队的缩写和比赛日期获取某一场比赛的数据，返回一个MatchVO
	
	//TODO 获得赛季以供选择，形式最好是"13-14赛季",这个是公用的、
	String[] getAllSeason();
	//TODO 传入一个日期，获得这天的比赛情况
	ArrayList<MatchInfo> getAllMatchInfo(String date);
}
