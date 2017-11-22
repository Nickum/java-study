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
import javax.swing.ImageIcon;
/*
 * 人员调动
 */
public class None2_P2 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u8C03\u52A8\u5386\u53F2\u67E5\u8BE2");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"编号","姓名","性别","出生年月","民族","地址","部门"};//列名
	database a = new database();
	Connection con1 = a.getConn();//此处为通过自己写的方法getConn()获得连接  
	private final JButton button = new JButton("\u5237\u65B0");
	private final JLabel label = new JLabel("New label");
	public None2_P2()
	{
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(184, 11, 138, 27);
		panel.add(lblNewLabel);
		jscrollpane.setBounds(0, 58, 494, 265);
		panel.add(jscrollpane);
		Vector rows = new Vector();//行
		Vector colum = new Vector();//列
		ResultSetMetaData rsmd = null;
	    String sql = "select * from Histrjn";  
        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
        try{
        	
        	Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData可以获取列名
            //获取列名
            
             colum.addElement("工号"); 
             colum.addElement("姓名"); 
             colum.addElement("原部门"); 
             colum.addElement("新部门"); 
             colum.addElement("变更次数"); 
             colum.addElement("变更日期"); 
             
             String name =null;
            //获取每行的元素
            while(rs.next()) 
            {  
            	String sql1 = "select Name from Person where PersonID='" + rs.getString(7) +"'";  
    			//获取PersonID
                Statement stmt1 = con1.createStatement();
                ResultSet rs1 = stmt1.executeQuery(sql1); //ResultSet类，用来存放获取的结果集！！
                while(rs1.next())
                {
                	name = rs1.getString(1);
                }
                System.out.println("name="+name);
                Vector currow = new Vector();  
                currow.addElement(rs.getString(1));
                currow.addElement(name);
                currow.addElement(rs.getString(3));  
                currow.addElement(rs.getString(4));
                currow.addElement(rs.getString(5));
                currow.addElement(rs.getString(6));
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
	   table.setRowHeight(25);
	   button.addActionListener(this);
	   button.setBounds(368, 13, 113, 27);
	   
	   panel.add(button);
	   label.setIcon(new ImageIcon(None2_P2.class.getResource("/xuna/57a99cdc3fa06.jpg")));
	   label.setBounds(0, -98, 531, 453);
	   
	   panel.add(label);
	   table.setVisible(true);
	   DefaultTableCellRenderer r = new DefaultTableCellRenderer();    
	   r.setHorizontalAlignment(JLabel.CENTER);   
	   table.setDefaultRenderer(Object.class,r);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("刷新"))
		{
			Vector rows = new Vector();//行
			Vector colum = new Vector();//列
			ResultSetMetaData rsmd = null;
		    String sql = "select * from Histrjn";  
	        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
	        try{
	        	
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
	            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData可以获取列名
	            //获取列名
	            
	             colum.addElement("工号"); 
	             colum.addElement("姓名"); 
	             colum.addElement("原部门"); 
	             colum.addElement("新部门"); 
	             colum.addElement("变更次数"); 
	             colum.addElement("变更日期"); 
	             
	             String name =null;
	            //获取每行的元素
	            while(rs.next()) 
	            {  
	            	String sql1 = "select Name from Person where PersonID='" + rs.getString(7) +"'";  
	    			//获取PersonID
	                Statement stmt1 = con1.createStatement();
	                ResultSet rs1 = stmt1.executeQuery(sql1); //ResultSet类，用来存放获取的结果集！！
	                while(rs1.next())
	                {
	                	name = rs1.getString(1);
	                }
	                System.out.println("name="+name);
	                Vector currow = new Vector();  
	                currow.addElement(rs.getString(1));
	                currow.addElement(name);
	                currow.addElement(rs.getString(3));  
	                currow.addElement(rs.getString(4));
	                currow.addElement(rs.getString(5));
	                currow.addElement(rs.getString(6));
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
		   table.setRowHeight(25);
		}
	}

}
