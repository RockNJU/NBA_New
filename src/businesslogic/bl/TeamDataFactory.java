package businesslogic.bl;
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
	  
	public void update_A_matchData(TeamMatchVO vo){
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(vo.getSeason())){
				dataList.get(i).updateTeamSeasonData(vo);
				return;
			}
		}
		
		
		
		//��������ݲֿ���û�ж�Ӧ����������ʱ�����һ��������ArrayList����
		TeamSeasonData data=new TeamSeasonData(vo.getSeason());
		data.updateTeamSeasonData(vo);
		dataList.add(data);
	}
	
	
	public ArrayList<TeamSeasonDataVO> get(String season){
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).getTeamSeasnList();
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
	public void setDataList(ArrayList<TeamSeasonData> dataList) {
		this.dataList = dataList;
	}
}
