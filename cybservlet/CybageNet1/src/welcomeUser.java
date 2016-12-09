

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class welcomeUser
 */
@WebServlet("/welcomeUser")
public class welcomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
			out.println("<body bgcolor='silver'>");
			
			 String name=(String)request.getSession().getAttribute("name");
		    out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout' style='float :right'>Logout</a>"+"</font>");	
			out.println("<font face='impact' size='4px'>"+"Welcome User :");
			out.println("<font color='green' face='impact' size='4px'>"+name+"<br>");
			
			out.println("</font>"); 
			out.println("</font>");
			out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet");
			out.println("<hr>"+"<center>");
			
			out.println("<a href='Searchbook'>Search Book</a>"+"<br>");
			out.println("<a href='Showdetails'>Show Review</a>"+"<br>");
			out.println("<a href='Addreview'>Add Review</a>");
			
			
			
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
