package VO;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.PO.SingleMatchPersonalDataPO;

public class PlayerSeasonDataVO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String season;					 //赛季
	String name;					 //球员姓名
	private String teamName;		 //所在球队名,为球队的缩写
	private String position;	     //场上位置
	private int matchNum;		 	 //出场次数
	private int startingNum;	     //首发场数
	 
	 private double time;		    //出场时间
	 private int fieldGoal;		    //进球数
	 private int shootNum;			 //出手
	 private int T_fieldGoal;		 //三分进球数
	 private int T_shootNum;		 //三分出手数
	 private int freeThrowGoalNum;	 //罚篮命中数	 
	 private int freeThrowNum;		 //罚篮总数
	 private int O_ReboundNum;		 //进攻篮板叔	 
	 private int D_ReboundNum;		 //防守篮板数
	 private int reboundNum;		 //篮板总数
	 private int assistNum;			 //助攻数	 
	 private int stealNum;			 //抢断数
	 private int blockNum;			 //盖帽数
	 private int turnoverNum;	     //失误数
	 private int foulNum;			 //犯规数
	 private int pointNum;		 	 //得分
	 
	private double efficiency; 		 //效率
	private double blockEfficiency;	 //篮板效率	 
	private double freeThrowPercentage;		//罚球命中率
	private double shootEfficiency;		    //投篮效率
	private double assistEfficiency;        //助攻率
	private double reboundEfficiency;       //篮板率
	private double offensiveReboundEff;     //进攻篮板率
	private double defenseReboundEff;	    //防守篮板率
	private double stealEfficiency;			//抢断率
	private double turnoverPercentage;      //失误率
	private double usingPercentage;         //使用率
	private double realShootPercentage=0;	//真实投篮命中率
	private double GmSc;				    //GmSc效率值
	private int seasonDoubleNum;		    //赛季两双数
	private int seasonThreeNum;  		    //赛季三双数
	
	private ArrayList<Integer> last_f_point=new ArrayList<>();
	private ArrayList<Integer> last_f_assist=new ArrayList<>();
	private ArrayList<Integer> last_f_rebound=new ArrayList<>();
	
	private double l_f_point_rate=0;
	private double l_f_assist_rate=0;
	private double l_f_rebound_rate=0;
	
	public PlayerSeasonDataVO(String season,String name,String teamName,String position,
	   int matchNum,  int startingNum,double time,int fieldGoal,
		 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
		 int O_R_N,int D_R_N,int reboundNum,int assistNum,int stealNum,int blockNum,int turnoverNum,
		 int foulNum,int points,
		                           double assistEfficiency,
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
			 double p_ave=(pointNum-get_last_five_Sum(last_f_point))/matchNum;
			 double a_ave=(assistNum-get_last_five_Sum(last_f_assist))/matchNum;
			 double r_ave=(reboundNum-get_last_five_Sum(last_f_rebound))/matchNum;
			 
			l_f_point_rate=(get_last_five_Sum(last_f_point)/5-p_ave)/p_ave;      //最近5场得分提升率
			l_f_assist_rate=(get_last_five_Sum(last_f_assist)/5-a_ave)/a_ave;    //最近5场助攻提升率
			l_f_rebound_rate=(get_last_five_Sum(last_f_rebound)/5-r_ave)/r_ave;  //最近5场篮板提升率
			 
		 }
		 
		 
	 }
	 
	private double get_last_five_Sum(ArrayList<Integer> list){
		 int sum=0;
		 for(int i=0;i<list.size();i++){
			 sum=sum+list.get(i);
		 }
		 return sum;
	 }
	
	public double getTime(){
		if(matchNum!=0)
			return time;
		else
			return 0;
	}
	public void addTime(double Num) {
		time=time+Num;
	}
	public double getBlockEfficiency(){
		if(matchNum!=0)
		return blockEfficiency/matchNum;
		else 
			return 0;
	}
	public void setBlockEfficiency(double blockEfficiency) {
		this.blockEfficiency = blockEfficiency;
	}
	public double getEfficiency() {
		if(matchNum!=0)
		 return (double)(pointNum+reboundNum+assistNum+stealNum+blockNum-
				  (shootNum-fieldGoal)  -(freeThrowNum-freeThrowGoalNum)-turnoverNum)/matchNum;
		else
			return 0;
	}
	 
	public double getReboundNum() {
		if(matchNum!=0)
		 return reboundNum/matchNum;
		else
			return 0;
	}
	public void addReboundNum(int num) {
		reboundNum=reboundNum+num;
	}
	public double getAssistNum() {
		if(matchNum!=0)
		  return assistNum;
		else
		  return 0;
	}
	public void addAssistNum(int num){
		matchNum=matchNum+num;
	}
	public double getTurnoverNum(){
		if(matchNum!=0)
		return turnoverNum/matchNum;
		return 0;
	}
	 
	public double getStealNum(){
		if(matchNum!=0)
		return stealNum/matchNum;
		else 
			return 0;
	}
	 
	public double getFreeThrowPercentage() {
		if(matchNum!=0)
		return freeThrowPercentage/matchNum;
		else
			return 0;
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
		
		 if(shootNum!=0){
			   
			   shootEfficiency=(fieldGoal+0.5*T_fieldGoal)/shootNum;
		 // 
		  }else{
			  shootEfficiency=0;
		  }
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
		return GmSc=pointNum+fieldGoal*0.4-0.7*shootNum-
				  0.4*(freeThrowNum-freeThrowGoalNum)+0.7*O_ReboundNum+0.3*D_ReboundNum
				  +stealNum+0.7*assistNum+0.7*blockNum-0.4*foulNum-turnoverNum;
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


	public double getTurnoverPercentage(){
		  if((shootNum-T_shootNum)!=0){
			  if(matchNum!=0)
		 turnoverPercentage=(double)turnoverNum/((shootNum-T_shootNum)+0.44*
				   (double)freeThrowNum/matchNum+(double)turnoverNum/matchNum);
		 }else{
			 if(matchNum!=0)
			 turnoverPercentage=0.44*(freeThrowNum+turnoverNum)/matchNum;
		 }
		return turnoverPercentage;
	}


	public double getRealShootPercentage() {
		if(matchNum!=0)
		return (double)realShootPercentage/matchNum;
		else
			return 0;
	}


	public int getSeasonDoubleNum() {
		return seasonDoubleNum;
	}


	public int getSeasonThreeNum() {
		return seasonThreeNum;
	}
	
	
}
