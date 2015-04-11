package businesslogic.bl;
import java.sql.*;
import java.util.ArrayList;

import businessService.blservice.PlayerBLService;
import VO.*;

public class PlayerController implements PlayerBLService {
	
		ArrayList<PlayerSeasonDataVO> dlist=new ArrayList<>();
		ArrayList<PlayerInfoVO> infoList=new ArrayList<>();
	
	public PlayerController(){
		readPlayerSeasonDataFromDB("13-14","points");
	}
		
		
	private void readPlayerSeasonDataFromDB(String season,String item){
		/*
		 * 从数据库中读取球员的赛季信息,传入的参数为赛季
		 * 和排序的标准，默认的是得分
		 * */
		Connection conn = null;  
        Statement stmt = null;  
        ResultSet rs  = null;  
        
        try {  
        	
        Class.forName("org.sqlite.JDBC");  
        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
        conn.setAutoCommit(false);  
        stmt = conn.createStatement(); 
   
       rs  = stmt.executeQuery("SELECT*FROM playerSeasonData where"
       		+ " season='"+season+"' and order by '"+item+" desc");
             
       
 

       PlayerSeasonDataVO PlayerData=new PlayerSeasonDataVO(null, null, null, null, 0, 0, 0, 0, 0, 0, 0,
    		   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        while (rs .next()){  
              dlist.add(new PlayerSeasonDataVO(rs.getString("season"),
            		  rs.getString("name"),rs.getString("teamName"),
            		 rs.getString("position"), rs.getInt("matchNum"),
            		 rs.getInt("startingNum"),rs.getDouble("time"),
            		  rs.getInt("fieldGoal"),rs.getInt("shootNum"),
	    			  rs.getInt("T_fieldGoal"),rs.getInt("T_shootNum"),
	    			  rs.getInt("freeThrowGoalNum"),rs.getInt("freeThrowNum"),
	    			  rs.getInt("O_ReboundNum"),
	    			  rs.getInt("D_ReboundNum"),rs.getInt("reboundNum"),
	    			  rs.getInt("assistNum"), rs.getInt("stealNum"),
	    			  rs.getInt("blockNum"),rs.getInt("turnoverNum"),
	    			  rs.getInt("foulNum"),rs.getInt("points")
	    			  ,rs.getDouble("assistEfficiency"),rs.getDouble("reboundEfficiency"),
	    			  rs.getDouble("offensesiveReboundEff"),rs.getDouble("defenseReboundEff"),
	    			  rs.getDouble("stealEfficiency"),rs.getDouble("usingPercentage"),
	    			  rs.getDouble("blockEfficiency"),rs.getInt("doubleNum"),rs.getInt("threeNum")));
              
             // System.out.println("测试打印篮板率："+ rs.getDouble("blockEfficiency"));
             
        }  
        
 
        if(rs !=null){  
           rs.close(); rs = null;  
        }  

       conn.commit();  

        } catch(ClassNotFoundException cnfe)  
        {  
            System.out.println("Can't find class for driver: " + cnfe.getMessage());  
            System.exit(-1);  
        } catch (SQLException e){  
            System.out.println("SQLException :" + e.getMessage());  
           System.exit(-1); 
           }  
        finally {  
            try {  
               if (rs!=null) rs.close();  
                stmt.close();  
               conn.close();  
           } catch (SQLException e){ 
        	  System.out.println("SQLException in finally :" + e.getMessage());  
            System.exit(-1);
            	} 
            }

		
	}//end readSeasonData
	
	
	public ArrayList<PlayerInfoVO> getPlayerInfoFrom_DB(){
		/*
		 * 获取所有球员的基本信息
		 * 以ArrayList的形式返回
		 * 
		 * */
		//ArrayList<PlayerInfoVO> list=new ArrayList<>();
		
		//************
		    Connection conn = null;  
	        Statement stmt = null;  
	        ResultSet rs  = null;   
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/playerInfo.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
	        char chr=39;
	       rs  = stmt.executeQuery("SELECT *FROM playerBaseInfo");  
	        while (rs .next()){  
	        	infoList.add(new PlayerInfoVO(rs.getString("name").replace('’', chr),rs.getString("number"),
		    			  rs.getString("position"),rs.getString("height"),
		    			  rs.getDouble("weight"),rs.getString("birth"),
		    			  rs.getInt("age"),rs.getInt("exp"),rs.getString("school")));
	        }  
	        if(rs !=null){  
	           rs.close(); 
	           rs = null;  
	        }  
 
	     //   stmt.executeUpdate("CREATE INDEX hehe_idx on hehe(id)");  
	       // stmt.executeUpdate("CREATE INDEX hehe_idx2 on hehe(name)");  
	       conn.commit();      
	        } catch(ClassNotFoundException cnfe)  
	        {  
	            System.out.println("Can't find class for driver: " + cnfe.getMessage());  
	            return infoList;  
	        } catch (SQLException e){  
	            System.out.println("SQLException :" + e.getMessage());  
	          return infoList; 
	           }  
	        finally {  
	            try {  
	               if (rs!=null) rs.close();  
	                stmt.close();  
	               conn.close();  
	           } catch (SQLException e) {
	        	   System.out.println("SQLException in finally :" + e.toString());  
	            System.exit(-1);
	            	} 
	            }
		//********
		return infoList;
	}
	
	
	public PlayerInfoVO get_A_PlayerInfo(String name){
		/*
		 * 根据球员的姓名
		 * 从数据库中获取球员的基本信息
		 * 
		 * */
		getPlayerInfoFrom_DB();
		for(int i=0;i<infoList.size();i++){
			if(infoList.get(i).getName().equals(name))
			return infoList.get(i);
		}
		 
		//********
		return null;//如果没有查询到就返回空
	}


	@Override
	public ArrayList<PlayerVO> getAllPlayer() {
		// TODO Auto-generated method stub
		getPlayerInfoFrom_DB();
		ArrayList<PlayerVO> list=new ArrayList<>();
		
		for(int i=0;i<dlist.size();i++){
			list.add(new PlayerVO(getInfo(dlist.get(i).getName()),dlist.get(i)));
		}
		
		return list;
	}

	 private PlayerInfoVO getInfo(String name){
		  PlayerInfoVO vo=new PlayerInfoVO(name, " --", "-- ","-- ", 0, "--", 0, 0, "--");
		 for(int i=0;i<infoList.size();i++){
			 if(infoList.get(i).equals(name)){
				 return infoList.get(i);
			 
			 }
		 }
		 return vo;
	 }

	@Override
	public PlayerVO getPlayer(String name) {
		// TODO Auto-generated method stub
		ArrayList<PlayerVO> list=getAllPlayer();
		 for(int i=0;i<list.size();i++){
			 if(list.get(i).equals(name)){
				 return list.get(i);
			 
			 }
		 }
		return null;
	}


	@Override
	public ArrayList<PlayerVO> getPlayerInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<PlayerSeasonDataVO> sort(String season, String position,
			String partition, String item) {
		
		//readPlayerFromDBS(item);
		
		ArrayList<PlayerSeasonDataVO> list=dlist;
		
		
		if(position!=null&&position.trim().length()!=0){
			
			list=sort_position(list,position);
		}
		
		if(partition.trim().length()!=0){
			
			if(partition.equals("E")||partition.equals("W")){
				list=sort_division(list,partition);
			}
			
			else {
			list=sort_partition(list,partition);
			}
		}
		
		int min=50;
		if(list.size()<50){
			min=list.size();
		}
		
		
		ArrayList<PlayerSeasonDataVO> result=new ArrayList<>();
		for(int i=0;i<min;i++){
			result.add(list.get(i));
		}
		
		System.out.println("返回的列表大小："+list.size());
	 
		return null;
	}


	@Override
	public ArrayList<PlayerSeasonDataVO> getSeasonHotPlayer(String season) {
		// TODO Auto-generated method stub
		/*
		 * 注：未完全实现
		 * */
		
		readPlayerSeasonDataFromDB(season,"points");
		
		return dlist;
	}


	@Override
	public ArrayList<A_player_match_data> getTodayHotPlayer(String item) {
		// TODO Auto-generated method stub
		
		ArrayList<A_player_match_data> list=new ArrayList<>();
		Connection conn = null;  
        Statement stmt = null;  
        ResultSet rs  = null;   
        try {  
        	
        Class.forName("org.sqlite.JDBC");  
        conn = DriverManager.getConnection( "jdbc:sqlite:database/playerInfo.db");  
        conn.setAutoCommit(false);  
        stmt = conn.createStatement(); 
        char chr=39;
       rs  = stmt.executeQuery("SELECT TOP (5)*FROM playerBaseInfo order by '"+item+"' and  ");  
        while (rs .next()){  
        	
        	/*stmt.executeUpdate("create table player_match_record(season varchar(10) , date varchar(20),"
		           		+ "teamAbb varchar(10), name varchar(32), position varchar(3),"
		           		+ " time double(5,3),fieldGoal int ,shootNum int,"
		           		+ "T_fieldGoal int,T_shootNum int,"
		           		+ "freeThrowGoalNum int, freeThrowNum int ,O_ReboundNum int,"
		           		+ "D_ReboundNum int,assistNum int,stealNum int,"
		           		+ "blockNum int,turnoverNum int,foulNum int,points int,"
		           		
		           		+ "assistEfficiency double(5,3),reboundEfficiency double(5,3),"
		           		+ "offenseEfficiency double(5,3),defenseEfficiency double(5,3),"
		           		+ "stealEfficiency double(5,3),usingPercentage double(5,3),"
		           		+ "blockEfficiency double(5,3))"); */
        	list.add(new A_player_match_data(rs.getString("season"),rs.getString("date"),
          		  rs.getString("teamAbb"),rs.getString("name"),
          		 rs.getString("position"),rs.getDouble("time"),
          		  rs.getInt("fieldGoal"),rs.getInt("shootNum"),
	    			  rs.getInt("T_fieldGoal"),rs.getInt("T_shootNum"),
	    			  rs.getInt("freeThrowGoalNum"),rs.getInt("freeThrowNum"),
	    			  rs.getInt("O_ReboundNum"),
	    			  rs.getInt("D_ReboundNum"),
	    			  rs.getInt("assistNum"), rs.getInt("stealNum"),
	    			  rs.getInt("blockNum"),rs.getInt("turnoverNum"),
	    			  rs.getInt("foulNum"),rs.getInt("points")
	    			  ,chr, rs.getDouble("assistEfficiency"),rs.getDouble("reboundEfficiency"),
	    			  rs.getDouble("offenseEfficiency"),rs.getDouble("defenseEffisiency"),
	    			  rs.getDouble("stealEfficiency"),rs.getDouble("usingPercentage"),
	    			  rs.getDouble("blockEfficiency")));
        }  
        if(rs !=null){  
           rs.close(); 
           rs = null;  
        }  

     //   stmt.executeUpdate("CREATE INDEX hehe_idx on hehe(id)");  
       // stmt.executeUpdate("CREATE INDEX hehe_idx2 on hehe(name)");  
       conn.commit();      
        } catch(ClassNotFoundException cnfe)  
        {  
            System.out.println("Can't find class for driver: " + cnfe.getMessage());  
          //  return infoList;  
        } catch (SQLException e){  
            System.out.println("SQLException :" + e.getMessage());  
       //   return infoList; 
           }  
        finally {  
            try {  
               if (rs!=null) rs.close();  
                stmt.close();  
               conn.close();  
           } catch (SQLException e) {
        	   System.out.println("SQLException in finally :" + e.toString());  
            System.exit(-1);
            	} 
            }
		
		
		return null;
	}
	
	/******************************************/
	private  ArrayList<PlayerSeasonDataVO> sort_division(ArrayList<PlayerSeasonDataVO>list,
			String division)  {
		TeamInfo_player tp=new TeamController();
		for(int i=0;i<list.size();i++){
			if(tp.getTeam_info(list.get(i).getTeamName())!=null){
			if(!(tp.getTeam_info(list.get(i).getTeamName())).
					getDivision().equals(division)){
				list.remove(i);
				//if(i>0)
					i--;
			}
		}
		}
		return list;
	}
	
	private ArrayList<PlayerSeasonDataVO> sort_partition(ArrayList<PlayerSeasonDataVO>list,
			String partition) {
		 TeamInfo_player tp=new TeamController();
		for(int i=0;i<list.size();i++){
			if(tp.getTeam_info(list.get(i).getTeamName())!=null){
			if(!(tp.getTeam_info(list.get(i).getTeamName())).
					getPartition().equals(partition)){
				list.remove(i);
				//if(i>0)
					i--;
			}
		}
		}	
		return list;
	}
	
	private ArrayList<PlayerSeasonDataVO> sort_position(ArrayList<PlayerSeasonDataVO>list,String position){
		
		for(int i=0;i<list.size();i++){
			if(!(list.get(i).getPosition().contains(position))){
				list.remove(i);
					i--;
			}
		}
		return list;
	}
	
}
