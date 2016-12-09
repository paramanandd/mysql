

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
 * Servlet implementation class Sbook
 */
@WebServlet("/Sbook")
public class Sbook extends HttpServlet {
	
 
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String bookname=request.getParameter("bookname");
	PrintWriter out=response.getWriter();
	 Connection con=null;
	  Statement st=null;
	  ResultSet rs=null;
	  
		out.println("<body bgcolor='silver'>");
		out.println("<font color='blue' face='impact' size='4px'>"+"<a href='Logout'>Logout</a>"+"</font>");
		out.println("<b>"+"<center>"+"<font face='impact' size='10px'>"+"Welcome To CybageNet");
		
		out.println("<hr>"+"</center>"+"</font>");
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
		System.out.println("connection established");
		st=con.createStatement();
		String query = "select * from book where bookname = '"+bookname+"'";
		rs=st.executeQuery(query);
		boolean flag=true;
	
		out.println("<table border='1'>");
		
		while(rs.next())
		{
			
			out.println("<tr>"+"<td>"+"Book id"+"</td>"+"<td>"+"Book Name"+"</td>"+"<td>"+"Book Author"+"</td>"+"<td>"+"Book Price"+"</td>"+"</tr>");
			out.println("<tr>"+"<td>"+rs.getInt(1)+"</td>");
			out.println("<td>"+rs.getString(2)+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td>"+rs.getInt(4)+"</td>"+"</tr>");
			flag=false;
		}
		
		if(flag==true)
		{
		
			out.println("No record Found");
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
