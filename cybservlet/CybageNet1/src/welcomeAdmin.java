

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class welcomeAdmin
 */
@WebServlet("/welcomeAdmin")
public class welcomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcomeAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='silver'>");
		
		String name=(String)request.getSession().getAttribute("name");		
		int count=(int)request.getSession().getAttribute("count");
		System.out.println(count);
        out.println("<font face='impact' size='4px'>"+"Welcome Admin :");
        out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout' style='float :right'>Logout</a>"+"</font>");
		out.println("<font color='green' face='impact' size='4px'>"+name);
		out.println("<br>"+"Total Login Till now :"+count+"<br>");
		
		out.println("</font>"); 
		out.println("</font>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet");
		
		out.println("<hr>"+"<center>");
		
		
		out.println("<hr>");
		out.println("<a href='BookDetails'>Insert Book</a>"+"<br>");
		out.println("<a href='DeleteBook'>Remove Book</a>");
		
		Cookie []c=request.getCookies();
		for (Cookie cookie : c) {
			if(cookie.getName().equals("TotalCount"))
			{
				System.out.println(cookie.getValue());
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
