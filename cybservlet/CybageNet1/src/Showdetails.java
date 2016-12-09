

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
 * Servlet implementation class Showdetails
 */
@WebServlet("/Showdetails")
public class Showdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='silver'>");
		out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout'>Logout</a>"+"</font>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet"+"</font>");
		out.println("<hr>"+"<center>");		
		out.println("<form action='Showall'>");
		out.println("<font face='Segoe Print' size='8'>"+"<center>"+"Search Book"+"<br>"+"</font>");
		out.println("Enter book name :<input type='text' name='bookname'>");
		out.println("<input type='submit' value='Search Book'>");
		
		
		  Connection con=null;
		  Statement st=null;
		  ResultSet rs=null;
		  
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
				System.out.println("connection established");
				st=con.createStatement();
				String query = "select * from book ";
				rs=st.executeQuery(query);
				out.println("<br>"+"<br>"+"List of All Books");
				out.println("<select name='s1'>");
				
				while(rs.next())
				{
				out.println("<option>"+rs.getString(2)+"</option>");
				}
				out.println("</select>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
				
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
