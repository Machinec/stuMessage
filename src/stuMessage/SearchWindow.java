package stuMessage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SearchWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchWindow window = new SearchWindow();
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
	public SearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"学号", "姓名"}));
		comboBox.setBounds(81, 104, 88, 24);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(181, 104, 189, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn_sure = new JButton("确定");
		btn_sure.setBounds(97, 197, 107, 25);
		frame.getContentPane().add(btn_sure);
		
		JButton btn_cancel = new JButton("取消");
		btn_cancel.setBounds(263, 197, 107, 25);
		frame.getContentPane().add(btn_cancel);
		frame.setVisible(true);
		
		btn_sure.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String culum = comboBox.getSelectedItem().toString();
				String searchitem = textField.getText();
				String sql = new String();
				if(culum == "学号") sql="select * from student where ID="+"'"+searchitem+"'";
				if(culum == "姓名") sql="select * from student where Name="+"'"+searchitem+"'";
				if(searchitem==null) {
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "请输入查找信息", "提示", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					SQLconnection sqLconnection = new SQLconnection();
					Connection connection = sqLconnection.getConnection();
					try {
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery(sql);
						if(!resultSet.next()) {
							JOptionPane jOptionPane = new JOptionPane();
							jOptionPane.showMessageDialog(null, "没有该学生信息", "查找错误", JOptionPane.PLAIN_MESSAGE);
						}
						else {
							String selectedid = resultSet.getString(1);
							DetailWindow detailWindow = new DetailWindow(selectedid);
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
	}
}
