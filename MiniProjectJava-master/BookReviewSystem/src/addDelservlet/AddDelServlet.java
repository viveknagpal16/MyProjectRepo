package addDelservlet;

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


/**
 * Servlet implementation class AddDelServlet
 */
@WebServlet("/AddDelServlet")
public class AddDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement stmt;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDelServlet() {
		super();	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		if(request.getParameter("operation").equals("Add"))
		{	
			try {
				stmt = con.prepareStatement("insert into book (booktitle,author,type) Values(?,?,?)");
				String booktitle = request.getParameter("title");
				String author = request.getParameter("author");
				String type = request.getParameter("type");
			
				stmt.setString(1, booktitle);
				stmt.setString(2,author);
				stmt.setString(3, type);
				if(stmt.executeUpdate()>0)
				{
					response.sendRedirect("AddDelBook.html");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else
		{
			
		}
	}

}
