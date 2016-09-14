package registerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DbUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
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
		try {	
			if(!request.getParameter("password").equals(request.getParameter("repassword")))
			{
				PrintWriter pw = response.getWriter();
				pw.println("password and repassword is not matching");
				RequestDispatcher rd = request.getRequestDispatcher("Register.html");
				rd.include(request, response);
			}
			stmt = con.prepareStatement("insert into userinfo (username,password,address,gender,email) Values(?,?,?,?,?)");
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String  gender = request.getParameter("gender");


			stmt.setString(1, user);
			stmt.setString(2,pass);
			stmt.setString(3, address);
			stmt.setString(4, gender);
			stmt.setString(5, email);
			if(stmt.executeUpdate()>0)
			{
				response.sendRedirect("Login.html");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
