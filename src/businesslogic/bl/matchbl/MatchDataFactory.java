package businesslogic.bl.matchbl;

import java.util.ArrayList;

import VO.MatchVO;

public class MatchDataFactory {
	ArrayList<MatchData> matchList;
	public MatchDataFactory(){
		matchList=new ArrayList<>();
	}
	
	public void add_A_match(MatchVO vo){
		for(int i=0;i<matchList.size();i++){
			/*当赛季子仓库已经存在，则直接添加*/
			if(matchList.get(i).getSeason().equals(vo.getSeason())){
				matchList.get(i).add_A_match(vo);
			}
		}
		
		
		
		MatchData newSeason=new MatchData(vo.getSeason());
		newSeason.add_A_match(vo);
		matchList.add(newSeason);
		
	}
	
	public MatchVO get_A_match(String date,String teamb){
		String time[]=date.split("-");  //xxxx-xx-xx,此处需要根据日期来判断赛季
		
		return null;
	}
}
