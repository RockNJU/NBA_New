package businesslogic.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businesslogic.PO.PlayerInfoPO;

public class PlayerDB {
	
	public static void main(String args[]){
		System.out.println("进入main函数导入球员基本信息�  ");
		PlayerData pd=new PlayerData();
		ArrayList<PlayerInfoPO> list=pd.getAllPlayer();
		//ArrayList<PlayerInfoPO> list=new ArrayList<>();
		PlayerDB db=new  PlayerDB();
		db.writePlayerInfo_to_DB(list);
	  list=db.getPlayerInfoFrom_DB();
		
		for(int i=0;i<list.size();i++){
			System.out.println("球员信息�  "+list.get(i).getName()+"-----"+(1+i));
		}
		System.out.println("打印球员信息结束�  ");
	}
	
	public void writePlayerInfo_to_DB(ArrayList<PlayerInfoPO> list){
		/**
		 * 将球员的基本信息写入数据�  
		 * */
		  Connection conn = null;  
	       Statement stmt = null;  
	        ResultSet rset = null;  
	        
	       System.out.println(new java.util.Date());  
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/playerInfo.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement();  
	       stmt.executeUpdate("drop table if exists playerBaseInfo");  
	        stmt.executeUpdate("create table playerBaseInfo(name varchar(60), "
	        		+ "number varchar(3), position varchar(5) ,"
	        		+ " height varchar(10),weight double(5,3) ,"
	        		+ "birth varchar(60) , age int,exp int,school varchar(60))");  
	        //System.out.println("建表hehe成功!");  
	        PlayerInfoPO po;
	        char chr=39;
	        for (int i=0; i<list.size(); i++) {  
	        	po=list.get(i);
	           stmt.executeUpdate("INSERT INTO playerBaseInfo VALUES("
	           		+ "'" + po.getName().replace(chr, '��') + "', "
	           		+ "'" + po.getNumber() + "','" + po.getPosition() + "' ,"
	           		+ "'" + po.getHeight() + "' , '" + po.getWeight() + "',"
	           		+ "'" + po.getBirth() + "' ,'" + po.getAge() + "',"
	           		+ "'" + po.getExp() + "','" + po.getSchool().replace(chr, '��') + "')");  
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
         System.exit(-1);
         	}
         }
	}// end write
	
	public ArrayList<PlayerInfoPO> getPlayerInfoFrom_DB(){
		/*
		 * 获取�  有球员的基本信息
		 * 以ArrayList的形式返�  
		 * 
		 * */
		ArrayList<PlayerInfoPO> list=new ArrayList<>();
		
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
	        	list.add(new PlayerInfoPO(rs.getString("name").replace('��', chr),rs.getString("number"),
		    			  rs.getString("position"),rs.getString("height"),
		    			  rs.getDouble("weight"),rs.getString("birth"),
		    			  rs.getInt("age"),rs.getInt("exp"),rs.getString("school").replace('��', chr)));
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
	
	
	public PlayerInfoPO get_A_PlayerInfoPO(String name){
		 Connection conn = null;  
	        Statement stmt = null;  
	        ResultSet rs  = null;   
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/playerInfo.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
	        char chr=39;
	       rs  = stmt.executeQuery("SELECT *FROM playerBaseInfo where 'name'="+name+" ");  
	        while (rs .next()){  
	        	return new PlayerInfoPO(rs.getString("name").replace('��', chr),rs.getString("number"),
		    			  rs.getString("position"),rs.getString("height"),
		    			  rs.getDouble("weight"),rs.getString("birth"),
		    			  rs.getInt("age"),rs.getInt("exp"),rs.getString("school"));
	        }  
	        if(rs !=null){  
	           rs.close(); 
	           rs = null;  
	        }  

	       conn.commit();      
	        } catch(ClassNotFoundException cnfe)  
	        {  
	            System.out.println("Can´t find class for driver: " + cnfe.getMessage());  
	     
	        } catch (SQLException e){  
	            System.out.println("SQLException :" + e.getMessage());  
	        
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
		return null;
	}
	
	
}
