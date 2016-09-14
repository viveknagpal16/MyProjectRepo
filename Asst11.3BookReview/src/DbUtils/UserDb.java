package DbUtils;

import java.sql.*;
public class UserDb {
	
	private static Connection cc;
	
	public static boolean ValidateUser(String name, String Pass) throws ClassNotFoundException, SQLException {
		boolean status=false;  
		cc= MyConnector.conn();
			PreparedStatement p = cc.prepareStatement("select * from usertable where uname=? and upass=?");
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
	
	public static boolean registerUser(String Name,String Pass,String Email,String Security_que,String Security_ans) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		PreparedStatement p = cc.prepareStatement("insert into usertable (uname,upass,uemail,sec_que,sec_ans) values(?,?,?,?,?)");
		p.setString(1, Name);
		p.setString(2, Pass);
		p.setString(3, Email);
		p.setString(4, Security_que);
		p.setString(5, Security_ans);
		int i = p.executeUpdate();
		
		if(i>0){
			return true;
		}else
			return false;
	}
	/* This function will register user
	 * return String on succession
	 * 
	 */
	
	public static ResultSet userdetail(String Name) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("select * from usertable where uname = ?");
	     st.setString(1, Name);
	     ResultSet rs = st.executeQuery();
	     return rs;
		
	}
	/* this function will return ResultSet object 
	 * input Parameter will be username
	 * 
	 */
	public static int  updatedUserVisit(String Name)throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("select * from usertable where uname = ?");
	     st.setString(1, Name);
	     ResultSet rs = st.executeQuery();
	     if(rs.next()){
	    	 int i = rs.getInt(7);
	    	 return i;
	     }
	     return 0;
	}
	public static String insertUserReview(String Review,String Title,String UserName)throws ClassNotFoundException, SQLException {
		 
		cc= MyConnector.conn();
		int Uid = getUserId(UserName);
		int Bid = getBookId(Title);
		PreparedStatement p = cc.prepareStatement("insert into reviewtable (reviews) values(?) where bookid = ? and userid = ?");
		p.setString(1, Review);
		p.setInt(2, Bid);
		p.setInt(3, Uid);
		int i = p.executeUpdate();
		
		if(i>0){
			return "Review Added ";
		}else
			return "Some error Occured";
	       
	}
	
	
	public static int getUserId(String UserName)throws ClassNotFoundException, SQLException  {
		cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("select * from usertable where uname = ?");
	     st.setString(1, UserName);
	     ResultSet rs1 = st.executeQuery();
	     if(rs1.next()){
	    	int i = rs1.getInt(1);
	    	return i;
	     }
	     return 0;
	}
	public static int getBookId(String Title)throws ClassNotFoundException, SQLException  {
		cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("select * from booktable where title = ?");
	     st.setString(1, Title);
	     ResultSet rs1 = st.executeQuery();
	     if(rs1.next()){
	    	int i = rs1.getInt(1);
	    	return i;
	     }
	     return 0;
	     
	}
}
