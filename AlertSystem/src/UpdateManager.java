

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminDao;
import model.Manager;

/**
 * Servlet implementation class UpdateManager
 */
@WebServlet("/updatemanager")
public class UpdateManager extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
RequestDispatcher dispatcher=request.getRequestDispatcher("admin.html");
		
		String m_id=request.getParameter("m_id");
		String m_name=request.getParameter("a_name");
		String m_email=request.getParameter("a_email"); 
		String m_mob=request.getParameter("a_mob");
		String m_add=request.getParameter("a_address");
		String m_hosp=request.getParameter("a_hosp"); 
		String m_uname=request.getParameter("aname");
		String m_pass=request.getParameter("apass");
		
		
		Manager m=new Manager(m_id,m_name, m_email, m_mob, m_add, m_hosp, m_uname, m_pass);
		try {
			int b= AdminDao.update(m);
	
			
			if(b>0)
				{
				
				dispatcher.include(request, response);
			    
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
