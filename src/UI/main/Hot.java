package UI.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;




public class Hot extends JPanel {
	JToolBar toolBar;
	JToolBar toolBar1;
	
	JPanel p1;
	JPanel p2;
	HotPlayers hp;
	HotTeams ht;
	String cmdplayer="day";
	/*
	JButton changjundefen;
	JButton changjungaimao;
	JButton changjunlanban;
	JButton changjunqiangduan;
	JButton changjunzhugong;
	JButton faqiumingzhonglv;
	JButton gaimao;
	
	JButton lanban;
	JButton qiangduan;
	JButton sanfenmingzhonglv;
	JButton toulanmingzhonglv;
	JButton zhugong;
	*/
	JButton pday;
	JButton pseason;
	JButton pfast;
	JButton tseason;
	JButton changjundefen=new JButton(new ImageIcon("pic/hotbut/�����÷�.jpg"));
	JButton changjungaimao=new JButton(new ImageIcon("pic/hotbut/������ñ.jpg"));
	JButton changjunlanban=new JButton(new ImageIcon("pic/hotbut/��������.jpg"));
	JButton changjunqiangduan=new JButton(new ImageIcon("pic/hotbut/��������.jpg"));
	JButton changjunzhugong=new JButton(new ImageIcon("pic/hotbut/��������.jpg"));
	
	JButton defen=new JButton(new ImageIcon("pic/hotbut/�÷�.jpg"));
	JButton faqiumingzhonglv=new JButton(new ImageIcon("pic/hotbut/����������.jpg"));
	JButton gaimao=new JButton(new ImageIcon("pic/hotbut/��ñ.jpg"));
	
	JButton lanban=new JButton(new ImageIcon("pic/hotbut/����.jpg"));
	JButton qiangduan=new JButton(new ImageIcon("pic/hotbut/����.jpg"));
	JButton sanfenmingzhonglv=new JButton(new ImageIcon("pic/hotbut/����������.jpg"));
	JButton toulanmingzhonglv=new JButton(new ImageIcon("pic/hotbut/Ͷ��������.jpg"));
	JButton zhugong=new JButton(new ImageIcon("pic/hotbut/����.jpg"));
	
	JButton changjundefen1=new JButton(new ImageIcon("pic/hotbut/�����÷�.jpg"));
	JButton changjungaimao1=new JButton(new ImageIcon("pic/hotbut/������ñ.jpg"));
	JButton changjunlanban1=new JButton(new ImageIcon("pic/hotbut/��������.jpg"));
	JButton changjunqiangduan1=new JButton(new ImageIcon("pic/hotbut/��������.jpg"));
	JButton changjunzhugong1=new JButton(new ImageIcon("pic/hotbut/��������.jpg"));
	JButton faqiumingzhonglv1=new JButton(new ImageIcon("pic/hotbut/����������.jpg"));
	JButton sanfenmingzhonglv1=new JButton(new ImageIcon("pic/hotbut/����������.jpg"));
	JButton toulanmingzhonglv1=new JButton(new ImageIcon("pic/hotbut/Ͷ��������.jpg"));
	
	/**
	 * Create the panel.
	 */
	public Hot() {
		setLayout(null);
		setSize(764,635);
		setOpaque(false);
		
		
		
		pday = new JButton(new ImageIcon("pic/hotbut/�ϲ�_ÿ��a.jpg"));
		pday.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pday.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="day";
	            	pday.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��a.jpg"));
	            	pseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_����.jpg"));
	            	pfast.setIcon(new ImageIcon("pic/hotbut/�ϲ�_�������.jpg"));
	            	changetoolp("day");
	            }	
	       
		});
		
		pday.setToolTipText("ÿ���ȵ���Ա");
		pday.setBounds(540, 139, 53, 28);
		add(pday);
		pday.setVisible(true);
		
		pseason = new JButton(new ImageIcon("pic/hotbut/�ϲ�_����.jpg"));
		pseason.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="season";
	            	pday.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��.jpg"));
	            	pseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_����a.jpg"));
	            	pfast.setIcon(new ImageIcon("pic/hotbut/�ϲ�_�������.jpg"));
	            	changetoolp("season");
	            }	
	       
		});
		
		pseason.setToolTipText("�����ȵ���Ա");
		pseason.setBounds(598, 139, 53, 28);
		add(pseason);
		pseason.setVisible(true);
		
		pfast = new JButton(new ImageIcon("pic/hotbut/�ϲ�_�������.jpg"));
		pfast.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="fast";
	            	pday.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��.jpg"));
	            	pseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_����.jpg"));
	            	pfast.setIcon(new ImageIcon("pic/hotbut/�ϲ�_�������a.jpg"));
	            	changetoolp("fast");
	            }	
	       
		});
		
		pfast.setToolTipText("���������Ա");
		pfast.setBounds(656, 139, 95, 28);
		add(pfast);
		pfast.setVisible(true);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 174, 746, 25);
		toolBar.setOpaque(false);
		
		toolBar.add(defen);
		toolBar.add(lanban);
		toolBar.add(zhugong);
		toolBar.add(gaimao);
		toolBar.add(qiangduan);
		add(toolBar);
		
		
		
		tseason = new JButton(new ImageIcon("pic/hotbut/�ϲ�_����a.jpg"));
		tseason.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_ÿ��a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	tseason.setIcon(new ImageIcon("pic/hotbut/�ϲ�_����a.jpg"));
	            	
	            }	
	       
		});
		
		tseason.setToolTipText("�����ȵ����");
		tseason.setBounds(700, 390, 53, 28);
		add(tseason);
		tseason.setVisible(true);
			
		
		toolBar1 = new JToolBar();
		toolBar1.setFloatable(false);
		toolBar1.setBounds(10, 425, 746, 25);
		toolBar1.setOpaque(false);
		
		toolBar1.add(changjundefen1);
		toolBar1.add(changjunlanban1);
		toolBar1.add(changjunzhugong1);
		toolBar1.add(changjungaimao1);
		toolBar1.add(changjunqiangduan1);			
		toolBar1.add(sanfenmingzhonglv1);
		toolBar1.add(toulanmingzhonglv1);
		toolBar1.add(faqiumingzhonglv1);
		add(toolBar1);
		
		/*
		defen = new JButton("");
		defen.setIcon(new ImageIcon("pic\\hotbut\\\u5F97\u5206.jpg"));
		toolBar.add(defen);
		
		lanban = new JButton("");
		lanban.setIcon(new ImageIcon("pic\\hotbut\\\u7BEE\u677F.jpg"));
		toolBar.add(lanban);
		
		zhugong = new JButton("");
		zhugong.setIcon(new ImageIcon("pic\\hotbut\\\u52A9\u653B.jpg"));
		toolBar.add(zhugong);
		
		gaimao = new JButton("");
		gaimao.setIcon(new ImageIcon("pic\\hotbut\\��ñ.jpg"));
		toolBar.add(gaimao);
		
		qiangduan = new JButton("");
		qiangduan.setIcon(new ImageIcon("pic\\hotbut\\����.jpg"));
		toolBar.add(qiangduan);
		*/
		
		ArrayList<String> tmps=new ArrayList<String>();
		tmps.add("Aaron Brooks");
		tmps.add("Aaron Gray");
		tmps.add("Adonis Thomas");
		tmps.add("Al Harrington");
		tmps.add("Al Horford");
		
		hp=new HotPlayers(tmps,"","");
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(10, 200, 746,170);
		p1.setOpaque(false);
		p1.add(hp);
		
		hp.setLocation(0, 0);
		add(p1);
		
		ArrayList<String> tmps2=new ArrayList<String>();
		tmps2.add("ATL");
		tmps2.add("BKN");
		tmps2.add("DEN");
		tmps2.add("DET");
		tmps2.add("DAL");
		
		ht=new HotTeams(tmps,"");
		p2=new JPanel();
		p2.setLayout(null);
		p2.setOpaque(false);
		p2.setBounds(10, 450, 746,170);
		p2.add(ht);	
		
		ht.setLocation(0, 0);
		add(p2);
		
		ImageIcon image = new ImageIcon("pic/�ȵ�.png");
		image.setImage(image.getImage().getScaledInstance(753, 510,Image.SCALE_DEFAULT)); 		
		JLabel photo = new JLabel(image);		
		photo.setBounds(7, 125, 753, 510);		
		photo.setOpaque(false);
		add(photo);
	}
	
	
	
	private void changetoolp(String com){
		if(com.equals("season")){
			toolBar.removeAll();
			toolBar.add(changjundefen);
			toolBar.add(changjunlanban);
			toolBar.add(changjunzhugong);
			toolBar.add(changjungaimao);
			toolBar.add(changjunqiangduan);			
			toolBar.add(sanfenmingzhonglv);
			toolBar.add(toulanmingzhonglv);
			toolBar.add(faqiumingzhonglv);
			toolBar.validate();
			toolBar.repaint();
		}
		else if(com.equals("day")){
			toolBar.removeAll();
			toolBar.add(defen);
			toolBar.add(lanban);
			toolBar.add(zhugong);
			toolBar.add(gaimao);
			toolBar.add(qiangduan);
			toolBar.validate();
			toolBar.repaint();
		}
		else {
			toolBar.removeAll();
			toolBar.add(changjundefen);
			toolBar.add(changjunlanban);
			toolBar.add(changjunzhugong);
			toolBar.validate();
			toolBar.repaint();
		}
	}
	
	void changep1(HotPlayers newhp){
		p1.removeAll();
		p1.add(newhp);
		newhp.setLocation(0, 0);
		p1.validate();
		p1.repaint();
	}
	void changep2(HotTeams newht){
		p2.removeAll();
		p2.add(newht);
		newht.setLocation(0, 0);
		p2.validate();
		p2.repaint();
	}
}