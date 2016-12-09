

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reviewsuccess
 */
@WebServlet("/Reviewsuccess")
public class Reviewsuccess extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Review=request.getParameter("review");
		String name=(String)request.getSession().getAttribute("bkname");
		int bkid=(int)request.getSession().getAttribute("bkid");           
		PrintWriter out=response.getWriter();
		  out.println("<body bgcolor='silver'>");
		  out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout'>Logout</a>"+"</font>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet"+"</font>");
		
		out.println("<hr>"+"<center>");
		
		Connection con=null;
		  Statement st=null;
		 
		
		System.out.println(name);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
			st=con.createStatement();
			String query = "insert into review(comment,bookid) values('"+Review+"','"+bkid+"')";
			st.executeUpdate(query);
			out.println("<i>"+"<font face='Segoe Print' color='green'size='6px'>");
			out.println("Review Added Successfully");
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
