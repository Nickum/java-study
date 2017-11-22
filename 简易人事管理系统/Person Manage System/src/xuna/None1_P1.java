package xuna;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
/*
 * 添加人员信息
 */
public class None1_P1 implements ActionListener {
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JComboBox comboBox;
	database a = new database();
	public JPanel panel_1 = new JPanel();
	public None1_P1() {
		
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u4EBA\u5458\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(139, 20, 190, 15);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(14, 48, 445, 302);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u4EBA\u5458\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setBounds(26, 25, 74, 15);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(91, 22, 102, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EBA\u5458\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(239, 25, 79, 15);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(328, 22, 96, 21);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027    \u522B\uFF1A");
		lblNewLabel_3.setBounds(26, 68, 66, 15);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		lblNewLabel_4.setBounds(239, 68, 79, 15);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6C11    \u65CF\uFF1A");
		lblNewLabel_5.setBounds(26, 117, 66, 15);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5730    \u5740\uFF1A");
		lblNewLabel_6.setBounds(239, 117, 79, 15);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u90E8    \u95E8\uFF1A");
		lblNewLabel_7.setBounds(26, 172, 74, 15);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\u5176    \u4ED6\uFF1A");
		lblNewLabel_8.setBounds(239, 172, 79, 15);
		panel_2.add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 65, 102, 21);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(328, 65, 96, 21);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(91, 114, 102, 21);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(328, 114, 96, 21);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(91, 169, 96, 21);
		String sql = "select * from Dept";  
        Connection con = a.getConn();//此处为通过自己写的方法getConn()获得连接  
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
            String DeptID=null,B_Dept=null,S_Dept=null,res="";
            while(rs.next())
            {
            	DeptID = rs.getString(1)+"-";
            	B_Dept = rs.getString(2)+"-";
            	S_Dept = rs.getString(3);
            	res = DeptID+B_Dept+S_Dept;
            	comboBox.addItem(res);
            	System.out.println(res);
            }
            System.out.println("None1_P1");
            rs.close();
            con.close();
        }
        catch(SQLException e)
        {      
            e.printStackTrace();   
        } 
		panel_2.add(comboBox);
		
		textField_6 = new JTextField();
		textField_6.setBounds(328, 169, 96, 21);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.setBounds(75, 264, 93, 23);
		btnNewButton.addActionListener(this);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
		btnNewButton_1.setBounds(278, 264, 93, 23);
		btnNewButton_1.addActionListener(this);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(None1_P1.class.getResource("/xuna/57a99cdc3fa06.jpg")));
		lblNewLabel_9.setBounds(-4, 0, 599, 416);
		panel_1.add(lblNewLabel_9);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("增加"))
		{	//JOptionPane.showMessageDialog(null, "这是一个简单的消息框");
			//其中getText()是获得文本，trim()是用来去掉文本前后的空字符的。
			String PersonID = textField.getText().trim();
			String Name = textField_1.getText().trim();
			String Sex = textField_2.getText().trim();
			String Birth = textField_3.getText().trim();
			String Nat = textField_4.getText().trim();
			String Address = textField_5.getText().trim();
			String DeptID=(String)comboBox.getSelectedItem();
			String[] array = DeptID.split("-");
			String key="";
			key = array[0]+array[1]+array[2];//获取关键字
			String Salary = "0";
			String Assess="未考核";
			String Other = textField_6.getText().trim();
			int i = 0;
	        Connection con = a.getConn();
	        String sql = "insert into Person (PersonID,Name,Sex,Birth,Nat,Address,DeptID,Salary,Assess,Other) values (?,?,?,?,?,?,?,?,?,?)";
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
	            pst.setString(7, DeptID); 
	            pst.setString(8, Salary); 
	            pst.setString(9, Assess);
	            pst.setString(10, Other);  
	            i = pst.executeUpdate();
	            JOptionPane.showMessageDialog(null, "添加成功");
	        }
	        catch (Exception e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "失败，添加数据不完整或者重复添加等其他原因");
	        }
	        System.out.println(i);
			System.out.println("增加="+PersonID);
		}
		if(cmd.equals("清空"))
		{
			System.out.println("清空");
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			//comboBox.setText("");
			//comboBox.Items.Clear();
		}
		
	}
}
