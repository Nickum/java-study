package xuna;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
 * ɾ����Ա��Ϣ
 */
public class None1_P3 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u5220\u9664\u4EBA\u5458\u4FE1\u606F");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"���","����","�Ա�","��������","����","��ַ","����"};//����
	private JTextField textField;
	database a = new database();
	private final JButton button_1 = new JButton("\u5237\u65B0");
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	public None1_P3()
	{
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(169, 14, 138, 27);
		panel.add(lblNewLabel);
		jscrollpane.setBounds(0, 54, 476, 240);
		panel.add(jscrollpane);
		Vector rows = new Vector();//��
		Vector colum = new Vector();//��
		ResultSetMetaData rsmd = null;
	    String sql = "select * from Person";  
        Connection con = a.getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
        try{
        	Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet�࣬������Ż�ȡ�Ľ��������
            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData���Ի�ȡ����
            //��ȡ����
            colum.addElement("����"); 
            colum.addElement("����"); 
            colum.addElement("�Ա�"); 
            colum.addElement("��������"); 
            colum.addElement("����"); 
            colum.addElement("��ַ"); 
            colum.addElement("����"); 
            colum.addElement("����"); 
            //��ȡÿ�е�Ԫ��
            while(rs.next()) 
            {  
                Vector currow = new Vector();  
               
                currow.addElement(rs.getString(1));  
                currow.addElement(rs.getString(2)); 
                currow.addElement(rs.getString(3)); 
                currow.addElement(rs.getString(4)); 
                currow.addElement(rs.getString(5)); 
                currow.addElement(rs.getString(6)); 
                currow.addElement(rs.getString(7)); 
                currow.addElement(rs.getString(10)); 
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
	   
	   JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u4EBA\u5458\u7F16\u53F7\uFF1A");
	   label.setBounds(10, 312, 233, 18);
	   panel.add(label);
	   
	   textField = new JTextField();
	   textField.setBounds(221, 309, 86, 24);
	   
	   panel.add(textField);
	   textField.setColumns(10);
	   
	   JButton button = new JButton("\u5220\u9664");
	   button.addActionListener(this);
	   button.setBounds(368, 307, 76, 27);
	   panel.add(button);
	   button_1.addActionListener(this);
	   button_1.setBounds(360, 16, 113, 27);
	   
	   panel.add(button_1);
	   lblNewLabel_1.setIcon(new ImageIcon(None1_P3.class.getResource("/xuna/57a99cdc3fa06.jpg")));
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
		if(cmd.equals("ɾ��"))
		{
			String PersonID =  textField.getText().trim();
	        String sql = "delete from Person where PersonID=" + PersonID;
	        int i=0;
	        Connection con = getConn();
	        try {
	            Statement stmt = con.createStatement();
	            i = stmt.executeUpdate(sql);
	            JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
	        }catch (Exception e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
	        }
		}  
		if(cmd.equals("ˢ��"))
		{
			Vector rows = new Vector();//��
			Vector colum = new Vector();//��
			ResultSetMetaData rsmd = null;
		    String sql = "select * from Person";  
	        Connection con = a.getConn();//�˴�Ϊͨ���Լ�д�ķ���getConn()�������  
	        try{
	        	Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql); //ResultSet�࣬������Ż�ȡ�Ľ��������
	            rsmd =(ResultSetMetaData) rs.getMetaData();//ResultSetMetaData���Ի�ȡ����
	          //��ȡ����
	            colum.addElement("����"); 
	            colum.addElement("����"); 
	            colum.addElement("�Ա�"); 
	            colum.addElement("��������"); 
	            colum.addElement("����"); 
	            colum.addElement("��ַ"); 
	            colum.addElement("����"); 
	            colum.addElement("����"); 
	            //��ȡÿ�е�Ԫ��
	            while(rs.next()) 
	            {  
	                Vector currow = new Vector();  
	               
	                currow.addElement(rs.getString(1));  
	                currow.addElement(rs.getString(2)); 
	                currow.addElement(rs.getString(3)); 
	                currow.addElement(rs.getString(4)); 
	                currow.addElement(rs.getString(5)); 
	                currow.addElement(rs.getString(6)); 
	                currow.addElement(rs.getString(7)); 
	                currow.addElement(rs.getString(10)); 
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
			
		}
	}
}
