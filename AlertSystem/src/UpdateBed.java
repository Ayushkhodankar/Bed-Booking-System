

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BedDao;
import controller.UserDao;
import model.Bed;
import model.User;

/**
 * Servlet implementation class UpdateBed
 */
@WebServlet("/updatebed")
public class UpdateBed extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//RequestDispatcher dispatcher=request.getRequestDispatcher("user.html");


		String bed_no=request.getParameter("bed_no");

		System.out.println("update bed");
		
		
		System.out.println("hi"+bed_no);

		try {
			int z1= BedDao.updateBed(bed_no);
	
			
			if(z1>0)
				{
				
				response.sendRedirect("user.jsp");
			    
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
