package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckBalance extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accno=(String)session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		boolean status=m.checkBalance();
		if(status==true)
		{
			try
			{
				String balance=m.getBalance();
				session.setAttribute("balance", balance);
				response.sendRedirect("balanceSucces.jsp");
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
				response.sendRedirect("balance.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
