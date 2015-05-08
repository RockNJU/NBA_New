package com.nba;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import UI.blObject.RMIObject;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import VO.TeamSeasonDataVO;
import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import businessService.blservice.TeamBLService;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2015年4月29日 下午8:45:52
 * @version 1.0
 * @parameter
 * @since
 * @return
 */

@CmdCommand(names = { "-team", "-t" }, description = "show team information")
public class Team {
	private boolean isShowTotal = false;
	private boolean isHighInfo = false;
	private boolean hasAll = false;
	private boolean isHot = false;
	private boolean hasSort = false;
	private String default_n = "score.desc";
	private String default_h = "winRate.desc";
	public ArrayList<?> finalResult;

	private int num = 30;

	@CmdOption(names = { "-print" }, description = "return the result", maxCount = 1, minCount = 0)
	public void setPrintResult() {
		
		
		if(isHot&&num==30){
			num=5;
		}else if(!isHot&&!hasSort){
			if(isHighInfo){
				setSortValue(default_h);;
			}else{
				setSortValue(default_n);;
			}
			
		}
		if(finalResult.size()<num){
			num = finalResult.size();
		}
		for(int i=finalResult.size()-1;i>=num;i--){
			finalResult.remove(i);
		}
		setAllBoolean();
		new AnalyseCmdOption().setResult(finalResult);
	}
	
	
	private void setAllBoolean(){
		isShowTotal = false;
		isHighInfo = false;
		isHot = false;
		hasAll = false;
		hasSort = false;
	}
	@CmdOption(names = { "-total" }, description = "show total", maxCount = 1, minCount = 0)
	public void setShowTotal() {
		this.isShowTotal = true;
	}

	@CmdOption(names = { "-avg" }, description = "show average", maxCount = 1, minCount = 0)
	public void setShowAvg() {
		this.isShowTotal = false;
	}

	@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
	public void setNum(String filed) {
		this.num = Integer.parseInt(filed);
	}
	public int getNum() {
		return num;
	}

	@CmdOption(names = { "-all" }, description = "show all player information", maxCount = 1, minCount = 0, conflictsWith = {
			"-hot" })
	public void setAllPlayer() {
		this.hasAll = true;
	}

	@CmdOption(names = { "-hot" }, description = "show hot player", maxCount = 1, minCount = 0, args = { "field" }, conflictsWith = {
			"-all", "-avg", "-total", "-sort" })
	public void setHotTeam(String field) {
    
		isHot = true;
		RMIObject object = new RMIObject();
		TeamBLService tbls = object.getTeamObject();
		SortItem_Map_Team sortItem = new SortItem_Map_Team();
		ArrayList<TeamHotInfo> result = new ArrayList<TeamHotInfo>();
		ArrayList<TeamSeasonDataVO> initialResult = new ArrayList<TeamSeasonDataVO>();
		initialResult = tbls.getHotTeam(sortItem.getItem(field));

		for (int count = 0; count < initialResult.size(); count++) {
			TeamHotInfo hotTeam = new TeamHotInfo();
			hotTeam.setField(field);
			hotTeam.setLeague(initialResult.get(count).getLeague());
			hotTeam.setTeamName(initialResult.get(count).getTeamName());
			switch (field) {
			case ("score"):
			    hotTeam.setValue(initialResult.get(count).getPointNum_avg());
				break;
			case ("rebound"):
			    hotTeam.setValue(initialResult.get(count).getReboundNum_avg());
				break;
			case ("assist"):
			    hotTeam.setValue(initialResult.get(count).getAssistNum_avg());
				break;
			case ("blockShot"):
			    hotTeam.setValue(initialResult.get(count).getBlockNum_avg());
				break;
			case ("steal"):
			    hotTeam.setValue(initialResult.get(count).getStealNum_avg());
				break;
			case ("foul"):
			    hotTeam.setValue(initialResult.get(count).getFoulNum_avg());
				break;
			case ("fault"):
			    hotTeam.setValue(initialResult.get(count).getTurnoverNum_avg());
				break;
			case ("shot"):
			    hotTeam.setValue(initialResult.get(count).getShootPercentage());
				break;
			case ("three"):
			    hotTeam.setValue(initialResult.get(count).getT_shootPercentage());
				break;
			case ("penalty"):
			    hotTeam.setValue(initialResult.get(count).getFreeThrowPercentage());
				break;
			case ("defendRound"):
			    hotTeam.setValue(initialResult.get(count).getD_ReboundNum_avg());
				break;
			case ("offendRound"):
			    hotTeam.setValue(initialResult.get(count).getO_ReboundNum_avg());

			}// end switch
			result.add(hotTeam);
		}
		finalResult = result;
		
	}

	@CmdOption(names = { "-high" }, description = "show high information of player", maxCount = 1, minCount = 0, conflictsWith = {
			"-avg", "-total", "-all", "-hot" })
	public void setHighInfo() {
		this.isHighInfo = true;
	}

	@CmdOption(names = { "-sort" }, description = "show sorted player information ", maxCount = 1, minCount = 0, args = { "field" },
			conflictsWith = {"-hot"})
	public void setSortValue(String field) {

		hasSort = true;
		if(field==null){
			if(isHighInfo){
				field = default_h;
			}else{
				field = default_n;
			}
			
		}
		RMIObject object = new RMIObject();
		SortItem_Map_Team sortItem = new SortItem_Map_Team();
		TeamBLService tbls = object.getTeamObject();
		ArrayList<TeamNormalInfo> resultN = new ArrayList<TeamNormalInfo>();
		ArrayList<TeamHighInfo> resultH = new ArrayList<TeamHighInfo>();
		ArrayList<TeamSeasonDataVO> initialResult = new ArrayList<TeamSeasonDataVO>();
		String[] fieldList = field.split(",|，");
		boolean[] reverse = new boolean[fieldList.length];
		String[] condition = new String[fieldList.length];
		for (int i = 0; i < fieldList.length; i++) {
			condition[i] = sortItem.getItem(fieldList[i].split(".|。")[0]);
			if (fieldList[i].split(".|。")[1].equals("desc")) { // 降序
				reverse[i] = false;
			} else {
				reverse[i] = true;
			}

		}// end for

		initialResult = tbls.sort(fieldList, reverse);
		if (isHighInfo) {
			for (int i = 0; i < initialResult.size(); i++) {
				TeamHighInfo high = new TeamHighInfo();
				TeamSeasonDataVO ts = initialResult.get(i);
	            high.setAssistEfficient(ts.getAssistEfficiency_avg());
	            high.setDefendEfficient(ts.getDefenseEfficiency_avg());
	            high.setDefendReboundEfficient(ts.getD_ReboundEfficiency_avg());
	            high.setOffendEfficient(ts.getOffenseEfficiency_avg());
	            high.setOffendReboundEfficient(ts.getO_ReboundEfficiency_avg());
	            high.setOffendRound(ts.getOffenseRound_avg());
	            high.setStealEfficient(ts.getStealEfficiency_avg());
	            high.setTeamName(ts.getTeamName());
	            high.setWinRate(ts.getWinRate());

				resultH.add(high);
			}
		} else {
			TeamNormalInfo normal = new TeamNormalInfo();
			if (isShowTotal) {
				for (int i = 0; i < initialResult.size(); i++) {
					TeamSeasonDataVO ts = initialResult.get(i);
					normal.setAssist(ts.getAssistNum());
					normal.setBlockShot(ts.getBlockNum());
					normal.setDefendRebound(ts.getD_ReboundNum());
					normal.setFault(ts.getTurnoverNum());
					normal.setFoul(ts.getFoulNum());
					normal.setNumOfGame(ts.getMatchNum());
					normal.setOffendRebound(ts.getO_ReboundNum());
					normal.setPenalty(ts.getFreeThrowPercentage());
					normal.setPoint(ts.getPointNum());
					normal.setRebound(ts.getReboundNum());
					normal.setShot(ts.getShootPercentage());
					normal.setSteal(ts.getStealNum());
					normal.setTeamName(ts.getTeamName());
					normal.setThree(ts.getT_shootPercentage());

					resultN.add(normal);
				}

			} else {
				for (int i = 0; i < initialResult.size(); i++) {
					TeamSeasonDataVO ts = initialResult.get(i);
					normal.setAssist(ts.getAssistNum_avg());
					normal.setBlockShot(ts.getBlockNum_avg());
					normal.setDefendRebound(ts.getD_ReboundNum_avg());
					normal.setFault(ts.getTurnoverNum_avg());
					normal.setFoul(ts.getFoulNum_avg());
					normal.setNumOfGame(ts.getMatchNum());
					normal.setOffendRebound(ts.getO_ReboundNum_avg());
					normal.setPenalty(ts.getFreeThrowPercentage());
					normal.setPoint(ts.getPointNum_avg());
					normal.setRebound(ts.getReboundNum_avg());
					normal.setShot(ts.getShootPercentage());
					normal.setSteal(ts.getStealNum_avg());
					normal.setTeamName(ts.getTeamName());
					normal.setThree(ts.getT_shootPercentage());

					resultN.add(normal);
				}
			}

		}

		if (isHighInfo) {
			finalResult = resultH;
		} else {
			finalResult = resultN;
		}
	}
}
