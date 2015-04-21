package businesslogic.bl.playerbl;
import java.util.ArrayList;

import businessService.blservice.PlayerBLService;
import VO.*;

public class PlayerController implements PlayerBLService {
	   PlayerDataFactory playerFactory;    
	   
	    public PlayerController(){
	    	playerFactory=new PlayerDataFactory();
	    }
		public void updatePlayerData(ArrayList<SingleMatchPersonalDataVO> list){
			/*一场比赛后更新一支球队球员的基本信息*/
				playerFactory.addPlayer_matchData(list); 
		}
		
		@Override
		public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,
				String name) {
			ArrayList<PlayerSeasonDataVO> list=getPlayerSeasonData(season);
			for(int i=0;i<list.size();i++){
				if(list.get(i).getName().equals(name)){
					return list.get(i);
				}
			}
			return null;
		}
		@Override
		public PlayerInfoVO getPlayerInfo(String name) {
			// TODO Auto-generated method stub
			ArrayList<PlayerInfoVO> list=playerFactory.getInfoList();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getName().equals(name)){
					return list.get(i);
				}
			}
			return null;
		}
		@Override
		public ArrayList<PlayerInfoVO> getAllPlayerInfo() {
			// TODO Auto-generated method stub
			return playerFactory.getInfoList();
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> sort(String season,
				String position, String paitition, String item) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,
				String sortItem) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<A_player_match_data> getTodayHotPlayer(String item) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> getPlayerSeasonData(String season) {
			// TODO Auto-generated method stub
			return playerFactory.getSeasonDataList(season);
		}
	
	
}
