package businesslogic.bl.teambl;
import java.util.ArrayList;

import businessService.blservice.TeamBLService;
import businesslogic.bl.center.HotSort;
import VO.TeamInfoVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public class TeamController implements TeamBLService,TeamInfo_player{
       private TeamDataFactory teamFactory;
       
       public TeamController(){
    	   teamFactory=new TeamDataFactory();
       }

       
       public void updateTeamData(TeamMatchVO vo){
    	   teamFactory.update_A_matchData(vo);
       }
       
	@Override
	public TeamInfoVO getTeam_info(String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_teamInfo(teamAbb);
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season) {
		// TODO Auto-generated method stub
		return teamFactory.getALLTeamSeasonData(season);
	}

	@Override
	public TeamSeasonDataVO get_A_TeamSeasonData(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_TeamSeasonData(season, teamAbb);
	}

	@Override
	public double getTeamWinNum(String season, String teamAbb) {
		// TODO Auto-generated method stub
		return teamFactory.get_A_TeamSeasonData(season, teamAbb).getWinRate();
	}

	@Override
	public ArrayList<String> getTeamAllPlayer(String teamAbb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamSeasonDataVO> sort(String season, String sortItem) {
		// TODO Auto-generated method stub
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(season);
		HotSort sort=new HotSort();
		
		return sort.hotTeam_Sort(list,sortItem);
	}

	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season, String item) {
		// TODO Auto-generated method stub
		ArrayList<TeamSeasonDataVO> list=teamFactory.getALLTeamSeasonData(season);
		HotSort sort=new HotSort();
		
		list= sort.hotTeam_Sort(list,item);
		ArrayList<TeamSeasonDataVO> result=new ArrayList<>();
		for(int i=0;i<5;i++){
			result.add(list.get(i));
		}
		return result;
	}
       
	
		
	
}
