package DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDb {

	static Connection cc;
	
	public static boolean addBookDetail(String Title,String AuthorName,String Publications,String Edition,String Genre,int No_of_Pages,int Price) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		PreparedStatement p = cc.prepareStatement("insert into booktable (title,author,no_of_pages,price,publication_house,edition,genre) values(?,?,?,?,?,?,?)");
		p.setString(1, Title);
		p.setString(2, AuthorName);
		p.setInt(3, No_of_Pages);
		p.setInt(4, Price);
		p.setString(5, Publications);
		p.setString(6, Edition);
		p.setString(7, Genre);
		int i = p.executeUpdate();
		p.close();
		if(i>0){
			return true;
		}else
			return false;
	
	}
	/* This function will add book detail
	 * return String on succession
	 * 
	 */
	public static boolean removeBook(String title,String Edition) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();;
		PreparedStatement p = cc.prepareStatement("delete from booktable where title = ? and edition = ?");
		p.setString(1, title);
		p.setString(2, Edition);
		int i = p.executeUpdate();
		p.close();
		if(i>0){
			return true;
		}else
			return false;
	}
	/* This function will return a string 
	 * when Data removed
	 * input parameter are title and edition
	 */
	public static boolean updateBookEdition(String title,String NewEdition) throws SQLException, ClassNotFoundException {
		
		cc= MyConnector.conn();
		PreparedStatement p = cc.prepareStatement("UPDATE booktable SET edition = ? WHERE title = ?");
		p.setString(1, NewEdition);
		p.setString(2, title);
		int i = p.executeUpdate();
		p.close();
		if(i>0){
			return true;
		}else
			return false;
	}
	/* This function will update the edition of the book
	 * Will take title as input and new edition as input parameter
	 * and return A string as output
	 */
	public static boolean updateBookPrice(String title,int NewPrice) throws SQLException, ClassNotFoundException {
		
		cc= MyConnector.conn();
		PreparedStatement p = cc.prepareStatement("UPDATE booktable SET price = ? WHERE title = ?");
		p.setInt(1, NewPrice);
		p.setString(2, title);
		int i = p.executeUpdate();
		p.close();
		if(i>0){
			return true;
		}else
			return false;
	}
	/* This function will update the Priice of the book
	 * Will take title as input and new price  as input parameter
	 * and return A string as output
	 */
	public static ResultSet searchbyTitle(String Title) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("select * from booktable where title=?");
         st.setString(1, Title);
         ResultSet rs = st.executeQuery();
         return rs;
	}
	/* This function will search about the book
	 * Will take title as input  parameter
	 * and return an array of resultset 
	 */
	public static ResultSet searchbyAuthor(String Author) throws ClassNotFoundException, SQLException {
		cc= MyConnector.conn();
		 PreparedStatement st = cc.prepareStatement("select * from booktable where author=?");
        st.setString(1, Author);
        ResultSet rs = st.executeQuery();
        return rs;
	}
	/* This function will search about the book
	 * Will take author as input  parameter
	 * and return an array of resultset 
	 */
}
