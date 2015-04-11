package businesslogic.PO;

import java.util.ArrayList;
public class TeamMatchPO {
	/*
	 * 
	 * 定义一场比赛中一支球队的持久化对象
	 * 只可读，不可修改 
	 * 
	 * */
	private String season;
	private String teamName;
	private ArrayList<SingleMatchPersonalDataPO> individualData;		//该场比赛的所有球员的数据信息
	
	public TeamMatchPO(String season,String teamName,ArrayList<SingleMatchPersonalDataPO> individualData){
		this.season=season;
		this.teamName= teamName;
		this.individualData= individualData;
		
	}
	
	public String getSeason(){
		return season;
	}
	public String getTeamName() {
		return teamName;
	}

	public ArrayList<SingleMatchPersonalDataPO> getIndividualData() {
		return individualData;
	}
}
