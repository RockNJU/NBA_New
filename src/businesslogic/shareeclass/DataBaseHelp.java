package businesslogic.shareeclass;

import java.sql.*;
import java.util.ArrayList;

import businesslogic.bl.MatchController;
import VO.A_player_match_data;
import VO.MatchVO;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class DataBaseHelp {
	/**
	 *
	 * */
	
	//private static final String offensiveRoundEff = null;
	
	
	
	public void updataSeasonData(MatchVO vo){
		/*
		 * 用于更新赛季中的球员和球队的
		 * 比赛信息
		 * */
		updateTeamSeasonData(vo.getHostTeam());
		updateTeamSeasonData(vo.getGuestTeam());//更新球队的比赛信�1
		
		ArrayList<SingleMatchPersonalDataVO> g_smpd=vo.getGuestTeam().getIndividualData();
		ArrayList<SingleMatchPersonalDataVO> h_smpd=vo.getHostTeam().getIndividualData();
		 	  
		
		  double assistEfficiency=0;       
		  double reboundEfficiency=0;         
		  double offensiveReboundEff=0;      
		  double defenseReboundEff=0;     	 
		  double stealEfficiency=0;			     
		  double usingPercentage=0;        
		  double blockEfficiency=0;		
		  
		  SingleMatchPersonalDataVO svo;
		  double time;
		  
		  double Two_reboundNum=vo.getHostTeam().getReboundNum()+ vo.getGuestTeam().getReboundNum();//�1场比赛中两支球队的篮板�1�和
		  
		  for(int i=0;i<h_smpd.size();i++){
			  /*处理主队球员数据*/
			  svo=h_smpd.get(i);
			  
			  if(svo.getTime()!=null){
			 String [] timeStr=svo.getTime().split(":");
			 try{
			 time=Double.parseDouble(timeStr[0])+((double)Double.parseDouble(timeStr[1])/60);
			 }catch(Exception e){
				 time=0;
			 }
			  }else{
				  time=0;
			  }
			  
			  
			  if(time!=0){
				  /*球员助攻数�1(球员上场时间÷(球队�1有球员上场时间�15)×球队总进
							球数-球员进球�1)*/
			  if((time/48*vo.getHostTeam().getShootNum()-svo.getShootNum())!=0){
				  
				   assistEfficiency=(double)svo.getAssistNum()/((time/48*
						   vo.getHostTeam().getShootNum()-svo.getShootNum()));   
			  }
			      
			  /*篮板率：球员篮板数�1(球队�1有球员上场时间�15)÷球员上场时间÷(球队总篮
					�1+对手总篮�1)   前提是时间不能为0*/
			   reboundEfficiency=(double)svo.getReboundNum()*48/time/Two_reboundNum; 
			   
			   offensiveReboundEff=(double)svo.getO_ReboundNum()*48/time/Two_reboundNum;;  
					   
			   defenseReboundEff=(double)svo.getD_ReboundNum()*48/time/Two_reboundNum;;   
			   
					   /* 球员抢断数�1(球队�1有球员上场时间�15)÷球员上场时间÷对手进攻�1
							�1)*/
					   /*此处留一个疑问，对手进攻次数是否是对手的进攻回合*/
			   stealEfficiency=(double)svo.getStealNum()*48/time/vo.getGuestTeam().getOffenseRound();			 
			   /* (球员出手次数+0.44×球员罚球次数+球员失误次数)×(球队�1有球�1
				上场时间÷5)÷球员上场时间÷(球队�1有�1�球员出手次�1+0.44×球队�1有球员罚�1
				次数+球队�1有球员失误次�1) */
			      
			   usingPercentage=(svo.getShootNum()+0.44*svo.getFreeThrowNum()+
					   svo.getTurnoverNum())*48/time/(vo.getHostTeam().getShootNum()
							   +0.44*vo.getHostTeam().getFreeThrowNum()+
							   vo.getHostTeam().getTurnoverNum());   
			   
			  /**球员盖帽数�1(球队�1有球员上场时间�15)÷球员上场时间÷对手两分�1
						出手次数*/	 
			   blockEfficiency=(double)svo.getBlockNum()*48/time/(
					   vo.getGuestTeam().getShootNum()-vo.getGuestTeam().getT_shootNum());
			  }
			/*String season,String date,
			 String team,String name,
			 String p,double time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,
			 int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,
			 int steal,int blockNum,int turnoverNum,
			 int foulNum,int points, double assistEfficiency,
			 double reboundEfficiency,double offensiveReboundEff,
			 double defenseReboundEff,double stealEfficiency,
			 double usingPercentage,double blockEfficiency*/
			  A_player_match_data pdata=new A_player_match_data(vo.getSeason(),vo.getDate(),
					  vo.getHostTeam().getTeamName(),svo.getPlayerName(),svo.getPlayerPosition(),
					  time,svo.getFieldGoal(),svo.getShootNum(),svo.getT_fieldGoal(),
					  svo.getT_shootNum(),svo.getFreeThrowGoalNum(),svo.getFreeThrowNum(),
					  svo.getO_ReboundNum(),svo.getD_ReboundNum(),svo.getReboundNum(),
					  svo.getAssistNum(),svo.getStealNum(),svo.getBlockNum(),svo.getTurnoverNum(),
					  svo.getFoulNum(),svo.getPoints(), assistEfficiency,
						   reboundEfficiency, offensiveReboundEff,
						   defenseReboundEff, stealEfficiency,
						   usingPercentage,  blockEfficiency);
			  
			  		updatePlayerData(pdata);
			  		addPlayer_A_matchData(pdata);
		  }
		
		  
		 
		  for(int i=0;i<g_smpd.size();i++){
			  /*处理客队球员数据*/
			  svo=g_smpd.get(i);
			  
			  if(svo.getTime()!=null){
			 String [] timeStr=svo.getTime().split(":");
			 time=Double.parseDouble(timeStr[0])+(double)(Double.parseDouble(timeStr[1])/60);
			  }else{
				  time=0;
			  }
			  
			  
			  if(time!=0){
				  /*球员助攻数�1(球员上场时间÷(球队�1有球员上场时间�15)×球队总进
							球数-球员进球�1)*/
			  if((time/48*vo.getGuestTeam().getShootNum()-svo.getShootNum())!=0){
				   assistEfficiency=(double)svo.getAssistNum()/((time/48*
						   vo.getGuestTeam().getShootNum()-svo.getShootNum()));   
			  }
				   
				   reboundEfficiency=(double)svo.getReboundNum()*48/time/Two_reboundNum; 
				   
				   offensiveReboundEff=(double)svo.getO_ReboundNum()*48/time/Two_reboundNum;;  
						   
				   defenseReboundEff=(double)svo.getD_ReboundNum()*48/time/Two_reboundNum;;   
				   
						   /* 球员抢断数�1(球队�1有球员上场时间�15)÷球员上场时间÷对手进攻�1
								�1)*/
						   /*此处留一个疑问，对手进攻次数是否是对手的进攻回合*/
				   stealEfficiency=(double)svo.getStealNum()*48/time/vo.getHostTeam().getOffenseRound();			 
				   /* (球员出手次数+0.44×球员罚球次数+球员失误次数)×(球队�1有球�1
					上场时间÷5)÷球员上场时间÷(球队�1有�1�球员出手次�1+0.44×球队�1有球员罚�1
					次数+球队�1有球员失误次�1) */
				      
				   usingPercentage=(svo.getShootNum()+0.44*svo.getFreeThrowNum()+
						   svo.getTurnoverNum())*48/time/(vo.getGuestTeam().getShootNum()
								   +0.44*vo.getGuestTeam().getFreeThrowNum()+
								   vo.getGuestTeam().getTurnoverNum());   
				   
				  /**球员盖帽数�1(球队�1有球员上场时间�15)÷球员上场时间÷对手两分�1
							出手次数*/	 
				   blockEfficiency=(double)svo.getBlockNum()*48/time/(
						   vo.getGuestTeam().getShootNum()-vo.getGuestTeam().getT_shootNum());
				  
			  }
			      
			  /*篮板率：球员篮板数�1(球队�1有球员上场时间�15)÷球员上场时间÷(球队总篮
					�1+对手总篮�1)   前提是时间不能为0*/
			   
			/*String season,String date,
			 String team,String name,
			 String p,double time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,
			 int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,
			 int steal,int blockNum,int turnoverNum,
			 int foulNum,int points, double assistEfficiency,
			 double reboundEfficiency,double offensiveReboundEff,
			 double defenseReboundEff,double stealEfficiency,
			 double usingPercentage,double blockEfficiency*/
			  A_player_match_data pdata=new A_player_match_data(vo.getSeason(),vo.getDate(),
					  vo.getHostTeam().getTeamName(),svo.getPlayerName(),svo.getPlayerPosition(),
					  time,svo.getFieldGoal(),svo.getShootNum(),svo.getT_fieldGoal(),
					  svo.getT_shootNum(),svo.getFreeThrowGoalNum(),svo.getFreeThrowNum(),
					  svo.getO_ReboundNum(),svo.getD_ReboundNum(),svo.getReboundNum(),
					  svo.getAssistNum(),svo.getStealNum(),svo.getBlockNum(),svo.getTurnoverNum(),
					  svo.getFoulNum(),svo.getPoints(), assistEfficiency,
						   reboundEfficiency, offensiveReboundEff,
						   defenseReboundEff, stealEfficiency,
						   usingPercentage,  blockEfficiency);
			  
			  		updatePlayerData(pdata);
			  		addPlayer_A_matchData(pdata);
		  }
		
	}
	

	public void updatePlayerData(A_player_match_data vo){
		/*
		 * 用于更新球员的赛季信�1
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
	       		+ " season='"+vo.getSeason()+"' and name="
	            + "'"+vo.getPlayerName()+"' ");  
	       boolean hasExist=false;
	       
	       /*String season,String name,String teamName,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
		 int O_R_N,int D_R_N,int reboundNum,int assistNum,int stealNum,int blockNum,int turnoverNum,
		 int foulNum,int points, double assistEfficiency,
		 double reboundEfficiency,double offensiveReboundEff,
		 double defenseReboundEff,double stealEfficiency,
		 double usingPercentage,double blockEfficiency,int doubleNum,int threeNum*/

	       PlayerSeasonDataVO PlayerData=new PlayerSeasonDataVO(null, null, null, null, 0, 0, 0, 0, 0, 0, 0,
	    		   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	        while (rs .next()){  
	              PlayerData=new PlayerSeasonDataVO(rs.getString("season"),
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
		    			  rs.getDouble("blockEfficiency"),rs.getInt("doubleNum"),rs.getInt("threeNum"));
 
	               hasExist=true;
	        }  
	        
	        if(hasExist){
	        	/*如果数据库中已有记录，先删除掉，再添�1*/
	         stmt.executeUpdate("DElETE FROM playerSeasonData where"
	 	       		+ " season='"+vo.getSeason()+"' and teamName="
		            + " '"+vo.getPlayerName()+"' ");
	         }
	         
	        String sqrStr="";
	        int stnum=0;
	        if(vo.getPlayerPosition()!=null&&vo.getPlayerPosition().length()!=0){
	        	stnum=1;
	        }
	        
	        int doubleNum=0;
			int threeNum=0;
			int num=0;
			if(vo.getPoints()>=10){
				num++;
			}
			if(vo.getBlockNum()>=10){
				num++;
			}
			if(vo.getAssistNum()>=10){
				num++;
			}
			if(vo.getReboundNum()>=10){
				num++;
			}
			
			if(num==3){
				threeNum=1;
			}else if(num==2){
				doubleNum=1;
			}else{
				threeNum=doubleNum=0;
			}
			 
	        
	        double time=vo.getTime()+PlayerData.getTime();
	        
	        int matchNum=PlayerData.getMatchNum()+1; 											// 赛季已比赛场�1		
	        int startingNum=PlayerData.getStartingNum()+stnum;
	    	int fieldGoal=PlayerData.getFieldGoal()+vo.getFieldGoal(); 						// 进球�1
	    	int shootNum=PlayerData.getShootNum()+vo.getShootNum(); 							// 投篮总数
	    	int T_fieldGoal=PlayerData.getT_fieldGoal()+vo.getT_fieldGoal(); 					// 三分命中�1
	    	int T_shootNum=PlayerData.getT_shootNum()+vo.getT_shootNum(); 					// 三分出手�1
	    	int freeThrowGoalNum=PlayerData.getFreeThrowGoalNum()+vo.getFreeThrowGoalNum(); 	// 罚篮命中�1
	    	int freeThrowNum=PlayerData.getFreeThrowNum()+vo.getFreeThrowNum(); 				// 罚球出手�1
	    	int O_ReboundNum=PlayerData.getO_ReboundNum()+vo.getO_ReboundNum(); 				// 进攻篮板�1
	    	int D_ReboundNum=PlayerData.getD_ReboundNum()+vo.getD_ReboundNum(); 				// 防守篮板�1
	    	int assistNum=PlayerData.getAssistNum()+vo.getAssistNum();						// 助攻�1
	    	int stealNum=PlayerData.getStealNum()+vo.getStealNum(); 							// 抢断�1
	    	int reboundNum=PlayerData.getReboundNum()+vo.getReboundNum(); 					// 篮板总数
	    	int blockNum=PlayerData.getBlockNum()+vo.getBlockNum(); 							// 盖帽�1
	    	int turnoverNum=PlayerData.getTurnoverNum()+vo.getTurnoverNum(); 					// 失误�1
	    	int foulNum=PlayerData.getFoulNum()+vo.getFoulNum(); 								// 犯规�1
	    	int points=PlayerData.getPointNum()+vo.getPoints(); 												// 得分
	    	
	    	double reboundEfficiency = PlayerData.getReboundEfficiency()+vo.getReboundEfficiency(); 			// 篮板效率
	    	double stealEfficiency = PlayerData.getStealEfficiency()+vo.getStealEfficiency(); 				// 抢断效率
	    	double assistEfficiency = PlayerData.getAssistEfficiency()+vo.getAssistEfficiency(); 				// 助攻效率
	    	double offensesiveReboundEff=PlayerData.getOffensiveReboundEff()+vo.getOffensiveReboundEff();
	    	double defenseReboundEff=PlayerData.getDefenseReboundEff()+vo.getDefenseReboundEff();
	    	double usingPercentage=PlayerData.getUsingPercentage()+vo.getUsingPercentage();
	    	double blockEfficiency=PlayerData.getBlockEfficiency()+vo.getBlockEfficiency();
	    	doubleNum=doubleNum+PlayerData.getDoubleNum();
	    	threeNum=threeNum+PlayerData.getThreeNum();
	    	/*(season varchar(10) , name varchar(20),"
	        		+ "teamName varchar(10), position varchar(3),matchNum int ,startingNum int,"
	        		+ " time double(5,3),fieldGoal int ,shootNum int,"
	        		+ "T_fieldGoal int,T_shootNum int,"
	        		+ "freeThrowGoalNum int, freeThrowNum int ,O_ReboundNum int,"
	        		+ "D_ReboundNum int,reboundNum int,assistNum int,stealNum int,"
	        		+ "blockNum int,turnoverNum int,foulNum int,points int,"
	        		
	        		+ "assistEfficiency double(5,3),reboundEfficiency double(5,3),"
	        		+ "offensesiveReboundEff double(5,3),defenseReboundEff double(5,3),"
	        		+ "stealEfficiency double(5,3),usingPercentage double(5,3),"
	        		+ "blockEfficiency double(5,3),doubleNum int,threeNum int)*/
	        
	        																							
	        
	        sqrStr="INSERT INTO playerSeasonData  VALUES ('"+vo.getSeason() +"',"
	        		+ "'"+vo.getPlayerName()+"', '"+vo.getTeamAbb()+"', "
	        		+ "'"+vo.getPlayerPosition()+"','"+matchNum+"','"+startingNum+"','"+time+"',"
	    	 		+ "'"+fieldGoal +"', '"+shootNum +"', "
	    	 		+ "'"+ T_fieldGoal +"', '"+ T_shootNum +"', "
	    	 		+ "'"+freeThrowGoalNum+"', '"+freeThrowNum+"','"+ O_ReboundNum+"', "
	    	 		+ "'"+ D_ReboundNum +"', '"+reboundNum +"','"+assistNum +"', "
	    	 		+ "'"+stealNum+"', "+ "'"+blockNum+"', '"+turnoverNum+"', "
	    	 		+ "'"+foulNum+"','"+points+"', "
	    	 		
	    	 		+ "'"+ assistEfficiency +"', '"+reboundEfficiency+"', "
	    	 		+ " '"+ offensesiveReboundEff +"', '"+ defenseReboundEff +"', "
	    	 		+ "'"+ stealEfficiency +"', '"+ usingPercentage+"', "
	    	 		+ "'"+ blockEfficiency +"', '"+ doubleNum+"','"+threeNum+"')";
	        
	     stmt.executeUpdate(sqrStr);
	    
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

	}
	
	
	public  void updateTeamSeasonData(TeamMatchVO vo){
		/*
		 * 用于更新球队的赛季信�1
		 * */
			Connection conn = null;  
	       Statement stmt = null;  
	        ResultSet rs  = null;  
	       System.out.println(new java.util.Date());  
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
	   
	       rs  = stmt.executeQuery("SELECT*FROM teamSeasonData where"
	       		+ " season='"+vo.getSeason()+"' and teamName="
	            + " '"+vo.getTeamName()+"' ");  
	       boolean hasExist=false;
	       TeamSeasonDataVO teamData=new TeamSeasonDataVO(vo.getSeason(), vo.getTeamName(), 0, 0, 0,
	    		   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	        while (rs .next()){  
	              teamData=new TeamSeasonDataVO(rs.getString("season"),rs.getString("teamName"),
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
		    			  rs.getDouble("assistEfficiency"));

	              hasExist=true;
	        }  
	        
	       
	        if(hasExist){
	        	/*如果数据库中已有记录，先删除掉，再添�1*/
	         stmt.executeUpdate("DElETE FROM teamSeasonData where"
	 	       		+ " season='"+vo.getSeason()+"' and teamName="
		            + " '"+vo.getTeamName()+"' ");
	         }
	         
	        String sqrStr="";
	        
	        int matchNum=teamData.getMatchNum()+1; 											// 赛季已比赛场�1
	    	int winNum=teamData.getWinNum()+vo.getWinNum();																		//胜利场数
	    	int fieldGoal=teamData.getFieldGoal()+vo.getFieldGoal(); 						// 进球�1
	    	int shootNum=teamData.getShootNum()+vo.getShootNum(); 							// 投篮总数
	    	int T_fieldGoal=teamData.getT_fieldGoal()+vo.getT_fieldGoal(); 					// 三分命中�1
	    	int T_shootNum=teamData.getT_shootNum()+vo.getT_shootNum(); 					// 三分出手�1
	    	int freeThrowGoalNum=teamData.getFreeThrowGoalNum()+vo.getFreeThrowGoalNum(); 	// 罚篮命中�1
	    	int freeThrowNum=teamData.getFreeThrowNum()+vo.getFreeThrowNum(); 				// 罚球出手�1
	    	int O_ReboundNum=teamData.getO_ReboundNum()+vo.getO_ReboundNum(); 				// 进攻篮板�1
	    	int D_ReboundNum=teamData.getD_ReboundNum()+vo.getD_ReboundNum(); 				// 防守篮板�1
	    	int assistNum=teamData.getAssistNum()+vo.getAssistNum();						// 助攻�1
	    	int stealNum=teamData.getStealNum()+vo.getStealNum(); 							// 抢断�1
	    	int reboundNum=teamData.getReboundNum()+vo.getReboundNum(); 					// 篮板总数
	    	int blockNum=teamData.getBlockNum()+vo.getBlockNum(); 							// 盖帽�1
	    	int turnoverNum=teamData.getTurnoverNum()+vo.getTurnoverNum(); 					// 失误�1
	    	int foulNum=teamData.getFoulNum()+vo.getFoulNum(); 								// 犯规�1
	    	int points=teamData.getPointNum(); 												// 得分
	    	
	    	double shootPercentage=teamData.getShootPercentage()+vo.getShootPercentage(); 					// 投篮命中�1
	    	double threePointPercentage=teamData.getThreePointPercentage()+vo.getThreePointPercentage(); 	// 三分命中�1
	    	double freeThrowPercentage=teamData.getFreeThrowPercentage()+vo.getFreeThrowPercentage(); 		// 罚篮命中�1
	    	double offenseRound=teamData.getOffenseRound()+vo.getOffenseRound(); 							// 进攻回合
	    	double offenseEfficiency = teamData.getOffenseEfficiency()+vo.getOffenseEfficiency(); 			// 进攻效率
	    	double defenseEfficiency = teamData.getDefenseEfficiency()+vo.getDefenseEfficiency(); 			// 防守效率
	    	double reboundEfficiency = teamData.getReboundEfficiency()+vo.getReboundEfficiency(); 			// 篮板效率
	    	double stealEfficiency = teamData.getStealEfficiency()+vo.getStealEfficiency(); 				// 抢断效率
	    	double assistEfficiency = teamData.getAssistEfficiency()+vo.getAssistEfficiency(); 				// 助攻效率

	        
	        
	        
	        sqrStr="INSERT INTO teamseasondata  VALUES ('"+vo.getSeason() +"',"
	        		+ "'"+vo.getTeamName()+"', '"+matchNum+"', '"+winNum+"',"
 	    	 		+ "'"+fieldGoal +"', '"+shootNum +"', "
 	    	 		+ "'"+ T_fieldGoal +"', '"+ T_shootNum +"', "
 	    	 		+ "'"+freeThrowGoalNum+"', '"+freeThrowNum+"','"+ O_ReboundNum+"', "
 	    	 		+ "'"+ D_ReboundNum +"', '"+assistNum +"', "
 	    	 		+ "'"+stealNum+"', '"+reboundNum+"', "
 	    	 		+ "'"+blockNum+"', '"+turnoverNum+"', "
 	    	 		+ "'"+foulNum+"','"+points+"', "
 	    	 		
 	    	 		+ "'"+ shootPercentage +"', '"+threePointPercentage+"', "
 	    	 		+ "'"+ freeThrowPercentage +"',"
 	    	 		+ " '"+ offenseRound +"', '"+ offenseEfficiency +"', "
 	    	 		+ "'"+ defenseEfficiency +"', '"+ reboundEfficiency+"', "
 	    	 		+ "'"+ stealEfficiency +"', '"+ assistEfficiency+"')";
	        
	     stmt.executeUpdate(sqrStr);
 
	        if(rs !=null){  
	           rs.close(); rs = null;  
	        }  

	       conn.commit();  
 
	        } catch(ClassNotFoundException cnfe)  
	        {  
	            
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
		
	}
	
	public  void addPlayer_A_matchData(A_player_match_data vo){
		/**
		 *  
		 * 
		 * */
		 Connection conn = null;  
	       Statement stmt = null;  
	        ResultSet rset = null;  
	       System.out.println(new java.util.Date());  
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement(); 
	   
	       rset = stmt.executeQuery("SELECT*FROM player_match_record where"
	       		+ " season='"+vo.getSeason()+"' and name='"+vo.getPlayerName()+"' and date='"+vo.getDate()+"' ");  
	        while (rset.next()){  
	        	return ;
	        }  
	        /*playerSeasonData(season varchar(10) , date varchar(20),"
        		+ "name varchar(32), position varchar(3),"
        		+ " time double(5,3),fieldGoal int ,shootNum int,"
        		+ "T_fieldGoal int,T_shootNum int,"
        		+ "freeThrowGoalNum int, freeThrowNum int ,O_ReboundNum int,"
        		+ "D_ReboundNum int,assistNum int,staalNum int,"
        		+ "blockNum int,turnoverNum int,foulNum int,pointNum int,"
        		
        		+ "assistEfficiency double(5,3),reboundEfficiency double(5,3),"
        		+ "offenseEfficiency double(5,3),defenseEfficiency double(5,3),"
        		+ "stealEfficiency double(5,3),usingPercentage double(5,3),"
        		+ "blockEfficiency double(5,3))"*/
	        
	        String sqStr="INSERT INTO player_match_record VALUES('"+vo.getSeason()+"','"+vo.getDate()+"'"
	        		+ ",'"+ vo.getTeamAbb()+"','"+vo.getPlayerName()+"','"+vo.getPlayerPosition()+"',"
	        		+ "'"+vo.getTime()+"','"+vo.getFieldGoal()+"','"+vo.getShootNum()+"',"
	        		+ "'"+vo.getT_fieldGoal()+"','"+vo.getT_shootNum()+"',"
	        		+ "'"+vo.getFreeThrowGoalNum()+"','"+vo.getFreeThrowNum()+"',"
	        		+ "'"+vo.getO_ReboundNum()+"','"+vo.getD_ReboundNum()+"',"
	        		+ "'"+vo.getAssistNum()+"','"+vo.getStealNum()+"',"
	        		+ "'"+vo.getBlockNum()+"','"+vo.getTurnoverNum()+"',"
	        		+ "'"+vo.getFoulNum()+"','"+vo.getPoints()+"',"
	        		+ "'"+vo.getAssistEfficiency()+"','"+vo.getReboundEfficiency()+"',"
	        		+ "'"+vo.getOffensiveReboundEff()+"','"+vo.getDefenseReboundEff()+"',"
	        		+ "'"+vo.getStealEfficiency()+"','"+vo.getUsingPercentage()+"',"
	        		+ "'"+vo.getBlockEfficiency()+"')";
	        stmt.executeUpdate(sqStr);
	       
	        if(rset!=null){  
	           rset.close(); rset = null;  
	        }  
 
	       conn.commit();  
	       System.out.println(new java.util.Date());  
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
	               if (rset!=null) rset.close();  
	                stmt.close();  
	               conn.close();  
	           } catch (SQLException e){ 
	        	  System.out.println("SQLException in finally :" + e.getMessage());  
	            System.exit(-1);
	            	} 
	            }
	}
	

		
	public void create_player_match_record_form(){
		 
			/**
			 * 创建存储球员赛季信息的数据库表格
			 * */
			 	Connection conn = null;  
			 	Statement stmt = null;  
		        ResultSet rset = null;  
		       System.out.println(new java.util.Date());  
		        try {  
		        	
		        Class.forName("org.sqlite.JDBC");  
		        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
		        conn.setAutoCommit(false);  
		        stmt = conn.createStatement();  
		    
		           stmt.executeUpdate("drop table if exists player_match_record");  
		           stmt.executeUpdate("create table player_match_record(season varchar(10) , date varchar(20),"
		           		+ "teamAbb varchar(10), name varchar(32), position varchar(3),"
		           		+ " time double(5,3),fieldGoal int ,shootNum int,"
		           		+ "T_fieldGoal int,T_shootNum int,"
		           		+ "freeThrowGoalNum int, freeThrowNum int ,O_ReboundNum int,"
		           		+ "D_ReboundNum int,assistNum int,stealNum int,"
		           		+ "blockNum int,turnoverNum int,foulNum int,points int,"
		           		
		           		+ "assistEfficiency double(5,3),reboundEfficiency double(5,3),"
		           		+ "offenseEfficiency double(5,3),defenseEfficiency double(5,3),"
		           		+ "stealEfficiency double(5,3),usingPercentage double(5,3),"
		           		+ "blockEfficiency double(5,3))"); 
		           /*设置数据库的索引*/
		          stmt.executeUpdate("CREATE INDEX player_match_record_idx1 on player_match_record(season)");  
		           stmt.executeUpdate("CREATE INDEX player_match_record_idx2 on player_match_record(name)");
		           stmt.executeUpdate("CREATE INDEX player_match_record_idx3 on player_match_record(date)");
		           
		           System.out.println("����player_match_record�ɹ���");
		         
		        conn.commit();  
			
		       } catch(ClassNotFoundException cnfe)  {  
	         System.out.println("Can't find class for driver: " + cnfe.getMessage());  
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
		}// end cerate
		
	 
	
	
	
	
	
	public void create_Team_SeasonData_Form(){
		/**
		 * 创建存储球员赛季信息的数据库表格
		 * */
		 	Connection conn = null;  
		 	Statement stmt = null;  
	        ResultSet rset = null;  
	       System.out.println(new java.util.Date());  
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement();  
	        stmt.executeUpdate("drop table if exists teamSeasonData");  
	        stmt.executeUpdate("create table teamSeasonData(season varchar(10) , "
	        		+ "teamName varchar(32), matchNum int,"
	        		+ " winNum int,fieldGoal int ,shootNum int,T_fieldGoal int,T_shootNum int,"
	        		+ "freeThrowGoalNum int, freeThrowNum int ,O_ReboundNum int,"
	        		+ "D_ReboundNum int,assistNum int,stealNum int,reboundNum int,"
	        		+ "blockNum int,turnoverNum int,foulNum int,points int,"
	        		+ "shootPercentage double(5,3),threePointPercentage double(5,3),"
	        		+ "freeThrowPercentage double(5,3),offenseRound double(5,3),"
	        		+ "offenseEfficiency double(5,3),defenseEfficiency double(5,3),"
	        		+ "reboundEfficiency double(5,3),stealEfficiency double(5,3),"
	        		+ "assistEfficiency double(5,3))");  
	        stmt.executeUpdate("CREATE INDEX teamSeasonData_idx1 on teamSeasonData(season)");  
	        stmt.executeUpdate("CREATE INDEX teamSeasonData_idx2 on teamSeasonData(teamName)");
	        System.out.println("����teamSeasonData�ɹ�!");   
	         
	        //System.out.println("建表hehe成功!");  
	        conn.commit();  
		
	       } catch(ClassNotFoundException cnfe)  {  
         System.out.println("Can't find class for driver: " + cnfe.getMessage());  
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
	}
	
	
	
	/***/
	public void create_Player_SeasonData_Form(){
		/**
		 * 创建存储球员赛季信息的数据库表格
		 * */
		 	Connection conn = null;  
		 	Statement stmt = null;  
	        ResultSet rset = null;  
	       System.out.println(new java.util.Date());  
	        try {  
	        	
	        Class.forName("org.sqlite.JDBC");  
	        conn = DriverManager.getConnection( "jdbc:sqlite:database/NBA.db");  
	        conn.setAutoCommit(false);  
	        stmt = conn.createStatement();  
	        stmt.executeUpdate("drop table if exists playerSeasonData");  
	        stmt.executeUpdate("create table playerSeasonData(season varchar(10) , name varchar(20),"
	        		+ "teamName varchar(10), position varchar(3),matchNum int ,startingNum int,"
	        		+ " time double(5,3),fieldGoal int ,shootNum int,"
	        		+ "T_fieldGoal int,T_shootNum int,"
	        		+ "freeThrowGoalNum int, freeThrowNum int ,O_ReboundNum int,"
	        		+ "D_ReboundNum int,reboundNum int,assistNum int,stealNum int,"
	        		+ "blockNum int,turnoverNum int,foulNum int,points int,"
	        		
	        		+ "assistEfficiency double(5,3),reboundEfficiency double(5,3),"
	        		+ "offensesiveReboundEff double(5,3),defenseReboundEff double(5,3),"
	        		+ "stealEfficiency double(5,3),usingPercentage double(5,3),"
	        		+ "blockEfficiency double(5,3),doubleNum int,threeNum int)"); 
	        
	        System.out.println("����playerSeasonData�ɹ���");  
	        //System.out.println("建表hehe成功!");  
	       
	         
	        conn.commit();  
		
	       } catch(ClassNotFoundException cnfe)  {  
         System.out.println("Can't find class for driver: " + cnfe.getMessage());  
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
	}// end cerate
	/***/
	
	public static void main(String args[]){
		System.out.println("starts in class DataBaseHelp�� main().");
		DataBaseHelp db=new DataBaseHelp();
	   ///db.createDatabaseForm();
	 
		A_player_match_data apd=new A_player_match_data("13-14", "HUO", "Jmase", "89", "35",
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 056, 89, 56, 0.33);
		TeamMatchVO vo=new TeamMatchVO("13-14", "HUO", 12, 98, 78, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,10, 10, 10, 10,
				10, 10, 10, 10, 10, 10, 10, 10, 0.98, 0.86, 0.9, 0.6, null);
		  //db.addPlayer_A_matchData(apd);
		   
		   db.create_Player_SeasonData_Form();
		  // db.updatePlayerData(apd);
		 db.create_Team_SeasonData_Form();
		//db.updateTeamSeasonData(vo);
		 db.create_player_match_record_form();
		 
		 MatchController m=new MatchController(); 
		 ArrayList<MatchVO> list=m.getAllMatchVO();
		 for(int i=0;i<list.size();i++){
			 db.updataSeasonData(list.get(i));
		 }
		 
		System.out.println("成功更新赛季球队数据�1");
		
	}
}
