package businesslogic.bl;

import java.util.ArrayList;

import VO.PlayerInfoVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerDataFactory {
	/**
	 *������Ա�����������Ļ�����Ϣ
	 **/
	ArrayList<PlayerInfoVO> infoList;
	ArrayList<PlayerSeasonData> dataList;
	
	
	
	public PlayerDataFactory(){
		
	}
	
	public void add_A_player_matchData(SingleMatchPersonalDataVO vo){
		for(int i=0;i<dataList.size();i++){
			//�����ݲֿ����Ѿ������ݵ�ʱ�������ݲֿ����������
			if(dataList.get(i).getSeason().equals(vo.getSeason())){
				dataList.get(i).updatePlayerSeasonData(vo);
			}
		}
		
		/*
		 * �����ݲֿ���û�ж�Ӧ�������ݵ�ʱ���½��ֿ��µ�һ��֧��֧
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
