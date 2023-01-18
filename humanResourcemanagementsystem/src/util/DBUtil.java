package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	
	 private static String path;
	 private static String url;
	 private static String username;
	 private static String password;
	 
	 static{
	    ResourceBundle rb=ResourceBundle.getBundle("dbdata");
	    path=rb.getString("db.pathname");
	    url=rb.getString("db.url");
	    username=rb.getString("db.username");
	    password=rb.getString("db.password");
	 }
	 
	    public static Connection getConnection(){
	    	 Connection conn=null;
	    	 
	    	 try {
				Class.forName(path);
			} catch (ClassNotFoundException e) {
				System.err.println(e.getMessage());
			}
	    	 
	    	 try {
				conn=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
	    	 return conn;
	    }
}
