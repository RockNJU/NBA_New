package businessService.blservice;

import java.util.ArrayList;

import VO.A_player_match_data;
import VO.*;

public interface PlayerBLService{
	public ArrayList<PlayerVO> getAllPlayer();		//��ȡ
	public PlayerVO getPlayer(String name);//������Ա������ȡ��Ա�Ļ�����Ϣ
	public ArrayList<PlayerVO> getPlayerInfo(String name);		        
	public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String paitition,String item);
	/*Ϊɸѡ��Ա����֮ǰ��������Ҫ��*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season);//��ȡ�������ȵ���Ա
	public ArrayList<A_player_match_data> getTodayHotPlayer(String item);//��ȡ������ȵ���Ա
}
