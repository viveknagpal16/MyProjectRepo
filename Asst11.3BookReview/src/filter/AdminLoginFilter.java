package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import DbUtils.AdminDb;
import DbUtils.UserDb;

/**
 * Servlet Filter implementation class AdminSignInFilter
 */
@WebFilter("/AdminSignInFilter")
public class AdminLoginFilter implements Filter {

	 /* Get actual class name to be printed on */
	   static Logger log = Logger.getLogger(AdminLoginFilter.class.getName());
    /**
     * Default constructor. 
     */
    public AdminLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try 
		{
			PrintWriter pw= response.getWriter();
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			if(AdminDb.ValidateAdmin(user, pass)){

				chain.doFilter(request, response);
				 log.info("Login User Name is :"+user);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				pw.println("invalid user name password");
				rd.include(request, response);
			}

		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
