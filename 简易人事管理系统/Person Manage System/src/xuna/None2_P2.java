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
 * ��Ա����
 */
public class None2_P2 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u8C03\u52A8\u5386\u53F2\u67E5\u8BE2");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"���","����","�Ա�","��������","����","��ַ","����"};//����
	database a = new database();
	Connection con1 = a.getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
	private final JButton button = new JButton("\u5237\u65B0");
	private final JLabel label = new JLabel("New label");
	public None2_P2()
	{
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(184, 11, 138, 27);
		panel.add(lblNewLabel);
		jscrollpane.setBounds(0, 58, 494, 265);
		panel.add(jscrollpane);
		Vector rows = new Vector();//��
		Vector colum = new Vector();//��
		ResultSetMetaData rsmd = null;
	    String sql = "select * from Histrjn";  
        Connection con = a.getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
        try{
        	
        	Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet�࣬������Ż�ȡ�Ľ��������
            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData���Ի�ȡ����
            //��ȡ����
            
             colum.addElement("����"); 
             colum.addElement("����"); 
             colum.addElement("ԭ����"); 
             colum.addElement("�²���"); 
             colum.addElement("�������"); 
             colum.addElement("�������"); 
             
             String name =null;
            //��ȡÿ�е�Ԫ��
            while(rs.next()) 
            {  
            	String sql1 = "select Name from Person where PersonID='" + rs.getString(7) +"'";  
    			//��ȡPersonID
                Statement stmt1 = con1.createStatement();
                ResultSet rs1 = stmt1.executeQuery(sql1); //ResultSet�࣬������Ż�ȡ�Ľ��������
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
	   JTable table = new JTable(rows, colum);//����������ڱ����
	   jscrollpane.setViewportView(table);//������Ҫ
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
		if(cmd.equals("ˢ��"))
		{
			Vector rows = new Vector();//��
			Vector colum = new Vector();//��
			ResultSetMetaData rsmd = null;
		    String sql = "select * from Histrjn";  
	        Connection con = a.getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
	        try{
	        	
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql); //ResultSet�࣬������Ż�ȡ�Ľ��������
	            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData���Ի�ȡ����
	            //��ȡ����
	            
	             colum.addElement("����"); 
	             colum.addElement("����"); 
	             colum.addElement("ԭ����"); 
	             colum.addElement("�²���"); 
	             colum.addElement("�������"); 
	             colum.addElement("�������"); 
	             
	             String name =null;
	            //��ȡÿ�е�Ԫ��
	            while(rs.next()) 
	            {  
	            	String sql1 = "select Name from Person where PersonID='" + rs.getString(7) +"'";  
	    			//��ȡPersonID
	                Statement stmt1 = con1.createStatement();
	                ResultSet rs1 = stmt1.executeQuery(sql1); //ResultSet�࣬������Ż�ȡ�Ľ��������
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
		   JTable table = new JTable(rows, colum);//����������ڱ����
		   jscrollpane.setViewportView(table);//������Ҫ
		   table.setRowHeight(25);
		}
	}

}
