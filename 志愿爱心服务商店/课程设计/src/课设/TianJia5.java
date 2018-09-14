package 课设;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

class GetAdd5 extends JFrame implements ActionListener{
	 JTextField first,second;
	 JButton queding,quxiao;
	 JLabel dianhua,mingcheng;;
	 public GetAdd5()
	 {
		 //UI初始化
		 setLayout(null);
		 setTitle("添加人员");
		 mingcheng = new JLabel("姓名：");
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
		 queding.setBounds(50, 175, 80, 30);
		 quxiao = new JButton("取消");
		 add(quxiao);
		 quxiao.setBounds(230, 176, 80, 30);
		 //注册监听器
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
	 //监听的实现
	 public void actionPerformed(ActionEvent e)
	 {
		 String aa,bb;
		 aa = first.getText();
		 bb = second.getText();
		 if(e.getSource()==queding)            
		 {
			int i=JOptionPane.showConfirmDialog(null,"确定添加吗？");
			 switch(i){
			 case JOptionPane.YES_OPTION:
				 Connection  con; Statement  sql; int  rs;
				 try {
					 Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
				 }catch(ClassNotFoundException es){}
				 try {//连接数据库
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
					 con.setAutoCommit(false);        //取消事务的自动提交
					 sql = con.createStatement();     //创建SQL语句
					 String strSQLInsert = "INSERT INTO zhiwu VALUES ('"+aa+"','"+bb+"')";
					 rs = sql.executeUpdate(strSQLInsert);   //添加一条记录并返回添加记录条数
					 System.out.println("添加信息记录条数："+rs);
					 if(rs>0)
						{
							JOptionPane.showMessageDialog(null,"添加成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
						}
					 con.commit();        //事务提交
					 con.close();
				 }catch(SQLException ev){ 
					 JOptionPane.showMessageDialog(null,"编号重复，添加失败！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				 }
				 this.dispose();
			 case JOptionPane.NO_OPTION:
			 }
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
public class TianJia5 {
	public static void main(String[] args) {
		GetAdd5 ll =new GetAdd5();
	}

}
