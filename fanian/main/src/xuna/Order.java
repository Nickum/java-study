package xuna;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class Order implements ActionListener
{

		public JFrame frame=null;
		public JTextField textField;
		public JTextField textField_1;
		FileReader r_file;//字符文件输入流  
	    FileWriter w_file;//字符文件输出流  
	    BufferedReader buf_reader;//与FileReader类配合使用，将字符输入到缓冲区，使数据处理速度大大加快，提高读写的效率  
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u5C0F\u7C73\u5357\u74DC\u7CA5  1.5");
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("\u996D\u83DC        7");
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("\u9E21\u86CB\u7092\u9762     7");
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("\u76AE\u86CB\u7626\u8089\u7CA5   2");
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("\u996D\u83DC        8");
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("\u996D\u83DC        2");
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("\u539F\u5473\u6E14\u7C89     7");
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("\u996D\u83DC        9");
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("\u996D\u83DC1         4");
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("\u80A5\u725B\u7C73\u7EBF     7");
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("\u996D\u83DC        1");
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("\u996D\u83DC        3");
		JTextArea textArea = new JTextArea();
		private final JLabel lblyymmddHhss = new JLabel("\u683C\u5F0F\u4E3Ayy-mm-dd hh-ss");
		
		public Order()
		{
			initialize();
		}
		public void initialize()
		{
			frame = new JFrame();
			frame.setBounds(100, 100, 1204, 539);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 514, 10);
			frame.getContentPane().add(panel);
			
			JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u684C\u53F7\uFF081-10\uFF09\uFF1A");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setBounds(10, 13, 276, 18);
			lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 20));
			frame.getContentPane().add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(277, 12, 146, 23);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel label = new JLabel("\u70B9\u9910\u65E5\u671F\u548C\u65F6\u95F4\uFF1A");
			label.setForeground(Color.BLUE);
			label.setFont(new Font("黑体", Font.PLAIN, 20));
			label.setBounds(460, 18, 178, 18);
			frame.getContentPane().add(label);
			
			textField_1 = new JTextField();
			textField_1.setBounds(626, 13, 139, 24);
			frame.getContentPane().add(textField_1);
			textField_1.setColumns(10);
			
			chckbxNewCheckBox.setBounds(25, 139, 169, 27);
			frame.getContentPane().add(chckbxNewCheckBox);
			
			chckbxNewCheckBox_1.setBounds(309, 139, 157, 27);
			frame.getContentPane().add(chckbxNewCheckBox_1);
			
			chckbxNewCheckBox_2.setBounds(25, 368, 157, 27);
			frame.getContentPane().add(chckbxNewCheckBox_2);
		
			chckbxNewCheckBox_3.setBounds(25, 194, 146, 27);
			frame.getContentPane().add(chckbxNewCheckBox_3);
			
			chckbxNewCheckBox_4.setBounds(309, 194, 133, 27);
			frame.getContentPane().add(chckbxNewCheckBox_4);
			
			chckbxNewCheckBox_5.setBounds(309, 355, 133, 27);
			frame.getContentPane().add(chckbxNewCheckBox_5);
			
			chckbxNewCheckBox_6.setBounds(25, 249, 169, 27);
			frame.getContentPane().add(chckbxNewCheckBox_6);
			
			chckbxNewCheckBox_7.setBounds(309, 249, 133, 27);
			frame.getContentPane().add(chckbxNewCheckBox_7);
			
			chckbxNewCheckBox_8.setBounds(25, 427, 169, 27);
			frame.getContentPane().add(chckbxNewCheckBox_8);
			
			chckbxNewCheckBox_9.setBounds(25, 305, 146, 27);
			frame.getContentPane().add(chckbxNewCheckBox_9);
			
			chckbxNewCheckBox_10.setBounds(309, 305, 133, 27);
			frame.getContentPane().add(chckbxNewCheckBox_10);

			chckbxNewCheckBox_11.setBounds(309, 427, 133, 27);
			frame.getContentPane().add(chckbxNewCheckBox_11);
			
			JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u4F60\u8981\u70B9\u7684\u83DC(\u5143/\u4EFD\uFF09\uFF1A");
			label_1.setForeground(Color.RED);
			label_1.setFont(new Font("黑体", Font.BOLD, 20));
			label_1.setBounds(10, 74, 276, 18);
			frame.getContentPane().add(label_1);
			
			textArea.setBounds(787, 45, 385, 421);
			frame.getContentPane().add(textArea);
			
			JButton button = new JButton("\u67E5\u770B\u8D26\u5355\u4FE1\u606F");
			button.addActionListener(this); 
			button.setFont(new Font("黑体", Font.PLAIN, 20));
			button.setBackground(Color.GREEN);
			button.setForeground(Color.BLACK);
			button.setBounds(588, 139, 164, 27);
			frame.getContentPane().add(button);
			
			JButton btnNewButton = new JButton("\u7ED3\u8D26");
			btnNewButton.setFont(new Font("黑体", Font.PLAIN, 20));
			btnNewButton.setBackground(Color.ORANGE);
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(588, 280, 164, 27);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u9000\u51FA");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setBounds(588, 427, 164, 27);
			frame.getContentPane().add(btnNewButton_1);
			
			JLabel label_2 = new JLabel("\u663E\u793A\u8D26\u5355\u533A\u57DF");
			label_2.setFont(new Font("宋体", Font.PLAIN, 20));
			label_2.setBackground(Color.GREEN);
			label_2.setForeground(Color.BLUE);
			label_2.setBounds(787, 15, 255, 18);
			frame.getContentPane().add(label_2);
			lblyymmddHhss.setFont(new Font("黑体", Font.PLAIN, 15));
			lblyymmddHhss.setBounds(603, 46, 169, 18);
			
			frame.getContentPane().add(lblyymmddHhss);
		}
		public void setVisible(boolean b)
		{
			// TODO Auto-generated method stub
			if(frame!=null)
			{
				frame.setVisible(b);
			}
		}
		
		//读取文件  
	    public void readFile()  
	    {  
	        String s;  
	        try  
	        {  
	            File f=new File("C:\\Users\\Administrator\\Desktop\\xuna.txt");  
	            r_file = new FileReader(f);//将文件f里面的内容给字符文件输入流  
	            buf_reader = new BufferedReader(r_file);  
	        }  
	        catch(IOException ef)  
	        {  
	            System.out.print(ef);  
	        }  
	        try  
	        {  
	            while ((s = buf_reader.readLine())!=null)  
	            {  
	            	textArea.append(s+'\n');  
	            }  
	        }  
	        catch(IOException er)  
	        {  
	            System.out.print(er);  
	        }  
	    }  
	    double money=0;
	    public void writeFile()  
	    {  
	        try  
	        {  
	            w_file = new FileWriter("C:\\Users\\Administrator\\Desktop\\xuna.txt");  
	            BufferedWriter buf_writer = new BufferedWriter(w_file);  
				String table="桌号为  ："+ textField.getText();
				String str="";
				String date= "订餐时间为："+textField_1.getText();
				
				System.out.println(table.length());
				 if( textField.getText().length()==0) 
				 {
					    JOptionPane.showMessageDialog(null, "请输入桌号", "错误", JOptionPane.ERROR_MESSAGE); 
			            System.out.println("JTextField的内容为空！");
				 }
				 else
				 {
	            		buf_writer.write(table,0,table.length());  
	            		buf_writer.newLine();
				 }
				 if( textField_1.getText().length()==0) 
				 {
					    JOptionPane.showMessageDialog(null, "请输入订餐时间，格式为yy-mm-dd hh-ss", "错误", JOptionPane.ERROR_MESSAGE); 
			            System.out.println("JTextField的内容为空！");
				 }
				 else
				 {
					 	buf_writer.write(date,0,date.length());  
	            		buf_writer.newLine();
				 }
	            if(chckbxNewCheckBox.isSelected() == true)
		    	{
	            		str = chckbxNewCheckBox.getText();
	            		buf_writer.write(str,0,str.length());  
	            		buf_writer.newLine();
	            		money = money +  1.5;
		    		    System.out.println(chckbxNewCheckBox.getText()+money);
		    	}
		    	if(chckbxNewCheckBox_1.isSelected() == true)
		    	{
		    		 str = chckbxNewCheckBox_1.getText();
            		 buf_writer.write(str,0,str.length());  
            		 buf_writer.newLine();
            		 money = money +  7;
		    		 System.out.println(chckbxNewCheckBox_1.getText());
		    	}
		    	if(chckbxNewCheckBox_2.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_2.getText() ;
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  7;
		    		 System.out.println(chckbxNewCheckBox_2.getText());
		    	}
		    	if(chckbxNewCheckBox_3.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_3.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  2;
		    		 System.out.println(chckbxNewCheckBox_3.getText());
		    	}
		    	if(chckbxNewCheckBox_4.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_4.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  8;
		    		 System.out.println(chckbxNewCheckBox_4.getText());
		    	}
		    	if(chckbxNewCheckBox_5.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_5.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  2;
		    		 System.out.println(chckbxNewCheckBox_5.getText());
		    	}
		    	if(chckbxNewCheckBox_6.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_6.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  7;
		    		 System.out.println(chckbxNewCheckBox_6.getText());
		    	}
		    	if(chckbxNewCheckBox_7.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_7.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            	    money = money +  9;
		    		 System.out.println(chckbxNewCheckBox_7.getText());
		    	}
		    	if(chckbxNewCheckBox_8.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_8.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  4;
		    		 System.out.println(chckbxNewCheckBox_8.getText());
		    	}
		    	if(chckbxNewCheckBox_9.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_9.getText();
            		buf_writer.write(str,0,str.length()); 
            		buf_writer.newLine();
            		money = money +  7;
		    		 System.out.println(chckbxNewCheckBox_9.getText());
		    	}
		    	if(chckbxNewCheckBox_10.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_10.getText();
            		buf_writer.write(str,0,str.length()); 
            		buf_writer.newLine();
            		money = money +  1;
		    		 System.out.println(chckbxNewCheckBox_10.getText());
		    	}
		    	if(chckbxNewCheckBox_11.isSelected() == true)
		    	{
		    		str = chckbxNewCheckBox_11.getText();
            		buf_writer.write(str,0,str.length());  
            		buf_writer.newLine();
            		money = money +  3;
		    		System.out.println(chckbxNewCheckBox_11.getText());
		    	}
		    	str = "你共消费了"+money+"元";
        		buf_writer.write(str,0,str.length());  
        		buf_writer.newLine();
		    	System.out.println(money);
		    	 buf_writer.flush();//一般情况下，writer方法向输出流写数据时，先把数据存放在缓冲区，这时缓冲区的数据不会自动写入输出流，只有当缓冲区满时，才会一次性将缓冲区的数据写入输出流，即写入文件。为了把尚未填满的缓冲区中的数据送出去，这时就要使用flush方法。  
	        }  
	        catch(IOException ew)  
	        {  
	            System.out.print(ew);  
	        }  
	    }  
	    
		@Override
		public void actionPerformed(ActionEvent e)
		{
				String cmd = e.getActionCommand(); 
				if(cmd.equals("查看账单信息"))
				{
					    FileReader r_file;//字符文件输入流  
					    FileWriter w_file;//字符文件输出流  
					    BufferedReader buf_reader;//与FileReader类配合使用，将字符输入到缓冲区，使数据处理速度大大加快，提高读写的效率  
				    
				    
				    	writeFile() ;   
				    	 readFile() ;
				}
				if(cmd.equals("结账"))
				{
					JOptionPane.showConfirmDialog(null, "你共消费了"+money+"元，是否确定结账", "确定", JOptionPane.YES_NO_OPTION); 
				}
				if(cmd.equals("退出"))
				{
					System.exit(0);
				}
			
		}
	}
	
