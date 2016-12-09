

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/InsertBook")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  Connection con=null;
	  Statement st=null;
	  ResultSet rs=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName=request.getParameter("t1");
		String bookAuthor=request.getParameter("t2");
		int bookPrice=Integer.parseInt(request.getParameter("t3"));
		
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='silver'>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet");
		out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout'>Logout</a>"+"</font>");
		out.println("<hr>"+"<center>"+"</font>");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
			System.out.println("connection established");
			st=con.createStatement();
			String query = "insert into book(bookname,author,price) values('"+bookName+"','"+bookAuthor+"','"+bookPrice+"')";
		    st.executeUpdate(query);
		    out.println("<b>"+"<i>"+"<center>"+"<font color='green' face='impact' size='7px'>");
			out.println("Book Details Inserted"+"</i>" );
		
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
