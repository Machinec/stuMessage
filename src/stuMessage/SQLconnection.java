package stuMessage;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLconnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/stuMM?characterEncoding=GBK";
    static final String USER = "root";
    static final String PASS = "199809";    
    static Connection connection;
	public Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("数据库驱动加载成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("数据库连接成功");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
