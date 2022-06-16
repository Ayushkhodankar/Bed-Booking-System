

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginDao;


@WebServlet("/managerlogin")
public class ManagerLogin extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	       //   System.out.println("managerlogin");
	    String n=request.getParameter("mname");  
	    String p=request.getParameter("mpass");
	    String q= "select * from reg_manager where username=? and password=?";
	          
	    if(LoginDao.validate(n, p,q)){  
	        RequestDispatcher rd=request.getRequestDispatcher("hsptlmgr.html");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close();
	}

}
