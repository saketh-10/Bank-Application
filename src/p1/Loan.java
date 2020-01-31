package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loan extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HttpSession session=request.getSession();
		    String accno=(String)session.getAttribute("accno");
		    Model m=new Model();
		    m.setAccno(accno);
		    boolean status=m.applyLoan();
		    if (status==true)
		    {
		    	String name=m.getName();
		    	String email=m.getEmail();
		    	session.setAttribute("name", name);
		    	session.setAttribute("email", email);
		    	response.sendRedirect("loanSuccess.jsp");
		    }
		    else
		    {
		    	response.sendRedirect("loanFail.jsp");
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
