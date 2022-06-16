

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserDao;
import model.User;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
		
		String u_id=request.getParameter("u_id");
		String u_name=request.getParameter("h1_name");
		String u_age=request.getParameter("h1_age"); 
		String u_mob=request.getParameter("h1_mob");
		String u_add=request.getParameter("h1_address");
		String u_gender=request.getParameter("gender"); 
		String u_bgroup=request.getParameter("h1bgroup");
		String u_uname=request.getParameter("h1name");
		String u_pass=request.getParameter("h1pass");
		
		
		User u1= new User(u_id,u_name, u_age, u_mob, u_add, u_gender, u_bgroup, u_uname, u_pass);
		try {
			int u2= UserDao.updateUser(u1);
	
			
			if(u2>0)
				{
				
				dispatcher.include(request, response);
			    
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
