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
 * ��ѯ��Ա��Ϣ
 */
public class None1_P4 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u4EBA\u5458\u4FE1\u606F\u67E5\u8BE2");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"���","����","�Ա�","��������","����","��ַ","����"};//����
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	public None1_P4()
	{
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setBounds(195, 11, 226, 27);
		panel.add(lblNewLabel);
		jscrollpane.setBounds(14, 51, 459, 246);
		panel.add(jscrollpane);
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u6240\u6709\u4EBA\u5458\u4FE1\u606F");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(180, 310, 173, 27);
		panel.add(btnNewButton);  
		lblNewLabel_1.setIcon(new ImageIcon(None1_P4.class.getResource("/xuna/57a99cdc3fa06.jpg")));
		lblNewLabel_1.setBounds(0, 0, 531, 355);
		
		panel.add(lblNewLabel_1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Vector rows = new Vector();//��
		Vector colum = new Vector();//��
		ResultSetMetaData rsmd = null;
		database a = new database();
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
	   table.setVisible(true);
	   DefaultTableCellRenderer r = new DefaultTableCellRenderer();    
	   r.setHorizontalAlignment(JLabel.CENTER);   
	   table.setDefaultRenderer(Object.class,r);
		   
		
	}
}
