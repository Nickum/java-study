package xuna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start implements ActionListener
{
		public JFrame frame;
	
		public static void main(String[] args)
		{
		
					Start window = new Start();
					window.frame.setVisible(true);
				
		}
		public Start()
		{
			frame = new JFrame();
			frame.setBounds(100, 100, 563, 489);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u5149\u4E34  \u5929\u5929\u996D\u5E97");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setBackground(Color.GRAY);
			lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 29));
			lblNewLabel.setBounds(152, 13, 329, 91);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel label = new JLabel("\u8BF7\u9009\u62E9\u4F60\u7684\u64CD\u4F5C\uFF1A");
			label.setForeground(Color.BLUE);
			label.setBackground(Color.DARK_GRAY);
			label.setFont(new Font("黑体", Font.PLAIN, 20));
			label.setBounds(37, 236, 162, 35);
			frame.getContentPane().add(label);
			
			JButton btnNewButton = new JButton("\u6211\u8981\u70B9\u83DC");
			btnNewButton.setBackground(Color.GREEN);
			btnNewButton.setForeground(Color.RED);
			btnNewButton.setFont(new Font("黑体", Font.PLAIN, 23));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(298, 169, 134, 27);
			frame.getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("\u9000\u51FA");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setForeground(Color.GREEN);
			btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 23));
			btnNewButton_1.setBounds(298, 299, 134, 27);
			frame.getContentPane().add(btnNewButton_1);
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
				String cmd = e.getActionCommand(); 
				if(cmd.equals("我要点菜"))
				{
					
				    new Order().setVisible(true); //创建Frame窗口
					
				}
				if(cmd.equals("退出"))
				{
					System.exit(0);
				}
				
			}
		
}
