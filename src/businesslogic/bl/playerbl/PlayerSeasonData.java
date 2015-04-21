package businesslogic.bl.playerbl;

import java.util.ArrayList;

import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;

public class PlayerSeasonData {
	String season;
	ArrayList<PlayerSeasonDataVO> playerDataList;  //������Ա�ı�������
	
	public PlayerSeasonData(String season){
		this.season=season;
		playerDataList=new ArrayList<>();
	}

	public String getSeason() {
		return season;
	}
    
	public void updatePlayerSeasonData(SingleMatchPersonalDataVO vo){
		int i;
		for( i=0;i<playerDataList.size();i++){
			System.out.println("�������֣�"+playerDataList.get(i).getName()+"�¼����֣�"+vo.getPlayerName());
			if(playerDataList.get(i).getName().equals(vo.getPlayerName())){
				playerDataList.get(i).add_A_MatchData(vo);
				playerDataList.get(i).setTeamName(vo.getTeamName());
				playerDataList.get(i).setDivision(vo.getDivision());
				playerDataList.get(i).setPartition(vo.getPartition());
				return;
				//����Ա�����ݲֿ����Ѿ��������Ӧ��������Ϣʱ����������Ϣ��
			}
		}
		
		System.out.println("��ӵ�  "  +playerDataList.size()+ "  ����Ա ��");
		//����Ա��������Ϣû�д������ݲֿ��е�ʱ���������������
		int startingNum=0;
		int seasonDoubleNum=0;
		int seasonThreeNum=0;
		if(vo.getPlayerPosition()!=null&vo.getPlayerPosition().length()!=0){
			startingNum=1;
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
		 seasonThreeNum++;   //������˫��
		 }
		 
		 if(vo.getPlayerPosition()!=null&vo.getPlayerPosition().length()!=0)
		 startingNum++;
		
		PlayerSeasonDataVO newData=new PlayerSeasonDataVO(season,vo.getPlayerName(),vo.getTeamName(),vo.getDivision(),
				vo.getPartition(),vo.getPlayerPosition(),1,startingNum,vo.getTime(),
				vo.getFieldGoal(),vo.getShootNum(),vo.getT_fieldGoal(),vo.getT_shootNum(),
				vo.getFreeThrowGoalNum(),vo.getFreeThrowNum(),vo.getO_ReboundNum(),
				vo.getD_ReboundNum(),vo.getReboundNum(),
				vo.getAssistNum(),vo.getStealNum(),vo.getBlockNum(),vo.getTurnoverNum(),
				vo.getFoulNum(),vo.getPoints(),vo.getAssistEfficiency(),vo.getReboundEfficiency(),
				vo.getOffensiveReboundEff(),vo.getDefenseReboundEff(),
				vo.getStealEfficiency(),vo.getUsingPercentage(),
				vo.getBlockEfficiency(),seasonDoubleNum,seasonThreeNum);
		playerDataList.add(newData);
		
	}
	
	public void setSeason(String season) {
		this.season = season;
	}

	public ArrayList<PlayerSeasonDataVO> getPlayerDataList() {
		return playerDataList;
	}

	public void setPlayerDataList(ArrayList<PlayerSeasonDataVO> playerDataList) {
		this.playerDataList = playerDataList;
	}
}
