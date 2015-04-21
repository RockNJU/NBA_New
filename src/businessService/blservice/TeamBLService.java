package businessService.blservice;
import java.util.ArrayList;

import VO.TeamSeasonDataVO;
import VO.TeamVO;

public interface TeamBLService {
	
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season);	
	//����ĳ��������������ӵ�����������Ϣ������Ĳ���Ϊ����
	
	public TeamSeasonDataVO get_A_TeamSeasonData(String season,String teamAbb);	
	//���������������д��ȡһ֧�����ĳ�������ı�����Ϣ
	
	public double getTeamWinNum(String season,String teamAbb);
	//������������ӻ�ȡһ֧��ӵ�ʤ�ʣ�ע����һ������ǰ���µģ�ʤ����TeamSeasonDataVO���Ѿ����ˣ��Ҳ�֪���費��Ҫ
	
	public ArrayList<String> getTeamAllPlayer(String teamAbb);    
	//������ӵ���д��ȡ������е���Ա��������ʵ����Կ��Ƿ������еĻ�����Ϣ������������
	
	public ArrayList<TeamVO> sort(String season,String sortItem);  //��������������� ���Զ���ӽ�������󷵻�
	
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season,String item);
	//����������ɸѡ������ ��ȡ�����ȵ���ӣ�������ǰ������
	
}
