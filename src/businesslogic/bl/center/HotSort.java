package businesslogic.bl.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;

public class HotSort {

	// �ȵ���Ա�����򷽷�
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String condition) {

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

		// �������ĳ�����Ե�����Ƚ�
		@SuppressWarnings("rawtypes")
		Comparator team_compare = new BeanComparator(condition);
		// Ĭ�ϵ�������������һ������
		team_compare = new ReverseComparator(team_compare);
		// ��ʼ����
		Collections.sort(teamSeasondata, team_compare);
		return teamSeasondata;

	}
	

}