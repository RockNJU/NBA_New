package businesslogic.shareeclass;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.MatchController;
import VO.MatchVO;

public class DataBaseHelpTest {
	ArrayList<MatchVO> list;
	@Before
	public void setUp() throws Exception {
		list=new ArrayList<MatchVO>();
		MatchController mc=new MatchController();
		list=mc.getAllMatchVO();
		System.out.println("����ǰ��׼����");
	}

	@Test
	public void testUpdataSeasonData() throws ClassNotFoundException, SQLException {
		
		DataBaseHelp hl=new DataBaseHelp();
		hl.updataSeasonData(list.get(1));
		System.out.println("��Ӧ�������Խ�����");
	}

}
