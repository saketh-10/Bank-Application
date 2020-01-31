package p1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class GetStatement extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accno=(String)session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		ArrayList al=m.getStatement();
		if(al.isEmpty()==true)
		{
			try 
			{
				response.sendRedirect("getStatementFail.jsp");
			}
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
		else
		{
			
			session.setAttribute("al", al);
			try {
				response.sendRedirect("getStatementSuccess.jsp");
			}
			catch (IOException e) 
			{
				
				e.printStackTrace();
			}
		}
	}
}
