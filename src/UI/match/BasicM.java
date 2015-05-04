package UI.match;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import UI.blObject.RMIObject;
import UI.main.init;
import UI.team.SingleTeam;
import VO.MatchVO;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BasicM extends JPanel {

	MatchVO mvo;
	//MatchBLService mbl;
	//RMIObject rmi=new RMIObject();
	Color win=Color.BLUE;
	Color lose=Color.BLACK;
	String season;
	/**
	 * Create the panel.
	 */
	public static String getSeason(String date){
		String str[]=date.split("-");    //date的格式xxxx-xx-xx
		
		int f_year,l_year;
		int year=Integer.parseInt(str[0].substring(2));
		int month=Integer.parseInt(str[1]);
		
		if(month>=10){
			f_year=year;
			l_year=year+1;
		}else{
			f_year=year-1;
			l_year=year;
		}
		String result=f_year+"-"+l_year;
		return result;
	}
	public BasicM(String team, String date) {
		setSize(760, 500);
		setLayout(null);
		setOpaque(false);
		season=getSeason(date);
		//mbl=init.rmi.getMatchObject();
		mvo=init.mbl.getMatchByTeam(date, team);
		//System.out.println(mvo==null);
		ImageIcon imageA=new ImageIcon("pic\\TEAMPNG\\"+mvo.getHostTeam().getTeamName()+".png");	
		//显示图片
		imageA.setImage(imageA.getImage().getScaledInstance(226,226,Image.SCALE_DEFAULT)); 
		JLabel photoA = new JLabel(imageA);		
		photoA.setBounds(15, 10, 226,226);
		photoA.setOpaque(false);
		add(photoA);
		photoA.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				SingleTeam spi;
				
				try {
					spi = new SingleTeam(mvo.getHostTeam().getTeamName(),season);
				
				init.currentdio="7(1)&"+mvo.getHostTeam().getTeamName()+";"+season;
				//System.out.println(init.currentpanel);
			    spi.setVisible(true);
				 spi.setLocation(375, 80);
				} catch (TransformerFactoryConfigurationError
						| TransformerException | IOException
						| SVGConverterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		ImageIcon imageB=new ImageIcon("pic\\TEAMPNG\\"+mvo.getGuestTeam().getTeamName()+".png");	
		//显示图片
		imageB.setImage(imageB.getImage().getScaledInstance(226,226,Image.SCALE_DEFAULT)); 
		JLabel photoB= new JLabel(imageB);		
		photoB.setBounds(520, 10, 226,226);
		photoB.setOpaque(false);
		add(photoB);
		photoB.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				SingleTeam spi;
				String season="13-14";
				try {
					spi = new SingleTeam(mvo.getGuestTeam().getTeamName(),season);
				
				init.currentdio="7(1)&"+mvo.getGuestTeam().getTeamName()+";"+season;
				//System.out.println(init.currentpanel);
			    spi.setVisible(true);
				 spi.setLocation(375, 80);
				} catch (TransformerFactoryConfigurationError
						| TransformerException | IOException
						| SVGConverterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			});
		String totalscore[]=mvo.getMatchScore().split("-");
		
		
		JLabel Atotal = new JLabel(totalscore[0]);
		
		Atotal.setFont(new Font("华康雅宋体W9", Font.PLAIN, 25));
		Atotal.setBounds(270, 142, 67, 52);
		add(Atotal);
		
		JLabel Btotal = new JLabel(totalscore[1]);
		
		Btotal.setFont(new Font("华康雅宋体W9", Font.PLAIN, 25));
		Btotal.setBounds(270, 190, 67, 52);
		add(Btotal);
		if(totalscore[0].compareTo(totalscore[1])>0){
			Atotal.setForeground(win);
			Btotal.setForeground(lose);
		}else{
			Atotal.setForeground(lose);
			Btotal.setForeground(win);
		}
		
	
		ArrayList<String> scores=mvo.getScores();
		for(int i=0;i<scores.size();i++){
			String singlescore[]=scores.get(i).split("-");
			
			JLabel scoreA = new JLabel(singlescore[0]);
			scoreA.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
			scoreA.setBounds(330+i*30, 142, 30, 50);
			add(scoreA);
			
			JLabel scoreB = new JLabel(singlescore[1]);
			scoreB.setFont(new Font("华康雅宋体W9", Font.PLAIN, 18));
			scoreB.setBounds(330+i*30, 190, 30, 50);
			add(scoreB);
			if(singlescore[0].compareTo(singlescore[1])>0){
				scoreA.setForeground(win);
				scoreB.setForeground(lose);
			}else if(singlescore[0].equals(singlescore[1])){
				scoreA.setForeground(lose);
				scoreB.setForeground(lose);
			}else {
				scoreA.setForeground(lose);
				scoreB.setForeground(win);
			}
			
		}
		
		JLabel zhugong = new JLabel("\u52A9\u653B");
		zhugong.setFont(new Font("黑体", Font.PLAIN, 18));
		zhugong.setBounds(66, 301, 50, 27);
		add(zhugong);
		
		JLabel lanban = new JLabel("\u7BEE\u677F");
		lanban.setFont(new Font("黑体", Font.PLAIN, 18));
		lanban.setBounds(66, 328, 50, 27);
		add(lanban);

		JLabel fangshouxiaolv = new JLabel("\u9632\u5B88\u6548\u7387");
		fangshouxiaolv.setFont(new Font("黑体", Font.PLAIN, 18));
		fangshouxiaolv.setBounds(30, 383, 81, 27);
		add(fangshouxiaolv);
		
		JLabel jingongxiaolv = new JLabel("\u8FDB\u653B\u6548\u7387");
		jingongxiaolv.setFont(new Font("黑体", Font.PLAIN, 18));
		jingongxiaolv.setBounds(30, 356, 80, 27);
		add(jingongxiaolv);		
		
		JLabel toulan = new JLabel("\u6295\u7BEE\u547D\u4E2D\u7387");
		toulan.setFont(new Font("黑体", Font.PLAIN, 18));
		toulan.setBounds(10, 408, 113, 27);
		add(toulan);
		
		JLabel faqiu = new JLabel("\u7F5A\u7403\u547D\u4E2D\u7387");
		faqiu.setFont(new Font("黑体", Font.PLAIN, 18));
		faqiu.setBounds(10, 435, 113, 27);
		add(faqiu);
				
		JLabel sanfen = new JLabel("\u4E09\u5206\u547D\u4E2D\u7387");
		sanfen.setFont(new Font("黑体", Font.PLAIN, 18));
		sanfen.setBounds(10, 459, 113, 27);
		add(sanfen);
		
		
		
		JLabel onea = new JLabel(String.valueOf(mvo.getHostTeam().getAssistNum()));
		onea.setFont(new Font("黑体", Font.PLAIN, 18));
		onea.setBounds(145, 301, 70, 27);
		add(onea);
		
		JLabel oneb = new JLabel(String.valueOf(mvo.getGuestTeam().getAssistNum()));
		oneb.setFont(new Font("黑体", Font.PLAIN, 18));
		oneb.setBounds(249, 301, 50, 27);
		add(oneb);
		if(mvo.getHostTeam().getAssistNum()>(mvo.getGuestTeam().getAssistNum())){
			onea.setForeground(win);
			oneb.setForeground(lose);
		}else if(mvo.getHostTeam().getAssistNum()==mvo.getGuestTeam().getAssistNum()){
			onea.setForeground(lose);
			oneb.setForeground(lose);
		}else{
			onea.setForeground(lose);
			oneb.setForeground(win);
		}
		JLabel twoa = new JLabel(String.valueOf(mvo.getHostTeam().getReboundNum()));
		twoa.setFont(new Font("黑体", Font.PLAIN, 18));
		twoa.setBounds(145, 328, 70, 27);
		add(twoa);
		
		JLabel twob = new JLabel(String.valueOf(mvo.getGuestTeam().getReboundNum()));
		twob.setFont(new Font("黑体", Font.PLAIN, 18));
		twob.setBounds(249, 328, 50, 27);
		add(twob);
		if(mvo.getHostTeam().getReboundNum()>(mvo.getGuestTeam().getReboundNum())){
			twoa.setForeground(win);
			twob.setForeground(lose);
		}else if(mvo.getHostTeam().getReboundNum()==mvo.getGuestTeam().getReboundNum()){
			twoa.setForeground(lose);
			twob.setForeground(lose);
		}else{
			twoa.setForeground(lose);
			twob.setForeground(win);
		}
		
		JLabel threea = new JLabel(changedouble(mvo.getHostTeam().getOffenseEfficiency()));
		threea.setFont(new Font("黑体", Font.PLAIN, 18));
		threea.setBounds(145, 356, 70, 27);
		add(threea);
		
		JLabel threeb = new JLabel(changedouble(mvo.getGuestTeam().getOffenseEfficiency()));
		threeb.setFont(new Font("黑体", Font.PLAIN, 18));
		threeb.setBounds(249, 356, 88, 27);
		add(threeb);
		if(mvo.getHostTeam().getOffenseEfficiency()>(mvo.getGuestTeam().getOffenseEfficiency())){
			threea.setForeground(win);
			threeb.setForeground(lose);
		}else if(mvo.getHostTeam().getOffenseEfficiency()==mvo.getGuestTeam().getOffenseEfficiency()){
			threea.setForeground(lose);
			threeb.setForeground(lose);
		}else{
			threea.setForeground(lose);
			threeb.setForeground(win);
		}
		JLabel fa = new JLabel(changedouble(mvo.getHostTeam().getDefenseEfficiency()));
		fa.setFont(new Font("黑体", Font.PLAIN, 18));
		fa.setBounds(145, 383, 70, 27);
		add(fa);
		
		JLabel fb = new JLabel(changedouble(mvo.getGuestTeam().getDefenseEfficiency()));
		fb.setFont(new Font("黑体", Font.PLAIN, 18));
		fb.setBounds(249, 383, 88, 27);
		add(fb);
		if(mvo.getHostTeam().getDefenseEfficiency()>(mvo.getGuestTeam().getDefenseEfficiency())){
			fa.setForeground(win);
			fb.setForeground(lose);
		}else if(mvo.getHostTeam().getDefenseEfficiency()==mvo.getGuestTeam().getDefenseEfficiency()){
			fa.setForeground(lose);
			fb.setForeground(lose);
		}else{
			fa.setForeground(lose);
			fb.setForeground(win);
		}
		JLabel fivea = new JLabel(changedouble(mvo.getHostTeam().getShootPercentage()));
		fivea.setFont(new Font("黑体", Font.PLAIN, 18));
		fivea.setBounds(145, 408, 70, 27);
		add(fivea);
		
		JLabel fiveb = new JLabel(changedouble(mvo.getGuestTeam().getShootPercentage()));
		fiveb.setFont(new Font("黑体", Font.PLAIN, 18));
		fiveb.setBounds(249, 408, 88, 27);
		add(fiveb);
		if(mvo.getHostTeam().getShootPercentage()>(mvo.getGuestTeam().getShootPercentage())){
			fivea.setForeground(win);
			fiveb.setForeground(lose);
		}else if(mvo.getHostTeam().getShootPercentage()==mvo.getGuestTeam().getShootPercentage()){
			fivea.setForeground(lose);
			fiveb.setForeground(lose);
		}else{
			fivea.setForeground(lose);
			fiveb.setForeground(win);
		}
		JLabel sixa = new JLabel(changedouble(mvo.getHostTeam().getFreeThrowPercentage()));
		sixa.setFont(new Font("黑体", Font.PLAIN, 18));
		sixa.setBounds(145, 435, 70, 27);
		add(sixa);
		
		JLabel sixb = new JLabel(changedouble(mvo.getGuestTeam().getFreeThrowPercentage()));
		sixb.setFont(new Font("黑体", Font.PLAIN, 18));
		sixb.setBounds(249, 435, 88, 27);
		add(sixb);
		if(mvo.getHostTeam().getFreeThrowPercentage()>(mvo.getGuestTeam().getFreeThrowPercentage())){
			sixa.setForeground(win);
			sixb.setForeground(lose);
		}else if(mvo.getHostTeam().getFreeThrowPercentage()==mvo.getGuestTeam().getFreeThrowPercentage()){
			sixa.setForeground(lose);
			sixb.setForeground(lose);
		}else{
			sixa.setForeground(lose);
			sixb.setForeground(win);
		}
		JLabel sevena = new JLabel(changedouble(mvo.getHostTeam().getThreePointPercentage()));
		sevena.setFont(new Font("黑体", Font.PLAIN, 18));
		sevena.setBounds(145, 459, 70, 27);
		add(sevena);
		
		JLabel sevenb = new JLabel(changedouble(mvo.getGuestTeam().getThreePointPercentage()));
		sevenb.setFont(new Font("黑体", Font.PLAIN, 18));
		sevenb.setBounds(249, 459, 88, 27);
		add(sevenb);
		if(mvo.getHostTeam().getThreePointPercentage()>(mvo.getGuestTeam().getThreePointPercentage())){
			sevena.setForeground(win);
			sevenb.setForeground(lose);
		}else if(mvo.getHostTeam().getThreePointPercentage()==mvo.getGuestTeam().getThreePointPercentage()){
			sevena.setForeground(lose);
			sevenb.setForeground(lose);
		}else{
			sevena.setForeground(lose);
			sevenb.setForeground(win);
		}
		
	
		JLabel label = new JLabel("\u52A9\u653B");
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(418, 305, 50, 27);
		add(label);
		
		JLabel label_1 = new JLabel("\u7BEE\u677F");
		label_1.setFont(new Font("黑体", Font.PLAIN, 18));
		label_1.setBounds(418, 360, 50, 27);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u5F97\u5206");
		label_2.setFont(new Font("黑体", Font.PLAIN, 18));
		label_2.setBounds(418, 422, 50, 27);
		add(label_2);
		
		JLabel zg1 = new JLabel(mvo.get_HostTeam_Highest_assist().getPlayerName());
		zg1.setFont(new Font("黑体", Font.PLAIN, 15));
		zg1.setBounds(463, 305, 138, 27);
		add(zg1);
		
		JLabel zg2 = new JLabel(mvo.get_GuestTeam_Highest_assist().getPlayerName());
		zg2.setFont(new Font("黑体", Font.PLAIN, 15));
		zg2.setBounds(616, 305, 143, 27);
		add(zg2);
		
		JLabel zga = new JLabel(String.valueOf(mvo.get_HostTeam_Highest_assist().getAssistNum()));
		zga.setFont(new Font("黑体", Font.PLAIN, 18));
		zga.setBounds(495, 328, 58, 27);
		add(zga);
		
	
		JLabel zgb = new JLabel(String.valueOf(mvo.get_GuestTeam_Highest_assist().getAssistNum()));
		zgb.setFont(new Font("黑体", Font.PLAIN, 18));
		zgb.setBounds(646, 328, 58, 27);
		add(zgb);
		
		
		if(mvo.get_HostTeam_Highest_assist().getAssistNum()>(mvo.get_GuestTeam_Highest_assist().getAssistNum())){
			zga.setForeground(win);
			zg1.setForeground(win);
			zgb.setForeground(lose);
			zg2.setForeground(lose);
		}else if(mvo.get_HostTeam_Highest_assist().getAssistNum()==(mvo.get_GuestTeam_Highest_assist().getAssistNum())){
			zga.setForeground(lose);
			zg1.setForeground(lose);
			zgb.setForeground(lose);
			zg2.setForeground(lose);
		}else{
			zga.setForeground(lose);
			zg1.setForeground(lose);
			zgb.setForeground(win);
			zg2.setForeground(win);
		}
		
		JLabel lba = new JLabel(mvo.get_HostTeam_Highest_rebound().getPlayerName());
		lba.setFont(new Font("黑体", Font.PLAIN, 15));
		lba.setBounds(463, 360, 138, 27);
		add(lba);
		JLabel lbb = new JLabel(mvo.get_GuestTeam_Highest_rebound().getPlayerName());
		lbb.setFont(new Font("黑体", Font.PLAIN, 15));
		lbb.setBounds(616, 360, 143, 27);
		add(lbb);
		JLabel lb1 = new JLabel(String.valueOf(mvo.get_HostTeam_Highest_rebound().getReboundNum()));
		lb1.setFont(new Font("黑体", Font.PLAIN, 18));
		lb1.setBounds(495, 391, 58, 27);
		add(lb1);
		
		JLabel lb2 = new JLabel(String.valueOf(mvo.get_GuestTeam_Highest_rebound().getReboundNum()));
		lb2.setFont(new Font("黑体", Font.PLAIN, 18));
		lb2.setBounds(646, 391, 58, 27);
		add(lb2);
		
		if(mvo.get_HostTeam_Highest_assist().getReboundNum()>(mvo.get_GuestTeam_Highest_assist().getReboundNum())){
			lba.setForeground(win);
			lb1.setForeground(win);
			lbb.setForeground(lose);
			lb2.setForeground(lose);
		}else if(mvo.get_HostTeam_Highest_assist().getReboundNum()==(mvo.get_GuestTeam_Highest_assist().getReboundNum())){
			lba.setForeground(lose);
			lb1.setForeground(lose);
			lbb.setForeground(lose);
			lb2.setForeground(lose);
		}else{
			lba.setForeground(lose);
			lb1.setForeground(lose);
			lbb.setForeground(win);
			lb2.setForeground(win);
		}
		
		JLabel de1 = new JLabel(mvo.get_HostTeam_Highest_point().getPlayerName());
		de1.setFont(new Font("黑体", Font.PLAIN, 15));
		de1.setBounds(463, 422, 138, 27);
		add(de1);
		
		JLabel de2 = new JLabel(mvo.get_GuestTeam_Highest_point().getPlayerName());
		de2.setFont(new Font("黑体", Font.PLAIN, 15));
		de2.setBounds(616, 422, 143, 27);
		add(de2);
		

		JLabel dea = new JLabel(String.valueOf(mvo.get_HostTeam_Highest_point().getPointNum()));
		dea.setFont(new Font("黑体", Font.PLAIN, 18));
		dea.setBounds(495, 443, 58, 27);
		add(dea);
		
		JLabel deb = new JLabel(String.valueOf(mvo.get_GuestTeam_Highest_point().getPointNum()));
		deb.setFont(new Font("黑体", Font.PLAIN, 18));
		deb.setBounds(646, 443, 58, 27);
		add(deb);
		if(mvo.get_HostTeam_Highest_assist().getPointNum()>(mvo.get_GuestTeam_Highest_assist().getPointNum())){
			dea.setForeground(win);
			de1.setForeground(win);
			deb.setForeground(lose);
			de2.setForeground(lose);
		}else if(mvo.get_HostTeam_Highest_assist().getPointNum()==(mvo.get_GuestTeam_Highest_assist().getPointNum())){
			dea.setForeground(lose);
			de1.setForeground(lose);
			deb.setForeground(lose);
			de2.setForeground(lose);
		}else{
			dea.setForeground(lose);
			de1.setForeground(lose);
			deb.setForeground(win);
			de2.setForeground(win);
		}
		
		/**
		 * 背景图片
		 */

		ImageIcon image = new ImageIcon("pic/比赛界面N.png");
		image.setImage(image.getImage().getScaledInstance(759, 499,Image.SCALE_DEFAULT)); 		

		JLabel photo = new JLabel(image);		
		photo.setBounds(0, 0, 759, 499);		
		photo.setOpaque(false);
		add(photo);
		
		
	}
	
	private String changedouble(double rate){
		//System.out.println(rate);
		//rate=rate*100;		
		DecimalFormat df = new DecimalFormat("0.00");    
		String temp=String.valueOf(df.format(rate));
		//System.out.println(temp);
		return temp;		
	}
}
