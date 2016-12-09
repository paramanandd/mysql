

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
 * Servlet implementation class Removebook
 */
@WebServlet("/Removebook")
public class Removebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Removebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='silver'>");
		out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout'>Logout</a>"+"</font>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet");
		
		out.println("<hr>"+"<center>"+"</font>");
		
	 Connection con=null;
	  Statement st=null;
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
		System.out.println("connection established");
		st=con.createStatement();
		String[] books=null;
		try {
			books = request.getParameterValues("b1");
		} catch (Exception e) {
			response.sendRedirect("DeleteBook");
			e.printStackTrace();
		}
		try {
			for (String string : books) {
				
			String query = "delete from book where bookname='"+string+"'";
			st.executeUpdate(query);
			
			}
		} catch (Exception e) {
			response.sendRedirect("DeleteBook");
			e.printStackTrace();
		}
		 out.println("<b>"+"<i>"+"<center>"+"<font color='green' face='impact' size='7px'>");
		out.println("Book Deleted Successfully"+"</i>" );
		
		
	}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
