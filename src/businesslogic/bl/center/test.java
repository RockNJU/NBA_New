package businesslogic.bl.center;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PackageListener_old p = new PackageListener_old("e://temp");
		ArrayList<String> filelist = p.f.getAddedFileList();
		System.out.println(filelist.size()+"   size");
		for(int i=0;i<filelist.size();i++){
			System.out.println(filelist.get(i)  + "~~~~");
		}
		
	}

}
