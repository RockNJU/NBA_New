package VO;

import java.io.Serializable;
import java.util.ArrayList;
public class PlayerSeasonDataVO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String season;					 //赛季
	String name;					 //球员姓名
	private String teamName;		 //所在球队名,为球队的缩写
	private String division;		 //球员目前所效力球队所在的分区
	private String partition;		 //球员所效力球队所在的赛区
	private String position;	     //场上位置
	private int matchNum;		 	 //出场次数
	private int startingNum;	     //首发场数
	 
	   private double time;		    //出场时间
	  private double time_avg;       //出场平均时间
	 
	    int fieldGoal; 					 //投篮命中数
		double fieldGoal_avg;
		int shootNum; 				     //投篮出手数
		double shootNum_avg;
		int T_fieldGoal; 				 //三分命中数
		double T_fieldGoal_avg;
		int T_shootNum; 				 //三分出手数
		double T_shootNum_avg;
		int freeThrowGoalNum; 			 //罚球命中数
		double freeThrowGoalNum_avg;
		int freeThrowNum; 				 //罚球总数
		double freeThrowNum_avg;
		int O_ReboundNum; 				 //进攻篮板数
		double O_ReboundNum_avg;
		int D_ReboundNum; 				 //防守篮板数
		double D_ReboundNum_avg;
		int assistNum;					 //助攻数
		double assistNum_avg;
		int stealNum; 					 //抢断数
		double stealNum_avg;
		int reboundNum; 				 //篮板数
		double reboundNum_avg;
		int blockNum; 					 //盖帽数
		double blockNum_avg;
		int turnoverNum; 			     //失误数
		double turnoverNum_avg;
		int foulNum; 					 //犯规数
		double foulNum_avg;
		int pointNum; 					 //得分
		double pointNum_avg;
	 
	private double efficiency; 		 //效率
	private double blockEfficiency;	 //盖帽效率	 
	
	private double freeThrowPercentage;		//罚球命中率
	private double shootPercentage;			//投篮命中率
	private double T_shootPercentage;		//三分球命中率
	
	private double shootEfficiency;		    //投篮效率
	
	private double assistEfficiency;        //助攻率
	private double reboundEfficiency;       //篮板率
	private double offensiveReboundEff;     //进攻篮板率
	private double defenseReboundEff;	    //防守篮板率
	private double stealEfficiency;			//抢断率
	private double turnoverPercentage;      //失误率
	private double usingPercentage;         //使用率
	
	private double assistEfficiency_avg;        //助攻率
	private double reboundEfficiency_avg;       //篮板率
	private double offensiveReboundEff_avg;     //进攻篮板率
	private double defenseReboundEff_avg;	    //防守篮板率
	private double stealEfficiency_avg;			//抢断率
	private double usingPercentage_avg;         //使用率
	private double blockEfficiency_avg;	 //篮板效率
	private double realShootPercentage=0;	//真实投篮命中率
	private double GmSc;				    //GmSc效率值
	private int seasonDoubleNum;		    //赛季两双数
	private int seasonThreeNum;  		    //赛季三双数
	
	private ArrayList<Integer> last_f_point=new ArrayList<>();
	private ArrayList<Integer> last_f_assist=new ArrayList<>();
	private ArrayList<Integer> last_f_rebound=new ArrayList<>();
	
	private double l_f_point_rate=0;         //最近五场得分的提升率
	private double l_f_assist_rate=0; 		//最近五场助攻的提升率
	private double l_f_rebound_rate=0;		//最近五场篮板的提升率
	
	public PlayerSeasonDataVO(String season,String name,String teamName,
			String division,String partition,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,
		 int freeThrowNum,int O_R_N,int D_R_N,int reboundNum,
		 int assistNum,int stealNum,int blockNum,int turnoverNum,
		 int foulNum,int points,
		                           double assistEfficiency,
		 double reboundEfficiency,double offensiveReboundEff,
		 double defenseReboundEff,double stealEfficiency,
		 double usingPercentage,double blockEfficiency,int doubleNum,int threeNum){
				
				this.season=season;
				this.name=name;
				this.teamName=teamName;
			
				this.division=division;
				 this.partition=partition;
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
				
				GmSc=pointNum+fieldGoal*0.4-0.7*shootNum-
						  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*O_ReboundNum+0.3*D_ReboundNum
						  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
				
				/*  真实投篮命中率： 得分÷(2×(投篮出手数+0.44×罚球出手数))*/
				if((shootNum+0.44*freeThrowNum)!=0)
				realShootPercentage=pointNum/(2*(shootNum+0.44*freeThrowNum));
				
				
				 if(shootNum!=0){
					   
					   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
				 // 
				  }else{
					  shootEfficiency=0;
				  }
				//////////////////*
				 time_avg=time;
				 fieldGoal_avg= fieldGoal;				    
				 shootNum_avg= shootNum;
				  T_fieldGoal_avg= T_fieldGoal;
				  T_shootNum_avg= T_shootNum;
				  freeThrowGoalNum_avg= freeThrowGoalNum;
				  freeThrowNum_avg= freeThrowNum;		 
				  O_ReboundNum_avg= O_ReboundNum;	 
				  D_ReboundNum_avg= D_ReboundNum;		 
				  assistNum_avg= assistNum;		 
				  stealNum_avg= stealNum;	 
				  reboundNum_avg= reboundNum;	 
				  blockNum_avg= blockNum;		 
				  turnoverNum_avg= turnoverNum;		 
				  foulNum_avg= foulNum;
				  pointNum_avg= pointNum;
				  
				  if(matchNum!=0)
						 efficiency=  pointNum+reboundNum+assistNum+stealNum+blockNum-
						   (shootNum-fieldGoal)  -(freeThrowNum-freeThrowGoalNum)-turnoverNum ;
						else 
							efficiency=0;
				  /////////////
				     assistEfficiency_avg=assistEfficiency;        //助攻率
					  reboundEfficiency_avg=reboundEfficiency;       //篮板率
					  offensiveReboundEff_avg=offensiveReboundEff;     //进攻篮板率
					  defenseReboundEff_avg=defenseReboundEff;	    //防守篮板率
					  stealEfficiency_avg=stealEfficiency;			//抢断率
					  blockEfficiency_avg=blockEfficiency;
					  usingPercentage_avg=usingPercentage;         //使用率
					  
					      if(freeThrowNum!=0)
					    freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;		//罚球命中率
					      if(shootNum!=0)
						 shootPercentage=(double)fieldGoal/shootNum;			//投篮命中率
					      if(T_shootNum!=0)
						  T_shootPercentage=(double)T_fieldGoal/T_shootNum;		//三分球命中率
					      
					      if((shootNum-T_shootNum)!=0){	  
					 		 turnoverPercentage=(double)turnoverNum/((shootNum-T_shootNum)+0.44*
					 				   (double)freeThrowNum/matchNum+(double)turnoverNum/matchNum);
					 		 }else{ 
					 			 turnoverPercentage=0.44*(freeThrowNum+turnoverNum)/matchNum;
					 		 }
				
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
 
	public double getL_f_point_rate(){
	  return l_f_point_rate;
   }
	
	public double getL_f_assist_rate(){
		  return l_f_assist_rate;
	  }
	  
	public double getL_f_rebound_rate(){
		  return l_f_rebound_rate;
	  }
	
	 public void add_A_MatchData(SingleMatchPersonalDataVO vo){
		 matchNum++;
		 time=time+vo.getTime();
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
		 pointNum=pointNum+vo.getPoints();
		 
		 
		 GmSc=(pointNum+fieldGoal*0.4-0.7*shootNum-
				  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*O_ReboundNum+0.3*D_ReboundNum
				  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum)/matchNum;
		 if((shootNum+0.44*freeThrowNum)!=0)
				realShootPercentage=pointNum/(2*(shootNum+0.44*freeThrowNum));
		 
		 if(shootNum!=0){
			   
			   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
		 // 
		  }else{
			  shootEfficiency=0;
		  }
		 
		 int count=0;
		 if(vo.getPoints()>=10)
			 count++;
		 if(vo.getReboundNum()>=10)
			 count++;
		 if(vo.getBlockNum()>=10)
			 count++;
		 if(vo.getStealNum()>=10)
			 count++;
		 if(vo.getAssistNum()>=10)
			 count++;
		 
		 if(count==2){
		 seasonDoubleNum++;
		 }else if(count==3){
		 seasonThreeNum++;   //计算三双数
		 }
		 
		 if(vo.getPlayerPosition()!=null&vo.getPlayerPosition().length()!=0)
		 startingNum++;
		 
		 
		 assistEfficiency= assistEfficiency+vo.getAssistEfficiency();
		  reboundEfficiency=reboundEfficiency+vo.getReboundEfficiency();
		  offensiveReboundEff=offensiveReboundEff + vo.getOffensiveReboundEff();
		  defenseReboundEff=defenseReboundEff+ vo.getDefenseReboundEff();
		 stealEfficiency=stealEfficiency+vo.getStealEfficiency();
		 usingPercentage=usingPercentage+ vo.getUsingPercentage();
		 blockEfficiency=blockEfficiency+vo.getBlockEfficiency();
		 
		 efficiency= (double)(pointNum+reboundNum+assistNum+stealNum+blockNum-
				   (shootNum-fieldGoal)  -(double)(freeThrowNum-freeThrowGoalNum)-turnoverNum)/matchNum;
		 
		 
		 if(freeThrowNum!=0)
			    freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;		//罚球命中率
			      if(shootNum!=0)
				 shootPercentage=(double)fieldGoal/shootNum;			//投篮命中率
			      if(T_shootNum!=0)
				  T_shootPercentage=(double)T_fieldGoal/T_shootNum;		//三分球命中率
		 
		 if(shootNum!=0)
			 shootPercentage=(double)fieldGoal/shootNum ;
		 if(freeThrowNum!=0)
				freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum;
		 if(T_shootNum==0)
				T_shootPercentage=(double)T_fieldGoal/T_shootNum;
		 
		 if(last_f_point.size()<5){
			 last_f_point.add(vo.getPoints());
			 last_f_assist.add(vo.getAssistNum());
			 last_f_rebound.add(vo.getReboundNum());
		 }else{
			 last_f_point.remove(0);
			 last_f_assist.remove(0);
			 last_f_rebound.remove(0);
			 
			 last_f_point.add(vo.getPoints());
			 last_f_assist.add(vo.getAssistNum());
			 last_f_rebound.add(vo.getReboundNum());
			 double p_avg=(pointNum-get_last_five_Sum(last_f_point))/matchNum;
			 double a_avg=(assistNum-get_last_five_Sum(last_f_assist))/matchNum;
			 double r_avg=(reboundNum-get_last_five_Sum(last_f_rebound))/matchNum;
			 
			l_f_point_rate=(get_last_five_Sum(last_f_point)/5-p_avg)/p_avg;      //最近5场得分提升率
			l_f_assist_rate=(get_last_five_Sum(last_f_assist)/5-a_avg)/a_avg;    //最近5场助攻提升率
			l_f_rebound_rate=(get_last_five_Sum(last_f_rebound)/5-r_avg)/r_avg;  //最近5场篮板提升率
			 
		 }
		 
		 
		 
		 
		 /////////////////////////
		 time_avg=time/matchNum;
		 fieldGoal_avg=(double)fieldGoal/matchNum;				    
		 shootNum_avg=(double)shootNum/matchNum;
		  T_fieldGoal_avg=(double)T_fieldGoal/matchNum;
		  T_shootNum_avg=(double)T_shootNum/matchNum;
		  freeThrowGoalNum_avg=(double)freeThrowGoalNum/matchNum;
		  freeThrowNum_avg=(double)freeThrowNum/matchNum;		 
		  O_ReboundNum_avg=(double)O_ReboundNum/matchNum;	 
		  D_ReboundNum_avg=(double)D_ReboundNum/matchNum;		 
		  assistNum_avg=(double)assistNum/matchNum;		 
		  stealNum_avg=(double)stealNum/matchNum;	 
		  reboundNum_avg=(double)reboundNum/matchNum;	 
		  blockNum_avg=(double)blockNum/matchNum;		 
		  turnoverNum_avg=(double)turnoverNum/matchNum;		 
		  foulNum_avg=(double)foulNum/matchNum;
		  pointNum_avg=(double)pointNum/matchNum;
		  /////////////
		  assistEfficiency_avg=assistEfficiency/matchNum;        //助攻率
		  reboundEfficiency_avg=reboundEfficiency/matchNum;       //篮板率
		  offensiveReboundEff_avg=offensiveReboundEff/matchNum;     //进攻篮板率
		  defenseReboundEff_avg=defenseReboundEff/matchNum;	    //防守篮板率
		  stealEfficiency_avg=stealEfficiency/matchNum;			//抢断率
		  blockEfficiency_avg=blockEfficiency/matchNum;
		  usingPercentage_avg=usingPercentage/matchNum;         //使用率
		  
		  if((shootNum-T_shootNum)!=0){	  
		 turnoverPercentage=(double)turnoverNum/((shootNum-T_shootNum)+0.44*
				   (double)freeThrowNum/matchNum+(double)turnoverNum/matchNum);
		 }else{ 
			 turnoverPercentage=0.44*(freeThrowNum+turnoverNum)/matchNum;
		 }
		 
	 }
	 
	private double get_last_five_Sum(ArrayList<Integer> list){
		 int sum=0;
		 for(int i=0;i<list.size();i++){
			 sum=sum+list.get(i);
		 }
		 return sum;
	 }
	
	 
	public double getFreeThrowPercentage() {
		 
		return freeThrowPercentage;
		 
	}
	 
 
	
	public double getT_shootPercentage(){
		return T_shootPercentage;  //获取三分球命中率
	}
	public double getShootPercentage() {
		return shootPercentage;
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

 
	public int getSeasonDoubleNum() {
		return seasonDoubleNum;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}

	public String getPartition() {
		return partition;
	}
	
	public void setPartition(String partition) {
		this.partition = partition;
	}



	public double getTime() {
		return time;
	}



	public double getTime_avg() {
		return time_avg;
	}



	public int getFieldGoal() {
		return fieldGoal;
	}



	public double getFieldGoal_avg() {
		return fieldGoal_avg;
	}



	public int getShootNum() {
		return shootNum;
	}



	public double getShootNum_avg() {
		return shootNum_avg;
	}



	public int getT_fieldGoal() {
		return T_fieldGoal;
	}



	public double getT_fieldGoal_avg() {
		return T_fieldGoal_avg;
	}



	public int getT_shootNum() {
		return T_shootNum;
	}



	public double getT_shootNum_avg() {
		return T_shootNum_avg;
	}



	public int getFreeThrowGoalNum() {
		return freeThrowGoalNum;
	}



	public double getFreeThrowGoalNum_avg() {
		return freeThrowGoalNum_avg;
	}



	public int getFreeThrowNum() {
		return freeThrowNum;
	}



	public int getO_ReboundNum() {
		return O_ReboundNum;
	}



	public double getO_ReboundNum_avg() {
		return O_ReboundNum_avg;
	}



	public int getD_ReboundNum() {
		return D_ReboundNum;
	}



	public double getD_ReboundNum_avg() {
		return D_ReboundNum_avg;
	}



	public int getAssistNum() {
		return assistNum;
	}



	public double getAssistNum_avg() {
		return assistNum_avg;
	}



	public int getStealNum() {
		return stealNum;
	}



	public double getStealNum_avg() {
		return stealNum_avg;
	}

	public int getReboundNum() {
		return reboundNum;
	}

	public double getReboundNum_avg() {
		return reboundNum_avg;
	}

	public int getBlockNum(){
		return blockNum;
	}

	public double getBlockNum_avg() {
		return blockNum_avg;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public double getTurnoverNum_avg() {
		return turnoverNum_avg;
	}

	public int getFoulNum() {
		return foulNum;
	}
	public double getFoulNum_avg() {
		return foulNum_avg;
	}

	public int getPointNum() {
		return pointNum;
	}

	public double getPointNum_avg() {
		return pointNum_avg;
	}

	public double getEfficiency() {
		return efficiency;
	}

	public double getShootEfficiency() {
		return shootEfficiency;
	}

	public double getTurnoverPercentage() {
		return turnoverPercentage;
	}

	public double getAssistEfficiency() {
		return assistEfficiency_avg;
	}

	public double getReboundEfficiency() {
		return reboundEfficiency_avg;
	}

	public double getOffensiveReboundEff() {
		return offensiveReboundEff_avg;
	}

	public double getDefenseReboundEff() {
		return defenseReboundEff_avg;
	}

	public double getStealEfficiency() {
		return stealEfficiency_avg;
	}

	public double getUsingPercentage() {
		return usingPercentage_avg;
	}

	public double getBlockEfficiency() {
		return blockEfficiency_avg;
	}

	public double getRealShootPercentage() {
		return realShootPercentage;
	}

	public double getGmSc() {
		return GmSc;
	}



	public int getSeasonThreeNum() {
		return seasonThreeNum;
	}



	public ArrayList<Integer> getLast_f_point() {
		return last_f_point;
	}



	public ArrayList<Integer> getLast_f_rebound() {
		return last_f_rebound;
	}



	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
