package businessService.blservice;

import java.util.ArrayList;

import VO.*;

public interface PlayerBLService{
	
	public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,String name);//������Ա������ȡ��Ա��ĳ�������ı�������
	public PlayerInfoVO getPlayerInfo(String name);   //������Ա�����ֻ�ȡ��Ա�Ļ�����Ϣ
	public ArrayList<PlayerInfoVO> getAllPlayerInfo();           //��ȡ������Ա�Ļ�����Ϣ
	public ArrayList<PlayerSeasonDataVO> sort(String season,String position,String partition,String item);/*Ϊɸѡ��Ա����֮ǰ��������Ҫ��*/
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,String sortItem);//��ȡ�������ȵ���Ա,����Ĳ�����������ɸѡ��Ŀ
	
	public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season);  //���մ����������ȡ���������е�������Ա����������
	
	 
	//     ��������-���д˹ؼ��ʵ���Ա�ı�����Ϣ��������Ϊ��������ֻ��ס���ջ�����ĸ
	public ArrayList<PlayerSeasonDataVO> keyfind( String text);
	
	 
		public ArrayList<PlayerInfoVO> getTeamAllPlayer(String season,String teamAbb);    
		//������ӵ���д��ȡ������е���Ա��������ʵ����Կ��Ƿ������еĻ�����Ϣ������������
		
		public  PlayerSeasonDataVO getMost_Progress_Player(String item);
	
}
