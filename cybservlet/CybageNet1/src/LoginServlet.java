

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	static Cookie c=null;
	 
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	  Connection con=null;
	  Statement st=null;
	  ResultSet rs=null;
	
	  String name1=request.getParameter("name");
	  String pass1=request.getParameter("pass");
	 
		
	

	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/bookreview","root","root");
		
		st=con.createStatement();
		String query = "select * from user where name = '"+name1+"'";
		rs=st.executeQuery(query);
		boolean flag=true;
		while(rs.next())
		{
			if(pass1.equals(" ")||name1.equals(" "))
			{
				response.sendRedirect("Login.html");
			}
			 if(rs.getString(3).equals(pass1)&&rs.getString(4).equals("admin"))
			 {
			 request.getSession().setAttribute("name",name1);
			 response.sendRedirect("welcomeAdmin");
			 }
			
           if(rs.getString(3).equals(pass1)&&rs.getString(4).equals("user"))
			  {
			  request.getSession().setAttribute("name",name1);
			  c=new Cookie("TotalCount",name1);
			  response.addCookie(c);
			  response.sendRedirect("welcomeUser");
			  }
			
			 flag=false;
		}
	if(flag==true)
	{
		response.sendRedirect("Login.html");
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
