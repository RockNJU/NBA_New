package businesslogic.bl;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businessService.blservice.TeamBLService;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

public class TeamController implements TeamBLService,TeamInfo_player{
		
	ArrayList<TeamSeasonDataVO> dlist=new ArrayList<>();
	
	public TeamController(){
		dlist=getAllTeamSeasonData("13-14","winRate");
	}
	
	
	private ArrayList<TeamSeasonDataVO> getAllTeamSeasonData(String season,String item){
		 /*
		   
		  * */
		    dlist.clear();
	    	Connection conn = null;  
	        Statement stmt = null;  
	        ResultSet rs  = null;   
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
	   
	       rs  = stmt.executeQuery("SELECT*FROM teamSeasonData where season='"+season+"' ");  
	        
	        while (rs .next()){  
	             dlist.add(new TeamSeasonDataVO(rs.getString("season"),rs.getString("teamName"),
	            		  rs.getInt("matchNum"),rs.getInt("winNum"), 
	            		  rs.getInt("fieldGoal"),rs.getInt("shootNum"),
		    			  rs.getInt("T_fieldGoal"),rs.getInt("T_shootNum"),
		    			  rs.getInt("freeThrowGoalNum"),rs.getInt("freeThrowNum"),rs.getInt("O_ReboundNum"),
		    			  rs.getInt("D_ReboundNum"),rs.getInt("assistNum"),
		    			  rs.getInt("stealNum"),rs.getInt("reboundNum"),
		    			  rs.getInt("blockNum"),rs.getInt("turnoverNum"),
		    			  rs.getInt("foulNum"),rs.getInt("points")
		    			  ,rs.getDouble("shootPercentage"),rs.getDouble("threePointPercentage"),
		    			  rs.getDouble("freeThrowPercentage"),rs.getDouble("offenseRound"),
		    			  rs.getDouble("offenseEfficiency"),rs.getDouble("defenseEfficiency"),
		    			  rs.getDouble("reboundEfficiency"),rs.getDouble("stealEfficiency"),
		    			  rs.getDouble("assistEfficiency")));
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
		return dlist;
		
	}
   
	private ArrayList<TeamInfoVO> getTeamInfoFrom_DB(){
		/*
	 
		 * 
		 * */
		ArrayList<TeamInfoVO> list=new ArrayList<>();
		
		//************
		    Connection conn = null;  
	        Statement stmt = null;  
	        ResultSet rs  = null;   
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/teamInfo.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
	        
	       rs  = stmt.executeQuery("SELECT *FROM teamBaseInfo");  
	        while (rs .next()){  
	        	list.add(new TeamInfoVO(rs.getString("fullName"),
	        			rs.getString("teamAbb"),rs.getString("location"),
	        			rs.getString("division"), rs.getString("partition"),
	        			rs.getString("homeGround"),rs.getString("formedTime")));
	        }  
	        if(rs !=null){  
	           rs.close(); 
	           rs = null;  
	        }  
  
	       conn.commit();      
	        } catch(ClassNotFoundException cnfe)  
	        {  
	            System.out.println("Can't find class for driver: " + cnfe.getMessage());  
	            return list;  
	        } catch (SQLException e){  
	            System.out.println("SQLException :" + e.getMessage());  
	          return list; 
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
		return list;
	}


	@Override
	public ArrayList<TeamVO> getAllTeam(String season) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TeamVO getTeamInfo(String teamAbb) {
		// TODO Auto-generated method stub
		ArrayList<TeamInfoVO> list=getTeamInfoFrom_DB();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getTeamAbb().equals("teamAbb"));
			//return list.get(i);
		}
		
		return null;
	}


	@Override
	public double getTeamWinNum(String season, String teamAbb) {
		// TODO Auto-generated method stub
		for(int i=0;i<dlist.size();i++){
			//if(dlist.get(i).gets)
		}
		
		return 0;
	}


	@Override
	public ArrayList<String> getTeamAllPlayer(String teamAbb) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TeamVO> sort(String season, String sortItem) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<TeamSeasonDataVO> getHotTeam(String season, String item) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TeamInfoVO getTeam_info(String teamAbb) {
		// TODO Auto-generated method stub
		return null;
	}

}
