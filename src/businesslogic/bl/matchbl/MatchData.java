package businesslogic.bl.matchbl;

import java.util.ArrayList;

import businesslogic.bl.center.SeasonInfo;
import VO.MatchInfo;
import VO.MatchVO;

public class MatchData {
	private String season;
	ArrayList<MatchVO> matchList;
	
	public MatchData(String season){
		this.season=season;
		matchList=new ArrayList<>();
	}
	public ArrayList<MatchVO> getMatchList() {
		return matchList;
	}
	
	public void add_A_match(MatchVO vo){
		matchList.add(vo);
	}
	
	public void setMatchList(ArrayList<MatchVO> matchList) {
		this.matchList = matchList;
	}
	public String getSeason(){
		return season;
	}
	
	public MatchVO get_A_match(String date,String teamb){
		for(int i=0;i<matchList.size();i++){
			if((matchList.get(i).getGuestTeam().getTeamName().equals(teamb)||
					matchList.get(i).getHostTeam().getTeamName().equals(teamb))
					&matchList.get(i).getDate().equals(date)){
				return matchList.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<MatchVO> get_A_Day_Match(String date){
		/*根据时间获取当天有比赛的两支队伍，返回比赛的信息*/
		ArrayList<MatchVO> list=new ArrayList<>();
		for(int i=0;i<matchList.size();i++){
			if(matchList.get(i).getDate().equals(date)){
				list.add(matchList.get(i));
			}
		}
		return list;
	}
}
