package DbUtils;

import java.sql.*;

public class UserDb {
	
	static Connection cc;
	
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
	public static int  getUserVisit(String Name)throws ClassNotFoundException, SQLException {
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
	/*	this will fetch the no of visit of user  
	 * 	input parameter name of user
	 * 	output no of visits
	 */
	public static String setUserVisit(String Name)throws ClassNotFoundException, SQLException {
		 cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("update usertable set visit = (visit+1) where uname = ?");
	     st.setString(1, Name);
	     int i = st.executeUpdate();
	     if(i>0){
	    	 
	    	 return "Visit Updated by no of counts: "+i;
	     }
	     return "";
	}
	/*	This function will update the count of visit by one
	 * 	input parameter will be name of user
	 * 	output no of visit updated
	 */
	public static boolean insertUserReview(String Review,String Title,String UserName)throws ClassNotFoundException, SQLException {
		 cc= MyConnector.conn();
		int Uid = getUserId(UserName);
		int Bid = getBookId(Title);
		PreparedStatement p = cc.prepareStatement("insert into reviewtable (reviews) values(?) where bookid = ? and userid = ?");
		p.setString(1, Review);
		p.setInt(2, Bid);
		p.setInt(3, Uid);
		int i = p.executeUpdate();
		
		if(i>0){
			return true;
		}else
			return false;
	    
	}
	/*	this function will take review book title and user name as input parameter
	 *  and will add the review in database
	 */
	
	public static ResultSet  getBookReviewByUserName(String UserName)throws ClassNotFoundException, SQLException {
		 cc= MyConnector.conn();
		int id = getUserId(UserName);
		 PreparedStatement st = cc.prepareStatement("select * from reviewtable where userid = ?");
	     st.setInt(1, id);
	     ResultSet rs = st.executeQuery();
	     return rs;
	}
	/* This function will take username as a parameter and
	 * will return array of reviews in resultset
	 */
	
	public static ResultSet getBookReviewByBookTitle(String BookTitle)throws ClassNotFoundException, SQLException {
		 cc= MyConnector.conn();
		int id = getBookId(BookTitle);
		 PreparedStatement st = cc.prepareStatement("select * from reviewtable where bookid = ?");
	     st.setInt(1, id);
	     ResultSet rs = st.executeQuery();
	     return rs;
	}
	/* This function will take booktitle as a parameter and
	 * will return array of reviews in resultset
	 */
	
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
	/*	This function will return the id of the user
	 *  and take the name of user as input parameter
	 */
	public  static int getBookId(String Title)throws ClassNotFoundException, SQLException  {
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
	/*	This function will return the id of the book
	 *  and take the title of book as input parameter
	 */
}
