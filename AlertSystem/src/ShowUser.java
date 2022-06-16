

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.UserDao;
import model.User;

@WebServlet("/showuser")
public class ShowUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	      PrintWriter out=response.getWriter();  
	        
	      String spageid=request.getParameter("page");  
	  int pageid=Integer.parseInt(spageid);  
	  int total=15;  
	  if(pageid==1){}  
	  else{  
	      pageid=pageid-1;  
	      pageid=pageid*total+1;  
	      }  
	  List<User> list=UserDao.getUserRecords(pageid,total);  

	  
	  out.print("<table border='1' cellpadding='4' width='60%'>");  
	out.print("<tr><th>User Id</th><th>Name</th><th>Age</th><th>mobile no.</th><th>address</th><th>gender</th><th>blood group</th><th>Symptoms</th><th>Department</th><th>Date Of Appointment</th><th>username</th><th>password</th></tr>");  
	  for(User e2:list){  
	          out.print("<tr><td>"+e2.getU_id()+"</td><td>"+e2.getU_name()+"</td><td>"+e2.getU_age()+"</td><td>"+e2.getU_mob()+"</td><td>"+e2.getU_add()+"</td><td>"+e2.getU_gender()+"</td><td>"+e2.getU_bgroup()+"</td><td>"+e2.getU_sym()+"</td><td>"+e2.getU_dprt()+"</td><td>"+e2.getU_doa()+"</td><td>"+e2.getU_uname()+"</td><td>"+e2.getU_pass()+"</td></tr>");  
	      }  
	   out.print("</table>");  
	        

	        
	  out.close();  

	}
	


}
