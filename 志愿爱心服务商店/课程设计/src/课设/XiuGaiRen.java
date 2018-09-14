package 课设;


import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
class Renxiugai extends JFrame implements ActionListener{
	 JTextField first,second,third,fouth,seven;
	 JButton xiugai,queding,quxiao;
	 JLabel bianhao,mingcheng,dizhi,lianxiren,dianhua,chuanzhen,youbian;
	 public Renxiugai()
	 {
		 //UI初始化
		 setLayout(null);
		 setTitle("修改人员信息");
		 mingcheng = new JLabel("年龄：");
		 add(mingcheng);
		 mingcheng.setBounds(20, 20, 60, 25);
		 first = new JTextField(20);
		 add(first);
		 first.setBounds(80, 20, 200, 25);
		 dizhi = new JLabel("性别：");
		 add(dizhi);
		 dizhi.setBounds(320, 20, 60, 25);
		 second = new JTextField(20);
		 add(second);
		 second.setBounds(380, 20, 200, 25);
		 lianxiren = new JLabel("职务：");
		 add(lianxiren);
		 lianxiren.setBounds(20,70 , 60, 25);
		 third = new JTextField(20);
		 add(third);
		 third.setBounds(80, 70, 200, 25);
		 dianhua = new JLabel("部门：");
		 add(dianhua);
		 dianhua.setBounds(320, 70, 60, 25);
		 fouth = new JTextField(20);
		 add(fouth);
		 fouth.setBounds(380, 70, 200, 25);
		 bianhao = new JLabel("请输入要修改的入库姓名：");
		 add(bianhao);
		 bianhao.setBounds(50, 170,150, 25);
		 seven = new JTextField(20);
		 add(seven);
		 seven.setBounds(210,170, 200, 25);
		 xiugai = new JButton("修改");
		 add(xiugai);
		 xiugai.setBounds(430, 170, 60, 25);
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
				ResultSet rs = sql.executeQuery("SELECT * FROM people");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("姓名");
					String bb = rs.getString("年龄");
					String cc = rs.getString("性别");
					String dd = rs.getString("职务");
					String ee = rs.getString("部门");
					if(aa.equals(shuju))
					{
						first.setText(bb);
						second.setText(cc);
						third.setText(dd);
						fouth.setText(ee);
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
				first.setText(" ");
				second.setText(" ");
				third.setText(" ");
				fouth.setText(" ");
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
				String strSQLUpdate = "UPDATE people SET 年龄='"+aa+"',性别='"+bb+"',职务='"+cc+"',部门='"+dd+"' WHERE 姓名='"+gg+"'";
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


public class XiuGaiRen {
	public static void main(String[] args) {
		Renxiugai j = new Renxiugai();
	}

}
