

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
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	
	 
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid=(int)request.getSession().getAttribute("bookid");
		String bookname=(String)request.getSession().getAttribute("bookname");
		String bookauthor=(String)request.getSession().getAttribute("bookauthor");
		int bookprice=(int)request.getSession().getAttribute("bookprice");
		
		
		
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor='silver'>");
		out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout'>Logout</a>"+"</font>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet");
		
		out.println("<hr>"+"<center>");
		
		 Connection con=null;
		  Statement st=null;
		  ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
			System.out.println("connection established");
			st=con.createStatement();
			String query = "select comment from review where bookid = '"+bookid+"'";
			rs=st.executeQuery(query);
	
		
		/*	
			out.println("Book Available");
			out.println("Book id"+bookid);
			out.println("Book Name"+bookname);
			out.println("Book Author"+bookauthor);
			out.println("Book Price"+bookprice);*/
			
			out.println("<table border='1'>");
			out.println("<tr>"+"<td>"+"Book id"+"</td>"+"<td>"+"Book Name"+"</td>"+"<td>"+"Book Author"+"</td>"+"<td>"+"Book Price"+"</td>"+"</tr>");
			out.println("<tr>"+"<td>"+bookid+"</td>");
			out.println("<td>"+bookname+"</td>");
			out.println("<td>"+bookauthor+"</td>");
			out.println("<td>"+bookprice+"</td>"+"</tr>");
			out.println("</table>");
			out.println("Review's"+"<br>"+"</font>");
     		while(rs.next())
			{
				out.println(" "+rs.getString(1)+"<br>");
			
			}
		
			
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
