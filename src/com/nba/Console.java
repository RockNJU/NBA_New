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
 * @date 创建时间：2015年4月27日 下午3:17:10 
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
		
		//调用指令解析类  解析指令  并获取返回对象   添加到PrintStream中
		AnalyseCmdOption cmdAnalyse = new AnalyseCmdOption();
		cmdAnalyse.setArgs(args);
		cmdAnalyse.start();
		ArrayList<?> result = cmdAnalyse.getResult();
		for(int i=0;i<result.size();i++){
			out.print(result.get(i));
		}
	}

}


