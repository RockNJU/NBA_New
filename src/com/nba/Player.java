package com.nba;

import java.util.ArrayList;

import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import UI.blObject.RMIObject;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import de.tototec.cmdoption.CmdCommand;
import de.tototec.cmdoption.CmdOption;

/** 
 * @author  作者 E-mail: 
 * @date 创建时间：2015年4月29日 下午8:45:52 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */

@CmdCommand(names = { "-player","-p" }, description = "show player information")
public class Player  {
	private boolean isShowTotal = false;
	private boolean isHighInfo = false;
	private boolean hasAll = false;
	private String kingField;
	private boolean hasFilter = false;
	private boolean hasSort = false;
	
	private int num = 50;

	@CmdOption(names = { "-total" }, description = "show total", maxCount = 1, minCount = 0)
	public void setShowTotal() {
		this.isShowTotal = true;
	}
	
	@CmdOption(names = { "-avg" }, description = "show average", maxCount = 1, minCount = 0)
	public void setShowAvg() {
		this.isShowTotal = false;
	}

	public int getNum() {
		return num;
	}
	
	@CmdOption(names = { "-all" }, description = "show all player information", maxCount = 1, minCount = 0,
			conflictsWith = {"-hot","-king"})
	public void setAllPlayer(){
		this.hasAll = true;
	}
	
	@CmdOption(names = { "-hot" }, description = "show hot player", maxCount = 1, minCount = 0,
			args = {"field"},conflictsWith = {"-all","-king","-avg","-total","-filter","-sort"})
	public void setHotPlayer(String field){
		
		RMIObject object = new RMIObject();
		PlayerBLService pbls = object.getPlayerObject();
		ArrayList<PlayerHotInfo> result = new ArrayList<PlayerHotInfo>();
		ArrayList<PlayerSeasonDataVO> initialResult = new ArrayList<PlayerSeasonDataVO>();
		switch(field){
		case("score"):
			initialResult = pbls.getMost_Progress_Player("l_f_point_rate",num);
			break;
		case("rebound"):
			initialResult = pbls.getMost_Progress_Player("l_f_rebound_rate",num);
			break;
		case("assist"):
			initialResult = pbls.getMost_Progress_Player("l_f_assist_rate",num);
			break;
		}// end switch
		
		for(int count=0;count<initialResult.size();count++){
			PlayerHotInfo hotPlayer = new PlayerHotInfo();
			hotPlayer.setField(field);
			hotPlayer.setName(initialResult.get(count).getName());
			hotPlayer.setPosition(initialResult.get(count).getPosition());
			hotPlayer.setTeamName(initialResult.get(count).getTeamName());
			switch(field){
			case("score"):
				hotPlayer.setUpgradeRate(initialResult.get(count).getL_f_point_rate());
			    hotPlayer.setValue(initialResult.get(count).getPointNum_avg());
				break;
			case("rebound"):
				hotPlayer.setUpgradeRate(initialResult.get(count).getL_f_rebound_rate());
		        hotPlayer.setValue(initialResult.get(count).getReboundNum_avg());
				break;
			case("assist"):
				hotPlayer.setUpgradeRate(initialResult.get(count).getL_f_assist_rate());
		        hotPlayer.setValue(initialResult.get(count).getAssistNum_avg());
				break;
			}// end switch
			result.add(hotPlayer);
		}
		new AnalyseCmdOption().setResult(result);
	}
	
	@CmdOption(names = { "-king" }, description = "show player king", maxCount = 1, minCount = 0,
			args = {"field"},conflictsWith = {"-all","-hot","-avg","-total","-filter","-sort"})
	public void setPlayerKing(String field){
		this.kingField = field;
	}
	
	@CmdOption(names = { "-season" }, description = "show season player king", maxCount = 1, minCount = 0,
			requires = {"-king"},conflictsWith = {"-daily"})
	public void setSeasonPlayerKing(){
		RMIObject object = new RMIObject();
		PlayerBLService pbls = object.getPlayerObject();
		ArrayList<PlayerKingInfo> result = new ArrayList<PlayerKingInfo>();
		ArrayList<PlayerSeasonDataVO> initialResult = new ArrayList<PlayerSeasonDataVO>();
		switch(kingField){
		case("score"):
			initialResult = pbls.getSeasonHotPlayer("pointNum_avg");
			break;
		case("rebound"):
			initialResult = pbls.getSeasonHotPlayer("reboundNum_avg");
			break;
		case("assist"):
			initialResult = pbls.getSeasonHotPlayer("assistNum_avg");
			break;
		
		}
		for(int count=0;count<initialResult.size();count++){
			PlayerKingInfo kingPlayer = new PlayerKingInfo();
			kingPlayer.setField(kingField);
			kingPlayer.setName(initialResult.get(count).getName());
			kingPlayer.setPosition(initialResult.get(count).getPosition());
			kingPlayer.setTeamName(initialResult.get(count).getTeamName());
			switch(kingField){
			case("score"):
			    kingPlayer.setValue(initialResult.get(count).getPointNum_avg());
				break;
			case("rebound"):
		        kingPlayer.setValue(initialResult.get(count).getReboundNum_avg());
				break;
			case("assist"):
		        kingPlayer.setValue(initialResult.get(count).getAssistNum_avg());
				break;
			}// end switch
			result.add(kingPlayer);
		}
		new AnalyseCmdOption().setResult(result);
	}
	
	@CmdOption(names = { "-daily" }, description = "show daily player king", maxCount = 1, minCount = 0,
			requires = {"-king"},conflictsWith = {"-season"})
	public void setDailyPlayerKing(){
		
		RMIObject object = new RMIObject();
		MatchBLService mbls = object.getMatchObject();
		ArrayList<PlayerKingInfo> result = new ArrayList<PlayerKingInfo>();
		ArrayList<SingleMatchPersonalDataVO> initialResult = new ArrayList<SingleMatchPersonalDataVO>();
		switch(kingField){
		case("score"):
			initialResult = mbls.getTodayHotPlayer("pointNum_avg");
			break;
		case("rebound"):
			initialResult = mbls.getTodayHotPlayer("reboundNum_avg");
			break;
		case("assist"):
			initialResult = mbls.getTodayHotPlayer("assistNum_avg");
			break;
		
		}
		for(int count=0;count<initialResult.size();count++){
			PlayerKingInfo kingPlayer = new PlayerKingInfo();
			kingPlayer.setField(kingField);
			kingPlayer.setName(initialResult.get(count).getPlayerName());
			kingPlayer.setPosition(initialResult.get(count).getPlayerPosition());
			kingPlayer.setTeamName(initialResult.get(count).getTeamName());
			switch(kingField){
			case("score"):
			    kingPlayer.setValue(initialResult.get(count).getPointNum());
				break;
			case("rebound"):
		        kingPlayer.setValue(initialResult.get(count).getReboundNum());
				break;
			case("assist"):
		        kingPlayer.setValue(initialResult.get(count).getAssistNum());
				break;
			}// end switch
			result.add(kingPlayer);
		}
		new AnalyseCmdOption().setResult(result);
	}
	
	@CmdOption(names = { "-n" }, args = { "filed" }, maxCount = 1, minCount = 0)
	public void setNum(String filed) {
		this.num = Integer.parseInt(filed);
	}
	
    @CmdOption(names = { "-high" },description= "show high information of player",maxCount = 1, minCount = 0,
    		conflictsWith = {"-avg","-total","-all","-hot","-king","-filter"})
    public void setHighInfo(){
    	this.isHighInfo = true;
    }
    
	@CmdOption(names = { "-filter" }, description = "show filtered player information ", maxCount = 1, minCount = 0,
			args = {"field"},conflictsWith = {"-sort"})
	public void setFilterValue(){
		
	}
	
	@CmdOption(names = { "-sort" }, description = "show sorted player information ", maxCount = 1, minCount = 0,
			args = {"field"},conflictsWith = {"-filter"})
	public void setSortValue(){
		
	}

}
