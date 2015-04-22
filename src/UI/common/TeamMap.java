package UI.common;

import java.util.HashMap;
import java.util.Map;

public class TeamMap {
	  Map<String, String> map=new HashMap<String, String>();
	  
		
	   public TeamMap(){
		   map.put("ʤ��", "winRate");
		   map.put("����������", "reboundNum");
		   map.put("�����غ�", "offenseRound");
		   map.put("����Ч��", "offenseEfficiency");
		   map.put("����Ч��", "defenseEfficiency");
		   map.put("����Ч��", "reboundEfficiency");
		   map.put("����Ч��", "stealEfficiency");
		   map.put("������", "assistEfficiency");
		   map.put("����������", "D_Rebound");
		   map.put("����������", "O_Rebound");
		   
		   
		   //---------------------
		   map.put("���������", "freeThrowNum");
		   map.put("���ֳ�����", "T_shootNum");
		   map.put("����������", "T_fieldGoal");
		   map.put("Ͷ�����ִ���", "shootNum");	   
		   
		   map.put("Ͷ��������", "shootPercentage");
 
		   map.put("�����÷�", "points");
		   map.put("������", "reboundNum");
		   map.put("������", "assistNum");
		    
		   map.put("��ñ��", "blockNum");
		   map.put("������", "stealNum");
		   map.put("������", "foulNum");
		   map.put("ʧ����", "turoverNum");
		   //map.put("", "");   
		   
		   map.put("����������", "threePointPercentage");	   
		   
		   map.put("����������", "freeThrowPercentage");
	   }
	   
	   public String getItem(String item){
		   return map.get(item).toString();
	   }
	
}
