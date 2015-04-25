package VO;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TeamSeasonDataVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 
	 * 注：基础数据中，带后缀_avg,是平均值，不带的是赛季进行到当下的总数，都可以通过get方法获得
	 */
 
	String season;					 //赛季
	String teamName; 				 //球队缩写
	private TeamInfoVO info;
	
	int matchNum; 				     //已比赛场数
	int winNum;						 //胜利场数
	double winRate;					//赛季胜率
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
	
	double shootPercentage; 		 //全队的投篮命中率
	double T_shootPercentage; 	     //全队的三分球命中率
	double freeThrowPercentage; 	 //全队的罚球命中率
	
	double offenseRound;
	double offenseRound_avg;
	
	private double defenseRound;   			//防守回合总数
	private double defenseRound_avg=0;
	double offenseEfficiency = 0; 	
	double offenseEfficiency_avg;
	double defenseEfficiency = 0;
	double defenseEfficiency_avg;
	double stealEfficiency = 0; 
	double stealEfficiency_avg;
	double assistEfficiency = 0;
	double assistEfficiency_avg;
	private double O_ReboundEfficiency =0; 
	double O_ReboundEfficiency_avg;
	private double D_ReboundEfficiency =0;
	double D_ReboundEfficiency_avg;
	
	private ArrayList<TeamMatchVO> last_five_match;

    	
	public TeamSeasonDataVO(String season,String teamName,TeamInfoVO info,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency,ArrayList<TeamMatchVO> last_five_match){
		
		last_five_match=new ArrayList<>();
		this.last_five_match=last_five_match;
		this.season=season;
		this.teamName = teamName; 
		this.info=info;
		this.matchNum = matchNum ; 
		this.winNum = winNum;
		this.fieldGoal = fieldGoal ;  
		this.fieldGoal = 
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
		this.pointNum = points ;  
		winRate=1;
		
		this.shootPercentage =  (double)fieldGoal/shootNum;  
		this.T_shootPercentage =(double)T_fieldGoal/T_shootNum ; 
		this.freeThrowPercentage = (double)freeThrowGoalNum/freeThrowNum ;  
		 
		this.offenseRound = offenseRound ;  
		
		this.offenseEfficiency = offenseEfficiency;  
		this.defenseEfficiency = defenseEfficiency;  
		
		this.stealEfficiency = stealEfficiency;  
		this.assistEfficiency = assistEfficiency;  
		
		this.O_ReboundEfficiency = O_ReboundEfficiency; 
		this.D_ReboundEfficiency = D_ReboundEfficiency;
		
		
		 /////////////////////
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
		  
		  //////
		   defenseRound_avg=defenseRound;
		   offenseEfficiency_avg=offenseEfficiency;
         defenseEfficiency_avg=defenseEfficiency;
        stealEfficiency_avg=stealEfficiency;
         assistEfficiency_avg=assistEfficiency;
		  O_ReboundEfficiency_avg=O_ReboundEfficiency;
		 D_ReboundEfficiency_avg=D_ReboundEfficiency;
		
	}
	

	 public void add_A_Match_Data(TeamMatchVO vo){
		
		 if(last_five_match.size()<5){
			 last_five_match.add(vo);
		 }else{
			 last_five_match.remove(0);
			 last_five_match.add(vo);
		 }
		 
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
		 pointNum=pointNum+vo.getPointNum();
		 
		 winRate=(double)winNum/matchNum;
		 
		 
		  shootPercentage=(double)fieldGoal/shootNum; 		 
		  T_shootPercentage=(double)T_fieldGoal/T_shootNum; 	 
		  freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum; 	
			  	
			  
		 offenseEfficiency = offenseEfficiency+vo.getOffenseEfficiency(); 	 
		 defenseEfficiency = defenseEfficiency+vo.getDefenseEfficiency(); 	 
			
 	 
		 stealEfficiency = stealEfficiency+vo.getStealEfficiency(); 	
		 assistEfficiency = assistEfficiency+vo.getAssistEfficiency(); 	 
			 
		 O_ReboundEfficiency = O_ReboundEfficiency+vo.getO_ReboundEfficiency(); 
		 D_ReboundEfficiency = D_ReboundEfficiency+vo.getD_ReboundEfficiency();
		 
		 
		 
		 /////////////////////
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
			  
			  //////
			   defenseRound_avg=0;
			   offenseEfficiency_avg=offenseEfficiency/matchNum;
              defenseEfficiency_avg=defenseEfficiency/matchNum;
             stealEfficiency_avg=stealEfficiency/matchNum;
             assistEfficiency_avg=assistEfficiency/matchNum;
			  O_ReboundEfficiency_avg=O_ReboundEfficiency/matchNum;
			 D_ReboundEfficiency_avg=D_ReboundEfficiency/matchNum;
		 
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

	

	public double getWinRate(){
		return winRate;
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


		public String getSeason() {
			return season;
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


		public double getFreeThrowNum_avg() {
			return freeThrowNum_avg;
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


		public int getBlockNum() {
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


		public double getFoulNum_avg() {
			return foulNum_avg;
		}


		public int getPointNum() {
			return pointNum;
		}


		public double getPointNum_avg() {
			return pointNum_avg;
		}


		public double getT_shootPercentage() {
			return T_shootPercentage;
		}


		public double getOffenseRound() {
			return offenseRound;
		}


		public double getOffenseRound_avg() {
			return offenseRound_avg;
		}


		public double getDefenseRound() {
			return defenseRound_avg;
		}


		public double getOffenseEfficiency() {
			return offenseEfficiency_avg;
		}


		 


		public double getDefenseEfficiency() {
			return defenseEfficiency_avg;
		}


		public double getStealEfficiency() {
			return stealEfficiency_avg;
		}


	 


		public double getAssistEfficiency() {
			return assistEfficiency_avg;
		}


	 


		public double getO_ReboundEfficiency() {
			return O_ReboundEfficiency_avg;
		}


		 


		public double getD_ReboundEfficiency() {
			return D_ReboundEfficiency_avg;
		}


		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}


		public TeamInfoVO getInfo() {
			return info;
		}


		public ArrayList<TeamMatchVO> getLast_five_match() {
			return last_five_match;
		}
}
