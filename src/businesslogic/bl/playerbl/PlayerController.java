package businesslogic.bl.playerbl;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businessService.blservice.PlayerBLService;
import businesslogic.bl.center.HotSort;
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
		public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season,
				String sortItem) {
			// TODO Auto-generated method stub
			ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(season) ;
			HotSort sort=new HotSort();
			list= sort.hotPlayer_Sort(list,sortItem);
			for(int i=0;i<5;i++){
				result.add(list.get(i));
			}
			return result;
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
	///////////////////////////////////////一下部分是排序所需
		
		@Override
		public ArrayList<PlayerSeasonDataVO> sort(String season,
				String position, String partition, String item) {
			// TODO Auto-generated method stub
			ArrayList<PlayerSeasonDataVO> list= playerFactory.getSeasonDataList(season) ;
			System.out.println("筛选前《"+"list的大小"+list.size());
			
			if(partition==null|partition.trim().length()==0){
				if(position.length()>=1){
					list=sort_position(list,position);
					System.out.println("球员位置筛选后《"+"list的大小："+list.size());
				}
				HotSort sort=new HotSort();
				return sort.hotPlayer_Sort(list,item);
			}
			
			
			if(partition.trim().length()>1){
				list=sort_partition(list,partition);
				System.out.println("赛区筛选后《"+"list的大小："+list.size());
				if(position.length()>=1){
					list=sort_position(list,position);
					System.out.println("球员位置筛选后《"+"list的大小："+list.size());
				}
				HotSort sort=new HotSort();
				return sort.hotPlayer_Sort(list,item);
			}
			
			if(partition.trim().equals("E")|partition.equals("W")){
				
				list=sort_division(list,partition);
				
				System.out.println("Division分区筛选后《"+"list的大小："+list.size());
			}
			
			
			if(position.length()>=1){
				list=sort_position(list,position);
				System.out.println("球员位置筛选后《"+"list的大小："+list.size());
			}
			HotSort sort=new HotSort();
			return sort.hotPlayer_Sort(list,item);
		}
		private  ArrayList<PlayerSeasonDataVO> sort_division(ArrayList<PlayerSeasonDataVO>list,
				String division) {
			 
			ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getDivision().equals(division)){
				vo.add(list.get(i));
				}
			}
			return vo;
			}
			
		 
		private ArrayList<PlayerSeasonDataVO> sort_partition(ArrayList<PlayerSeasonDataVO>list,
				String partition) {
			 
			ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getPartition().equals(partition)){
				vo.add(list.get(i));
				}
			}
			return vo;
		}
		
		private ArrayList<PlayerSeasonDataVO> sort_position(ArrayList<PlayerSeasonDataVO>list,String position){
			/*这个地方有待思考*/
			ArrayList<PlayerSeasonDataVO> vo=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).getPosition().contains(position)){
				vo.add(list.get(i));
				}
			}
			return vo;
			 
		}
		@Override
		public ArrayList<PlayerSeasonDataVO> keyfind(String text) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
