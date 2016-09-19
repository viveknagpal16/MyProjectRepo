package DbUtils;

import java.sql.*;

public class MyConnector {

	public static Connection conn() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
		
	}
}
