package stuMessage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DetailWindow {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailWindow window = new DetailWindow();
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
	public DetailWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPicture = new JLabel("picture");
		lblPicture.setBounds(12, 12, 61, 15);
		frame.getContentPane().add(lblPicture);
		
		JLabel lid = new JLabel("学号");
		lid.setBounds(155, 12, 61, 15);
		frame.getContentPane().add(lid);
		
		JLabel lName = new JLabel("姓名");
		lName.setBounds(155, 39, 61, 15);
		frame.getContentPane().add(lName);
		
		JLabel lSex = new JLabel("性别");
		lSex.setBounds(155, 66, 61, 15);
		frame.getContentPane().add(lSex);
		
		JLabel lAge = new JLabel("年龄");
		lAge.setBounds(155, 93, 61, 15);
		frame.getContentPane().add(lAge);
		
		JLabel lBirth = new JLabel("生日");
		lBirth.setBounds(12, 140, 61, 15);
		frame.getContentPane().add(lBirth);
		
		JLabel lDept = new JLabel("学院");
		lDept.setBounds(12, 167, 61, 15);
		frame.getContentPane().add(lDept);
		
		JLabel lMajor = new JLabel("专业");
		lMajor.setBounds(12, 208, 61, 15);
		frame.getContentPane().add(lMajor);
		
		JLabel lGrade = new JLabel("年级");
		lGrade.setBounds(207, 120, 61, 15);
		frame.getContentPane().add(lGrade);
		
		JLabel lGrass = new JLabel("班级");
		lGrass.setBounds(207, 153, 61, 15);
		frame.getContentPane().add(lGrass);
		
		JLabel lPhone = new JLabel("电话");
		lPhone.setBounds(207, 194, 61, 15);
		frame.getContentPane().add(lPhone);
		
		tId = new JTextField();
		tId.setBounds(238, 10, 104, 19);
		frame.getContentPane().add(tId);
		tId.setColumns(10);
		
		tName = new JTextField();
		tName.setBounds(248, 37, 104, 19);
		frame.getContentPane().add(tName);
		tName.setColumns(10);
		
		tSex = new JTextField();
		tSex.setBounds(234, 62, 104, 19);
		frame.getContentPane().add(tSex);
		tSex.setColumns(10);
		
		tAge = new JTextField();
		tAge.setBounds(238, 91, 104, 19);
		frame.getContentPane().add(tAge);
		tAge.setColumns(10);
		
		tBirth = new JTextField();
		tBirth.setBounds(91, 138, 104, 19);
		frame.getContentPane().add(tBirth);
		tBirth.setColumns(10);
		
		tDept = new JTextField();
		tDept.setBounds(85, 165, 104, 19);
		frame.getContentPane().add(tDept);
		tDept.setColumns(10);
		
		tMajor = new JTextField();
		tMajor.setBounds(85, 206, 104, 19);
		frame.getContentPane().add(tMajor);
		tMajor.setColumns(10);
		
		tGrade = new JTextField();
		tGrade.setBounds(286, 118, 104, 19);
		frame.getContentPane().add(tGrade);
		tGrade.setColumns(10);
		
		tGrass = new JTextField();
		tGrass.setBounds(286, 151, 104, 19);
		frame.getContentPane().add(tGrass);
		tGrass.setColumns(10);
		
		tPhone = new JTextField();
		tPhone.setBounds(296, 192, 104, 19);
		frame.getContentPane().add(tPhone);
		tPhone.setColumns(10);
		
		frame.setVisible(true);
	}
}
