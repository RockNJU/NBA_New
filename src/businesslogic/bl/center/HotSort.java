package businesslogic.bl.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.beanutils.BeanUtils;

import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;

public class HotSort {

	// �ȵ���Ա�����򷽷�
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String condition) {

		// �������ĳ�����Ե�����Ƚ�
		Comparator player_compare = new BeanComparator("points");
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
	
	public static void main(String[] args){
		PlayerSeasonDataVO pvo1 = new PlayerSeasonDataVO("13-14", "John", "Eagle", "front", 30, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 150);
		PlayerSeasonDataVO pvo2 = new PlayerSeasonDataVO("13-14", "Bob", "EDG", "front", 30, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 160);
		PlayerSeasonDataVO pvo3 = new PlayerSeasonDataVO("13-14", "William", "OMG", "front", 30, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 83);
		PlayerSeasonDataVO pvo4 = new PlayerSeasonDataVO("13-14", "Swen", "Tiger", "front", 30, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 99);
		PlayerSeasonDataVO pvo5 = new PlayerSeasonDataVO("13-14", "Keven", "Rabbit", "front", 30, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 75);
		PlayerSeasonDataVO pvo6 = new PlayerSeasonDataVO("13-14", "Blues", "Rabbit", "front", 30, 17, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 135);
		ArrayList<PlayerSeasonDataVO> list = new ArrayList<PlayerSeasonDataVO>();
		list.add(pvo1);
		list.add(pvo2);
		list.add(pvo3);
		list.add(pvo4);
		list.add(pvo5);
		list.add(pvo6);
		
		HotSort h= new HotSort();
	
	       System.out.println("----------------����ǰ-------------------------");
	        for(PlayerSeasonDataVO pvo:list){
	            System.out.println(pvo.getName()+"  "+pvo.getTeamName()+"  ["+pvo.getPointNum()+"]");
	        }
	        System.out.println("-----------------points�ĵ����������������-------------------");
	        
	        list = h.hotPlayer_Sort(list, "points");
	        for(PlayerSeasonDataVO pvo:list){
	            System.out.println(pvo.getName()+"  "+pvo.getTeamName()+"  ["+pvo.getPointNum()+"]");
	        }
	        
		
		
		
	}
}