package xuna;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

/*
 * 修改人员信息
 */
public class None1_P2 implements ActionListener{
	public JPanel panel_3 = new JPanel();
	public final JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u4EBA\u5458\u4FE1\u606F");
	public final JPanel panel_1 = new JPanel();
	public final JLabel label_1 = new JLabel("\u4EBA\u5458\u7F16\u53F7\uFF1A");
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	JComboBox comboBox = new JComboBox();
	database a = new database();
	public None1_P2()
	{
		panel_3.setBounds(0, 0, 505, 355);
		panel_3.setLayout(null);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(187, 13, 226, 27);
		
		panel_3.add(lblNewLabel);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(14, 53, 444, 289);
		
		panel_3.add(panel_1);
		panel_1.setLayout(null);
		label_1.setBounds(14, 64, 86, 18);
		
		panel_1.add(label_1);
		textField = new JTextField();
		textField.setBounds(93, 61, 120, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027    \u522B\uFF1A");
		lblNewLabel_1.setBounds(14, 110, 86, 18);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6C11    \u65CF\uFF1A");
		lblNewLabel_2.setBounds(14, 156, 86, 18);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5176    \u4ED6\uFF1A");
		lblNewLabel_3.setBounds(14, 207, 86, 18);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u4EBA\u5458\u59D3\u540D\uFF1A");
		lblNewLabel_4.setBounds(239, 64, 86, 18);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		lblNewLabel_5.setBounds(239, 110, 95, 18);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5730    \u5740\uFF1A");
		lblNewLabel_6.setBounds(239, 156, 86, 18);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u9009\u62E9\u4EBA\u5458\u4FE1\u606F\uFF1A");
		lblNewLabel_7.setBounds(14, 13, 105, 18);
		panel_1.add(lblNewLabel_7);
		
		comboBox.setBounds(131, 10, 120, 24);
		
		String sql = "select * from Person";  
        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
            String Person=null,Name=null,res="";
            while(rs.next())
            {
            	Person = rs.getString(1)+"-";
            	Name = rs.getString(2);
            	res = Person + Name;
            	comboBox.addItem(res);
            	System.out.println(res);
            }
            System.out.println("None1_P2");
            rs.close();
            con.close();
        }
        catch(SQLException e)
        {      
            e.printStackTrace();   
        } 
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(103, 249, 65, 27);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(288, 249, 65, 27);
		panel_1.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(328, 61, 111, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(93, 107, 120, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(93, 153, 120, 24);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(93, 204, 346, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(328, 107, 111, 24);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(328, 153, 111, 24);
		panel_1.add(textField_6);
		textField_6.setColumns(10);	
		
		JButton btnNewButton_2 = new JButton("\u663E\u793A");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(327, 9, 65, 27);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(-18, -109, 599, 416);
		panel_1.add(label);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(None1_P2.class.getResource("/xuna/57a99cdc3fa06.jpg")));
		lblNewLabel_8.setBounds(0, 0, 505, 355);
		panel_3.add(lblNewLabel_8);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String PersonID_Name =(String)comboBox.getSelectedItem();
		String[] array = PersonID_Name.split("-");
		String key="";
		key = array[0];//获取关键字
		//点击"查询按钮"显示信息
		if(cmd.equals("显示"))
		{
			//获得comboBox的内容
			
			System.out.println("PersonID_Name"+PersonID_Name);
			String sql = "select * from Person where PersonID="+key;  
	        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
	        String PersonID = textField.getText().trim();
			String Name = textField_1.getText().trim();
			String Sex = textField_2.getText().trim();
			String Birth = textField_5.getText().trim();
			String Nat = textField_3.getText().trim();
			String Address = textField_6.getText().trim();
			String Other = textField_4.getText().trim();
	        try{
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
	            while(rs.next())
	            {
	            	textField.setText(rs.getString(1));
	            	textField_1.setText(rs.getString(2));
	            	textField_2.setText(rs.getString(3));
	            	textField_5.setText(rs.getString(4));
	            	textField_3.setText(rs.getString(5));
	            	textField_6.setText(rs.getString(6));
	            	textField_4.setText(rs.getString(10));	
	            }
	            System.out.println("None1_P2");
	            rs.close();
	            con.close();
	        }
	        catch(SQLException e1)
	        {      
	            e1.printStackTrace();   
	        } 
		}
		if(cmd.equals("修改"))
		{
			//其中getText()是获得文本，trim()是用来去掉文本前后的空字符的。
			String PersonID = textField.getText().trim();
			String Name = textField_1.getText().trim();
			String Sex = textField_2.getText().trim();
			String Birth = textField_5.getText().trim();
			String Nat = textField_3.getText().trim();
			String Address = textField_6.getText().trim();
			String Other = textField_4.getText().trim();
			int i = 0;
	        Connection con = a.getConn();
	        String sql = "update Person set PersonID=?,Name=?,Sex=?,Birth=?,Nat=?,Address=?,Other=? where PersonID =?";
	        try 
	        {
	            //用来执行SQL语句
	            PreparedStatement pst = con.prepareStatement(sql); 
	            pst.setString(1, PersonID); 
	            pst.setString(2, Name); 
	            pst.setString(3, Sex); 
	            pst.setString(4, Birth); 
	            pst.setString(5, Nat); 
	            pst.setString(6, Address); 
	            pst.setString(7, Other); 
	            pst.setString(8, key); 
	            i = pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "修改成功");
	        }
	        catch (Exception e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "失败，修改数据不完整或者重复添加等其他原因");
	        }
	        System.out.println(i);
			System.out.println("修改="+PersonID);
		}
		if(cmd.equals("清空"))
		{
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_5.setText("");
			textField_3.setText("");
			textField_6.setText("");
			textField_4.setText("");
		}
	}
}
