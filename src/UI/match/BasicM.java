package UI.match;

import javax.swing.*;

import businessService.blservice.MatchBLService;
import UI.blObject.RMIObject;
import VO.MatchVO;

import java.awt.*;
import java.util.ArrayList;

public class BasicM extends JPanel {

	MatchVO mvo;
	MatchBLService mbl;
	RMIObject rmi=new RMIObject();
	Color win=Color.BLUE;
	Color lose=Color.DARK_GRAY;
	/**
	 * Create the panel.
	 */
	public BasicM(String team, String date) {
		setSize(760, 500);
		setLayout(null);
		setOpaque(false);
		
		mbl=rmi.getMatchObject();
		mvo=mbl.getMatchByTeam(date, team);
		System.out.println(mvo==null);
		ImageIcon imageA=new ImageIcon("pic\\TEAMPNG\\"+mvo.getHostTeam().getTeamName()+".png");	
		//显示图片
		imageA.setImage(imageA.getImage().getScaledInstance(226,226,Image.SCALE_DEFAULT)); 
		JLabel photoA = new JLabel(imageA);		
		photoA.setBounds(15, 10, 226,226);
		photoA.setOpaque(false);
		add(photoA);
		
		ImageIcon imageB=new ImageIcon("pic\\TEAMPNG\\"+mvo.getGuestTeam().getTeamName()+".png");	
		//显示图片
		imageB.setImage(imageB.getImage().getScaledInstance(226,226,Image.SCALE_DEFAULT)); 
		JLabel photoB= new JLabel(imageB);		
		photoB.setBounds(520, 10, 226,226);
		photoB.setOpaque(false);
		add(photoB);
		
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
			}else{
				scoreA.setForeground(lose);
				scoreB.setForeground(win);
			}
			
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
}
