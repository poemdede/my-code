package 课设;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
class Project2 extends JFrame implements ActionListener{
	JTextField first,second,third,fouth,fifth,sixth,seven,eight,nine,eleven;
	JButton xiugai,queding,quxiao;
	JTextArea bei;
	JLabel bianhao,mingcheng,dizhi,lianxiren,dianhua,chuanzhen,youbian,yinhang,wangzhi,youxiang,beizhu;
	Project2()
	{
		setTitle("修改爱心志愿者信息");
		setLayout(null);
		bianhao = new JLabel("请输入要修改的信息编号：");
		add(bianhao);
		bianhao.setBounds(30, 10, 150, 25);
		first = new JTextField(20);
		add(first);
		first.setBounds(180, 10, 300, 25);
		xiugai = new JButton("修改");
		add(xiugai);
		xiugai.setBounds(500, 10, 60, 25);
		mingcheng = new JLabel("志愿天数：");
		add(mingcheng);
		mingcheng.setBounds(30, 65, 60, 25);
		second = new JTextField(20);
		add(second);
		second.setBounds(90, 65, 200, 25);
		dizhi = new JLabel("客户地址：");
		add(dizhi);
		dizhi.setBounds(310, 65, 60, 25);
		third = new JTextField(20);
		add(third);
		third.setBounds(370, 65, 200, 25);
		lianxiren = new JLabel("联系人：");
		add(lianxiren);
		lianxiren.setBounds(30,115 ,60, 25);
		fouth = new JTextField(20);
		add(fouth);
		fouth.setBounds(90, 115, 200, 25);
		dianhua = new JLabel("联系电话：");
		add(dianhua);
		dianhua.setBounds(310, 115, 60, 25);
		fifth = new JTextField(20);
		add(fifth);
		fifth.setBounds(370, 115, 200, 25);
		chuanzhen = new JLabel("传真：");
		add(chuanzhen);
		chuanzhen.setBounds(30, 170, 60, 25);
		sixth = new JTextField(20);
		add(sixth);
		sixth.setBounds(90, 170, 200, 25);
		youbian = new JLabel("邮编：");
		add(youbian);
		youbian.setBounds(310, 170, 60, 25);
		seven = new JTextField(20);
		add(seven);
		seven.setBounds(370, 170, 200, 25);
		yinhang = new JLabel("银行账号：");
		add(yinhang);
		yinhang.setBounds(30, 225, 60, 25);
		eight = new JTextField(20);
		add(eight);
		eight.setBounds(90, 225, 200, 25);
		wangzhi = new JLabel("公司网址：");
		add(wangzhi);
		wangzhi.setBounds(310, 225, 60, 25);
		nine = new JTextField(20);
		add(nine);
		nine.setBounds(370, 225, 200, 25);
		youxiang = new JLabel("邮箱：");
		add(youxiang);
		youxiang.setBounds(30, 280, 60, 25);
		eleven = new JTextField(20);
		add(eleven);
		eleven.setBounds(90, 280, 200, 25);
		beizhu = new JLabel("备注：");
		add(beizhu);
		beizhu.setBounds(30, 325, 60, 25);
		bei = new JTextArea();
		add(bei);
		bei.setBounds(90, 325, 480, 50);
		queding = new JButton("确定");
		add(queding);
		queding.setBounds(130, 405, 80, 30);
		quxiao = new JButton("取消");
		add(quxiao);
		quxiao.setBounds(390,405, 80, 30);
		//窗口设置
		setSize(600,500);
		setLocationRelativeTo(null);
		//居中
		setResizable(false);
		//大小不可改变
		setVisible(true);
		//可见
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		//注册监听器
		xiugai.addActionListener(this);
		queding.addActionListener(this);
		quxiao.addActionListener(this);
	}
	int temp = 0;
	//
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
				ResultSet rs = sql.executeQuery("SELECT * FROM xiaoshoushang");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getInt("编号")+"";
					String bb = rs.getString("志愿天数");
					String cc = rs.getString("地址");
					String dd = rs.getString("联系人");
					String ee = rs.getString("联系电话");
					String ff = rs.getString("传真");
					String gg = rs.getString("邮编");
					String hh = rs.getString("银行账号");
					String ii = rs.getString("公司网址");
					String jj = rs.getString("邮箱地址");
					String kk = rs.getString("备注");
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
						nine.setText(ii);
						eleven.setText(jj);
						bei.setText(kk);
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
			String aa,bb,cc,dd,ee,ff,gg,hh,ii,jj,kk;
			kk = eleven.getText();
			aa = first.getText();
			bb = second.getText();
			cc = third.getText();
			dd = fouth.getText();
			ee = fifth.getText();
			ff = sixth.getText();
			gg = seven.getText();
			hh = eight.getText();
			ii = nine.getText();
			jj = bei.getText();
			//
			Connection  con; Statement  sql; int  rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ed){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLUpdate = "UPDATE xiaoshoushang SET 客户名称='"+bb+"',地址='"+cc+"',联系人='"+dd+"',联系电话='"+ee+"',传真='"+ff+"',邮编='"+gg+"',银行账号='"+hh+"',公司网址='"+ii+"',邮箱地址='"+kk+"',备注='"+jj+"' WHERE 编号='"+aa+"'";
				rs = sql.executeUpdate(strSQLUpdate);   //修改“王五”的数学成绩为100+
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

public class XiuGai2 {
	public static void main(String[] args) {
		Project2 j = new Project2();
	}

}
