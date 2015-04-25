package VO;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.bl.center.HotSort;

public class MatchVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String season;					//����
	private String date;					//��������
	private String matchScore;				//�����ȷ�
	private ArrayList<String> scores;		//������ÿ�ڱȷ�
	
	private TeamMatchVO  hostTeam;			//���ӵı�������
	private TeamMatchVO  guestTeam;			//�Ͷӵı�������
	
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
		/*��ȡһ�������е÷���*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("pointNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_rebound(){
		/*��ȡһ��������������*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("reboundNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_assist(){
		/*��ȡһ�������е�������**/
		ArrayList<SingleMatchPersonalDataVO>list= sort("assistNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_steal(){
		/*��ȡһ�������е�������*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("stealNum");
		
		return list.get(0);
	}
	
	public SingleMatchPersonalDataVO get_Highest_block(){
		/*��ȡһ�������еĸ�ñ��*/
		ArrayList<SingleMatchPersonalDataVO>list= sort("blockNum");
		
		return list.get(0);
	}
}
