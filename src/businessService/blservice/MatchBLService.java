package businessService.blservice;
import java.util.ArrayList;

import businesslogic.bl.matchbl.MatchInfo;
import VO.MatchVO;
public interface MatchBLService {
	
	ArrayList<MatchInfo> getMatchByTeamTime(String date); 
	            /*  ������������ڻ�ȡ��һ�����еı�����Ϣ
	          ������Ϣ MatchInfo ���matchbl���MAtchInfo���壬
	          ����Ϊ���֮ǰ����-������String���㣬ʡȥ���ǵķָ����               
	                         */
	MatchVO getMatchByTeam(String data,String teamA,String teamB);
	        //������ӵ���д�ͱ������ڻ�ȡĳһ�����������ݣ�����һ��MatchVO
}
