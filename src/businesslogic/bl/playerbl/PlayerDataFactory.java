package businesslogic.bl.playerbl;

import java.util.ArrayList;

import businesslogic.data.PlayerDataController;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerDataFactory {
	/**
	 *保存球员的所有赛季的基本信息
	 **/
	ArrayList<PlayerInfoVO> infoList;
	ArrayList<PlayerSeasonData> dataList;
	
	
	
	public PlayerDataFactory(){
		PlayerDataController plc=new PlayerDataController();
		infoList=plc.getAllPlayer();
		
		dataList=new ArrayList<>();
	}
	
	
	
	public void addPlayer_matchData(ArrayList<SingleMatchPersonalDataVO> list){
		for(int i=0;i<dataList.size();i++){
			//当数据仓库中已经有数据的时候，往数据仓库中添加数据
			if(dataList.get(i).getSeason().equals(list.get(0).getSeason())){
			
				for(int k=0;k<list.size();k++)
				dataList.get(i).updatePlayerSeasonData(list.get(k));
				
				return;
			}
		}
		
		/*
		 * 当数据仓库中没有对应赛季数据的时候，新建仓库下的一个支分支
		 * */
		
		System.out.println("添加的第  " +dataList.size()+"  赛季:"+list.get(0).getSeason());
		PlayerSeasonData newData=new PlayerSeasonData(list.get(0).getSeason(),infoList);
		
		for(int k=0;k<list.size();k++){
			newData.updatePlayerSeasonData(list.get(k));
		}
		dataList.add(newData);
		
	}
	
	public ArrayList<PlayerInfoVO> getInfoList() {
		return infoList;
	}
	
	public ArrayList<PlayerSeasonDataVO> getSeasonDataList(String season) {
		/*传入的数据为赛季，返回某个赛季的所有球员的比赛数据信息*/
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).getPlayerDataList();
			}
		}
		
		return null;
	}
}
