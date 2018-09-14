package 课设;


//登录窗口类
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class LoginFrame extends JFrame implements ActionListener
{
	String name,pass;               //用于身份信息的验证
	JTextField zhanghao;            //帐号密码信息的输入
	JPasswordField password;
	JLabel zh,mm,zong,touxiang,shang;
	JButton login;
	ImageIcon img,img2 ;
	public LoginFrame()
	{
		//UI组件初始化
		setLayout(null);
		setTitle("欢迎使用志愿爱心商店管理系统");
		img2 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/1.jpg");
		shang = new JLabel(img2);
		add(shang);
		shang.setBounds(0, 0, 400, 200);
		zhanghao = new JTextField("");
		add(zhanghao);
		zhanghao.setBounds(100, 220, 200, 30);
		password = new JPasswordField();
		add(password);
		password.setBounds(100, 250, 200, 30);
		zh = new JLabel("账号");
		add(zh);
		zh.setBounds(310, 220, 50, 30);
		mm = new JLabel("密码");
		add(mm);
		mm.setBounds(310, 250, 50, 30);
		zong = new JLabel("请输入账号和密码");
		add(zong);
		zong.setBounds(100, 280, 200, 30);
		login = new JButton("登录");
		add(login);
		login.setBounds(100, 310, 200, 30);
		img = new ImageIcon("src/test.jpg");
		touxiang = new JLabel(img);
		add(touxiang);
		touxiang.setBounds(30, 220, 60, 60);
		//按钮注册监听器
		login.addActionListener(this);
		//窗口设置
		setSize(400,400);
		setLocationRelativeTo(null);
		//居中
		setResizable(false);
		//大小不可改变
		setVisible(true);
      //可见
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//按钮监听的实现
	int temp = 0;                                             //用于输入错误的信息时提供应答
	public void actionPerformed(ActionEvent e)
	{
		String xname = null,xpass = null;
		xname = zhanghao.getText();
		xpass = String.valueOf(password.getPassword());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("连接成功！");
		}
		catch(ClassNotFoundException ev)
		{ 
			System.out.println("连接失败！");
		}     
		try { 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
			Statement sql = con.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM user");
			//将数据库管理员信息提出与之对比
			while(rs.next())
			{
				name = rs.getString("用户名");
				pass = rs.getString("密码");
				if(name.equals(xname)&&pass.equals(xpass))
				{
					this.dispose();
					MainFrame l=new MainFrame();
					temp++;
				}
			}
			con.close();
		}
		catch(SQLException ex) 
		{ 
			System.out.println(ex);
		}
		if(temp==0)
		{
		JOptionPane.showMessageDialog(null,"账号或密码输入错误","警告",JOptionPane.INFORMATION_MESSAGE,null);
		password.setText("");  		
		}
	}
	//界面风格
	static {  
		try {    
			String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";            //流畅点	        	
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
public class Login{
	public static void main(String args[])
	{
		LoginFrame l = new LoginFrame();
	}
}
