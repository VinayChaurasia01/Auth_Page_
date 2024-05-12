package com.DB;
import java.sql.*;

public class DBConnect {

	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			if(con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");  
				con = DriverManager.getConnection("jdbc:mysql:///loginpage" , "root" , "@Vinay#7828");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
