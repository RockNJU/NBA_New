package UI.team;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.batik.apps.rasterizer.DestinationType;
import org.apache.batik.apps.rasterizer.SVGConverter;
import org.apache.batik.apps.rasterizer.SVGConverterException;
import org.w3c.dom.Document;

import businessService.blservice.PlayerBLService;
import businessService.blservice.TeamBLService;
import UI.blObject.RMIObject;
import UI.common.CreateTable;
import UI.common.DOMRasterizer;
import UI.common.PartitionMap;
import UI.common.PlayerPosition_Map;
import UI.main.init;
import UI.player.SinglePlayer;
import VO.PlayerInfoVO;
import VO.TeamInfoVO;
import VO.TeamSeasonDataVO;
import VO.TeamVO;

import javax.swing.plaf.*;
import javax.swing.table.*;

public class BasicInfo_1 extends JPanel {
	
	Color back=new Color(247,162,19);
	Color line=new Color(255,83,1);
	private JTable table;
	ImageIcon  image;
	TeamVO tvo;
	TeamInfoVO tivo;
	TeamSeasonDataVO tdvo;
	String teamnameAbb;
	String season;
	//RMIObject rmi=new RMIObject();
	///TeamBLService tbl;
	//PlayerBLService pbl;
	/**
	 * Create the panel.
	 * @throws TransformerFactoryConfigurationError 
	 * @throws TransformerException 
	 * @throws IOException 
	 * @throws SVGConverterException 
	 */
	public BasicInfo_1(String name,String s) throws TransformerFactoryConfigurationError, TransformerException, IOException, SVGConverterException {
		this.setSize(582, 474);
		
		setLayout(null);
		this.setBackground(new Color(253,212,146));
		this.season=s;
		this.teamnameAbb=name;
		//tbl=init.rmi.getTeamObject();
		//pbl=init.rmi.getPlayerObject();
		tivo=init.tbl.get_A_TeamInfo(s,name);
		tdvo=init.tbl.get_A_TeamSeasonData(s, teamnameAbb);
		
	//	System.out.println(s+teamnameAbb);
		
		if(tivo==null&&tdvo!=null){
			tivo=new TeamInfoVO(tdvo.getTeamName(), "??", "??", "??", "??", "??", "??");
		}
		else if(tdvo==null&&tivo!=null){
			tdvo=new TeamSeasonDataVO(season, tivo.getFullName(), tivo, 0, 0,0, 0,0,0, 0, 0, 0, 0,0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
		}else if(tivo==null&&tdvo==null){
			tivo=new TeamInfoVO(name, "??", "??", "??", "??", "??", "??");
			tdvo=new TeamSeasonDataVO(season, name, null, 0, 0,0, 0,0,0, 0, 0, 0, 0,0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
			
		}
		tvo=new TeamVO(tivo,tdvo);
		
		DOMRasterizer rasterizer = new DOMRasterizer();
		File svgpic=new File("pic\\teams\\"+teamnameAbb+".svg");
		File file=new File("pic/TEAMPNG/"+teamnameAbb+".png");
		if(svgpic.exists()){//svg图片存在
			if(!file.exists()){//png不存在	，新建png图片		
				InputStream in = new FileInputStream(svgpic);			
				Document svgXmlDoc = rasterizer.createDocument(in);
			    // Save this SVG into a file (required by SVG -> PNG transformation process)			
				File svgFile = File.createTempFile("graphic-", ".svg");			
				Transformer transformer = TransformerFactory.newInstance().newTransformer();		
				DOMSource source = new DOMSource(svgXmlDoc);			
				FileOutputStream fos = new FileOutputStream(svgFile);			
				try {			
					transformer.transform(source, new StreamResult(fos));			
				} finally {			  
					fos.close();			
				}
			    // Convert the SVG into PNG
			    //TODO 保存为同名文件
			    File outputFile =new File("pic/TEAMPNG/"+teamnameAbb+".png");
			    SVGConverter converter = new SVGConverter();
			    converter.setDestinationType(DestinationType.PNG);
			    converter.setSources(new String[]{svgFile.toString()});
			    converter.setDst(outputFile);
			    converter.execute();		
			}
			//否则，直接用
			image = new ImageIcon("pic\\TEAMPNG\\"+teamnameAbb+".PNG");
		}else{//svg图片不存在
			image=new ImageIcon("pic\\nothing.jpg");
		}
		//显示图片
		image.setImage(image.getImage().getScaledInstance(247,222,Image.SCALE_DEFAULT)); 
		JLabel photo = new JLabel(image);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pic\\portrait\\Aaron Brooks.png"));
		photo.setBounds(12, 13, 247, 222);
		photo.setOpaque(false);
		add(photo);
		photo.setBorder(BorderFactory.createLineBorder(line));
		
		//TODO 球队名称
		//System.out.println(tvo.getInfo().getFullName());
		JLabel teamname = new JLabel(tvo.getInfo().getFullName());
		teamname.setForeground(Color.DARK_GRAY);
		teamname.setFont(new Font("微软雅黑", Font.BOLD, 30));
		teamname.setBounds(275, 15, 247, 45);
		add(teamname);
		//TODO 胜负情况
		PartitionMap ss=new PartitionMap();
		JLabel basicin = new JLabel("联盟："+ss.getItem(tvo.getInfo().getPartition())+"/"+tvo.getInfo().getLocation());
		basicin.setForeground(Color.WHITE);
		basicin.setFont(new Font("微软雅黑", Font.BOLD, 12));
		basicin.setBounds(280, 48, 180, 25);
		add(basicin);
		
		JLabel label = new JLabel("建队时间:"+tvo.getInfo().getFormedTime());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("微软雅黑", Font.BOLD, 12));
		label.setBounds(280, 65, 180, 25);
		add(label);
		
		JLabel losewin = new JLabel(tvo.getData().getWinNum()+"W - "+
				(tvo.getData().getMatchNum()-tvo.getData().getWinNum())+"L");
		losewin.setForeground(Color.WHITE);
		losewin.setFont(new Font("微软雅黑", Font.BOLD, 12));
		losewin.setBounds(480, 35, 80, 25);
		add(losewin);
		//TODO 比赛场数
		JLabel matchcounts = new JLabel("\u6BD4\u8D5B\u573A\u6570\uFF1A"+String.valueOf(tvo.getData().getMatchNum()));
		matchcounts.setForeground(Color.WHITE);
		matchcounts.setFont(new Font("微软雅黑", Font.BOLD, 12));
		matchcounts.setBounds(480, 55, 80, 15);
		add(matchcounts);
		//TODO 得分
		JLabel points = new JLabel("\u5F97\u5206\uFF1A"+String.valueOf(tvo.getData().getPointNum()));
		points.setForeground(Color.WHITE);
		points.setFont(new Font("微软雅黑", Font.BOLD, 12));
		points.setBounds(480, 70, 80, 15);
		add(points);
		
		int countnum=tvo.getData().getMatchNum();
		
		
	
		//TODO
		JLabel toulanchushou = new JLabel("\u6295\u7BEE\u51FA\u624B\uFF1A"+getCalc(tvo.getData().getShootNum(),countnum));
		toulanchushou.setForeground(new Color(51, 0, 51));
		toulanchushou.setFont(new Font("黑体", Font.PLAIN, 15));
		toulanchushou.setBounds(270, 95, 150, 18);
		add(toulanchushou);
		//TODO
		JLabel toulanmingzhong = new JLabel("\u6295\u7BEE\u547D\u4E2D\uFF1A"+getCalc(tvo.getData().getFieldGoal(),countnum));
		toulanmingzhong.setForeground(new Color(51, 0, 51));
		toulanmingzhong.setFont(new Font("黑体", Font.PLAIN, 15));
		toulanmingzhong.setBounds(270, 115, 150, 18);
		add(toulanmingzhong);
		//TODO
		JLabel sanfenchushou = new JLabel("\u4E09\u5206\u51FA\u624B\uFF1A"+getCalc(tvo.getData().getT_shootNum(),countnum));
		sanfenchushou.setForeground(new Color(51, 0, 51));
		sanfenchushou.setFont(new Font("黑体", Font.PLAIN, 15));
		sanfenchushou.setBounds(270, 135, 150, 18);
		add(sanfenchushou);
		//TODO
		JLabel sanfenmingzhong = new JLabel("\u4E09\u5206\u547D\u4E2D\uFF1A"+getCalc(tvo.getData().getT_fieldGoal(),countnum));
		sanfenmingzhong.setForeground(new Color(51, 0, 51));
		sanfenmingzhong.setFont(new Font("黑体", Font.PLAIN, 15));
		sanfenmingzhong.setBounds(270, 153, 150, 18);
		add(sanfenmingzhong);
		//TODO
		JLabel faqiuchushou = new JLabel("\u7F5A\u7403\u51FA\u624B\uFF1A"+getCalc(tvo.getData().getFreeThrowNum(),countnum));
		faqiuchushou.setForeground(new Color(51, 0, 51));
		faqiuchushou.setFont(new Font("黑体", Font.PLAIN, 15));
		faqiuchushou.setBounds(270, 173, 150, 18);
		add(faqiuchushou);
		//TODO
		JLabel faqiumingzhong = new JLabel("\u7F5A\u7403\u547D\u4E2D\uFF1A"+getCalc(tvo.getData().getFreeThrowGoalNum(),countnum));
		faqiumingzhong.setForeground(new Color(51, 0, 51));
		faqiumingzhong.setFont(new Font("黑体", Font.PLAIN, 15));
		faqiumingzhong.setBounds(270, 191, 150, 18);
		add(faqiumingzhong);
		//TODO
		JLabel fangui = new JLabel("\u72AF\u89C4\uFF1A"+getCalc(tvo.getData().getFoulNum(),countnum));
		fangui.setForeground(new Color(51, 0, 51));
		fangui.setFont(new Font("黑体", Font.PLAIN, 15));
		fangui.setBounds(270, 210, 150, 18);
		add(fangui);
		//TODO
		JLabel lanban = new JLabel("\u7BEE\u677F\uFF1A"+getCalc(tvo.getData().getReboundNum(),countnum));
		lanban.setForeground(new Color(51, 0, 51));
		lanban.setFont(new Font("黑体", Font.PLAIN, 15));
		lanban.setBounds(422, 95, 150, 18);
		add(lanban);
		//TODO
		JLabel jingonglanban = new JLabel("\u8FDB\u653B\u7BEE\u677F\uFF1A"+getCalc(tvo.getData().getO_ReboundNum(),countnum));
		jingonglanban.setForeground(new Color(51, 0, 51));
		jingonglanban.setFont(new Font("黑体", Font.PLAIN, 15));
		jingonglanban.setBounds(422, 115, 150, 18);
		add(jingonglanban);
		//TODO
		JLabel fangshoulanban = new JLabel("\u9632\u5B88\u7BEE\u677F\uFF1A"+getCalc(tvo.getData().getD_ReboundNum(),countnum));
		fangshoulanban.setForeground(new Color(51, 0, 51));
		fangshoulanban.setFont(new Font("黑体", Font.PLAIN, 15));
		fangshoulanban.setBounds(422, 135, 150, 18);
		add(fangshoulanban);
		//TODO
		JLabel zhugong = new JLabel("\u52A9\u653B\uFF1A"+getCalc(tvo.getData().getAssistNum(),countnum));
		zhugong.setForeground(new Color(51, 0, 51));
		zhugong.setFont(new Font("黑体", Font.PLAIN, 15));
		zhugong.setBounds(422, 153, 150, 18);
		add(zhugong);
		//TODO
		JLabel qiangduan = new JLabel("\u62A2\u65AD\uFF1A"+getCalc(tvo.getData().getStealNum(),countnum));
		qiangduan.setForeground(new Color(51, 0, 51));
		qiangduan.setFont(new Font("黑体", Font.PLAIN, 15));
		qiangduan.setBounds(422, 173, 150, 18);
		add(qiangduan);
		//TODO
		JLabel gaimao = new JLabel("\u76D6\u5E3D\uFF1A"+"12"+getCalc(tvo.getData().getBlockNum(),countnum));
		gaimao.setForeground(new Color(51, 0, 51));
		gaimao.setFont(new Font("黑体", Font.PLAIN, 15));
		gaimao.setBounds(422, 191, 150, 18);
		add(gaimao);
		//TODO
		JLabel shiwu = new JLabel("\u5931\u8BEF\uFF1A"+getCalc(tvo.getData().getTurnoverNum(),countnum));
		shiwu.setForeground(new Color(51, 0, 51));
		shiwu.setFont(new Font("黑体", Font.PLAIN, 15));
		shiwu.setBounds(422, 210, 150, 18);
		add(shiwu);
		
		
		//TODO
				Object[][] data=getTeamPlayers(init.pbl.getTeamAllPlayer(season,teamnameAbb));
				String[] t=new String[] {"                          姓名                       ","              位置                ","             球龄            "};
		final CreateTable list=new CreateTable(t,data, 12,265,558,198, 20,new Font("华文新魏", 0, 15),new Font("Dialog", 0, 12));
		add(list);
		
		list.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println(playerlist.getSelectedRow()!=-1);
				// System.out.println(e.getClickCount() == 2);
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 && list.getSelectedRow() != -1) {
					
					String name = list.getValueAt(
							list.getSelectedRow(),0);
					// System.out.println(name);
					init.currentdio="4(1)&"+name+";"+season;
					System.out.println(init.currentpanel);
					SinglePlayer spi = new SinglePlayer(name, season);
					spi.setVisible(true);
					spi.setLocation(375, 80);
				}
				
			}
		});
		/*
		table = new JTable(){    //设置jtable的单元格为透明的
			public Component prepareRenderer(TableCellRenderer renderer,int row,int column){
				Component c=super.prepareRenderer(renderer,row,column);
				if(c instanceof JComponent){
				((JComponent)c).setOpaque(false);
				}
				return c;
				}
		};
		table.getTableHeader().setOpaque(false);
		
		 
		table.setRowHeight(20);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Century", Font.PLAIN, 15));
		table.setBounds(12, 270, 558, 198);
		table.setOpaque(false);
		table.setEnabled(false);
		
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		  tcr.setHorizontalAlignment(JLabel.CENTER);
		//tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		table.setDefaultRenderer(Object.class, tcr);
		JTableHeader tableH = table.getTableHeader();
	    //设置表头的背景色
	    tableH.setBackground(new Color(247,162,19));
		//add(table);
		table.setOpaque(false);  
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
        render.setOpaque(false); //将渲染器设置为透明  
        
		JScrollPane roll=new JScrollPane(table);
		JScrollBar bar = roll.getVerticalScrollBar();
		bar.setBackground(new Color(247,162,19));
	
		//roll.setUI(new ScrollPaneUI());
		
		
		roll.setPreferredSize(new Dimension(558,198-10)); 
		roll.setBounds(12,270,558,198);
		roll.setVisible(true);
		roll.getViewport().setOpaque(false);
		roll.setOpaque(false);
        roll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	roll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	add(roll);
    	*/
    	ImageIcon imagebg = new ImageIcon("pic\\球队背景.png"); 
		imagebg.setImage(imagebg.getImage().getScaledInstance(582,474,Image.SCALE_DEFAULT)); 
		JLabel bg = new JLabel(imagebg);
		//photo.setIcon(new ImageIcon("D:\\\u5927\u4E8C\u4E0B\\java\\DSSforNBA_Client\\pic\\portrait\\Aaron Brooks.png"));
		bg.setBounds(0,0,582,474);	
		add(bg);
	}
	
	
	private Object[][] getTeamPlayers(ArrayList<PlayerInfoVO> players){
		Object[][] temp=new String[players.size()][3];
		PlayerPosition_Map mm=new PlayerPosition_Map();
		for(int i=0;i<players.size();i++){
			temp[i][0]=players.get(i).getName();
			temp[i][1]=players.get(i).getPosition();
			temp[i][2]=String.valueOf(players.get(i).getExp());
		}	
		return temp;
	}
	
	
	private String getCalc(double d,int count){
		double result=(double)(d/count);
		DecimalFormat df = new DecimalFormat( "0.00");    
		String temp=String.valueOf(df.format(result));
		return temp;
	}
}

