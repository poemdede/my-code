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

class GetAdd3 extends JFrame implements ActionListener{
	 JTextField first,second,third,fouth,fifth,sixth,seven;
	 JButton queding,quxiao;
	 JLabel bianhao,mingcheng,dizhi,lianxiren,dianhua,chuanzhen,youbian;
	 public GetAdd3()
	 {
		 //UI初始化
		 setLayout(null);
		 setTitle("添加货品");
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
		 bianhao = new JLabel("编号：");
		 add(bianhao);
		 bianhao.setBounds(20, 170, 60, 25);
		 seven = new JTextField(20);
		 add(seven);
		 seven.setBounds(80,170, 200, 25);
		 queding = new JButton("确定");
		 add(queding);
		 queding.setBounds(130, 215, 80, 30);
		 quxiao = new JButton("取消");
		 add(quxiao);
		 quxiao.setBounds(390, 215, 80, 30);
		 //注册监听器
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
	 //监听的实现
	 public void actionPerformed(ActionEvent e)
	 {
		 String aa,bb,cc,dd,ee,ff,gg;
		 aa = first.getText();
		 bb = second.getText();
		 cc = third.getText();
		 dd = fouth.getText();
		 ee = fifth.getText();
		 ff = sixth.getText();
		 gg = seven.getText();
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
					 String strSQLInsert = "INSERT INTO huopin VALUES ('"+gg+"','"+aa+"','"+bb+"','"+cc+"','"+dd+"','"+ee+"','"+ff+"')";
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
public class TianJia3 {


	public static void main(String[] args) {
		GetAdd3 l = new GetAdd3();

	}

}
