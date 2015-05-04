package com.nba;

import java.util.ArrayList;

import de.tototec.cmdoption.*;

public class AnalyseCmdOption{
	
	static ArrayList<Object> result = new ArrayList<Object>();
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
	
	
	public ArrayList<Object> getResult(){
		return result;
	}
	
	public void setResult(ArrayList<Object> list){
		this.result = list;
	}

}  // end class AnalyseCmdOption

class Config {
	@CmdOption(names = { "--help", "-h", "-?" }, description = "show help", isHelp = true)
	public boolean help;
}

