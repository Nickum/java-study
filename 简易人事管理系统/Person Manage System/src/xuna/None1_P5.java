package xuna;
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
import javax.swing.ImageIcon;
/*
/*
 * ���Ź���
 */
public class None1_P5 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u90E8\u95E8\u7BA1\u7406");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"���","����","�Ա�","��������","����","��ַ","����"};//����
	private final JLabel label = new JLabel("\u7F16 \u53F7\uFF1A");
	private final JTextField textField = new JTextField();
	private final JLabel label_1 = new JLabel("\u4E00\u7EA7\u90E8\u95E8\uFF1A");
	private final JTextField textField_1 = new JTextField();
	private final JLabel label_2 = new JLabel("\u4E8C\u7EA7\u90E8\u95E8\uFF1A");
	private final JTextField textField_2 = new JTextField();
	database a = new database();
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	public None1_P5()
	{
		textField_2.setBounds(400, 285, 108, 21);
		textField_2.setColumns(10);
		textField_1.setBounds(218, 288, 87, 21);
		textField_1.setColumns(10);
		textField.setBounds(71, 288, 66, 21);
		textField.setColumns(10);
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(218, 14, 226, 27);
		panel.add(lblNewLabel);
		jscrollpane.setBounds(14, 51, 486, 227);
		panel.add(jscrollpane);
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u90E8\u95E8\u4FE1\u606F");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(335, 14, 173, 27);
		panel.add(btnNewButton);  
		label.setBounds(14, 288, 54, 15);
		
		panel.add(label);
		
		panel.add(textField);
		label_1.setBounds(144, 288, 75, 15);
		
		panel.add(label_1);
		
		panel.add(textField_1);
		label_2.setBounds(315, 288, 75, 15);
		
		panel.add(label_2);
		
		panel.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("\u589E\u52A0");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(36, 319, 75, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(163, 319, 87, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5220\u9664");
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setBounds(294, 319, 75, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u6E05\u7A7A");
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setBounds(421, 319, 75, 23);
		panel.add(btnNewButton_5);
		lblNewLabel_1.setIcon(new ImageIcon(None1_P5.class.getResource("/xuna/57a99cdc3fa06.jpg")));
		lblNewLabel_1.setBounds(-4, 0, 535, 355);
		
		panel.add(lblNewLabel_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("��ѯ������Ϣ"))
		{
			Vector rows = new Vector();//��
			Vector colum = new Vector();//��
			ResultSetMetaData rsmd = null;
		    String sql = "select * from Dept";  
	        Connection con = a.getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
	        try{
	            
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql); //ResultSet�࣬������Ż�ȡ�Ľ��������
	            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData���Ի�ȡ����
	            //��ȡ����
	            for(int i = 1; i <= rsmd.getColumnCount(); ++i)  
	                colum.addElement(rsmd.getColumnName(i)); 
	            //��ȡÿ�е�Ԫ��
	            while(rs.next()) 
	            {  
	                Vector currow = new Vector();  
	                for (int i = 1; i <= rsmd.getColumnCount(); ++i) {  
	                    currow.addElement(rs.getString(i));  
	                }  
	                rows.addElement(currow);  
	            } 
	            
	            System.out.println("database:");
	            for(int i1=0; i1<res[0].length; i1++)
	    		{
	    			System.out.println(res[0][i1]);
	    		}
	            System.out.print(res.length);
	            rs.close();
	            con.close();
	        }
	        catch(SQLException e1)
	        {      
	            e1.printStackTrace();   
	        } 
		   JTable table = new JTable(rows, colum);//����������ڱ����
		   jscrollpane.setViewportView(table);//������Ҫ
		   table.setRowHeight(25); //���ñ���еĸ߶�
		   table.setVisible(true);
		   DefaultTableCellRenderer r = new DefaultTableCellRenderer();    
		   r.setHorizontalAlignment(JLabel.CENTER);   
		   table.setDefaultRenderer(Object.class,r);
		}
		if(cmd.equals("����"))
		{
			
			//JOptionPane.showMessageDialog(null, "����һ���򵥵���Ϣ��");
			//����getText()�ǻ���ı���trim()������ȥ���ı�ǰ��Ŀ��ַ��ġ�
			String DeptID = textField.getText().trim();
			String B_Dept = textField_1.getText().trim();
			String S_Dept = textField_2.getText().trim();
			int i = 0;
	        Connection con = a.getConn();
	        String sql = "insert into Dept (DeptID,B_Dept,S_Dept) values (?,?,?)";
	        try 
	        {
	            //����ִ��SQL���
	            PreparedStatement pst = con.prepareStatement(sql); 
	            pst.setString(1, DeptID); 
	            pst.setString(2, B_Dept); 
	            pst.setString(3, S_Dept);  
	            i = pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "��ӳɹ�");
	        }
	        catch (Exception e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "ʧ�ܣ�������ݲ����������ظ���ӵ�����ԭ��");
	        }
	        System.out.println(i);
		}
		if(cmd.equals("�޸�"))
		{
			//String sql = "update Person set PersonID=?,Name=?,Sex=?,Birth=?,Nat=?,Address=?,Other=? where PersonID =?";
			//JOptionPane.showMessageDialog(null, "����һ���򵥵���Ϣ��");
			//����getText()�ǻ���ı���trim()������ȥ���ı�ǰ��Ŀ��ַ��ġ�
			String DeptID = textField.getText().trim();
			String B_Dept = textField_1.getText().trim();
			String S_Dept = textField_2.getText().trim();
			String res="";
			int i = 0;
	        Connection con = a.getConn();
	        String sql_old = "select * from Dept where DeptID="+DeptID;
	        try 
	        {
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql_old); //ResultSet�࣬������Ż�ȡ�Ľ��������
	            while(rs.next())
	            {
	            	res+=rs.getString(1);
	            	res+="-";
	            	res+=rs.getString(2);
	            	res+="-";
	            	res+=rs.getString(3);
	            	//break;
	            }
	            System.out.println("res="+res);
	            String sql = "update Dept set DeptID=?,B_Dept=?,S_Dept=? where DeptID='"+DeptID+"'";
	            String sql2 ="update Person set DeptID=? where DeptID='" + res +"'";
		        
		        //System.out.println("sql2="+sql2);
	            //����ִ��SQL���
		      
	            PreparedStatement pst = con.prepareStatement(sql); 
	            pst.setString(1, DeptID); 
	            pst.setString(2, B_Dept); 
	            pst.setString(3, S_Dept); 
	            i = pst.executeUpdate();
	            System.out.println("sql="+i);
	            
	            PreparedStatement pst1 = con.prepareStatement(sql2); 
	            pst1.setString(1,DeptID+"-"+B_Dept+"-"+S_Dept); 
	            System.out.println("sql2="+sql2);
	            i = pst1.executeUpdate();
	            System.out.println("sql2="+i);
	            JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
	           
	        }
	        catch (Exception e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "ʧ�ܣ�������ݲ����������ظ���ӵ�����ԭ��");
	        }
	        System.out.println(i);
		}
		if(cmd.equals("ɾ��"))
		{
			String DeptID = textField.getText().trim();
			String B_Dept = textField_1.getText().trim();
			String S_Dept = textField_2.getText().trim();
			String res="";
		
	        Connection con = a.getConn();
	        String sql_old = "select * from Dept where DeptID="+DeptID;
	        try 
	        {
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql_old); //ResultSet�࣬������Ż�ȡ�Ľ��������
	            while(rs.next())
	            {
	            	res+=rs.getString(1);
	            	res+="-";
	            	res+=rs.getString(2);
	            	res+="-";
	            	res+=rs.getString(3);
	            }
	            System.out.println("res="+res);
	            String sql2 ="select Name from Person where DeptID='" + res +"'";
	            
	            PreparedStatement pst1 = con.prepareStatement(sql2); 
	            rs = stmt.executeQuery(sql2); //ResultSet�࣬������Ż�ȡ�Ľ��������
	        	String name =null;
	            while(rs.next())
	            {
	            	name = rs.getString(1);
	            }
	            
	            if(name == null)
	            {
	            	String sql3 ="delete from Dept where DeptID='"+DeptID+"'";
	            	pst1 = con.prepareStatement(sql3);
	            	int i = pst1.executeUpdate();
	            	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
	            	
	            }
	            else
	            {	
	            	JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܳɹ�����Ϊ�˲�����Ա����Ϣ");
	            }
	           
	        }
	        catch (Exception e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "ʧ�ܣ�������ݲ����������ظ���ӵ�����ԭ��");
	        }
	       
		}
		if(cmd.equals("���"))
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
		}
	}
}
