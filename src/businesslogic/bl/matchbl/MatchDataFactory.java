package businesslogic.bl.matchbl;

import java.util.ArrayList;

import businesslogic.bl.center.SeasonInfo;
import businesslogic.data.TeamData;
import businesslogic.dataservice.TeamDataService;
import VO.MatchInfo;
import VO.MatchVO;
import VO.TeamInfoVO;

public class MatchDataFactory {
	ArrayList<MatchData> matchList;
	ArrayList<TeamInfoVO> infoList;
	public MatchDataFactory(){
		TeamDataService teamdata=new TeamData();
		infoList=teamdata.getTeamInfoList();
		matchList=new ArrayList<>();
	}
	
	
	public ArrayList<String> getAllSeason(){
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<matchList.size();i++){
			list.add(matchList.get(i).getSeason());
		}
		return list;
	}
	
	public void add_A_match(MatchVO vo){
		for(int i=0;i<matchList.size();i++){
			/*当赛季子仓库已经存在，则直接添加*/
			if(matchList.get(i).getSeason().equals(vo.getSeason())){
				matchList.get(i).add_A_match(vo);
			}
		}
				
		MatchData newSeason=new MatchData(vo.getSeason());
		newSeason.add_A_match(vo);
		matchList.add(newSeason);
		
	}
	
	public MatchVO get_A_match(String date,String teamb){
		String season=SeasonInfo.getSeason(date);
		String d=SeasonInfo.getDate(date);
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(season)){
				return matchList.get(i).get_A_match(d, teamb);
			}
		}
		return null;
	}
	
	public ArrayList<MatchInfo> getMatchInfo(String date){
		String season=SeasonInfo.getSeason(date);
		String d=SeasonInfo.getDate(date);
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(season)){
				return matchList.get(i).getMatchInfo(d);
			}
		}
		return null;  					//当对应的日期没有比赛信息时，返回null
	}

	public ArrayList<TeamInfoVO> getInfoList() {
		return infoList;
	}
}
