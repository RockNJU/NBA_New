package com.nba;
import java.util.HashMap;
import java.util.Map;

public class SortItem_Map_PlayerHigh {
     Map<String, String> map=new HashMap<String, String>();
 
	
   public SortItem_Map_PlayerHigh(){
	   
	   //基础数据
	   map.put("point", "pointNum_avg");
	   map.put("rebound", "reboundNum_avg");
	   map.put("assist", "assistNum_avg");
	   map.put("blockShot", "blockNum_avg");
	   map.put("steal", "stealNum_avg");
	   map.put("foul", "foulNum_avg");
	   map.put("fault", "turnoverNum_avg");
	   map.put("minute", "time_avg");
	   map.put("efficient", "efficiency");
	   map.put("shot", "shootPercentage");
	   map.put("three", "t_shootPercentage");
	   map.put("penalty", "freeThrowPercentage");
	   map.put("doubleTwo", "seasonDoubleNum");

	   
	   //高阶数据
	   
	   map.put("realShot", "realShootPercentage");
	   map.put("GmSc", "gmSc");
	   map.put("shotEfficient", "shootEfficiency");
	   map.put("reboundEfficient", "reboundEfficiency_avg");
	   map.put("offendReboundEfficient", "o_ReboundEfficiency_avg");
	   map.put("defendReboundEfficient", "d_ReboundEfficiency_avg"); 
	   map.put("assistEfficient", "assistEfficiency_avg");
	   map.put("stealEfficient", "stealEfficiency_avg");
	   map.put("blockShotEfficient", "blockEfficiency_avg");
	   map.put("faultEfficient", "turnoverPercentage");
	   map.put("frequency", "usingPercentage_avg");
	   
   }
   
   public String getItem(String item){
	   
	   System.out.println("传进来的item："+item);
	   
	   if(map.get(item)==null){
		   return "pointNum_avg";
	   }
	   return map.get(item).toString();
   }
   
}

