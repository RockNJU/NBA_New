package UI.common;

import java.util.HashMap;
import java.util.Map;

public class SortItem_Map {
     Map<String, String> map=new HashMap<String, String>();
 
	
   public SortItem_Map(){
	   /*	private double =0;         //����峡�÷ֵ�������
	private double =0; 		//����峡������������
	private double =0;	int winNum;						 //ʤ������
		//����峡�����������    //Ͷ��Ч��*/
	   
	   map.put("ʤ������", "winNum");
	   
	   map.put("���峡�÷�������", "l_f_point_rate");
	   map.put("���峡����������", "l_f_assist_rate");
	   map.put("���峡����������", "l_f_rebound_rate");
	   
	   map.put("GmScЧ��ֵ", "GmSc");
	   map.put("����Ч��", "offensiveReboundEff_avg");
	   map.put("������", "reboundEfficiency_avg");
	   map.put("������", "assistEfficiency_avg");
	   
	   map.put("��ʵ������", "realShootPercentage");
	   map.put("Ͷ��Ч��", "shootEfficiency");
	   map.put("��ñ��", "blockEfficiency_avg");
	   map.put("ʹ����", "usingPercentage_avg");
	   map.put("ʧ����", "turnoverPercentage");
	   map.put("������", "stealEfficiency_avg");
	   map.put("����Ч��", "defenseReboundEff_avg");
	   /////////////
	   
	   map.put("��˫��", "seasonDoubleNum");
	   map.put("��˫��", "seasonThreeNum");
	   map.put("Ͷ��������", "shootPercentage");
	   map.put("����������", "T_shootPercentage");
	   map.put("����������", "freeThrowPercentage");
	   
	   
	   map.put("��������", "matchNum");
	   map.put("�ȷ�����", "startingNum");
	   map.put("�ϳ�ʱ��", "time_avg");
	   map.put("������", "fieldGoal_avg");
	   map.put("������", "shootNum_avg");
	   map.put("����������", "T_fieldGoal_avg");
	   map.put("���ֳ�����", "T_shootNum_avg");
	   //////
	   map.put("�÷�", "pointNum_avg");
	   map.put("Ч��", "efficiency");
	   map.put("����", "foulNum_avg");
	   map.put("ʧ��", "turnoverNum_avg");
	   map.put("��ñ", "blockNum_avg");
	   map.put("����", "reboundNum_avg");
	   map.put("����", "stealNum_avg");
	   map.put("����", "assistNum_avg");
	   map.put("��������", "D_ReboundNum_avg");
	   map.put("��������", "O_ReboundNum_avg");
	   map.put("������", "freeThrowNum_avg");
	   map.put("����������", "freeThrowGoalNum_avg");
	   ////////
	   //---------------------
	   map.put("������", "reboundNum");
	   map.put("������", "assistNum");
	   map.put("��ñ��", "blockNum");
	   map.put("������", "stealNum");
	   map.put("������", "foulNum");
	   map.put("ʧ����", "turoverNum");
	   map.put("�÷���", "pointNum");
	   
	  
	   //map.put("", "");   
   }
   
   public String getItem(String item){
	   if(map==null)
		   return null;
	   return map.get(item).toString();
   }
   
   public static void main(String args[]){
	   SortItem_Map m=new SortItem_Map();
	   System.out.println("999"+"\u524D\u950B");
	   System.out.println("�Ҿͼ죡"+m.getItem("\u524D\u950B"));
   }
   
}
