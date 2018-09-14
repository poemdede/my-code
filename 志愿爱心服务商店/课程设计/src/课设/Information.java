package 课设;

//基本档案管理
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


class InformationFrame extends JFrame implements ActionListener{
	JScrollPane scroll;       //将树添加到滚动面板上
	JTree tree;
	JPanel zuo,xia1,shang1,xia2,shang2,xia3,shang3,xia4,shang4,xia5,shang5;                   
	DefaultMutableTreeNode q,w,x,r,t;
	JButton chaxun1,tianjia1,xiugai1,shanchu1,quanbu1;
	JButton chaxun2,tianjia2,xiugai2,shanchu2,quanbu2;
	JButton chaxun3,tianjia3,xiugai3,shanchu3,quanbu3;
	JButton chaxun4,tianjia4,xiugai4,shanchu4,quanbu4;
	JButton chaxun5,tianjia5,xiugai5,shanchu5,quanbu5;
	JLabel bianhao,kehumingcheng,lianxiren,dizhi;
	Object  a1[][],a2[][],a3[][],a4[][],a5[][];
	Object  columnName1[]={"编号","名称/志愿天数","地址","联系人","联系电话","传真","邮编",
			"银行账号","公司网址","邮箱地址","备注"},columnName2[] = {"编号","货品名称","货品描述","单位","进货价","零售价","爱心价"},columnName3[] = {
			"编号","库管","描述","库存利用率"},columnName4[] = {"姓名","职务"};
	JTable table1,table2,table3,table4,table5;
	JTextField haoma1,kehu1,ren1,zhuzhi1;
	JTextField haoma2,kehu2,ren2,zhuzhi2;
	JTextField huopinmingcheng,haoma3;
	JTextField haoma4,kuguan;
	JTextField xingming;
	public InformationFrame()
	{
		setLayout(new BorderLayout());
		setTitle("基本档案管理系统");

		//创建根节点
		DefaultMutableTreeNode total = new DefaultMutableTreeNode("基本档案管理");
		//创建叶子节点,树的布局
		q = new DefaultMutableTreeNode("爱心供货商管理");
		total.add(q);
		w = new DefaultMutableTreeNode("爱心志愿者管理");
		total.add(w);
		x = new DefaultMutableTreeNode("货品档案管理");
		total.add(x);
		r = new DefaultMutableTreeNode("仓库管理管理");
		total.add(r);
		t = new DefaultMutableTreeNode("职务管理");
		total.add(t);
		tree = new JTree(total);
		scroll = new JScrollPane();
		scroll.getViewport().add(tree);
		add(scroll,BorderLayout.WEST);
		//左部面板布局
		zuo = new JPanel();
		zuo.setLayout(new BorderLayout());
		add(zuo,BorderLayout.CENTER);

		//表格数据显示（供货）
		a1 = new Object[60][11];
		table1 = new  JTable(a1, columnName1);
		xia1 = new JPanel();
		xia1.setLayout(new BorderLayout());
		xia1.add(new JScrollPane(table1)); //添加带滚动条的table	
		//功能栏面板（供货）	
		shang1 = new JPanel();
		shang1.setLayout(new FlowLayout());   
		bianhao = new JLabel("编号");
		shang1.add(bianhao);
		haoma1 = new JTextField(10);
		shang1.add(haoma1);
		kehumingcheng = new JLabel("爱心供货商名称");
		shang1.add(kehumingcheng);     
		kehu1 = new JTextField(10);
		shang1.add(kehu1);     
		lianxiren = new JLabel("联系人");
		shang1.add(lianxiren);     
		ren1 = new JTextField(10);
		shang1.add(ren1);     
		dizhi = new JLabel("地址");
		shang1.add(dizhi);      
		zhuzhi1 = new JTextField(10);
		shang1.add(zhuzhi1);
		chaxun1 = new JButton("查询");
		shang1.add(chaxun1);
		tianjia1 = new JButton("添加");
		shang1.add(tianjia1);
		xiugai1 = new JButton("修改");
		shang1.add(xiugai1);
		shanchu1 = new JButton("删除");
		shang1.add(shanchu1);
		quanbu1 = new JButton("浏览全部信息");
		shang1.add(quanbu1);



		//表（销售商）
		a2 = new Object[60][11];
		table2 = new  JTable(a2, columnName1);
		xia2 = new JPanel();
		xia2.setLayout(new BorderLayout());
		xia2.add(new JScrollPane(table2)); //添加带滚动条的table	
		//功能面板(销售商)
		shang2 = new JPanel();
		shang2.setLayout(new FlowLayout());   
		bianhao = new JLabel("编号");
		shang2.add(bianhao);
		haoma2 = new JTextField(10);
		shang2.add(haoma2);
		kehumingcheng = new JLabel("爱心志愿者");
		shang2.add(kehumingcheng);     
		kehu2 = new JTextField(10);
		shang2.add(kehu2);     
		lianxiren = new JLabel("联系人");
		shang2.add(lianxiren);     
		ren2 = new JTextField(10);
		shang2.add(ren2);     
		dizhi = new JLabel("地址");
		shang2.add(dizhi);      
		zhuzhi2 = new JTextField(10);
		shang2.add(zhuzhi2);
		chaxun2 = new JButton("查询");
		shang2.add(chaxun2);
		tianjia2 = new JButton("添加");
		shang2.add(tianjia2);
		xiugai2 = new JButton("修改");
		shang2.add(xiugai2);
		shanchu2 = new JButton("删除");
		shang2.add(shanchu2);
		quanbu2 = new JButton("浏览全部信息");
		shang2.add(quanbu2);



		//货品管理
		a3= new Object[60][7];
		table3 = new  JTable(a3, columnName2);
		xia3 = new JPanel();
		xia3.setLayout(new BorderLayout());
		xia3.add(new JScrollPane(table3)); //添加带滚动条的table
		//功能面板（货品）
		shang3 = new JPanel();
		shang3.setLayout(new FlowLayout());   
		bianhao = new JLabel("编号");
		shang3.add(bianhao);
		haoma3 = new JTextField(10);
		shang3.add(haoma3);
		kehumingcheng = new JLabel("货品名称");
		shang3.add(kehumingcheng);     
		huopinmingcheng = new JTextField(10);
		shang3.add(huopinmingcheng);     
		chaxun3 = new JButton("查询");
		shang3.add(chaxun3);
		tianjia3 = new JButton("添加");
		shang3.add(tianjia3);
		xiugai3 = new JButton("修改");
		shang3.add(xiugai3);
		shanchu3 = new JButton("删除");
		shang3.add(shanchu3);
		quanbu3 = new JButton("浏览全部信息");
		shang3.add(quanbu3);


		//仓库管理
		a4= new Object[60][4];
		table4 = new  JTable(a4, columnName3);
		xia4 = new JPanel();
		xia4.setLayout(new BorderLayout());
		xia4.add(new JScrollPane(table4)); //添加带滚动条的table
		//功能表（仓库）
		shang4 = new JPanel();
		shang4.setLayout(new FlowLayout());   
		bianhao = new JLabel("编号");
		shang4.add(bianhao);
		haoma4 = new JTextField(10);
		shang4.add(haoma4);
		kehumingcheng = new JLabel("库管");
		shang4.add(kehumingcheng);     
		kuguan = new JTextField(10);
		shang4.add(kuguan);     
		chaxun4 = new JButton("查询");
		shang4.add(chaxun4);
		tianjia4 = new JButton("添加");
		shang4.add(tianjia4);
		xiugai4 = new JButton("修改");
		shang4.add(xiugai4);
		shanchu4 = new JButton("删除");
		shang4.add(shanchu4);
		quanbu4 = new JButton("浏览全部信息");
		shang4.add(quanbu4);


		//职务
		a5= new Object[30][2];
		table5 = new  JTable(a5, columnName4);
		xia5 = new JPanel();
		xia5.setLayout(new BorderLayout());
		xia5.add(new JScrollPane(table5)); //添加带滚动条的table
		//功能表（职务）
		shang5 = new JPanel();
		shang5.setLayout(new FlowLayout());   
		bianhao = new JLabel("姓名");
		shang5.add(bianhao);
		xingming = new JTextField(10);
		shang5.add(xingming);
		chaxun5 = new JButton("查询");
		shang5.add(chaxun5);
		tianjia5 = new JButton("添加");
		shang5.add(tianjia5);
		xiugai5 = new JButton("修改");
		shang5.add(xiugai5);
		shanchu5 = new JButton("删除");
		shang5.add(shanchu5);
		quanbu5 = new JButton("浏览全部信息");
		shang5.add(quanbu5);
		//注册监听器
		tree.addTreeSelectionListener(new TreeSelectionListener(){
			public void valueChanged(TreeSelectionEvent e)
			{
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				Object object = node.getUserObject();
				if(node==q)   //供货
				{				
					System.out.println("qqq");
					zuo.removeAll();
					zuo.add(xia1,BorderLayout.CENTER);
					zuo.add(shang1,BorderLayout.NORTH);
					zuo.updateUI();
				}
				if(node==w)   //销售
				{
					System.out.println("www");
					zuo.removeAll();
					zuo.add(xia2,BorderLayout.CENTER);
					zuo.add(shang2,BorderLayout.NORTH);
					zuo.updateUI();
				}
				if(node==x)  //货品
				{
					System.out.println("xxx");
					zuo.removeAll();
					zuo.add(xia3,BorderLayout.CENTER);
					zuo.add(shang3,BorderLayout.NORTH);
					zuo.updateUI();
				}
				if(node==r)  //仓库
				{
					System.out.println("rrr");
					zuo.removeAll();
					zuo.add(xia4,BorderLayout.CENTER);
					zuo.add(shang4,BorderLayout.NORTH);
					zuo.updateUI();
				}
				if(node==t)  //职务
				{
					System.out.println("ttt");
					zuo.removeAll();
					zuo.add(xia5,BorderLayout.CENTER);
					zuo.add(shang5,BorderLayout.NORTH);
					zuo.updateUI();
				}
			}
		});
		//注册监听器
		quanbu1.addActionListener(this);
		chaxun1.addActionListener(this);
		tianjia1.addActionListener(this);
		xiugai1.addActionListener(this);
		shanchu1.addActionListener(this);
		quanbu2.addActionListener(this);
		chaxun2.addActionListener(this);
		tianjia2.addActionListener(this);
		xiugai2.addActionListener(this);
		shanchu2.addActionListener(this);
		quanbu3.addActionListener(this);
		chaxun3.addActionListener(this);
		tianjia3.addActionListener(this);
		xiugai3.addActionListener(this);
		shanchu3.addActionListener(this);
		quanbu4.addActionListener(this);
		chaxun4.addActionListener(this);
		tianjia4.addActionListener(this);
		xiugai4.addActionListener(this);
		shanchu4.addActionListener(this);
		quanbu5.addActionListener(this);
		chaxun5.addActionListener(this);
		tianjia5.addActionListener(this);
		xiugai5.addActionListener(this);
		shanchu5.addActionListener(this);
		//窗口设置
		setSize(1000,600);
		setLocationRelativeTo(null);

		//居中
		setResizable(false);

		//大小不可改变		
		setVisible(true);

		//可见
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	//两个用于循环的变量
	int i = 0,j = 0;
	public void actionPerformed(ActionEvent e)
	{
		//浏览功能！！！！！
		if(e.getSource() == quanbu1 )
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<11;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM gongyingshang");
				while(rs.next())
				{
					//在数据库中获取数据
					int aa = rs.getInt("编号");
					String bb = rs.getString("客户名称");
					String cc = rs.getString("地址");
					String dd = rs.getString("联系人");
					String ee = rs.getString("联系电话");
					String ff = rs.getString("传真");
					String gg = rs.getString("邮编");
					String hh = rs.getString("银行账号");
					String ii = rs.getString("公司网址");
					String jj = rs.getString("邮箱地址");
					String kk = rs.getString("备注");

					//将字段写入表格中
					a1[i][0] = aa;  
					a1[i][1] = bb;
					a1[i][2] = cc;
					a1[i][3] = dd;
					a1[i][4] = ee;
					a1[i][5] = ff;
					a1[i][6] = gg;
					a1[i][7] = hh;
					a1[i][8] = ii;
					a1[i][9] = jj;
					a1[i][10] = kk;

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

		//销售商浏览
		if(e.getSource() == quanbu2 )
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<11;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM xiaoshoushang");
				while(rs.next())
				{
					//在数据库中获取数据
					int aa = rs.getInt("编号");
					String bb = rs.getString("客户名称");
					String cc = rs.getString("地址");
					String dd = rs.getString("联系人");
					String ee = rs.getString("联系电话");
					String ff = rs.getString("传真");
					String gg = rs.getString("邮编");
					String hh = rs.getString("银行账号");
					String ii = rs.getString("公司网址");
					String jj = rs.getString("邮箱地址");
					String kk = rs.getString("备注");

					//将字段写入表格中
					a2[i][0] = aa;  
					a2[i][1] = bb;
					a2[i][2] = cc;
					a2[i][3] = dd;
					a2[i][4] = ee;
					a2[i][5] = ff;
					a2[i][6] = gg;
					a2[i][7] = hh;
					a2[i][8] = ii;
					a2[i][9] = jj;
					a2[i][10] = kk;

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

		//货品浏览
		if(e.getSource() == quanbu3 )
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<7;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM huopin");
				while(rs.next())
				{
					int aa = rs.getInt("编号");					
					String bb = rs.getString("货品名称");					
					String cc = rs.getString("货品描述");
					String dd = rs.getString("单位");	
					String ee = rs.getFloat("进货价")+"";
					String ff = rs.getFloat("零售价")+"";
					String gg = rs.getFloat("爱心价")+"";


					//将字段写入表格中
					a3[i][0] = aa;  
					a3[i][1] = bb;
					a3[i][2] = cc;
					a3[i][3] = dd;
					a3[i][4] = ee;
					a3[i][5] = ff;
					a3[i][6] = gg;

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

		//仓库浏览
		if(e.getSource() == quanbu4 )
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<4;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM cangku");
				while(rs.next())
				{
					//在数据库中获取数据
					int aa = rs.getInt("编号");
					String bb = rs.getString("库管");
					String cc = rs.getString("描述");
					String dd = rs.getDouble("库存利用率")+"";
					//将字段写入表格中
					a4[i][0] = aa;  
					a4[i][1] = bb;
					a4[i][2] = cc;
					a4[i][3] = dd;
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
		//职务浏览
		if(e.getSource() == quanbu5 )
		{
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<2;j++)
				{
					a5[i][j] = "";
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
				ResultSet rs = sql.executeQuery("SELECT * FROM zhiwu");
				while(rs.next())
				{
					//在数据库中获取数据
					System.out.println("111");
					String aa = rs.getString("姓名");
					String bb = rs.getString("职务");
					//将字段写入表格中
					a5[i][0] = aa;  
					a5[i][1] = bb;
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

		//查询功能！！！！
		//供应商查询
		if(e.getSource() == chaxun1 )
		{
			String test1 = haoma1.getText();
			String test2 = kehu1.getText();
			String test3 = ren1.getText();
			String test4 = zhuzhi1.getText();
			System.out.println(test1+test2+test3+test4);
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<11;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM gongyingshang");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getInt("编号")+"";
					String bb = rs.getString("客户名称");
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
					if(aa.equals(test1)||bb.equals(test2)||cc.equals(test4)||dd.equals(test3))
					{
						System.out.println("5");       //验证是否比对成功
						//将字段写入表格中
						a1[i][0] = aa;  
						a1[i][1] = bb;
						a1[i][2] = cc;
						a1[i][3] = dd;
						a1[i][4] = ee;
						a1[i][5] = ff;
						a1[i][6] = gg;
						a1[i][7] = hh;
						a1[i][8] = ii;
						a1[i][9] = jj;
						a1[i][10] = kk;

						//下一行
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
		//查询(销售商)
		if(e.getSource() == chaxun2 )
		{
			String test1 = haoma2.getText();
			String test2 = kehu2.getText();
			String test3 = ren2.getText();
			String test4 = zhuzhi2.getText();
			System.out.println(test1+test2+test3+test4);
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<11;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM xiaoshoushang");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getInt("编号")+"";
					String bb = rs.getString("客户名称");
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
					if(aa.equals(test1)||bb.equals(test2)||cc.equals(test4)||dd.equals(test3))
					{
						System.out.println("55");       //验证是否比对成功
						//将字段写入表格中
						a2[i][0] = aa;  
						a2[i][1] = bb;
						a2[i][2] = cc;
						a2[i][3] = dd;
						a2[i][4] = ee;
						a2[i][5] = ff;
						a2[i][6] = gg;
						a2[i][7] = hh;
						a2[i][8] = ii;
						a2[i][9] = jj;
						a2[i][10] = kk;

						//下一行
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
		//货品查询
		if(e.getSource() == chaxun3 )
		{
			String test1 = haoma3.getText();
			String test2 = huopinmingcheng.getText();
			System.out.println(test1+test2);
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<7;j++)
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
					if(test1.equals(aa)||bb.equals(test2))
					{
						System.out.println("666");
						System.out.println(i);//验证是否比对成功
						//将字段写入表格中
						a3[i][0] = aa;  
						a3[i][1] = bb;
						a3[i][2] = cc;
						a3[i][3] = dd;
						a3[i][4] = ee;
						a3[i][5] = ff;
						a3[i][6] = gg;			
						//下一行
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
		//仓库查询
		if(e.getSource() == chaxun4 )
		{
			String test1 = haoma4.getText();
			String test2 = kuguan.getText();
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<4;j++)
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
				ResultSet rs = sql.executeQuery("SELECT * FROM cangku");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getInt("编号")+"";
					String bb = rs.getString("库管");
					String cc = rs.getString("描述");
					String dd = rs.getDouble("库存利用率")+"";
					if(aa.equals(test1)||bb.equals(test2))
					{
						//将字段写入表格中
						a4[i][0] = aa;  
						a4[i][1] = bb;
						a4[i][2] = cc;
						a4[i][3] = dd;
						//下一行
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
		//职务查询
		if(e.getSource() == chaxun5 )
		{
			String test1 = xingming.getText();
			while(i>=0) {         //清空上次查询结果
				for( j = 0;j<2;j++)
				{
					a5[i][j] = "";
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
				ResultSet rs = sql.executeQuery("SELECT * FROM zhiwu");
				while(rs.next())
				{
					//在数据库中获取数据
					String aa = rs.getString("姓名");
					String bb = rs.getString("职务");
					//将字段写入表格中
					if(test1.equals(aa))
					{
						//将字段写入表格中
						a5[i][0] = aa;  
						a5[i][1] = bb;
						//下一行
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
		//添加   重写窗口
		if(e.getSource() == tianjia1 )
		{
			GetAdd dd = new GetAdd();
		}
		if(e.getSource() == tianjia2 )
		{
			GetAdd2 a = new GetAdd2();
		}
		if(e.getSource() == tianjia3 )
		{
			GetAdd3 l = new GetAdd3();
		}
		if(e.getSource() == tianjia4 )
		{
			GetAdd4 ll =new GetAdd4();
		}
		if(e.getSource() == tianjia5 )
		{
			GetAdd5 ll =new GetAdd5();
		}
		//修改  重写窗口
		if(e.getSource() == xiugai1 )
		{
			Project j = new Project();
		}
		if(e.getSource() == xiugai2 )
		{
			Project2 j = new Project2();
		}
		if(e.getSource() == xiugai3 )
		{
			Project3 j = new Project3();
		}
		if(e.getSource() == xiugai4 )
		{
			Project4 p = new Project4();
		}
		if(e.getSource() == xiugai5 )
		{
			Project5 p = new Project5();
		}
		//删除
		if(e.getSource() == shanchu1 )
		{
			String test1 = haoma1.getText();
			String test2 = kehu1.getText();
			String test3 = ren1.getText();
			String test4 = zhuzhi1.getText();
			System.out.println(test1+test2+test3+test4);
			Connection  con; Statement  sql; int  rs1,rs2,rs3,rs4;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM gongyingshang WHERE 编号='"+test1+"'";
				String strSQLDelete2 = "DELETE FROM gongyingshang WHERE 客户名称='"+test2+"'";
				String strSQLDelete3 = "DELETE FROM gongyingshang WHERE 联系人='"+test3+"'";
				String strSQLDelete4 = "DELETE FROM gongyingshang WHERE 地址='"+test4+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				rs2 = sql.executeUpdate(strSQLDelete2);   //删除姓名为“王二”的记录
				System.out.println("删除信息记录条数："+rs2);
				rs3 = sql.executeUpdate(strSQLDelete3);   //删除姓名为“王二”的记录
				System.out.println("删除信息记录条数："+rs3);
				rs4 = sql.executeUpdate(strSQLDelete4);   //删除姓名为“王二”的记录
				System.out.println("删除信息记录条数："+rs4);
				if((rs1+rs2+rs3+rs4)>0)
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
		if(e.getSource() == shanchu2 )
		{
			String test1 = haoma2.getText();
			String test2 = kehu2.getText();
			String test3 = ren2.getText();
			String test4 = zhuzhi2.getText();
			System.out.println(test1+test2+test3+test4);
			Connection  con; Statement  sql; int  rs1,rs2,rs3,rs4;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM xiaoshoushang WHERE 编号='"+test1+"'";
				String strSQLDelete2 = "DELETE FROM xiaoshoushang WHERE 客户名称='"+test2+"'";
				String strSQLDelete3 = "DELETE FROM xiaoshoushang WHERE 联系人='"+test3+"'";
				String strSQLDelete4 = "DELETE FROM xiaoshoushang WHERE 地址='"+test4+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				rs2 = sql.executeUpdate(strSQLDelete2);   //删除姓名为“王二”的记录
				System.out.println("删除信息记录条数："+rs2);
				rs3 = sql.executeUpdate(strSQLDelete3);   //删除姓名为“王二”的记录
				System.out.println("删除信息记录条数："+rs3);
				rs4 = sql.executeUpdate(strSQLDelete4);   //删除姓名为“王二”的记录
				System.out.println("删除信息记录条数："+rs4);
				if((rs1+rs2+rs3+rs4)>0)
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
		if(e.getSource() == shanchu3 )
		{
			String test1 = haoma3.getText();
			String test2 = huopinmingcheng.getText();
			System.out.println(test1+test2);
			Connection  con; Statement  sql; int  rs1,rs2;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM huopin WHERE 编号='"+test1+"'";
				String strSQLDelete2 = "DELETE FROM huopin WHERE 货品名称='"+test2+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				rs2 = sql.executeUpdate(strSQLDelete2);   //删除姓名为“王二”的记录
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
		if(e.getSource() == shanchu4 )
		{
			String test1 = haoma4.getText();
			String test2 = kuguan.getText();
			Connection  con; Statement  sql; int  rs1,rs2;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM cangku WHERE 编号='"+test1+"'";
				String strSQLDelete2 = "DELETE FROM cangku WHERE 库管='"+test2+"'";
				rs1 = sql.executeUpdate(strSQLDelete1);   
				System.out.println("删除信息记录条数："+rs1);
				rs2 = sql.executeUpdate(strSQLDelete2);   //删除姓名为“王二”的记录
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
		if(e.getSource() == shanchu5 )
		{
			String test1 = xingming.getText();
			Connection  con; Statement  sql; int  rs1,rs2;
			try {
				Class.forName("com.mysql.jdbc.Driver");  //建立桥接器
			}catch(ClassNotFoundException ea){}
			try {//连接数据库
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/factory","root","981129"); 
				con.setAutoCommit(false);        //取消事务的自动提交
				sql = con.createStatement();     //创建SQL语句
				String strSQLDelete1 = "DELETE FROM zhiwu WHERE 姓名='"+test1+"'";
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


public class Information{
	public static void main(String args[])
	{
		InformationFrame a = new InformationFrame();
	}
}