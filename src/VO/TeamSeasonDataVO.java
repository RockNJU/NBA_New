package VO;
import java.io.Serializable;

public class TeamSeasonDataVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 
	 */
	String season;					 //赛季
	String teamName; 				 //球队缩写
	int matchNum; 				     //已比赛场数
	int winNum;						 //胜利场数
	int fieldGoal; 					 //投篮命中数
	int shootNum; 				     //投篮出手数
	int T_fieldGoal; 				 //三分命中数
	int T_shootNum; 				 //三分出手数
	int freeThrowGoalNum; 			 //罚球命中数
	int freeThrowNum; 				 //罚球总数
	int O_ReboundNum; 				 //进攻篮板数
	int D_ReboundNum; 				 //防守篮板数
	int assistNum;					 //助攻数
	int stealNum; 					 //抢断数
	int reboundNum; 				 //篮板数
	int blockNum; 					 //盖帽数
	int turnoverNum; 			     //失误数
	int foulNum; 					 //犯规数
	int points; 					 //得分
	
	double shootPercentage; 		 
	double threePointPercentage; 	 
	double freeThrowPercentage; 	
	
	double offenseRound; 	
	
	private double defenseRound;   			//防守回合总数
	double offenseEfficiency = 0; 	 
	double defenseEfficiency = 0; 		 
	double stealEfficiency = 0; 	
	double assistEfficiency = 0; 	 
	private double O_ReboundEfficiency =0; 
	private double D_ReboundEfficiency =0; 

	public TeamSeasonDataVO(String season,String teamName,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,double shootPercentage,
	double threePointPercentage,double freeThrowPercentage,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency){
		this.season=season;
		this.teamName = teamName; 
		this.matchNum = matchNum ; 
		this.winNum = winNum;
		this.fieldGoal = fieldGoal ;  
		this.shootNum = shootNum ;  
		this.T_fieldGoal = T_fieldGoal ;  
		this.T_shootNum = T_shootNum ; 
		this.freeThrowGoalNum =  freeThrowGoalNum;  
		this.freeThrowNum = freeThrowNum;  
		this.O_ReboundNum = O_ReboundNum ;  
		this.D_ReboundNum =  D_ReboundNum;  
		this.assistNum =  assistNum;  
		this.stealNum = stealNum ;  
		this.reboundNum = reboundNum ; 
		this.blockNum = blockNum ;  
		this.turnoverNum = turnoverNum ;  
		this.foulNum = foulNum ;  
		this.points = points ;  
		
		
		this.shootPercentage =  shootPercentage;  
		this.threePointPercentage = threePointPercentage ; 
		this.freeThrowPercentage = freeThrowPercentage ;  
		 
		this.offenseRound = offenseRound ;  
		
		this.offenseEfficiency = offenseEfficiency;  
		this.defenseEfficiency = defenseEfficiency;  
		
		this.stealEfficiency = stealEfficiency;  
		this.assistEfficiency = assistEfficiency;  
		
		this.O_ReboundEfficiency = O_ReboundEfficiency; 
		this.D_ReboundEfficiency = D_ReboundEfficiency;
	}
	

	 public void add_A_Match_Data(TeamMatchVO vo){
		
		 matchNum++;
		 defenseRound=defenseRound+vo.getDefenseRound();
		 fieldGoal=fieldGoal+vo.getFieldGoal();
		 shootNum=vo.getShootNum()+shootNum;
		 T_fieldGoal=T_fieldGoal+vo.getT_fieldGoal();
		 T_shootNum=T_shootNum+vo.getT_shootNum();
		 freeThrowGoalNum=freeThrowGoalNum+vo.getFreeThrowGoalNum();
		 freeThrowNum=vo.getFreeThrowNum()+freeThrowNum;
		 O_ReboundNum=O_ReboundNum+vo.getO_ReboundNum();
		 D_ReboundNum=D_ReboundNum+vo.getD_ReboundNum();
		 
		 reboundNum=reboundNum+vo.getReboundNum();
		 assistNum=assistNum+vo.getAssistNum();
		 stealNum=stealNum+vo.getStealNum();
		 blockNum=blockNum+vo.getBlockNum();
		 turnoverNum=turnoverNum+vo.getTurnoverNum();
		 
		 foulNum=foulNum+vo.getFoulNum();
		 points=points+vo.getPointNum();
		 
		 
		 
		  shootPercentage=(double)fieldGoal/shootNum; 		 
		  threePointPercentage=(double)T_fieldGoal/T_shootNum; 	 
		  freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum; 	
			  	
			  
		 offenseEfficiency = offenseEfficiency+vo.getOffenseEfficiency(); 	 
		 defenseEfficiency = defenseEfficiency+vo.getDefenseEfficiency(); 	 
			
 	 
		 stealEfficiency = stealEfficiency+vo.getStealEfficiency(); 	
		 assistEfficiency = assistEfficiency+vo.getAssistEfficiency(); 	 
			 
		 O_ReboundEfficiency = O_ReboundEfficiency+vo.getO_ReboundEfficiency(); 
		 D_ReboundEfficiency = D_ReboundEfficiency+vo.getD_ReboundEfficiency();
		 
	 }
	
	public String getSreason(){
		return season;
	}
	
	public String getTeamName() {
		return teamName;
	}

	 
 
	
	public int getMatchNum(){
		return matchNum;
	}
	
	public int getWinNum(){
		return winNum;
	}
	
	public void setWinNum(int i){
		this.winNum = i;
	}



	public double getFieldGoal() {
		if(matchNum!=0)
		return fieldGoal;
		else
			return 0;
	}


	public double getShootNum() {
		if(matchNum!=0)
		return shootNum;
		else
			return 0;
	}


	public double getT_fieldGoal() {
		if(matchNum!=0)
		return T_fieldGoal;
		else 
			return 0;
	}


	public double getT_shootNum() {
		if(matchNum!=0)
		return T_shootNum;
		else
			return 0;
	}


	public double getFreeThrowGoalNum() {
		if(matchNum!=0)
		return freeThrowGoalNum;
		else 
			return 0;
	}


	public double getFreeThrowNum() {
		if(matchNum!=0)
		return freeThrowNum;
		else 
			return 0;
	}


	public double getO_ReboundNum() {
		if(matchNum!=0)
		return O_ReboundNum;
		else
			return 0;
	}


	public double getD_ReboundNum() {
		if(matchNum!=0)
		return (double)D_ReboundNum/matchNum;
		else
			return 0;
	}


	public double getBlockNum() {
		if(matchNum!=0)
		return (double)blockNum/matchNum;
		else
			return 0;
	}
	public double getOffenseRound() {
		return offenseRound;
	}

	public void setOffenseRound(double d) {
		this.offenseRound = d;
	}

 

	public void setFreeThrowPercentage(double d) {
		this.freeThrowPercentage = d;
	}

	 

	public void setThreePointPercentage(double d) {
		this.threePointPercentage = d;
	}

	 

	public void setShootPercentage(double d) {
		this.shootPercentage = d;
	}

	public double getAssistEfficiency() {
		 
		if(matchNum!=0)
			return assistEfficiency/matchNum;
		return 0;
	}

	public void setAssistEfficiency(double d) {
		this.assistEfficiency = d;
	}

	public double getStealEfficiency() {
	 
		if(matchNum!=0)
			return stealEfficiency/matchNum;
		else
			return 0;
	}

	public void setStealEfficiency(double d) {
		this.stealEfficiency = d;
	}

	public double getDefenseEfficiency() {
		if(matchNum!=0)
			return defenseEfficiency/matchNum;
		else
			return 0;
	}

	public void setDefenseEfficiency(double d) {
		this.defenseEfficiency = d;
	}

	public double getOffenseEfficiency() {
		/*进攻效率：每 100 个进攻回合，球队的得分*/
		if(matchNum!=0)
			return offenseEfficiency/matchNum;
		else
			return 0;
	}

	public void setOffenseEfficiency(double d) {
		this.offenseEfficiency = d;
	}

	public double getWinRate(){
		if(matchNum!=0)
		return (double)winNum/matchNum;
		else 
			return 0;
	}
	
	
	 
		public double getReboundNum() {
			if(matchNum!=0)
			 return (double)reboundNum/matchNum;
			else
				return 0;
		}
		public void addReboundNum(int num) {
			reboundNum=reboundNum+num;
		}
		public double getAssistNum() {
			if(matchNum!=0)
			  return (double)assistNum/matchNum;
			else
			  return 0;
		}
		public void addAssistNum(int num){
			matchNum=matchNum+num;
		}
		public double getTurnoverNum(){
			if(matchNum!=0)
				return (double)turnoverNum/matchNum;
			return 0;
		}
		 
		public double getStealNum(){
			if(matchNum!=0)
			return (double)stealNum/matchNum;
			else 
				return 0;
		}
		 
		public double getFreeThrowPercentage() {
			if(matchNum!=0)
				return freeThrowPercentage/matchNum;
			else
				return 0;
		}
		
		public double getFoulNum() {
			if(matchNum!=0)
				return (double)foulNum/matchNum;
			else
				return 0;
		}
		public void addFoulNum(int Num) {
			foulNum=foulNum+Num;
		}
		public double getPointNum() {
			return (double)points/matchNum;
		}
		 
		
		public double getThreePointPercentage(){
			if(T_shootNum==0)
				return 0;
			else
				return (double)T_fieldGoal/T_shootNum;
		}
		public double getShootPercentage() {
			if(shootNum==0)
				return 0;
			else{
				return (double)fieldGoal/shootNum ;
			}
		}
}
