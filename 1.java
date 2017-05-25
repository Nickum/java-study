package 学生信息;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class 学生信息 implements ItemListener{//JComboBox的监听器

	String sex;
	private JFrame frame;
	private JTextField textField;

    //FileReader r_file;
    FileWriter w_file;
    //BufferedReader buf_reader;
    BufferedWriter buf_writer;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					学生信息 window = new 学生信息();
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
	public 学生信息() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 22));
		frame.setBounds(100, 100, 817, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u5F55\u5165\u754C\u9762");
		lblNewLabel.setBounds(239, 15, 334, 67);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u5B66\u53F7\uFF1A");
		label.setBounds(29, 107, 81, 21);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(102, 106, 167, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) //按钮的点击事件
			{
				if(e.getSource()== btnNewButton)
				{
					writeFile();
				}
				if(e.getSource()== btnNewButton)
				{
					System.exit(0);
				}
			}
			public void writeFile()
			{
				try
				{
					w_file = new FileWriter("C:\\Users\\Administrator\\Desktop\\java小程序\\学生信息.txt");
					buf_writer = new BufferedWriter(w_file);
					String t=" ";
					String number = textField .getText();//读入学号
					buf_writer.write(number,0,number.length());
					buf_writer.write(t,0,t.length());
					
					String name = textField_1.getText();//读入姓名
					buf_writer.write(name,0,name.length());
					buf_writer.write(t,0,t.length());
					
					buf_writer.write(sex,0,sex.length());//读入性别
					buf_writer.write(t,0,t.length());
					
					String nom = textField_2 .getText();//读入宿舍号
					buf_writer.write(nom,0,nom.length());
					buf_writer.write(t,0,t.length());
					
					String clas= textField_3 .getText();//读入班级
					buf_writer.write(clas,0,clas.length());
					buf_writer.write(t,0,t.length());
					
					String cell= textField_4 .getText();//读入班级
					buf_writer.write(cell,0,cell.length());
					buf_writer.write(t,0,t.length());
					buf_writer.flush();
					JOptionPane.showMessageDialog(null, "保存成功");
					
				}
				catch(IOException ew)
				{
					System.out.print(ew);
				}
			}
			
		});
		btnNewButton.setBounds(531, 371, 123, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(29, 163, 81, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 162, 167, 27);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		label_1.setBounds(29, 225, 81, 21);
		frame.getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		 
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(102, 224, 167, 27);
		comboBox.addItemListener(this);
		frame.getContentPane().add(comboBox);
		
		JLabel label_2 = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 24));
		label_2.setBounds(393, 97, 113, 21);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u73ED\u7EA7\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 24));
		label_3.setBounds(393, 165, 81, 21);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 24));
		label_4.setBounds(393, 227, 81, 21);
		frame.getContentPane().add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(521, 97, 147, 27);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(521, 162, 147, 27);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(521, 224, 147, 27);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u53D6\u6D88");
		button.setBounds(86, 371, 123, 29);
		frame.getContentPane().add(button);
	}
	public void itemStateChanged(ItemEvent e) {//下拉列表的获取事件
		sex=e.getItem().toString();
	}
}
