package businesslogic.shareeclass;

import java.sql.SQLException;
import java.util.ArrayList;

import VO.MatchVO;
import businesslogic.bl.MatchController;

public class Test {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		System.out.println("进入Test的main函数进行测试！");
		ArrayList<MatchVO>list=new ArrayList<MatchVO>();
		MatchController mc=new MatchController();
		list=mc.getAllMatchVO();
		DataBaseHelp hl=new DataBaseHelp();
		hl.updataSeasonData(list.get(1));
		System.out.println("对应方法测试结束！");
	}
}
