package UI.common;

import java.util.HashMap;
import java.util.Map;

public class TeamName_Map {
	Map<String, String> map=new HashMap<String, String>();
	  
	
	   public TeamName_Map(){
		   map.put("Hawks", "ATL");
		   map.put("Nets", "BKN");
		   map.put("Celtics", "BOS");
		   map.put("Hornets", "CHA");
		   map.put("Bulls", "CHI");
		   map.put("Cavaliers", "CLE");
		   map.put("Mavericks", "DAL");
		   map.put("Nuggets", "DEN");
		   map.put("Pistons", "DET");
		   map.put("Warriors", "GSW");
		   
		   
		   //---------------------
		   map.put("Rockets", "HOU");
		   map.put("Pacers", "IND");
		   map.put("Clippers", "LAC");
		   map.put("Lakers", "LAL");	   
		   
		   map.put("Grizzlies", "MEM");

		   map.put("Heat", "MIA");
		   map.put("Bucks", "MIL");
		   map.put("TimBerwolves", "MIN");
		    
		   map.put("Pelicans", "NOP");
		   map.put("Knicks", "NYK");
		   map.put("Thunder", "OKC");
		   map.put("Magic", "ORL");
		   //map.put("", "");   
		   
		   map.put("76ers", "PHI");	   
		   
		   map.put("Suns", "PHX");
		   //
		   map.put("Trail Blazers", "POR");
		   map.put("Kings", "SAC");
		   map.put("Spurs", "SAS");
		    
		   map.put("Raptors", "TOR");
		   map.put("Jazz", "UTA");
		   map.put("Wizards", "WAS");
	   }
	   
	   public String getFullName(String item){
		   return map.get(item).toString();
	   }
}
