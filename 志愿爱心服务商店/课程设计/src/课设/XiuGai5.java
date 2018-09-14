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

class Project5 extends JFrame implements ActionListener{
	JTextField first,second;
	JButton xiugai,queding,quxiao;
	JLabel dianhua,mingcheng;;
	public Project5()
	{
		//UI初始化
		setLayout(null);
		setTitle("修改人员信息");
		mingcheng = new JLabel("修改姓名：");
		add(mingcheng);
		mingcheng.setBounds(50, 50, 60, 25);
		first = new JTextField(20);
		add(first);
		first.setBounds(110, 50, 200, 25);
		dianhua = new JLabel("职务：");
		add(dianhua);
		dianhua.setBounds(50, 125, 60, 25);
		second = new JTextField(20);
		add(second);
		second.setBounds(110, 125, 200, 25);
		queding = new JButton("确定");
		add(queding);
		queding.setBounds(30, 175, 80, 30);
		xiugai = new JButton("修改");
		add(xiugai);
		xiugai.setBounds(140, 175, 80, 30);
		quxiao = new JButton("取消");
		add(quxiao);
		quxiao.setBounds(250, 176, 80, 30);
		//注册监听器
		xiugai.addActionListener(this);
		queding.addActionListener(this);
		quxiao.addActionListener(this);

		//窗口设置
		setSize(360,260);
		setLocationRelativeTo(null);
		//居中
		setResizable(false);
		//大小不可改变
		setVisible(true);
		//可见
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	int temp = 0;
	//监听的实现
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
				ResultSet rs = sql.executeQuery("SELECT * FROM zhiwu");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("姓名");
					String bb = rs.getString("职务");
					//将字段写入表格中
					if(shuju.equals(aa))
					{
						second.setText(bb);
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

			}
			temp = 0;
		}
		if(e.getSource()==queding)
		{
			String aa,bb,cc,dd;
			 aa = first.getText();
			 bb = second.getText();
			 Connection  con; Statement  sql; int  rs;
				try {
					Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
				}catch(ClassNotFoundException ed){}
				try {//连接数据库
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
					con.setAutoCommit(false);        //取消事务的自动提交
					sql = con.createStatement();     //创建SQL语句
					String strSQLUpdate = "UPDATE zhiwu SET 职务='"+bb+"'";
					rs = sql.executeUpdate(strSQLUpdate);   
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

public class XiuGai5 {
	public static void main(String[] args) 
	{
		Project5 p = new Project5();
	}

}


