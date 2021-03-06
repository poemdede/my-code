package 课设;


import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
class Project3 extends JFrame implements ActionListener{
	 JTextField first,second,third,fouth,fifth,sixth,seven;
	 JButton xiugai,queding,quxiao;
	 JLabel bianhao,mingcheng,dizhi,lianxiren,dianhua,chuanzhen,youbian;
	 public Project3()
	 {
		 //UI初始化
		 setLayout(null);
		 setTitle("修改货品信息");
		 mingcheng = new JLabel("货品名称：");
		 add(mingcheng);
		 mingcheng.setBounds(20, 20, 60, 25);
		 first = new JTextField(20);
		 add(first);
		 first.setBounds(80, 20, 200, 25);
		 dizhi = new JLabel("货品描述：");
		 add(dizhi);
		 dizhi.setBounds(320, 20, 60, 25);
		 second = new JTextField(20);
		 add(second);
		 second.setBounds(380, 20, 200, 25);
		 lianxiren = new JLabel("单位：");
		 add(lianxiren);
		 lianxiren.setBounds(20,70 , 60, 25);
		 third = new JTextField(20);
		 add(third);
		 third.setBounds(80, 70, 200, 25);
		 dianhua = new JLabel("进货价：");
		 add(dianhua);
		 dianhua.setBounds(320, 70, 60, 25);
		 fouth = new JTextField(20);
		 add(fouth);
		 fouth.setBounds(380, 70, 200, 25);
		 chuanzhen = new JLabel("零售价：");
		 add(chuanzhen);
		 chuanzhen.setBounds(20, 120, 60, 25);
		 fifth = new JTextField(20);
		 add(fifth);
		 fifth.setBounds(80, 120, 200, 25);
		 youbian = new JLabel("爱心价：");
		 add(youbian);
		 youbian.setBounds(320, 120, 60, 25);
		 sixth = new JTextField(20);
		 add(sixth);
		 sixth.setBounds(380, 120, 200, 25);
		 bianhao = new JLabel("请输入要修改的货品编号：");
		 add(bianhao);
		 bianhao.setBounds(20, 170,150, 25);
		 seven = new JTextField(20);
		 add(seven);
		 seven.setBounds(180,170, 200, 25);
		 xiugai = new JButton("修改");
		 add(xiugai);
		 xiugai.setBounds(400, 170, 60, 25);
		 queding = new JButton("确定");
		 add(queding);
		 queding.setBounds(130, 215, 80, 30);
		 quxiao = new JButton("取消");
		 add(quxiao);
		 quxiao.setBounds(390, 215, 80, 30);
		 //注册监听器
		 xiugai.addActionListener(this);
		 queding.addActionListener(this);
		 quxiao.addActionListener(this);
		 
		 //窗口设置
		 setSize(600,290);
		 setLocationRelativeTo(null);
		 //居中
		 setResizable(false);
		 //大小不可改变
		 setVisible(true);
		 //可见
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	 int temp = 0;
	//
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==xiugai)
		{
			String shuju = seven.getText();
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
				ResultSet rs = sql.executeQuery("SELECT * FROM huopin");
				while(rs.next())
				{
					String aa = rs.getInt("编号")+"";					
					String bb = rs.getString("货品名称");					
					String cc = rs.getString("货品描述");
					String dd = rs.getString("单位");	
					String ee = rs.getFloat("进货价")+"";
					String ff = rs.getFloat("零售价")+"";
					String gg = rs.getFloat("爱心价")+"";
					if(aa.equals(shuju))
					{
						first.setText(bb);
						second.setText(cc);
						third.setText(dd);
						fouth.setText(ee);
						fifth.setText(ff);
						sixth.setText(gg);
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
			}
			temp = 0;
		}

		if(e.getSource()==queding)
		{
			//获取修改后的数据
			String aa,bb,cc,dd,ee,ff,gg;
			aa = first.getText();
			bb = second.getText();
			cc = third.getText();
			dd = fouth.getText();
			ee = fifth.getText();
			ff = sixth.getText();
			gg = seven.getText();
			//
			Connection  con; Statement  sql; int  rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ed){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLUpdate = "UPDATE huopin SET 货品名称='"+aa+"',货品描述='"+bb+"',单位='"+cc+"',进货价='"+dd+"',零售价='"+ee+"',爱心价='"+ff+"' WHERE 编号='"+gg+"'";
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
				con.commit();        //事务提交
				con.close();
			}catch(SQLException ea){ 
				System.out.println(e.toString());
			}
			this.dispose();
		}

		if(e.getSource()==quxiao)
		{
			this.dispose();
		}
	}


	//界面优化
	static {  
		try {    
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


public class XiuGai3 {
	public static void main(String[] args) {
		Project3 j = new Project3();
	}

}
