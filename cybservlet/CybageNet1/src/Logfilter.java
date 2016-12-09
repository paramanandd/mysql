

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Logfilter
 */
@WebFilter("/Logfilter")
public class Logfilter implements Filter {
	File f=null;
	PrintWriter pw=null;
    static int count=0;
	public void destroy() {
		pw.close();
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  
		
		 String name=(String)((HttpServletRequest)request).getSession().getAttribute("name");
		
		
		pw.write(name+" "+(new Date()));
		count=++count;
		System.out.println(count);
		((HttpServletRequest)request).getSession().setAttribute("count",count);
		pw.flush();
		 
		chain.doFilter(request, response);
	}
public static void  Countdesc()
{
	--count;
}
	
	public void init(FilterConfig fConfig) throws ServletException {
		f=new File("a.txt");
		try {
			pw=new PrintWriter(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

}
