package VO;

import java.io.Serializable;

public class PlayerSeasonDataVO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String season;						 
	String name;						 
	private String teamName;		 
	private String position;	 
	private int matchNum;		 
	private int startingNum;	 
	
	  private double time;		 
	 private int fieldGoal;				 
	 private int shootNum;			 
	 private int T_fieldGoal;		 
	 private int T_shootNum;			 
	 private int freeThrowGoalNum;		 
	 private int freeThrowNum;			 
	 private int O_ReboundNum;			 
	 private int D_ReboundNum;		 
	 private int reboundNum;		 
	 private int assistNum;				 
	 private int stealNum;			 
	 private int blockNum;			 
	 private int turnoverNum;	 
	 private int foulNum;			 
	 private int pointNum;		 
	 
	private double efficiency; 		 
	private double blockEfficiency;		 
	private double freeThrowPercentage;		 
	private double shootEfficiency;		 
	private double assistEfficiency;       
	private double reboundEfficiency;      
	private double offensiveReboundEff;    
	private double defenseReboundEff;	 
	private double stealEfficiency;			 
	private double turnoverPercentage;     
	private double usingPercentage;        
	private double realShootPercentage=0;	 
	private double GmSc;				 
	private int seasonDoubleNum;		    
	private int seasonThreeNum;  		  
	
	
	public PlayerSeasonDataVO(String season,String name,String teamName,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
		 int O_R_N,int D_R_N,int reboundNum,int assistNum,int stealNum,int blockNum,int turnoverNum,
		 int foulNum,int points, double assistEfficiency,
		 double reboundEfficiency,double offensiveReboundEff,
		 double defenseReboundEff,double stealEfficiency,
		 double usingPercentage,double blockEfficiency,int doubleNum,int threeNum){
				
				this.season=season;
				this.name=name;
				this.teamName=teamName;
				this.position=position;
				this.matchNum=matchNum;
				this.startingNum=startingNum;
				this.time=time;
				this.blockNum=blockNum;
				
				this.freeThrowGoalNum=freeThrowGoalNum;
				this.freeThrowNum=freeThrowNum;
				this.blockEfficiency=blockEfficiency;
				this.reboundNum=reboundNum;
				this.O_ReboundNum=O_R_N;
				 this.D_ReboundNum=D_R_N;
				this.assistNum=assistNum;
				this.turnoverNum=turnoverNum;
				this.stealNum=stealNum;
				this.foulNum=foulNum;
				this.pointNum=points;
				this.assistEfficiency=assistEfficiency;
				this.reboundEfficiency=reboundEfficiency;
				this.offensiveReboundEff=offensiveReboundEff;
				this.defenseReboundEff=defenseReboundEff;
				this.stealEfficiency=stealEfficiency;
				this.usingPercentage=usingPercentage;
				
				this.seasonDoubleNum=doubleNum;
				this.seasonThreeNum=threeNum;	
				
				
				 if(shootNum!=0){
					   
					   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
				 // 
				  }
				   
				   if((shootNum+0.44*freeThrowNum)!=0){
					   realShootPercentage=points/(2*(shootNum+0.44*freeThrowNum));
				   }
				 // assistEfficiency;        
					//  reboundEfficiency;       
					 // offensiveReboundEff;   
					  //stealEfficiency;			
				   turnoverPercentage=turnoverNum/((shootNum-T_shootNum)+0.44*
						   freeThrowNum+turnoverNum); 
				   
					  //usingPercentage;    
					  GmSc=points+fieldGoal*0.4-0.7*shootNum-
							  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*O_ReboundNum+0.3*D_ReboundNum
							  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
					
					  efficiency=pointNum+reboundNum+assistNum+stealNum+blockNum-
							  (shootNum-fieldGoal)  -(freeThrowNum-freeThrowGoalNum)-turnoverNum;
	}
	
	
	public String getName(){
		
		return name;
	}
	public String getTeamName() {
		return teamName;
	}
	
	public String getPosition(){
		return position;
	}
	public double getDefenseReboundEff(){
		return defenseReboundEff;
	}
	
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getMatchNum() {
		return matchNum;
	}
	public void addMatchNum(){
		 matchNum ++;
	}
	public int getStartingNum() {
		return startingNum;
	}
	public void addStartingNum(double startingNum) {
		 startingNum ++;
	}
 
	public double getTime(){
		return time;
	}
	public void addTime(double Num) {
		time=time+Num;
	}
	public double getBlockEfficiency(){
		return blockEfficiency;
	}
	public void setBlockEfficiency(double blockEfficiency) {
		this.blockEfficiency = blockEfficiency;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		 
	}
	public int getReboundNum() {
		return reboundNum;
	}
	public void addReboundNum(int num) {
		reboundNum=reboundNum+num;
	}
	public int getAssistNum() {
		return assistNum;
	}
	public void addAssistNum(int num){
		matchNum=matchNum+num;
	}
	public int getTurnoverNum(){
		return turnoverNum;
	}
	 
	public int getStealNum(){
		return stealNum;
	}
	 
	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}
	/*public void setFreeThrowPercentage(int Num) {
		if(matchNum!=0)
			 freeThrowPercentage = (Num+freeThrowPercentage*(matchNum-1))/matchNum;
			else
				freeThrowPercentage=Num;
	}*/
	public int getFoulNum() {
		return foulNum;
	}
	public void addFoulNum(int Num) {
		foulNum=foulNum+Num;
	}
	public int getPointNum() {
		return pointNum;
	}
	public void addPointNum(int Num) {
		pointNum=pointNum+Num;
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
	public double getShootEfficiency() {
		return shootEfficiency;
	}
	public void setShotEfficiency(double shotEfficiency) {
		this.shootEfficiency = shotEfficiency;
	}
	public double getAssistEfficiency() {
		return assistEfficiency;
	}
	public void setAssistEfficiency(double assistEfficiency) {
		this.assistEfficiency = assistEfficiency;
	}
	public double getReboundEfficiency() {
		return reboundEfficiency;
	}

	public double getOffensiveReboundEff() {
		return offensiveReboundEff;
	}

	public double getStealEfficiency(){
		return stealEfficiency;
	}
	public double getTurnoverPercenttage() {
		return turnoverPercentage;
	}
	public void setTurnoverPercenttage(double turnoverPercenttage) {
		this.turnoverPercentage = turnoverPercenttage;
	}
	public double getUsingPercentage(){
		return usingPercentage;
	}
	public void setUsingPercentage(double usingPercentage) {
		this.usingPercentage = usingPercentage;
	}
	public int getBlock() {
		return blockNum;
	}
	public double getGmSc() {
		return GmSc;
	}



	public int getDoubleNum() {
		return seasonDoubleNum;
	}



	public int getThreeNum() {
		return seasonThreeNum;
	}


	public String getSeason() {
		return season;
	}


	public int getFieldGoal() {
		return fieldGoal;
	}


	public int getShootNum() {
		return shootNum;
	}


	public int getT_fieldGoal() {
		return T_fieldGoal;
	}


	public int getT_shootNum() {
		return T_shootNum;
	}


	public int getFreeThrowGoalNum() {
		return freeThrowGoalNum;
	}


	public int getFreeThrowNum() {
		return freeThrowNum;
	}


	public int getO_ReboundNum() {
		return O_ReboundNum;
	}


	public int getD_ReboundNum() {
		return D_ReboundNum;
	}


	public int getBlockNum() {
		return blockNum;
	}


	public double getTurnoverPercentage() {
		return turnoverPercentage;
	}


	public double getRealShootPercentage() {
		return realShootPercentage;
	}


	public int getSeasonDoubleNum() {
		return seasonDoubleNum;
	}


	public int getSeasonThreeNum() {
		return seasonThreeNum;
	}
	
	
}
