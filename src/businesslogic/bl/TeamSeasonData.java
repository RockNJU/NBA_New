package businesslogic.bl;

import java.util.ArrayList;

import VO.TeamSeasonDataVO;

public class TeamSeasonData {
	private String season;
	private ArrayList<TeamSeasonDataVO> teamSeasnList;
	
	public TeamSeasonData(String season,ArrayList<TeamSeasonDataVO> list){
		this.season=season;
		this.teamSeasnList=list;
	}
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public ArrayList<TeamSeasonDataVO> getTeamSeasnList() {
		return teamSeasnList;
	}
	public void setTeamSeasnList(ArrayList<TeamSeasonDataVO> teamSeasnList) {
		this.teamSeasnList = teamSeasnList;
	}
}
