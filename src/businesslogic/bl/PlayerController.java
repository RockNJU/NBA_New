package businesslogic.bl;
import java.sql.*;
import java.util.ArrayList;

import businessService.blservice.PlayerBLService;
import VO.*;

public class PlayerController implements PlayerBLService {
	
		ArrayList<PlayerSeasonDataVO> dlist=new ArrayList<>();
		ArrayList<PlayerInfoVO> infoList=new ArrayList<>();
		@Override
		public PlayerSeasonDataVO getAPlayerSeasonMatch(String season,
				String name) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerInfoVO> getPlayerInfo(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PlayerInfoVO> getAllPlayerInfo() {
			// TODO Auto-generated method stub
			return null;
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
			return null;
		}
	
	
}
