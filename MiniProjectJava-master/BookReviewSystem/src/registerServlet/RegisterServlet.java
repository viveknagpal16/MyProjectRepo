package registerServlet;

import java.io.IOException;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.UserDb;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement stmt;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
	
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
			
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String securityQue = request.getParameter("SecurityQues");
			String securityAns =request.getParameter("securityAns");


			try {
				
				if(UserDb.registerUser(user, pass, email, securityQue, securityAns))
				{
					response.sendRedirect("index.html");
				}
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
	}

}
