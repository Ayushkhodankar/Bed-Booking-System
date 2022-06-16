

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddAdmin
 */
@WebServlet("/addmanager")
public class AddManager extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String m_name=request.getParameter("a_name");
		String m_email=request.getParameter("a_email"); 
		String m_mob=request.getParameter("a_mob");
		String m_address=request.getParameter("a_address");
		String m_hosp=request.getParameter("a_hosp"); 
		String m_aname=request.getParameter("aname");
		String m_apass=request.getParameter("apass");
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin.html");
		
		
			Manager m=new Manager(m_name,m_email,m_mob,m_address,m_hosp,m_aname,m_apass);
			try {
				int a= AdminDao.insert(m);
				
				if(a>0)
					{
					
					dispatcher.include(request, response);
				    
					}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
