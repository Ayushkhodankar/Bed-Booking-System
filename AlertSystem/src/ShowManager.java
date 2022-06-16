

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminDao;
import model.Manager;

/**
 * Servlet implementation class ShowManager
 */
@WebServlet("/showmanager")
public class ShowManager extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
			        PrintWriter out=response.getWriter();  
			          
			        String spageid=request.getParameter("page");  
		        int pageid=Integer.parseInt(spageid);  
		        int total=5;  
		        if(pageid==1){}  
		        else{  
		            pageid=pageid-1;  
		            pageid=pageid*total+1;  
			        }  
		        List<Manager> list=AdminDao.getRecords(pageid,total);  
		  
		        
		        out.print("<table border='1' cellpadding='4' width='60%'>");  
	        out.print("<tr><th>Id</th><th>Name</th><th>E-mail</th><th>Mobile No.</th><th>Hospital Name</th><th>Address</th><th>Username</th><th>Password</th></tr>");  
		        for(Manager e:list){  
			            out.print("<tr><td>"+e.getM_id()+"</td><td>"+e.getM_name()+"</td><td>"+e.getM_email()+"</td><td>"+e.getM_mob()+"</td><td>"+e.getM_hosp()+"</td><td>"+e.getM_add()+"</td><td>"+e.getM_uname()+"</td><td>"+e.getM_pass()+"</td></tr>");  
			        }  
		         out.print("</table>");  
			          
		     
			          
		        out.close();  
		    }  

}
