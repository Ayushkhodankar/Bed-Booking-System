

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginDao;


@WebServlet("/doctorlogin")
public class DoctorLogin extends HttpServlet {
	
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();   
	    String n=request.getParameter("dname");  
	    String p=request.getParameter("dpass");
	    String q= "select * from reg_doctor where username=? and password=?";
	          
	    if(LoginDao.validate(n, p,q)){  
	        RequestDispatcher rd=request.getRequestDispatcher("doctor.html");  
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
