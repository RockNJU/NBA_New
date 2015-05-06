package com.nba;
import java.io.PrintStream;
import java.util.ArrayList;

import businessService.blservice.MatchBLService;
import businessService.blservice.PlayerBLService;
import UI.blObject.RMIObject;
import VO.PlayerSeasonDataVO;
import VO.SingleMatchPersonalDataVO;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;


/**
 * 
 */
/** 
 * @author  ghl
 * @date ����ʱ�䣺2015��4��27�� ����3:17:10 
 * @version 1.0.1 
 * @parameter  
 * @since  jdk 1.8.0_45
 * @return  
 */
/**
 * @author ghl
 *
 */
public class Console {
	

	public void execute(PrintStream out,String[] args){
		
		//����ָ�������  ����ָ��  ����ȡ���ض���   ��ӵ�PrintStream��
		AnalyseCmdOption cmdAnalyse = new AnalyseCmdOption();
		cmdAnalyse.setArgs(args);
		cmdAnalyse.start();
		ArrayList<?> result = cmdAnalyse.getResult();
		for(int i=0;i<result.size();i++){
			out.print(result.get(i));
		}
	}

}


