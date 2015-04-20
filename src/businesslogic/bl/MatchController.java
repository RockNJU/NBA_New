package businesslogic.bl;

import java.util.ArrayList;

import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamMatchVO;
import businessService.blservice.MatchBLService;
import businesslogic.PO.MatchPO;
import businesslogic.PO.SingleMatchPersonalDataPO;
import businesslogic.PO.TeamMatchPO;

public class MatchController implements MatchBLService{
	
	public MatchVO matchpo_TO_po(MatchPO po){
       /*�����غϣ����ӻغ�=Ͷ����+0.4*��ӷ�����-1.07*�����ӽ�������/�����ӽ�����
					��+���ַ������壩*Ͷʧ������+1.07*ʧ����**/
		TeamMatchPO H_po=po.getHostTeam();
		TeamMatchPO G_po=po.getGuestTeam();
		double H_offense_round=H_po.getShootNum()+0.4*H_po.getFreeThrowNum()-1.07*(
				(double)H_po.getO_ReboundNum()/(H_po.getO_ReboundNum()+G_po.getD_ReboundNum())*
				(H_po.getShootNum()-H_po.getFieldGoal()))+1.07*H_po.getTurnoverNum();
		
        double G_offense_round=G_po.getShootNum()+0.4*G_po.getFreeThrowNum()-1.07*(
				(double)G_po.getO_ReboundNum()/(G_po.getO_ReboundNum()+H_po.getD_ReboundNum())*
				(G_po.getShootNum()-G_po.getFieldGoal()))+1.07*G_po.getTurnoverNum();
        /* ��������Ч�ʣ�ǰ�����������/��ǰ����������+���ֺ���������*/
        double H_offenseReboundeEff=(double)H_po.getO_ReboundNum()/(H_po.getO_ReboundNum()+G_po.getD_ReboundNum());
        double G_offenseReboundeEff=(double)G_po.getO_ReboundNum()/(G_po.getO_ReboundNum()+H_po.getD_ReboundNum());
        
        
        ArrayList<SingleMatchPersonalDataVO> H_player_list=playerMatchPO_To_VO(H_po.getTeamName(),po.getSeason(),po.getDate(),
        		H_po.getIndividualData(),
				H_po.getReboundNum(),G_po.getReboundNum(),H_po.getFieldGoal(),G_offense_round,
				G_po.getShootNum(),H_po.getShootNum(),H_po.getFreeThrowNum(),H_po.getTurnoverNum());
        
        ArrayList<SingleMatchPersonalDataVO> G_player_list=playerMatchPO_To_VO(G_po.getTeamName(),po.getSeason(),po.getDate(),
        		G_po.getIndividualData(),
				G_po.getReboundNum(),H_po.getReboundNum(),G_po.getFieldGoal(),H_offense_round,
				H_po.getShootNum(),G_po.getShootNum(),G_po.getFreeThrowNum(),G_po.getTurnoverNum());
        /*String season,String teamName, 
			int winNum,int pointNum,int lost_point,
			int reboundNum, int O_ReboundNum, int D_ReboundNum,
			int assistNum, int turnoverNum, int stealNum, int foulNum,
			int fieldGoal, int shootNum, int T_fieldGoal, int T_shootNum,
			int freeThrowGoalNum, int freeThrowNum, int blockNum,
			double offenseRound, double defenseRound,
			double O_ReboundEfficiency,double D_ReboundEfficiency,
			ArrayList<SingleMatchPersonalDataVO> individualData*/
        String []sco=po.getSeason().split("-");
        int H_win=0,G_win=0;
        if(sco[0].compareTo(sco[1])>0){
        	H_win=1;
        }else{
        	G_win=1;
        }
        
        TeamMatchVO H_team=new TeamMatchVO(po.getSeason(), H_po.getTeamName(),H_win,
        		H_po.getPoints(),G_po.getPoints(), H_po.getReboundNum(),
        		H_po.getO_ReboundNum(), H_po.getD_ReboundNum(), 
        		H_po.getAssistNum(), H_po.getTurnoverNum(),
        		H_po.getStealNum(), H_po.getFoulNum(), H_po.getFieldGoal(),
        		H_po.getShootNum(), H_po.getT_fieldGoal(), 
        		H_po.getT_shootNum(), H_po.getFreeThrowGoalNum()
        		, H_po.getFreeThrowNum(),H_po.getBlockNum(), 
        		H_offense_round, G_offense_round, 
        		H_offenseReboundeEff, H_offenseReboundeEff, H_player_list);
        
        TeamMatchVO G_team=new TeamMatchVO(po.getSeason(), G_po.getTeamName(),G_win,
        		G_po.getPoints(),H_po.getPoints(), G_po.getReboundNum(),
        		G_po.getO_ReboundNum(), G_po.getD_ReboundNum(), 
        		G_po.getAssistNum(), G_po.getTurnoverNum(),
        		G_po.getStealNum(), G_po.getFoulNum(), G_po.getFieldGoal(),
        		G_po.getShootNum(), G_po.getT_fieldGoal(), 
        		G_po.getT_shootNum(), G_po.getFreeThrowGoalNum()
        		, G_po.getFreeThrowNum(),G_po.getBlockNum(), 
        		G_offense_round, H_offense_round, 
        		G_offenseReboundeEff, G_offenseReboundeEff, G_player_list);
        
        
        
		return new MatchVO(po.getSeason(),po.getDate(),po.getMatchScore(),po.getScores(),
				H_team,G_team);
		}
	
	private ArrayList<SingleMatchPersonalDataVO> playerMatchPO_To_VO(String team,String season,
			String date,ArrayList<SingleMatchPersonalDataPO>list,
			int T_reboundNum,int E_reboundNum,int T_fieldGoal,double E_offenseRound,
			int E_two_shootNum,int T_shootNum,int T_freeThrowNum,int T_turnoverNum){
		
		  double assistEff =0;        //������__
		  double reboundEff =0;       //������__
		  double offensiveReboundEff=0;     //����������__
		  double defenseReboundEff=0;     	//����������__
		  double stealEff =0;			//������__
		  double usingPer =0;         //ʹ����__
		  double blockEff =0;			//��ñ��__
		 ArrayList<SingleMatchPersonalDataVO> result=new ArrayList<>();
		 SingleMatchPersonalDataPO po;
		 for(int i=0;i<list.size();i++){
			 po=list.get(i);
			 /*�����ʣ���Ա��������(��Ա�ϳ�ʱ���(���������Ա�ϳ�ʱ���5)������ܽ� ����-��Ա������)*/
			 if(po.getTime()!=0){
			 assistEff=(double)po.getAssistNum()/(po.getTime()/48*T_fieldGoal-po.getFieldGoal());
			/* �����ʣ���Ա��������(���������Ա�ϳ�ʱ���5)����Ա�ϳ�ʱ���(���������+����������)*/
			 reboundEff=(double)po.getReboundNum()/48/po.getTime()/(T_reboundNum+E_reboundNum);
			 offensiveReboundEff=(double)po.getO_ReboundNum()/48/po.getTime()/(T_reboundNum+E_reboundNum);
			 defenseReboundEff=(double)po.getD_ReboundNum()/48/po.getTime()/(T_reboundNum+E_reboundNum);
			 /*�����ʣ� ��Ա��������(���������Ա�ϳ�ʱ���5)����Ա�ϳ�ʱ��¶��ֽ�������)*/
			 stealEff=(double)po.getStealNum()*48/po.getTime()/E_offenseRound;
			 /*��ñ�ʣ���Ա��ñ����(���������Ա�ϳ�ʱ���5)����Ա�ϳ�ʱ��¶�����������ִ���*/
			 blockEff=po.getBlockNum()*48/po.getTime()/E_two_shootNum;
			 /*ʹ���ʣ� (��Ա���ִ���+0.44����Ա�������+��Աʧ�����)��(���������Ա
			�ϳ�ʱ���5)����Ա�ϳ�ʱ���(�����������Ա���ִ���+0.44�����������Ա����
			����+���������Աʧ�����) */
			 usingPer=(po.getShootNum()+0.44*po.getFreeThrowNum()+po.getTurnoverNum())*
			 48/po.getTime()/(T_shootNum+0.44*T_freeThrowNum+T_turnoverNum);
			 }
			 /*String season,String date,String name,String p,String time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int steal,int blockNum,int turnoverNum,
			 int foulNum,int points, double assistEfficiency,
			 double reboundEfficiency,double offensiveReboundEff,
			 double defenseReboundEff,double stealEfficiency,
			 double usingPercentage,double blockEfficiency*/
			 
			 SingleMatchPersonalDataVO vo=new SingleMatchPersonalDataVO(season, date,
					 po.getPlayerName(),team,po.getPlayerPosition(), 
					 po.getTime(),po.getFieldGoal(), po.getShootNum()
					 , po.getT_fieldGoal(), po.getT_shootNum(), 
					 po.getFreeThrowGoalNum(), po.getFreeThrowNum(),
					 po.getO_ReboundNum(), po.getD_ReboundNum(),
					 po.getReboundNum(), po.getAssistNum(), 
					 po.getStealNum(), po.getBlockNum(),
					 po.getTurnoverNum(), po.getFoulNum(), po.getPoints(),
					 assistEff, reboundEff, offensiveReboundEff,
					 defenseReboundEff, stealEff, usingPer, blockEff);
			 result.add(vo);
			 
		 }
		
		return result;
	}

	
	@Override
	public ArrayList<String> getMatchByTeamTime(String time, String team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MatchVO getMatchByTeam(String time, String teamA, String teamB) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
