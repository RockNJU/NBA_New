package VO;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.bl.center.HotSort;

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
	public ArrayList<SingleMatchPersonalDataVO> sort(String item){
		ArrayList<SingleMatchPersonalDataVO> list=hostTeam.getIndividualData();
		list.addAll(guestTeam.getIndividualData());
		HotSort sort=new HotSort();
		return sort.hotSinglePlayer_Sort(list, item);	
	}
	
	public SingleMatchPersonalDataVO get_Highest_point(){
		/*获取一场比赛中得分王*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("pointNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_rebound(){
		/*获取一场比赛中篮板王*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("reboundNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_assist(){
		/*获取一场比赛中的助攻王**/
		ArrayList<SingleMatchPersonalDataVO>list= sort("assistNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_steal(){
		/*获取一场比赛中的抢断王*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("stealNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_block(){
		/*获取一场比赛中的盖帽王*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("blockNum");
		
		return list.get(0);
	}
}
