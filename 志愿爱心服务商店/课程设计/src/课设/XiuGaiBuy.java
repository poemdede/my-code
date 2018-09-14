package 课设;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class Program2 extends JFrame implements ActionListener{
	JTextField first,second,third,fouth,fifth,sixth,seven,eight,nine,eleven;
	JButton xiugai,queding,quxiao;
	JLabel bianhao,mingcheng,dizhi,lianxiren,dianhua,chuanzhen,youbian,yinhang,wangzhi;
	public Program2()
	{
		//UI初始化
		setLayout(null);
		setTitle("修改采购信息");
		mingcheng = new JLabel("编号：");
		add(mingcheng);
		mingcheng.setBounds(20, 20, 60, 25);
		first = new JTextField(20);
		add(first);
		first.setBounds(80, 20, 200, 25);
		dizhi = new JLabel("客户：");
		add(dizhi);
		dizhi.setBounds(320, 20, 60, 25);
		second = new JTextField(20);
		add(second);
		second.setBounds(380, 20, 200, 25);
		lianxiren = new JLabel("订单号：");
		add(lianxiren);
		lianxiren.setBounds(20,70 , 60, 25);
		third = new JTextField(20);
		add(third);
		third.setBounds(80, 70, 200, 25);
		dianhua = new JLabel("交货日期：");
		add(dianhua);
		dianhua.setBounds(320, 70, 60, 25);
		fouth = new JTextField(20);
		add(fouth);
		fouth.setBounds(380, 70, 200, 25);
		chuanzhen = new JLabel("商品：");
		add(chuanzhen);
		chuanzhen.setBounds(20, 120, 60, 25);
		fifth = new JTextField(20);
		add(fifth);
		fifth.setBounds(80, 120, 200, 25);
		youbian = new JLabel("金额：");
		add(youbian);
		youbian.setBounds(320, 120, 60, 25);
		sixth = new JTextField(20);
		add(sixth);
		sixth.setBounds(380, 120, 200, 25);
		yinhang = new JLabel("数量：");
		add(yinhang);
		yinhang.setBounds(20, 170, 60, 25);
		seven = new JTextField(20);
		add(seven);
		seven.setBounds(80, 170, 200, 25);
		wangzhi = new JLabel("是否入库：");
		add(wangzhi);
		wangzhi.setBounds(320, 170, 60, 25);
		eight = new JTextField(20);
		add(eight);
		eight.setBounds(380, 170, 200, 25);
		queding = new JButton("确定");
		add(queding);
		queding.setBounds(130, 220, 80, 30);
		xiugai = new JButton("修改");
		add(xiugai);
		xiugai.setBounds(265, 220, 80, 30);
		quxiao = new JButton("取消");
		add(quxiao);
		quxiao.setBounds(400, 220, 80, 30);
		//注册监听器
		queding.addActionListener(this);
		quxiao.addActionListener(this);
		xiugai.addActionListener(this);

		//窗口设置
		setSize(600,300);
		setLocationRelativeTo(null);
		//居中
		setResizable(false);
		//大小不可改变
		setVisible(true);
		//可见
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	//监听的实现
	int temp = 0;
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==xiugai)
		{
			String shuju = first.getText();
			System.out.println(shuju);
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("连接成功！");
			}
			catch(ClassNotFoundException es)
			{ 
				System.out.println("连接失败！");
			}     
			try { 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				Statement sql = con.createStatement();
				ResultSet rs = sql.executeQuery("SELECT * FROM huopin2");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("编号");
					String bb = rs.getString("客户");
					String cc = rs.getString("订单号");
					String dd = rs.getString("交货日期");
					String ee = rs.getString("商品");
					String ff = rs.getString("金额");
					String gg = rs.getString("数量");
					String hh = rs.getString("是否入库");
					//比对
					if(shuju.equals(aa))
					{
						second.setText(bb);
						third.setText(cc);
						fouth.setText(dd);
						fifth.setText(ee);
						sixth.setText(ff);
						seven.setText(gg);
						eight.setText(hh);
						temp++;
					}
				}
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
			if(temp==0)
			{
				JOptionPane.showMessageDialog(null,"没有相应数据无法修改！","警告",JOptionPane.INFORMATION_MESSAGE,null);	
				second.setText(" ");
				third.setText(" ");
				fouth.setText(" ");
				fifth.setText(" ");
				sixth.setText(" ");
				seven.setText(" ");
				eight.setText(" ");
			}
			temp = 0;
		}
		if(e.getSource()==queding)
		{
			//获取修改后的数据
			String aa,bb,cc,dd,ee,ff,gg,hh;
			aa = first.getText();
			bb = second.getText();
			cc = third.getText();
			dd = fouth.getText();
			ee = fifth.getText();
			ff = sixth.getText();
			gg = seven.getText();
			hh = eight.getText();

			//
			Connection  con; Statement  sql; int  rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ed){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLUpdate = "UPDATE huopin2 SET 客户='"+bb+"',订单号='"+cc+"',交货日期='"+dd+"',商品='"+ee+"',金额='"+ff+"',数量='"+gg+"',是否入库='"+hh+"'WHERE 编号='"+aa+"'";
				rs = sql.executeUpdate(strSQLUpdate);   //修改“王小五”的数学成绩为100+
				System.out.println("修改信息记录条数："+rs);
				if((rs)>0)
				{
					JOptionPane.showMessageDialog(null,"修改成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"没有找到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}

				con.commit();        //事务提交
				con.close();
			}catch(SQLException ea){ 
				System.out.println(e.toString());
			}
		}
	}
	//界面风格
	static {  
		try {    
			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";            //流畅点
			//String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";                     //基于Java
			//String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";   //windows经典	        	
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
		} catch (ClassNotFoundException e) {  
			e.printStackTrace();  
		} catch (InstantiationException e) {  
			e.printStackTrace();  
		} catch (IllegalAccessException e) {  
			e.printStackTrace();  
		} catch (UnsupportedLookAndFeelException e) {  
			e.printStackTrace();  
		}  
	}

}


public class XiuGaiBuy {
	public static void main(String args[])
	{
		Program2 dd = new Program2();	
	}

}
