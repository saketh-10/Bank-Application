package p1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ChangePasswordFilter
 */
public class ChangePasswordFilter1 implements Filter {

    /**
     * Default constructor. 
     */
    public ChangePasswordFilter1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String npwd=request.getParameter("npwd");
		String cpwd=request.getParameter("cpwd");
		if (npwd.equals(cpwd)==true)
		{
			chain.doFilter(request, response);
		}
		else
		{
		  ((HttpServletResponse)response).sendRedirect("npwd");	
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
