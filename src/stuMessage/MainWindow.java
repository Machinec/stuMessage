package stuMessage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.Vector;

public class MainWindow extends JFrame{
	static Connection connection;
	static Statement statement;
	static ResultSet resultSet;
	static ResultSetMetaData rsmd;

	private DefaultTableModel getTableModel() {
		SQLconnection sqLconnection = new SQLconnection();
		connection = sqLconnection.getConnection();
    	Vector tableHeader = new Vector();//表头
    	String head[] = {"学号","姓名","性别","年龄","生日","学院","专业","年级","班级","电话"};
    	Vector tabledata = new Vector();//表格
    	try {
    		statement = connection.createStatement();
    		resultSet = statement.executeQuery("select * from student");
    		rsmd = resultSet.getMetaData();
    		//获得表头
//    		for(int i=1; i<=rsmd.getColumnCount(); i++)
//    			tableHeader.addElement(rsmd.getColumnName(i));
    		for(int i=0; i<10; i++)
    			tableHeader.addElement(head[i]);
    		//获得表格
    		while(resultSet.next())
    		{
    			Vector rowdata = new Vector();
    			for(int i=1; i<=rsmd.getColumnCount(); i++)
    				rowdata.addElement(resultSet.getString(i));
    			tabledata.addElement(rowdata);
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	DefaultTableModel tableModel = new DefaultTableModel(tabledata,tableHeader);
    	return tableModel;
	}
    public MainWindow() {
    	super();
    	//设置表格模型
        final DefaultTableModel tableModel = getTableModel();
        final JTable table = new JTable(tableModel) {
            public boolean isCellEditable(int row, int column)
            {
                       return false;//表格不允许被编辑
            }
        };
    	//界面布局--放置表格
    	setTitle("学生信息管理系统");
    	setBounds(100,100,910,675);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	final JScrollPane scrollPane = new JScrollPane();
    	getContentPane().add(scrollPane,BorderLayout.CENTER);
    	scrollPane.setViewportView(table);
    	//界面布局--放置按钮
    	final JPanel panel = new JPanel();
//    	final JButton btn_set = new JButton("设置");
    	final JButton btn_detail = new JButton("详细");
    	final JButton btn_add = new JButton("添加");
    	final JButton btn_edit = new JButton("修改");
    	final JButton btn_search = new JButton("查找");
    	final JButton btn_delete = new JButton("删除");
    	final JButton btn_refresh = new JButton("刷新");
//    	panel.add(btn_set);
    	panel.add(btn_detail);
    	panel.add(btn_add);
    	panel.add(btn_edit);
    	panel.add(btn_search);
    	panel.add(btn_delete);
    	panel.add(btn_refresh);
    	getContentPane().add(panel,BorderLayout.SOUTH);
    	setVisible(true);
    	
    	//实现“刷新”按钮功能
    	btn_refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				table.setModel(getTableModel());
			}
		});
    	//实现“详细”按钮功能
    	btn_detail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedrow = table.getSelectedRow();
				if(selectedrow!=-1)
				{
					String selectedid = table.getValueAt(selectedrow, 0).toString();
					DetailWindow detailWindow = new DetailWindow(selectedid);
				}
				else
				{
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "请选中表格一行", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
    	
    	//实现“修改”按钮功能
    	btn_edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedrow = table.getSelectedRow();
				if(selectedrow!=-1)
				{
					String selectedid = table.getValueAt(selectedrow, 0).toString();
					EditWindow editWindow = new EditWindow(selectedid);
				}
				else
				{
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "请选中表格一行", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
    	
    	//实现“添加”按钮功能
    	btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddWindow addWindow = new AddWindow();
			}
		});
    	
    	//实现“删除”按钮功能
    	btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedrow = table.getSelectedRow();
				if(selectedrow!=-1)
				{
					String selectedid = table.getValueAt(selectedrow, 0).toString();
					String sql = "delete from student where ID = "+selectedid;
					try {
						File file = new File(selectedid+".jpg");
						file.delete();
						statement.executeUpdate(sql);
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
				else
				{
					JOptionPane jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "请选中表格一行", "提示", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
    	
    	//实现“查找”功能
    	btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchWindow searchWindow = new SearchWindow();
			}
		});
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainWindow();
	}

}