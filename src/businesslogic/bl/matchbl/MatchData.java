package businesslogic.bl.matchbl;

import java.util.ArrayList;

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
	public String getSeason() {
		return season;
	}
}
