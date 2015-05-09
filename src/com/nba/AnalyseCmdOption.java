package com.nba;

import java.util.ArrayList;

import UI.blObject.RMIObject;
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
	String player_path;
	String team_path;
	String match_path;
	char c = 92; //·´Ð±¸ÜµÄasciiÂë

	public void setSourcePath(String filePath){
		
		player_path = filePath + c + "players";
		team_path = filePath + c + "teams";
		match_path = filePath + c + "matches";
	}
	
	public void start(){
		SourcePath s = new SourcePath();
		CmdlineParser cp = new CmdlineParser(new Object[] {s});
		cp.parse(args);
		Config config = new Config();
		RMIObject object = new RMIObject(player_path,team_path,match_path);
		Player player = new Player(object);
		Team team = new Team(object);
	    cp = new CmdlineParser(new Object[] {config,player,team });
		
	    try {
	        cp.parse(args);
	      } catch (CmdlineParserException e) {
	        System.err.println("Error: " + e.getLocalizedMessage() + "\n-help for help.");
	        System.exit(1);
	      }
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

class SourcePath{
	
	@CmdOption(names = { "--datasource" }, description = "set data source path", args = {"sourcePath"},maxCount = 1, minCount = 0)
	public void setDataSource(String sourcePath){
		new AnalyseCmdOption().setSourcePath(sourcePath);
	}
}

