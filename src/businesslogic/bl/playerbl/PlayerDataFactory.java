package businesslogic.bl.playerbl;

import java.util.ArrayList;

import businesslogic.data.PlayerDataController;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerDataFactory {
	/**
	 *������Ա�����������Ļ�����Ϣ
	 **/
	ArrayList<PlayerInfoVO> infoList;
	ArrayList<PlayerSeasonData> dataList;
	
	
	
	public PlayerDataFactory(){
		PlayerDataController plc=new PlayerDataController();
		infoList=plc.getAllPlayer();
		dataList=new ArrayList<>();
	}
	
	
	
	public void add_A_player_matchData(SingleMatchPersonalDataVO vo){
		for(int i=0;i<dataList.size();i++){
			//�����ݲֿ����Ѿ������ݵ�ʱ�������ݲֿ�����������
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
	
	public ArrayList<PlayerSeasonDataVO> getSeasonDataList(String season) {
		/*���������Ϊ����������ĳ��������������Ա�ı���������Ϣ*/
		for(int i=0;i<dataList.size();i++){
			if(dataList.get(i).getSeason().equals(season)){
				return dataList.get(i).getPlayerDataList();
			}
		}
		
		return null;
	}
}