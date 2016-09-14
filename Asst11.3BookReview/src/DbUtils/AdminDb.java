package DbUtils;

import java.sql.*;
public class AdminDb {

	private static Connection cc;
	
	public static boolean ValidateAdmin(String name, String Pass) throws ClassNotFoundException, SQLException {
		boolean status=false;  
			cc= MyConnector.conn();
			PreparedStatement p = cc.prepareStatement("select * from admintable where aname=? and apass=?");
			p.setString(1,name);  
			p.setString(2,Pass);
			ResultSet rs=p.executeQuery();  
			status=rs.next();  
		return status;
	}
	/* This function validate the username and 
	 *  password from the database
	 *  return true when username and password exists
	 *  else return false
	 */
	
	public static String registerAdmin(String Name,String Pass,String Email) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		PreparedStatement p = cc.prepareStatement("insert into admintable (aname,apass,aemail) values(?,?,?)");
		p.setString(1, Name);
		p.setString(2, Pass);
		p.setString(3, Email);
		int i = p.executeUpdate();
		
		if(i>0){
			return "Registration Done";
		}else
			return "Some error Occured";
	}
	/* This function will register user
	 * return String on succession
	 * 
	 */
}
