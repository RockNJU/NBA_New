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
	
	public static void main(String[] args){
		AnalyseCmdOption cmdAnalyse = new AnalyseCmdOption();
		String[] arg = {"-player","-hot","score","-n","10","-print"};
		cmdAnalyse.setArgs(arg);
		cmdAnalyse.start();
		ArrayList<?> result = cmdAnalyse.getResult();
		for(int i=0;i<result.size();i++){
			System.out.println((i+1)+"\n"+result.get(i).toString());
		}
	}

}  // end class AnalyseCmdOption

class Config {
	@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
	public boolean help;
}

