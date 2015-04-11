package businesslogic.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businesslogic.PO.PlayerInfoPO;
import businesslogic.PO.TeamInfoPO;


public class TeamDB {
	
	public static void main(String args[]){
		
		System.out.println("进入main函数导入球队基本信息�   ");
		TeamData pd=new TeamData();
		 ArrayList<TeamInfoPO> list=pd.getTeamInfoList();
		//ArrayList<TeamInfoPO> list=new ArrayList<>();
		 //list=pd.getTeamInfoList();
		TeamDB db=new  TeamDB();
		db.writeTeamInfo_to_DB(list);
	 // list=db.getTeamInfoFrom_DB();
		
		for(int i=0;i<list.size();i++){
			System.out.println("球队信息�   "+list.get(i).getFullName()+"-----"+(1+i));
		}
		System.out.println("打印球队�   ***息结束！");
	}
	
	
	
	public void writeTeamInfo_to_DB(ArrayList<TeamInfoPO> list){
		/**
		 * 将球队的基本信息写入数据�   
		 * */
		 	Connection conn = null;  
		 	Statement stmt = null;  
	        ResultSet rset = null;  
	       System.out.println(new java.util.Date());  
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/teamInfo.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement();  
	        stmt.executeUpdate("drop table if exists teamBaseInfo");  
	        
	        stmt.executeUpdate("create table teamBaseInfo(fullName varchar(60) , "
	        		+ "location varchar(32), teamAbb varchar(10) PRIMARY KEY,"
	        		+ " division varchar(3),partition varchar(32) ,"
	        		+ "homeGround varchar(60) , formedTime varchar(32))");  
	        //System.out.println("建表hehe成功!");  
	        TeamInfoPO po;
	         for (int i=0; i<list.size(); i++) {  
	        	po=list.get(i);
	           System.out.println(stmt.executeUpdate("INSERT INTO "
	           		+ "teamBaseInfo VALUES('" + po.getFullName() + "', '" + po.getLocation() + "',"
	           		+ "'" + po.getTeamAbb() + "' ,'" + po.getDivision() + "' , "
	           		+ "'" + po.getPartition() + "','" + po.getHomeGround() + "' ,"
	           		+ "'" + po.getFormedTime() + "')"));  
	        }   
	        conn.commit();  
		
	       } catch(ClassNotFoundException cnfe)  {  
         System.out.println("Can´t find class for driver: " + cnfe.getMessage());  
         System.exit(-1);  
     } catch (SQLException e){  
         System.out.println("SQLException :" + e.toString());  
         System.exit(-1); 
        }  
     finally {  
         try {  
            if (rset!=null) rset.close();  
             stmt.close();  
            conn.close();  
         } catch (SQLException e) {
        	 System.out.println("SQLException in finally :" +e.toString());  
         System.exit(-1);}
         }
	}// end write
	
	public ArrayList<TeamInfoPO> getTeamInfoFrom_DB(){
		/*
		 * 获取�   有球队的基本信息
		 * 以ArrayList的形式返�   
		 * 
		 * */
		ArrayList<TeamInfoPO> list=new ArrayList<>();
		
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
	        	list.add(new TeamInfoPO(rs.getString("fullName"),
	        			rs.getString("teamAbb"),rs.getString("location"),
	        			rs.getString("division"), rs.getString("partition"),
	        			rs.getString("homeGround"),rs.getString("formedTime")));
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
	            System.out.println("Can´t find class for driver: " + cnfe.getMessage());  
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
		
}
