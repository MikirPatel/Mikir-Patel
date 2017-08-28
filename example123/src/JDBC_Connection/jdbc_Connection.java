package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbc_Connection {
	
		public Statement Connection_JDBC () throws SQLException, ClassNotFoundException{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mikir","root","admin123");
			
			Statement statement = con.createStatement();
			
			return statement;
		}
		

}
