package businesslogic.data;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.PO.MatchPO;
 

public class MatchDataControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMatchDataController() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllMatch() {
		MatchDataController c=new MatchDataController();
		ArrayList<MatchPO> list= c.getAllMatch();
		int m=0;
		for(int i=0;i<list.size();i++){
		//System.out.println("--一支球队得分："+list.get(i).getGuestTeam().getPoints());
		m++;
		}
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAMatch() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatchList() {
		fail("Not yet implemented");
	}

}
