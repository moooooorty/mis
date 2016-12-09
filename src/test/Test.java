package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class Test {
	public static void main(String[] args) {
		InputStream is = Test.class.getClassLoader().getResourceAsStream("mysql.properties");
		Properties ps = new Properties();
		try {
			ps.load(is);
			String driver = ps.getProperty("driver");
			String url = ps.getProperty("url");
			String user = ps.getProperty("user");
			String pwd = ps.getProperty("pwd");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pwd);
			System.out.println(conn);
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
		
	}
	public void foo(){
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("mysql.properties");
		
	}
}
