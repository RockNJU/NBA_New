package com.nba;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;
import de.tototec.cmdoption.*;

public class AnalyseCmdOption{
	
	/*static ArrayList<PlayerHighInfo> result_PHigh = new ArrayList<PlayerHighInfo>();
	static ArrayList<PlayerHotInfo> result_PHot = new ArrayList<PlayerHotInfo>();
	static ArrayList<PlayerKingInfo> result_PKing = new ArrayList<PlayerKingInfo>();
	static ArrayList<PlayerNormalInfo> result_PNomal = new ArrayList<PlayerNormalInfo>();
	static ArrayList<TeamHighInfo> result_THigh = new ArrayList<TeamHighInfo>();
	static ArrayList<TeamHotInfo> result_Thot = new ArrayList<TeamHotInfo>();
	static ArrayList<TeamNormalInfo> result_TNormal = new ArrayList<TeamNormalInfo>();*/
	static ArrayList<?> result;
	String[] args;

	
	public void start(){
		Config config = new Config();
		Player player = new Player();
		Team team = new Team();
		CmdlineParser cp = new CmdlineParser(new Object[] {config,player,team });
	    cp.parse(args);
	}
	
	public void setArgs(String[] instructions){
		this.args = instructions;
	}
	
	
	public ArrayList<?> getResult(){
		return result;
	}
	
	public void setResult(ArrayList<?> list){
		this.result = list;
	}

}  // end class AnalyseCmdOption

class Config {
	@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
	public boolean help;
}

