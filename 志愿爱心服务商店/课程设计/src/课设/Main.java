package 课设;

//主框体窗口类
//主界面窗口，主要实现每个模块功能的实现
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class MainFrame extends JFrame implements ActionListener{
	//声明要用的所有组件
	JMenuBar menurBar;
	JLabel dangan,dinghuo,ruku,chuku,renyuan,bumen,tiaojian,yonghuming,mima,dingdan,rukushijian,cangku1,chukushi2,bumen2,xingming;
	JButton left,rignt,first,second,third,fouth,fifth,sixth,eight,queding1,queding2;
	JMenu jm1,jm2;
	JMenuItem jmi1,jmi2;
	JPanel zhong,xia1,shang1,xia2,shang2,xia3,shang3,xia4,shang4,xia5,shang5,pp;
	Object  a1[][],a2[][],a3[][],a4[][];
	Object  columnName1[]={"编号","客户","订单号","交货日期","商品名","金额","数量","是否入库"},columnName2[] = {"编号","订单号","仓库编号","货品名称","入库时间","重量","备注"},columnName3[] = {
			"编号","仓库遍号","货品名称","出库时间","重量","备注"},columnName4[] = {"姓名","年龄","性别","职务","部门"};
	JTable table1,table2,table3,table4;
	JComboBox  department;
	JTextField shuru1,yonghu1,mima1,dingdanhao,rukushi,cangku,chukushi,bumen3,xingming2;
	JButton chaxun1,tianjia1,xiugai1,shanchu1,quanbu1,tianjia2,xiugai2,shanchu2,chaxun3,tianjia3,xiugai3,shanchu3,quanbu3,
	chaxun4,tianjia4,xiugai4,shanchu4,quanbu4,chaxun5,tianjia5,xiugai5,shanchu5,quanbu5;
	//构造函数
	public MainFrame()
	{
		setTitle("                                                                                 志愿爱心服务商店");
		setLayout(null);
		menurBar=new JMenuBar();
		setJMenuBar(menurBar);
		jm1=new JMenu("文件");
		jm2=new JMenu("帮助");
		jmi1=new JMenuItem("退出");
		jmi2=new JMenuItem("关于");
		jm1.add(jmi1);
		jm2.add(jmi2);
		menurBar.add(jm1);
		menurBar.add(jm2);
		//热键添加
		jmi1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
		
		//主要分类按钮的初始化，包括添加图标
		//档案管理
		first = new JButton();
		ImageIcon icon1 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/5.png");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/6.png");
		first.setIcon(icon1);                                //初始化背景
		first.setRolloverIcon(icon2);                        //鼠标碰到时显示的图片
		add(first);
		first.setBounds(70, 0, 60, 60);
		dangan = new JLabel("档案管理");
		add(dangan);
		dangan.setBounds(77, 50, 60, 30);
		//采购订货
		second = new JButton();
		ImageIcon icon3 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/7.jpg");
		ImageIcon icon4 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/8.png");
		second.setIcon(icon3);                               //初始化背景
		second.setRolloverIcon(icon4);                       //鼠标碰到时显示的图片
		add(second);
		second.setBounds(230, 0, 60, 60);
		dinghuo = new JLabel("采购订货");
		add(dinghuo);
		dinghuo.setBounds(237, 50, 60, 30);		
		//入库管理
		third = new JButton();
		ImageIcon icon5 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/3.png");
		ImageIcon icon6 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/2.png");
		third.setIcon(icon5);                                //初始化背景
		third.setRolloverIcon(icon6);                        //鼠标碰到时显示的图片
		add(third);
		third.setBounds(390, 0, 60, 60);
		ruku = new JLabel("入库管理");
		add(ruku);
		ruku.setBounds(397, 50, 60, 30);
		//出库管理
		fouth = new JButton();
		ImageIcon icon7 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/9.png");
		ImageIcon icon8 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/10.png");
		fouth.setIcon(icon7);                              //初始化背景
		fouth.setRolloverIcon(icon8);                      //鼠标碰到时显示的图片
		add(fouth);
		fouth.setBounds(550, 0, 60, 60);
		chuku = new JLabel("出库管理");
		add(chuku);
		chuku.setBounds(557, 50, 60, 30);
		//人员管理
		fifth = new JButton();
		ImageIcon icon9 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/11.png");
		ImageIcon icon10 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/12.png");
		fifth.setIcon(icon9);                             //初始化背景
		fifth.setRolloverIcon(icon10);                    //鼠标碰到时显示的图片
		add(fifth);
		fifth.setBounds(710, 0, 60, 60);
		renyuan = new JLabel("人员管理");
		add(renyuan);
		renyuan.setBounds(717, 50, 60, 30);
		//部门管理
		sixth = new JButton();
		ImageIcon icon11 = new ImageIcon("C:\\Users\\LDSY\\Desktop\\爱心商店管理系统\\管理系统\\Java课程设计\\src/13.png");
		ImageIcon icon12 = new ImageIcon("src/14.jpg");
		sixth.setIcon(icon11);                           //初始化背景
		sixth.setRolloverIcon(icon12);                   //鼠标碰到时显示的图片
		add(sixth);
		sixth.setBounds(870, 0, 60, 60);
		bumen = new JLabel("系统人员");
		add(bumen);
		bumen.setBounds(877, 50, 60, 30);
		
		//窗口控制   
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		setSize(1000,900);
		setResizable(false);
		setLocation(screenSize.width/2-1015/2,screenSize.height/2-900/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//在当前窗口的中部分作为实现功能的面板进行初始化
		//中部面板设计
		zhong = new JPanel();
		zhong.setLayout(new BorderLayout());
		add(zhong);
		zhong.setBounds(0, 100, 1000, 800);
		pp =new JPanel();
		pp.setLayout(null);
		zhong.add(pp);
		ImageIcon icon13 = new ImageIcon("src/15.jpg");
		eight = new JButton();
		eight.setIcon(icon13);
		pp.add(eight);
		eight.setBounds(0, 0, 1000, 800);
		
		
		//采购
		shang1 = new JPanel();
		shang1.setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
		tiaojian = new JLabel("编号");
		shang1.add(tiaojian);    
		shuru1 = new JTextField(20);
		shang1.add(shuru1);
		chaxun1 = new JButton("查询");
		shang1.add(chaxun1);
		tianjia1 = new JButton("添加");
		shang1.add(tianjia1);
		xiugai1 = new JButton("修改");
		shang1.add(xiugai1);
		shanchu1 = new JButton("删除");
		shang1.add(shanchu1);
		quanbu1 = new JButton("浏览");
		shang1.add(quanbu1);
		//采购（表）
		a1 = new Object[60][8];
		table1 = new  JTable(a1, columnName1);
		xia1 = new JPanel();
		xia1.setLayout(new BorderLayout());
		xia1.add(new JScrollPane(table1));


		//人员管理（功能表）
		shang2 = new JPanel();
		shang2.setLayout(new FlowLayout(FlowLayout.LEFT,140,20));
		tianjia2 = new JButton("添加");
		shang2.add(tianjia2);
		xiugai2 = new JButton("修改");
		shang2.add(xiugai2);
		queding1 = new JButton("确定修改");
		shang2.add(queding1);
		shanchu2 = new JButton("删除");
		shang2.add(shanchu2);
		//人员(输入框)
		xia2 = new JPanel();
		xia2.setLayout(null);
		yonghu1 = new JTextField(20);
		mima1 = new JTextField(20);
		yonghuming = new JLabel("用户名：");
		mima = new JLabel("密码：");
		xia2.add(yonghuming);
		yonghuming.setBounds(200, 150, 60, 30);
		xia2.add(yonghu1);
		yonghu1.setBounds(270,150, 500, 25);
		xia2.add(mima);
		mima.setBounds(200, 230, 60, 30);
		xia2.add(mima1);
		mima1.setBounds(270, 230, 500, 25);


		//入库
		shang3 = new JPanel();
		shang3.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		dingdan = new JLabel("订单号：");
		shang3.add(dingdan);
		dingdanhao = new JTextField(20);
		shang3.add(dingdanhao);
		rukushijian = new JLabel("入库时间：");
		shang3.add(rukushijian);
		rukushi = new JTextField(20);
		shang3.add(rukushi);
		chaxun3 = new JButton("查询");
		shang3.add(chaxun3);
		tianjia3 = new JButton("添加");
		shang3.add(tianjia3);
		xiugai3 = new JButton("修改");
		shang3.add(xiugai3);
		shanchu3 = new JButton("删除");
		shang3.add(shanchu3);
		quanbu3 = new JButton("浏览");
		shang3.add(quanbu3);
		//入库（表）
		a2 = new Object[60][7];
		table2 = new  JTable(a2, columnName2);
		xia3 = new JPanel();
		xia3.setLayout(new BorderLayout());
		xia3.add(new JScrollPane(table2));


		//出库
		shang4 = new JPanel();
		shang4.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		cangku1 = new JLabel("仓库：");
		shang4.add(cangku1);
		cangku = new JTextField(20);
		shang4.add(cangku);
		chukushi2 = new JLabel("出库时间：");
		shang4.add(chukushi2);
		chukushi = new JTextField(20);
		shang4.add(chukushi);
		chaxun4 = new JButton("查询");
		shang4.add(chaxun4);
		tianjia4 = new JButton("添加");
		shang4.add(tianjia4);
		xiugai4 = new JButton("修改");
		shang4.add(xiugai4);
		shanchu4 = new JButton("删除");
		shang4.add(shanchu4);
		quanbu4 = new JButton("浏览");
		shang4.add(quanbu4);
		//出库（表）
		a3 = new Object[60][6];
		table3 = new  JTable(a3, columnName3);
		xia4 = new JPanel();
		xia4.setLayout(new BorderLayout());
		xia4.add(new JScrollPane(table3));

		
		//人员管理
		shang5 = new JPanel();
		shang5.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
		bumen = new JLabel("部门：");
		shang5.add(bumen);
		bumen3 = new JTextField(20);
		shang5.add(bumen3);
		xingming = new JLabel("姓名：");
		shang5.add(xingming);
		xingming2 = new JTextField(20);
		shang5.add(xingming2);
		chaxun5 = new JButton("查询");
		shang5.add(chaxun5);
		tianjia5 = new JButton("添加");
		shang5.add(tianjia5);
		xiugai5 = new JButton("修改");
		shang5.add(xiugai5);
		shanchu5 = new JButton("删除");
		shang5.add(shanchu5);
		quanbu5 = new JButton("浏览");
		shang5.add(quanbu5);
		//人员管理（表）
		a4= new Object[60][5];
		table4 = new  JTable(a4, columnName4);
		xia5 = new JPanel();
		xia5.setLayout(new BorderLayout());
		xia5.add(new JScrollPane(table4));

		
		//注册监听器
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		first.addActionListener(this);
		second.addActionListener(this);
		third.addActionListener(this);
		fouth.addActionListener(this);
		fifth.addActionListener(this);
		sixth.addActionListener(this);
		chaxun1.addActionListener(this);
		chaxun3.addActionListener(this);
		chaxun4.addActionListener(this);
		chaxun5.addActionListener(this);
		quanbu1.addActionListener(this);
		quanbu3.addActionListener(this);
		quanbu4.addActionListener(this);
		quanbu5.addActionListener(this);
		tianjia1.addActionListener(this);
		tianjia2.addActionListener(this);
		tianjia3.addActionListener(this);
		tianjia4.addActionListener(this);
		tianjia5.addActionListener(this);
		xiugai1.addActionListener(this);
		xiugai2.addActionListener(this);
		xiugai3.addActionListener(this);
		xiugai4.addActionListener(this);
		xiugai5.addActionListener(this);
		shanchu1.addActionListener(this);
		shanchu2.addActionListener(this);
		shanchu3.addActionListener(this);
		shanchu4.addActionListener(this);
		shanchu5.addActionListener(this);
		queding1.addActionListener(this);

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
	//所有监听的实现
	//两个用于循环的变量
	int i = 0,j = 0,temp = 0;
	public void actionPerformed(ActionEvent e)
	{
		//菜单方面的监听实现
		if(e.getSource()==jmi1)            //退出
		{
			int i=JOptionPane.showConfirmDialog(null,"确定退出吗？");
			switch(i){
			case JOptionPane.YES_OPTION:
				System.exit(0);
			case JOptionPane.NO_OPTION:
			}

		}

		if(e.getSource()==jmi2)            //关于
		{
			JOptionPane.showMessageDialog(null,"  制作者：刘德诗懿，闫思帆！");
		}
      //基本档案管理要求实现多方面的呈现，采用新窗口实现
		if(e.getSource()==first)          
		{
			InformationFrame a = new InformationFrame();
		}
      //采购
		if(e.getSource()==second)
		{
			zhong.removeAll();
			zhong.add(xia1,BorderLayout.CENTER);
			zhong.add(shang1,BorderLayout.NORTH);
			zhong.updateUI();
		}
      //入库
		if(e.getSource()==third)
		{
			zhong.removeAll();
			zhong.add(shang3,BorderLayout.NORTH);
			zhong.add(xia3,BorderLayout.CENTER);
			zhong.updateUI();

		}
      //出库
		if(e.getSource()==fouth)
		{
			zhong.removeAll();
			zhong.add(shang4,BorderLayout.NORTH);
			zhong.add(xia4,BorderLayout.CENTER);
			zhong.updateUI();
		}
      //人员
		if(e.getSource()==fifth)
		{
			zhong.removeAll();
			zhong.add(shang5,BorderLayout.NORTH);
			zhong.add(xia5,BorderLayout.CENTER);
			zhong.updateUI();
		}
      //管理员
		if(e.getSource()==sixth)
		{
			zhong.removeAll();
			zhong.add(xia2,BorderLayout.CENTER);
			zhong.add(shang2,BorderLayout.NORTH);
			zhong.updateUI();

		}
		
		//采购栏下的增删改查功能的实现
		if(e.getSource()==chaxun1)
		{
			String test1 = shuru1.getText();
			System.out.println(test1);
			while(i>=0) {                                 //清空上次查询结果
				for( j = 0;j<8;j++)
				{
					a1[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
					if(aa.equals(test1))
					{
						//将字段写入表格中
						a1[i][0] = aa;  
						a1[i][1] = bb;
						a1[i][2] = cc;
						a1[i][3] = dd;
						a1[i][4] = ee;
						a1[i][5] = ff;
						a1[i][6] = gg;
						a1[i][7] = hh;
						i++;
					}
				}
				//查询不到数据的应答
				if(i == 0)
				{
					JOptionPane.showMessageDialog(null,"没有查询到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
		}

		if(e.getSource()==tianjia1)
		{
			Program1 l = new Program1();
		}
		if(e.getSource()==xiugai1)
		{
			Program2 dd = new Program2();
		}
		if(e.getSource()==shanchu1)
		{
			String test1 = shuru1.getText();
			Connection  con; Statement  sql; int  rs1;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM huopin2 WHERE 编号='"+test1+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				if((rs1)>0)
				{
					JOptionPane.showMessageDialog(null,"删除成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"没有找到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				con.commit();        //事务提交
				con.close();
			}catch(SQLException eq){ 
				System.out.println(e.toString());}
		}
		if(e.getSource()==quanbu1)
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<8;j++)
				{
					a1[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
					//将字段写入表格中
					a1[i][0] = aa;  
					a1[i][1] = bb;
					a1[i][2] = cc;
					a1[i][3] = dd;
					a1[i][4] = ee;
					a1[i][5] = ff;
					a1[i][6] = gg;
					a1[i][7] = hh;
					//下一行
					i++;	        
				}				
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
		}


		//入库
		if(e.getSource()==chaxun3)
		{
			String test1 = dingdanhao.getText();
			String test2 = rukushi.getText();
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<7;j++)
				{
					a2[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
				ResultSet rs = sql.executeQuery("SELECT * FROM ruku");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("编号");	
					String bb = rs.getString("订单号");
					String cc = rs.getString("仓库编号");
					String dd = rs.getString("货品名称");	
					String ee = rs.getString("入库时间");	
					String ff = rs.getString("重量");	
					String gg = rs.getString("备注");
					//比对
					if(bb.equals(test1)||ee.equals(test2))
					{
						//将字段写入表格中
						a2[i][0] = aa;  
						a2[i][1] = bb;
						a2[i][2] = cc;
						a2[i][3] = dd;
						a2[i][4] = ee;
						a2[i][5] = ff;
						a2[i][6] = gg;
						i++;
					}

				}
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
			if(i == 0)
			{
				JOptionPane.showMessageDialog(null,"没有查询到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}

		if(e.getSource()==tianjia3)
		{
			INtianjia l = new INtianjia();
		}
		if(e.getSource()==xiugai3)
		{
			INxiugai j = new INxiugai();
		}
		if(e.getSource()==shanchu3)
		{
			String test1 = dingdanhao.getText();
			String test2 = rukushi.getText();
			Connection  con; Statement  sql; int  rs1,rs2;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM ruku WHERE 编号='"+test1+"'";
				String strSQLDelete2 = "DELETE FROM ruku WHERE 入库时间='"+test2+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);  
				System.out.println("删除信息记录条数："+rs1);
				rs2 = sql.executeUpdate(strSQLDelete2);
				System.out.println("删除信息记录条数："+rs2);
				if((rs1+rs2)>0)
				{
					JOptionPane.showMessageDialog(null,"删除成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"没有找到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				con.commit();        //事务提交
				con.close();
			}catch(SQLException eq){ 
				System.out.println(e.toString());}
		}
		if(e.getSource()==quanbu3)
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<7;j++)
				{
					a2[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
				ResultSet rs = sql.executeQuery("SELECT * FROM ruku");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("编号");
					String bb = rs.getString("订单号");
					String cc = rs.getString("仓库编号");
					String dd = rs.getString("货品名称");
					String ee = rs.getString("入库时间");
					String ff = rs.getString("重量");
					String gg = rs.getString("备注");
					//将字段写入表格中
					a2[i][0] = aa;  
					a2[i][1] = bb;
					a2[i][2] = cc;
					a2[i][3] = dd;
					a2[i][4] = ee;
					a2[i][5] = ff;
					a2[i][6] = gg;
					//下一行
					i++;	        
				}				
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("");
			}
		}

		//出库
		if(e.getSource()==quanbu4)
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<6;j++)
				{
					a3[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
				ResultSet rs = sql.executeQuery("SELECT * FROM chuku");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("编号");
					String bb = rs.getString("仓库编号");
					String cc = rs.getString("货品名称");
					String dd = rs.getString("出库时间");
					String ee = rs.getString("重量");
					String ff = rs.getString("备注");
					//将字段写入表格中
					a3[i][0] = aa;  
					a3[i][1] = bb;
					a3[i][2] = cc;
					a3[i][3] = dd;
					a3[i][4] = ee;
					a3[i][5] = ff;
					//下一行
					i++;	        
				}				
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
		}
		if(e.getSource()==chaxun4)
		{
			String test1 = cangku.getText();
			String test2 = chukushi.getText();
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<6;j++)
				{
					a3[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
				ResultSet rs = sql.executeQuery("SELECT * FROM chuku");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("编号");
					String bb = rs.getString("仓库编号");
					String cc = rs.getString("货品名称");
					String dd = rs.getString("出库时间");
					String ee = rs.getString("重量");
					String ff = rs.getString("备注");
					//比对
					if(bb.equals(test1)||dd.equals(test2))
					{
						System.out.println("5");       //验证是否比对成功
						//将字段写入表格中
						a3[i][0] = aa;  
						a3[i][1] = bb;
						a3[i][2] = cc;
						a3[i][3] = dd;
						a3[i][4] = ee;
						a3[i][5] = ff;
						i++;
					}

				}
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
			if(i == 0)
			{
				JOptionPane.showMessageDialog(null,"没有查询到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}
		if(e.getSource()==tianjia4)
		{
			OUTtianjia l = new OUTtianjia();
		}
		if(e.getSource()==xiugai4)
		{
			OUTxiugai j = new OUTxiugai();
		}
		if(e.getSource()==shanchu4)
		{
			String test1 = cangku.getText();
			String test2 = chukushi.getText();
			Connection  con; Statement  sql; int  rs1,rs2;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM chuku WHERE 仓库编号='"+test1+"'";
				String strSQLDelete2 = "DELETE FROM chuku WHERE 出库时间='"+test2+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);  
				System.out.println("删除信息记录条数："+rs1);
				rs2 = sql.executeUpdate(strSQLDelete2);
				System.out.println("删除信息记录条数："+rs2);
				if((rs1+rs2)>0)
				{
					JOptionPane.showMessageDialog(null,"删除成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"没有找到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				con.commit();        //事务提交
				con.close();
			}catch(SQLException eq){ 
				System.out.println(e.toString());}
		}
		
		//管理员管理
		if(e.getSource()==tianjia2)
		{
			String shuju1 = yonghu1.getText();
			String shuju2 = mima1.getText();
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
					String strSQLInsert = "INSERT INTO user VALUES ('"+shuju1+"','"+shuju2+"')";

					rs = sql.executeUpdate(strSQLInsert);   //添加一条记录并返回添加记录条数
					System.out.println("添加信息记录条数："+rs);
					if(rs > 0)
					{
						JOptionPane.showMessageDialog(null,"添加成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
					}
					con.commit();        //事务提交
					con.close();
				}catch(SQLException ev){ 
					JOptionPane.showMessageDialog(null,"用户名重复，添加失败！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
			case JOptionPane.NO_OPTION:
			}
		}
		if(e.getSource()==xiugai2)
		{
			String shuju1 = yonghu1.getText();
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
				ResultSet rs = sql.executeQuery("SELECT * FROM user");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("用户名");
					String bb = rs.getString("密码");

					//比对
					if(aa.equals(shuju1))
					{
						System.out.println("5");       //验证是否比对成功
						//将字段写入表格中
						mima1.setText(bb);
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
				mima1.setText("");
			}
			temp = 0;
			
		}
		if(e.getSource()==queding1)
		{
			String aa,bb;
			aa = yonghu1.getText();
			bb = mima1.getText();
			System.out.println(aa+bb);
			Connection  con; Statement  sql; int  rs;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ed){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLUpdate = "UPDATE user SET 用户名='"+aa+"',密码='"+bb+"' WHERE 用户名='"+aa+"'";
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
			}catch(SQLException ea){ 
				System.out.println(e.toString());
			}
		}
		if(e.getSource()==shanchu2)
		{
			String shuju1 = yonghu1.getText();
			Connection  con; Statement  sql; int  rs1,rs2,rs3,rs4;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM user WHERE 用户名='"+shuju1+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				if((rs1)>0)
				{
					JOptionPane.showMessageDialog(null,"删除成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"没有找到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				con.commit();        //事务提交
				con.close();

			}catch(SQLException eq){ 
				System.out.println(e.toString());}
		}

		//人员管理
		if(e.getSource()==quanbu5)
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<5;j++)
				{
					a4[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
					//将字段写入表格中
					a4[i][0] = aa;  
					a4[i][1] = bb;
					a4[i][2] = cc;
					a4[i][3] = dd;
					a4[i][4] = ee;
					//下一行
					i++;	        
				}				
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}
		}
		if(e.getSource()==chaxun5)
		{
			String test1 = bumen3.getText();
			String test2 = xingming2.getText();
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<5;j++)
				{
					a4[i][j] = "";
				}	  
				i--;
			}
			i = 0;
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
					//比对
					if(ee.equals(test1)||aa.equals(test2))
					{
						System.out.println("5");       //验证是否比对成功
						//将字段写入表格中
						a4[i][0] = aa;  
						a4[i][1] = bb;
						a4[i][2] = cc;
						a4[i][3] = dd;
						a4[i][4] = ee;
						i++;
					}
				}
				con.close();
				repaint();   //刷新
			}
			catch(SQLException ew){ 
				System.out.println("表出问题");
			}	
			if(i == 0)
			{
				JOptionPane.showMessageDialog(null,"没有查询到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}
		if(e.getSource()==xiugai5)
		{
			Renxiugai j = new Renxiugai();
		}
		if(e.getSource()==shanchu5)
		{
			String test2 = xingming2.getText();
			Connection  con; Statement  sql; int  rs1,rs2,rs3,rs4;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM people WHERE 姓名='"+test2+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				if((rs1)>0)
				{
					JOptionPane.showMessageDialog(null,"删除成功！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"没有找到相应数据！","警告",JOptionPane.INFORMATION_MESSAGE,null);
				}
				con.commit();        //事务提交
				con.close();

			}catch(SQLException eq){ 
				System.out.println(e.toString());}
		}
		if(e.getSource()==tianjia5)
		{
			Rentianjia j = new Rentianjia();
		}
	}
}
public class Main{
	public static void main(String args[])
	{
		MainFrame a = new MainFrame();
	}
}