package businesslogic.bl;

import java.util.ArrayList;

import VO.TeamMatchVO;
import VO.TeamSeasonDataVO;

public class TeamSeasonData {
	private String season;
	private ArrayList<TeamSeasonDataVO> teamSeasonList;
	
	public TeamSeasonData(String season){
		this.season=season;	
		teamSeasonList=new ArrayList<TeamSeasonDataVO>();
	}
	
	public void updateTeamSeasonData(TeamMatchVO vo){
		for(int i=0;i<teamSeasonList.size();i++){
			if(teamSeasonList.get(i).getTeamName().equals(vo.getTeamName())){
				teamSeasonList.get(i).add_A_Match_Data(vo);      //�������б����Ѿ�����ĳ֧��ӵ�ʱ��ֱ�Ӹ��ݴ����������ݽ��и���
				return;
			}
		}
		/*
		 * String season,String teamName,int matchNum,int winNum,
	int fieldGoal,int shootNum,int T_fieldGoal,int T_shootNum,
	int freeThrowGoalNum,int freeThrowNum,int O_ReboundNum,
	int D_ReboundNum,int assistNum,int stealNum,int reboundNum,int blockNum,
	int turnoverNum,int foulNum,int points, 
	 
	double offenseRound,double offenseEfficiency,
	double defenseEfficiency,double O_ReboundEfficiency,double D_ReboundEfficiency,
	double stealEfficiency ,double assistEfficiency
		 * */
		teamSeasonList.add(new TeamSeasonDataVO(vo.getSeason(),vo.getTeamName(),1,vo.getWinNum(),
				vo.getFieldGoal(),vo.getShootNum(),vo.getT_fieldGoal(),vo.getT_shootNum(),
				vo.getFreeThrowGoalNum(),vo.getFreeThrowNum(),vo.getO_ReboundNum(),vo.getD_ReboundNum(),
				vo.getAssistNum(),vo.getStealNum(),vo.getReboundNum(),vo.getBlockNum(),vo.getTurnoverNum(),
				vo.getFoulNum(),vo.getPointNum(),vo.getOffenseRound(),vo.getOffenseEfficiency(),
				vo.getDefenseEfficiency(),vo.getO_ReboundEfficiency(),vo.getD_ReboundEfficiency(),
				vo.getStealEfficiency(),vo.getAssistEfficiency()));            //�������б���û��ĳ֧��ӵ�ʱ�������֧��ӵ���Ϣ
	}
	
	public TeamSeasonData(String season,ArrayList<TeamSeasonDataVO> list){
		this.season=season;
		this.teamSeasonList=list;
	}
	
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public ArrayList<TeamSeasonDataVO> getTeamSeasnList() {
		return teamSeasonList;
	}
	public void setTeamSeasnList(ArrayList<TeamSeasonDataVO> teamSeasnList) {
		this.teamSeasonList = teamSeasnList;
	}
}
