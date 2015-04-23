package businesslogic.bl.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ReverseComparator;

import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamSeasonDataVO;

public class HotSort {

	// �ȵ���Ա�����򷽷�
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String condition) {
		
		//�Ȱ��������� 
		Collections.sort(playerSeasondata,new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				PlayerSeasonDataVO p1 = (PlayerSeasonDataVO)o1;
				PlayerSeasonDataVO p2 = (PlayerSeasonDataVO)o2;
				String name1 = p1.getReverseName();
				String name2 = p2.getReverseName();
				return name1.compareTo(name2);
			}
		});

		// �������ĳ�����Ե�����Ƚ�
		Comparator player_compare = new BeanComparator(condition);
		// Ĭ�ϵ�������������һ������
		player_compare = new ReverseComparator(player_compare);
		// ��ʼ����
		Collections.sort(playerSeasondata, player_compare);

		return playerSeasondata;
	}
	
	

	// �ȵ���ӵ����򷽷�
	@SuppressWarnings("unchecked")
	public ArrayList<TeamSeasonDataVO> hotTeam_Sort(
			ArrayList<TeamSeasonDataVO> teamSeasondata, String condition) {

		//�Ȱ��������� 
		Collections.sort(teamSeasondata,new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				TeamSeasonDataVO p1 = (TeamSeasonDataVO)o1;
				TeamSeasonDataVO p2 = (TeamSeasonDataVO)o2;
				String name1 = p1.getTeamName();
				String name2 = p2.getTeamName();
				return name1.compareTo(name2);
			}
		});
		
		// �������ĳ�����Ե�����Ƚ�
		@SuppressWarnings("rawtypes")
		Comparator team_compare = new BeanComparator(condition);
		// Ĭ�ϵ�������������һ������
		team_compare = new ReverseComparator(team_compare);
		// ��ʼ����
		Collections.sort(teamSeasondata, team_compare);
		return teamSeasondata;

	}
	
	
	// �ȵ���Ա�����򷽷�
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<SingleMatchPersonalDataVO> hotSinglePlayer_Sort(
			ArrayList<SingleMatchPersonalDataVO> playerSeasondata, String condition) {
		
		//�Ȱ��������� 
		Collections.sort(playerSeasondata,new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				SingleMatchPersonalDataVO p1 = (SingleMatchPersonalDataVO)o1;
				SingleMatchPersonalDataVO p2 = (SingleMatchPersonalDataVO)o2;
				String name1 = p1.getPlayerReverseName();
				String name2 = p2.getPlayerReverseName();
				return name1.compareTo(name2);
			}
		});

		// �������ĳ�����Ե�����Ƚ�
		Comparator player_compare = new BeanComparator(condition);
		// Ĭ�ϵ�������������һ������
		player_compare = new ReverseComparator(player_compare);
		// ��ʼ����
		Collections.sort(playerSeasondata, player_compare);

		return playerSeasondata;
	}
	
	

}