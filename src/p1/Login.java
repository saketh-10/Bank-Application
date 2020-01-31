package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
	  	String custid=request.getParameter("custid");
	  	String pwd=request.getParameter("pwd");
	  	Model m=new Model();
	  	m.setCustid(custid);
	  	m.setPwd(pwd);
	  	boolean status=m.login();
	  	if(status==true)
	  	{
	  		try
	  		{
	  			String accno=m.getAccno();
	  			HttpSession session=request.getSession(true);
	  			session.setAttribute("accno", accno);
	  			response.sendRedirect("home.jsp");
	  		}
	  		catch(Exception e)
	  		{
	  			e.printStackTrace();
	  		}
	  		
	  	}
	  	else
	  	{
	  		try 
	  		{
				response.sendRedirect("loginFail.html");
			} 
	  		catch (IOException e) 
	  		{
				e.printStackTrace();
			}
	  	}
	}
}
