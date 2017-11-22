package xuna;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
/*
 * 人员调动
 */
public class None3_P1 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u4EBA\u5458\u8003\u6838");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"编号","姓名","性别","出生年月","民族","地址","部门"};//列名
	private JTextField textField;
	database a = new database();
	private final JButton button_1 = new JButton("\u5237\u65B0");
	private JTextField textField_1;
	JComboBox comboBox = new JComboBox();
	Connection con1 = a.getConn();//此处为通过自己写的方法getConn()获得连接  
	public None3_P1()
	{
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(217, 11, 101, 27);
		panel.add(lblNewLabel);
		jscrollpane.setBounds(0, 54, 494, 206);
		panel.add(jscrollpane);
		Vector rows = new Vector();//行
		Vector colum = new Vector();//列
		ResultSetMetaData rsmd = null;
	    String sql = "select * from Person";  
        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
        try{
        	Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData可以获取列名
            //获取列名
            
             colum.addElement("工号"); 
             colum.addElement("姓名"); 
             colum.addElement("性别"); 
             colum.addElement("部门"); 
             colum.addElement("酬薪"); 
             colum.addElement("考核信息"); 
             
            //获取每行的元素
            while(rs.next()) 
            {  
                Vector currow = new Vector();  
                currow.addElement(rs.getString(1));  
                currow.addElement(rs.getString(2));  
                currow.addElement(rs.getString(3));
                currow.addElement(rs.getString(7));
                currow.addElement(rs.getString(8));
                currow.addElement(rs.getString(9));
                rows.addElement(currow);  
            } 
            
            System.out.println("database:");
            rs.close();
            con.close();
        }
        catch(SQLException e1)
        {      
            e1.printStackTrace();   
        } 
	   JTable table = new JTable(rows, colum);//将结果保存在表格中
	   jscrollpane.setViewportView(table);//这句很重要
	   table.setRowHeight(25); //设置表格列的高度
	   
	   JLabel label = new JLabel("\u59D3\u540D");
	   label.setBounds(24, 273, 55, 18);
	   panel.add(label);
	   
	   textField = new JTextField();
	   textField.setBounds(78, 270, 86, 24);
	   panel.add(textField);
	   textField.setColumns(10);
	   
	   JButton button = new JButton("\u786E\u5B9A");
	   button.addActionListener(this);
	   button.setBounds(239, 315, 113, 27);
	   panel.add(button);
	   button_1.addActionListener(this);
	   button_1.setBounds(375, 13, 113, 27);
	   
	   panel.add(button_1);
	   
	   JLabel label_1 = new JLabel("\u4E0A\u6B21\u8003\u6838");
	   label_1.setBounds(178, 273, 72, 18);
	   panel.add(label_1);
	   
	   textField_1 = new JTextField();
	   textField_1.setBounds(252, 270, 86, 24);
	   panel.add(textField_1);
	   textField_1.setColumns(10);
	   
	   JLabel label_2 = new JLabel("\u672C\u6B21\u8003\u6838");
	   label_2.setBounds(359, 270, 72, 18);
	   panel.add(label_2);
	   
	   JButton button_2 = new JButton("\u6E05\u7A7A\u4FE1\u606F");
	   button_2.setBounds(395, 315, 113, 27);
	   panel.add(button_2);
	   comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4F18\u79C0", "\u826F\u597D", "\u5408\u683C", "\u4E0D\u5408\u683C"}));
	   
	  
	   comboBox.setBounds(421, 270, 96, 21);
	   panel.add(comboBox);
	   
	   JLabel lblNewLabel_1 = new JLabel("New label");
	   lblNewLabel_1.setIcon(new ImageIcon(None3_P1.class.getResource("/xuna/57a99cdc3fa06.jpg")));
	   lblNewLabel_1.setBounds(0, 0, 531, 355);
	   panel.add(lblNewLabel_1);
	   table.setVisible(true);
	   DefaultTableCellRenderer r = new DefaultTableCellRenderer();    
	   r.setHorizontalAlignment(JLabel.CENTER);   
	   table.setDefaultRenderer(Object.class,r);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Date d = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(d);  
        String name = textField.getText().trim();//人员姓名
		String OldInfo = textField_1.getText().trim();//原始信息
		String NewInfo=(String)comboBox.getSelectedItem();//更新信息
		int ChgTime = 0;//变更次数
        String RegDate = dateNowStr;//变更日期
        String PersonID = null;
        PreparedStatement  pst=null;
        int i;
		if(cmd.equals("确定"))
		{ 
			try{
				Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
	            Statement stmt = con.createStatement();
	            ResultSet rs ; //ResultSet类，用来存放获取的结果集！！
	            //获取操作次数
	            String sql2 = "select time from Test where Name='" + name +"'";
	            rs = stmt.executeQuery(sql2); //ResultSet类，用来存放获取的结果集！！
	            while(rs.next())
	            {
	            	ChgTime = rs.getInt(1);
	            }
	            ChgTime++;
	            //更新person表
	            
	            String sql4 = "update Person set Assess=? where Name =?";
	            pst = con.prepareStatement(sql4); 
	            pst.setString(1, NewInfo); 
	            pst.setString(2, name); 
	            i = pst.executeUpdate();
	            
	            //添加到test表中
	            String sql3 = "insert into Test (Name,last,now,time,date) values (?,?,?,?,?)";
	            pst = con.prepareStatement(sql3); 
	            pst.setString(1,name ); 
	            pst.setString(2, OldInfo); 
	            pst.setString(3, NewInfo); 
	            pst.setInt(4, ChgTime); 
	            pst.setString(5, RegDate); 
	            i = pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "添加成功");
	            
	            System.out.println("2-2= "+ChgTime);
	            rs.close();
	            con.close();
	        }
	        catch(SQLException e1)
	        {      
	            e1.printStackTrace();   
	        } 	
		}  
		if(cmd.equals("刷新"))
		{
			Vector rows = new Vector();//行
			Vector colum = new Vector();//列
			ResultSetMetaData rsmd = null;
		    String sql = "select * from Person";  
	        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
	        try{
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
	            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData可以获取列名
	            //获取列名
	            
	             colum.addElement("工号"); 
	             colum.addElement("姓名"); 
	             colum.addElement("性别"); 
	             colum.addElement("部门"); 
	             colum.addElement("酬薪"); 
	             colum.addElement("考核信息"); 
	             
	            //获取每行的元素
	            while(rs.next()) 
	            {  
	                Vector currow = new Vector();  
	                currow.addElement(rs.getString(1));  
	                currow.addElement(rs.getString(2));  
	                currow.addElement(rs.getString(3));
	                currow.addElement(rs.getString(7));
	                currow.addElement(rs.getString(8));
	                currow.addElement(rs.getString(9));
	                rows.addElement(currow);  
	            } 
	            
	            System.out.println("database:");
	            rs.close();
	            con.close();
	        }
	        catch(SQLException e1)
	        {      
	            e1.printStackTrace();   
	        } 
		   JTable table = new JTable(rows, colum);//将结果保存在表格中
		   jscrollpane.setViewportView(table);//这句很重要
		   table.setRowHeight(25); //设置表格列的高度
		   
		}
	}
}
