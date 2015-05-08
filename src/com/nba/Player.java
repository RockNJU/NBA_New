package com.nba;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import UI.blObject.RMIObject;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
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

@CmdCommand(names = { "-player", "-p" }, description = "show player information")
public class Player {
	private boolean isShowTotal = false;
	private boolean isHighInfo = false;
	private boolean hasAll = false;
	private boolean isKingOrHot = false;
	private String kingField;
	private boolean hasSort = false;
	private String default_p = "All";
	private String default_l = "All";
	private String default_a = "All";
	private String default_s = "score.desc";
	public ArrayList<?> finalResult;

	private int num = 50;

	@CmdOption(names = { "-print" }, description = "return the result", maxCount = 1, minCount = 0)
	public void setPrintResult() {
		
		if(isKingOrHot&&num==50){
			num=5;
		}else if(!isKingOrHot&&!hasSort){
			setSortValue("score.desc");
		}
		
		if(finalResult.size()<num){
			num = finalResult.size();
		}
		for(int i=finalResult.size()-1;i>=num;i--){
			finalResult.remove(i);
		}
		new AnalyseCmdOption().setResult(finalResult);
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
			"-hot", "-king" })
	public void setAllPlayer() {
		this.hasAll = true;
	}

	@CmdOption(names = { "-hot" }, description = "show hot player", maxCount = 1, minCount = 0, args = { "field" }, conflictsWith = {
			"-all", "-king", "-avg", "-total", "-filter", "-sort" })
	public void setHotPlayer(String field) {
    
		isKingOrHot = true;
		RMIObject object = new RMIObject();
		PlayerBLService pbls = object.getPlayerObject();
		ArrayList<PlayerHotInfo> result = new ArrayList<PlayerHotInfo>();
		ArrayList<PlayerSeasonDataVO> initialResult = new ArrayList<PlayerSeasonDataVO>();
		switch (field) {
		
		case ("score"):
			initialResult = pbls.getMost_Progress_Player("l_f_point_rate", num);
			break;
		case ("rebound"):
			initialResult = pbls.getMost_Progress_Player("l_f_rebound_rate",
					num);
			break;
		case ("assist"):
			initialResult = pbls
					.getMost_Progress_Player("l_f_assist_rate", num);
			break;
		}// end switch

		for (int count = 0; count < initialResult.size(); count++) {
			PlayerHotInfo hotPlayer = new PlayerHotInfo();
			hotPlayer.setField(field);
			hotPlayer.setName(initialResult.get(count).getName());
			hotPlayer.setPosition(initialResult.get(count).getPosition());
			hotPlayer.setTeamName(initialResult.get(count).getTeamName());
			switch (field) {
			case ("score"):
				hotPlayer.setUpgradeRate(initialResult.get(count)
						.getL_f_point_rate());
				hotPlayer.setValue(initialResult.get(count).getPointNum_avg());
				break;
			case ("rebound"):
				hotPlayer.setUpgradeRate(initialResult.get(count)
						.getL_f_rebound_rate());
				hotPlayer
						.setValue(initialResult.get(count).getReboundNum_avg());
				break;
			case ("assist"):
				hotPlayer.setUpgradeRate(initialResult.get(count)
						.getL_f_assist_rate());
				hotPlayer.setValue(initialResult.get(count).getAssistNum_avg());
				break;
			}// end switch
			result.add(hotPlayer);
		}
		hasSort = false;
		finalResult = result;
		
	}

	@CmdOption(names = { "-king" }, description = "show player king", maxCount = 1, minCount = 0, args = { "field" }, conflictsWith = {
			"-all", "-hot", "-avg", "-total", "-filter", "-sort" })
	public void setPlayerKing(String field) {
		isKingOrHot = true;
		this.kingField = field;
	}

	@CmdOption(names = { "-season" }, description = "show season player king", maxCount = 1, minCount = 0, requires = { "-king" }, conflictsWith = { "-daily" })
	public void setSeasonPlayerKing() {
		isKingOrHot = true;
		RMIObject object = new RMIObject();
		PlayerBLService pbls = object.getPlayerObject();
		ArrayList<PlayerKingInfo> result = new ArrayList<PlayerKingInfo>();
		ArrayList<PlayerSeasonDataVO> initialResult = new ArrayList<PlayerSeasonDataVO>();
		switch (kingField) {
		case ("score"):
			initialResult = pbls.getSeasonHotPlayer("pointNum_avg",num);
			break;
		case ("rebound"):
			initialResult = pbls.getSeasonHotPlayer("reboundNum_avg",num);
			break;
		case ("assist"):
			initialResult = pbls.getSeasonHotPlayer("assistNum_avg",num);
			break;

		}
		for (int count = 0; count < initialResult.size(); count++) {
			PlayerKingInfo kingPlayer = new PlayerKingInfo();
			kingPlayer.setField(kingField);
			kingPlayer.setName(initialResult.get(count).getName());
			kingPlayer.setPosition(initialResult.get(count).getPosition());
			kingPlayer.setTeamName(initialResult.get(count).getTeamName());
			switch (kingField) {
			case ("score"):
				kingPlayer.setValue(initialResult.get(count).getPointNum_avg());
				break;
			case ("rebound"):
				kingPlayer.setValue(initialResult.get(count)
						.getReboundNum_avg());
				break;
			case ("assist"):
				kingPlayer
						.setValue(initialResult.get(count).getAssistNum_avg());
				break;
			}// end switch
			result.add(kingPlayer);
		}
		hasSort = false;
		finalResult = result;
	}

	@CmdOption(names = { "-daily" }, description = "show daily player king", maxCount = 1, minCount = 0, requires = { "-king" }, conflictsWith = { "-season" })
	public void setDailyPlayerKing() {

		isKingOrHot = true;
		RMIObject object = new RMIObject();
		MatchBLService mbls = object.getMatchObject();
		ArrayList<PlayerKingInfo> result = new ArrayList<PlayerKingInfo>();
		ArrayList<SingleMatchPersonalDataVO> initialResult = new ArrayList<SingleMatchPersonalDataVO>();
		switch (kingField) {
		case ("score"):
			initialResult = mbls.getTodayHotPlayer("pointNum");
			break;
		case ("rebound"):
			initialResult = mbls.getTodayHotPlayer("reboundNum");
			break;
		case ("assist"):
			initialResult = mbls.getTodayHotPlayer("assistNum");
			break;

		}
		for (int count = 0; count < initialResult.size(); count++) {
			PlayerKingInfo kingPlayer = new PlayerKingInfo();
			kingPlayer.setField(kingField);
			kingPlayer.setName(initialResult.get(count).getPlayerName());
			kingPlayer
					.setPosition(initialResult.get(count).getPlayerPosition());
			kingPlayer.setTeamName(initialResult.get(count).getTeamName());
			switch (kingField) {
			case ("score"):
				kingPlayer.setValue(initialResult.get(count).getPointNum());
				break;
			case ("rebound"):
				kingPlayer.setValue(initialResult.get(count).getReboundNum());
				break;
			case ("assist"):
				kingPlayer.setValue(initialResult.get(count).getAssistNum());
				break;
			}// end switch
			result.add(kingPlayer);
		}
		hasSort = false;
		finalResult = result;
	}



	@CmdOption(names = { "-high" }, description = "show high information of player", maxCount = 1, minCount = 0, conflictsWith = {
			"-avg", "-total", "-all", "-hot", "-king", "-filter" })
	public void setHighInfo() {
		this.isHighInfo = true;
	}

	@CmdOption(names = { "-filter" }, description = "show filtered player information ", maxCount = 1, minCount = 0, args = { "field" }, conflictsWith = { "-sort" })
	public void setFilterValue(String field) {
		String[] fieldList = field.split(",|，");
		for (int i = 0; i < fieldList.length; i++) {
			String f = fieldList[i].split(".|.")[0];
			String v = fieldList[i].split(".|.")[1];
			switch (f) {
			case ("position"):
				default_p = v;
				break;
			case ("league"):
				default_l = v;
				break;
			case ("age"):
				default_a = v;
				break;
			}
		}// end for

	}

	@CmdOption(names = { "-sort" }, description = "show sorted player information ", maxCount = 1, minCount = 0, args = { "field" })
	public void setSortValue(String field) {

		hasSort = true;
		if(field==null){
			field = default_s;
		}
		RMIObject object = new RMIObject();
		SortItem_Map_PlayerHigh sortItem = new SortItem_Map_PlayerHigh();
		PlayerBLService pbls = object.getPlayerObject();
		ArrayList<PlayerNormalInfo> resultN = new ArrayList<PlayerNormalInfo>();
		ArrayList<PlayerHighInfo> resultH = new ArrayList<PlayerHighInfo>();
		ArrayList<PlayerSeasonDataVO> initialResult = new ArrayList<PlayerSeasonDataVO>();
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

		initialResult = pbls.getSortInfo(default_p, default_l, default_a,
				fieldList, reverse);
		if (initialResult.size() > num) {
			initialResult = (ArrayList<PlayerSeasonDataVO>) initialResult
					.subList(0, num);
		}
		if (isHighInfo) {
			for (int i = 0; i < initialResult.size(); i++) {
				PlayerHighInfo high = new PlayerHighInfo();
				PlayerSeasonDataVO ps = initialResult.get(i);
				high.setAssistEfficient(ps.getAssistEfficiency_avg());
				high.setBlockShotEfficient(ps.getBlockEfficiency_avg());
				high.setDefendReboundEfficient(ps.getDefenseReboundEff_avg());
				high.setFaultEfficient(ps.getTurnoverPercentage());
				high.setFrequency(ps.getUsingPercentage_avg());
				high.setGmSc(ps.getGmSc());
				high.setLeague(ps.get);
				high.setName(ps.getName());
				high.setOffendReboundEfficient(ps.getOffensiveReboundEff_avg());
				high.setPosition(ps.getPosition());
				high.setRealShot(ps.getRealShootPercentage());
				high.setReboundEfficient(ps.getReboundEfficiency_avg());
				high.setShotEfficient(ps.getShootEfficiency());
				high.setStealEfficient(ps.getStealEfficiency_avg());
				high.setTeamName(ps.getTeamName());

				resultH.add(high);
			}
		} else {
			PlayerNormalInfo normal = new PlayerNormalInfo();
			if (isShowTotal) {
				for (int i = 0; i < initialResult.size(); i++) {
					PlayerSeasonDataVO ps = initialResult.get(i);
					normal.setAge(ps.getAge());
					normal.setAssist(ps.getAssistNum());
					normal.setBlockShot(ps.getBlockNum());
					normal.setDefend(ps.getDefend());
					normal.setEfficiency(ps.getEfficiency());
					normal.setFault(ps.getTurnoverNum());
					normal.setFoul(ps.getFoulNum());
					normal.setMinute(ps.getTime());
					normal.setName(ps.getName());
					normal.setNumOfGame(ps.getMatchNum());
					normal.setOffend(ps.getOffend());
					normal.setPenalty(ps.getFreeThrowPercentage());
					normal.setPoint(ps.getPointNum());
					normal.setRebound(ps.getReboundNum());
					normal.setShot(ps.getShootPercentage());
					normal.setStart(ps.getStartingNum());
					normal.setSteal(ps.getStealNum());
					normal.setTeamName(ps.getTeamName());
					normal.setThree(ps.getT_shootPercentage());

					resultN.add(normal);
				}

			} else {
				for (int i = 0; i < initialResult.size(); i++) {
					PlayerSeasonDataVO ps = initialResult.get(i);
					normal.setAge(ps.getAge());
					normal.setAssist(ps.getAssistNum_avg());
					normal.setBlockShot(ps.getBlockNum_avg());
					normal.setDefend(ps.getDefend_avg());
					normal.setEfficiency(ps.getEfficiency());
					normal.setFault(ps.getTurnoverNum_avg());
					normal.setFoul(ps.getFoulNum_avg());
					normal.setMinute(ps.getTime_avg());
					normal.setName(ps.getName());
					normal.setNumOfGame(ps.getMatchNum());
					normal.setOffend(ps.getOffend_avg());
					normal.setPenalty(ps.getFreeThrowPercentage());
					normal.setPoint(ps.getPointNum_avg());
					normal.setRebound(ps.getReboundNum_avg());
					normal.setShot(ps.getShootPercentage());
					normal.setStart(ps.getStartingNum());
					normal.setSteal(ps.getStealNum_avg());
					normal.setTeamName(ps.getTeamName());
					normal.setThree(ps.getT_shootPercentage());

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
