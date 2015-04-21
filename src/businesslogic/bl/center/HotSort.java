package businesslogic.bl.center;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import VO.PlayerSeasonDataVO;
import VO.TeamSeasonDataVO;

public class HotSort {

	// 热点球员的排序方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<PlayerSeasonDataVO> hotPlayer_Sort(
			ArrayList<PlayerSeasonDataVO> playerSeasondata, String condition) {

		// 创建针对某个属性的升序比较
		Comparator player_compare = new BeanComparator(condition);
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
	

}