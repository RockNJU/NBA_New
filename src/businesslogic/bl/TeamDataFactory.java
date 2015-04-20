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
		
		
		
		//当球队数据仓库中没有对应赛季的数据时，添加一个赛季的ArrayList数据
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
		return null;   //当没有对应赛季的数据的时候，返回空。
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
