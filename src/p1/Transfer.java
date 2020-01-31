package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet 
{
  public void service(HttpServletRequest request,HttpServletResponse response)
  {
	  String tamt=request.getParameter("tamt");
	  HttpSession session=request.getSession();
	  String accno=(String) session.getAttribute("accno");
	  Model m=new Model();
	  m.setAccno(accno);
	  boolean status=m.transfer(tamt);
	  if(status==true)
	  {
		  try 
		  {
			response.sendRedirect("transferSuccess.jsp");
		} 
		  catch (IOException e) 
		  {
			
			e.printStackTrace();
		}
	  }
	  else 
	  {
		  try 
		  {
			response.sendRedirect("transferFail.jsp");
		} 
		  catch (IOException e) 
		  {
			
			e.printStackTrace();
		}
	  }
  }
  
}