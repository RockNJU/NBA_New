package businesslogic.PO;

import java.util.ArrayList;
public class TeamMatchPO {
	/*
	 * 
	 * ����һ��������һ֧��ӵĳ־û�����
	 * ֻ�ɶ��������޸� 
	 * 
	 * */
	private String season;
	private String teamName;
	private ArrayList<SingleMatchPersonalDataPO> individualData;		//�ó�������������Ա��������Ϣ
	
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
