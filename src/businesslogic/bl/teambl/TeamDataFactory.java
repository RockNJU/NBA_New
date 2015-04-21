package businesslogic.bl.teambl;
import java.util.ArrayList;

import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class TeamDataFactory {
	  ArrayList<TeamInfoVO> infoList;
	  ArrayList<TeamSeasonData> dataList;
	  
	  
	  public TeamDataFactory(){
		  dataList=new ArrayList<>();
	  }
	  
	 public TeamInfoVO get_A_teamInfo(String teamAbb){
		 for(int i=0;i<infoList.size();i++){
			 if(infoList.get(i).getTeamAbb().equals(teamAbb)|
					 infoList.get(i).getFullName().equals(teamAbb)){
				 return infoList.get(i);
			 }
		 }
		 return null;
	 } 
	  
	public void update_A_matchData(TeamMatchVO vo){
		/*����һ������������ӵ�������Ϣ�����仯*/
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(vo.getSeason())){
				dataList.get(i).updateTeamSeasonData(vo);
				return;
			}
		}
		
		
		
		//��������ݲֿ���û�ж�Ӧ����������ʱ������һ��������ArrayList����
		TeamSeasonData data=new TeamSeasonData(vo.getSeason());
		data.updateTeamSeasonData(vo);
		dataList.add(data);
	}
	
	public TeamSeasonDataVO get_A_TeamSeasonData(String season,String teamAbb){
		ArrayList<TeamSeasonDataVO> list=getALLTeamSeasonData(season);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTeamName().equals(teamAbb))
				return list.get(i);
		}
		return null;
	}
	
	public ArrayList<TeamSeasonDataVO> getALLTeamSeasonData(String season){
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).getTeamSeasnList();   
				//�������������е�������ӵ�����������Ϣ
			}
		}
		return null;   //��û�ж�Ӧ���������ݵ�ʱ�򣬷��ؿա�
	}
	
	
	public ArrayList<TeamInfoVO> getInfoList() {
		return infoList;
	}
	
	public void setInfoList(ArrayList<TeamInfoVO> infoList) {
		this.infoList = infoList;
	}
	public ArrayList<TeamSeasonData> getDataList(){
		return dataList;
	}
}