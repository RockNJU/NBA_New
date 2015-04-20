package businesslogic.bl;

import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerDataFactory {
	/**
	 *保存球员的所有赛季的基本信息
	 **/
	ArrayList<PlayerInfoVO> infoList;
	ArrayList<PlayerSeasonData> dataList;
	
	
	
	public PlayerDataFactory(){
		
	}
	
	public void add_A_player_matchData(SingleMatchPersonalDataVO vo){
		for(int i=0;i<dataList.size();i++){
			//当数据仓库中已经有数据的时候，往数据仓库中添加数据
			if(dataList.get(i).getSeason().equals(vo.getSeason())){
				dataList.get(i).updatePlayerSeasonData(vo);
			}
		}
		
		/*
		 * 当数据仓库中没有对应赛季数据的时候，新建仓库下的一个支分支
		 * */
		PlayerSeasonData newData=new PlayerSeasonData(vo.getSeason());
		newData.updatePlayerSeasonData(vo);
		dataList.add(newData);
		
	}
	
	public ArrayList<PlayerInfoVO> getInfoList() {
		return infoList;
	}
	public void setInfoList(ArrayList<PlayerInfoVO> infoList) {
		this.infoList = infoList;
	}
	public ArrayList<PlayerSeasonData> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<PlayerSeasonData> dataList) {
		this.dataList = dataList;
	}
}
