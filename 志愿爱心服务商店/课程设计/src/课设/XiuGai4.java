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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class Project4 extends JFrame implements ActionListener{
	JTextField first,second,third,fouth;
	JButton xiugai,queding,quxiao;
	JLabel dianhua,mingcheng,dizhi,lianxiren;
	public Project4()
	{
		//UI初始化
		setLayout(null);
		setTitle("添加仓库");
		mingcheng = new JLabel("库管：");
		add(mingcheng);
		mingcheng.setBounds(20, 50, 60, 25);
		first = new JTextField(20);
		add(first);
		first.setBounds(80, 50, 200, 25);
		dizhi = new JLabel("描述：");
		add(dizhi);
		dizhi.setBounds(320, 50, 60, 25);
		second = new JTextField(20);
		add(second);
		second.setBounds(380, 50, 200, 25);
		lianxiren = new JLabel("库存利用：");
		add(lianxiren);
		lianxiren.setBounds(20,125 , 60, 25);
		third = new JTextField(20);
		add(third);
		third.setBounds(80, 125, 200, 25);
		dianhua = new JLabel("修改编号：");
		add(dianhua);
		dianhua.setBounds(320, 125, 60, 25);
		fouth = new JTextField(20);
		add(fouth);
		fouth.setBounds(380, 125, 200, 25);
		queding = new JButton("确定");
		add(queding);
		queding.setBounds(80, 215, 80, 30);
		xiugai = new JButton("修改");
		add(xiugai);
		xiugai.setBounds(260, 215, 80, 30);
		quxiao = new JButton("取消");
		add(quxiao);
		quxiao.setBounds(440, 215, 80, 30);
		//注册监听器
		xiugai.addActionListener(this);
		queding.addActionListener(this);
		quxiao.addActionListener(this);

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
	int temp = 0;
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==xiugai)
		{
			String shuju = fouth.getText();
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
				ResultSet rs = sql.executeQuery("SELECT * FROM cangku");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getInt("编号")+"";
					String bb = rs.getString("库管");
					String cc = rs.getString("描述");
					String dd = rs.getDouble("库存利用率")+"";
					if(aa.equals(shuju))						
					{
						first.setText(bb);
						second.setText(cc);
						third.setText(dd);
						fouth.setText(aa);
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
			}
			temp = 0;

		}
		if(e.getSource()==queding)
		{
			String aa,bb,cc,dd;
			 aa = first.getText();
			 bb = second.getText();
			 cc = third.getText();
			 dd = fouth.getText();
			 Connection  con; Statement  sql; int  rs;
				try {
					Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
				}catch(ClassNotFoundException ed){}
				try {//连接数据库
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
					con.setAutoCommit(false);        //取消事务的自动提交
					sql = con.createStatement();     //创建SQL语句
					String strSQLUpdate = "UPDATE cangku SET 库管='"+aa+"',描述='"+bb+"',库存利用率='"+cc+"' WHERE 编号='"+dd+"'";
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
public class XiuGai4 {
	public static void main(String[] args) 
	{
		Project4 p = new Project4();
	}

}


