package stuMessage;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DetailWindow {

	private String selectedid;
	private JFrame frame;
	private JTextField tId;
	private JTextField tName;
	private JTextField tSex;
	private JTextField tAge;
	private JTextField tBirth;
	private JTextField tDept;
	private JTextField tMajor;
	private JTextField tGrade;
	private JTextField tGrass;
	private JTextField tPhone;
	
	static Statement statement;
	static ResultSet resultSet;
	static ResultSetMetaData rsmd;
	static Connection connection;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DetailWindow window = new DetailWindow();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public DetailWindow(String s) {
		selectedid = new String(s);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SQLconnection sqLconnection = new SQLconnection();
		connection = sqLconnection.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from student where ID="+selectedid);
			resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 400, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPicture = new JLabel("picture");
		lblPicture.setBounds(12, 12, 61, 15);
		frame.getContentPane().add(lblPicture);
		
		JLabel lid = new JLabel("学号");
		lid.setBounds(207, 12, 61, 15);
		frame.getContentPane().add(lid);
		
		JLabel lName = new JLabel("姓名");
		lName.setBounds(207, 39, 61, 15);
		frame.getContentPane().add(lName);
		
		JLabel lSex = new JLabel("性别");
		lSex.setBounds(207, 66, 61, 15);
		frame.getContentPane().add(lSex);
		
		JLabel lAge = new JLabel("年龄");
		lAge.setBounds(207, 93, 61, 15);
		frame.getContentPane().add(lAge);
		
		JLabel lBirth = new JLabel("生日");
		lBirth.setBounds(12, 154, 61, 15);
		frame.getContentPane().add(lBirth);
		
		JLabel lDept = new JLabel("学院");
		lDept.setBounds(12, 181, 61, 15);
		frame.getContentPane().add(lDept);
		
		JLabel lMajor = new JLabel("专业");
		lMajor.setBounds(12, 208, 61, 15);
		frame.getContentPane().add(lMajor);
		
		JLabel lGrade = new JLabel("年级");
		lGrade.setBounds(207, 154, 61, 15);
		frame.getContentPane().add(lGrade);
		
		JLabel lGrass = new JLabel("班级");
		lGrass.setBounds(207, 181, 61, 15);
		frame.getContentPane().add(lGrass);
		
		JLabel lPhone = new JLabel("电话");
		lPhone.setBounds(207, 208, 61, 15);
		frame.getContentPane().add(lPhone);
		
		try {
		tId = new JTextField();
		tId.setBounds(245, 12, 104, 19);
		frame.getContentPane().add(tId);
		tId.setColumns(10);
		tId.setEditable(false);
		tId.setText(resultSet.getString(1));
		
		tName = new JTextField();
		tName.setBounds(245, 39, 104, 19);
		frame.getContentPane().add(tName);
		tName.setColumns(10);
		tName.setEditable(false);
		tName.setText(resultSet.getString(2));
		
		tSex = new JTextField();
		tSex.setBounds(245, 66, 104, 19);
		frame.getContentPane().add(tSex);
		tSex.setColumns(10);
		tSex.setEditable(false);
		tSex.setText(resultSet.getString(3));
		
		tAge = new JTextField();
		tAge.setBounds(245, 93, 104, 19);
		frame.getContentPane().add(tAge);
		tAge.setColumns(10);
		tAge.setEditable(false);
		tAge.setText(resultSet.getString(4));
		
		tBirth = new JTextField();
		tBirth.setBounds(47, 154, 104, 19);
		frame.getContentPane().add(tBirth);
		tBirth.setColumns(10);
		tBirth.setEditable(false);
		tBirth.setText(resultSet.getString(5));
		
		tDept = new JTextField();
		tDept.setBounds(47, 181, 104, 19);
		frame.getContentPane().add(tDept);
		tDept.setColumns(10);
		tDept.setEditable(false);
		tDept.setText(resultSet.getString(6));
		
		tMajor = new JTextField();
		tMajor.setBounds(47, 208, 104, 19);
		frame.getContentPane().add(tMajor);
		tMajor.setColumns(10);
		tMajor.setEditable(false);
		tMajor.setText(resultSet.getString(7));
		
		tGrade = new JTextField();
		tGrade.setBounds(245, 154, 104, 19);
		frame.getContentPane().add(tGrade);
		tGrade.setColumns(10);
		tGrade.setEditable(false);
		tGrade.setText(resultSet.getString(8));
		
		tGrass = new JTextField();
		tGrass.setBounds(245, 181, 104, 19);
		frame.getContentPane().add(tGrass);
		tGrass.setColumns(10);
		tGrass.setEditable(false);
		tGrass.setText(resultSet.getString(9));
		
		tPhone = new JTextField();
		tPhone.setBounds(245, 206, 104, 19);
		frame.getContentPane().add(tPhone);
		tPhone.setColumns(10);
		tPhone.setEditable(false);
		tPhone.setText(resultSet.getString(10));
		
		frame.setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
