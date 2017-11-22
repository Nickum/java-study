package xuna;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
/*
 * 主函数入口
 */
public class HrMain implements ActionListener,TreeSelectionListener{

	public JFrame frame;
	public JPanel panel = new JPanel();
	public JSplitPane splitPane = new JSplitPane();
	public JTree tree = new JTree();
	None1_P1 p1 = new None1_P1(); //p1:添加人员信息
	None1_P2 p2 = new None1_P2(); //p2:修改人员信息
	None1_P3 p3 = new None1_P3(); //p3:删除人员信息
	None1_P4 p4 = new None1_P4(); //p4:查询人员信息
	None1_P5 p5 = new None1_P5(); //p4:查询人员信息
	
	None2_P1 p6 = new None2_P1(); //人员调动
	None2_P2 p7 = new None2_P2(); //调动历史查询
	
	None3_P1 p8 = new None3_P1(); //人员考核
	None3_P2 p9 = new None3_P2(); //考核历史查询
	

	None4_P1 p10 = new None4_P1(); //劳资分配管理
	None4_P2 p11 = new None4_P2(); //劳资历史查询
	private final JLabel lblNewLabel = new JLabel("New label");
	public static void main(String[] args) {
		HrMain window = new HrMain();
		window.frame.setVisible(true);
}
	public HrMain() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		splitPane.setContinuousLayout(true);
		splitPane.setBounds(0, 0, 669, 370);
		splitPane.setOneTouchExpandable(true);
		frame.getContentPane().add(splitPane);
		tree.setFont(new Font("宋体", Font.BOLD, 15));
		tree.setShowsRootHandles(true);
		tree.setBackground(Color.WHITE);
		tree.setEditable(true);
		panel.setLayout(null);
		JLabel label = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(137, 86, 263, 46);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("宋体", Font.BOLD, 18));
		panel.add(label);
		splitPane.setRightComponent(panel);
		lblNewLabel.setBounds(-212, -81, 808, 484);
		lblNewLabel.setIcon(new ImageIcon(HrMain.class.getResource("/xuna/57a99cdc3fa06.jpg")));
		
		panel.add(lblNewLabel);
		
		
		tree.addTreeSelectionListener(this);
		splitPane.setLeftComponent(tree);	
		tree.setModel(new DefaultTreeModel(
		new DefaultMutableTreeNode("\u4EBA\u4E8B\u7BA1\u7406\u7CFB\u7EDF") {
		{
			DefaultMutableTreeNode node_1;
			node_1 = new DefaultMutableTreeNode("\u57FA\u672C\u4FE1\u606F\u7BA1\u7406");
				node_1.add(new DefaultMutableTreeNode("\u6DFB\u52A0\u4EBA\u5458\u4FE1\u606F"));
				node_1.add(new DefaultMutableTreeNode("\u4FEE\u6539\u4EBA\u5458\u4FE1\u606F"));
				node_1.add(new DefaultMutableTreeNode("\u5220\u9664\u4EBA\u5458\u4FE1\u606F"));
				node_1.add(new DefaultMutableTreeNode("\u67E5\u8BE2\u4EBA\u5458\u4FE1\u606F"));
				node_1.add(new DefaultMutableTreeNode("\u90E8\u95E8\u7BA1\u7406"));
			add(node_1);
			node_1 = new DefaultMutableTreeNode("\u4EBA\u5458\u8C03\u52A8\u7BA1\u7406");
				node_1.add(new DefaultMutableTreeNode("\u4EBA\u5458\u8C03\u52A8"));
				node_1.add(new DefaultMutableTreeNode("\u8C03\u52A8\u5386\u53F2\u67E5\u8BE2"));
			add(node_1);
			node_1 = new DefaultMutableTreeNode("\u4EBA\u5458\u8003\u6838\u8BB0\u5F55");
				node_1.add(new DefaultMutableTreeNode("\u4EBA\u5458\u8003\u6838"));
				node_1.add(new DefaultMutableTreeNode("\u8003\u6838\u5386\u53F2\u67E5\u8BE2"));
			add(node_1);
			node_1 = new DefaultMutableTreeNode("\u52B3\u8D44\u7BA1\u7406");
				node_1.add(new DefaultMutableTreeNode("\u52B3\u8D44\u5206\u914D\u7BA1\u7406"));
				node_1.add(new DefaultMutableTreeNode("\u52B3\u8D44\u5386\u53F2\u67E5\u8BE2"));
			add(node_1);
		}}));
	}
	public void valueChanged(TreeSelectionEvent temp) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)temp.getPath().getLastPathComponent();
		String str = node.toString();
		if(str=="人事管理系统")
		{
			System.out.print("panel");
			splitPane.setRightComponent(panel);
		}
		else if(str == "添加人员信息")
		{
			System.out.print("panel_1");
			splitPane.setRightComponent(p1.panel_1);
		}
		else if(str == "修改人员信息")
		{
			System.out.print("panel_3");
			splitPane.setRightComponent(p2.panel_3);
		}
		else if(str == "删除人员信息")
		{
			System.out.print("panel_3");
			splitPane.setRightComponent(p3.panel);
		}
		else if(str == "查询人员信息")
		{
			System.out.print("panel_4");
			splitPane.setRightComponent(p4.panel);
		}
		else if(str == "部门管理")
		{
			System.out.print("panel_5");
			splitPane.setRightComponent(p5.panel);
		}
		else if(str == "人员调动")
		{
			System.out.print("pane2_1");
			splitPane.setRightComponent(p6.panel);
		}
		else if(str == "调动历史查询")
		{
			System.out.print("pane2_2");
			splitPane.setRightComponent(p7.panel);
		}
		else if(str == "人员考核")
		{
			System.out.print("pane2_2");
			splitPane.setRightComponent(p8.panel);
		}
		else if(str == "考核历史查询")
		{
			System.out.print("pane2_2");
			splitPane.setRightComponent(p9.panel);
		}
		else if(str == "劳资分配管理")
		{
			System.out.print("pane2_2");
			splitPane.setRightComponent(p10.panel);
		}
		else if(str == "劳资历史查询")
		{
			System.out.print("pane2_2");
			splitPane.setRightComponent(p11.panel);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
