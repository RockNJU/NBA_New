package businesslogic.bl;
import java.util.ArrayList;
import VO.TeamInfoVO;

public class TeamDataFactoey {
	  ArrayList<TeamInfoVO> infoList;
	  ArrayList<TeamSeasonData> dataList;
	public ArrayList<TeamInfoVO> getInfoList() {
		return infoList;
	}
	public void setInfoList(ArrayList<TeamInfoVO> infoList) {
		this.infoList = infoList;
	}
	public ArrayList<TeamSeasonData> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<TeamSeasonData> dataList) {
		this.dataList = dataList;
	}
}
