package com.nba;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author  ���� E-mail: 
 * @date ����ʱ�䣺2015��5��7�� ����4:33:55 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class SortItem_Map_Team {

    Map<String, String> map=new HashMap<String, String>();
    
	
  public SortItem_Map_Team(){
	   
	   //�ȵ��������
	   map.put("score", "pointNum_avg");
	   map.put("rebound", "reboundNum_avg");
	   map.put("assist", "assistNum_avg");
	   map.put("blockShot", "blockNum_avg");
	   map.put("steal", "stealNum_avg");
	   map.put("foul", "foulNum_avg");
	   map.put("fault", "turnoverNum_avg");
	   map.put("shot", "shootPercentage");
	   map.put("three", "t_shootPercentage");
	   map.put("penalty", "freeThrowPercentage");
	   map.put("defendRebound", "d_ReboundNum_avg");
	   map.put("offendRebound", "o_ReboundNum_avg");
	   map.put("rebound", "reboundNum_avg");
	   
	   
	   //ɸѡ����
	   map.put("point", "pointNum_avg");
	   map.put("winRate","winRate" );
	   map.put("offendRound","offenseRound_avg" );
	   map.put("offendEfficient","offenseEfficiency_avg" );
	   map.put("defendEfficient","defenseEfficiency_avg" );
	   map.put("offendReboundEfficient","offensiveReboundEff_avg" );
	   map.put("defendReboundEfficient","defenseReboundEff_avg" );
	   map.put("stealEfficient","stealEfficiency_avg" );
	   map.put("assistEfficient","assistEfficiency_avg" );
  }
  
  public String getItem(String item){
	   
	   if(map.get(item)==null){
		   return "pointNum_avg";
	   }
	   return map.get(item).toString();
  }
  
}
