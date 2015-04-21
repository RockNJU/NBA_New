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

	// 热点球员的排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String condition) {

		// 创建针对某个属性的升序比较
		Comparator player_compare = new BeanComparator("points");
		// 默认的是升序，这里用一个降序
		player_compare = new ReverseComparator(player_compare);
		// 开始排序
		Collections.sort(playerSeasondata, player_compare);
		return playerSeasondata;
	}

	// 热点球队的排序方法
	@SuppressWarnings("unchecked")
	public ArrayList<TeamSeasonDataVO> hotTeam_Sort(
			ArrayList<TeamSeasonDataVO> teamSeasondata, String condition) {

		// 创建针对某个属性的升序比较
		@SuppressWarnings("rawtypes")
		Comparator team_compare = new BeanComparator(condition);
		// 默认的是升序，这里用一个降序
		team_compare = new ReverseComparator(team_compare);
		// 开始排序
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
	
	       System.out.println("----------------排序前-------------------------");
	        for(PlayerSeasonDataVO pvo:list){
	            System.out.println(pvo.getName()+"  "+pvo.getTeamName()+"  ["+pvo.getPointNum()+"]");
	        }
	        System.out.println("-----------------points的单个属性排序，排序后-------------------");
	        
	        list = h.hotPlayer_Sort(list, "points");
	        for(PlayerSeasonDataVO pvo:list){
	            System.out.println(pvo.getName()+"  "+pvo.getTeamName()+"  ["+pvo.getPointNum()+"]");
	        }
	        
		
		
		
	}
}