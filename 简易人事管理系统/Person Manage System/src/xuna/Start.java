package xuna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Start {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	database a1 = new database();
	int a,b,c;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 624, 416);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF");
		label_1.setFont(new Font("宋体", Font.PLAIN, 22));
		label_1.setBounds(181, 13, 264, 26);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(195, 100, 72, 18);
		panel.add(label);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(154, 131, 81, 32);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(154, 176, 81, 32);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(253, 137, 129, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =null,password=null,check=null;
				int n;
				username =  textField.getText().trim();
				password =  passwordField .getText().trim();
			    check =  textField_3.getText().trim();
				n = Integer.parseInt(check);
				if(username != null && password != null)
				{
					
					if(n == c)
					{
						int i = 0;
				        Connection con = a1.getConn();
				        String sql = "insert into User (username,password) values (?,?)";
				        try 
				        {
				            //用来执行SQL语句
				            PreparedStatement pst = con.prepareStatement(sql); 
				            pst.setString(1, username); 
				            pst.setString(2, password);  
				            i = pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "注册成功");
				        }
				        catch (Exception e1) {
				            e1.printStackTrace();
				            JOptionPane.showMessageDialog(null, "失败，注册数据不完整或者重复添加等其他原因");
				        }
				        System.out.println(i);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "验证码错误");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "用户名或者密码为空");
				}
			}
		});
		btnNewButton.setBounds(154, 340, 72, 27);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =null,password=null,check=null;
				int n;
				username =  textField.getText().trim();
				password =  passwordField .getText().trim();
			    check =  textField_3.getText().trim();
				n = Integer.parseInt(check);
				String sql = "select password from User where username='"+username+"'";  
		        Connection con = a1.getConn();//此处为通过自己写的方法getConn()获得连接  
		        try{
		        	
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery(sql); //ResultSet类，用来存放获取的结果集！！
		            String temp=null;
		            while(rs.next())
		            {
		            	temp = rs.getString(1);
		            }
		            System.out.println("n= "+n);
		            System.out.println("c= "+ c);
		            if(temp.equals(password))
		            {
		            	if(n == c)
						{
		            		HrMain window = new HrMain();
		            		window.frame.setVisible(true);
						}
		            	else
		            	{
		            		JOptionPane.showMessageDialog(null, "验证码错误");
		            	}
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "用户名或者密码不正确");
		            }
		            rs.close();
		            con.close();
		        }
		        catch(SQLException e1)
		        {      
		            e1.printStackTrace();   
		        } 
				
			}
		});
		button.setBounds(305, 340, 72, 27);
		panel.add(button);
		
		JLabel label_4 = new JLabel("\u8F93\u5165\u4E0A\u5F0F\u7ED3\u679C\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(154, 277, 144, 32);
		panel.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(253, 221, 129, 43);
		int max=20;
	    int min=10;
        Random random = new Random();
        a = random.nextInt(max)%(max-min+1) + min;
        b = random.nextInt(max)%(max-min+1) + min;
        
        c = a+b;
        
        System.out.println("a = "+ a);
        System.out.println("b = "+ b);
        System.out.println("c = "+ c);
        String temp = Integer.toString(a) + " + " + Integer.toString(b) + " = ?";
        textField_2.setText(temp) ;
        System.out.println(temp);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(282, 283, 100, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(253, 182, 129, 24);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Start.class.getResource("/xuna/57a99cdc3fa06.jpg")));
		lblNewLabel.setBounds(0, 0, 610, 416);
		panel.add(lblNewLabel);
	}
}
