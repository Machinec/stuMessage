package stuMessage;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class AddWindow {

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
	private String path;
	
	static Statement statement;
	static ResultSet resultSet;
	static ResultSetMetaData rsmd;
	static Connection connection;

	public AddWindow() {
		initialize();
	}

	private void initialize() {
//		SQLconnection sqLconnection = new SQLconnection();
//		connection = sqLconnection.getConnection();
//		try {
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery("select * from student where ID="+selectedid);
//			resultSet.next();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		//设置标签
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 310);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPicture = new JLabel("picture");
		lblPicture.setBounds(12, 12, 104, 100);
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
		
		//设置显示框
		try {
		tId = new JTextField();
		tId.setBounds(245, 12, 104, 19);
		frame.getContentPane().add(tId);
		tId.setColumns(10);
		
		tName = new JTextField();
		tName.setBounds(245, 39, 104, 19);
		frame.getContentPane().add(tName);
		tName.setColumns(10);
		
		tSex = new JTextField();
		tSex.setBounds(245, 66, 104, 19);
		frame.getContentPane().add(tSex);
		tSex.setColumns(10);
		
		tAge = new JTextField();
		tAge.setBounds(245, 93, 104, 19);
		frame.getContentPane().add(tAge);
		tAge.setColumns(10);
		
		tBirth = new JTextField();
		tBirth.setBounds(47, 154, 104, 19);
		frame.getContentPane().add(tBirth);
		tBirth.setColumns(10);
		
		tDept = new JTextField();
		tDept.setBounds(47, 181, 104, 19);
		frame.getContentPane().add(tDept);
		tDept.setColumns(10);
		
		tMajor = new JTextField();
		tMajor.setBounds(47, 208, 104, 19);
		frame.getContentPane().add(tMajor);
		tMajor.setColumns(10);
		
		tGrade = new JTextField();
		tGrade.setBounds(245, 154, 104, 19);
		frame.getContentPane().add(tGrade);
		tGrade.setColumns(10);
		
		tGrass = new JTextField();
		tGrass.setBounds(245, 181, 104, 19);
		frame.getContentPane().add(tGrass);
		tGrass.setColumns(10);
		
		tPhone = new JTextField();
		tPhone.setBounds(245, 206, 104, 19);
		frame.getContentPane().add(tPhone);
		tPhone.setColumns(10);
		
		JButton sure = new JButton("确认");
		JButton cancel = new JButton("取消");
		sure.setBounds(47,240,104,19);
		cancel.setBounds(245,240,104,19);
		frame.getContentPane().add(sure);
		frame.getContentPane().add(cancel);
		
		JButton choose = new JButton("选图");
		choose.setBounds(107, 103, 75, 25);
		frame.getContentPane().add(choose);
		
//		String path = new String();//照片路径
//		String fileName = new String();//图片名
		
		choose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		          JFileChooser jfc = new JFileChooser();
		          jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		          jfc.showDialog(new JLabel(), "选择");  
	              path=jfc.getSelectedFile().getPath();
		          try {
		              ImageIcon icon = new ImageIcon(path);
		              icon.setImage(icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
		              lblPicture.setIcon(icon);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] str = new String[10];
				str[0] = tId.getText();
				str[1] = tName.getText();
				str[2] = tSex.getText();
				str[3] = tAge.getText();
				str[4] = tBirth.getText();
				str[5] = tDept.getText();
				str[6] = tMajor.getText();
				str[7] = tGrade.getText();
				str[8] = tGrass.getText();
				str[9] = tPhone.getText();
				
				//获取并保存图片
				String imageName = str[0]+".jpg";
				File image = new File(path);
				BufferedImage bufferedImage = null;
				try {
					bufferedImage = ImageIO.read(image);
			        ImageIO.write(bufferedImage, "jpeg", new File(imageName));
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				String sql = "insert into student set ID='"+str[0]+"',Name='"+str[1]+"',Sex='"+str[2]+"',Age="+Integer.valueOf(str[3]).intValue()+",Birth='"+str[4]+"',Dept='"+str[5]+"',Major='"+str[6]+"',Grade='"+str[7]+"',Class='"+str[8]+"',Phone='"+str[9]+"'";
//				System.out.println(sql);
				String sql2 = "insert into image set ID='"+str[0]+"',Name='"+imageName+"'";
				try {
					SQLconnection sqLconnection = new SQLconnection();
					connection = sqLconnection.getConnection();
					statement = connection.createStatement();
					statement.executeUpdate(sql);
					statement.executeUpdate(sql2);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				JOptionPane jOptionPane = new JOptionPane();
				frame.dispose();
				jOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();//关闭当前窗口
			}
		});
		
		frame.setVisible(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


