package VO;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String season;					//赛季
	private String date;					//比赛日期
	private String matchScore;				//比赛比分
	private ArrayList<String> scores;		//比赛的每节比分
	private TeamMatchVO  hostTeam;			//主队的比赛数据
	private TeamMatchVO  guestTeam;			//客队的比赛数据
	
	public MatchVO(String season,String date,String matchScore,
			ArrayList<String>scores,TeamMatchVO ht,TeamMatchVO gt){
		this.season=season;
		this.date=date;
		this.matchScore=matchScore;
		this.scores=scores;
		this.hostTeam=ht;
		this.guestTeam=gt;	
	}

	public String getSeason() {
		return season;
	}

	public String getDate() {
		return date;
	}

	public String getMatchScore() {
		return matchScore;
	}

	public ArrayList<String> getScores() {
		return scores;
	}

	public TeamMatchVO getHostTeam() {
		return hostTeam;
	}

	public TeamMatchVO getGuestTeam() {
		return guestTeam;
	}
}
