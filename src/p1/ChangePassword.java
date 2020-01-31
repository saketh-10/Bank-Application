package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangePassword extends HttpServlet 
{
  public void service(HttpServletRequest request,HttpServletResponse response)
  {
	  String npwd=request.getParameter("npwd");
	  HttpSession session=request.getSession();
	  String accno=(String)session.getAttribute("accno");
	  Model m=new Model();
	  m.setAccno(accno);
	  m.setPwd(npwd);
	  boolean status=m.changePassword();
	  if(status==true)
	  {
		  try 
		  {
			response.sendRedirect("cpSuccess.jsp");
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
			response.sendRedirect("cpFail.jsp");
		} 
		  catch (IOException e) 
		  {
			
			e.printStackTrace();
		}
	  }
  }
}
