

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddUser
 */
@WebServlet("/adduser")
public class AddUser extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String u_name=request.getParameter("h1_name");
		String u_age=request.getParameter("h1_age"); 
		String u_mob=request.getParameter("h1_mob");
		String u_add=request.getParameter("h1_address");
		String u_gender=request.getParameter("gender"); 
		String u_bgroup=request.getParameter("h1bgroup");
		String u_uname=request.getParameter("h1name");
		String u_pass=request.getParameter("h1pass");
		RequestDispatcher dispatcher=request.getRequestDispatcher("hsptlmgr.html");
		
		
			User u=new User( u_name,u_age,u_mob,  u_add, u_gender,u_bgroup,u_uname,u_pass);
			try {
				int y=UserDao.insertUser(u);
				
				if(y>0)
					{
					
					dispatcher.include(request, response);
				    
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
