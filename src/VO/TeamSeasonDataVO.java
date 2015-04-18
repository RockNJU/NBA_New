package VO;
import java.io.Serializable;

public class TeamSeasonDataVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 
	 */
	String season;					 //����
	String teamName; 				 //�����д
	int matchNum; 				     //�ѱ�������
	int winNum;						 //ʤ������
	int fieldGoal; 					 //Ͷ��������
	int shootNum; 				     //Ͷ��������
	int T_fieldGoal; 				 //����������
	int T_shootNum; 				 //���ֳ�����
	int freeThrowGoalNum; 			 //����������
	int freeThrowNum; 				 //��������
	int O_ReboundNum; 				 //����������
	int D_ReboundNum; 				 //����������
	int assistNum;					 //������
	int stealNum; 					 //������
	int reboundNum; 				 //������
	int blockNum; 					 //��ñ��
	int turnoverNum; 			     //ʧ����
	int foulNum; 					 //������
	int points; 					 //�÷�
	
	int lost_points;				 //ʧ��
	
	int lost_rebound;                //��ʧ������
	int lost_O_rebound;				 //�Է���������
	int lost_D_rebound;				 //�Է���������
	
	double shootPercentage; 		 
	double threePointPercentage; 	 
	double freeThrowPercentage; 	 
	double offenseRound; 	
	
	private double defenseRound;   			//���ػغ�����
	double offenseEfficiency = 0; 	 
	double defenseEfficiency = 0; 	 
	double reboundEfficiency = 0; 	 
	double stealEfficiency = 0; 	
	double assistEfficiency = 0; 	 

	public TeamSeasonDataVO(String season,String teamName,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points,double shootPercentage,
	double threePointPercentage,double freeThrowPercentage,
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double reboundEfficiency,
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
		this.reboundEfficiency = reboundEfficiency;  
		this.stealEfficiency = stealEfficiency;  
		this.assistEfficiency = assistEfficiency;  
	}
	

	 public void add_A_Match_Data(double t,int fGoal,
			 int sNum,int T_fGoal,int T_sNum,int free_ThrowGoalNum,int free_ThrowNum,
			 int O_r_N,int D_r_N,int r_Num,int assist_Num,int steal_Num,int block_Num,
			 int turnover_Num,int foul_Num,int ps,int dNum,int tNum,double d_Round){
		 defenseRound=defenseRound+d_Round;
		 matchNum++;
		 fieldGoal=fieldGoal+fGoal;
		 shootNum=sNum+shootNum;
		 T_fieldGoal=T_fieldGoal+T_fGoal;
		
		 T_shootNum=T_shootNum+T_sNum;
		 freeThrowGoalNum=freeThrowGoalNum+free_ThrowGoalNum;
		 freeThrowNum=free_ThrowNum+freeThrowNum;
		 O_ReboundNum=O_ReboundNum+O_r_N;
		 D_ReboundNum=D_ReboundNum+D_r_N;
		 
		 reboundNum=reboundNum+r_Num;
		 assistNum=assistNum+assist_Num;
		 stealNum=stealNum+steal_Num;
		 blockNum=blockNum+block_Num;
		 turnoverNum=turnoverNum+turnover_Num;
		 
		 foulNum=foulNum+foul_Num;
		 points=points+ps;
		 
		 
		   shootPercentage=(double)fieldGoal/shootNum; 		 
			 threePointPercentage=(double)T_fieldGoal/T_shootNum; 	 
			  freeThrowPercentage=(double)freeThrowGoalNum/freeThrowNum; 	
			  /* �����غϣ����ӻغ�=Ͷ����+0.4*��ӷ�����-1.07*�����ӽ�������/�����ӽ�������+���ַ������壩*Ͷʧ������+1.07*ʧ����*/
			  offenseRound=shootNum+0.4*freeThrowNum-1.07*(O_ReboundNum/(O_ReboundNum+
					  lost_O_rebound)*(shootNum-fieldGoal))+1.07*turnoverNum; 	
			  
			  offenseEfficiency = 0; 	 
			  defenseEfficiency = 0; 	 
			 reboundEfficiency = 0; 	 
			 stealEfficiency = 0; 	
			 assistEfficiency = 0; 	 
		 
	 }
	
	public String getSreason(){
		return season;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public int getPointNum() {
		return points;
	}

	public void setPointNum(int i) {
		this.points = i;
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


	public int getReboundNum() {
		return reboundNum;
	}

	public void setReboundNum(int i) {
		this.reboundNum = i;
	}

	public int getO_ReboundNum() {
		return O_ReboundNum;
	}

	public void setO_ReboundNum(int i) {
		this.O_ReboundNum = i;
	}

	public int getD_ReboundNum() {
		return D_ReboundNum;
	}

	public void setD_ReboundNum(int i) {
		this.D_ReboundNum = i;
	}

	public int getAssistNum() {
		return assistNum;
	}

	public void setAssistNum(int i) {
		this.assistNum = i;
	}

	public int getTurnoverNum() {
		return turnoverNum;
	}

	public void setTurnoverNum(int i) {
		this.turnoverNum = i;
	}

	public int getStealNum() {
		return stealNum;
	}

	public void setStealNum(int i) {
		this.stealNum = i;
	}

	public int getFoulNum() {
		return foulNum;
	}

	public void setFoulNum(int i) {
		this.foulNum = i;
	}

	public int getFieldGoal() {
		return fieldGoal;
	}

	public void setFieldGoal(int i) {
		this.fieldGoal = i;
	}

	public int getShootNum() {
		return shootNum;
	}

	public void setShootNum(int i) {
		this.shootNum = i;
	}

	public int getT_fieldGoal() {
		return T_fieldGoal;
	}

	public void setT_fieldGoal(int i) {
		this.T_fieldGoal = i;
	}

	public int getT_shootNum() {
		return T_shootNum;
	}

	public void setT_shootNum(int i) {
		this.T_shootNum = i;
	}

	public int getFreeThrowGoalNum() {
		return freeThrowGoalNum;
	}

	public void setFreeThrowGoalNum(int i) {
		this.freeThrowGoalNum = i;
	}

	public int getFreeThrowNum() {
		return freeThrowNum;
	}

	public void setFreeThrowNum(int i) {
		this.freeThrowNum = i;
	}

	public int getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(int i) {
		this.blockNum = i;
	}

	public double getOffenseRound() {
		return offenseRound;
	}

	public void setOffenseRound(double d) {
		this.offenseRound = d;
	}

	public double getFreeThrowPercentage() {
		return freeThrowPercentage;
	}

	public void setFreeThrowPercentage(double d) {
		this.freeThrowPercentage = d;
	}

	public double getThreePointPercentage() {
		return threePointPercentage;
	}

	public void setThreePointPercentage(double d) {
		this.threePointPercentage = d;
	}

	public double getShootPercentage() {
		return shootPercentage;
	}

	public void setShootPercentage(double d) {
		this.shootPercentage = d;
	}

	public double getAssistEfficiency() {
		/*
		 * �����ʣ�ÿ 100 �������غϣ���ӵ���������
		 * */
		return (double)assistNum/(offenseRound/matchNum/100);
	}

	public void setAssistEfficiency(double d) {
		this.assistEfficiency = d;
	}

	public double getReboundEfficiency() {
		return reboundEfficiency;
	}

	public void setReboundEfficiency(double d) {
		this.reboundEfficiency = d;
	}

	public double getStealEfficiency() {
		/*����Ч�ʣ�ÿ 100 �����ػغϣ���ӵ���������*/
		return ((double)stealNum/matchNum)/(defenseRound/matchNum/100);
	}

	public void setStealEfficiency(double d) {
		this.stealEfficiency = d;
	}

	public double getDefenseEfficiency() {
		/*����Ч�ʣ�ÿ 100 �����ػغϣ����ֵĵ÷�*/
		return ((double)lost_points/matchNum)/(defenseRound/matchNum/100);
	}

	public void setDefenseEfficiency(double d) {
		this.defenseEfficiency = d;
	}

	public double getOffenseEfficiency() {
		/*����Ч�ʣ�ÿ 100 �������غϣ���ӵĵ÷�*/
		return ((double)points/matchNum)/(offenseRound/matchNum/100);
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
}
