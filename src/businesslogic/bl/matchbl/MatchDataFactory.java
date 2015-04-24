package businesslogic.bl.matchbl;

import java.util.ArrayList;

import businesslogic.bl.center.LastMatchDay;
import businesslogic.bl.center.SeasonInfo;
import businesslogic.data.TeamData;
import businesslogic.dataservice.TeamDataService;
import VO.A_player_match_data;
import VO.MatchInfo;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamInfoVO;

public class MatchDataFactory {
	ArrayList<MatchData> matchList;
	ArrayList<TeamInfoVO> infoList;
	
	private LastMatchDay lastDay;
	public MatchDataFactory(){
		TeamDataService teamdata=new TeamData();
		infoList=teamdata.getTeamInfoList();
		lastDay=new LastMatchDay("","");
		matchList=new ArrayList<>();
	}
	
	
	public ArrayList<String> getAllSeason(){
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<matchList.size();i++){
			list.add(matchList.get(i).getSeason()+"赛季");
		}
		return list;
	}
	
	public void add_A_match(MatchVO vo){
		
		lastDay.setSeason(vo.getSeason());
		lastDay.setDate(vo.getDate());
		for(int i=0;i<matchList.size();i++){
			/*当赛季子仓库已经存在，则直接添加*/
			if(matchList.get(i).getSeason().equals(vo.getSeason())){
				matchList.get(i).add_A_match(vo);
				System.out.println("添加比赛信息：" +vo.getDate()+"  ;"+
	vo.getHostTeam().getTeamName()+"-"+vo.getGuestTeam().getTeamName()+"比赛场数："+
				matchList.get(0).getMatchList().size());
				return;
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
	
	public ArrayList<MatchVO> get_A_Day_match(String date){
		String season=SeasonInfo.getSeason(date);
		String d=SeasonInfo.getDate(date);
		
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(season)){
				return matchList.get(i).get_A_Day_Match(d);
			}
		}
		return null;  					//当对应的日期没有比赛信息时，返回null
	}

	public ArrayList<MatchVO> get_A_Season_team_match(String season,String teamAbb){
		
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(season)){
				return matchList.get(i).get_A_Season_Team_Match(teamAbb);
			}
		}
		return null;  					//当对应的日期没有比赛信息时，返回null
	}
	
	public ArrayList<TeamInfoVO> getInfoList() {
		return infoList;
	}
	
	public ArrayList<SingleMatchPersonalDataVO> get_A_Aay_playMatchData(){
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getSeason().equals(lastDay.getSeason())){
				return matchList.get(i).get_last_day_playerData(lastDay.getDate());
			}
		}
		
	
		return new ArrayList<SingleMatchPersonalDataVO>();
	}
	
}
