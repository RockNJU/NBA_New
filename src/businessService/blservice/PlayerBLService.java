package businessService.blservice;

import java.util.ArrayList;

import VO.A_player_match_data;
import VO.*;

public interface PlayerBLService{
	
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,String name);//������Ա������ȡ��Ա��ĳ�������ı�������
	public PlayerInfoVO getPlayerInfo(String name);   //������Ա�����ֻ�ȡ��Ա�Ļ�����Ϣ
	public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //��ȡ������Ա�Ļ�����Ϣ
	public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String paitition,String item);/*Ϊɸѡ��Ա����֮ǰ��������Ҫ��*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);//��ȡ�������ȵ���Ա,����Ĳ�����������ɸѡ��Ŀ
	public ArrayList<A_player_match_data> getTodayHotPlayer(String item);//��ȡ������ȵ���Ա����������ȵ���Ŀ
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  //���մ����������ȡ���������е�������Ա����������
	
}
