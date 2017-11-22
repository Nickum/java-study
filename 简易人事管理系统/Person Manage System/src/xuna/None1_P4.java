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
 * 查询人员信息
 */
public class None1_P4 extends database implements ActionListener {
	public JPanel panel = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u4EBA\u5458\u4FE1\u606F\u67E5\u8BE2");
	private JTable table;
	JScrollPane jscrollpane = new JScrollPane();
	Object[] columnNames = {"编号","姓名","性别","出生年月","民族","地址","部门"};//列名
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	public None1_P4()
	{
		panel.setBounds(0, 0, 531, 355);
		panel.setLayout(null);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
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
		
		Vector rows = new Vector();//行
		Vector colum = new Vector();//列
		ResultSetMetaData rsmd = null;
		database a = new database();
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
            colum.addElement("出生年月"); 
            colum.addElement("民族"); 
            colum.addElement("地址"); 
            colum.addElement("部门"); 
            colum.addElement("其他"); 
            //获取每行的元素
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
	   JTable table = new JTable(rows, colum);//将结果保存在表格中
	   jscrollpane.setViewportView(table);//这句很重要
	   table.setRowHeight(25); //设置表格列的高度
	   table.setVisible(true);
	   DefaultTableCellRenderer r = new DefaultTableCellRenderer();    
	   r.setHorizontalAlignment(JLabel.CENTER);   
	   table.setDefaultRenderer(Object.class,r);
		   
		
	}
}
