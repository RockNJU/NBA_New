package businesslogic.bl;
 
import java.util.ArrayList;

import businesslogic.PO.MatchPO;
import businesslogic.PO.SingleMatchPersonalDataPO;
import businesslogic.PO.TeamMatchPO;
import businesslogic.data.MatchDataController;
import businesslogic.dataservice.MatchDataService;
import VO.MatchVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamMatchVO;



public class MatchController implements  businessService.blservice.MatchBLService{

	
	 
	
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

	/*
	 * 
	 * ***************************
	 * 
	 * */
	
	//--------------------------


	public static TeamMatchVO hostTeam, tempHost = new TeamMatchVO(null,null, 0,0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, null);
	public static TeamMatchVO guestTeam, tempGuest = new TeamMatchVO(null, null,0,0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, null); // tempHost      tempGuest                      §Þ        
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("starts here!");

	}


	public ArrayList<MatchVO> getAllMatchVO() {
		ArrayList<MatchVO> result=new ArrayList<MatchVO>();
		MatchController c=new MatchController();
		MatchDataService mds = new MatchDataController();
		ArrayList<MatchPO> list= mds.getAllMatch();
		for(int i=0;i<list.size();i++){
		result.add(c.matchPOToVO(list.get(i)));
		}
		return result;
	}

	//     matchpo                              matchvo
	public MatchVO matchPOToVO(MatchPO po) {	
		String score[]=po.getMatchScore().split("-");
		int H_winNum,G_winNum;
		if(score[0].compareTo(score[1])>0){
			H_winNum=1;
			G_winNum=0;
		}else{
			H_winNum=0;
			G_winNum=1;
		}
		calculateNum(po.getHostTeam(), "host",po.getDate(),H_winNum);
		calculateNum(po.getGuestTeam(), "guest",po.getDate(),G_winNum);
		calOffenseRound("host");
		calOffenseRound("guest");
	
		
		
		this.hostTeam = TeamMatchPOtoVO(po.getSeason(),tempHost, "host",H_winNum);
		this.guestTeam = TeamMatchPOtoVO(po.getSeason(),tempGuest, "guest",G_winNum);
		MatchVO vo = new MatchVO(po.getSeason(),po.getDate(), po.getMatchScore(),
				po.getScores(), hostTeam, guestTeam);
		return vo;

	}

	//     teamMatchPO          TeamMatchVO
	private TeamMatchVO TeamMatchPOtoVO(String season,TeamMatchVO vo, String role,int winNum) {

		double offenseRound = vo.getOffenseRound(); //         
		double defenseRound = 0; //             

		double freeThrowPercentage = 0; //                     
		double threePointPercentage = 0; //                   
		double shootPercentage = 0; //                   
		double assistEfficiency = 0; //         
		double O_ReboundEfficiency = 0; //                 
		double D_ReboundEfficiency = 0; //                     
		double stealEfficiency = 0; //             
		double defenseEfficiency = 0; //         
		double offenseEfficiency = 0; //       

		if (role.equals("host")) {
			vo.setDefenseRound(tempGuest.getOffenseRound());
			O_ReboundEfficiency = (double)vo.getO_ReboundNum()
					/ (vo.getO_ReboundNum() + tempGuest.getD_ReboundNum()); //                 
			D_ReboundEfficiency = (double)vo.getD_ReboundNum()
					/ (vo.getD_ReboundNum() + tempGuest.getO_ReboundNum()); //                     
		} else if (role.equals("guest")) {
			vo.setDefenseRound(tempHost.getOffenseRound());
			O_ReboundEfficiency = (double)vo.getO_ReboundNum()
					/ (vo.getO_ReboundNum() + tempHost.getD_ReboundNum()); //                 
			D_ReboundEfficiency = (double)vo.getD_ReboundNum()
					/ (vo.getD_ReboundNum() + tempHost.getO_ReboundNum()); //                     
		}

		freeThrowPercentage = (double)vo.getFreeThrowGoalNum() / vo.getFreeThrowNum(); //                     
		threePointPercentage = (double)vo.getT_fieldGoal() / vo.getT_shootNum(); //                   
		shootPercentage =(double) vo.getFieldGoal() / vo.getShootNum(); //                   
		assistEfficiency = (double)vo.getAssistNum() / vo.getOffenseRound() * 100; //         

		offenseEfficiency = (double)vo.getPointNum() / vo.getOffenseRound() * 100; //         
	//	System.out.println(offenseEfficiency+"   cal offenseRate");
		//System.out.println(vo.getPointNum()+"   pointNum");
		//System.out.println(vo.getOffenseRound()+"  offenseRound");
		stealEfficiency = (double)vo.getStealNum() / vo.getDefenseRound() * 100; //             
		defenseEfficiency = (double)vo.getPointNum() / vo.getDefenseRound() * 100; //             

		TeamMatchVO matchvo = new TeamMatchVO(season,vo.getTeamName(),winNum,
				vo.getPointNum(), vo.getDefenseNum(), vo.getOffenseNum(),
				vo.getReboundNum(), vo.getO_ReboundNum(), vo.getD_ReboundNum(),
				vo.getAssistNum(), vo.getTurnoverNum(), vo.getStealNum(),
				vo.getFoulNum(), vo.getFieldGoal(), vo.getShootNum(),
				vo.getT_fieldGoal(), vo.getT_shootNum(),
				vo.getFreeThrowGoalNum(), vo.getFreeThrowNum(),
				vo.getBlockNum(), offenseRound, defenseRound,
				freeThrowPercentage, threePointPercentage, shootPercentage,
				assistEfficiency, O_ReboundEfficiency, D_ReboundEfficiency,
				stealEfficiency, defenseEfficiency, offenseEfficiency,
				vo.getIndividualData());
		return matchvo;

	}

	private void calculateNum(TeamMatchPO po, String role,String date,int winNum) {
		ArrayList<SingleMatchPersonalDataPO> individualData = po
				.getIndividualData();
		ArrayList<SingleMatchPersonalDataVO> singleData = new ArrayList<SingleMatchPersonalDataVO>(
				individualData.size());
		String season=po.getSeason();
		//String date=po.getd
		
		for (int i = 0; i < individualData.size(); i++) {
			/*String season,String date,String name,String p,String time,int fieldGoal,
			 int shootNum,int T_fieldGoal,int T_shootNum,int freeThrowGoalNum,int freeThrowNum,
			 int O_R_N,int D_R_N,int reboundNum,int assistNum,int steal,int blockNum,int turnoverNum,
			 int foulNum,int points*/
				
			singleData.add(new SingleMatchPersonalDataVO(season,date,individualData.get(i)
					.getPlayerName(),
					individualData.get(i).getPlayerPosition(), individualData
							.get(i).getTime(), individualData.get(i)
							.getFieldGoal(), individualData.get(i)
							.getShootNum(), individualData.get(i)
							.getT_fieldGoal(), individualData.get(i)
							.getT_shootNum(), individualData.get(i)
							.getFreeThrowGoalNum(), individualData.get(i)
							.getFreeThrowNum(), individualData.get(i)
							.getO_ReboundNum(), individualData.get(i)
							.getD_ReboundNum(), individualData.get(i)
							.getReboundNum(), individualData.get(i)
							.getAssistNum(), individualData.get(i)
							.getStealNum(),
					individualData.get(i).getBlockNum(), individualData.get(i)
							.getTurnoverNum(), individualData.get(i)
							.getFoulNum(), individualData.get(i).getPoints()));
		}// end for
			//         

		int points = 0; //   ¡Â  
		int defenseNum = 0; //             
		int offenseNum = 0; //         
		int reboundNum = 0; //                 
		int O_ReboundNum = 0; //                           
		int D_ReboundNum = 0; //                      
		int assistNum = 0; //         
		int turnoverNum = 0; //          
		int stealNum = 0; //             
		int foulNum = 0; //             
		int fieldGoal = 0; //                   
		int shootNum = 0; //                   
		int T_fieldGoal = 0; //                       
		int T_shootNum = 0; //                     
		int freeThrowGoalNum = 0; //                     
		int freeThrowNum = 0; //                   
		int blockNum = 0; //           

		int playerNum = singleData.size(); // number of players in the team
		for (int i = 0; i < playerNum; i++) {
			//             
			points = points + singleData.get(i).getPoints();
			defenseNum = defenseNum + singleData.get(i).getD_ReboundNum();
			offenseNum = offenseNum + singleData.get(i).getO_ReboundNum();
			reboundNum = reboundNum + singleData.get(i).getReboundNum();
			O_ReboundNum = O_ReboundNum + singleData.get(i).getO_ReboundNum();
			D_ReboundNum = D_ReboundNum + singleData.get(i).getD_ReboundNum();
			assistNum = assistNum + singleData.get(i).getAssistNum();
			turnoverNum = turnoverNum + singleData.get(i).getTurnoverNum();
			stealNum = stealNum + singleData.get(i).getStealNum();
			foulNum = foulNum + singleData.get(i).getFoulNum();
			fieldGoal = fieldGoal + singleData.get(i).getFieldGoal();
			T_fieldGoal = T_fieldGoal + singleData.get(i).getT_fieldGoal();
			T_shootNum = T_shootNum + singleData.get(i).getT_shootNum();
			freeThrowGoalNum = freeThrowGoalNum
					+ singleData.get(i).getFreeThrowGoalNum();
			freeThrowNum = freeThrowNum + singleData.get(i).getFreeThrowNum();
			blockNum = blockNum + singleData.get(i).getBlockNum();

		}// end for

		if (role.equals("host")) {
			tempHost = new TeamMatchVO(season,po.getTeamName(),winNum, points, defenseNum,
					offenseNum, reboundNum, O_ReboundNum, D_ReboundNum,
					assistNum, turnoverNum, stealNum, foulNum, fieldGoal,
					shootNum, T_fieldGoal, T_shootNum, freeThrowGoalNum,
					freeThrowNum, blockNum, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					singleData);
		} else if (role.equals("guest")) {
			tempGuest = new TeamMatchVO(season,po.getTeamName(), winNum,points, defenseNum,
					offenseNum, reboundNum, O_ReboundNum, D_ReboundNum,
					assistNum, turnoverNum, stealNum, foulNum, fieldGoal,
					shootNum, T_fieldGoal, T_shootNum, freeThrowGoalNum,
					freeThrowNum, blockNum, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					singleData);
		}
	}

	private void calOffenseRound(String role) {
		if (role.equals("host")) {
			
			
			double offenseRound = (double)(tempHost.getShootNum()
					+ 0.4
					* tempHost.getFreeThrowNum()
					- 1.07
					* (tempHost.getO_ReboundNum()
							/ (tempHost.getO_ReboundNum() + tempGuest
									.getD_ReboundNum()) * (tempHost
							.getShootNum() - tempHost.getFieldGoal())) + 1.07
					* tempHost.getTurnoverNum());
			//System.out.println(offenseRound+"   host~~");
			tempHost.setOffenseRound(offenseRound);
			tempGuest.setDefenseRound(offenseRound);
		} else if (role.equals("guest")) {
		
			double offenseRound = (double)(tempGuest.getShootNum()
					+ 0.4
					* tempGuest.getFreeThrowNum()
					- 1.07
					* (tempGuest.getO_ReboundNum()
							/ (tempGuest.getO_ReboundNum() + tempHost
									.getD_ReboundNum()) * (tempGuest
							.getShootNum() - tempGuest.getFieldGoal())) + 1.07
					* tempGuest.getTurnoverNum());
			tempGuest.setOffenseRound(offenseRound);
			tempHost.setDefenseRound(offenseRound);
		
			
			//System.out.println(offenseRound+"   guest~~");
		}
	}
	
	
}
