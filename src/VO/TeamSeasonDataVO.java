package VO;
import java.io.Serializable;

public class TeamSeasonDataVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 一支球队的
	 */
	String season;					//赛季
	String teamName; 				// 队名，表示的是球队的球队缩写
	int matchNum; 					// 赛季已比赛场数
	int winNum;						//胜利场数
	int fieldGoal; 					// 进球数
	int shootNum; 					// 投篮总数
	int T_fieldGoal; 				// 三分命中数
	int T_shootNum; 				// 三分出手数
	int freeThrowGoalNum; 			// 罚篮命中数
	int freeThrowNum; 				// 罚球出手数
	int O_ReboundNum; 				// 进攻篮板数
	int D_ReboundNum; 				// 防守篮板数
	int assistNum;					// 助攻数
	int stealNum; 					// 抢断数
	int reboundNum; 				// 篮板总数
	int blockNum; 					// 盖帽数
	int turnoverNum; 				// 失误数
	int foulNum; 					// 犯规数
	int points; 					// 得分
	
	double shootPercentage; 		// 投篮命中率
	double threePointPercentage; 	// 三分命中率
	double freeThrowPercentage; 	// 罚篮命中率
	double offenseRound; 			// 进攻回合
	double offenseEfficiency = 0; 	// 进攻效率
	double defenseEfficiency = 0; 	// 防守效率
	double reboundEfficiency = 0; 	// 篮板效率
	double stealEfficiency = 0; 	// 抢断效率
	double assistEfficiency = 0; 	// 助攻效率

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
		this.teamName = teamName; // �����������
		this.matchNum = matchNum ; // ��������
		this.winNum = winNum;
		this.fieldGoal = fieldGoal ; // Ͷ��������
		this.shootNum = shootNum ; // Ͷ��������
		this.T_fieldGoal = T_fieldGoal ; // ������������
		this.T_shootNum = T_shootNum ; // �����������
		this.freeThrowGoalNum =  freeThrowGoalNum; // ����������
		this.freeThrowNum = freeThrowNum; // ���������
		this.O_ReboundNum = O_ReboundNum ; // ������ǰ����������
		this.D_ReboundNum =  D_ReboundNum; // ���أ��󳡣�������
		this.assistNum =  assistNum; // ������
		this.stealNum = stealNum ; // ������
		this.reboundNum = reboundNum ; // ��������
		this.blockNum = blockNum ; // ��ñ��
		this.turnoverNum = turnoverNum ; // ʧ����
		this.foulNum = foulNum ; // ������
		this.points = points ; // �÷�
		this.shootPercentage =  shootPercentage; // Ͷ��������
		this.threePointPercentage = threePointPercentage ; // ��������������
		this.freeThrowPercentage = freeThrowPercentage ; // ��������������
		 
		this.offenseRound = offenseRound ; // �����غ�
		this.offenseEfficiency = offenseEfficiency; // ����Ч��
		this.defenseEfficiency = defenseEfficiency; // ����Ч��
		this.reboundEfficiency = reboundEfficiency; // ����Ч��
		this.stealEfficiency = stealEfficiency; // ������
		this.assistEfficiency = assistEfficiency; // ������

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
		return assistEfficiency;
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
		return stealEfficiency;
	}

	public void setStealEfficiency(double d) {
		this.stealEfficiency = d;
	}

	public double getDefenseEfficiency() {
		return defenseEfficiency;
	}

	public void setDefenseEfficiency(double d) {
		this.defenseEfficiency = d;
	}

	public double getOffenseEfficiency() {
		return offenseEfficiency;
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
